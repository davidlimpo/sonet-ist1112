package sonet.menu.publicacao;

import java.util.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.publication.MenuEntry;
import sonet.textui.publication.Message;

import sonet.core.Publicacao;
import sonet.core.Agente;

import sonet.textui.publication.UnknownKeyException;
import sonet.textui.publication.CommentDeniedException;

/**
 * Classe que permite comentar uma publicacao
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ComentarPublicacao extends Command<Agente>{

	private Agente _login;

	/**
	 * Construtor.
	 * 
	 * @param login
	 *            Agente que fez o login.
	 *
	 * @param visitado
	 *            Agente que sera visitado.
	 */
	public ComentarPublicacao(Agente login, Agente visitado){
		super(MenuEntry.COMMENT_PUBLICATION, visitado);
		_login = login;
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Form f = new Form();
		InputString idPublicacao = new InputString(f, Message.reqKey());
		f.parse();

			for (Publicacao p: entity().getPublicacoes())

				if ((Integer.parseInt(idPublicacao.value())) == p.getId()){

					Form g = new Form();
					InputString comentario = new InputString(g, Message.reqComment());
					g.parse();

					if(p.isProtected(_login))
						throw new CommentDeniedException("" + _login.getId(), ""+ p.getId());

					p.addComentario(comentario.value());

					return;
				}

			//Se chegar aqui é porque nao encontrou a publicação
			throw new UnknownKeyException("" + (Integer.parseInt(idPublicacao.value())) );
	}
}

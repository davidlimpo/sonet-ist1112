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
import sonet.textui.publication.RatingDeniedException;

/**
 * Classe que permite pontuar uma publicacao
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class PontuarPublicacao extends Command<Agente>{

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
	public PontuarPublicacao(Agente login, Agente visitado){
		super(MenuEntry.RATE_PUBLICATION, visitado);
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

				Form pontua = new Form();
				InputString pontos = new InputString(pontua, Message.reqRating());
						     pontua.parse();

				if(p.isProtected(_login))
					throw new RatingDeniedException("" + _login.getId(), ""+ p.getId());

				p.pontua(Integer.parseInt(pontos.value()));

				return;
			}

		throw new UnknownKeyException("" + (Integer.parseInt(idPublicacao.value())) );
	}
}

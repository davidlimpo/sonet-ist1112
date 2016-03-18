package sonet.menu.publicacao;

import java.util.*;
import java.lang.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.publication.MenuEntry;
import sonet.textui.publication.Message;
import sonet.textui.publication.UnknownKeyException;

import sonet.core.Publicacao;
import sonet.core.Agente;
import sonet.core.RedeSocial;

/**
 * Classe que permite proteger uma publicacao
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ProtegerPublicacao extends Command<Collection<Publicacao>>{

	/**
	 * Construtor.
	 * 
	 * @param p
	 *            Colecçao a que se refere o command.
	 */
	public ProtegerPublicacao(Collection<Publicacao> p){
		super(MenuEntry.PROTECT_PUBLICATION, p);
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

		for (Publicacao p: entity())
			if ((Integer.parseInt(idPublicacao.value())) == p.getId()){
				Form g = new Form();
				InputString idAgente = new InputString(g, sonet.textui.agents.Message.reqKeys());
				g.parse();

				String[] split = (idAgente + "").split(",");

				//Verifica se as publicacoes com os identificadores introduzidos existem 
				for(int j = 0; j < split.length; j++)

					if(!p.getRedeSocial().getAgentes().contains(
					p.getRedeSocial().getAgente(Integer.parseInt(split[j]))))

						throw new sonet.textui.agents.UnknownKeyException("" + 
						(Integer.parseInt(split[j])));


				//Adiciona os protegidos introduzidos na lista
				for(int i = 0; i < split.length; i++)
					p.addProtegido(Integer.parseInt(split[i]));

				return;
			}

		//Se chegar aqui é porque nao encontrou a publicação
		throw new UnknownKeyException("" + (Integer.parseInt(idPublicacao.value())) );
	}
}

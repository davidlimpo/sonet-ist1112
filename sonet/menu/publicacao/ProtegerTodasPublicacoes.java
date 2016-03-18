package sonet.menu.publicacao;

import java.util.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.publication.MenuEntry;
import sonet.textui.publication.Message;
import sonet.textui.agents.UnknownKeyException;

import sonet.core.Publicacao;

/**
 * Classe que permite proteger todas as publicacoes
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ProtegerTodasPublicacoes extends Command<Collection<Publicacao>>{

	/**
	 * Construtor.
	 * 
	 * @param p
	 *            Colecçao de publicacao a que se refere o command.
	 */
	public ProtegerTodasPublicacoes(Collection<Publicacao> p){
		super(MenuEntry.PROTECT_PUBLICATIONS, p);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Form f = new Form();
		InputString idAgente = new InputString(f, sonet.textui.agents.Message.reqKeys());
		f.parse();
		String[] split = (idAgente + "").split(",");


		for (Publicacao p: entity()){

			//Verifica se as publicacoes com os identificadores introduzidos existem 
			for(int j = 0; j < split.length; j++)
				if(!p.getRedeSocial().getAgentes().contains(
					p.getRedeSocial().getAgente(Integer.parseInt(split[j]))))

						throw new sonet.textui.agents.UnknownKeyException("" + 
						(Integer.parseInt(split[j])));


			//Adiciona os protegidos introduzidos na lista
			for(int i = 0; i < split.length; i++)
				p.addProtegido(Integer.parseInt(split[i]));
		}
	}
}

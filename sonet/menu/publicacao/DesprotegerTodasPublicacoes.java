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
 * Classe que permite desproteger todas as publicacoes
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class DesprotegerTodasPublicacoes extends Command<Collection<Publicacao>>{

	/**
	 * Construtor.
	 * 
	 * @param p
	 *            Colecçao a que se refere o command.
	 */
	public DesprotegerTodasPublicacoes(Collection<Publicacao> p){
		super(MenuEntry.UNPROTECT_PUBLICATIONS, p);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		int i;

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

			//Remove os protegidos introduzinos da lista
			for(String idDesp: split){

				i = 0;

				for(Integer idProt: (p.getProtegidos())){
					if((Integer.parseInt(idDesp)) == (idProt.intValue())){

						p.removeProtegido(i);

						break;
					}
					i++;
				}
			}
		}
	}
}

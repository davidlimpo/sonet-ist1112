package sonet.menu.agente;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.agent.MenuEntry;
import sonet.textui.agent.Message;
import sonet.textui.agents.UnknownKeyException;

import sonet.core.Agente;
import sonet.core.RedeSocial;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Classe que desprotege o perfil de um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class DesprotegerPerfil extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            o agente alvo.
	 */
	public DesprotegerPerfil(Agente a){
		super(MenuEntry.UNPROTECT_PROFILE, a);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		int i;

		Form f = new Form();
		InputString idsInput = new InputString(f, sonet.textui.agents.Message.reqKeys());
		f.parse();

		String[] split = (idsInput + "").split(",");


		//Verifica se os agentes com os identificadores introduzidos existem 
		for(int j = 0; j < split.length; j++)

			if(!entity().getRedeSocial().getAgentes().contains(
			entity().getRedeSocial().getAgente(Integer.parseInt(split[j]))))

				throw new UnknownKeyException("" + (Integer.parseInt(split[j])));

		//Remove os protegidos introduzinos da lista
		for(String idDesp: split){
			i = 0;

			for(Integer idProt: (entity().getProtegidos())){

				if((Integer.parseInt(idDesp)) == (idProt.intValue())){

					entity().removeProtegido(i);
					break;
				}
				i++;
			}
		}
	}
}

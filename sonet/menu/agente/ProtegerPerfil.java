package sonet.menu.agente;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.agent.MenuEntry;
import sonet.textui.agent.Message;

import sonet.textui.agents.UnknownKeyException;

import sonet.core.Agente;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Classe que protege o perfil de um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ProtegerPerfil extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            o agente alvo.
	 */
	public ProtegerPerfil(Agente a){
		super(MenuEntry.PROTECT_PROFILE, a);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Form f = new Form();
		InputString idsInput = new InputString(f, sonet.textui.agents.Message.reqKeys());
		f.parse();

		String[] split = (idsInput + "").split(",");

		//Verifica se os agentes com os identificadores introduzidos existem 
		for(int j = 0; j < split.length; j++)

			if(!entity().getRedeSocial().getAgentes().contains(
			entity().getRedeSocial().getAgente(Integer.parseInt(split[j]))))

				throw new UnknownKeyException("" + (Integer.parseInt(split[j])));

		//Adiciona os protegidos introduzidos na lista
		for(int i = 0; i < split.length; i++)
			entity().addProtegido(Integer.parseInt(split[i]));

	}
}

package sonet.menu.agentes;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.lang.String;

import sonet.textui.agents.MenuEntry;
import sonet.textui.agents.Message;
import sonet.core.*;

/**
 * Classe que reactiva um agente.
 * INCOMPLETA!
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ReactivarAgente extends Command<RedeSocial>{

	/**
	 * Construtor.
	 * 
	 * @param r
	 *            a RedeSocial alvo.
	 */
	public ReactivarAgente(RedeSocial r){
		super(MenuEntry.REACTIVATE_AGENT, r);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		Form f = new Form();
		InputString inputId  = new InputString(f, Message.reqKey());
		f.parse();

		for (Agente a: entity().getAgentes()){

			if ((Integer.parseInt(inputId.value())) == a.getId()){
				a.activar();

			}
		}
	}
}

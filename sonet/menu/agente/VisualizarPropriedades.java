package sonet.menu.agente;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;	
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.agent.MenuEntry;
import sonet.textui.agent.Message;

import sonet.core.Agente;

/**
 * Classe que permite visualizar as propriedades de um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class VisualizarPropriedades extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            o agente alvo.
	 */
	public VisualizarPropriedades(Agente a){
		super(MenuEntry.SHOW_PROPERTIES, a);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Display d = new Display(title());
		d.addNewLine(entity().toString());
		d.display();
	}
}

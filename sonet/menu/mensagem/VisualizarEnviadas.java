package sonet.menu.mensagem;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.message.MenuEntry;
import sonet.textui.message.Message;

import sonet.core.Agente;
import sonet.core.Mensagem;

/**
 * Classe que permite visualizar as mensagens enviadas de um Agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class VisualizarEnviadas extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            agente a que se refere o command.
	 */
	public VisualizarEnviadas(Agente a){
		super(MenuEntry.LIST_OUTBOX, a);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Display d = new Display(title());

		for (Mensagem m: entity().getMensagensEnviadas())
			d.addNewLine(m.toString());

		d.display();
	}
}

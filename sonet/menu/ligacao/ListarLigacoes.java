package sonet.menu.ligacao;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.connection.MenuEntry;
import sonet.textui.connection.Message;

import sonet.core.Agente;
import sonet.core.Ligacao;

/**
 * Classe que permite listar todas as ligacoes de um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ListarLigacoes extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param visitado
	 *            Agente de visitado.
	 */
	public ListarLigacoes(Agente visitado){
		super(MenuEntry.SHOW_CONNECTIONS, visitado);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Display d = new Display(title());
		for (Ligacao l: entity().getLigacoes())
			d.addNewLine(l.toString());
		d.display();
	}
}

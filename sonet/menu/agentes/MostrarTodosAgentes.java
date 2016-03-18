package sonet.menu.agentes;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.agents.MenuEntry;

import sonet.core.*;

/**
 * Classe que mostra todos os agentes de uma RedeSocial.
 *
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class MostrarTodosAgentes extends Command<RedeSocial>{

	/**
	 * Construtor.
	 * 
	 * @param r
	 *            a RedeSocial alvo.
	 */
	public MostrarTodosAgentes(RedeSocial redesocial){
		super(MenuEntry.SHOW_ALL_AGENTS, redesocial);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {
		Display d = new Display(title());
		for (Agente a: entity().getAgentes())
			d.addNewLine(a.toString());
		d.display();

	 }

}

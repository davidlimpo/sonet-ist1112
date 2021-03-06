package sonet.menu.manager;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.manager.MenuEntry;
import sonet.textui.manager.Message;

import sonet.core.RedeSocial;
import sonet.menu.RedeSocialMenuAgentes;

/**
 * Classe que acede ao menu dos agentes.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class AgentesMenu extends Command<RedeSocial> {

	/** Construtor
	 *
	 *  @param redesocial
	 *	redesocial a que se refere o comando.
	 */
	public AgentesMenu(RedeSocial redesocial){
		super(MenuEntry.MENU_AGENTS, redesocial);
	}

	/**
	 * Executa o comando e acede ao menu dos agentes de uma redesocial.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		/* Iniciar a interface de utilizador */
		Menu m = new RedeSocialMenuAgentes(entity());
		m.open();
	}
}

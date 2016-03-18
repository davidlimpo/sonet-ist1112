package sonet.menu.manager;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.manager.MenuEntry;
import sonet.textui.manager.Message;

import sonet.core.RedeSocial;
import sonet.menu.RedeSocialMenuProcura;

/**
 * Classe que acede ao menu da procura.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ProcuraMenu extends Command<RedeSocial>{

	/** Construtor
	 *
	 *  @param redesocial
	 *	redesocial a que se refere o comando.
	 */
	public ProcuraMenu(RedeSocial redesocial){
		super(MenuEntry.MENU_SEARCH, redesocial);
	}

	/**
	 * Executa o comando e acede ao menu da procura de uma redesocial.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		/* Iniciar a interface de utilizador */
		Menu m = new RedeSocialMenuProcura(entity());
		m.open();
	}
}

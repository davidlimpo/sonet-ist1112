package sonet.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import sonet.textui.manager.MenuEntry;
import sonet.textui.manager.Message;
import sonet.menu.manager.*;

import sonet.core.RedeSocial;
import sonet.core.Agente;

/**
 * Esta classe trata do Menu principal da RedeSocial.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class MenuRedeSocial extends Menu {

	/**
	* Construtor
	*
	* @param r
	*		RedeSocial a que pertence
	*/
	public MenuRedeSocial(RedeSocial r){
		super(MenuEntry.TITLE, new Command<?>[] {
			new NovaRedeSocial(r),
			new AbrirRedeSocial(r),
			new GuardarRedeSocial(r),
			new GuardarComoRedeSocial(r),
			new AgentesMenu(r),
			new ProcuraMenu(r)

		});
	}
}

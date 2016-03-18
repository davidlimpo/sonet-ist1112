package sonet.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import sonet.textui.browser.MenuEntry;
import sonet.textui.browser.Message;
import sonet.menu.browser.*;

import sonet.core.RedeSocial;
import sonet.core.Agente;

/**
 * Este classe trata do Menu do Browser da RedeSocial.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RedeSocialMenuBrowser extends Menu{

	/**
	* Construtor
	*
	* @param r
	*		RedeSocial a que pertence
	*/
	public RedeSocialMenuBrowser(RedeSocial r){
		super(MenuEntry.TITLE, new Command<?>[] {
			new VisitarAgente(r)
		});
	}
}

package sonet.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import sonet.textui.search.MenuEntry;
import sonet.textui.search.Message;
import sonet.menu.procura.*;

import sonet.core.RedeSocial;

/**
 * Esta classe trata do Menu da Procura.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RedeSocialMenuProcura extends Menu{

	/**
	* Construtor
	*
	* @param r
	*		RedeSocial a que pertence
	*/
	public RedeSocialMenuProcura(RedeSocial r){
		super(MenuEntry.TITLE, new Command<?>[] {
			new ListarMensagens(r),
			new ListarAgentesSemMensagens(r)
		});
	}

}

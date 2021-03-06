package sonet.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import sonet.textui.agents.MenuEntry;
import sonet.textui.agents.Message;
import sonet.menu.agentes.*;

import sonet.core.RedeSocial;

/**
 * Esta classe trata do Menu de Agentes da RedeSocial.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RedeSocialMenuAgentes extends Menu{

	/**
	* Construtor
	*
	* @param r
	*		RedeSocial a que pertence
	*/
	public RedeSocialMenuAgentes(RedeSocial r){
		super(MenuEntry.TITLE, new Command<?>[] {
			new MostrarTodosAgentes(r),
			new RegistarAgente(r),
			new DesactivarAgente(r),
			new ReactivarAgente(r)
		});
	}

}

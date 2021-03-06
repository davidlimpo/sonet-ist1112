package sonet.menu.agente;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.agent.MenuEntry;
import sonet.textui.agent.Message;
import sonet.menu.RedeSocialMenuAgente;
import sonet.menu.RedeSocialMenuMensagem;

import sonet.core.Agente;

/**
 * Classe que acede ao menu das mensagens de um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class MensagensMenu extends Command<Agente> {

	/** Construtor
	 *
	 *  @param agente
	 *	agente a que se refere o comando.
	 */
	public MensagensMenu(Agente agente){
		super(MenuEntry.OPEN_MENU_MESSAGES, agente);
	}

	/**
	 * Executa o comando e acede ao menu das mensagens de um agente.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		/* Iniciar a interface de utilizador */
		Menu m = new RedeSocialMenuMensagem(entity());
		m.open();
	}
}

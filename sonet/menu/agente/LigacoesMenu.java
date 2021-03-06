package sonet.menu.agente;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.agent.MenuEntry;
import sonet.textui.agent.Message;
import sonet.menu.RedeSocialMenuAgente;
import sonet.menu.RedeSocialMenuLigacao;

import sonet.core.Agente;

/**
 * Classe que acede ao menu de ligacoes de um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class LigacoesMenu extends Command<Agente> {

	/** Agente que faz o login */
	Agente _login;

	/** Construtor
	 *
	 *  @param login
	 *	agente que fez o login.
	 *
	 *  @param visitado
	 *	agente a que sera visitado.
	 */
	public LigacoesMenu(Agente login, Agente visitado){
		super(MenuEntry.OPEN_MENU_CONNECTIONS, visitado);
		_login = login;
	}

	/**
	 * Executa o comando e acede ao menu das ligacoes de um agente.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		/* Iniciar a interface de utilizador */
		Menu m = new RedeSocialMenuLigacao(_login, entity());
		m.open();
	}
}

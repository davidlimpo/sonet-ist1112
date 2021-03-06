package sonet.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import sonet.textui.agent.Message;
import sonet.textui.agents.MenuEntry;
import sonet.menu.agente.*;

import sonet.core.Agente;

/**
 * Esta classe trata do Menu do Agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RedeSocialMenuAgente extends Menu{

	/**
	* Construtor
	*
	* @param login
	*		Agente que fez login
	*
	* @param visitado
	*		Agente a ser visitado
	*/
	public RedeSocialMenuAgente(Agente login, Agente visitado){
	
		super(Message.menuTitle(Integer.toString(visitado.getId())), new Command<?>[] {
			new VisualizarPropriedades(visitado),
			new EditarPerfil(visitado),
			new ProtegerPerfil(visitado),
			new DesprotegerPerfil(visitado),
			new PublicacoesMenu(login),
			new MensagensMenu(visitado),
			new LigacoesMenu(login, visitado)
		});

		/* Esconde as opçoes */
		if((login.getId() != visitado.getId()) && (login.getId() != 0)){
			entry(1).invisible();
			entry(2).invisible();
			entry(3).invisible();
			entry(5).invisible();
		}
	}
}

package sonet.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import sonet.textui.connection.MenuEntry;
import sonet.textui.connection.Message;
import sonet.menu.ligacao.*;

import sonet.core.Agente;

/**
 * Esta classe trata do Menu das Ligacoes.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RedeSocialMenuLigacao extends Menu{

	/**
	* Construtor
	*
	* @param a
	*		Agente do login
	* @param b
	*		Agente visitado
	*/
	public RedeSocialMenuLigacao(Agente login, Agente visitado){
		super(MenuEntry.TITLE, new Command<?>[] {
			new ListarLigacoes(visitado),
			new PedidoLigacao(visitado),
			new AceitarLigacao(visitado),
			new RecusarLigacao(visitado),
			new RemoverLigacao(visitado)
		});

		/* Esconde as opçoes */
		if((login.getId() != visitado.getId()) && (login.getId() != 0)){
			entry(1).invisible();
			entry(2).invisible();
			entry(3).invisible();
			entry(4).invisible();
		}
	}

}

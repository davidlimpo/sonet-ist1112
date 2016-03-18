package sonet.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import sonet.textui.message.MenuEntry;
import sonet.textui.message.Message;
import sonet.menu.mensagem.*;

import sonet.core.Agente;

/**
 * Esta classe trata do Menu das Mensagens.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RedeSocialMenuMensagem extends Menu{

	/**
	* Construtor
	*
	* @param a
	*		Agente a que pertence
	*/
	public RedeSocialMenuMensagem(Agente a){
		super(MenuEntry.TITLE, new Command<?>[] {
			new VisualizarRecebidas(a),
			new VisualizarEnviadas(a),
			new VisualizarMensagem(a),
			new EnviarMensagem(a),
			new ResponderMensagem(a),
			new ReenviarMensagem(a),
			new RemoverMensagem(a)
		});

	}

}

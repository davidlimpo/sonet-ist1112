package sonet.menu.ligacao;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.connection.MenuEntry;
import sonet.textui.connection.Message;

import sonet.core.Agente;

/**
 * Classe que permite a um agente remover um pedido de ligacao.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RemoverLigacao extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param visitado
	 *            Agente  visitado.
	 */
	public RemoverLigacao(Agente visitado){
		super(MenuEntry.REMOVE_CONNECTIONS, visitado);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

	}
}

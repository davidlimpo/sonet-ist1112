package sonet.menu.procura;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.search.MenuEntry;
import sonet.textui.search.Message;

import sonet.core.RedeSocial;
import sonet.core.Agente;
import sonet.core.Mensagem;

/**
 * Classe que permite listar todos os agentes da rede social 
 * que nao tenham nenhumas mensagens.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ListarAgentesSemMensagens extends Command<RedeSocial>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            RedeSocial a que se refere o command.
	 */
	public ListarAgentesSemMensagens(RedeSocial r){
		super(MenuEntry.SHOW_AGENTS_WITHOUT_MESSAGES, r);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {		

		for(Agente a: entity().getAgentes())
			if(a.getNumMensagens() == 0){
				Display d = new Display(title());
				d.addNewLine(a.toString());
				d.display();
			}
	}
}

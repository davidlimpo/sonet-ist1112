package sonet.menu.ligacao;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.connection.*;
import sonet.textui.message.UnknownKeyException;

import sonet.core.RedeSocial;
import sonet.core.Agente;
import sonet.core.Ligacao;
import sonet.core.Mensagem;

/**
 * Classe que permite a um agente Recusar um pedido de ligacao.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RecusarLigacao extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param visitado
	 *            Agente visitado.
	 */
	public RecusarLigacao(Agente visitado){
		super(MenuEntry.REFUSE_CONNECTIONS, visitado);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		RedeSocial r = entity().getRedeSocial();


		Form g = new Form();
		InputString idAgente = new InputString(g, sonet.textui.agents.Message.reqKeys());
		g.parse();

		String[] split = (idAgente + "").split(",");

		int i = 0;

		for (Ligacao l: entity().getLigacoes()){
			for(Agente a: r.getAgentes()){

				if((l.getIdAgenteOrigem()) == a.getId()){

					Mensagem m = new Mensagem(r, r.getProximoId(), 0, "" + a.getId(),
					"" + entity().getId(), Message.connectionRefused("" + entity().getId()));
					
					a.removeLigacaoPendente(i);
					break;

				}
			i++;
			}
		}


	}
}

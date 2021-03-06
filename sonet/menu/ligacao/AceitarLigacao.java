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
 * Classe que permite ao agente aceitar um pedido de ligacao.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class AceitarLigacao extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param visitado
	 *            Agente visitado.
	 */
	public AceitarLigacao(Agente visitado){
		super(MenuEntry.APPROVE_CONNECTIONS, visitado);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		RedeSocial r = entity().getRedeSocial();
		int proxId = r.getProximoId();


		Form g = new Form();
		InputString idAgente = new InputString(g, sonet.textui.agents.Message.reqKeys());
		g.parse();

		String[] split = (idAgente + "").split(",");


		for (Ligacao l: entity().getLigacoesPendentes()){
			for(Agente a: r.getAgentes()){
				if((l.getIdAgenteDestino()) == a.getId()){

					Agente destino = r.getAgente(l.getIdAgenteDestino());

					l.aceitarLigacao();

					Mensagem m = new Mensagem(r, proxId , 0, idAgente.value(),
					"" + entity().getId(), Message.connectionApproved("" + entity().getId()));
					
					a.addMensagemRecebida(m);

				}
			}
		}

	}

}

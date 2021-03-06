package sonet.menu.ligacao;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.connection.MenuEntry;
import sonet.textui.connection.Message;
import sonet.textui.message.UnknownKeyException;

import sonet.core.RedeSocial;
import sonet.core.Agente;
import sonet.core.Ligacao;
import sonet.core.Mensagem;

/**
 * Classe que permite a um agente enviar um pedido de ligacao.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class PedidoLigacao extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param visitado
	 *            Agente visitado.
	 */
	public PedidoLigacao(Agente visitado){
		super(MenuEntry.REQUEST_CONNECTION, visitado);
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

		//Verifica se os agentes com os identificadores introduzidos existem 
		for(int j = 0; j < split.length; j++)
			if(!entity().getRedeSocial().getAgentes().contains(
			entity().getRedeSocial().getAgente(Integer.parseInt(split[j])))){

				//ENVIA MENSAGEM
				Mensagem m = new Mensagem(r, r.getProximoId(), 0, "" + entity().getId(),
				split[j], Message.unknownId(split[j]));

				entity().addMensagemRecebida(m);


			}else{
				//Adiciona os pedidos introduzidos na lista
				for(int i = 0; i < split.length; i++){

					Ligacao lOrigem = new Ligacao(entity().getRedeSocial(), 
							  entity().getId(), Integer.parseInt(split[i]));

					Ligacao lDestino = new Ligacao(entity().getRedeSocial(), 
							  Integer.parseInt(split[i]), entity().getId());

					for (Agente b: r.getAgentes()){

						if ((Integer.parseInt(split[i])) == b.getId()){
							b.addLigacaoPendente(lDestino);
							b.addLigacao(lDestino);
						}
					}
					entity().addLigacao(lOrigem);
				}
			}
	}
}

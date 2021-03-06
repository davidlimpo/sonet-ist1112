package sonet.menu.mensagem;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.message.*;
import sonet.core.*;
import java.util.*;
import java.io.*;
import java.lang.*;


/**
 * Classe que permite ao Agente reenviar uma mensagem.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ReenviarMensagem extends Command<Agente>{

	/** Atributo que guarda o conteudo(texto) da Mensagem */
	private String _txt;

	/** Lista de Anexos que irão compor a mensagem */
	private List<Integer> _arrayAnexos = new ArrayList<Integer>();

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            agente rementede a que se refere o command.
	 */
	public ReenviarMensagem(Agente a){
		super(MenuEntry.FORWARD_MESSAGE, a);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		VisualizarMensagem v = new VisualizarMensagem(entity());
		v.execute();
		
		Mensagem m = v.getMensagem();

		EnviarMensagem em = new EnviarMensagem(entity());

		Form f = new Form();
		InputString idDestinatario = new InputString(f, sonet.textui.agents.Message.reqKeys());
		f.parse();

		String[] split = (idDestinatario + "").split(",");

		List<Integer> destinatarios = new ArrayList<Integer>();


		_txt = em.conteudo();
		_arrayAnexos = em.anexos();

		RedeSocial a = entity().getRedeSocial();
		int idS = a.getProximoId();

		for(int i = 0; i < split.length; i++){

			destinatarios.add(Integer.parseInt(split[i]));

			Mensagem r = new Mensagem(a, idS, entity().getId(), 
			"" + Integer.parseInt(split[i]) , Message.forwarded() + m.getSubject(), _txt);
			
			entity().addMensagemEnviada(r);

 			for (Agente b: a.getAgentes()){
 				if ((Integer.parseInt(split[i])) == b.getId()){
 			
 					b.addMensagemRecebida(r);
				}
			}
		}


	}
}

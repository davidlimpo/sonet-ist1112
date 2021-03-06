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
 * Classe que permite ao Agente responder a uma mensagem.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ResponderMensagem extends Command<Agente>{


	private String _txt;
	private List<Integer> _arrayAnexos = new ArrayList<Integer>();


	/**
	 * Construtor.
	 * 
	 * @param a
	 *            agente a que se refere o command.
	 */
	public ResponderMensagem(Agente a){
		super(MenuEntry.REPLY_TO_MESSAGE, a);
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

		_txt = em.conteudo();

		_arrayAnexos = em.anexos();

		RedeSocial a = entity().getRedeSocial();

		Mensagem m2 = new Mensagem(entity().getRedeSocial(), 
		a.getProximoId(), Integer.parseInt(m.getTo()), 
		"" + m.getFrom(), Message.inReply() + m.getSubject(), _txt);
			
		entity().addMensagemEnviada(m2);

			
		for (Agente b: a.getAgentes()){
 			if ((m.getFrom()) == b.getId()){

				b.addMensagemRecebida(m2);
			}
		}
	}
}

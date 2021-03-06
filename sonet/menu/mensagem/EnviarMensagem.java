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
 * Classe que permite ao Agente enviar uma mensagem.
 * 
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class EnviarMensagem extends Command<Agente>{

	/** Atributo que guarda o conteudo(texto) da Mensagem */
	private String _txt;

	/** Lista de Anexos que irão compor a mensagem */
	private List<Integer> _idsAnexosInput = new ArrayList<Integer>();


	/**
	 * Construtor.
	 * 
	 * @param a
	 *            agente rementede a que se refere o command.
	 */
	public EnviarMensagem(Agente a){
		super(MenuEntry.SEND_MESSAGE, a);
	}

	/** 
	 * Metodo que recebe do input o conteudo(texto) da mensagem 
	 *
	 *@return o conteudo
	 *
	 */
	public String conteudo(){

		String txt;
		String input;

		Form h = new Form();
		InputString textoMensagem = new InputString(h, Message.reqText());
		h.parse();
		input = txt = textoMensagem.value();

		while (!((input).equals("."))){

			Form h1 = new Form();
			InputString textoMensagemCiclo = new InputString(h1, "");
			h1.parse();
			txt = txt + textoMensagemCiclo.value();
			input = textoMensagemCiclo.value();
		}

		return txt;


	}

	/** 
	 * Metodo que recebe do input a lista de anexos que irão compor a mensagem
	 *
	 *@return lista de anexos
	 *
	 */
	public List<Integer> anexos(){

		// lista separada virgulas
		Form j = new Form();
		InputString anexos = new InputString(j, Message.reqKeys());
		j.parse();


		String[] split1 = (anexos + "").split(",");

		List<Integer> _idsAnexosInput = new ArrayList<Integer>();

		if(!((anexos.value()).equals(""))){
			for(int i = 0; i < split1.length; i++){
				_idsAnexosInput.add(Integer.parseInt(split1[i]));
			}
		}

		return _idsAnexosInput;

	}


	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */

	public final void execute() throws InvalidOperation { 

		Form f = new Form();
		InputString idDestinatario = new InputString(f, sonet.textui.agents.Message.reqKeys());
		f.parse();

		String[] split = (idDestinatario + "").split(",");

		if(split[0].isEmpty())
			throw new NoDestinationException();

		List<Integer> destinatarios = new ArrayList<Integer>();

		Form g = new Form();
		InputString assunto = new InputString(g, Message.reqSubject());
		g.parse();


		_txt = conteudo();
		_idsAnexosInput = anexos();

		//lista com os Anexos da Mensagem
		List<Anexo> listaAnexos = new ArrayList<Anexo>();


		// Cria anexo
		boolean flagMensagemEnviada = false;
		boolean flagMensagemRecebida = false;
		boolean flagPublicacao = false;

		for(Integer i: _idsAnexosInput ){
			for(Mensagem m: (entity().getMensagensEnviadas())){
				if(m.getId() == i.intValue() ){
					Anexo a = new Anexo(entity(), m);
					listaAnexos.add(a);
				} else{
					flagMensagemEnviada = true;
				}
			}


			for(Mensagem m: (entity().getMensagensRecebidas()) ){
				if(m.getId() == i.intValue() ){
					Anexo a = new Anexo(entity(), m);
					listaAnexos.add(a);
				} else{
					flagMensagemRecebida = true;
					  }
			}


			for(Publicacao p: (entity().getPublicacoes()) ){
				if(p.getId() == i.intValue() ){
					Anexo a = new Anexo(entity(), p);
					listaAnexos.add(a);
				} else{

					flagPublicacao = true;
				  }
			}
		}


		// envia a mensagem
		RedeSocial a = entity().getRedeSocial();
		int _ids = a.getProximoId();

		Mensagem rEnv = new Mensagem(a, _ids, entity().getId(), 
						idDestinatario.value(), assunto.value(), _txt, listaAnexos);

		for(int i = 0; i < split.length; i++){

			destinatarios.add(Integer.parseInt(split[i]));

				Mensagem r = new Mensagem(a, _ids, entity().getId(), 
						"" + Integer.parseInt(split[i]) , assunto.value(),
						_txt, listaAnexos);


			boolean entregue = false;
			List<Anexo> anexoErro = new ArrayList<Anexo>();

			
			for (Agente b: a.getAgentes()){

				if ((Integer.parseInt(split[i])) == b.getId() && 
					(!(flagMensagemEnviada && flagMensagemRecebida && flagPublicacao))){

					if(((b.getActivo()).equals("ACTIVE")) /*&& b.isConnected() */){

						b.addMensagemRecebida(r);
						entregue = true;

					} else if ((!(flagMensagemEnviada && flagMensagemRecebida && flagPublicacao))) {
						
						Mensagem r2 = new Mensagem(a, _ids, entity().getId(), 
						"" + Integer.parseInt(split[i]), assunto.value(), _txt);

						Anexo anx = new Anexo (entity(), r2);
						
						anexoErro.add(anx);

						Mensagem errorsms = new Mensagem(a, a.getProximoId(), 
						0, "" + entity().getId(), Message.msgRejected("" + r.getId()), "", anexoErro);
						
						entity().addMensagemRecebida(errorsms);
						
						entity().addMensagemEnviada(rEnv);

					}
				}
			}

			if (flagMensagemEnviada && flagMensagemRecebida && flagPublicacao) {

				Anexo anx = new Anexo (entity(), r);
				anexoErro.add(anx);

				Mensagem errorsms = new Mensagem(a, a.getProximoId(), 0, 
				"" + entity().getId(), Message.couldNotAttach("" + r.getId()), 
				"", anexoErro);

				entity().addMensagemRecebida(errorsms);
				
				entity().addMensagemEnviada(rEnv);
			}

			if(entregue)
				entity().addMensagemEnviada(rEnv);
		}
	}
}

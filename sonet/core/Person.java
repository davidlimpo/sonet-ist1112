package sonet.core;

import java.util.*;
import java.io.*;

import sonet.core.*;
import sonet.textui.agents.Message;

/**
 *	Classe responsavel pela criaçao do Agente Person.<P>
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public class Person extends Agente implements java.io.Serializable {

	/** TreeMap de mensagens enviadas do agente */
	private Map<Integer, Mensagem> _mensagensEnviadas = new TreeMap<Integer, Mensagem>();

	/**
	 * Construtor
	 * 
	 * @param redeS
	 *            A Rede Social
	 * @param id
	 *            id.
	 * @param nome
	 *            nome.
	 * @param email
	 *            email.
	 * @param numTel
	 *            numero de telefone.
	 */
	public Person(RedeSocial redeS, int id, String nome, String email, int numTel) {

		super(redeS, id, nome, email, numTel);
	}

	/**
	 * Metodo que adiciona Mensagens Enviadas ao TreeMap _mensagensEnviadas
	 * 
	 * @param mensagem
	 *            mensagem que vai ser adicionada
	 */
	public void addMensagemEnviada(Mensagem mensagemEnviada){
	  	_mensagensEnviadas.put(mensagemEnviada.getId(), mensagemEnviada);
	}

	/**
	 * Metodo que retorna todas as mensagens enviadas do Agente
	 * 
	 * @return collection com todas as mensagens do Agente
	 *
	 */
	public Collection<Mensagem> getMensagensEnviadas() {
		return Collections.unmodifiableCollection(_mensagensEnviadas.values());
	}

	/**
	 * Este metodo retorna o numero total de mensagens do agente
	 *
	 * @return numero total de mensagens
	 */
	public final int getNumMensagens() {
		return (getNumMensagensRecebidas() + _mensagensEnviadas.size());
	}

	/**
	 * Este metodo retorna o numero total de mensagens enviadas do agente
	 *
	 * @return numero de mensagens enviadas
	 */
	public final int getNumMensagensEnviadas() {
		return _mensagensEnviadas.size();
	}

	public void setMensagensEnviadas(List<Mensagem> list){
		_mensagensEnviadas.clear();

		for (Mensagem m: list)
			addMensagemEnviada(m);
	}

	/** Redefiniçao do metodo toString para imprimir o output como esperado */
	public String toString(){ 
		return Message.typePerson() + super.toString(); 
	}
}

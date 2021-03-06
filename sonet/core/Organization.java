package sonet.core;

import java.util.*;
import java.io.*;

import sonet.textui.agents.Message;

import sonet.core.*;

/**
 *	Classe responsavel pela criaçao do Agente Organization.<P>
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public class Organization extends Agente implements java.io.Serializable {

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
	public Organization(RedeSocial redeS, int id, String nome, String email, int numTel) {

		super(redeS, id, nome, email, numTel);
	}

	/**
	 * Metodo que retorna todas as mensagens enviadas do Agente
	 * 
	 * @return collection com todas as mensagens do Agente
	 *
	 */
	public Collection<Mensagem> getMensagensEnviadas() {
		Map<Integer, Mensagem> treemapVazio = new TreeMap<Integer, Mensagem>();
		return Collections.unmodifiableCollection( treemapVazio.values() );
	}

	/**
	 * Este metodo retorna o numero total de mensagens do agente
	 *
	 * @return numero total de mensagens
	 */
	public final int getNumMensagens() {
		return 0;
	}

	/**
	 * Este metodo retorna o numero total de mensagens enviadas do agente
	 *
	 * @return numero de mensagens enviadas
	 */
	public final int getNumMensagensEnviadas() {
		return 0;
	}

	/** Redefiniçao do metodo toString para imprimir o output como esperado */
	public String toString(){ 
		return Message.typeOrganization() + super.toString();
	}
}

package sonet.core;

import java.io.Serializable;
import sonet.core.*;

/**
 *	Classe responsavel pela criaçao de Anexos.<P>
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public class Anexo implements Serializable {

	/** O Agente do Anexo */
	private Agente _agente;

	/** A Publicacao do Anexo */
	private Publicacao _publicacao;

	/** A Mensagem do Anexo */
	private Mensagem _mensagem;


	/**
	 * Construtor para Anexos que sejam Publicacoes
	 * 
	 * @param a
	 *            o Agente a que pertence
	 * @param p
	 *            a Publicacao que contem
	 */
	public Anexo(Agente a, Publicacao p){

		_agente = a;
		_publicacao = p;
	}

	/**
	 * Construtor para Anexos que sejam Mensagens
	 * 
	 * @param a
	 *            o Agente a que pertence
	 * @param p
	 *            a Mensagem que contem
	 */
	public Anexo(Agente a, Mensagem m){

		_agente = a;
		_mensagem = m;
	}

	/**
	 * Este metodo retorna a publicacao que o anexo contem
	 *
	 * @return Publicacao
	 */ 
	public Publicacao getPublicacao(){
		return _publicacao;
	}

	/**
	 * Este metodo retorna a mensagem que o anexo contem
	 *
	 * @return Mensagem
	 */ 
	public Mensagem getMensagem(){
		return _mensagem;
	}
}

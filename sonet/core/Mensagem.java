package sonet.core;

import java.io.Serializable;
import sonet.menu.RedeSocialMenuMensagem;

import java.util.*;
import java.io.*;

/**
 *	Classe responsavel pela criaçao de Mensagens.<P>
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public class Mensagem implements Serializable {

	/** A Rede Social da mensagem */
	private RedeSocial _redeS;

	/** O id da mensagem. */
	private int _id;

	/** O id do remetente. */
	private int _from;

	/** O id do(s) destinatario(s). */
	private String _to;

	/** O assunto. */
	private String _subject;

	/** O texto. */
	private String _body;

	/** List de anexos da mensagem */
	private List<Anexo> _anexos = new ArrayList<Anexo>();


	/**
	 * Construtor para mensagem sem anexos
	 * 
	 * @param s
	 *            A Rede Social
	 * @param id
	 *            id.
	 * @param form
	 *            id do remetente.
	 * @param to
	 *            id(s) do(s) destinatario(s).
	 * @param subject
	 *            assunto.
	 * @param body
	 *            texto da mensagem.
	 */
	public Mensagem(RedeSocial s, int id, int from, String to, String subject, String body){

		_redeS = s;
		_id = id;
		_from = from;
		_to = to;
		_subject = subject;
		_body = body;
	}


	/**
	 * Construtor para mensagem com anexos
	 * 
	 * @param s
	 *            A Rede Social
	 * @param id
	 *            id.
	 * @param form
	 *            id do remetente.
	 * @param to
	 *            id(s) do(s) destinatario(s).
	 * @param subject
	 *            assunto.
	 * @param body
	 *	      texto da mensagem.
	 * @param anexo
	 *            lista de anexos da mensagem.
	 */
	public Mensagem(RedeSocial s, int id, int from, String to, String subject, String body, List<Anexo> anexo){

		_redeS = s;
		_id = id;
		_from = from;
		_to = to;
		_subject = subject;
		_body = body;
		_anexos = anexo;
	}

	/**
	 * Este metodo retorna o id da mensagem
	 *
	 * @return id.
	 */
	public int getId(){
		return _id;
	}

	/**
	 * Este metodo retorna o id do remetente
	 *
	 * @return id do rementente.
	 */
	public int getFrom(){
		return _from;
	}

	/**
	 * Este metodo retorna o id(s) do(s) destinatario(s)
	 *
	 * @return id(s) do(s) destinatario(s)
	 */
	public String getTo(){
		return _to;
	}

	/**
	 * Este metodo retorna o assunto da mensagem
	 *
	 * @return assunto
	 */
	public String getSubject(){
		return _subject;
	}

	/**
	 * Este metodo retorna o texto da mensagem
	 *
	 * @return texto
	 */
	public String getBody(){
		return _body;
	}

	/**
	 * Metodo que retorna todas os Anexos da Mensagem
	 * 
	 * @return collection com todos os Anexos da Mensagem
	 *
	 */
	public Collection<Anexo> getAnexos() {
		return Collections.unmodifiableCollection(_anexos);
	}

	/** Redefiniçao do metodo toString para imprimir o output como esperado */
	public String toString(){
		return "MESSAGE" + "|" + getId() + "|" + getFrom() + "|" + getTo() + "|" + getSubject() + "|" + _anexos.size();
	}
}

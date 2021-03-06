package sonet.core;

import java.io.Serializable;
import sonet.menu.RedeSocialMenuPublicacao;

import java.util.*;
import sonet.core.*;

/**
 *	Classe responsavel pela criaçao de Publicacoes.<P>
 *	Ainda vazia na parte intermédia.
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public abstract class Publicacao implements Serializable {

	/** A Rede Social da publicacao */
	private RedeSocial _redesocial;

	/** O id da publicacao. */
	private int _id;

	/** O id do criador da publicacao */
	private int _owner;

	/** A legenda */
	private String _legend;

	/** Pontos positivos */
	private int _pontosPos;

	/** Pontos negativos */
	private int _pontosNeg;

	/** List com os comentarios da publicacao */
	private List<String> _comentarios = new ArrayList<String>();

	/** List de agentes protegidos da publicacao */
	private List<Integer> _protegidos = new ArrayList<Integer>();


	/**
	 * Construtor
	 * 
	 * @param s
	 *            a Rede Social
	 * @param id
	 *            id
	 * @param owner
	 *            id do criador
	 * @param legend
	 *            a legenda
	 * @param content
	 *            o conteudo.
	 */
	public Publicacao(RedeSocial s, int id, int owner, String legend){

		_redesocial = s;
		_id = id;
		_owner = owner;
		_legend = legend;
	}

	/**
	 * Metodo que pontua a publicacao
	 *
	 * @param p
	 *	     pontos que vao ser acrescentados
	 */
	public void pontua(int p){

		if(p > 0)
			_pontosPos += p;
		else
			_pontosNeg += p;
	}

	/**
	 * Este metodo retorna a RedeSocial a que a publicacao pertence
	 *
	 * @return Rede Social
	 */
	public RedeSocial getRedeSocial(){
		return _redesocial;
	}

	/**
	 * Este metodo retorna o id da publicacao
	 *
	 * @return id.
	 */
	public int getId(){
		return _id;
	}

	/**
	 * Este metodo retorna o total de pontos positivos
	 *
	 * @return pontos positivos.
	 */
	public int getPontosPos(){
		return _pontosPos;
	}

	/**
	 * Este metodo retorna o total de pontos negativos
	 *
	 * @return pontos negativos.
	 */
	public int getPontosNeg(){
		return _pontosNeg;
	}

	public abstract String getContent();

	/**
	 * Metodo que adiciona comentarios à List _comentarios
	 * 
	 * @param comentario
	 *            comentario que vai ser adicionado
	 */
	public void addComentario(String comentario){
	  	_comentarios.add(comentario);
	}

	/**
	 * Metodo que retorna todas os comentarios da Publicacao
	 * 
	 * @return collection com todas os comentarios da Publicacao
	 *
	 */
	public Collection<String> getComentario() {
		return Collections.unmodifiableCollection(_comentarios);
	}

	/**
	 * Metodo que adiciona agentes à List _protegidos
	 * 
	 * @param id
	 *            id do agente que vai ser adicionado
	 */
	public void addProtegido(int id){
	  	_protegidos.add(id);
	}

	/**
	 * Metodo que remove agentes da List _protegidos
	 * 
	 * @param id
	 *           id do agente que vai ser removido
	 */
	public void removeProtegido(int id){
	  	_protegidos.remove(id);
	}

	/**
	 * Metodo que retorna todos os agentes protegidos da Publicacao
	 * 
	 * @return collection com todos os agentes protegidos da Publicacao
	 *
	 */
	public Collection<Integer> getProtegidos() {
		return Collections.unmodifiableCollection(_protegidos);
	}

	/**
	 * Metodo que indica se um agente esta na lista de protegidos
	 * 
	 * @param id
	 *           id do agente que vai ser testado
	 *
	 * @ return true se está na lista, false caso contrario
	 */
        public boolean isProtected(Agente a){

		for(int i: getProtegidos())
			if(i == (a.getId()))
				return true;

		return false;
        }

	/** Redefiniçao do metodo toString para imprimir o output como esperado */
	public String toString(){
		return "|" + getId() + "|" + getPontosPos() + "|" + getPontosNeg() + "|" + _comentarios.size();
	}

}

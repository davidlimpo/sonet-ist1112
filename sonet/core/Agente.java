package sonet.core;

import java.util.*;
import java.io.*;
import sonet.textui.agents.AgentIsInactiveException;
import sonet.textui.agents.AgentIsActiveException;

import sonet.core.*;

/**
 *	Classe que trata do Agente, é a super classe das 
 *	classes Person e Organization.<P>
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public abstract class Agente implements Serializable {


	/** O id do Agente. */
	private int _id;

	/** O nome do agente. */
	private String _nome;

	/** A Rede Social do agente */
	private RedeSocial _redeS;

	/** O email do agente */
	private String _email;

	/** O numero de telefone do agente */
	private int _numTel;

	/** Estado do agente: activo ou desactivo */
	private boolean _activo;

	/** TreeMap de publicacoes do agente */
	private Map<Integer, Publicacao> _publicacoes = new TreeMap<Integer, Publicacao>();

	/** TreeMap de mensagens recebidas do agente */
	private Map<Integer, Mensagem> _mensagensRecebidas = new TreeMap<Integer, Mensagem>();

	/** List de ligacoes do agente */
	private List<Ligacao> _ligacoes = new ArrayList<Ligacao>();

	/** List de ligacoes pendentes do agente */
	private List<Ligacao> _ligacoesPendentes = new ArrayList<Ligacao>();

	/** List de agentes protegidos do agente */
	private List<Integer> _protegidos = new ArrayList<Integer>();


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
	public Agente(RedeSocial redeS, int id, String nome, String email, int numTel) {
		_id = id;
		_nome = nome;
		_email = email;
		_numTel = numTel;
		_activo = true;
		
		(_redeS = redeS).addAgente(this); 
	}

	/**
	 * Metodo que adiciona Mensagens Enviadas ao TreeMap _mensagens
	 * 
	 * @param mensagem
	 *            mensagem que vai ser adicionada
	 */
	public void addMensagemEnviada(Mensagem mensagemEnviada){ }

	/**
	 * Metodo que retorna todas as mensagens enviadas do Agente
	 * 
	 * @return collection com todas as mensagens do Agente
	 *
	 */
	public abstract Collection<Mensagem> getMensagensEnviadas();

	/**
	 * Metodo que adiciona Mensagens Recebidas ao TreeMap _mensagens
	 * 
	 * @param mensagem
	 *            mensagem que vai ser adicionada
	 */
	public void addMensagemRecebida(Mensagem mensagemRecebida){
	  	_mensagensRecebidas.put(mensagemRecebida.getId(), mensagemRecebida);
	}

	/**
	 * Metodo que retorna todas as mensagens recebidas do Agente
	 * 
	 * @return collection com todas as mensagens do Agente
	 *
	 */
	public Collection<Mensagem> getMensagensRecebidas() {
		return Collections.unmodifiableCollection(_mensagensRecebidas.values());
	}

	/**
	 * Metodo que adiciona publicacoes ao TreeMap _publicacoes
	 * 
	 * @param publicacao
	 *            publicacao que vai ser adicionada
	 */
	public void addPublicacao(Publicacao publicacao){
	  	_publicacoes.put(publicacao.getId(), publicacao);
	}

	/**
	 * Metodo que retorna todas as publicacoes do Agente
	 * 
	 * @return collection com todas as publicacoes do Agente
	 *
	 */
	public Collection<Publicacao> getPublicacoes() {
		return Collections.unmodifiableCollection(_publicacoes.values());
	}

	/**
	 * Metodo que adiciona ligacaoes à List _ligacoes
	 * 
	 * @param ligacao
	 *            ligacao que vai ser adicionada
	 */
	public void addLigacao(Ligacao ligacao){
	  	_ligacoes.add(ligacao);

		//Ordena a lista
		Collections.sort (_ligacoes, new Comparator() {  
		    public int compare(Object o1, Object o2) {  
		        Ligacao l1 = (Ligacao) o1;  
		        Ligacao l2 = (Ligacao) o2;  
		        return l1.getIdAgenteDestino() < l2.getIdAgenteDestino() ? -1 : 
			(l1.getIdAgenteDestino() > l2.getIdAgenteDestino() ? +1 : 0);  
		    }  
		}); 


	}

	/**
	 * Metodo que retorna todas as ligacoes do Agente
	 * 
	 * @return collection com todas as ligacoes do Agente
	 *
	 */
	public Collection<Ligacao> getLigacoes() {
		return Collections.unmodifiableCollection(_ligacoes);
	}

	/**
	 * Metodo que adiciona pedidos de ligacao à List _ligacoesPendentes
	 * 
	 * @param ligacao
	 *            ligacao que vai ser adicionada
	 */
	public void addLigacaoPendente(Ligacao ligacao){
	  	_ligacoesPendentes.add(ligacao);
	}

	/**
	 * Metodo que remove ligações da List _ligacoesPendentes
	 * 
	 * @param pos
	 *            pos a ser removida
	 */

	public void removeLigacaoPendente(int pos){

		_ligacoesPendentes.remove(pos);

	}

	/**
	 * Metodo que retorna todas as ligaçoes pendentes do Agente
	 * 
	 * @return collection com todas as ligaçoes pendentes do Agente
	 *
	 */
	public Collection<Ligacao> getLigacoesPendentes() {
		return Collections.unmodifiableCollection(_ligacoesPendentes);
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
	 *            id do agente que vai ser removido
	 */
	public void removeProtegido(int id){
	  	_protegidos.remove(id);
	}

	/**
	 * Metodo que retorna todos os agentes protegidos do Agente
	 * 
	 * @return collection com todos os agentes protegidos do Agente
	 *
	 */
	public Collection<Integer> getProtegidos() {
		return Collections.unmodifiableCollection(_protegidos);
	}

	/**
	 * Este metodo retorna a RedeSocial a que o agente pertence
	 *
	 * @return Rede Social
	 */
	public final RedeSocial getRedeSocial() {
		return _redeS;
	}

	/**
	 * Este metodo retorna o id do agente
	 *
	 * @return id.
	 */
	public final int getId() {
		return _id;
	}

	/**
	 * Este metodo retorna o nome do agente
	 *
	 * @return nome.
	 */
	public final String getNome() {
		return _nome;
	}

	/**
	 * Este metodo retorna o email do agente
	 *
	 * @return email.
	 */
	public final String getEmail() {
		return _email;
	}


	/**
	 * Este metodo retorna o estado do agente
	 *
	 * @return ACTIVE, se esta activo
		   INACTIVE caso contrario
	 */
	public final String getActivo() {
		if (_activo == false)
			return "INACTIVE";
		else return "ACTIVE";
	}

	/**
	 * Este metodo retorna o numero total de mensagens do agente
	 *
	 * @return numero total de mensagens
	 */
	public abstract int getNumMensagens();

	/**
	 * Este metodo retorna o numero total de mensagens enviadas do agente
	 *
	 * @return numero de mensagens enviadas
	 */
	public abstract int getNumMensagensEnviadas();

	/**
	 * Este metodo retorna o numero total de mensagens recebidas do agente
	 *
	 * @return numero de mensagens recebidas
	 */
	public final int getNumMensagensRecebidas() {
		return _mensagensRecebidas.size();
	}

	public void setMensagensEnviadas(List<Mensagem> list){ }

	public void setMensagensRecebidas(List<Mensagem> list){
		_mensagensRecebidas.clear();
		for (Mensagem m: list)
			addMensagemRecebida(m);
	}

	/**
	 * Set nome.
	 * 
	 * @param nome
	 *      	O novo nome
	 */
	public final void setNome(String nome) {
		_nome = nome;
	}

	/**
	 * Set email.
	 * 
	 * @param email
	 *      	O novo email
	 */
	public final void setEmail(String email) {
		_email = email;
	}

	/**
	 * Set numero de telefone.
	 * 
	 * @param numTel
	 *      	O novo numero de telefone
	 */
	public final void setNumTel(int numTel) {
		_numTel = numTel;
	}

	/** Activa o agente */
	public final void activar() throws AgentIsActiveException {
		if(_activo)
			throw new AgentIsActiveException("" + _id);
		else
			_activo	= true;
	}

	/** Desactiva o agente */
	public final void desactivar() throws AgentIsInactiveException {
		if (!_activo)
			throw new AgentIsInactiveException("" + _id);
		else
			_activo	= false;
	}

	/**
	 * Este metodo indica se o agente esta ou nao protegido
	 *
	 * @return true se tiver protegido, false caso contrario
	 */
        public boolean isProtected(Agente visitante){

		for(int a: getProtegidos())
			if(a == (visitante.getId()))
				return true;

		return false;
        }

	/** Redefiniçao do metodo toString para imprimir o output como esperado */
	public String toString() {
		return "|" + getId() + "|" + getNome() 
		+ "|" + getEmail() + "|" + _publicacoes.size() + "|" + _mensagensRecebidas.size() 
		+ "|" + getNumMensagensEnviadas() + "|" + _ligacoes.size() + "|" + getActivo();
	}
}

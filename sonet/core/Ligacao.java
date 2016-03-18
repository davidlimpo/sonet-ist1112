package sonet.core;

import java.io.Serializable;

/**
 *	Classe responsavel pela criaçao de Ligacoes.<P>
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public class Ligacao implements Serializable {


	/** Id do agente que criou a ligacao*/
	int _idAgenteOrigem;

	/** Id do agente alvo da ligaçao*/
	int _idAgenteDestino;


	  /** Agente 1 aceitou a ligacao se for 1, 
	      caso contrario 0*/
	 int _agenteOrigemAceitou;

	  /** Agente 2 aceitou a ligacaose for 1, 
	      caso contrario 0*/
	 int _agenteDestinoAceitou;


	/**
	 * Construtor para a ligações do import
	 * 
	 * @param s
	 *            A Rede Social
	 * @param id1
	 *            o id que criou a ligaçao.
	 * @param id2
	 *            o id alvo da ligaçao..
	 * @param aceite1
	 *           1 se o id1 aceitou, caso contrario, 0
	 * @param aceite2
	 *           1 se o id2 aceitou, caso contrario, 0
	 */
	public Ligacao(RedeSocial s, int id1, int id2, int aceite1, int aceite2){

		_idAgenteOrigem = id1;
		_idAgenteDestino = id2;
		_agenteOrigemAceitou = aceite1;
		_agenteDestinoAceitou = aceite2;
	}

	/**
	 * Construtor para a ligações feitas no Browser
	 * 
	 * @param s
	 *            A Rede Social
	 * @param id1
	 *            o id que criou a ligaçao.
	 * @param id2
	 *            o id alvo da ligaçao.
	 */
	public Ligacao(RedeSocial s, int id1, int id2){

		_idAgenteOrigem = id1;
		_idAgenteDestino = id2;
		_agenteOrigemAceitou = 1;
		_agenteDestinoAceitou = 0;
	}

	/**
	 * Este metodo retorna o id do Agente criador
	 *
	 * @return id do criador.
	 */
	public int getIdAgenteOrigem(){

		return _idAgenteOrigem;
	}

	/**
	 * Este metodo retorna o id do Agente alvo
	 *
	 * @return id do alvo.
	 */
	public int getIdAgenteDestino(){

		return _idAgenteDestino;
	}

	/**
	 * Este metodo indica se a ligaçao esta estabelicda
	 *
	 * @return 1 se estiver, caso contrario 0.
	 */
	public int getLigacaoEstabelecida(){

		if(_agenteDestinoAceitou == 1)
			return 1;
		else
			return 0;
	}

	/**
	 * Este metodo indica se a ligaçao esta estabelicda
	 *
	 * @return 1 se estiver, caso contrario 0.
	 */
	public void aceitarLigacao(){
		_agenteDestinoAceitou = 1;
	}

	/** Redefiniçao do metodo toString para imprimir o output como esperado */
	public String toString(){
		return 	"CONNECTION" + "|" + getIdAgenteDestino() + "|" + getLigacaoEstabelecida();
	}
}

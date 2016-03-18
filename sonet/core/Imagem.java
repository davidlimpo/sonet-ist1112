package sonet.core;

import java.io.Serializable;
import sonet.textui.publication.Message;

/**
 *	Classe responsavel pela criaçao de Imagens.<P>
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public class Imagem extends Publicacao implements Serializable{

	/** O conteudo da Imagem */
	private String _content;

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
	public Imagem(RedeSocial s, int id, int owner, String legend, String content){

		super(s, id, owner, legend);
		_content = content;
	}

	/**
	 * Este metodo retorna o conteudo da imagem
	 *
	 * @return string com o conteudo
	 */ 
	public String getContent(){
		return _content;
	}

	/** Redefiniçao do metodo toString para imprimir o output como esperado */
	public String toString(){
		return Message.typeImage() + super.toString(); 
	}

}

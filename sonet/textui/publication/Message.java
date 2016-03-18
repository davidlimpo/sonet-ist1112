/** @version $Id: Message.java,v 1.4 2011/09/25 14:57:21 david Exp $ */
/*
 * $Log: Message.java,v $
 * Revision 1.4  2011/09/25 14:57:21  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.publication;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return prompt for key
	 */
	public static final String reqKey() {
		return "Identificador da publicação: ";
	}

	/**
	 * @return prompt for keys
	 */
	public static final String reqKeys() {
		return "Identificadores das publicações: ";
	}

	/**
	 * @return prompt for publication type
	 */
	public static final String reqType() {
		return "Tipo de publicação: ";
	}

	/**
	 * @return prompt for publication legend
	 */
	public static final String reqLegend() {
		return "Legenda (título): ";
	}

	/**
	 * @return prompt for note text
	 */
	public static final String reqNoteText() {
		return "Texto da nota: ";
	}

	/**
	 * @return prompt for "image"
	 */
	public static final String reqImgContents() {
		return "Conteúdo da imagem: ";
	}

	/**
	 * @return prompt for URI
	 */
	public static final String reqURI() {
		return "URI: ";
	}

	/**
	 * @return prompt for rating
	 */
	public static final String reqRating() {
		return "Pontuação: ";
	}

	/**
	 * @return prompt for comment
	 */
	public static final String reqComment() {
		return "Comentário: ";
	}

	/**
	 * @return tag for text notes
	 */
	public static final String typeNote() {
		return "NOTE";
	}

	/**
	 * @return tag for URIs
	 */
	public static final String typeURI() {
		return "URI";
	}

	/**
	 * @return tag for images
	 */
	public static final String typeImage() {
		return "IMAGE";
	}

}
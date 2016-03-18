/** @version $Id: Message.java,v 1.4 2011/09/25 14:57:21 david Exp $ */
/*
 * $Log: Message.java,v $
 * Revision 1.4  2011/09/25 14:57:21  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.message;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return prompt for key
	 */
	public static final String reqKey() {
		return "Identificador da mensagem: ";
	}

	/**
	 * @return prompt for key
	 */
	public static final String reqKeys() {
		return "Identificadores de anexos: ";
	}

	/**
	 * @return prompt for subject
	 */
	public static final String reqSubject() {
		return "Assunto: ";
	}

	/**
	 * @return prompt for body
	 */
	public static final String reqText() {
		return "Texto [linha só com . para acabar]: ";
	}

	/**
	 * @param key message key
	 * @return "message rejected" notice
	 */
	public static final String msgRejected(String key) {
		return "A mensagem '" + key + "' foi rejeitada.";
	}

	/**
	 * @param key agent key
	 * @return "unknown destination" notice
	 */
	public static final String unknownDestination(String key) {
		return "O destinatário '" + key + "' é desconhecido.";
	}

	/**
	 * @param key attachment key
	 * @return "unable to attach" notice
	 */
	public static final String couldNotAttach(String key) {
		return "Não foi possível anexar '" + key + "'.";
	}

	/**
	 * @param key attachment key
	 * @return "unknown attachment" notice
	 */
	public static final String unknownAttachment(String key) {
		return "O anexo '" + key + "' é desconhecido.";
	}

	/**
	 * @return subject prefix for reply
	 */
	public static final String inReply() {
		return "Re: ";
	}

	/**
	 * @return subject prefix for forwarded message
	 */
	public static final String forwarded() {
		return "Fwd: ";
	}

	/**
	 * @return prompt for message removal
	 */
	public static final String reqRemoveMessage() {
		return "Remover mensagem? (s/n) ";
	}

	/**
	 * @param key message key
	 * @return message removal notice
	 */
	public static final String messageRemoved(String key) {
		return "A mensagem '" + key + "' foi removida.";
	}

}

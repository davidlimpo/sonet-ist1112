/** @version $Id: Message.java,v 1.4 2011/09/25 14:57:22 david Exp $ */
/*
 * $Log: Message.java,v $
 * Revision 1.4  2011/09/25 14:57:22  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.browser;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {
	/**
	 * Request the agent's own identifier (login).
	 * 
	 * @return prompt for identifier.
	 */
	public static String login() {
		return "Introduza o identificador do agente inspeccionador: ";
	}

	/**
	 * Request agent to be inspected.
	 * 
	 * @return prompt for identifier.
	 */
	public static String reqAgentKey() {
		return "Identificador do agente a inspeccionar: ";
	}

}

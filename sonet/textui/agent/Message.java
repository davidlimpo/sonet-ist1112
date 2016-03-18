/** @version $Id: Message.java,v 1.4 2011/09/25 14:57:21 david Exp $ */
/*
 * $Log: Message.java,v $
 * Revision 1.4  2011/09/25 14:57:21  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.agent;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @param agentKey
	 * @return Menu title.
	 */
	public static String menuTitle(String agentKey) {
		return "Inspecção do agente " + agentKey;
	}
	
}

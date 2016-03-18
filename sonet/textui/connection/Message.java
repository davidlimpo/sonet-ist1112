/** @version $Id: Message.java,v 1.4 2011/09/25 14:57:21 david Exp $ */
/*
 * $Log: Message.java,v $
 * Revision 1.4  2011/09/25 14:57:21  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.connection;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @param key agent key
	 * @return "unknown id" notice
	 */
	public static final String unknownId(String key) {
		return "O agente '" + key + "' é desconhecido.";
	}

	/**
	 * @param key agent key
	 * @return "connection approved" notice
	 */
	public static final String connectionApproved(String key) {
		return "O agente '" + key + "' aprovou o pedido de ligação.";
	}

	/**
	 * @param key agent key
	 * @return "connection refused" notice
	 */
	public static final String connectionRefused(String key) {
		return "O agente '" + key + "' rejeitou o pedido de ligação.";
	}

	/**
	 * @param key agent key
	 * @return "connection removed" notice
	 */
	public static final String connectionRemoved(String key) {
		return "O agente '" + key + "' removeu a ligação.";
	}

}

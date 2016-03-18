/** @version $Id: AgentIsProtectedException.java,v 1.3 2011/10/13 14:57:22 prs Exp $ */
/*
 * $Log: AgentIsProtectedException.java,v $
 * Revision 1.0  2011/10/13 14:57:22  prs
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.agents;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when a unknown key is used.
 */
public class AgentIsProtectedException extends InvalidOperation {
	/**
	 * Class serial number (serialization).
	 */
	private static final long serialVersionUID = 201109020943L;

	/** The key */
	private final String _key;

	/**
	 * @param key
	 *            agent key
	 */
	public AgentIsProtectedException(String key) {
		_key = key;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "O agente '" + _key + "' está protegido.";
	}
}


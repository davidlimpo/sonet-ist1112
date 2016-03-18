/** @version $Id: DuplicateKeyException.java,v 1.3 2011/09/25 14:57:22 david Exp $ */
/*
 * $Log: DuplicateKeyException.java,v $
 * Revision 1.3  2011/09/25 14:57:22  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.agents;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when a unknown key is used.
 */
public class DuplicateKeyException extends InvalidOperation {
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
	public DuplicateKeyException(String key) {
		_key = key;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "O agente '" + _key + "' já existe.";
	}
}

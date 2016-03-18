/** @version $Id: UnknownKeyException.java,v 1.3 2011/09/25 14:57:21 david Exp $ */
/*
 * $Log: UnknownKeyException.java,v $
 * Revision 1.3  2011/09/25 14:57:21  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.publication;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when a unknown key is used.
 */
public class UnknownKeyException extends InvalidOperation {
	/**
	 * Class serial number (serialization).
	 */
	private static final long serialVersionUID = 201109020943L;

	/** The key */
	private final String _key;

	/**
	 * @param key
	 *            publication key
	 */
	public UnknownKeyException(String key) {
		_key = key;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "A publicação '" + _key + "' não existe.";
	}
}

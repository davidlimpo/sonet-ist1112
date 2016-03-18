/** @version $Id: RatingDeniedException.java,v 1.3 2011/09/25 14:57:21 david Exp $ */
/*
 * $Log: RatingDeniedException.java,v $
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
public class RatingDeniedException extends InvalidOperation {
	/**
	 * Class serial number (serialization).
	 */
	private static final long serialVersionUID = 201109020943L;

	/** The agent key */
	private final String _agtKey;

	/** The publication key */
	private final String _pubKey;

	/**
	 * @param agtKey
	 *            agent key
	 * @param pubKey
	 *            publication key
	 */
	public RatingDeniedException(String agtKey, String pubKey) {
		_agtKey = agtKey;
		_pubKey = pubKey;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "O agente '" + _agtKey + "' não pode pontuar a publicação '" + _pubKey + "'.";
	}
}

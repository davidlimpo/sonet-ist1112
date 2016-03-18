/**
 * @version $Id: UnknownKeyException.java,v 1.0 $
 */
package sonet.textui.connection;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown connection identifiers.
 */
@SuppressWarnings("nls")
public class UnknownKeyException extends InvalidOperation {
	static final long serialVersionUID = 200910161102L;


	/**
	 * @param id
	 *            Unknown connection id to report.
	 */
	public UnknownKeyException(int id) {
		super("Não existe nenhum telemóvel identificado por '" + id + "'");
	}

}

/**
 * @version $Id: UnknownAgentKeyException.java, v 1.0 $
 */
package sonet.textui.agents;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown agent identifiers.
 */
@SuppressWarnings("nls")
public class UnknownAgentKeyException extends InvalidOperation {
	static final long serialVersionUID = 201109191102L;
	/**
	 * @param id
	 *            Unknown animal id to report.
	 */
	public UnknownAgentKeyException(String id) {
		super("Não existe nenhum agente identificado por '" + id + "'");
	}

}

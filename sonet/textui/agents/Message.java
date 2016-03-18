/** @version $Id: Message.java,v 1.4 2011/09/25 14:57:22 david Exp $ */
/*
 * $Log: Message.java,v $
 * Revision 1.4  2011/09/25 14:57:22  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.agents;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return prompt for key
	 */
	public static final String reqKey() {
		return "Identificador do agente: ";
	}

	/**
	 * @return prompt for keys
	 */
	public static final String reqKeys() {
		return "Identificadores dos agentes: ";
	}

	/**
	 * @return prompt for agent type
	 */
	public static final String reqType() {
		return "Tipo de agente: ";
	}

	/**
	 * @return prompt for name
	 */
	public static final String reqName() {
		return "Nome do agente: ";
	}
	
	/**
	 * @return prompt for email
	 */
	public static final String reqEmail() {
		return "Email do agente: ";
	}

	/**
	 * @return prompt for phone number
	 */
	public static final String reqPhone() {
		return "Telefone do agente: ";
	}
	
	/**
	 * @return tag for individual agents
	 */
	public static final String typePerson() {
		return "PERSON";
	}
	
	/**
	 * @return tag for organizations
	 */
	public static final String typeOrganization() {
		return "ORGANIZATION";
	}
	
	/**
	 * @return tag for active agents
	 */
	public static final String agentActive() {
		return "ACTIVE";
	}
	
	/**
	 * @return tag for inactive agents
	 */
	public static final String agentInactive() {
		return "INACTIVE";
	}
}

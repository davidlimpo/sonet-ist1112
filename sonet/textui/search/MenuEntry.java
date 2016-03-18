/** @version $Id: MenuEntry.java,v 1.4 2011/09/25 14:57:22 david Exp $ */
/*
 * $Log: MenuEntry.java,v $
 * Revision 1.4  2011/09/25 14:57:22  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.search;

/**
 * Menu entries.
 */
@SuppressWarnings("nls")
public class MenuEntry {

	/** Menu title. */
	public static final String TITLE = "Consultas";

	/** Show all messages. */
	public static final String SHOW_ALL_MESSAGES = "Listar todas as mensagens";

	/** Show all messages with attachments. */
	public static final String SHOW_ALL_MESSAGES_WITH_ATTACHMENTS = "Listar todas as mensagens com anexos";

	/** Show agents without messages. */
	public static final String SHOW_AGENTS_WITHOUT_MESSAGES = "Listar agentes sem mensagens";

	/** Show agents without connections. */
	public static final String SHOW_AGENTS_WITHOUT_CONNECTIONS = "Listar agentes sem ligações";

	/** Show agents without publications. */
	public static final String SHOW_AGENTS_WITHOUT_PUBLICATIONS = "Listar agentes sem publicações";

}
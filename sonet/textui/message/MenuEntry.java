/** @version $Id: MenuEntry.java,v 1.3 2011/09/25 14:57:21 david Exp $ */
/*
 * $Log: MenuEntry.java,v $
 * Revision 1.3  2011/09/25 14:57:21  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.message;

/**
 * Menu entries.
 */
@SuppressWarnings("nls")
public final class MenuEntry {
	/** Menu title. */
	public static final String TITLE = "Gestão de Mensagens";
	
	/** */
	public static final String LIST_INBOX = "Visualizar mensagens recebidas";

	/** */
	public static final String LIST_OUTBOX = "Visualizar mensagens enviadas";

	/** */
	public static final String SHOW_MESSAGE = "Visualizar mensagem";

	/** */
	public static final String SEND_MESSAGE = "Enviar mensagem";

	/** */
	public static final String REPLY_TO_MESSAGE = "Responder a mensagem";

	/** */
	public static final String FORWARD_MESSAGE = "Reenviar mensagem";

	/** */
	public static final String REMOVE_MESSAGE = "Remover mensagem";

	/** */
	public static final String ENABLE_MESSAGES = "Autorizar mensagens";

	/** */
	public static final String DISABLE_MESSAGES = "Bloquear mensagens";

}
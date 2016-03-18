/** @version $Id: MenuEntry.java,v 1.4 2011/09/25 14:57:21 david Exp $ */
/*
 * $Log: MenuEntry.java,v $
 * Revision 1.4  2011/09/25 14:57:21  david
 * First (preliminary) version of the support classes.
 *
 * 
 */
package sonet.textui.agent;

/**
 * Menu entries.
 */
@SuppressWarnings("nls")
public final class MenuEntry {
	/* Menu title. NOT USED! Use Messages.menuTitle() */
	// public static final String TITLE = "Menu de Inspecção";

	/** Show agent properties. */
	public static final String SHOW_PROPERTIES = "Visualizar propriedades";

	/** Edit agent profile. */
	public static final String EDIT_PROFILE = "Editar perfil do agente";

	/** Protect agent profile. */
	public static final String PROTECT_PROFILE = "Proteger perfil do agente";

	/** Unprotect agent profile. */
	public static final String UNPROTECT_PROFILE = "Desproteger perfil do agente";

	/** Open publications menu. */
	public static final String OPEN_MENU_PUBLICATIONS = "Menu de publicações";

	/** Open messages menu. */
	public static final String OPEN_MENU_MESSAGES = "Menu de mensagens";

	/** Open connections menu. */
	public static final String OPEN_MENU_CONNECTIONS = "Menu de ligações";

}
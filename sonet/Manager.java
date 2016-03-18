package sonet;

import pt.utl.ist.po.ui.Menu;
import static pt.utl.ist.po.ui.UserInteraction.IO;

import java.io.*;
import sonet.core.*;
import sonet.menu.MenuRedeSocial;

/**
 * Main do Manager
 * 
 * @author José Andrade
 * @author David Limpo
 * @version 1.0
 */
public class Manager {
	/**
	 * @param args
	 */
	@SuppressWarnings("nls")
	public static void main(String[] args) {
		RedeSocial redeS = new RedeSocial("redeS");

		/* Ler um ficheiro de importação */
		String filename = System.getProperty("Import");
		if (filename != null) redeS.parseInputFile(filename);

		/* Iniciar a interface de utilizador */
		IO.setTitle(redeS.getNome());
		Menu m = new MenuRedeSocial(redeS);
		m.open();

	}

}

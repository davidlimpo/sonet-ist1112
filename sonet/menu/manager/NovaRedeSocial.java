package sonet.menu.manager;

import pt.utl.ist.po.ui.*;

import sonet.textui.manager.MenuEntry;
import sonet.textui.manager.Message;

import static pt.utl.ist.po.ui.UserInteraction.IO;

import java.io.*;

import sonet.core.*;
import sonet.menu.manager.*;
import sonet.menu.MenuRedeSocial;

/**
 * Classe que permite criar uma nova RedeSocial.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class NovaRedeSocial extends Command<RedeSocial>{

	/** Construtor
	 *
	 *  @param redesocial
	 *	redesocial a que se refere o comando.
	 */
	public NovaRedeSocial(RedeSocial redesocial){
		super(true, MenuEntry.NEW, redesocial);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		Form f = new Form(title());
		InputBoolean saveBE = new InputBoolean(f, Message.saveBeforeExit());
		f.parse();


		if(saveBE.value()){

		RedeSocial redeS = new RedeSocial("redeS");

		/* Ler um ficheiro de importação */
		String filename = System.getProperty("Import");
		if (filename != null) redeS.parseInputFile(filename);

		/* Iniciar a interface de utilizador */
		IO.setTitle(redeS.getNome());
		Menu m = new MenuRedeSocial(redeS);
		m.open();

		} else {

			GuardarRedeSocial r1 = new GuardarRedeSocial(entity());

		  }
	}

}

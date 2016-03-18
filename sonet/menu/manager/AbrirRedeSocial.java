package sonet.menu.manager;

import pt.utl.ist.po.ui.*;

import sonet.menu.MenuRedeSocial;
import sonet.textui.manager.MenuEntry;
import sonet.textui.manager.Message;
import java.io.*;

import sonet.core.*;

/**
 * Classe que permite abrir uma RedeSocial previamente gravada.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class AbrirRedeSocial extends Command<RedeSocial>{

	/**
	 * Construtor.
	 * 
	 * @param redesocial
	 *            redesocial a que se refere o command.
	 */
	public AbrirRedeSocial(RedeSocial redesocial){
		super(true, MenuEntry.OPEN, redesocial);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		Form f = new Form(title());
		InputString openFile = new InputString(f, Message.openFile());
		f.parse();

  		RedeSocial r1 = new RedeSocial(openFile.value());

		try{
		r1 = r1.load(openFile.value());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro:" + openFile.value() + " not found");
			Menu m = new MenuRedeSocial(entity());
			m.open();
	    	} catch (IOException e) {
			System.out.println("Erro (IO):" + openFile.value() + " fail to load");
			Menu m = new MenuRedeSocial(entity());
			m.open();
	   	}

		Menu m = new MenuRedeSocial(r1);
		m.open();
	}
}

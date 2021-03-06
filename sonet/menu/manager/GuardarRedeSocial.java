package sonet.menu.manager;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.lang.String;
import java.io.*;

import sonet.textui.manager.MenuEntry;
import sonet.textui.manager.Message;

import sonet.core.RedeSocial;

/**
 * Classe que permite guardar uma RedeSocial no directorio onde 
 * foi previamente gravada.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class GuardarRedeSocial extends Command<RedeSocial>{

	/** Construtor
	 *
	 *  @param redesocial
	 *	redesocial a que se refere o comando.
	 */
	public GuardarRedeSocial(RedeSocial redesocial){
		super(MenuEntry.SAVE, redesocial);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		RedeSocial RedeS = entity();
		String file = entity().getSave();
		
		/* save file */
		if (file.equals("RedeS")){

			Form f = new Form(title());
		 	InputString saveName = new InputString(f, Message.newSaveAs());
		    	f.parse();

			  try {
			   entity().setSave(saveName.value());
		  	   RedeS.save(saveName.value());
		  	} catch (IOException e) {
			    System.out.println("Erro : "+file+" : "+e);
		 	  }
		} else {
			  try {
			   RedeS.save(file);
			} catch (IOException e) {
			    System.out.println("Erro : "+file+" : "+e);
			  }
		  }
	}
}

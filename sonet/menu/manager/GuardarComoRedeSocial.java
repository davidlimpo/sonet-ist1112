package sonet.menu.manager;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;

import java.lang.String;
import java.io.*;

import sonet.textui.manager.MenuEntry;
import sonet.textui.manager.Message;

import sonet.core.RedeSocial;

/**
 * Classe que permite guardar num directorio à escolha uma RedeSocial.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class GuardarComoRedeSocial extends Command<RedeSocial>{

	/** Construtor
	 *
	 *  @param redesocial
	 *	redesocial a que se refere o comando.
	 */
	public GuardarComoRedeSocial(RedeSocial redesocial){
		super(MenuEntry.SAVE_AS, redesocial);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		RedeSocial RedeS = entity();
		String file = entity().getSave();

		Form f = new Form(title());
		InputString newSaveName = new InputString(f, Message.saveAs());
		f.parse();

		try {
			entity().setSave(newSaveName.value());
			RedeS.save(newSaveName.value());
			} catch (IOException e) {
				System.out.println("Erro : "+file+" : "+e);
			  }

	}
}

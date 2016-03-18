package sonet.menu.mensagem;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputBoolean;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Display;


import sonet.textui.message.*;
import sonet.core.*;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Classe que permite ao Agente remover uma mensagem.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RemoverMensagem extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            agente a que se refere o command.
	 */
	public RemoverMensagem(Agente a){
		super(MenuEntry.REMOVE_MESSAGE, a);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		VisualizarMensagem v = new VisualizarMensagem(entity());
		v.execute();
		
		Mensagem m = v.getMensagem();

		Form f = new Form();
		InputBoolean remover = new InputBoolean(f, Message.reqRemoveMessage());
		f.parse();

		List<Mensagem> theList1 = new ArrayList(entity().getMensagensEnviadas());
		List<Mensagem> theList2 = new ArrayList(entity().getMensagensRecebidas());


		int i;

 		if(remover.value()){
 			i = 0;
 			for (Mensagem m2: theList1){
				if ((m2.getId()) == (m.getId())){
					(theList1).remove(i);
					entity().setMensagensEnviadas(theList1);
					break;
				}
				i++;
			}

			i = 0;
			for (Mensagem m2: theList2){
				if ((m2.getId()) == (m.getId())){
					(theList2).remove(i);
					entity().setMensagensRecebidas(theList2);
					break;
				}
				i++;
			}


			Display d = new Display(title());
			d.addNewLine(Message.messageRemoved("" + m.getId()));
			d.display();

		}

	}
}

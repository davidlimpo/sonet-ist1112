package sonet.menu.procura;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.search.MenuEntry;
import sonet.textui.search.Message;

import java.util.*;

import sonet.core.RedeSocial;
import sonet.core.Agente;
import sonet.core.Mensagem;

/**
 * Classe que permite listar todas as mensagens da rede social 
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ListarMensagens extends Command<RedeSocial>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            RedeSocial a que se refere o command.
	 */
	public ListarMensagens(RedeSocial r){
		super(MenuEntry.SHOW_ALL_MESSAGES, r);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		List<Mensagem> listaTodasMensagens = new ArrayList<Mensagem>();

		//Copia todas as mensagens de uma RedeSocial para uma lista
		for(Agente a: entity().getAgentes())
			for(Mensagem m: a.getMensagensEnviadas() )
				listaTodasMensagens.add(m);

		//Ordena essa lista
		Collections.sort (listaTodasMensagens, new Comparator() {  
		    public int compare(Object o1, Object o2) {  
		        Mensagem m1 = (Mensagem) o1;  
		        Mensagem m2 = (Mensagem) o2;  
		        return m1.getId() < m2.getId() ? -1 : (m1.getId() > m2.getId() ? +1 : 0);  
		    }  
		}); 

		//Imprime-a
		for(Mensagem m: listaTodasMensagens){
			Display d = new Display(title());
			d.addNewLine(m.toString());
			d.display();
		}
	}
}

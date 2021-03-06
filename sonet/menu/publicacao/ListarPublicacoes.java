package sonet.menu.publicacao;

import java.util.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.publication.MenuEntry;
import sonet.textui.publication.Message;

import sonet.core.Publicacao;

/**
 * Classe que permite listar todas as publicacoes de um agente
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class ListarPublicacoes extends Command<Collection<Publicacao>>{

	/**
	 * Construtor.
	 * 
	 * @param p
	 *            Colecçao a que se refere o command.
	 */
	public ListarPublicacoes(Collection<Publicacao> p){
		super(MenuEntry.SHOW_PUBLICATIONS, p);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Display d = new Display(title());

		for (Publicacao p: entity())
			d.addNewLine(p.toString());

		d.display();
	}
}

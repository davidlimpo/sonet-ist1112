package sonet.menu.publicacao;

import java.util.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.publication.MenuEntry;
import sonet.textui.publication.Message;

import sonet.core.Publicacao;
import sonet.core.Imagem;
import sonet.core.Notas;
import sonet.core.Uri;

import sonet.textui.publication.UnknownKeyException;

/**
 * Classe que permite mostrar uma publicacao
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class MostrarPublicacao extends Command<Collection<Publicacao>>{

	/**
	 * Construtor.
	 * 
	 * @param p
	 *            Colecçao a que se refere o command.
	 */
	public MostrarPublicacao(Collection<Publicacao> p){
		super(MenuEntry.SHOW_PUBLICATION, p);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		Form f = new Form();
		InputString inputId  = new InputString(f, Message.reqKey());
		f.parse();

		for (Publicacao p: entity())
			if ((Integer.parseInt(inputId.value())) == p.getId()){

				Display d = new Display(title());
				d.addNewLine(p.toString());
				d.addNewLine(p.getContent());

				for(String c: p.getComentario())
					d.addNewLine(c);

				d.display();

				return;
			}
		//Se chegar aqui é porque nao encontrou a publicação
		throw new UnknownKeyException("" + (Integer.parseInt(inputId.value())));
	}
}

package sonet.menu.browser;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InvalidOperation;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import sonet.textui.browser.MenuEntry;
import sonet.textui.browser.Message;
import sonet.textui.agents.AgentIsProtectedException;

import sonet.core.*;
import sonet.menu.RedeSocialMenuAgente;

/**
 * Classe que permite visitar um agente atraves do Browser.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class VisitarAgente extends Command<RedeSocial>{

	/**
	 * Construtor.
	 * 
	 * @param r
	 *            a RedeSocial alvo.
	 */
	public VisitarAgente(RedeSocial r){
		super(MenuEntry.VISIT_AGENT, r);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {
		Person prev;
		Form f = new Form();
	   	InputString Ainspeccionado = new InputString(f, Message.reqAgentKey());	
	    	f.parse();

		for (Agente a: entity().getAgentes()){
			if ((Integer.parseInt(Ainspeccionado.value())) == a.getId()){

				entity().setInspeccionado((Integer.parseInt(Ainspeccionado.value())));

				for (Agente b: entity().getAgentes())
					if (((b.getRedeSocial()).getInspeccionador()) == b.getId()){

						//b = login, a = visitado
						if((a.getActivo()).equals("INACTIVE") || a.isProtected(b) )
							throw new AgentIsProtectedException("" + a.getId());
						else{
							Menu m = new RedeSocialMenuAgente(b, a);
							m.open();
						}
					}
			}
		}
	}
}

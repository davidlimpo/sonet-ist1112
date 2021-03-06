package sonet.menu.agentes;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.lang.String;

import sonet.textui.agents.*;
import java.util.*;

import sonet.core.*;

/**
 * Classe que regista um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RegistarAgente extends Command<RedeSocial>{

	/**
	 * Construtor.
	 * 
	 * @param r
	 *            a RedeSocial alvo.
	 */
	public RegistarAgente(RedeSocial r){
		super(MenuEntry.REGISTER_AGENT, r);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Form f = new Form();
		InputString tipoAgente = new InputString(f, Message.reqType());
		f.parse();

		if((tipoAgente.value()).equals(Message.typePerson()) || (tipoAgente.value()).equals(Message.typeOrganization())){

			Form nome = new Form();
			InputString nomeAgente = new InputString(nome, Message.reqName());
			nome.parse();

			Form email = new Form();
			InputString emailAgente = new InputString(email, Message.reqEmail());
			email.parse();

			Form numTel = new Form();
			InputString numTelAgente = new InputString(numTel, Message.reqPhone());
			numTel.parse();

			if((tipoAgente.value()).equals(Message.typePerson())){
				Person p = new Person(entity(), entity().getProximoId(), nomeAgente.value(), 
					   emailAgente.value(), Integer.parseInt(numTelAgente.value()));
				entity().addAgente(p);
			} else {
				Organization o = new Organization(entity(), entity().getProximoId(), nomeAgente.value(), 
						 emailAgente.value(), Integer.parseInt(numTelAgente.value()));
				entity().addAgente(o);
			  }

		} else {

			this.execute();

		 }

	}
}

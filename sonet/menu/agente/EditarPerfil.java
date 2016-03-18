package sonet.menu.agente;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.agent.MenuEntry;
import sonet.textui.agents.Message;

import sonet.core.Agente;

/**
 * Classe que edita o perfil de um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class EditarPerfil extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            o agente alvo.
	 */
	public EditarPerfil(Agente a){
		super(MenuEntry.EDIT_PROFILE, a);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation { 

		Form nome = new Form();
		InputString nomeNovo = new InputString(nome, Message.reqName());
		nome.parse();

		Form email = new Form();
		InputString emailNovo = new InputString(email, Message.reqEmail());
		email.parse();

		Form numTel = new Form();
		InputString numTelNovo = new InputString(numTel, Message.reqPhone());
		numTel.parse();

		entity().setNome(nomeNovo.value());
		entity().setEmail(emailNovo.value());
		entity().setNumTel(Integer.parseInt(numTelNovo.value()));
	}

}

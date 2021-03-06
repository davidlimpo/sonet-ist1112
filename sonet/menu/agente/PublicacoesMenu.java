package sonet.menu.agente;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.agent.MenuEntry;
import sonet.textui.agent.Message;
import sonet.menu.RedeSocialMenuAgente;
import sonet.menu.RedeSocialMenuPublicacao;

import sonet.core.Agente;
import sonet.core.RedeSocial;

/**
 * Classe que acede ao menu das publicacoes de um agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class PublicacoesMenu extends Command<Agente> {

	/** Construtor
	 *
	 *  @param login
	 *	agente a que se refere o comando.
	 */
	public PublicacoesMenu(Agente login){
		super(MenuEntry.OPEN_MENU_PUBLICATIONS, login);
	}

	/**
	 * Executa o comando e acede ao menu das publicacoes de um agente.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		int idVisitado = (entity().getRedeSocial()).getInspeccionado();

		for (Agente visitado: (entity().getRedeSocial()).getAgentes()){

			if (idVisitado == visitado.getId()){

				/* Iniciar a interface de utilizador */
				Menu m = new RedeSocialMenuPublicacao(entity(), visitado);
				m.open();
			}
		}
	}

}

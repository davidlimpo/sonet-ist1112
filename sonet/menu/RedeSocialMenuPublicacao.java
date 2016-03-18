package sonet.menu;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

import sonet.textui.publication.MenuEntry;
import sonet.textui.publication.Message;
import sonet.menu.publicacao.*;

import sonet.core.Publicacao;
import sonet.core.Agente;

import java.util.List;
import java.util.ArrayList;

/**
 * Esta classe trata do Menu da Publicacao.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RedeSocialMenuPublicacao extends Menu{

	/**
	* Construtor
	*
	* @param login
	*		Agente que fez login
	*
	* @param visitado
	*		Agente a ser visitado
	*/
	public RedeSocialMenuPublicacao(Agente login, Agente visitado){
		super(MenuEntry.TITLE, new Command<?>[] {
			new ListarPublicacoes(visitado.getPublicacoes()),
			new MostrarPublicacao(visitado.getPublicacoes()),
			new RegistarPublicacao(visitado),
			new PontuarPublicacao(login, visitado),
			new ComentarPublicacao(login, visitado),
			new ProtegerPublicacao(visitado.getPublicacoes()),
			new ProtegerTodasPublicacoes(visitado.getPublicacoes()),
			new DesprotegerPublicacao(visitado.getPublicacoes()),
			new DesprotegerTodasPublicacoes(login.getPublicacoes())
		});

		/* Esconde as opçoes */
		if((login.getId() != visitado.getId()) && (login.getId() != 0)){
			entry(2).invisible();
			entry(5).invisible();
			entry(6).invisible();
			entry(7).invisible();
			entry(8).invisible();
		}
	}
}	

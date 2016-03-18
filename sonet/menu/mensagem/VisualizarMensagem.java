package sonet.menu.mensagem;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.message.MenuEntry;
import sonet.textui.message.Message;

import sonet.core.Agente;
import sonet.core.Anexo;
import sonet.core.Mensagem;

/**
 * Classe que permite visualizar uma mensagem de um Agente.
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class VisualizarMensagem extends Command<Agente>{

	/** Mensagem que sera visualizada */
	private Mensagem _sms;

	/** 
	 *  Metodo que actuaiza o atributo com a nova mensagem 
	 *  a ser visualizada 
	 *
	 *  @param m
	 *		a mensagem que é visualizada
	 */
	public void setMensagem(Mensagem m){
		_sms = m;
	}

	/** 
	 *  Metodo que devolve a mensagem que esta a ser visualizada
	 *
	 *  @return a mensagem que é visualizada
	 */
	public Mensagem getMensagem(){
		return _sms;
	}

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            agente a que se refere o command.
	 */
	public VisualizarMensagem(Agente a){
		super(MenuEntry.SHOW_MESSAGE, a);
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

		for (Mensagem m: entity().getMensagensEnviadas())
			if ((Integer.parseInt(inputId.value())) == m.getId()){

				Display d = new Display(title());

				d.addNewLine(m.toString());
				d.addNewLine(m.getBody());

				for(Anexo a: m.getAnexos()){

					// Se o anexo é uma mensagem
					if(a.getMensagem() == null)
						d.addNewLine(a.getPublicacao().toString());

					// Se o anexo é uma publicacao
					if(a.getPublicacao() == null)
						d.addNewLine(a.getMensagem().toString());
				}

				d.display();
				setMensagem(m);
			}

		for (Mensagem m: entity().getMensagensRecebidas())
			if ((Integer.parseInt(inputId.value())) == m.getId()){

				Display d = new Display(title());

				d.addNewLine(m.toString());
				d.addNewLine(m.getBody());

				for(Anexo a: m.getAnexos()){

					// Se o anexo é uma mensagem
					if(a.getMensagem() == null)
						d.addNewLine(a.getPublicacao().toString());

					// Se o anexo é uma publicacao
					if(a.getPublicacao() == null)
						d.addNewLine(a.getMensagem().toString());
				}

				d.display();
				setMensagem(m);
			}
	}
}

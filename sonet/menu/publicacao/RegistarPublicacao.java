package sonet.menu.publicacao;

import java.util.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import sonet.textui.publication.MenuEntry;
import sonet.textui.publication.Message;

import sonet.core.Agente;
import sonet.core.Notas;
import sonet.core.Imagem;
import sonet.core.Uri;

/**
 * Classe que permite registar uma nova publicacao
 *
 * @author David Limpo
 * @author Jose Andrade
 * @version 1.0
 */
public class RegistarPublicacao extends Command<Agente>{

	/**
	 * Construtor.
	 * 
	 * @param a
	 *            agente a que se refere o command.
	 */
	public RegistarPublicacao(Agente a){
		super(MenuEntry.REGISTER_PUBLICATION, a);
	}

	/**
	 * Executa o command.
	 * 
	 * @throws InvalidOperation
	 */
	public final void execute() throws InvalidOperation {

		Form f = new Form();
		InputString tipoPublicacao = new InputString(f, Message.reqType());
		f.parse();

		if((tipoPublicacao.value()).equals(Message.typeNote())){ 

			Form legNota = new Form();
			InputString legendaPublicacao = new InputString(legNota, Message.reqLegend());
			legNota.parse();

			Form nota = new Form();
			InputString textoPublicacao = new InputString(nota, Message.reqNoteText());
			nota.parse();

			Notas n = new Notas(entity().getRedeSocial(), (entity().getRedeSocial()).getProximoId(), 
			entity().getId(), legendaPublicacao.value(), textoPublicacao.value());

			entity().addPublicacao(n);

		}else if((tipoPublicacao.value()).equals(Message.typeURI())){ 

			Form legUri = new Form();
			InputString legendaPublicacao = new InputString(legUri, Message.reqLegend());
			legUri.parse();

			Form uri = new Form();
			InputString uriPublicacao = new InputString(uri, Message.reqURI());
			uri.parse();

			Uri u = new Uri(entity().getRedeSocial(), (entity().getRedeSocial()).getProximoId(), 
			entity().getId(), legendaPublicacao.value(), uriPublicacao.value());

			entity().addPublicacao(u);

		}else if((tipoPublicacao.value()).equals(Message.typeImage())){

			Form legImg = new Form();
			InputString legendaPublicacao = new InputString(legImg, Message.reqLegend());
			legImg.parse();


			Form img = new Form();
			InputString imagemPublicacao = new InputString(img, Message.reqImgContents());
			img.parse();

			Imagem i = new Imagem(entity().getRedeSocial(), (entity().getRedeSocial()).getProximoId(),
			entity().getId(), legendaPublicacao.value(), imagemPublicacao.value());

			entity().addPublicacao(i);

		}else
			this.execute();

	}
}

package sonet;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Form;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

import java.io.*;
import sonet.menu.RedeSocialMenuBrowser;
import sonet.textui.browser.Message;
import sonet.core.*;
import java.lang.String;

/**
 * Main do Browser
 * 
 * @author Jose Andrade
 * @author David Limpo
 * @version 1.0
 */
public class Browser {

	/**
	 * 	Metodo Main do Browser
	 * @param args
	 * 
	 */
	public static void main(String[] args){


		/* Criar uma nova forma */
		Form f = new Form();
	    	InputString Ainsp = new InputString(f, Message.login());
	    	f.parse();
		RedeSocial redeS = new RedeSocial("RedeSocial");

		try{
			redeS = redeS.load("sonet.dat");
	      } catch (FileNotFoundException e) {System.out.println("Erro: File not found exception"); } 
		catch (IOException e) {System.out.println("Erro: IO exception");}
		catch (ClassNotFoundException e) { System.out.println("Erro: Class Not Found Exception"); }
		
		if((Integer.parseInt(Ainsp.value())) == 0){
			Person prev = new Person(redeS, 0, "root", "admin@ist.utl.pt", 000);
		}else{
			Agente prev = redeS.getAgente(Integer.parseInt(Ainsp.value()));

		}
		redeS.setInspeccionador(Integer.parseInt(Ainsp.value()));


		/* Iniciar a interface da procura */

		Menu m = new RedeSocialMenuBrowser(redeS);
		m.open();


		try {
			redeS.save("sonet.dat");
		} catch (IOException e) {
			System.out.println("Erro : fail to save browser");
		  }
	}
}

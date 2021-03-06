package sonet.core;

//import sonet.textui.manager.Message;
import sonet.textui.agents.Message;
import sonet.core.*;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

/**
 * Classe que trata da Rede Social
 *
 * @author David Limpo
 * @author José Andrade
 * @version 1.0
 */
public class RedeSocial implements Serializable {

	/** Nome da RedeSocial */
	private String _nome;

	/** Id do Agente Inspeccionador */
	private int _inspeccionador;

	/** Id do Agente Inspeccionado */
	private int _inspeccionado;

	/** Nome ao guardar a RedeSocial */
	private String _save = "RedeS";

	/** Agentes da Rede Social */
	private Map<Integer, Agente> _agentes = new TreeMap<Integer, Agente>();

	private int _id;

	/**
	 * Construtor
	 * 
	 * @param nome
	 *            nome da Rede Social
	 */
	public RedeSocial(String nome){
		_nome = nome;
	}

	/**
	 * Devolve o nome da Rede Social.
	 * 
	 * @return o nome da Rede Social.
	 */
	public final String getNome() {
		return _nome;
	}

	/**
	 * Metodo que adiciona agentes ao TreeMap _agentes
	 * 
	 * @param agente
	 *            agente que vai ser adicionado
	 */
	public void addAgente(Agente agente){
	  	_agentes.put(agente.getId(), agente);
	}

	/**
	 * Metodo que retorna todos os agentes da RedeSocial
	 * 
	 * @return collection com todos os agentes da RedeSocial
	 *
	 */
	public Collection<Agente> getAgentes() {
		return Collections.unmodifiableCollection(_agentes.values());
	}

	/**
	 * Metodo que retorna um agente especifico da RedeSocial
	 * 
	 * @param id 
	 *		id do agente pretendido
	 * @return agente especifico
	 *
	 */
	public Agente getAgente(int id) {
		return _agentes.get(id);
	}

	/**
	 * Metodo que retorna o nome com que a RedeSocial sera gravada
	 * 
	 * @return nome que sera usado no save
	 */
	public String getSave(){
		return _save;
	}

	/**
	 * Metodo que retorna o id do Agente Inspeccionador
	 * 
	 * @return id do agente inspeccionador
	 */
	public int getInspeccionador(){
		return _inspeccionador;
	}

	/**
	 * Metodo que retorna o id do Agente Inspeccionado
	 * 
	 * @return id do agente inspeccionado
	 */
	public int getInspeccionado(){
		return _inspeccionado;
	}

	/**
	 * Metodo que altera o nome com que a RedeSocial sera gravada
	 * 
	 * @param save
	 *		nome que sera usado no save
	 */
	public void setSave(String save){
		_save = save;
	}

	/**
	 * Metodo que define qual é o id do Agente Inspeccionador
	 * 
	 * @param insp
	 *		 id do agente inspeccionador
	 */
	public void setInspeccionador(int insp){
		_inspeccionador = insp;
	}

	/**
	 * Metodo que define qual é o id do Agente Inspeccionado
	 * 
	 * @param insp
	 *		 id do agente inspeccionado
	 */
	public void setInspeccionado(int insp){
		_inspeccionado = insp;
	}

	public int getProximoId(){

		_id++;
		return _id;
	}


	public void parseInputFile(String file) {
	      int lineno = 0;
	      try {
		// Reader in = new InputStreamReader(new FileInputStream("file"), "UTF-8"));
		BufferedReader in = new BufferedReader(new FileReader(file));
		String s;

		while ((s = in.readLine()) != null) {
			String line = new String(s.getBytes(), "UTF-8");
			lineno++;
			String[] split = line.split("\\|");

			if (split[0].equals(Message.typePerson())){
				Agente person = new Person(this, Integer.parseInt(split[1]), split[2], 
					        split[3], Integer.parseInt(split[4]));

				this.addAgente(person);
				_id++;
			}

			else if(split[0].equals(Message.typeOrganization())){
				Agente organization = new Organization(this, Integer.parseInt(split[1]), 
					     	      split[2], split[3], Integer.parseInt(split[4]));

				this.addAgente(organization);
				_id++;
			}
	
			else if(split[0].equals("MESSAGE")){

				Mensagem m = new Mensagem(this, Integer.parseInt(split[1]), Integer.parseInt(split[2]), 
					     "" + Integer.parseInt(split[3]), split[4], split[5]);

				_id++;

				for (Agente a: this.getAgentes()){

					if ((Integer.parseInt(split[2])) == a.getId())
						a.addMensagemEnviada(m);

					if ((Integer.parseInt(split[3])) == a.getId())
						a.addMensagemRecebida(m);

				}
			}

			else if(split[0].equals("NOTE")){

				Notas n = new Notas(this, Integer.parseInt(split[1]), Integer.parseInt(split[2]), 
					  split[3], split[4]);

				for (Agente a: this.getAgentes())

					if ((Integer.parseInt(split[2])) == a.getId())
						a.addPublicacao(n);
				_id++;
			}

			else if(split[0].equals("URI")){
				Uri u = new Uri(this, Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3], split[4]);

				for (Agente a: this.getAgentes())

					if ((Integer.parseInt(split[2])) == a.getId())
						a.addPublicacao(u);

				_id++;
			}

			else if(split[0].equals("IMAGE")){
				Imagem i = new Imagem(this, Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3], split[4]);

				for (Agente a: this.getAgentes())

					if ((Integer.parseInt(split[2])) == a.getId())
						a.addPublicacao(i);
				_id++;
			}

			else if(split[0].equals("CONNECTION")){

				Ligacao lig1 = new Ligacao(this, Integer.parseInt(split[1]), Integer.parseInt(split[2]),
					    Integer.parseInt(split[3]), Integer.parseInt(split[4]));

				Ligacao lig2 = new Ligacao(this, Integer.parseInt(split[2]), Integer.parseInt(split[1]),
					    Integer.parseInt(split[3]), Integer.parseInt(split[4]));


				for (Agente a: this.getAgentes()){
					if ((Integer.parseInt(split[1])) == a.getId()){
						a.addLigacao(lig1);
						if((Integer.parseInt(split[3])) == 0)
							a.addLigacaoPendente(lig1);
						
					}

					if ((Integer.parseInt(split[2])) == a.getId()){
						a.addLigacao(lig2);
						if((Integer.parseInt(split[4])) == 0)
							a.addLigacaoPendente(lig2);
					}
				}
			}
		}


	      } catch (FileNotFoundException e) {
		System.out.println("Erro (file not found):"+file+": "+e);
	      } catch (IOException e) {
		System.out.println("Erro (IO):"+file+":"+lineno+": line "+e);
	      }
	}

	/**
	 * Carrega o estado anterior da aplicacao que estava guardado num
	 * dado ficheiro.
	 *
	 * @param file o nome do ficheiro com os dados serializados.
	 *
	 * @throws IOException caso aconteca algum erro durante a leitura
	 * do estado.
	 * @return um objecto Telele com dados os recuperados do file.
	 **/
	public static RedeSocial load(String file)
	  throws IOException, ClassNotFoundException{
	  ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

	  RedeSocial redeS = (RedeSocial)in.readObject();
	  in.close();

	  return redeS;
	}

	/**
	 * Guarda o estado actual da aplicacao.
	 *
	 * @param file o nome do ficheiro a conter os dados a serializar.
	 *
	 * @throws IOException caso aconteca algum erro durante a gravacao
	 * do estado.
	 **/
	public void save(String file) throws IOException {
	  ObjectOutputStream out =
	    new ObjectOutputStream(new FileOutputStream(file));
	  out.writeObject(this);
	  out.close();
	}


}

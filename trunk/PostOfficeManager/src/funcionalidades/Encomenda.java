package funcionalidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import correios.util.Atendente;

//Última alteração feita em: 27/05/2010
/**
 * Classe para as encomendas, as caracteristicas básicas
 * de uma encomenda normal estão aqui definidas.
 * @author Vinícius Souza
 * @version 1.0
 */

public abstract class Encomenda {
	
	private String dataDeEnvio;
	private String dataDeChegada;
	private String cepRemetente;
	private String cepDestinatario;
	private double peso;
	private Atendente atendente;
	private int chancesDeSerEntregue;
	private double expresso;
	private ArrayList<String> motivosDeFalhaNaEntrega = new ArrayList<String>();
	/* o atributo id eh a identificação de cada encomenda, ela é única
	 * é utilizada ao obter acesso a persistencia e seu valor inteiro
	 * é utilizado como hashCode, por esta razão o método getId() não
	 * existe.
	 */
	private String id;
	
	/**
	 * Construtor da classe
	 * @param String dataDeEnvio - na forma DDmmAA
	 * @param String dataDeChegada - na forma DDmmAA, e caso não tenha sido entregue será ------
	 * @param String cepRemetente - na forma XXXXXXXX
	 * @param String cepDestinatario - na forma XXXXXXXX 
	 * @param double peso - em gramas(g)
	 * @param Atendente atendente - usuário ativo
	 * @param int chancesDeSerEntregue - chances restantes que a correspondencia 
	 * tem antes de ser devolvida ao remetente
	 */
	public Encomenda(String dataDeEnvio, String dataDeChegada, 
			         String cepRemetente, String cepDestinatario,
			         double peso, Atendente atendente, int chancesDeSerEntregue) {
		
		this.dataDeEnvio = dataDeEnvio;
		this.dataDeChegada = dataDeChegada;
		this.cepRemetente = cepRemetente;
		this.cepDestinatario = cepDestinatario;
		this.peso = peso;
		this.atendente = atendente;
		this.chancesDeSerEntregue = chancesDeSerEntregue;
		id = new SimpleDateFormat("ddMMyyHHmmss").format((new GregorianCalendar()).getTime()); 
	}
	
	// ACESSOR METHODS
	
	public Atendente getAtendente() {
		return atendente;
	}
	
	public String getCepDestinatario() {
		return cepDestinatario;
	}
	
	public String getCepRemetente() {
		return cepRemetente;
	}
	
	public int getChancesDeSerEntregue() {
		return chancesDeSerEntregue;
	}
	
	public String getDataDeChegada() {
		return dataDeChegada;
	}
	
	public String getDataDeEnvio() {
		return dataDeEnvio;
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(id);
	}
	
	public ArrayList<String> getMotivosDeFalhaNaEntrega() {
		return motivosDeFalhaNaEntrega;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getExpresso() {
		return expresso;
	}
	
	// OUTROS MÉTODOS
	public abstract double custo();
}
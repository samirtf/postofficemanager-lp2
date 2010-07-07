package correios.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Classe que implementa encomendas simples e com valor declarado.
 * Essa classe tambem eh a superclasse de EncomendaRegistrada e 
 * consequentemente de EncomendaExpressa.
 * @author Marcus Vinicius Souza de Oliveira<br>
 *         Rafael Oliveira Vieira<br>
 *         Samir Trajano Feitosa<br>
 *         Werton Vinicius Guimaraes Gomes
 * @version 2.0
 */
public class Encomenda implements Serializable{

	protected static final long serialVersionUID = 1L;
	protected String cepRemetente, cepDestinatario, dataEnvio, id, atendente, cidade, estado;
	protected double peso, valorDeclarado;
	protected int tentativasDeEntrega=3;
	protected String dataRecebimento = "";
	
	/**
	 * Construtor que nao recebe valor declarado como parametro (Encomendas simples). 
	 * @param cepRemetente - Conjunto de 8 numeros, para formar o CEP do Remetente
	 * @param cepDestinatario - Conjunto de .8 numeros, para formar o CEP do Destinatario
	 * @param dataEnvio - Conjunto de 8 numeros, para formar a data.
	 * @param atendente - nome da(o) atendente.
	 * @param cidade - Nome de uma cidade.
	 * @param estado - Nome de um estado.
	 * @param peso - pega um valor de peso (em gramas).
	 * @throws IllegalArgumentException - quando algum parametro eh invalido.
	 *         TipoDeEncomendaException - Quando o peso ou valor declarado da encomenda, a caracterizam de outro tipo.
	 */
	public Encomenda(String cepRemetente, String cepDestinatario, 
					 String dataEnvio, String atendente,
					 String cidade, String estado,
					 double peso) throws Exception {

		if ((!VerificaDados.verificaCep(cepRemetente)) ||
				(!VerificaDados.verificaCep(cepDestinatario)) ||
				(peso <= 0) ||
				(!VerificaDados.verificaNome(atendente)) ||
				(!VerificaDados.verificaData(dataEnvio)) ||
				(!VerificaDados.verificaEstado(estado)) ||
				(!VerificaDados.verificaNome(cidade))) {
							
				throw new IllegalArgumentException("algum(ns) parametro(s) invalido(s)");
			}
		
		if (peso > 2000) {
			
			throw new TipoDeEncomendaException("tipo errado de encomenda");
		}
		
		this.cepRemetente = cepRemetente;
		this.cepDestinatario = cepDestinatario;
		this.dataEnvio = dataEnvio;
		this.atendente = atendente;
		this.cidade = cidade;
		this.estado = estado;
		this.peso = peso;
		
		/* O id de uma encomenda eh unico. Eh utilizado para acessar os dados persistentes da encomenda.
		 * Na construcao do id da encomenda, o tempo em segundos eh utilizados,logo para que nao haja 
		 * possibilidades de haver dois id's iguais, espera-se 1 segundo.
		 * IMPORTANTE: O id de uma eh baseado na hora e data que foi cadastrado no sistema,
		 * nao na hora que foi entregue ou recebido.
		 */
		id = new SimpleDateFormat("ddMMyyHHmmss").format((new GregorianCalendar()).getTime());
        Thread.sleep(1000);
	}
	
	/**
	 * Construtor que recebe valor declarado como parametro. 
	 * @param cepRemetente - Conjunto de 8 numeros, para formar o CEP do Remetente
	 * @param cepDestinatario - Conjunto de .8 numeros, para formar o CEP do Destinatario
	 * @param dataEnvio - Conjunto de 8 numeros, para formar a data.
	 * @param atendente - nome da(o) atendente.
	 * @param cidade - Nome de uma cidade.
	 * @param estado - Nome de um estado.
	 * @param peso - pega um valor de peso (em gramas).
	 * @param valorDeclarado - Pega o valor Declarado.
	 * @throws IllegalArgumentException - quando algum parametro eh invalido.
	 *         TipoDeEncomendaException - Quando o peso ou valor declarado da encomenda, a caracterizam de outro tipo.
	 */
	public Encomenda(String cepRemetente, String cepDestinatario, 
			 String dataEnvio, String atendente,
			 String cidade, String estado,
			 double peso, double valorDeclarado) throws Exception {
		
		if ((!correios.util.VerificaDados.verificaCep(cepRemetente)) ||
			(!correios.util.VerificaDados.verificaCep(cepDestinatario)) ||
			(peso <= 0) ||
			(!correios.util.VerificaDados.verificaNome(atendente)) ||
			(!correios.util.VerificaDados.verificaData(dataEnvio)) ||
			(valorDeclarado<0) ||
			(!VerificaDados.verificaEstado(estado)) ||
			(!VerificaDados.verificaNome(cidade))) {
				
			throw new IllegalArgumentException("algum(ns) parametro(s) invalido(s)");
		}
		
		if ((peso > 2000) ||
			(valorDeclarado > 500)) {
				
			throw new TipoDeEncomendaException("tipo errado de encomenda");
		}
		
		this.cepRemetente = cepRemetente;
		this.cepDestinatario = cepDestinatario;
		this.dataEnvio = dataEnvio;
		this.atendente = atendente;
		this.cidade = cidade;
		this.estado = estado;
		this.peso = peso;
		this.valorDeclarado = valorDeclarado;
		
		id = new SimpleDateFormat("ddMMyyHHmmss").format((new GregorianCalendar()).getTime());
        Thread.sleep(1000);
	}
		
	//ACCESSOR METHODS
	/**
	 * Retorna o atendente que realizou a operacao
	 * @return String - nome da(o) atendente.
	 */
	public String getAtendente() {
		return atendente;
	}
	/**
	 * Retorna o CEP do destinatario da encomenda.
	 * @return String - CEP
	 */
	public String getCepDestinatario() {
		return cepDestinatario;
	}
	/**
	 * Retorna o CEP do remetente da encomenda.
	 * @return String - CEP
	 */
	public String getCepRemetente() {
		return cepRemetente;
	}
	/**
	 * Retorna a data de envio da encomenda. 
	 * @return String - data
	 */
	public String getDataEnvio() {
		return dataEnvio;
	}
	/**
	 * Se a encomenda jah tiver sido entregue com sucesso,
	 * retornarah a data, caso nao, retornarah <i>null</i>.
	 * @return String - data
	 */
	public String getDataRecebimento() {
		if (dataRecebimento.length()>0) {
			return dataRecebimento;			
		}
		return "";
		
	}
	/**
	 *Se a encomenda possuir um valor declarado, sera retornado
	 * @return o id unico da carta
	 */
	public String getId() {
		return id;
	}
	/**
	 * Retorna o peso da encomenda em gramas.
	 * @return double - peso
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * Retorna o valor declarado de uma encomenda, caso a encomenda nao possuir um valor declarado, retornara 0 (zero).
	 * @return double - valor
	 */
	public double getValorDeclarado() {
		return valorDeclarado;
	}
	/**
	 * Retorna as chances que a encomenda tem de ser entregue.
	 * @return int - chances
	 */
	public int getTentativasDeEntrega() {
		return tentativasDeEntrega;
	}
	/**
	 * Retorna a cidade para onde a encomenda vai ser entregue.
	 * @return String - cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * Retorna o estado para onde a encomenda vai ser entregue.
	 * @return String - estado
	 */
	public String getEstado() {
		return estado;
	}
	
	//OUTROS METODOS
	/**
	 * Diminui o contador de chances da encomenda, se ele chegar a zero, significa que a carta voltou ao destinatario.
	 */
	public void falhouNaEntrega() {
		if (tentativasDeEntrega>0) {
			tentativasDeEntrega--;
		}
	}
	/**
	 * Se uma encomenda for entregue com sucesso. Esse metodo cadastra a hora do recebimento.
	 */
	public void entregouComSucesso() {
		dataRecebimento = new SimpleDateFormat("ddMMyyyy").format((new GregorianCalendar()).getTime());
	}
	/**Calcula o valor da encomenda e o retorna.
	 * Tantos encomendas com valor declarado, 
	 * como as simples.
	 * @return double - valor
	 */
	public double valorDaEncomenda() {
		return 0.75 + (peso/10)*0.2 + (getValorDeclarado()/100); 
	}
	
	@Override
	public String toString() {
		return "id: " + id + "\n" + cidade  + "\n" + estado + "\nCEP destinatario: " + cepDestinatario + "\nCEP remetente: " + cepRemetente + "\n" + String.format("%.0f gramas\nValor: %.2f", peso, valorDaEncomenda());
	}
}
package correios.util;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Encomenda {
	
	protected String cepRemetente, cepDestinatario, dataEnvio, dataRecebimento, id, atendente;
	protected double peso, valorDeclarado;
	protected int tentativasDeEntrega=3;
	
	public Encomenda(String cepRemetente, String cepDestinatario, 
					 String dataEnvio, String atendente, 
					 double peso) throws Exception {
		
		if ((!correios.util.VerificaDados.verificaCep(cepRemetente)) ||
			(!correios.util.VerificaDados.verificaCep(cepDestinatario)) ||
			(peso <= 0) ||
			(!correios.util.VerificaDados.verificaNome(atendente)) ||
			(!correios.util.VerificaDados.verificaData(dataEnvio))) {
			
			throw new IllegalArgumentException("algum(ns) parametro(s) inválido(s)");
		}
		
		if (peso > 2000) {
			
			throw new TipoDeEncomendaException("tipo errado de encomenda");
		}
		
		this.cepRemetente = cepRemetente;
		this.cepDestinatario = cepDestinatario;
		this.dataEnvio = dataEnvio;
		this.atendente = atendente;
		this.peso = peso;
		
		/* O id de uma encomenda é único. É utilizado para acessar os dados persistentes da encomenda.
		 * Na construção do id da encomenda, o tempo em segundos é utilizados,logo para que não haja 
		 * possibilidades de haver dois id's iguais, espera-se 1 segundo.
		 * IMPORTANTE: O id de uma é baseado na hora e data que foi cadastrado no sistema,
		 * não na hora que foi entregue ou recebido.
		 */
		id = new SimpleDateFormat("ddMMyyHHmmss").format((new GregorianCalendar()).getTime());
        Thread.sleep(1000);
	}
	
	public Encomenda(String cepRemetente, String cepDestinatario, 
			 String dataEnvio, String atendente, 
			 double peso, double valorDeclarado) throws Exception {
		
		if ((!correios.util.VerificaDados.verificaCep(cepRemetente)) ||
			(!correios.util.VerificaDados.verificaCep(cepDestinatario)) ||
			(peso <= 0) ||
			(!correios.util.VerificaDados.verificaNome(atendente)) ||
			(!correios.util.VerificaDados.verificaData(dataEnvio)) ||
			(valorDeclarado<0)) {
				
			throw new IllegalArgumentException("algum(ns) parametro(s) inválido(s)");
		}
		
		if ((peso > 2000) ||
			(valorDeclarado > 500)) {
				
			throw new TipoDeEncomendaException("tipo errado de encomenda");
		}
		
		this.cepRemetente = cepRemetente;
		this.cepDestinatario = cepDestinatario;
		this.dataEnvio = dataEnvio;
		this.atendente = atendente;
		this.peso = peso;
		this.valorDeclarado = valorDeclarado;
		
		id = new SimpleDateFormat("ddMMyyHHmmss").format((new GregorianCalendar()).getTime());
        Thread.sleep(1000);
	}
	
	
	//ACCESSOR METHODS
	/**
	 * Retorna o atendente que realizou a operação
	 * @return String - nome da(o) atendente.
	 */
	public String getAtendente() {
		return atendente;
	}
	/**
	 * Retorna o CEP do destinatário da encomenda.
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
	 * Se a encomenda já tiver sido entregue com sucesso,
	 * retornará a data, caso não, retornará <i>null</i>.
	 * @return String - data
	 */
	public String getDataRecebimento() {
		if (dataRecebimento.length()>0) {
			return dataRecebimento;			
		}
		return null;
		
	}
	/**Se a encomenda possuir um valor declarado, será retornado
	 * Retorna o id único da carta
	 * @return
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
	 * Retorna o valor declarado de uma encomenda, caso a encomenda não possuir um valor declarado, retornará 0 (zero).
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
	 * Diminui o contador de chances da encomenda, se ele chegar a zero, significa que a carta voltou ao destinátario.
	 */
	public void falhouNaEntrega() {
		if (tentativasDeEntrega>0) {
			tentativasDeEntrega--;
		}
	}
	/**
	 * Se uma encomenda for entregue com sucesso. Esse método cadastra a hora do recebimento.
	 */
	public void entregouComSucesso() {
		dataRecebimento = new SimpleDateFormat("ddMMyyyy").format((new GregorianCalendar()).getTime());
	}
	/**Exception
	 * Calcula o valor da encomenda e o retorna.
	 * Tantos encomendas com valor declarado, 
	 * como as simples.
	 * @return double - valor
	 */
	public double valorDaEncomenda() {
		return 0.75 + (peso/10)*0.2 + (getValorDeclarado()/100); 
	}
}

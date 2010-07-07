package correios.util;

/**
 * Classe que implementa comportamento de encomendas registradas.
 * @author Marcus Vinicius Souza de Oliveira
 *         Rafael Oliveira Vieira
 *         Samir Trajano Feitosa
 *         Werton Vinicius Guimaraes Gomes
 */
public class EncomendaRegistrada extends Encomenda {
	protected String codigoDeRegistro;
	
	/**
	 * Encomenda Registrada com valor declarado.
	 * @param cepRemetente - Conjunto de 8 numeros, para formar o CEP do Remetente
	 * @param cepDestinatario - Conjunto de .8 numeros, para formar o CEP do Destinatario
	 * @param dataEnvio - Conjunto de 8 numeros, para formar a data.
	 * @param atendente - nome da(o) atendente.
	 * @param cidade - Nome de uma cidade.
	 * @param estado - Nome de um estado.
	 * @param peso - pega um valor de peso (em gramas).
	 * @param valorDeclarado - pega um valor declarado
	 * @throws IllegalArgumentException - quando algum parâmetro é inválido.
	 *         TipoDeEncomendaException - Quando o peso ou valor declarado da encomenda, a caracterizam de outro tipo.
	 */
	public EncomendaRegistrada(String cepRemetente, String cepDestinatario,	
			String dataEnvio, String atendente, String cidade, String estado, double peso, double valorDeclarado) throws Exception {
		super(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso, valorDeclarado);
		codigoDeRegistro = "PB" + getId().substring(3,12) + "BR";

	}
	/**
	 * Encomenda registrada sem valor declarado.
	 * @param cepRemetente - Conjunto de 8 numeros, para formar o CEP do Remetente
	 * @param cepDestinatario - Conjunto de .8 numeros, para formar o CEP do Destinatario
	 * @param dataEnvio - Conjunto de 8 numeros, para formar a data.
	 * @param atendente - nome da(o) atendente.
	 * @param cidade - Nome de uma cidade.
	 * @param estado - Nome de um estado.
	 * @param peso - pega um valor de peso (em gramas).
	 * @throws IllegalArgumentException - quando algum parâmetro é inválido.
	 *         TipoDeEncomendaException - Quando o peso ou valor declarado da encomenda, a caracterizam de outro tipo.
	 */
	public EncomendaRegistrada(String cepRemetente, String cepDestinatario,
			String dataEnvio, String atendente, String cidade, String estado, double peso) throws Exception {
		super(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
		codigoDeRegistro = "PB" + getId().substring(3,12) + "BR";
	}
	
	/**
	 * Retorna o codigo de registro de uma encomenda.
	 * @return String - código de registro
	 */
	public String getCodigoDeRegistro() {
		return codigoDeRegistro;
	}
	
	/**Calcula o valor da encomenda registrada e o retorna.
	 * Tantos encomendas com valor declarado, 
	 * como as simples.
	 * @return double - valor
	 */
	@Override
	public double valorDaEncomenda() {
		return 1.4 + (peso/10)*0.2 + (getValorDeclarado()/100);
	}
	
	@Override
	public String toString() {
		return "id: " + id + "\n" + cidade  + "\n" + estado + "\nCEP destinatario: " + cepDestinatario + "\nCEP remetente: " + cepRemetente + "\n" + String.format("%.0f gramas\nValor: %.2f", peso, valorDaEncomenda()) + "\n" + getCodigoDeRegistro();
	}
}

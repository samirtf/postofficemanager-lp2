package correios.util;

/**
 * Classe que implementa comportamento de encomendas registradas.
 * @author Vinícius Souza
 */
public class EncomendaRegistrada extends Encomenda {
	protected String codigoDeRegistro;
	
	/**
	 * Encomenda Registrada com valor declarado.
	 * @param String - cepRemetente
	 * @param String - cepDestinatario
	 * @param String - dataEnvio
	 * @param String - nome da(o) atendente
	 * @param String - cidade
	 * @param String - estado
	 * @param double - peso (em gramas)
	 * @param double - valor declarado
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
	 * @param String - cepRemetente
	 * @param String - cepDestinatario
	 * @param String - dataEnvio
	 * @param String - nome da(o) atendente
	 * @param String - cidade
	 * @param String - estado
	 * @param double - peso (em gramas)
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
}

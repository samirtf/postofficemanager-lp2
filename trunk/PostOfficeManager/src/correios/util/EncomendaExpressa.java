package correios.util;
/**
 * 
 * @author Marcus Vinicius Souza de Oliveira
 *         Rafael Oliveira Vieira
 *         Samir Trajano Feitosa
 *         Werton Vinicius Guimaraes Gomes
 *
 */

public class EncomendaExpressa extends EncomendaRegistrada{
	
	/**
	 * Encomenda expressa sem valor declarado.
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
	public EncomendaExpressa(String cepRemetente, String cepDestinatario, String dataEnvio, 
			String atendente, String cidade, String estado, double peso) throws Exception {
		super(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
		
	}
	/**
	 * Encomenda expressa com valor declarado.
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
	public EncomendaExpressa(String cepRemetente, String cepDestinatario, String dataEnvio, 
			String atendente, String cidade, String estado, double peso, double valorDeclarado) throws Exception {
		super(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso, valorDeclarado);
		
	}
	
	/**
	 * Calcula o valor da encomenda expressa.
	 * return double - valor
	 */
	@Override
	public double valorDaEncomenda() {
		double envio = 10 + 1.5*(peso/100);
		if (valorDeclarado>500) {
			return ((envio + valorDeclarado)*5)/100;
		}
		return envio + valorDeclarado/100;
	} 
}

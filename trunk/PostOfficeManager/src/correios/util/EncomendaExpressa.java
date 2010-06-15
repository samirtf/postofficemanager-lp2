package correios.util;

public class EncomendaExpressa extends EncomendaRegistrada{
	
	/**
	 * Encomenda expressa sem valor declarado.
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
	public EncomendaExpressa(String cepRemetente, String cepDestinatario, String dataEnvio, 
			String atendente, String cidade, String estado, double peso) throws Exception {
		super(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
		
	}
	/**
	 * Encomenda expressa com valor declarado.
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

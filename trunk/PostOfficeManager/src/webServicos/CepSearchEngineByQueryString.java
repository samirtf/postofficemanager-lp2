package webServicos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


/**
 * Ferramenta de busca de CEP, atrav�s de Query String, que encapsula os resultados da
 * pesquisa em um {@link WebServiceCep}, consulte a sua documenta��o para informa��es 
 * de como os dados da pesquisa s�o passados.
 * <BR>
 * <BR>Constroi um objeto {@link WebServiceCep} com os dados Query String encapsulados, 
 * a partir da chamada do m�todo estatico
 * {@link CepSearchEngineByQueryString#searchCep(String)}.
 * <BR>
 * <BR>Objeto contem todas as informa��es do CEP, al�m de informa��es referente ao
 * resultado da pesquisa.
 * <BR>
 * <BR>Esta ferramenta independe de API externa ao pacote java.*; podendo ser usada 
 * independente de outras bibliotecas.
 * <BR>
 * <BR>Exemplo de uso:
 * <BR><tt>{@link WebServiceCep} cep = 
 * {@link CepSearchEngineByQueryString}.searchCep("13345-325");
 * 
 * <BR>//caso a busca ocorra bem, imprime os resultados.
 * <BR>if (cep.wasSuccessful()) {
 * <BR>&nbsp; &nbsp; System.out.println("Cep: "+cep.getCep());
 * <BR>&nbsp; &nbsp; System.out.println("Logradouro: "+cep.getLogradouroFull());
 * <BR>&nbsp; &nbsp; System.out.println("Bairro: "+cep.getBairro());
 * <BR>&nbsp; &nbsp; System.out.println("Cidade: "+
 * 			cep.getCidade()+"/"+ cep.cep());
 * <BR>//caso haja problemas imprime o c�digo e msg de erro.
 * <BR>} else {
 * <BR>&nbsp; &nbsp; System.out.println("Erro n�mero: " + cep.getResulCode());
 * <BR>&nbsp; &nbsp; System.out.println("Descri��o do erro: " + cep.getResultText());
 * <BR>}
 * <BR></tt>
 * <BR>A resposta do console seria:
 * <BR><tt>
 * <BR>Cep: 13345325
 * <BR>Logradouro: Rua Cinco
 * <BR>Bairro: Jardim R�mulo Zoppi
 * <BR>Cidade: Indaiatuba/SP
 * <BR></tt>
 * <BR>Last Revision: 01/10/2009
 * @see WebServiceCep
 * @see CepSearchEngineByQueryString
 * @author Tomaz Lavieri
 * @since 01/09/09
 * @version 1.01
 */
public final class CepSearchEngineByQueryString {
	/**
     * Mascara para a string url de conex�o, onde <tt>"%s"</tt> � substituido pelo valor
     * do cep. 
     */
	private static final String URL_STRING_QUERY = 
		"http://cep.republicavirtual.com.br/web_cep.php?cep=%s&formato=query_string";
	/**
	 * Adciona o cep a url padr�o e l� a Query String resposta do servidor da 
	 * republicavirtual.com.br.
	 * @param	cep objeto {@link WebServiceCep} com a informa��o do cep j� inclusa, 
	 * 			resgata atrav�s de {@link WebServiceCep#getCep()}
	 * @return	Query String com os caracters especiais <tt>"ISO-8859-1"</tt>
	 * 			c�dificados. 
	 * @throws	IOException Exce��es geradas por problema de conex�o, ou de acesso e
	 * 			leitura da {@link URL}
	 */
	private static String loadUrl(WebServiceCep cep) throws IOException {
	    URL url = new URL(
	    		String.format(URL_STRING_QUERY, cep.getCep()));
        BufferedReader reader = new BufferedReader(
        		new InputStreamReader(url.openStream()));  
        String queryString = reader.readLine();  
        reader.close(); 
        return queryString;
	}
	/**
	 * Decodifica a Query String passada no parametro, transformado os caracters 
	 * especieis c�dificados em caracters n�o codificados.
	 * @param queryString query string codificada
	 * @return query string decodifcada.
	 */
	private static String decoderQueryString(String queryString) {
		try {
			queryString = URLDecoder.decode(queryString,"ISO-8859-1");
		} catch (Exception e) {}
		return queryString;
	}
	/**
	 * Quebra a string j� decodificada mapeando cada Property key com seu respectivo
	 * valor em um {@link Map} de onde � possivel resgatar cada valor, apenas informando
	 * a chave da Property.
	 * @param	decoderQueryString Query String com seus caracters especiais j� 
	 * 			decodificada.
	 * @return	{@link Map} das Properties (propriedades) onde � possivel resgatar o 
	 * 			valor de cada Property especifica apenas com a sua chave.
	 */
	private static Map<String,String> getProperties(String decoderQueryString) {
		String[] properties = decoderQueryString.split("&");
		Map<String,String> propertiesMap = new HashMap<String,String>();
		String[] property = null;
		//first "&" (properties[0]) == "" 
		for (int i = 1; i < properties.length; i++) {
			property = properties[i].split("=");
			propertiesMap.put(property[0].toLowerCase(), property[1]);
		}
		return propertiesMap;
	}
	/**
	 * Carrega os dados do mapa de Properties para o objeto {@link WebServiceCepImpl}
	 * passado no parametro.
	 * @param	cep Obejeto {@link WebServiceCepImpl} onde os dados do mapa de
	 * 			propriedades devem ser carregado. 
	 * @param	properties {@link Map} de propriedades que ser�o carregados no objeto
	 * 			{@link WebServiceCepImpl}.
	 */
	private static void loadWebServiceCepQueryString(
			WebServiceCepImpl cep,Map<String,String> properties) {
		
		cep.setBairro(properties.get("bairro"));
		cep.setCidade(properties.get("cidade"));
		cep.setLogradouro(properties.get("logradouro"));
		cep.setLogradouroType(properties.get("tipo_logradouro"));
		cep.setResulCode(Integer.valueOf(properties.get("resultado")));
		cep.setResultText(properties.get("resultado_txt"));
		cep.setUf(properties.get("uf"));
	}
	/**
	 * Faz uma busca, via <tt>Query String</tt> a partir do cep enviado, no site 
	 * <a href="http://www.republicavirtual.com.br" 
	 * target="_blank">republicavirtual.com.br</a>, retornando o resultado em um objeto
	 * {@link WebServiceCep}.
	 * <BR>
	 * <BR>Para maiores informa��es dos dados dipoiniveis do resultado da pesquisa, 
	 * consulte a documenta��o de {@link WebServiceCep}
	 * <BR>
	 * <BR>N�o se faz necess�rio formata��es, a string pode ser enviada em qualquer
	 * formata��o, pois s� ser�o consideradas os primeiros 8 numeros da string.
	 * <BR>Por Exemplo:
	 * <BR>Uma <tt>{@link String} "14.568-910"</tt> � automaticamente passada para
	 * <tt>"14568910"</tt>.
	 * <BR>Uma <tt>{@link String} "1%4#5?55%16a8&910"</tt> � automaticamente passada para
	 * <tt>"14555168"</tt>, s� levando em conta os primeiros 8 n�meros.
	 * @param	cep N�mero do cep a ser carregado. S� ser�o considerados os primeiros 8 
	 * 			n�meros da {@link String} enviada. Todos os caracters n�o num�ricos ser�o
	 * 			removidos, e a string ser� truncada caso seja maior que 8 caracters.
	 * @return {@link WebServiceCep} contendo as informa��es da pesquisa.
	 */
	public static WebServiceCep searchCep(String cep) {
		WebServiceCepImpl searchCep = new WebServiceCepImpl(cep);
		try {
			String decoderQueryString = decoderQueryString(loadUrl(searchCep));
			loadWebServiceCepQueryString(searchCep, getProperties(decoderQueryString));
		} catch(IOException ex) {
			if (ex.getMessage() != null && ex.getMessage()
					.contains("HTTP response code: 403")) {
				searchCep.setResulCode(-18);
				searchCep.setResultText("Acesso negado IP bloqueado, uso abusivo");
			}
		} catch(Exception ex) {
			
		}
		return searchCep;
	}
	
	/**
	 * A ferramenta de busca n�o deve ser instanciada, funciona apenas com m�todos
	 * est�ticos.
	 * 
	 * @see #searchCep(String)
	 */
	private CepSearchEngineByQueryString() {}
}


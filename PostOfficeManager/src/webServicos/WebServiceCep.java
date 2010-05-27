package webServicos;

/**
 * Interface de consulta contendo os dados encapsulados da busca no site
 * <a href="http://www.republicavirtual.com.br" 
 * target="_blank">republicavirtual.com.br</a>. 
 * <BR>
 * <BR>Consulte as classes de <i>Search Engine</i> {@link CepSearchEngineByQueryString}
 * e {@link CepSearchEngineByXML}, para saber como recuperar os
 * dados do CEP do site.
 * <BR>
 * <BR>Last Revision: 01/10/2009 (US Data)
 * 
 * @see CepSearchEngineByQueryString
 * @see CepSearchEngineByXML
 * @see SearchEngineResults
 * @author Tomaz Lavieri
 * @since 01/10/09
 * @version 1.01
 */
public interface WebServiceCep {
	
	/* PUBLIC m�todos get e is, usado para acessar o objeto ap�s carregado. */
	/**
	 * {@link SearchEngineResults} contendo o resultado da opera��o, de onde pode-se 
	 * consultar tanto a msg do resultado, como o seu c�digo. Use os m�todos
	 * {@link SearchEngineResults#getCode()} e {@link SearchEngineResults#getMessage()}
	 * para a consulta.
	 * @return {@link SearchEngineResults} contendo o resultado da opera��o.
	 */
	public SearchEngineResults getResult();
	/**
	 * Informa o c�digo do resultado da pesquisa.
	 * <BR>C�digos conhecidos:
	 * <BR><tt>-1</tt> : busca n�o realizada
	 * <BR><tt>0</tt> : cep n�o encontrado
	 * <BR><tt>1</tt> : cep econtrado
	 * <BR><tt>-14</tt> : Site n�o encontrado (pode ser por problemas na internet).
	 * <BR><tt>-15</tt> : N�o foi possivel ler o documento xml
	 * <BR><tt>-16</tt> : Erro na forma��o da url
	 * <BR><tt>-17</tt> : Erro inesperado
	 * 
	 * 
	 * @return <tt>int</tt> C�digo do resultado.
	 */
	public int getResulCode();
	/**
	 * Informa��o textual sobre o resultado da pesquisa
	 * @return {@link String} contendo a descri��o do resultado da pesquisa.
	 */
	public String getResultText();
	/**
	 * Informa se o cep foi encontrado com sucesso.
	 * @return	<tt>true</tt> - caso a pesquisa ache um resultado no banco.
	 * 			<BR><tt>false</tt> - caso haja falhas, ou o cep enviado n�o esteja 
	 * 			cadastrado.
	 */
	public boolean wasSuccessful();
	/**
	 * Informa se n�o existe o cep cadastrado.
	 * @return	<tt>true</tt> - Caso o cep n�o tenha cido encontrado.
	 * 			<BR><tt>false</tt> - Caso haja falhas, ou caso o cep esteja cadastrado.
	 */
	public boolean isCepNotFound();
	/**
	 * Informa se houve falhas na busca do cep
	 * @return	<tt>true</tt> - Caso ocorra falhas
	 * 			<BR><tt>false</tt> - Caso n�o haja falhas.
	 */
	public boolean hasException();
	/**
	 * Pega a exce��o que ocorreu durante a busca, retorna null caso n�o haja exce��es.
	 * @return	<tt>{@link Exception}</tt> - Caso ocorra falhas
	 * 			<BR><tt>null</tt> - Caso n�o haja falhas.
	 */
	public Exception getException();
	/**
	 * Informa o bairro
	 * @return {@link String} contendo o nome bairro
	 */
	public String getBairro();
	/**
	 * Informa a cidade
	 * @return {@link String} contendo o nome da Cidade
	 */
	public String getCidade();
	/**
	 * Informa a Unidade Federativa
	 * @return {@link String} contendo o nome da Unidade Federativa
	 */
	public String getUf();
	/**
	 * Informa o logradouro.
	 * @return {@link String} contendo o nome do Logradouro
	 */
	public String getLogradouro();
	/**
	 * Informa o logradouro junto com o tipo de logradouro.
	 * @return {@link String} contendo o tipo de Logradouro + nome do Logradouro.
	 */
	public String getLogradouroFull();
	/**
	 * Informa o tipo do logradouro.
	 * @return {@link String} contendo o tipo de logradouuro.
	 */
	public String getLogradouroType();
	/**
	 * Informa o cep.
	 * @return {@link String} contendo o cep.
	 */
	public String getCep();
}


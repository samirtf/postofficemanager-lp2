package webServicos;

/**
 * 
 * @author Tomaz Lavieri
 * @version 1.01
 * @since 01/10/09
 */
final class WebServiceCepImpl implements WebServiceCep {
	
	
	
/* Campos internos de resultado da busca */
	
	private int resulCode = -1;
	private String resultText = "busca não realizada.";
	private String cep = null;
	private String bairro = null;
	private String cidade = null;
	private String logradouro = null;
	private String logradouroType = null;
	private String uf = null;
	private Exception exception;
	
	/**
	 * Visibilidade default para que seja invocado apenas dentro do pacote
	 * pelas Engines de busca do sistema de CEP.
	 * 
	 * @see CepSearchEngineByQueryString#searchCep(String)
	 * @see CepSearchEngineByXML#searchCep(String)
	 * @param cep String contendo o n�mero do CEP, s� ser�o considerados os 8 primeiros
	 * 		  n�meros da {@link String} enviada.
	 * 		  <BR>todos os caracters n�o n�mericos
	 * 		  ser�o apagados, juntamento com os digitos ap�s a oitava casa.
	 */
    WebServiceCepImpl(String cep) {
    	cep = cep.replaceAll( "\\D*", "" ); //To numeric digits only
		if (cep.length() > 8)
			cep = cep.substring(0, 8);
    	this.cep = cep;
    }
    
    /**
	 * Exce��es lan�adas pelas engines de busca.
	 * <BR>Este m�todo tem visibilidade default pois deve ser acessado apenas pelas
	 * @param ex {@link Exception} lan�ada pela engine de busca.
	 */
    void setExceptio(Exception ex) {
		this.exception = ex;
	}
	
/* PRIVATE m�todos set, usados pela classe Xml para setar o objeto CepWebService */
	/**
	 * Ajusta o valor da cidade deste objeto.
	 * <BR>Este m�todo tem visibilidade default pois deve ser acessado apenas pelas
	 * Engines de busca.
	 * @param cidade {@link String} com o novo valor para cidade.
	 */
    void setCidade(String cidade) {
		this.cidade = cidade;
	}
    
    /**
	 * Ajusta o valor do bairro deste objeto.
	 * <BR>Este m�todo tem visibilidade default pois deve ser acessado apenas pelas
	 * Engines de busca.
	 * @param bairro {@link String} com o novo valor para bairro.
	 */
    void setBairro(String bairro) {
		this.bairro = bairro;
	}
    
    /**
	 * Ajusta o valor do Tipo de Logradouro deste objeto.
	 * <BR>Este m�todo tem visibilidade default pois deve ser acessado apenas pelas
	 * Engines de busca.
	 * @param logradouroType {@link String} com o novo valor para cidade.
	 */
    void setLogradouroType(String logradouroType) {
		this.logradouroType = logradouroType;
	}
    
    /**
	 * Ajusta o valor do logradouro deste objeto.
	 * <BR>Este m�todo tem visibilidade default pois deve ser acessado apenas pelas
	 * Engines de busca.
	 * @param logradouro {@link String} com o novo valor para logradouro.
	 */
    void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
    
    /**
	 * Ajusta o valor do resultado deste objeto.
	 * <BR>Este m�todo tem visibilidade default pois deve ser acessado apenas pelas
	 * Engines de busca.
	 * @param resultado <tt>int</tt> com o novo valor para resultado.
	 */
    void setResulCode(int resultado) {
		this.resulCode = resultado;
	}
    
    /**
	 * Ajusta o valor do texto do resultado deste objeto.
	 * <BR>Este m�todo tem visibilidade default pois deve ser acessado apenas pelas
	 * Engines de busca.
	 * @param resultado_txt {@link String} com o novo valor para o texto do resultado.
	 */
    void setResultText(String resultado_txt) {
		this.resultText = resultado_txt;
	}
    
    /**
	 * Ajusta o valor da unidade federativa deste objeto.
	 * <BR>Este m�todo tem visibilidade default pois deve ser acessado apenas pelas
	 * Engines de busca.
	 * @param uf {@link String} com o novo valor para unidade federativa.
	 */
    void setUf(String uf) {
		this.uf = uf;
	}
	
/* PUBLIC m�todos get e is, usado para acessar o objeto ap�s carregado. */
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
	public int getResulCode() {
		return resulCode;
	}
	
	/**
	 * Recupera o resultado da SearchEngine.
	 * @return
	 * 		O resultado da SearchEngine.
	 */
	public SearchEngineResults getResult() {
		return SearchEngineResults.valueOf(getResulCode());
	}
	
	/**
	 * Informa��o textual sobre o resultado da pesquisa
	 * @return {@link String} contendo a descri��o do resultado da pesquisa.
	 */
	public String getResultText() {
		return resultText;
    }
	
	/**
	 * Informa se o cep foi encontrado com sucesso.
	 * @return	<tt>true</tt> - caso a pesquisa ache um resultado no banco.
	 * 			<BR><tt>false</tt> - caso haja falhas, ou o cep enviado n�o esteja 
	 * 			cadastrado.
	 */
	public boolean wasSuccessful() {
		return (resulCode == 1 && exception == null);
	}
	
	/**
	 * Informa se n�o existe o cep cadastrado.
	 * @return	<tt>true</tt> - Caso o cep n�o tenha cido encontrado.
	 * 			<BR><tt>false</tt> - Caso haja falhas, ou caso o cep esteja cadastrado.
	 */
	public boolean isCepNotFound() {
		return (resulCode == 0);
	}
	
	/**
	 * Informa se houve falhas na busca do cep
	 * @return	<tt>true</tt> - Caso ocorra falhas
	 * 			<BR><tt>false</tt> - Caso não haja falhas.
	 */
	public boolean hasException() {
		return (exception != null);
	}
	
	/**
	 * Pega a exceção que ocorreu durante a busca, retorna null caso n�o haja exce��es.
	 * @return	<tt>{@link Exception}</tt> - Caso ocorra falhas
	 * 			<BR><tt>null</tt> - Caso n�o haja falhas.
	 */
	public Exception getException() {
		return exception;
	}
	
	/**
	 * Informa o bairro
	 * @return {@link String} contendo o nome bairro
	 */
	public String getBairro() {
		return bairro;
	}
	
	/**
	 * Informa a cidade
	 * @return {@link String} contendo o nome da Cidade
	 */
	public String getCidade() {
		return cidade;
	}
	
	/**
	 * Informa a Unidade Federativa
	 * @return {@link String} contendo o nome da Unidade Federativa
	 */
	public String getUf() {
		return uf;
	}
	
	/**
	 * Informa o logradouro.
	 * @return {@link String} contendo o nome do Logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}
	
	/**
	 * Informa o logradouro junto com o tipo de logradouro.
	 * @return {@link String} contendo o tipo de Logradouro + nome do Logradouro.
	 */
	public String getLogradouroFull() {
		return (logradouro == null || logradouroType ==null) ? null : 
			logradouroType + " " + logradouro; 
	}
	
	/**
	 * Informa o tipo do logradouro.
	 * @return {@link String} contendo o tipo de logradouuro.
	 */
	public String getLogradouroType() {
		return logradouroType;
	}
	
	/**
	 * Informa o cep.
	 * @return {@link String} contendo o cep.
	 */
	public String getCep() {
		return cep;
	}
}


package webServicos;

/**
 * Resultado da operacao de busca realizada pelas <i>Search Engine</i> encapsulado junto
 * a interface {@link WebServiceCep}, contendo codigo e mensagem do resultado.
 * <BR>
 * <BR>O {@link SearchEngineResults} pode ser consultado atraves da interface via
 * {@link WebServiceCep#getResult()}.
 * <BR>
 * <BR>Last Revision: 01/10/2009
 * @see CepSearchEngineByQueryString
 * @see WebServiceCep
 * @author Tomaz Lavieri
 * @version 1.00
 * @since 01/10/2009
 */
public enum SearchEngineResults {
	/**
	 * Result 1: Cep encontrado com sucesso.
	 */
	R1 {
		@Override public int getCode() {
			return 1;
		}
		@Override public String getMessage() {
			return "Cep encontrado.";
		}
	},
	/**
	 * Result 0: Busca realizada, porém Cep não encontrado.
	 */
	R0 {
		@Override public int getCode() {
			return 0;
		}
		@Override public String getMessage() {
			return "Cep não encontrado.";
		}
	},
	/**
	 * Result Negative 1: Busca não realizada
	 */
	RN1 {
		@Override public int getCode() {
			return -1;
		}
		@Override public String getMessage() {
			return "Busca não realizada.";
		}
	},
	/**
	 * Result Negative 14: Site não encontrado.
	 */
	RN14 {
		@Override public int getCode() {
			return -14;
		}
		@Override public String getMessage() {
			return "Site não encontrado.";
		}
	},
	/**
	 * Result Negative 15: Problema de leitura do documento xml.
	 */
	RN15 {
		@Override public int getCode() {
			return -15;
		}
		@Override public String getMessage() {
			return "Problemas durante a leitura do documento xml.";
		}
	},
	/**
	 * Result Negative 16: Problemas na estrutura do link URL.
	 */
	RN16 {
		@Override public int getCode() {
			return -16;
		}
		@Override public String getMessage() {
			return "Erro na formação da url.";
		}
	},
	/**
	 * Result Negative 17: Erro desconhecido
	 */
	RN17 {
		@Override public int getCode() {
			return -17;
		}
		@Override public String getMessage() {
			return "Erro inesperado e desconhecido.";
		}
	},
	/**
	 * Result Negative 18: HTTP response code: 403, acesso negada a URL, provav�l abuso
	 * no uso do link.
	 */
	RN18 {
		@Override public int getCode() {
			return -18;
		}

		@Override public String getMessage() {
			return "Server returned HTTP response code: 403 for URL";
		}
		
	}
	;
	/**
	 * Busca o valor do c�digo do erro.
	 * @return <tt>int</tt> contendo o c�digo do erro.
	 */
	abstract public int getCode();
	/**
	 * Mensage de erro.
	 * @return {@link String} busca a msg padrao de erro deste enum.
	 */
	abstract public String getMessage();
	/**
	 * Acha o resultado correspondente ao c�digo enviado.
	 * @param code c�digo do resultado.
	 * @return {@link SearchEngineResults} correspondente ao c�digo.
	 */
	public static SearchEngineResults valueOf(int code) {
		SearchEngineResults valueOf;
		try {
			if (code >=0)
				valueOf = SearchEngineResults.valueOf("R" + code);
			else
				valueOf = SearchEngineResults.valueOf("RN" + code);
		} catch (IllegalArgumentException ex) {
			valueOf = RN17;
		}
		
		return valueOf;
	}
}


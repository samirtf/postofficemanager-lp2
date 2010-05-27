package webServicos;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.dom4j.*;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Ferramenta de busca de CEP, atrav�s de XML, que encapsula os resultados da pesquisa
 * em um {@link WebServiceCep}, consulte a sua documenta��o para informa��es de como
 * os dados da pesquisa s�o passados.
 * <BR>
 * <BR>Constroi um objeto {@link WebServiceCep} com os dados XML encapsulados, a 
 * partir da chamada do m�todo estatico {@link CepSearchEngineByXML#searchCep(String)}.
 * <BR>
 * <BR>Objeto contem todas as informa��es do CEP, al�m de informa��es referente ao
 * resultado da pesquisa.
 * <BR>
 * <BR>Esta ferramente depende diretamente do pacote <tt>dom4j-1.6.1</tt> para fazer o 
 * parse dos arquivos XML. O pacote <tt>dom4j-1.6.1</tt> pode ser encontrado em 
 * <a href="http://www.dom4j.org/dom4j-1.6.1/download.html" target="_blank">dom4j.org</a>
 * <BR>
 * <BR>Exemplo de uso:
 * <BR><tt>{@link WebServiceCep} cep = 
 * {@link CepSearchEngineByXML}.searchCep("13345-325");
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
public final class CepSearchEngineByXML {
	
/* Classes Internas, que auxiliam na busca do CEP */
	/**
	 * Enumeration para setar os parametros do XML, cada constante conhece o seu m�todo
	 * correspondente, invocando a partir de um atalho comum
	 * {@link Xml#setCep(String, CepSearchEngineByXML)}.
	 * @author Tomaz Lavieri
	 */
	private enum Xml {
		CIDADE {
			@Override
			public void setCep(String text, WebServiceCepImpl webServiceCepXml) {
				webServiceCepXml.setCidade(text);
			}
		}, 
		BAIRRO {
			@Override
			public void setCep(String text, WebServiceCepImpl webServiceCepImpl) {
				webServiceCepImpl.setBairro(text);
			}
		},
		TIPO_LOGRADOURO {
			@Override
			public void setCep(String text, WebServiceCepImpl webServiceCepImpl) {
				webServiceCepImpl.setLogradouroType(text);
			}
		},
		LOGRADOURO {
			@Override
			public void setCep(String text, WebServiceCepImpl webServiceCepImpl) {
				webServiceCepImpl.setLogradouro(text);
			}
		},
		RESULTADO {
			@Override
			public void setCep(String text, WebServiceCepImpl webServiceCepImpl) {
				webServiceCepImpl.setResulCode(Integer.parseInt(text));
			}
		},
		RESULTADO_TXT {
			@Override
			public void setCep(String text, WebServiceCepImpl webServiceCepImpl) {
				webServiceCepImpl.setResultText(text);
			}
		},
		UF {
			@Override
			public void setCep(String text, WebServiceCepImpl webServiceCepImpl) {
				webServiceCepImpl.setUf(text);
			}
		}
		;
		/**
		 * Seta o texto enviado no parametro <tt>text</tt> no objeto
		 * {@link CepSearchEngineByXML} no seu parametro correspondente. Cada constante do 
		 * enum conhece o seu parametro a passar.
		 * @param text {@link String} contendo o texto a ser inserido.
		 * @param webServiceCepXml {@link CepSearchEngineByXML} referencia do objeto para 
		 * 		  inserir o parametro text.
		 */
		public abstract void setCep(String text,WebServiceCepImpl webServiceCepXml);
	}
	/**
	 * Classe utilit�ria apenas encapsula o Iterator de elements da root dentro de um
	 * Iterable, para ser usado dentro de um for.
	 * @see Iterable
	 * @see Iterator
	 * @author Tomaz Lavieri
	 */
	private static final class IterableElement implements Iterable<Element> {
		private Iterator<Element> itr;
		
		@SuppressWarnings("unchecked")
		public IterableElement(Iterator<?> itr) {
			this.itr = (Iterator<Element>)itr;
		}
		@Override
		public Iterator<Element> iterator() {
			return itr;
		}
	}
/* M�todos e variaveis estaticas, respons�veis pela busca do CEP */
    /**
     * Mascara para a string url de conex�o, onde <tt>"%s"</tt> � substituido pelo valor
     * do cep. 
     */
	private static final String URL_STRING_XML = 
		"http://cep.republicavirtual.com.br/web_cep.php?cep=%s&formato=xml";
    /**
     * Carrega o Documento xml a partir do CEP enviado.
     * @param cep n�mero do cep.
     * @return {@link Document} xml WebService do site Republic Virtual
     * @throws DocumentException Quando h� problema na forma��o do documento XML.
     * @throws MalformedURLException Quando a h� problema no link url.
     */
	private static Document getDocument(String cep) 
			throws DocumentException, MalformedURLException {
		URL url = new URL(String.format(URL_STRING_XML, cep));
		SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
	}
	/**
	 * Retorna o elemento principal (root) da arvore XML.
     * @param cep n�mero do cep.
	 * @return {@link Element} principal (root) da arvore XML.
     * @throws DocumentException Quando h� problema na forma��o do documento XML.
     * @throws MalformedURLException Quando a h� problema no link url.
	 */
	private static Element getRootElement(String cep) 
			throws DocumentException, MalformedURLException {
		return getDocument(cep).getRootElement();
	}
	/**
	 * Encapsula os elementos XML dentro de um objeto
	 * <tt>{@link Iterable}<{@link Element}></tt> podendo ser recuperados um a um dentro
	 * de um for
	 * <BR>
	 * <BR>Por exemplo:
	 * <BR><tt>for (Element e : getElements(cep)) {
	 * <BR>//...
	 * <BR>}
     * @param cep n�mero do cep.
	 * @return
     * @throws DocumentException Quando h� problema na forma��o do documento XML.
     * @throws MalformedURLException Quando a h� problema no link url.
	 */
	private static IterableElement getElements(String cep) 
			throws DocumentException, MalformedURLException {
		return new IterableElement(getRootElement(cep).elementIterator());
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
		WebServiceCepImpl loadCep = new WebServiceCepImpl(cep);
		try {
			for (Element e : getElements(loadCep.getCep()))
				Xml.valueOf(e.getQualifiedName().toUpperCase())
				.setCep(e.getText(), loadCep);
		} catch (DocumentException ex) {
			if (ex.getNestedException() != null && ex.getNestedException() 
					instanceof java.net.UnknownHostException) {
				loadCep.setResultText("Site n�o encontrado.");
				loadCep.setResulCode(-14);
			} else {
				loadCep.setResultText("N�o foi possivel ler o documento xml.");
				loadCep.setResulCode(-15);
			}
			loadCep.setExceptio(ex);
		} catch (MalformedURLException ex) {
			loadCep.setExceptio(ex);
			loadCep.setResultText("Erro na forma��o da url.");
			loadCep.setResulCode(-16);
		} catch (Exception ex) {
			loadCep.setExceptio(ex);
			loadCep.setResultText("Erro inesperado.");
			loadCep.setResulCode(-17);
		}
		return loadCep;
	}
	
	/**
	 * A ferramenta de busca n�o deve ser instanciada, funciona apenas com m�todos
	 * est�ticos.
	 * 
	 * @see #searchCep(String)
	 */
    private CepSearchEngineByXML() {}
	
}

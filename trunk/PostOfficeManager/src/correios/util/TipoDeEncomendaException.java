package correios.util;

/**
 * Excecao utilizada para indicar erros de tipo de encomenda.
 * Por exemplo, quando o peso ou valor declarado de uma Encomenda,
 * a obrigarem a ser de um outro tipo.
 * 
   * @author
  * 	Marcus Vinicius Souza de Oliveira<br>
  * 	Rafael O. Vieira<br>
  * 	Samir Trajano Feitosa<br>
  * 	Werton Vinicius Guimaraes Gomes
  * 
  */
public class TipoDeEncomendaException extends Exception {

	public TipoDeEncomendaException(String mensagem) {
		super(mensagem);
	}
	
	public TipoDeEncomendaException() {
		super();
	}
}
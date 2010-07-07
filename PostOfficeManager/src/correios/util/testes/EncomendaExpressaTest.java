package correios.util.testes;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import correios.util.EncomendaExpressa;

/**
 * 
 * @author Marcus Vinicius Souza de Oliveira
 *         Rafael Oliveira Vieira
 *         Samir Trajano Feitosa
 *         Werton Vinicius Guimaraes Gomes
 */
public class EncomendaExpressaTest {
	
	private EncomendaExpressa encomenda;
	
	@Before
	public void zeraEncomenda() {
		encomenda = null;
	}
	
	@Test
	public void testaValorSimples() throws Exception {
		encomenda = new EncomendaExpressa("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300);
		Assert.assertEquals("valor errado - 1", 14.5, encomenda.valorDaEncomenda(), 0);
	}
	
	@Test
	public void testaValorDeclarado() throws Exception {
		encomenda = new EncomendaExpressa("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300, 300);
		Assert.assertEquals("valor errado - 2", 17.5, encomenda.valorDaEncomenda(), 0);
	}

}

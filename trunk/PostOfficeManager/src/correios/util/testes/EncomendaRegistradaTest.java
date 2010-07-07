package correios.util.testes;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import correios.util.EncomendaRegistrada;
/**
 * 
 * @author Marcus Vinicius Souza de Oliveira
 *         Rafael Oliveira Vieira
 *         Samir Trajano Feitosa
 *         Werton Vinicius Guimaraes Gomes
 *
 */

public class EncomendaRegistradaTest {
	
	
	private EncomendaRegistrada encomenda;
	
	@Before
	public void zeraEncomenda() {
		encomenda = null;
	}
	
	@Test
	public void testaRegistro() throws Exception {
		encomenda = new EncomendaRegistrada("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300);
		String codigoDeRegistro = encomenda.getCodigoDeRegistro();
		Assert.assertTrue("Numero de caracteres errados", codigoDeRegistro.length()==13);
		for (int i=0; i<5; i++) {
			Assert.assertFalse("Codigos de registro iguais", codigoDeRegistro.equals(new EncomendaRegistrada( "58000000","58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300)));
		}
	}
	
	@Test
	public void testaValorSimples() throws Exception {
		encomenda = new EncomendaRegistrada("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300);
		Assert.assertEquals("valor errado - 1", 7.4, encomenda.valorDaEncomenda(), 0);
	}
	
	@Test
	public void testaValorDeclarado() throws Exception {
		encomenda = new EncomendaRegistrada("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300, 300);
		Assert.assertEquals("valor errado - 2", 10.4, encomenda.valorDaEncomenda(), 0);
	}

}

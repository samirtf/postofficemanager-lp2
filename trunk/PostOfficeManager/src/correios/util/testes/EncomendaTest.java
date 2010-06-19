package correios.util.testes;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import correios.util.Encomenda;


public class EncomendaTest {
	
	private Encomenda encomenda;
	
	@Before
	public void zeraEncomenda() {
		encomenda = null;
	}
	
	@Test
	public void construtorTest() {
		try {
			encomenda = new Encomenda("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300);
		} catch (Exception e) {
			Assert.fail("A encomenda estava comos parametros certos");
		}
		
		try {
			encomenda = new Encomenda("5800000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300);
		} catch (Exception e) {
			Assert.assertEquals("Parametro invalido - 1", "algum(ns) parametro(s) inválido(s)", e.getMessage());
		}
		
		try {
			encomenda = new Encomenda("58000000", null, "11062010", "Fulano", "Campina Grande", "Paraiba", 300);
		} catch (Exception e) {
			Assert.assertEquals("Parametro invalido - 2", "algum(ns) parametro(s) inválido(s)", e.getMessage());
		}
		
		try {//Data inválida: formato certo ddMMaaaa
			encomenda = new Encomenda("5800000", "58999999", "110610", "Fulano", "Campina Grande", "Paraiba", 300);
		} catch (Exception e) {
			Assert.assertEquals("Parametro invalido - 3", "algum(ns) parametro(s) inválido(s)", e.getMessage());
		}
		
		try {
			encomenda = new Encomenda("5800000", "58999999", "11062010", null, "Campina Grande", "Paraiba", 300);
		} catch (Exception e) {
			Assert.assertEquals("Parametro invalido - 4", "algum(ns) parametro(s) inválido(s)", e.getMessage());
		}
		
		try {
			encomenda = new Encomenda("5800000", "58999999", "11062010", "Fulano", null, "Paraiba", 300);
		} catch (Exception e) {
			Assert.assertEquals("Parametro invalido - 5", "algum(ns) parametro(s) inválido(s)", e.getMessage());
		}
		
		try {
			encomenda = new Encomenda("5800000", "58999999", "11062010", "Fulano", "Campina Grande", "", 300);
		} catch (Exception e) {
			Assert.assertEquals("Parametro invalido - 6", "algum(ns) parametro(s) inválido(s)", e.getMessage());
		}
		
		try {
			encomenda = new Encomenda("5800000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 0);
		} catch (Exception e) {
			Assert.assertEquals("Parametro invalido - 7", "algum(ns) parametro(s) inválido(s)", e.getMessage());
		}
		
		try {
			encomenda = new Encomenda("5800000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 3000);
		} catch (Exception e) {
			Assert.assertEquals("Tipo errado de encomenda - 1", "tipo errado de encomenda", e.getMessage());
		}
		
		try {
			encomenda = new Encomenda("5800000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300, 600);
		} catch (Exception e) {
			Assert.assertEquals("Tipo errado de encomenda - 2", "tipo errado de encomenda", e.getMessage());
		}
	}
	
	@Test
	public void atributosTest() throws Exception {
		//Testa os accesor methods
		encomenda = new Encomenda("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300, 300);
		Assert.assertEquals("Erro de atributo - 1", "58000000", encomenda.getCepRemetente());
		Assert.assertEquals("Erro de atributo - 2", "58999999", encomenda.getCepDestinatario());
		Assert.assertEquals("Erro de atributo - 3", "11062010", encomenda.getDataEnvio());
		Assert.assertEquals("Erro de atributo - 4", "Fulano", encomenda.getAtendente());
		Assert.assertEquals("Erro de atributo - 5", "Campina Grande", encomenda.getCidade());
		Assert.assertEquals("Erro de atributo - 6", "Paraiba", encomenda.getEstado());
		Assert.assertEquals("Erro de atributo - 7", 300.0, encomenda.getPeso());
		Assert.assertEquals("Erro de atributo - 8", 300.0, encomenda.getValorDeclarado());
		
	}
	
	@Test
	public void testaID() throws Exception {
		encomenda = new Encomenda("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300, 300);
		for (int i = 5; i<5; i++) {
			Assert.assertFalse("O id ficou igual", encomenda.equals(new Encomenda("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300, 300)));
		}
	}
	
	@Test
	public void testaEntrega() throws Exception {
		encomenda = new Encomenda("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300, 300);
		Assert.assertEquals("Numero de tentativas errado - 1", 3, encomenda.getTentativasDeEntrega());
		encomenda.falhouNaEntrega();
		Assert.assertEquals("Numero de tentativas errado - 2", 2, encomenda.getTentativasDeEntrega());
		encomenda.falhouNaEntrega();
		Assert.assertEquals("Numero de tentativas errado - 3", 1, encomenda.getTentativasDeEntrega());
		Assert.assertEquals("A encomenda foi entregue - 1", "", encomenda.getDataRecebimento());
		encomenda.entregouComSucesso();
		Assert.assertFalse("A encomenda nao foi entregue - 1", encomenda.getDataRecebimento().equals(""));
		
	}
	
	@Test
	public void testaValorSimples() throws Exception {
		encomenda = new Encomenda("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300);
		Assert.assertEquals("valor da encomenda errado - 1", 6.75, encomenda.valorDaEncomenda(), 0);
	}
	
	@Test
	public void testaValorDeclarado() throws Exception {
		encomenda = new Encomenda("58000000", "58999999", "11062010", "Fulano", "Campina Grande", "Paraiba", 300, 300);
		Assert.assertEquals("valor da encomenda errado - 2", 9.75, encomenda.valorDaEncomenda(), 0);
	}
}

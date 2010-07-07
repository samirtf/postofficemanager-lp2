package correios.util.testes;

import junit.framework.Assert;
import correios.util.Agencia;
import correios.util.Encomenda;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Marcus Vinicius Souza de Oliveira
 *         Rafael Oliveira Vieira
 *         Samir Trajano Feitosa
 *         Werton Vinicius Guimaraes Gomes
 */
public class AgenciaTest {
	
	Agencia agencia1, agencia2, agencia5, agencia6;
	@Before
	public void setUp() throws Exception {
		try{
			agencia1 = new Agencia("eu");
			agencia2 = new Agencia("Bo");
			agencia6 = new Agencia("EU");
		} catch (Exception e) {
			agencia5 = new Agencia("Ze Ninguem");
		}
	}

	@Test
	public void testGetAtendenteAtivo() {
		Assert.assertEquals("Erro na primeira agencia", "eu", agencia1.getnomeDoAtendente());
		Assert.assertEquals("Erro na segunda agencia", "Bo", agencia2.getnomeDoAtendente());
		Assert.assertTrue("Erro na sexta agencia",agencia6.getnomeDoAtendente().toLowerCase().equals(agencia1.getnomeDoAtendente()));
	}
	@Test
	public void addEncomendas() throws Exception {
		try{
			//Deixa o ArrayList vazio
			agencia1.getEncomendas().clear(); //limpa todos de emcomenda 
			
			agencia1.addEncomenda(new Encomenda("12345678", "58780000", "21062010",agencia1.getnomeDoAtendente(), "Itaporanga", "PB", 500));
			agencia1.addEncomenda(new Encomenda("erro no cep", "58780000", "12062010",agencia1.getnomeDoAtendente(), "Itaporanga", "PB", 500));
			System.out.println("Isso nao deve ser impresso");
		} catch (Exception e) {
			agencia1.addEncomenda(new Encomenda("12345678", "45678904", "20062010",agencia1.getnomeDoAtendente(), "Patos", "PB", 300));
		}
	}
	
	@Test
	public void testGetEncomendas() {
		//quantidade armazenada
		Assert.assertEquals("Erro na quantidade de encomendas", 2, agencia1.getEncomendas().size());
		//testa os atendentes armazenados
		Assert.assertEquals("Erro no nome do atendente1", "eu", agencia1.getEncomendas().get(0).getAtendente());
		Assert.assertEquals("Erro no nome do atendente2", "eu", agencia1.getEncomendas().get(1).getAtendente());
		//Testas os CEPs destinarios armazenados
		Assert.assertEquals("Erro no CEP destinatario1", "58780000", agencia1.getEncomendas().get(0).getCepDestinatario());
		Assert.assertEquals("Erro no CEP destinatario2", "45678904", agencia1.getEncomendas().get(1).getCepDestinatario());
		//Testa os CEPs remetentes armazenados
		Assert.assertEquals("Erro no CEP remetente1", "12345678", agencia1.getEncomendas().get(0).getCepRemetente());
		Assert.assertEquals("Erro no CEP remetente2", "12345678", agencia1.getEncomendas().get(1).getCepRemetente());
		//Testa a cidade
		Assert.assertEquals("Erro na Cidade", "Itaporanga", agencia1.getEncomendas().get(0).getCidade());
		Assert.assertEquals("Erro na Cidade2", "Patos", agencia1.getEncomendas().get(1).getCidade());
		//Testa a data de envio
		Assert.assertEquals("Erro na Data", "21062010", agencia1.getEncomendas().get(0).getDataEnvio());
		Assert.assertEquals("Erro na Data2", "20062010", agencia1.getEncomendas().get(1).getDataEnvio());
		//Testa Estado das encomendas armazendas
		Assert.assertEquals("Erro no Estado", "PB", agencia1.getEncomendas().get(0).getEstado());
		Assert.assertEquals("Erro no Estado2", "PB", agencia1.getEncomendas().get(1).getEstado());
		
		//Testa as outras agencias		
		Assert.assertEquals("Erro no total de agencias2", 2, agencia2.getEncomendas().size());
		
	}

	@Test
	public void testGetEncomendasCidade() {
		Assert.assertEquals("Erro no total de cidade1", 0, agencia1.getEncomendasCidade("Ita").size());
		Assert.assertEquals("Erro no total de cidade2", 1, agencia1.getEncomendasCidade("Itaporanga").size());
		Assert.assertEquals("Erro no total de cidade3", 1, agencia1.getEncomendasCidade("Patos").size());
	}

	@Test
	public void testGetEncomendasEstado() {
		Assert.assertEquals("Erro no total de Estado1", 2, agencia1.getEncomendasEstado("PB").size());
		Assert.assertEquals("Erro no total de Estado2", 0, agencia1.getEncomendasEstado("Paraiba").size());
	}

	@Test
	public void testGetEncomendasCEPDestinatario() throws Exception {
		Assert.assertEquals("Erro no total de CEPdestinatario", 0, agencia1.getEncomendasCEPDestinatario("53625343").size());
		Assert.assertEquals("Erro no total de CEPdestinatario2", 1, agencia1.getEncomendasCEPDestinatario("58780000").size());
	}

	@Test
	public void testGetEncomendasCEPRemetente() {
		Assert.assertEquals("Erro no total de CEPremetente", 0, agencia1.getEncomendasCEPDestinatario("53625343").size());
		Assert.assertEquals("Erro no total de CEPremetente", 0, agencia1.getEncomendasCEPDestinatario("53625343").size());
	}

	@Test
	public void testGetEncomendasDataEnvio() {
		Assert.assertEquals("Erro na data de envio", 0, agencia1.getEncomendasDataEnvio("10122010").size());
		Assert.assertEquals("Erro na data de envio", "21062010", agencia1.getEncomendasDataEnvio("21062010").get(0).getDataEnvio());
	}

}

package webServicos.testes;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import webServicos.BancoDeDadosCepServico;
import webServicos.Cep;
import webServicos.CepSearchEngineByQueryString;
import webServicos.WebServiceCep;

public class BancoDeDadosCepServicoTeste {
	Cep cep1;
	Cep cep2;
	Cep cep3;
	BancoDeDadosCepServico correiosBD;
	@Before
	public void setUpClass() throws Exception {
		try{
			cep1 = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
			cep2 = new Cep("62700001", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
			cep3 = new Cep("62700002", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
			correiosBD = new BancoDeDadosCepServico();
			
			//TODO remover testa conexao para outro lugar
			//correiosBD.testaConexaoInternet();
		}
		catch(Exception e){
			System.out.println("ERRO: " + e.getMessage() + e);
		}
    }

    @After
    public void tearDownClass() throws Exception {
    }
    
    @Test
    public void testaAdicCepAoBancoDeDados(){
    	System.out.println("testaAdicCepAoBancoDeDados");
    	Assert.assertTrue(correiosBD.adicCepAoBancoDeDados(cep1));
    	Assert.assertTrue(correiosBD.adicCepAoBancoDeDados(cep2));
    	Assert.assertFalse(correiosBD.adicCepAoBancoDeDados(cep1));
    	Assert.assertFalse(correiosBD.adicCepAoBancoDeDados(cep2));
    	Assert.assertTrue(correiosBD.adicCepAoBancoDeDados(cep3));
    	Assert.assertEquals(correiosBD.getMapaBD().size(), 3);
    	
    	//verificando o tamanho atual do BD
    	System.out.println(correiosBD.getMapaBD().size());
    	
    	//Verificando CEP 62700000
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700000").getCep(), "62700000");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700000").getLogradouro(), "Av. Francisco C. Campos");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700000").getBairro(), "Monte");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700000").getCidade(), "Caninde");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700000").getUf(), "CE");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700000").getChave(), true);
    	
    	//verificando CEP 62700001
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700001").getCep(), "62700001");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700001").getLogradouro(), "Av. Francisco C. Campos");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700001").getBairro(), "Monte");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700001").getCidade(), "Caninde");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700001").getUf(), "CE");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700001").getChave(), true);
    	
    	//verificando CEP 62700002
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700002").getCep(), "62700002");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700002").getLogradouro(), "Av. Francisco C. Campos");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700002").getBairro(), "Monte");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700002").getCidade(), "Caninde");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700002").getUf(), "CE");
    	Assert.assertEquals(correiosBD.getMapaBD().get("62700002").getChave(), true);

    }// fim do teste do metodo adicCepAoBancoDeDados
    
    @Test
    public void testaTotalRegistrosBancoDeDados(){
    	System.out.println("totalRegistrosBancoDeDados");
    	Assert.assertEquals(correiosBD.totalRegistrosBancoDeDados(), 3);
    }// fim do teste do metodo totalRegistrosBancoDeDados
    
    @Test
    public void testaPesquisaCepNoBancoDeDadosLocal() throws IOException{
    	System.out.println("pesquisaCepNoBancoDeDadosLocal");
    	Assert.assertTrue(correiosBD.pesquisaCepNoBancoDeDadosLocal("62700000"));
    	Assert.assertTrue(correiosBD.pesquisaCepNoBancoDeDadosLocal("62700001"));
    	Assert.assertTrue(correiosBD.pesquisaCepNoBancoDeDadosLocal("62700002"));
    	Assert.assertFalse(correiosBD.devoCadastrarCepNoBancoDeDados("62700000"));
    }// fim do teste do metodo pesquisaCepNoBancoDeDadosLocal
    
    @Test
    public void testaPesquisaCepBancoDeDadosOnline(){
    	Assert.assertFalse(correiosBD.pesquisaCepBancoDeDadosOnline("00000000"));
    	Assert.assertFalse(correiosBD.pesquisaCepBancoDeDadosOnline("62700000"));
    }
    
    @Test
    public void testadelCepDoBancoDeDados(){
    	System.out.println("testaDelCepAoBancoDeDados");
    	Assert.assertTrue(correiosBD.delCepDoBancoDeDados(cep1));
    	Assert.assertTrue(correiosBD.delCepDoBancoDeDados(cep2));
    	Assert.assertFalse(correiosBD.delCepDoBancoDeDados(cep1));
    	Assert.assertFalse(correiosBD.delCepDoBancoDeDados(cep2));
    	Assert.assertTrue(correiosBD.delCepDoBancoDeDados(cep3));
    	Assert.assertEquals(correiosBD.getMapaBD().size(), 0);
    	
    	Assert.assertFalse(correiosBD.pesquisaCepNoBancoDeDadosLocal("62700000"));
    	Assert.assertFalse(correiosBD.pesquisaCepNoBancoDeDadosLocal("62700001"));
    	Assert.assertFalse(correiosBD.pesquisaCepNoBancoDeDadosLocal("62700002"));

    }// fim do teste do metodo delCepDoBancoDeDados.
    
    @Test
    public void testaDevoCadastrarCepNoBancoDeDados() throws IOException{
    	Assert.assertTrue(correiosBD.devoCadastrarCepNoBancoDeDados("62700000"));
    }// fim do teste do metodo devoCadastrarCepNoBancoDeDados.
    
    //13345325
    
    @Test
    public void testaRecuperaCepBancoDeDadosOnline() throws Exception{
    	System.out.println("recuperaCepBancoDeDadosOnline");
    	WebServiceCep cep = CepSearchEngineByQueryString.searchCep("13345325");
		Cep recupCep = correiosBD.recuperaCepBancoDeDadosOnline("13345325");
    	
		Assert.assertEquals("13345325", recupCep.getCep());
		Assert.assertEquals("Cinco", recupCep.getLogradouro());
		Assert.assertEquals("Jardim Remulo Zoppi", recupCep.getBairro());
		Assert.assertEquals("Indaiatuba", recupCep.getCidade());
		Assert.assertEquals("SP", recupCep.getUf());
		Assert.assertEquals(true, recupCep.getChave());
    	
    }
	
	
}

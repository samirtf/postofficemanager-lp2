package webServicos.testes;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webServicos.Cep;

/**
 *
 * @author Samir Trajano Feitosa 20921299
 */
public class CepTeste {

    public CepTeste() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    /**
     * Teste de erros no construtor
     */
    @Test
    public void testaErrosNoConstrutor(){
    	try{
    		Cep instance = new Cep(null, "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
    		Assert.fail("Esperava mensagem de Cep invalido.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Cep invalido.", e.getMessage());
    	}// teste para cep nulo
    	
    	try{
    		Cep instance = new Cep("", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
    		Assert.fail("Esperava mensagem de Cep invalido.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Cep invalido.", e.getMessage());
    	}// teste para cep vazio
    	
    	try{
    		Cep instance = new Cep("62700000", null, "Monte", "Caninde", "CE", "true");
    		Assert.fail("Esperava mensagem de Logradouro invalido.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Logradouro invalido.", e.getMessage());
    	}// teste para logradouro nulo
    	
    	try{
    		Cep instance = new Cep("62700000", "", "Monte", "Caninde", "CE", "true");
    		Assert.fail("Esperava mensagem de Logradouro invalido.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Logradouro invalido.", e.getMessage());
    	}// teste para logradouro vazio
    	
    	try{
    		Cep instance = new Cep("62700000", "Av. Francisco C. Campos", null, "Caninde", "CE", "true");
    		Assert.fail("Esperava mensagem de Bairro invalido.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Bairro invalido.", e.getMessage());
    	}// teste para bairro nulo
    	
    	try{
    		Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "", "Caninde", "CE", "true");
    		Assert.fail("Esperava mensagem de Bairro invalido.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Bairro invalido.", e.getMessage());
    	}// teste para bairro vazio
    	
    	try{
    		Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", null, "CE", "true");
    		Assert.fail("Esperava mensagem de Cidade invalido.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Cidade invalida.", e.getMessage());
    	}// teste para cidade nulo
    	
    	try{
    		Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "", "CE", "true");
    		Assert.fail("Esperava mensagem de Cidade invalida.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Cidade invalida.", e.getMessage());
    	}// teste para cidade vazio
    	
    	try{
    		Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", null, "true");
    		Assert.fail("Esperava mensagem de UF invalida.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("UF invalida.", e.getMessage());
    	}// teste para estado nulo
    	
    	try{
    		Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "", "true");
    		Assert.fail("Esperava mensagem de UF invalida.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("UF invalida.", e.getMessage());
    	}// teste para estado vazio
    	
    	try{
    		Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", null);
    		Assert.fail("Esperava mensagem de Chave invalida.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Chave invalida.", e.getMessage());
    	}// teste para chave nulo
    	
    	try{
    		Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "");
    		Assert.fail("Esperava mensagem de Chave invalida.");
    	}
    	catch(Exception e){
    		Assert.assertEquals("Chave invalida.", e.getMessage());
    	}// teste para chave vazio
    	
    }

    /**
     * Teste do método getCep, da classe Cep.
     */
    @Test
    public void testGetCep() throws Exception {
        System.out.println("getCep");
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        String expResult = "62700000";
        String result = instance.getCep();
        assertEquals(expResult, result);
        
    }

    /**
     * Teste do método getLogradouro, da classe Cep.
     */
    @Test
    public void testGetLogradouro() throws Exception {
        System.out.println("getLogradouro");
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        String expResult = "Av. Francisco C. Campos";
        String result = instance.getLogradouro();
        assertEquals(expResult, result);
        
    }

    /**
     * Teste do método getBairro, da classe Cep.
     */
    @Test
    public void testGetBairro() throws Exception {
        System.out.println("getBairro");
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        String expResult = "Monte";
        String result = instance.getBairro();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getCidade, da classe Cep.
     */
    @Test
    public void testGetCidade() throws Exception {
        System.out.println("getCidade");
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        String expResult = "Caninde";
        String result = instance.getCidade();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getUf, da classe Cep.
     */
    @Test
    public void testGetUf() throws Exception {
        System.out.println("getUf");
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        String expResult = "CE";
        String result = instance.getUf();
        assertEquals(expResult, result);
    }

    /**
     * Teste de método getChave, da classe Cep.
     */
    @Test
    public void testGetChave() throws Exception {
        System.out.println("getChave");
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        boolean expResult = true;
        boolean result = instance.getChave();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setCep, da classe Cep.
     */
    @Test
    public void testSetCep() throws Exception {
        System.out.println("setCep");
        String cep = "";
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        instance.setCep(cep);
    }

    /**
     * Teste do método setLogradouro, da classe Cep.
     * @throws Exception 
     */
    @Test
    public void testSetLogradouro() throws Exception {
        System.out.println("setLogradouro");
        String logradouro = "Avenida Francisco C. Campos";
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        instance.setLogradouro(logradouro);
        assertEquals(logradouro, instance.getLogradouro());
    }

    /**
     * Teste do método setBairro, da classe Cep.
     * @throws Exception 
     */
    @Test
    public void testSetBairro() throws Exception {
        System.out.println("setBairro");
        String bairro = "Monte Carlos";
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        instance.setBairro(bairro);
        assertEquals(bairro, instance.getBairro());
    }

    /**
     * Teste do metodo setCidade, da classe Cep.
     * @throws Exception 
     */
    @Test
    public void testSetCidade() throws Exception {
        System.out.println("setCidade");
        String cidade = "Cannis";
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        instance.setCidade(cidade);
        assertEquals(cidade, instance.getCidade());
    }

    /**
     * Teste do metodo setUf da classe Cep.
     * @throws Exception 
     */
    @Test
    public void testSetUf() throws Exception {
        System.out.println("setUf");
        String uf = "";
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        instance.setUf(uf);
        assertEquals(uf, instance.getUf());
    }

    /**
     * Teste do metodo setChave, da classe Cep.
     * @throws Exception 
     */
    @Test
    public void testSetChave() throws Exception {
        System.out.println("setChave");
        boolean chave = false;
        Cep instance = new Cep("62700000", "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
        instance.setChave(chave);
        assertEquals(chave, instance.getChave());
    }

}

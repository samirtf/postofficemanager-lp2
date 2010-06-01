package webServicos.testes;

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
     */
    @Test
    public void testSetLogradouro() {
        System.out.println("setLogradouro");
        String logradouro = "";
        Cep instance = null;
        instance.setLogradouro(logradouro);
    }

    /**
     * Test of setBairro method, of class Cep.
     */
    @Test
    public void testSetBairro() {
        System.out.println("setBairro");
        String bairro = "";
        Cep instance = null;
        instance.setBairro(bairro);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCidade method, of class Cep.
     */
    @Test
    public void testSetCidade() {
        System.out.println("setCidade");
        String cidade = "";
        Cep instance = null;
        instance.setCidade(cidade);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUf method, of class Cep.
     */
    @Test
    public void testSetUf() {
        System.out.println("setUf");
        String uf = "";
        Cep instance = null;
        instance.setUf(uf);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChave method, of class Cep.
     */
    @Test
    public void testSetChave() {
        System.out.println("setChave");
        boolean chave = false;
        Cep instance = null;
        instance.setChave(chave);
        fail("The test case is a prototype.");
    }

}

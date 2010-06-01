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

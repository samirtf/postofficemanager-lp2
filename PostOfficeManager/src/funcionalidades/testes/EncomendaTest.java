package funcionalidades.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EncomendaTest {

    private Encomenda encomenda1;
    private Encomenda encomenda2;
    private Encomenda encomenda3;


    private String cepDest = "58800000";
    private String cepRem = "58890000";
    private String data = "020510";
    private double peso = 1.2;
    private String atendente1 = "Sharlene";
    private String atendente2 = "Shirley";
    private double valorDeclarado1 = 100;
    private double valorDeclarado2 = 600;

    @Before
    public void setUp() throws Exception {
        encomenda1 = new Encomenda(cepRem, cepDest, data, peso, atendente1, valorDeclarado2);
        encomenda2 = new Encomenda(cepRem, cepDest, data, peso + 1, atendente2);
        encomenda3 = new Encomenda(cepRem, cepDest, data, peso, atendente1, valorDeclarado1);
    }

    @After
    public void tearDown() {
    	encomenda1 = null;
    }


    @Test
    public void testGetCEPremetente() {
        assertEquals("cep do remetente errado", cepRem, encomenda3.getCEPremetente());
    }


    @Test
    public void testGetCEPdestinatario() {
        assertEquals("cep do destinatario errado", cepDest, encomenda3.getCEPdestinatario());
    }


    @Test
    public void testGetPeso() {
        assertEquals("peso errado 1", 1.2, encomenda1.getPeso(), 0);
        assertEquals("peso errado 2", 2.2, encomenda2.getPeso(), 0);
    }


    @Test
    public void testGetViaExpressa() {
        assertTrue("deveria ser via expressa 1", encomenda1.getViaExpressa());
        assertTrue("deveria ser via expressa 2", encomenda2.getViaExpressa());
        assertFalse("não deveria ser via expressa 3", encomenda3.getViaExpressa());

    }


    @Test
    public void testGetAtendente() {
        assertEquals("atendente errado 1", "Sharlene", encomenda1.getAtendente());
        assertEquals("atendente errado 2", "Shirley", encomenda2.getAtendente());
        assertEquals("atendente errado 3", "Sharlene", encomenda3.getAtendente());
    }


    @Test
    public void testConfirmaViaExpressa() {
        assertFalse("não deveria ser via expressa 4", encomenda3.getViaExpressa());
        encomenda3.ConfirmaViaExpressa();
        assertTrue("deveria ser via expressa 5", encomenda3.getViaExpressa());
    }


    @Test
    public void testGetValorDeclarado() {
        
    }

    /**
     * Test of getData method, of class Encomenda.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Encomenda instance = null;
        String expResult = "";
        String result = instance.getData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValorDaEncomenda method, of class Encomenda.
     */
    @Test
    public void testValorDaEncomenda() {
        System.out.println("ValorDaEncomenda");
        Encomenda instance = null;
        double expResult = 0.0;
        double result = instance.ValorDaEncomenda();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnviadas method, of class Encomenda.
     */
    @Test
    public void testGetEnviadas() {
        System.out.println("getEnviadas");
        Encomenda instance = null;
        int expResult = 0;
        int result = instance.getEnviadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enviaCarta method, of class Encomenda.
     */
    @Test
    public void testEnviaCarta() {
        System.out.println("enviaCarta");
        Encomenda instance = null;
        String expResult = "";
        String result = instance.enviaCarta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Encomenda.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Encomenda instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
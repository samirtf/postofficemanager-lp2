package funcionalidades.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

import funcionalidades.Encomenda;


/*
 * autor: Vinícius Souza 
 */
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
    public void tearDown() throws Exception {
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
        encomenda3.confirmaViaExpressa();
        assertTrue("deveria ser via expressa 5", encomenda3.getViaExpressa());
    }


    @Test
    public void testGetValorDeclarado() {
        assertEquals("valor declarado errado 1", valorDeclarado2, encomenda1.getValorDeclarado(), 0);
        assertEquals("valor declarado errado 2", 0, encomenda2.getValorDeclarado(), 0);
        assertEquals("valor declarado errado 3", valorDeclarado1, encomenda3.getValorDeclarado(), 0);
        
    }

    @Test
    public void testGetData() {
    	assertEquals("data esperada errada 1", data, encomenda1.getData());
    	assertEquals("data esperada errada 2", data, encomenda2.getData());
    	assertEquals("data esperada errada 3", data, encomenda3.getData());
    }

    

    

    @Test
    public void testEnviaCartaEGetEnviadas() {
    	assertEquals("enviadas erradas 1", 0, encomenda1.getEnviadas());
    	assertEquals("enviadas erradas 2", 0, encomenda2.getEnviadas());
    	assertEquals("enviadas erradas 3", 0, encomenda3.getEnviadas());
    	assertEquals("envio errado 1", "A encomenda foi enviada ao destinatario 1 vez(es).", encomenda1.enviaCarta());
    	assertEquals("envio errado 2", "A encomenda foi enviada ao destinatario 1 vez(es).", encomenda2.enviaCarta());
    	assertEquals("enviadas erradas 4", 1, encomenda1.getEnviadas());
    	assertEquals("enviadas erradas 5", 1, encomenda2.getEnviadas());
    	assertEquals("enviadas erradas 6", 0, encomenda3.getEnviadas());
    	assertEquals("envio errado 3", "A encomenda foi enviada ao destinatario 2 vez(es).", encomenda1.enviaCarta());
    	assertEquals("enviadas erradas 7", 2, encomenda1.getEnviadas());
    	assertEquals("envio errado 4", "A encomenda foi enviada ao destinatario 3 vez(es).", encomenda1.enviaCarta());
    	assertEquals("envio errado 5", "A carta foi enviada ao remetente", encomenda1.enviaCarta());
    	assertEquals("enviadas erradas 8", 4, encomenda1.getEnviadas());
    	
    	
    }
    
    @Test
    public void testGetId() {
    	assertFalse("ids iguais 1", encomenda1.getId().equals(encomenda2.getId()));
    	assertFalse("ids iguais 2", encomenda1.getId().equals(encomenda3.getId()));
    	assertFalse("ids iguais 3", encomenda2.getId().equals(encomenda3.getId()));
    }
    
    
    @Test
    public void testValorDaEncomenda() {
    	assertEquals("valor da encomenda errado 1", 244.7, encomenda1.valorDaEncomenda(), 0);
    	assertEquals("valor da encomenda errado 2", 384.75, encomenda2.valorDaEncomenda(), 0);
    	assertEquals("valor da encomenda errado 3", 25.75, encomenda3.valorDaEncomenda(), 0);
    	encomenda3.confirmaEnvioResistrado();
    	assertEquals("valor da encomenda errado 1", 51.15, encomenda3.valorDaEncomenda(), 0);
    	encomenda3.confirmaViaExpressa();
    	assertEquals("valor da encomenda errado 1", 216.4, encomenda3.valorDaEncomenda(), 0);
    }

}
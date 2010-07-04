
package servicosAutenticacaoUsuario.testes;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import servicosAutenticacaoUsuario.BloqueioSistema;
import servicosAutenticacaoUsuario.ErroAutenticacaoUsuario;
import static org.junit.Assert.*;

/**
 *
 * @author Samir
 */
public class BloqueioSistemaTest {

    public BloqueioSistemaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class BloqueioSistema.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        BloqueioSistema instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getErroAutenticacaoUsuario method, of class BloqueioSistema.
     */
    @Test
    public void testGetErroAutenticacaoUsuario() {
        System.out.println("getErroAutenticacaoUsuario");
        BloqueioSistema instance = null;
        ErroAutenticacaoUsuario expResult = null;
        ErroAutenticacaoUsuario result = instance.getErroAutenticacaoUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrevisaoDesbloqueio method, of class BloqueioSistema.
     */
    @Test
    public void testGetPrevisaoDesbloqueio() {
        System.out.println("getPrevisaoDesbloqueio");
        BloqueioSistema instance = null;
        GregorianCalendar expResult = null;
        GregorianCalendar result = instance.getPrevisaoDesbloqueio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesbloqueado method, of class BloqueioSistema.
     */
    @Test
    public void testGetDesbloqueado() {
        System.out.println("getDesbloqueado");
        BloqueioSistema instance = null;
        boolean expResult = false;
        boolean result = instance.getDesbloqueado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDesbloqueado method, of class BloqueioSistema.
     */
    @Test
    public void testSetDesbloqueado() {
        System.out.println("setDesbloqueado");
        boolean desbloquear = false;
        BloqueioSistema instance = null;
        instance.setDesbloqueado(desbloquear);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class BloqueioSistema.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        BloqueioSistema instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class BloqueioSistema.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        BloqueioSistema instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
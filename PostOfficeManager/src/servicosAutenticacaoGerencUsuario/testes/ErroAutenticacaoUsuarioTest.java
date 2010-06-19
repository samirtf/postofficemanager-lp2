
package servicosAutenticacaoGerencUsuario.testes;

import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import servicosAutenticacaoGerencUsuario.ErroAutenticacaoUsuario;
import static org.junit.Assert.*;

/**
 *
 * @author Samir
 */
public class ErroAutenticacaoUsuarioTest {

    public ErroAutenticacaoUsuarioTest() {
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
     * Test of getId method, of class ErroAutenticacaoUsuario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstanteErro method, of class ErroAutenticacaoUsuario.
     */
    @Test
    public void testGetInstanteErro() {
        System.out.println("getInstanteErro");
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        GregorianCalendar expResult = null;
        GregorianCalendar result = instance.getInstanteErro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogin method, of class ErroAutenticacaoUsuario.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataHora method, of class ErroAutenticacaoUsuario.
     */
    @Test
    public void testGetDataHora() {
        System.out.println("getDataHora");
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        String expResult = "";
        String result = instance.getDataHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdParcial method, of class ErroAutenticacaoUsuario.
     */
    @Test
    public void testGetIdParcial() {
        System.out.println("getIdParcial");
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        String expResult = "";
        String result = instance.getIdParcial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ErroAutenticacaoUsuario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ErroAutenticacaoUsuario.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}


package AutenticacaoUsuario;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samir
 */
public class CriptografiaTest {

    public CriptografiaTest() {
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
     * Test of criptografa method, of class Criptografia.
     */
    @Test
    public void testCriptografa() {
        System.out.println("criptografa");
        String login = "";
        String senha = "";
        String expResult = "";
        String result = Criptografia.criptografa(login, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

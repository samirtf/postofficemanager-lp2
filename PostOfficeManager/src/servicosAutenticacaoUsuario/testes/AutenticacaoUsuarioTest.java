
package servicosAutenticacaoUsuario.testes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import servicosAutenticacaoUsuario.AutenticacaoUsuario;
import servicosAutenticacaoUsuario.Usuario.Prioridade;
import static org.junit.Assert.*;

/**
 *
 * @author Samir
 */
public class AutenticacaoUsuarioTest {

    public AutenticacaoUsuarioTest() {
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
     * Test of validaLogin method, of class AutenticacaoUsuario.
     */
    @Test
    public void testValidaLogin() throws Exception {
        System.out.println("validaLogin");
        String login = "";
        AutenticacaoUsuario instance = new AutenticacaoUsuario();
        boolean expResult = false;
        boolean result = instance.validaLogin(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaSenha method, of class AutenticacaoUsuario.
     */
    @Test
    public void testValidaSenha() throws Exception {
        System.out.println("validaSenha");
        String login = "";
        String senha = "";
        AutenticacaoUsuario instance = new AutenticacaoUsuario();
        boolean expResult = false;
        boolean result = instance.validaSenha(login, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastraUsuario method, of class AutenticacaoUsuario.
     */
    @Test
    public void testCadastraUsuario() throws Exception {
        System.out.println("cadastraUsuario");
        String login = "";
        String senha = "";
        Prioridade prioridade = null;
        AutenticacaoUsuario instance = new AutenticacaoUsuario();
        boolean expResult = false;
        boolean result = instance.cadastraUsuario(login, senha, prioridade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logaNoSistema method, of class AutenticacaoUsuario.
     */
    @Test
    public void testLogaNoSistema() {
        System.out.println("logaNoSistema");
        String login = "";
        String senha = "";
        AutenticacaoUsuario instance = new AutenticacaoUsuario();
        boolean expResult = false;
        boolean result = instance.logaNoSistema(login, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contadorFalhaAutenticacao method, of class AutenticacaoUsuario.
     */
    @Test
    public void testContadorFalhaAutenticacao() {
        System.out.println("contadorFalhaAutenticacao");
        AutenticacaoUsuario instance = new AutenticacaoUsuario();
        instance.contadorFalhaAutenticacao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bloquearSistema method, of class AutenticacaoUsuario.
     */
    @Test
    public void testBloquearSistema() {
        System.out.println("bloquearSistema");
        AutenticacaoUsuario instance = new AutenticacaoUsuario();
        instance.bloquearSistema();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

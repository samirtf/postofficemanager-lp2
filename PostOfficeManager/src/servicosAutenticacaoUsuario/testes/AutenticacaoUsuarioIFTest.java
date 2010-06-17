

package servicosAutenticacaoUsuario.testes;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import servicosAutenticacaoUsuario.AutenticacaoUsuarioExcecao;
import servicosAutenticacaoUsuario.AutenticacaoUsuarioIF;
import servicosAutenticacaoUsuario.Usuario.Prioridade;
import static org.junit.Assert.*;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 17/06/2010
 */
public class AutenticacaoUsuarioIFTest {

    public AutenticacaoUsuarioIFTest() {
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
     * Test of validaLogin method, of class AutenticacaoUsuarioIF.
     */
    @Test
    public void testValidaLogin() throws Exception {
        System.out.println("validaLogin");
        String login = "";
        AutenticacaoUsuarioIF instance = new AutenticacaoUsuarioIFImpl();
        boolean expResult = false;
        boolean result = instance.validaLogin(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaSenha method, of class AutenticacaoUsuarioIF.
     */
    @Test
    public void testValidaSenha() throws Exception {
        System.out.println("validaSenha");
        String login = "";
        String senha = "";
        AutenticacaoUsuarioIF instance = new AutenticacaoUsuarioIFImpl();
        boolean expResult = false;
        boolean result = instance.validaSenha(login, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastraUsuario method, of class AutenticacaoUsuarioIF.
     */
    @Test
    public void testCadastraUsuario() throws Exception {
        System.out.println("cadastraUsuario");
        String login = "";
        String senha = "";
        Prioridade prioridade = null;
        AutenticacaoUsuarioIF instance = new AutenticacaoUsuarioIFImpl();
        boolean expResult = false;
        boolean result = instance.cadastraUsuario(login, senha, prioridade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logaNoSistema method, of class AutenticacaoUsuarioIF.
     */
    @Test
    public void testLogaNoSistema() {
        System.out.println("logaNoSistema");
        String login = "";
        String senha = "";
        AutenticacaoUsuarioIF instance = new AutenticacaoUsuarioIFImpl();
        boolean expResult = false;
        boolean result = instance.logaNoSistema(login, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contadorFalhaAutenticacao method, of class AutenticacaoUsuarioIF.
     */
    @Test
    public void testContadorFalhaAutenticacao() {
        System.out.println("contadorFalhaAutenticacao");
        AutenticacaoUsuarioIF instance = new AutenticacaoUsuarioIFImpl();
        instance.contadorFalhaAutenticacao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bloquearSistema method, of class AutenticacaoUsuarioIF.
     */
    @Test
    public void testBloquearSistema() {
        System.out.println("bloquearSistema");
        AutenticacaoUsuarioIF instance = new AutenticacaoUsuarioIFImpl();
        instance.bloquearSistema();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AutenticacaoUsuarioIFImpl implements AutenticacaoUsuarioIF {

        public boolean validaLogin(String login) throws AutenticacaoUsuarioExcecao {
            return false;
        }

        public boolean validaSenha(String login, String senha) throws AutenticacaoUsuarioExcecao {
            return false;
        }

        public boolean cadastraUsuario(String login, String senha, Prioridade prioridade) throws AutenticacaoUsuarioExcecao {
            return false;
        }

        public boolean logaNoSistema(String login, String senha) {
            return false;
        }

        public void contadorFalhaAutenticacao() {
        }

        public void bloquearSistema() {
        }
    }

}

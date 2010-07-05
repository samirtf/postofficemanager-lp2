
package servicosAutenticacaoUsuario.testes;

import junit.framework.Assert;

import org.junit.Test;

import servicosAutenticacaoUsuario.Usuario;
import servicosAutenticacaoUsuario.Usuario.Prioridade;
import static org.junit.Assert.*;

/**
 *
 * @author Samir
 */
public class UsuarioTest {

	@Test
	public void testConstrutor(){
		
		try{
			Usuario usuario = new Usuario(null, "senha");
			Assert.fail("Esperava excecao de login invalido.");
		}catch(Exception e){
			Assert.assertEquals("Login invalido!", e.getMessage());
		}
		
		try{
			Usuario usuario = new Usuario(" ", "senha");
			Assert.fail("Esperava excecao de login invalido.");
		}catch(Exception e){
			Assert.assertEquals("Login invalido!", e.getMessage());
		}
		
	}

    /**
     * Teste do metodo setLogin.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        Usuario instance = null;
        instance.setLogin(login);
        
    }

    /**
     * Test of getLogin method, of class Usuario.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSenha method, of class Usuario.
     */
    @Test
    public void testSetSenha() {
        System.out.println("setSenha");
        String NovaSenha = "";
        Usuario instance = null;
        instance.setSenha(NovaSenha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSenha method, of class Usuario.
     */
    @Test
    public void testGetSenha() {
        System.out.println("getSenha");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getSenha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrioridade method, of class Usuario.
     */
    @Test
    public void testGetPrioridade() {
        System.out.println("getPrioridade");
        Usuario instance = null;
        Prioridade expResult = null;
        Prioridade result = instance.getPrioridade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarPrioridadeDeOutroUsuario method, of class Usuario.
     */
    @Test
    public void testAlterarPrioridadeDeOutroUsuario() {
        System.out.println("alterarPrioridadeDeOutroUsuario");
        Object objeto = null;
        Prioridade prioridade = null;
        Usuario instance = null;
        boolean expResult = false;
        boolean result = instance.alteraPrioridadeDeOutroUsuario(objeto, prioridade);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Usuario instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Usuario.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Usuario instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

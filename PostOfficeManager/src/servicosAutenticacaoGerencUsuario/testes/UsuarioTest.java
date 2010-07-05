
package servicosAutenticacaoGerencUsuario.testes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import servicosAutenticacaoGerencUsuario.Criptografia;
import servicosAutenticacaoGerencUsuario.Usuario;
import servicosAutenticacaoGerencUsuario.Usuario.Prioridade;
import static org.junit.Assert.*;

/**
 *
 * @author Samir
 */
public class UsuarioTest {
	Usuario usuario = null;
	Usuario usuarioAdmin = null;
	@Before
	public void criaUsuario(){
		
		try {
			usuario = new Usuario("login", "senha");
			usuarioAdmin = new Usuario("loginAdmin", "senhaAdmin", Prioridade.ADMINISTRADOR);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConstrutor(){
		Usuario usuario = null;

			try{
				usuario = new Usuario(null, "senha");
				Assert.fail("Esperava excecao de login invalido.");
			}catch(Exception e){
				Assert.assertEquals("Login invalido!", e.getMessage());
			}
			
			try{
				usuario = new Usuario(" ", "senha");
				Assert.fail("Esperava excecao de login invalido.");
			}catch(Exception e){
				Assert.assertEquals("Login invalido!", e.getMessage());
			}
			
			try{
				usuario = new Usuario("login", null);
				Assert.fail("Esperava excecao de senha invalida.");
			}catch(Exception e){
				Assert.assertEquals("Senha invalida!", e.getMessage());
			}
			
			try{
				usuario = new Usuario("login", " ");
				Assert.fail("Esperava excecao de senha invalido.");
			}catch(Exception e){
				Assert.assertEquals("Senha invalida!", e.getMessage());
			}
		
	}

    /**
     * Teste do metodo setLogin.
     */
    @Test
    public void testSetLogin() {
        String login = "meuNovoLogin";
        Usuario instance = null;
		try {
			instance = new Usuario("login", "senha");
		} catch (Exception e) {
			e.printStackTrace();
		}
        instance.setLogin(login);
        Assert.assertEquals("meuNovoLogin", instance.getLogin());
        
    }

    /**
     * Teste de metodo getLogin().
     */
    @Test
    public void testGetLogin(){
        assertEquals("login", usuario.getLogin() );
    }

    /**
     * Teste de metodo getSenha().
     */
	@Test
    public void testSetSenha() {
		Usuario usuario1 = null;
		try {
			usuario1 = new Usuario("login1", "senha1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String senha = null;
		try {
			senha = Criptografia.criptografa("login1", "novaSenha");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			usuario1.setSenha("novaSenha");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(senha, usuario1.getSenha() );
    }

    /**
     * Teste de metodo getSenha().
     */
    @Test
    public void testGetSenha() {
    	try {
			assertEquals(Criptografia.criptografa("login", "senha"), usuario.getSenha() );
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Teste de metodo getPrioridade().
     */
    @Test
    public void testGetPrioridade() {
        assertEquals(Prioridade.DEFAULT, usuario.getPrioridade());
        assertEquals(Prioridade.ADMINISTRADOR, usuarioAdmin.getPrioridade());
    }

    /**
     * Teste de metodo alterarPrioridadeDeOutroUsuario().
     */
    @Test
    public void testAlterarPrioridadeDeOutroUsuario(){
        Usuario usuarioComum1 = null;
        Usuario usuarioComum2 = null;
        Usuario usuarioAdmin = null;
        
		try {
			usuarioComum1 = new Usuario("login", "senha");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		try {
			usuarioComum2 = new Usuario("login", "senha");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        try {
			usuarioAdmin = new Usuario("login", "senha", Prioridade.ADMINISTRADOR);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        assertFalse(usuarioComum1.alteraPrioridadeDeOutroUsuario(usuarioComum2, Prioridade.ADMINISTRADOR));
        assertEquals(Prioridade.DEFAULT, usuarioComum2.getPrioridade());
        
        assertFalse(usuarioComum1.alteraPrioridadeDeOutroUsuario(usuarioAdmin, Prioridade.DEFAULT));
        assertEquals(Prioridade.ADMINISTRADOR, usuarioAdmin.getPrioridade());
        
        assertTrue(usuarioAdmin.alteraPrioridadeDeOutroUsuario(usuarioComum1, Prioridade.ADMINISTRADOR));
        assertEquals(Prioridade.ADMINISTRADOR, usuarioComum1.getPrioridade());
        
        assertTrue(usuarioComum1.alteraPrioridadeDeOutroUsuario(usuarioAdmin, Prioridade.DEFAULT));
        assertEquals(Prioridade.DEFAULT, usuarioAdmin.getPrioridade());
        
    }

    /**
     * Teste de metodo equals.
     */
    @Test
    public void testEquals() {
    	Usuario usuario1 = null;
        Usuario usuario2 = null;
        Usuario usuarioAdmin = null;
        
		try {
			usuario1 = new Usuario("login", "senha");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		try {
			usuario2 = new Usuario("login2", "senha");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        try {
			usuarioAdmin = new Usuario("login", "senha", Prioridade.ADMINISTRADOR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(usuarioAdmin.equals(usuario1));
		assertFalse(usuarioAdmin.equals(usuario2));
    }


}//fim da classe de testes

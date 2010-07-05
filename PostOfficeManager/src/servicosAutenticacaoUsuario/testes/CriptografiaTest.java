
package servicosAutenticacaoUsuario.testes;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import servicosAutenticacaoUsuario.Criptografia;
import static org.junit.Assert.*;

/**
 *
 * @author Samir
 */
public class CriptografiaTest {

	public CriptografiaTest() {
    }
    /**
     * Test of criptografa method, of class Criptografia.
     */
    @Test
    public void testCriptografa() {
    	String cript = Criptografia.criptografa(null, "administrador");
    	
    	System.out.println(cript);
        try{
        	Criptografia.criptografa(null, "administrador");
        }catch(Exception e){
        	Assert.assertEquals("Login inválido!!", e.getMessage());
        }
        
        try{
        	Criptografia.criptografa("", "administrador");
        	///Assert.fail("Esperava mensagem de login invalido");
        }catch(Exception e){
        	Assert.assertEquals("Login inválido!", e.getMessage());
        }
        
    }

}

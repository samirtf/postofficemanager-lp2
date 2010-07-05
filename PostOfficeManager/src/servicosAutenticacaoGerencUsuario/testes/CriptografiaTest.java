
package servicosAutenticacaoGerencUsuario.testes;



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
    	
        String cript1 = Criptografia.criptografa(null, "administrador");
        Assert.assertEquals("2a3d245e1dcdc912dd49c1a92aa49fa1", cript1);
        
        String cript2 = Criptografia.criptografa("", "administrador");
        Assert.assertEquals("91f5167c34c400758115c2a6826ec2e3", cript2);
        
        String cript3 = Criptografia.criptografa("administrador", null);
        Assert.assertEquals("e3a3ac84abf0db988aafe81c448f335e", cript3);
        
        String cript4 = Criptografia.criptografa("administrador", "");
        Assert.assertEquals("91f5167c34c400758115c2a6826ec2e3", cript4);
        
        String cript5 = Criptografia.criptografa("administrador", "administrador");
        Assert.assertEquals("1e450240549a769a41db6cb27c4575a2", cript5);
        
    }

}


package servicosAutenticacaoGerencUsuario.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import servicosAutenticacaoGerencUsuario.ErroAutenticacaoUsuario;
import static org.junit.Assert.*;

/**
 *
 * @author Samir Trajano Feitosa 20921299
 */
public class ErroAutenticacaoUsuarioTest {

    /**
     * Teste de metodo getId.
     */
    @Test
    public void testGetId() {
        
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        
        GregorianCalendar instanteErro = new GregorianCalendar();
        String ano = String.format("%1$tY", instanteErro);
        String diaDoAno = String.format("%d", instanteErro.get(Calendar.DAY_OF_YEAR));
        String horaMinutoSegundoDoDia = String.format("%1$tH/%1$tM/%1$tS", instanteErro);
        String id = ano + "/" + diaDoAno + "/" + horaMinutoSegundoDoDia;
        
        String result = instance.getId();
        assertEquals(id, result);
        
    }

    /**
     * Teste de metodo getLogin.
     */
    @Test
    public void testGetLogin() {
        
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario("Samir");
        String expResult = "Samir";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        
    }

    /**
     * Teste de metodo getIdParcial.
     */
    @Test
    public void testGetIdParcial() {
        
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        
        GregorianCalendar instanteErro = new GregorianCalendar();
        String ano = String.format("%1$tY", instanteErro);
        String diaDoAno = String.format("%d", instanteErro.get(Calendar.DAY_OF_YEAR));
        String idParcial = ano + "/" + diaDoAno;
        
        String result = instance.getIdParcial();
        assertEquals(idParcial, result);
        
    }

    /**
     * Teste de metodo equals.
     */
    @Test
    public void testEquals() {
        
        ErroAutenticacaoUsuario instance = new ErroAutenticacaoUsuario();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
        ErroAutenticacaoUsuario outroErro = new ErroAutenticacaoUsuario();
        boolean result = instance.equals(outroErro);
        assertFalse(result);
    }

}//fim de classe de testes.

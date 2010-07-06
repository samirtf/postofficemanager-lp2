
package servicosAutenticacaoGerencUsuario.testes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import servicosAutenticacaoGerencUsuario.BloqueioSistema;
import servicosAutenticacaoGerencUsuario.ErroAutenticacaoUsuario;
import static org.junit.Assert.*;

/**
 *
 * @author Samir Trajano Feitosa 20921299
 */
public class BloqueioSistemaTest {

    /**
     * Teste de metodo getId.
     */
    @Test
    public void testGetId() {

        BloqueioSistema instance = new BloqueioSistema();
        
        GregorianCalendar instanteErro = new GregorianCalendar();
        String ano = String.format("%1$tY", instanteErro);
        String diaDoAno = String.format("%d", instanteErro.get(Calendar.DAY_OF_YEAR));
        String horaMinutoSegundoDoDia = String.format("%1$tH/%1$tM/%1$tS", instanteErro);
        String id = ano + "/" + diaDoAno + "/" + horaMinutoSegundoDoDia;
        
        String result = instance.getId();
        assertEquals(id, result);
        
    }

    /**
     * Teste de metodo getErroAutenticacaoUsuario.
     */
    @Test
    public void testGetErroAutenticacaoUsuario() {

        BloqueioSistema instance = new BloqueioSistema();
        ErroAutenticacaoUsuario expResult = new ErroAutenticacaoUsuario();
        ErroAutenticacaoUsuario result = instance.getErroAutenticacaoUsuario();
        assertEquals(expResult, result);
        
    }

    /**
     * Teste de metodo getPrevisaoDesbloqueio.
     */
    @Test
    public void testGetPrevisaoDesbloqueio() {

        ErroAutenticacaoUsuario erro = new ErroAutenticacaoUsuario();
        BloqueioSistema instance = new BloqueioSistema(erro);
        GregorianCalendar expResult = new GregorianCalendar();
        expResult.set(Calendar.MINUTE, expResult.get(Calendar.MINUTE)+1);
        
        GregorianCalendar result = instance.getPrevisaoDesbloqueio();
        boolean chaveHora = result.get(Calendar.HOUR_OF_DAY)==expResult.get(Calendar.HOUR_OF_DAY);
        boolean chaveMinuto = result.get(Calendar.MINUTE)==expResult.get(Calendar.MINUTE);
        boolean chaveSegundo = result.get(Calendar.SECOND)==expResult.get(Calendar.SECOND);
        assertTrue(chaveHora && chaveMinuto && chaveSegundo);

    }

    /**
     * Teste de metodo getDesbloqueado.
     */
    @Test
    public void testDesbloqueado() {
        
    	ErroAutenticacaoUsuario erro = new ErroAutenticacaoUsuario();
        BloqueioSistema instance = new BloqueioSistema(erro);
        
        assertEquals(false, instance.getDesbloqueado() );
        instance.setDesbloqueado(true);
        assertEquals(true, instance.getDesbloqueado() );
        
    }

}//fim de classe de teste.

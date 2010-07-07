
package servicosAutenticacaoUsuario;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *Bloqueia o sistema por 30 minutos para a seguranca dos dados do sistema.
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 *
 */
public class BloqueioSistema implements Serializable{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String id = "";
    private ErroAutenticacaoUsuario erroAutenticacaoUsuario = null;
    private GregorianCalendar previsaoDesbloqueio = null;
    private boolean desbloqueado = false;

    public BloqueioSistema(){
    	this.erroAutenticacaoUsuario = new ErroAutenticacaoUsuario();
        this.id = this.erroAutenticacaoUsuario.getId();
        this.previsaoDesbloqueio = this.erroAutenticacaoUsuario.getInstanteErro();
    }
    
    /**
     * Constroi um bloqueio de sistema a partir de um Erro de Autenticacao do Usuario.
     * @param erroAutenticacaoUsuario
     *      O erro de autenticacao do usuario.
     */
    public BloqueioSistema(ErroAutenticacaoUsuario erroAutenticacaoUsuario){
        this.erroAutenticacaoUsuario = erroAutenticacaoUsuario;
        this.id = this.erroAutenticacaoUsuario.getId();
        this.previsaoDesbloqueio = this.erroAutenticacaoUsuario.getInstanteErro();
        this.previsaoDesbloqueio.set(Calendar.MINUTE,
                this.previsaoDesbloqueio.get(Calendar.MINUTE) + 1);
    }// fim do construtor.

    /**
     * Recupera o ID do bloqueio sistema.
     * @return
     *      O ID do bloqueio de sistema.
     */
    public String getId(){
        return this.id;
    }// fim do metodo getId.

    /**
     * Recupera o erro de autenticacao do usuario.
     * @return
     *      O erro de autenticacao do usuario.
     */
    public ErroAutenticacaoUsuario getErroAutenticacaoUsuario(){
        return this.erroAutenticacaoUsuario;
    }// fim do metodo getErroAutenticacaoUsuario

    /**
     * Recupera a previsao de desbloqueio do sistema.
     * @return
     *      A previsao de desbloqueio do sistema.
     */
    public GregorianCalendar getPrevisaoDesbloqueio(){
    	if( this.previsaoDesbloqueio == null ){
    		return null;
    	}
        return this.previsaoDesbloqueio;
    }// fim do metodo getPrevisaoDesbloqueado

    /**
     * Recupera o estado do sistema.
     * @return
     *      True - Se o sistema estiver desbloqueado.
     *      False - Se o sistema nao estiver desbloqueado.
     */
    public boolean getDesbloqueado(){
        return this.desbloqueado;
    }// fim do metodo getDesbloqueado.

    /**
     * Configura o estado do sistema.
     * @param desbloquear
     *      True - Desbloqueia o sistema.
     *      False - Bloqueia o sistema.
     */
    public void setDesbloqueado(boolean desbloquear){
        this.desbloqueado = desbloquear;
    }// fim do metodo setDesbloqueio.

    /**
     * Compara a igualdade de dois objetos. Supoe-se que o outro objeto seja
     * instancia de BloqueioSistema.
     * @param obj
     *      O outro objeto a ser comparado.
     * @return
     *      True - Se os dois bloqueios de sistema forem iguais.
     *      False - Se o segundo objeto a se comparar nao for uma instancia
     *              de BloqueioSistema.
     *      False - Se os dois bloqueios nao forem iguais.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BloqueioSistema other = (BloqueioSistema) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }// fim do metodo equals.

    /**
     * Gera o hashCode do bloqueio de sistema.
     * @return
     *      O hashCode do bloqueio de sistema.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }// fim do metodo hashCode.

}// fim da classe BloqueioSistema


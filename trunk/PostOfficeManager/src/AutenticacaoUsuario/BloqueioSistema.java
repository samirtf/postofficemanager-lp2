
package AutenticacaoUsuario;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 *
 * @Definição:
 *      Bloqueia o sistema por 30 minutos para a segurança dos dados do sistema.
 *
 */
public class BloqueioSistema {

    private String id = "";
    private ErroAutenticacaoUsuario erroAutenticacaoUsuario = null;
    private GregorianCalendar previsaoDesbloqueio = null;
    private boolean desbloqueado = false;

    /**
     * Constroi um bloqueio de sistema a partir de um Erro de Autenticação do Usuário.
     * @param erroAutenticacaoUsuario
     *      O erro de autenticação do usuário.
     */
    public BloqueioSistema(ErroAutenticacaoUsuario erroAutenticacaoUsuario){
        this.erroAutenticacaoUsuario = erroAutenticacaoUsuario;
        this.id = this.erroAutenticacaoUsuario.getId();
        this.previsaoDesbloqueio = this.erroAutenticacaoUsuario.getInstanteErro();
        this.previsaoDesbloqueio.set(Calendar.MINUTE,
                this.previsaoDesbloqueio.get(Calendar.MINUTE) + 30);
    }// fim do construtor.

    /**
     * Recupera o ID do bloqueio sistema.
     * @return
     *      O ID do bloqueio de sistema.
     */
    public String getId(){
        return this.id;
    }// fim do método getId.

    /**
     * Recupera o erro de autencitação do usuário.
     * @return
     *      O erro de autenticação do usuário.
     */
    public ErroAutenticacaoUsuario getErroAutenticacaoUsuario(){
        return this.erroAutenticacaoUsuario;
    }// fim do método getErroAutenticacaoUsuario

    /**
     * Recupera a previsão de desbloqueio do sistema.
     * @return
     *      A previsão de desbloqueio do sistema.
     */
    public GregorianCalendar getPrevisaoDesbloqueio(){
        return this.previsaoDesbloqueio;
    }// fim do método getPrevisaoDesbloqueado

    /**
     * Recupera o estado do sistema.
     * @return
     *      True - Se o sistema estiver desbloqueado.
     *      False - Se o sistema não estiver desbloqueado.
     */
    public boolean getDesbloqueado(){
        return this.desbloqueado;
    }// fim do método getDesbloqueado.

    /**
     * Configura o estado do sistema.
     * @param desbloquear
     *      True - Desbloqueia o sistema.
     *      False - Bloqueia o sistema.
     */
    public void setDesbloqueado(boolean desbloquear){
        this.desbloqueado = desbloquear;
    }// fim do método setDesbloqueio.

    /**
     * Compara a igualdade de dois objetos. Supoe-se que o outro objeto seja
     * instância de BloqueioSistema.
     * @param obj
     *      O outro objeto a ser comparado.
     * @return
     *      True - Se os dois bloqueios de sistema forem iguais.
     *      False - Se o segundo objeto a se comparar não for uma instância
     *              de BloqueioSistema.
     *      False - Se os dois bloqueios não forem iguais.
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
    }// fim do método equals.

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
    }// fim do método hashCode.

}// fim da classe BloqueioSistema


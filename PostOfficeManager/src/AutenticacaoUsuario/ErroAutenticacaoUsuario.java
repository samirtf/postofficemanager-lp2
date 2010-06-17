
package AutenticacaoUsuario;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public class ErroAutenticacaoUsuario {
    private String id = null;
    private String idParcial = null;
    private GregorianCalendar instanteErro = null;
    private String login = "";
    private String dataHora = "";

    /**
     * Constroi um erro de autentica��o de usu�rio.
     */
    public ErroAutenticacaoUsuario(){
        this.instanteErro = new GregorianCalendar();
        String ano = String.format("%1$tY", this.instanteErro);
        String diaDoAno = String.format("%d", this.instanteErro.get(Calendar.DAY_OF_YEAR));
        String horaMinutoSegundoDoDia = String.format("%1$tH/%1$tM/%1$tS", this.instanteErro);
        this.id = ano + "/" + diaDoAno + "/" + horaMinutoSegundoDoDia;
        this.idParcial = ano + "/" + diaDoAno;
        this.dataHora = String.format("%tc", instanteErro);
        
    }// fim do construtor padr�o.

    /**
     * Constroi um erro de autentica��o de usu�rio a partir de um login.
     * @param login
     *      O login do usu�rio.
     */
    public ErroAutenticacaoUsuario(String login){
        this();
        this.login = login;
    }// fim do construtor a partir de uma String login.

    /**
     * Recupera o ID do erro de autentica��o do usu�rio.
     * @return
     *      O ID do erro de autentica��o do usu�rio.
     */
    public String getId(){
        return this.id;
    }// fim do m�todo getId.

    /**
     * Recupera dados do instante em que o erro foi gerado.
     * @return
     *      Os dados do erro.
     */
    public GregorianCalendar getInstanteErro(){
        return this.instanteErro;
    }// fim do m�todo getInstanteErro.

    /**
     * Recupera o login que estava sendo usado para logar no sistema.
     * @return
     *      O login do usu�rio.
     */
    public String getLogin(){
        return this.login;
    }// fim do m�todo getLogin.

    /**
     * Recupera a data e a hora do erro.
     * @return
     *      A data e a hora do erro.
     */
    public String getDataHora(){
        return this.dataHora;
    }// fim do m�todo getDataHora.

    /**
     * Recupera o ID Parcial. O ID Parcial serve usar como filtro dos erros do dia.
     * @return
     *      O ID Parcial.
     */
    public String getIdParcial(){
        return this.idParcial;
    }// fim do m�todo getIdParcial.

    /**
     * Compara a igualdade de dois erros.
     * @param obj
     *      O objeto a ser passado. Supoe-se que seja uma inst�ncia de
     *      ErroAutenticacaoUsuario.
     * @return
     *      True - Se os dois erros forem iguais.
     *      False - Se o segundo objeto a se comparar n�o for uma inst�ncia de
     *              ErroAutenticacaoUsuario.
     *      False - Se os dois erros n�o forem iguais.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErroAutenticacaoUsuario other = (ErroAutenticacaoUsuario) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }// fim do m�todo equals.

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }// fim do m�todo hashCode.

}// fim da classe ErroAutenticacaoUsuario.



package servicosAutenticacaoGerencUsuario;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public class ErroAutenticacaoUsuario implements Serializable{
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String id = null;
    private String idParcial = null;
    private GregorianCalendar instanteErro = null;
    private String login = "";
    private String dataHora = "";

    /**
     * Constroi um erro de autenticacao de usuario.
     */
    public ErroAutenticacaoUsuario(){
        this.instanteErro = new GregorianCalendar();
        String ano = String.format("%1$tY", this.instanteErro);
        String diaDoAno = String.format("%d", this.instanteErro.get(Calendar.DAY_OF_YEAR));
        String horaMinutoSegundoDoDia = String.format("%1$tH/%1$tM/%1$tS", this.instanteErro);
        this.id = ano + "/" + diaDoAno + "/" + horaMinutoSegundoDoDia;
        this.idParcial = ano + "/" + diaDoAno;
        this.dataHora = String.format("%tc", instanteErro);
        
    }// fim do construtor padrao.

    /**
     * Constroi um erro de autenticacao de usuario a partir de um login.
     * @param login
     *      O login do usuario.
     */
    public ErroAutenticacaoUsuario(String login){
        this();
        this.login = login;
    }// fim do construtor a partir de uma String login.

    /**
     * Recupera o ID do erro de autenticacao do usuario.
     * @return
     *      O ID do erro de autenticacao do usuario.
     */
    public String getId(){
        return this.id;
    }// fim do metodo getId.

    /**
     * Recupera dados do instante em que o erro foi gerado.
     * @return
     *      Os dados do erro.
     */
    public GregorianCalendar getInstanteErro(){
        return this.instanteErro;
    }// fim do metodo getInstanteErro.

    /**
     * Recupera o login que estava sendo usado para logar no sistema.
     * @return
     *      O login do usuario.
     */
    public String getLogin(){
        return this.login;
    }// fim do metodo getLogin.

    /**
     * Recupera a data e a hora do erro.
     * @return
     *      A data e a hora do erro.
     */
    public String getDataHora(){
        return this.dataHora;
    }// fim do metodo getDataHora.

    /**
     * Recupera o ID Parcial. O ID Parcial serve usar como filtro dos erros do dia.
     * @return
     *      O ID Parcial.
     */
    public String getIdParcial(){
        return this.idParcial;
    }// fim do metodo getIdParcial.

    /**
     * Compara a igualdade de dois erros.
     * @param obj
     *      O objeto a ser passado. Supoe-se que seja uma instancia de
     *      ErroAutenticacaoUsuario.
     * @return
     *      True - Se os dois erros forem iguais.
     *      False - Se o segundo objeto a se comparar nao for uma instancia de
     *              ErroAutenticacaoUsuario.
     *      False - Se os dois erros nao forem iguais.
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
    }// fim do metodo equals.

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }// fim do metodo hashCode.

}// fim da classe ErroAutenticacaoUsuario.


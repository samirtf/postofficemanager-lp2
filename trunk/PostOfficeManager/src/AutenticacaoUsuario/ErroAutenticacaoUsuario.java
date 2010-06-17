/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AutenticacaoUsuario;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Samir Trajano Feitosa
 */
public class ErroAutenticacaoUsuario {
    private String id = null;
    private String idParcial = null;
    private GregorianCalendar instanteErro = null;
    private String login = "";
    private String dataHora = "";

    /**
     * Constroi um erro de autenticação de usuário.
     */
    public ErroAutenticacaoUsuario(){
        this.instanteErro = new GregorianCalendar();
        String ano = String.format("%1$tY", this.instanteErro);
        String diaDoAno = String.format("%d", this.instanteErro.get(Calendar.DAY_OF_YEAR));
        String horaMinutoSegundoDoDia = String.format("%1$tH/%1$tM/%1$tS", this.instanteErro);
        this.id = ano + "/" + diaDoAno + "/" + horaMinutoSegundoDoDia;
        this.idParcial = ano + "/" + diaDoAno;
        this.dataHora = String.format("%tc", instanteErro);
        
    }

    /**
     * Constroi um erro de autenticação de usuário a partir de um login.
     * @param login
     *      O login do usuário.
     */
    public ErroAutenticacaoUsuario(String login){
        this();
        this.login = login;
    }

    /**
     * Recupera o ID do erro de autenticação do usuário.
     * @return
     *      O ID do erro de autenticação do usuário.
     */
    public String getId(){
        return this.id;
    }

    /**
     * Recupera dados do instante em que o erro foi gerado.
     * @return
     *      Os dados do erro.
     */
    public GregorianCalendar getInstanteErro(){
        return this.instanteErro;
    }

    /**
     * Recupera o login que estava sendo usado para logar no sistema.
     * @return
     *      O login do usuário.
     */
    public String getLogin(){
        return this.login;
    }

    /**
     * Recupera a data e a hora do erro.
     * @return
     *      A data e a hora do erro.
     */
    public String getDataHora(){
        return this.dataHora;
    }

    /**
     * Recupera o ID Parcial. O ID Parcial serve usar como filtro dos erros do dia.
     * @return
     *      O ID Parcial.
     */
    public String getIdParcial(){
        return this.idParcial;
    }

    /**
     * Compara a igualdade de dois erros.
     * @param obj
     *      O objeto a ser passado. Supoe-se que seja uma instância de
     *      ErroAutenticacaoUsuario.
     * @return
     *      True - Se os dois erros forem iguais.
     *      False - Se o segundo objeto a se comparar não for uma instância de
     *              ErroAutenticacaoUsuario.
     *      False - Se os dois erros não forem iguais.
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
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }


}


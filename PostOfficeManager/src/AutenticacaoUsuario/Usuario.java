/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AutenticacaoUsuario;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 13/06/2010
 * @Definição:
 *      Exceções para esta classe devem ser chamadas por AutenticacaoUsuario.
 */
public class Usuario {
    public enum Prioridade{
    /**
     * Prioridadr de Administrador de Sistema.
     */
    ADMINISTRADOR,

    /**
     * Prioridade Padrão: Acesso limitado.
     */
    DEFAULT
}
    private String login = null;
    private String senha = null;
    private Prioridade prioridade = Prioridade.DEFAULT;

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = Criptografia.criptografa(login, senha);
    }

    public Usuario(String login, String senha, Prioridade prioridade){
        this(login, senha);
        this.prioridade = prioridade;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getLogin(){
        return this.login;
    }

    public void setSenha(String NovaSenha){
        this.senha = Criptografia.criptografa(this.login, NovaSenha);
    }

    public String getSenha(){
        return this.senha;
    }

    public Prioridade getPrioridade(){
        return this.prioridade;
    }

    public boolean alterarPrioridadeDeOutroUsuario(Object objeto, Prioridade prioridade){
        if( this.getPrioridade() != Prioridade.ADMINISTRADOR ){
            return false;
        }
        if( !(objeto instanceof Usuario) && !(this.equals(objeto)) ){
            return false;
        }
        Usuario outroUsuario = (Usuario) objeto;
        outroUsuario.prioridade = prioridade;

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }



    
}


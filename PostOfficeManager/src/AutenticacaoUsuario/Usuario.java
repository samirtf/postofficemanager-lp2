
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

    /**
     * Cria um usuário a partir de um login e uma senha.
     * @param login
     * 		O login do usuário.
     * @param senha
     * 		A senha do usuário.
     */
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = Criptografia.criptografa(login, senha);// senha será armazenada 
                                                            //no atributo já criptografada.
    }// fim do construtor a partir de um login e senha do usuário.

    /**
     * Cria um usuário a partir de um login, uma senha e a prioridade do usuário.
     * @param login
     * 		O login do novo usuário.
     * @param senha
     * 		A senha do novo usuário.
     * @param prioridade
     * 		A prioridade do novo usuário.
     */
    public Usuario(String login, String senha, Prioridade prioridade){
        this(login, senha);
        this.prioridade = prioridade;
    }// fim do construtor a partir de um login, uma senha e uma prioridade do usuário.

    /**
     * Configura o login do usuario.
     * @param login
     * 		O login do usuário.
     */
    public void setLogin(String login){
        this.login = login;
    }// fim do método setLogin.

    /**
     * Recupera o login do usuário.
     * @return
     * 		O login do usuário.
     */
    public String getLogin(){
        return this.login;
    }// fim do método getLogin.

    /**
     * Configura a senha do usuário. A nova senha será criptografada antes de ser armazenada.
     * @param NovaSenha
     * 		A nova senha do usuário.
     */
    public void setSenha(String NovaSenha){
        this.senha = Criptografia.criptografa(this.login, NovaSenha);
    }// fim do método setSenha.

    /**
     * Recupera a senha do usuário. Recupera a senha criptografada.
     * @return
     * 		A senha criptografada.
     */
    public String getSenha(){
        return this.senha;
    }// fim do método getSenha.

    /**
     * Recupera a prioridade do usuário.
     * @return
     * 		A prioridade do usuário.
     */
    public Prioridade getPrioridade(){
        return this.prioridade;
    }// fim do método getPrioridade.

    /**
     * Altera a prioridade do usuário. A alteração só pode ser feita por um 
     * usuário com privilégios de administrador.
     * @param objeto
     * 		O usuário a ter os privilégios alterados.
     * @param prioridade
     * 		A prioridade do usuário.
     * @return
     * 		True - Se a prioridade do usuário for alterada.
     * 		False - Se a prioridade do usuário não for alterada.
     */
    public boolean alteraPrioridadeDeOutroUsuario(Object objeto, Prioridade prioridade){
        if( this.getPrioridade() != Prioridade.ADMINISTRADOR ){
            return false;
        }
        if( !(objeto instanceof Usuario) && !(this.equals(objeto)) ){
            return false;
        }
        Usuario outroUsuario = (Usuario) objeto;
        outroUsuario.prioridade = prioridade;

        return true;
    }// fim do método alteraPrioridadeDeOutroUsuario.

    /**
     * Compara dois usuários. Supoe-se que o segundo objeto a ser comparado seja uma instância
     * de Usuário.
     * @param obj
     * 		O usuário a se comparado.
     * @return
     * 		True - Se os usuários forem iguais.
     * 		False - Se os dois objetos forem de instâncias diferentes.
     * 		False - Se os dois usuários não forem iguais.
     */
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
    }// fim do método equals.

    /**
     * Recupera o hashCode do usuário.
     * @return
     * 		O hashCode do usuário.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }// fim do método hashCode.
    
}// fim da classe usuário.


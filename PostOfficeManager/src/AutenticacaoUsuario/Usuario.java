
package AutenticacaoUsuario;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 13/06/2010
 * @Defini��o:
 *      Exce��es para esta classe devem ser chamadas por AutenticacaoUsuario.
 */
public class Usuario {
	
    public enum Prioridade{
    /**
     * Prioridadr de Administrador de Sistema.
     */
    ADMINISTRADOR,

    /**
     * Prioridade Padr�o: Acesso limitado.
     */
    DEFAULT
}
    private String login = null;
    private String senha = null;
    private Prioridade prioridade = Prioridade.DEFAULT;

    /**
     * Cria um usu�rio a partir de um login e uma senha.
     * @param login
     * 		O login do usu�rio.
     * @param senha
     * 		A senha do usu�rio.
     */
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = Criptografia.criptografa(login, senha);// senha ser� armazenada 
                                                            //no atributo j� criptografada.
    }// fim do construtor a partir de um login e senha do usu�rio.

    /**
     * Cria um usu�rio a partir de um login, uma senha e a prioridade do usu�rio.
     * @param login
     * 		O login do novo usu�rio.
     * @param senha
     * 		A senha do novo usu�rio.
     * @param prioridade
     * 		A prioridade do novo usu�rio.
     */
    public Usuario(String login, String senha, Prioridade prioridade){
        this(login, senha);
        this.prioridade = prioridade;
    }// fim do construtor a partir de um login, uma senha e uma prioridade do usu�rio.

    /**
     * Configura o login do usuario.
     * @param login
     * 		O login do usu�rio.
     */
    public void setLogin(String login){
        this.login = login;
    }// fim do m�todo setLogin.

    /**
     * Recupera o login do usu�rio.
     * @return
     * 		O login do usu�rio.
     */
    public String getLogin(){
        return this.login;
    }// fim do m�todo getLogin.

    /**
     * Configura a senha do usu�rio. A nova senha ser� criptografada antes de ser armazenada.
     * @param NovaSenha
     * 		A nova senha do usu�rio.
     */
    public void setSenha(String NovaSenha){
        this.senha = Criptografia.criptografa(this.login, NovaSenha);
    }// fim do m�todo setSenha.

    /**
     * Recupera a senha do usu�rio. Recupera a senha criptografada.
     * @return
     * 		A senha criptografada.
     */
    public String getSenha(){
        return this.senha;
    }// fim do m�todo getSenha.

    /**
     * Recupera a prioridade do usu�rio.
     * @return
     * 		A prioridade do usu�rio.
     */
    public Prioridade getPrioridade(){
        return this.prioridade;
    }// fim do m�todo getPrioridade.

    /**
     * Altera a prioridade do usu�rio. A altera��o s� pode ser feita por um 
     * usu�rio com privil�gios de administrador.
     * @param objeto
     * 		O usu�rio a ter os privil�gios alterados.
     * @param prioridade
     * 		A prioridade do usu�rio.
     * @return
     * 		True - Se a prioridade do usu�rio for alterada.
     * 		False - Se a prioridade do usu�rio n�o for alterada.
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
    }// fim do m�todo alteraPrioridadeDeOutroUsuario.

    /**
     * Compara dois usu�rios. Supoe-se que o segundo objeto a ser comparado seja uma inst�ncia
     * de Usu�rio.
     * @param obj
     * 		O usu�rio a se comparado.
     * @return
     * 		True - Se os usu�rios forem iguais.
     * 		False - Se os dois objetos forem de inst�ncias diferentes.
     * 		False - Se os dois usu�rios n�o forem iguais.
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
    }// fim do m�todo equals.

    /**
     * Recupera o hashCode do usu�rio.
     * @return
     * 		O hashCode do usu�rio.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }// fim do m�todo hashCode.
    
}// fim da classe usu�rio.


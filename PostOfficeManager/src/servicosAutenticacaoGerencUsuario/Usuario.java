
package servicosAutenticacaoGerencUsuario;

import java.io.Serializable;


/**
*
* @author
* 	Samir Trajano Feitosa 20921299
* 	Marcus Vinicius Souza de Oliveira
* 	Rafael O. Vieira
* 	Werton Vin�cius Guimar�es Gomes
* 
* @version 1.0
* @since 13/06/2010
*
* Excecoes para esta classe devem ser chamadas por AutenticacaoUsuario.
*/
public class Usuario implements Serializable{
	
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public enum Prioridade{
    /**
     * Prioridadr de Administrador de Sistema.
     */
    ADMINISTRADOR,

    /**
     * Prioridade Padrao: Acesso limitado.
     */
    DEFAULT
}
    private String login = null;
    private String senha = null;
    private Prioridade prioridade = Prioridade.DEFAULT;

    /**
     * Cria um usuario a partir de um login e uma senha.
     * @param login
     * 		O login do usuario.
     * @param senha
     * 		A senha do usuario.
     * @throws Exception 
     */
    public Usuario(String login, String senha) throws Exception{
    	if( login == null || login.trim().equals("")){
    		throw new Exception("Login invalido!");
    	}
    	else if( senha == null || senha.trim().equals("")){
    		throw new Exception("Senha invalida!");
    	}
        this.login = login.trim();
        this.senha = Criptografia.criptografa(login, senha);// senha sera armazenada 
                                                            //no atributo ja criptografada.
    }// fim do construtor a partir de um login e senha do usuario.

    /**
     * Cria um usuario a partir de um login, uma senha e a prioridade do usuario.
     * @param login
     * 		O login do novo usuario.
     * @param senha
     * 		A senha do novo usuario.
     * @param prioridade
     * 		A prioridade do novo usuario.
     * @throws Exception 
     */
    public Usuario(String login, String senha, Prioridade prioridade) throws Exception{
    	
        this(login, senha);
        this.prioridade = prioridade;
    }// fim do construtor a partir de um login, uma senha e uma prioridade do usuario.

    /**
     * Configura o login do usuario.
     * @param login
     * 		O login do usuario.
     */
    public void setLogin(String login){
        this.login = login;
    }// fim do metodo setLogin.

    /**
     * Recupera o login do usuario.
     * @return
     * 		O login do usuario.
     */
    public String getLogin(){
        return this.login;
    }// fim do metodo getLogin.

    /**
     * Configura a senha do usuario. A nova senha sera criptografada antes de ser armazenada.
     * @param NovaSenha
     * 		A nova senha do usuario.
     * @throws Exception 
     */
    public void setSenha(String NovaSenha) throws Exception{
        this.senha = Criptografia.criptografa(this.login, NovaSenha);
    }// fim do metado setSenha.

    /**
     * Recupera a senha do usuario. Recupera a senha criptografada.
     * @return
     * 		A senha criptografada.
     */
    public String getSenha(){
        return this.senha;
    }// fim do metado getSenha.

    /**
     * Recupera a prioridade do usuario.
     * @return
     * 		A prioridade do usuario.
     */
    public Prioridade getPrioridade(){
        return this.prioridade;
    }// fim do metado getPrioridade.

    /**
     * Altera a prioridade do usuario. A alteracao so pode ser feita por um 
     * usuario com privilegios de administrador.
     * @param objeto
     * 		O usuario a ter os privilegios alterados.
     * @param prioridade
     * 		A prioridade do usuario.
     * @return
     * 		True - Se a prioridade do usuario for alterada.
     * 		False - Se a prioridade do usuario nao for alterada.
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
    }// fim do metado alteraPrioridadeDeOutroUsuario.

    /**
     * Compara dois usuarios. Supoe-se que o segundo objeto a ser comparado seja uma instancia
     * de Usuario.
     * @param obj
     * 		O usuario a se comparado.
     * @return
     * 		True - Se os usuarios forem iguais.
     * 		False - Se os dois objetos forem de instancias diferentes.
     * 		False - Se os dois usuarios nao forem iguais.
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
    }// fim do metado equals.

    /**
     * Recupera o hashCode do usuario.
     * @return
     * 		O hashCode do usuario.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }// fim do metado hashCode.
    
}// fim da classe usuario.


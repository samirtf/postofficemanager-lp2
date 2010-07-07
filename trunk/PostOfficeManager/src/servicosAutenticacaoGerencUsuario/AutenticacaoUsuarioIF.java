
package servicosAutenticacaoGerencUsuario;


import java.io.IOException;
import java.io.Serializable;

import servicosAutenticacaoGerencUsuario.Usuario.Prioridade;

/**
*
* @author
* 	Samir Trajano Feitosa 20921299
* 	Marcus Vinicius Souza de Oliveira
* 	Rafael O. Vieira
* 	Werton Vinícius Guimarães Gomes
* 
* @version 1.0
* @since 11/06/2010
*
*/
public interface AutenticacaoUsuarioIF extends Serializable{


    


    /**
     * Cadastra usuario no sistema.
     * @param login
     *      O login do novo usuario.
     * @param senha
     *      A senha do novo usuario.
     * @return
     *      True - Em caso do cadastro ser efetuado com sucesso.
     *      False - Em caso do cadastro nao ser efetuado..
     */
    public boolean cadastraUsuario(String login, String senha, Prioridade prioridade)
            throws AutenticacaoUsuarioExcecao, IOException;

    /**
     * Loga no sistema a partir de um login e senha validos.
     * @param login
     *      O login do usuario ja cadastrado.
     * @param senha
     *      A senha do usuario ja cadastrado.
     * @return
     */
    public boolean logaNoSistema(String login, String senha) throws Exception;

    /**
     * Incrementa contador de falhas da autenticacao.
     * OBS.: O contador de falhas da autenticacao deve ser um atributo da classe
     * a implementar esta interface.
     * Se o contador chegar a 10, o sistema fica bloqueado por 30 minutos.
     * Apos esse tempo, o contador sera zerado e o usuario podera realizar
     * outras tentativas de autenticacao.
     */
    public void incrementaContadorFalhaAutenticacao();
    
    /**
     * Gera um Erro de Autenticacao de Usuario.
     * @return
     * 		True - Se o erro for gerado.
     * 		False - Se o erro nao for gerado.
     * @throws IOException
     */
    public boolean geraErroAutenticacao() throws IOException;
    
    /**
     * Gera um Erro de Autenticacao de Usuario a partir de um login.
     * @param login
     * 		O login do usuario.
     * @return
     * 		True - Se o erro tiver sido gerado.
     * 		False - Se o erro nao tiver sido gerado.
     * @throws IOException
     */
    public boolean geraErroAutenticacao(String login) throws IOException;

    /**
     * Bloqueia sistema por 30 minutos. O bloqueio eh realizado por motivos
     * de seguranca.
     */
    public boolean bloquearSistema(ErroAutenticacaoUsuario erroAutenticacaoUsuario) 
        throws IOException;

}



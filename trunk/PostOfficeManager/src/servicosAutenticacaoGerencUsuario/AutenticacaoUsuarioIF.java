
package servicosAutenticacaoGerencUsuario;


import java.io.IOException;
import java.io.Serializable;

import servicosAutenticacaoGerencUsuario.Usuario.Prioridade;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public interface AutenticacaoUsuarioIF extends Serializable{


    /**
     * Valida login do usuario.
     * Verifica se o login e nulo.
     * Verifica se o login e vazio.
     * Verifica se o login possui menos de 8 caracteres.
     * Verifica se o login possui mais de 12 caracteres.
     * Verifica se alguma substring do login nao eh alphanumerico.
     * @param login
     *      O login do usuario.
     * @return
     *      True - Se o login eh valido.
     *      False - Se o login nao for valido.
     */
    public abstract boolean validaLogin(String login);

    /**
     * Valida a senha do usuario.
     * Verifica a validade do login.
     * Verifica se o login os 3 primeiros caracteres do login sao os 3
     * primeiros caracteres da senha.
     * Verifica se o login eh substring da senha.
     * Verifica se a senha possui menos de 8 caracteres.
     * @param login
     * @param senha
     * @return
     */
    public boolean validaSenha(String login, String senha);
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
    
    //TODO JAVADOC
    public boolean geraErroAutenticacao() throws IOException;
    
  //TODO JAVADOC
    public boolean geraErroAutenticacao(String login) throws IOException;

    /**
     * Bloqueia sistema por 30 minutos. O bloqueio eh realizado por motivos
     * de seguranca.
     */
    public boolean bloquearSistema(ErroAutenticacaoUsuario erroAutenticacaoUsuario) 
        throws IOException;

}




package servicosAutenticacaoUsuario;


import java.io.Serializable;

import servicosAutenticacaoUsuario.Usuario.Prioridade;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public interface AutenticacaoUsuarioIF extends Serializable{


    /**
     * Valida login do usu�rio.
     * Verifica se o login � nulo.
     * Verifica se o login � vazio.
     * Verifica se o login possui menos de 8 caracteres.
     * Verifica se o login possui mais de 12 caracteres.
     * Verifica se alguma substring do login n�o � alphanum�rico.
     * @param login
     *      O login do usu�rio.
     * @return
     *      True - Se o login � v�lido.
     *      False - Se o login n�o for v�lido.
     */
    public boolean validaLogin(String login)throws AutenticacaoUsuarioExcecao;

    /**
     * Valida a senha do usu�rio.
     * Verifica a validade do login.
     * Verifica se o login os 3 primeiros caracteres do login s�o os 3
     * primeiros caracteres da senha.
     * Verifica se o login � substring da senha.
     * Verifica se a senha possui menos de 8 caracteres.
     * @param login
     * @param senha
     * @return
     */
    public boolean validaSenha(String login, String senha)
            throws AutenticacaoUsuarioExcecao;

    /**
     * Cadastra usu�rio no sistema.
     * @param login
     *      O login do novo usu�rio.
     * @param senha
     *      A senha do novo usu�rio.
     * @return
     *      True - Em caso do cadastro ser efetuado com sucesso.
     *      False - Em caso do cadastro n�o ser efetuado..
     */
    public boolean cadastraUsuario(String login, String senha, Prioridade prioridade)
            throws AutenticacaoUsuarioExcecao;

    /**
     * Loga no sistema a partir de um login e senha v�lidos.
     * @param login
     *      O login do usu�rio j� cadastrado.
     * @param senha
     *      A senha do usu�rio j� cadastrado.
     * @return
     */
    public boolean logaNoSistema(String login, String senha);

    /**
     * Incrementa contador de falhas da autentica��o.
     * OBS.: O contador de falhas da autentica��o deve ser um atributo da classe
     * a implementar esta interface.
     * Se o contador chegar a 10, o sistema fica bloqueado por 30 minutos.
     * Ap�s esse tempo, o contador ser� zerado e o usu�rio poder� realizar
     * outras tentativas de autentica��o.
     */
    public void contadorFalhaAutenticacao();

    /**
     * Bloqueia sistema por 30 minutos. O bloqueio � realizado por motivos
     * de seguran�a.
     */
    public void bloquearSistema();

}




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
     * Valida login do usuário.
     * Verifica se o login é nulo.
     * Verifica se o login é vazio.
     * Verifica se o login possui menos de 8 caracteres.
     * Verifica se o login possui mais de 12 caracteres.
     * Verifica se alguma substring do login não é alphanumérico.
     * @param login
     *      O login do usuário.
     * @return
     *      True - Se o login é válido.
     *      False - Se o login não for válido.
     */
    public boolean validaLogin(String login)throws AutenticacaoUsuarioExcecao;

    /**
     * Valida a senha do usuário.
     * Verifica a validade do login.
     * Verifica se o login os 3 primeiros caracteres do login são os 3
     * primeiros caracteres da senha.
     * Verifica se o login é substring da senha.
     * Verifica se a senha possui menos de 8 caracteres.
     * @param login
     * @param senha
     * @return
     */
    public boolean validaSenha(String login, String senha)
            throws AutenticacaoUsuarioExcecao;

    /**
     * Cadastra usuário no sistema.
     * @param login
     *      O login do novo usuário.
     * @param senha
     *      A senha do novo usuário.
     * @return
     *      True - Em caso do cadastro ser efetuado com sucesso.
     *      False - Em caso do cadastro não ser efetuado..
     */
    public boolean cadastraUsuario(String login, String senha, Prioridade prioridade)
            throws AutenticacaoUsuarioExcecao;

    /**
     * Loga no sistema a partir de um login e senha válidos.
     * @param login
     *      O login do usuário já cadastrado.
     * @param senha
     *      A senha do usuário já cadastrado.
     * @return
     */
    public boolean logaNoSistema(String login, String senha);

    /**
     * Incrementa contador de falhas da autenticação.
     * OBS.: O contador de falhas da autenticação deve ser um atributo da classe
     * a implementar esta interface.
     * Se o contador chegar a 10, o sistema fica bloqueado por 30 minutos.
     * Após esse tempo, o contador será zerado e o usuário poderá realizar
     * outras tentativas de autenticação.
     */
    public void contadorFalhaAutenticacao();

    /**
     * Bloqueia sistema por 30 minutos. O bloqueio é realizado por motivos
     * de segurança.
     */
    public void bloquearSistema();

}



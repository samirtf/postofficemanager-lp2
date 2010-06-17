
package AutenticacaoUsuario;

import AutenticacaoUsuario.Usuario.Prioridade;
import Excecoes.AutenticacaoUsuarioExcecao;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public class AutenticacaoUsuario implements AutenticacaoUsuarioIF{

    private Integer contadorFalhasAutenticacao = 0;

    HashMap<String, Usuario> cadastros = new HashMap<String, Usuario>();
    public AutenticacaoUsuario(){
        try{
            ObjectInputStream objectIn = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("cadastrosUsuarios.txt")));
            cadastros = (HashMap<String, Usuario>)objectIn.readObject();
            objectIn.close();

            
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage() + e);
            e.printStackTrace();
        }

    }


    /**
     * Verifica se Login do Usuário é válido.
     * @param login
     *      O login do usuário.
     * @return
     *      True - Se o login for válido.
     *      False - Se o login não for válido.
     * @throws AutenticacaoUsuarioExcecao
     *      Se houver problemas na autenticação do login.
     */
    public boolean validaLogin(String login) throws AutenticacaoUsuarioExcecao{
        final int MIN_LENGTH_PASS = 8;// Tamanho mínimo do login.
        final int MAX_LENGTH_PASS = 12;// Tamanho máximo do login.

        // Se login for nulo, retorna false.
        if( login == null ){
            throw new AutenticacaoUsuarioExcecao(1);
        }
        // Se login for vazio, retorna false.
        else if( login.equals("")){
            throw new AutenticacaoUsuarioExcecao(2);
        }
        // Se login não for formado apenas por caracteres alfanuméricos,
        // retorna false.
        else if( !(login.matches("^[a-zA-Z0-9]*$") )){
            throw new AutenticacaoUsuarioExcecao(3);
        }
        // Se tamanho do login for menor que MIN_LENGTH_PASS, retorna false.
        else if( login.length() < MIN_LENGTH_PASS ){
            throw new AutenticacaoUsuarioExcecao(4);
        }
        // Se o tamanho do login for maior que MAX_MIN_PASS, retorna false.
        else if( login.length() > MAX_LENGTH_PASS ){
            throw new AutenticacaoUsuarioExcecao(5);
        }

        return false;
    }

    /**
     * Verifica se Senha do Usuário é válida.
     * @param login
     *      O login do usuário.
     * @param senha
     *      A senha do usuário.
     * @return
     *      True - Se a senha for válida.
     *      False - Se a senha não for válida.
     * @throws AutenticacaoUsuarioExcecao
     *      Se houver problemas na autenticação do login.
     */
    public boolean validaSenha(String login, String senha) 
            throws AutenticacaoUsuarioExcecao{
        final int MIN_LENGTH_PASS = 8;// Tamanho mínimo do login.
        final int MAX_LENGTH_PASS = 12;// Tamanho máximo do login.

        // Se senha for nulo, retorna false.
        if( senha == null ){
            throw new AutenticacaoUsuarioExcecao(6);
        }
        // Se senha for vazio, retorna false.
        else if( senha.equals("")){
            throw new AutenticacaoUsuarioExcecao(7);
        }
        // Se tamanho do senha for menor que MIN_LENGTH_PASS, retorna false.
        else if( senha.length() < MIN_LENGTH_PASS ){
            throw new AutenticacaoUsuarioExcecao(8);
        }
        // Se o tamanho do senha for maior que MAX_MIN_PASS, retorna false.
        else if( senha.length() > MAX_LENGTH_PASS ){
            throw new AutenticacaoUsuarioExcecao(9);
        }

        return false;
    }

    /**
     * Cadastra um usuário no sistema a partir de um login e uma senha. O cadastro
     * de usuários só deve ser realizado por um usuário Administrador.
     * @param login
     *      O login do usuário.
     * @param senha
     *      A senha do usuário.
     * @return
     *      True - Se o usuário for cadastrado.
     *      False - Se o usuário não for cadastrado.
     */
    public boolean cadastraUsuario(String login, String senha, Prioridade prioridade)
              throws AutenticacaoUsuarioExcecao{
        try{
            // Se prioridade for null, um usuário default será cadastrado
            if ( validaLogin(login) && validaSenha(login, senha) && prioridade == null){
                cadastros.put(login, new Usuario(login, senha));
                return true;
            }
            // Se prioridade for instancia de Prioridade, será criado um usuário
            // com prioridade pré-definida.
            else if( validaLogin(login) && validaSenha(login, senha) &&
                    prioridade.getClass() == Prioridade.class ){
                cadastros.put(login, new Usuario(login, senha, prioridade));
                return true;
            }
        }
        catch(AutenticacaoUsuarioExcecao autenticacaoUsuarioExcecao){
            System.out.println("Erro: " + autenticacaoUsuarioExcecao.getMessage() +
                    autenticacaoUsuarioExcecao);
        }
        return false;

    }

    /**
     * Loga usuário no sistema a partir de um login e uma senha.
     * @param login
     *      O login do usuário.
     * @param senha
     *      A senha do usuário.
     * @return
     *      True - Se o Login no sistema for realizado.
     *      False - Se o Login no sistema não for realizado.
     */
    public boolean logaNoSistema(String login, String senha) {
        if ( cadastros != null && cadastros.size()!= 0 &&
                contadorFalhasAutenticacao < 8 ){
            if( cadastros.get(login).getSenha().equals(senha) ){
                return true;
            }

            return false;
        }
        return false;
    }

    /**
     * Incrementa contador de falha na autenticação de 1.
     */
    public void contadorFalhaAutenticacao() {
        this.contadorFalhasAutenticacao++;
    }

    /**
     * Bloqueia o sistema por 30 minutos.
     */
    public void bloquearSistema() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    

}


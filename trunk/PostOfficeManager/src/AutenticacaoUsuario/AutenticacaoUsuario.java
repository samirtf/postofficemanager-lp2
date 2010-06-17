
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
     * Verifica se Login do Usu�rio � v�lido.
     * @param login
     *      O login do usu�rio.
     * @return
     *      True - Se o login for v�lido.
     *      False - Se o login n�o for v�lido.
     * @throws AutenticacaoUsuarioExcecao
     *      Se houver problemas na autentica��o do login.
     */
    public boolean validaLogin(String login) throws AutenticacaoUsuarioExcecao{
        final int MIN_LENGTH_PASS = 8;// Tamanho m�nimo do login.
        final int MAX_LENGTH_PASS = 12;// Tamanho m�ximo do login.

        // Se login for nulo, retorna false.
        if( login == null ){
            throw new AutenticacaoUsuarioExcecao(1);
        }
        // Se login for vazio, retorna false.
        else if( login.equals("")){
            throw new AutenticacaoUsuarioExcecao(2);
        }
        // Se login n�o for formado apenas por caracteres alfanum�ricos,
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
     * Verifica se Senha do Usu�rio � v�lida.
     * @param login
     *      O login do usu�rio.
     * @param senha
     *      A senha do usu�rio.
     * @return
     *      True - Se a senha for v�lida.
     *      False - Se a senha n�o for v�lida.
     * @throws AutenticacaoUsuarioExcecao
     *      Se houver problemas na autentica��o do login.
     */
    public boolean validaSenha(String login, String senha) 
            throws AutenticacaoUsuarioExcecao{
        final int MIN_LENGTH_PASS = 8;// Tamanho m�nimo do login.
        final int MAX_LENGTH_PASS = 12;// Tamanho m�ximo do login.

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
     * Cadastra um usu�rio no sistema a partir de um login e uma senha. O cadastro
     * de usu�rios s� deve ser realizado por um usu�rio Administrador.
     * @param login
     *      O login do usu�rio.
     * @param senha
     *      A senha do usu�rio.
     * @return
     *      True - Se o usu�rio for cadastrado.
     *      False - Se o usu�rio n�o for cadastrado.
     */
    public boolean cadastraUsuario(String login, String senha, Prioridade prioridade)
              throws AutenticacaoUsuarioExcecao{
        try{
            // Se prioridade for null, um usu�rio default ser� cadastrado
            if ( validaLogin(login) && validaSenha(login, senha) && prioridade == null){
                cadastros.put(login, new Usuario(login, senha));
                return true;
            }
            // Se prioridade for instancia de Prioridade, ser� criado um usu�rio
            // com prioridade pr�-definida.
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
     * Loga usu�rio no sistema a partir de um login e uma senha.
     * @param login
     *      O login do usu�rio.
     * @param senha
     *      A senha do usu�rio.
     * @return
     *      True - Se o Login no sistema for realizado.
     *      False - Se o Login no sistema n�o for realizado.
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
     * Incrementa contador de falha na autentica��o de 1.
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



package servicosAutenticacaoUsuario;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.LinkedList;

import servicosAutenticacaoUsuario.Usuario.Prioridade;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public class AutenticacaoUsuario implements AutenticacaoUsuarioIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Mapa de usuarios cadastrados.
    private HashMap<String, Usuario> cadastros;
    
	private LinkedList<ErroAutenticacaoUsuario>  listaDeErros;
	
	private LinkedList<BloqueioSistema> listaDeBloqueios;
	
	private BloqueioSistema bloqueioSistema = null;
	
	private boolean sistemaDesbloqueado = true;

	// Contador do numero de falhas geradas durante o login.
    private Integer contadorFalhasAutenticacao = 0;

    
    public AutenticacaoUsuario(){
    	
    	// Recupera usuarios cadastrados do banco de dados cadastrosUsuarios.txt.
        try{
            ObjectInputStream objectIn = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("cadastros_usuarios.txt")));
            HashMap<String, Usuario> readObject = (HashMap<String, Usuario>)objectIn.readObject();
			cadastros = readObject;
            objectIn.close();

            
        }catch(Exception e){
            System.err.println("Erro: " + e.getMessage() + e);
            e.printStackTrace();
        }
        
        // Recupera a lista de erros de autenticacao.
        try{
            ObjectInputStream objectIn = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("lista_erros_autenticacao.txt")));
            LinkedList<ErroAutenticacaoUsuario> readObject = 
            	   (LinkedList<ErroAutenticacaoUsuario>)objectIn.readObject();
            listaDeErros = readObject;
            objectIn.close();
            
        }catch(Exception e){
            System.err.println("Erro: " + e.getMessage() + e);
            e.printStackTrace();
        }
        
        // Recupera a lista de erros de bloqueio de sistema.
        try{
            ObjectInputStream objectIn = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("lista_bloqueios.txt")));
            LinkedList<BloqueioSistema> readObject = 
            	   (LinkedList<BloqueioSistema>)objectIn.readObject();
            listaDeBloqueios = readObject;
            objectIn.close();
            
        }catch(Exception e){
            System.err.println("Erro: " + e.getMessage() + e);
            e.printStackTrace();
        }
        
        // Recupera a lista de erros de bloqueio de sistema.
        if ( listaDeBloqueios != null && !listaDeBloqueios.isEmpty() ){
        	bloqueioSistema = listaDeBloqueios.getLast();
        	sistemaDesbloqueado = bloqueioSistema.getDesbloqueado();
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
     * Gera um erro de autenticacao.
     * @return
     * 		True - Se o erro de autenticacao for gerado e adicionada na lista de erros
     *             de autenticacao.
     *      False - Se não o erro nao for gerado.
     */
    public boolean geraErroAutenticacao(){
    	if( listaDeErros != null ){
    		listaDeErros.addLast(new ErroAutenticacaoUsuario());
    		return true;
    	}
    	return false;
    }// fim do metodo geraErroAutenticacao.
    
    /**
     * Gera um erro de autenticacao a partir de um login de usuário.
     * @param login
     * 		O login do usuário.
     * @return
     * 		True - Se o erro de autenticacao for gerado e adicionada na lista de erros
     *             de autenticacao.
     *      False - Se não o erro nao for gerado.
     */
    public boolean geraErroAutenticacao(String login){
    	if( login == null ){
    		login = "";
    	}
    	if( listaDeErros != null ){
    		listaDeErros.addLast(new ErroAutenticacaoUsuario(login));
    		return true;
    	}
    	return false;
    }
    
    /**
     *  M�todo criado com o intuito de evitar a entrada no sistema por For�a-Bruta.
     *  Bloqueia o sistema por 30 minutos.
     */
    public void bloquearSistema() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    

}


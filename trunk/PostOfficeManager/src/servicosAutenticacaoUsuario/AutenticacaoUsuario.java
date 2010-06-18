
package servicosAutenticacaoUsuario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    
    @SuppressWarnings("unchecked")
	public AutenticacaoUsuario() throws IOException{
    	cadastros = new HashMap<String, Usuario>();
    	listaDeErros = new LinkedList<ErroAutenticacaoUsuario>();
    	listaDeBloqueios = new LinkedList<BloqueioSistema>();
    	
    	// Recupera usuarios cadastrados do banco de dados cadastrosUsuarios.txt.
    	ObjectInputStream inCadastrosUsuarios = null;
        try{
        	inCadastrosUsuarios = new ObjectInputStream(
                    new FileInputStream("cadastros_usuarios.dat"));
        	
        	cadastros = (HashMap<String, Usuario>) inCadastrosUsuarios.readObject();
            
        }catch(Exception e1){
        	ObjectOutputStream out = null;
        	try {
            	Usuario admin = new Usuario("admin", "admin", Prioridade.ADMINISTRADOR);
            	cadastros.put("admin", admin);
            	out = new ObjectOutputStream(
                        new FileOutputStream("cadastros_usuarios.dat"));
            	out.writeObject(cadastros);
    			out.close();
        	} catch (Exception e2) {
        		e2.printStackTrace();
			}finally{
				out.close();
			}
        }finally{
        	inCadastrosUsuarios.close();
        }
        
        // Recupera a lista de erros de autenticacao.
        ObjectInputStream inErrosAutenticacao = null;
        try{
        	inErrosAutenticacao = new ObjectInputStream(
                    new FileInputStream("erros_autenticacao.dat"));
        	
        	listaDeErros = (LinkedList<ErroAutenticacaoUsuario>) inErrosAutenticacao.readObject();
            
        }catch(Exception e1){
        	ObjectOutputStream out = null;
        	try {
            	 out = new ObjectOutputStream(
                        new FileOutputStream("erros_autenticacao.dat"));
            	out.writeObject(listaDeErros);
    			out.close();
        	} catch (Exception e2) {
        		e2.printStackTrace();
			}finally{
				
			}
        }finally{
        	inErrosAutenticacao.close();
        }
        
        // Recupera a lista de erros de bloqueio de sistema.
        ObjectInputStream inBloqueioSistema = null;
        try{
        	inBloqueioSistema = new ObjectInputStream(
                    new FileInputStream("bloqueios_sistema.dat"));
        	
        	listaDeBloqueios = (LinkedList<BloqueioSistema>) inBloqueioSistema.readObject();
            
        }catch(Exception e1){
        	ObjectOutputStream out = null;
        	try {
            	out = new ObjectOutputStream(
                        new FileOutputStream("bloqueios_sistema.dat"));
            	out.writeObject(listaDeBloqueios);
    			out.close();
        	} catch (Exception e2) {
        		e2.printStackTrace();
			}finally{
				out.close();
			}
        }finally{
        	inBloqueioSistema.close();
        }
        
        // Recupera a lista de erros de bloqueio de sistema.
        if ( listaDeBloqueios != null && !listaDeBloqueios.isEmpty() ){
        	bloqueioSistema = listaDeBloqueios.getLast();
        	sistemaDesbloqueado = bloqueioSistema.getDesbloqueado();
        }
        

    }// fim do construtor.

    /**
     * Recupera o mapa de registros dos usuarios.
     * @return
     * 		O mapa de registros dos usuarios.
     */
    public HashMap<String, Usuario> getCadastrosUsuarios(){
    	return this.cadastros;
    }// fim do metodo getCadastrosUsuarios.
    
    /**
     * Recupera a lista de erros de autenticacao.
     * @return
     * 		A lista de erros de autenticacao.
     */
    public LinkedList<ErroAutenticacaoUsuario> getListaErros(){
    	return this.listaDeErros;
    }// fim do metodo getListaErros.
    
    /**
     * Recupera a lista de Bloqueios de Sistema.
     * @return
     * 		Lista de bloqueios do sistema.
     */
    public LinkedList<BloqueioSistema> getListaBloqueios(){
    	return this.listaDeBloqueios;
    }// fim do metodo getListaBloqueios.
    
    /**
     * Recupera o bloqueio de sistema atual.
     * @return
     * 		O bloqueio de sistema atual.
     */
    public BloqueioSistema getBloqueiosSistema(){
    	return this.bloqueioSistema;
    }// fim do metodo getBloqueioSistema.

    /**
     * Verifica se Login do Usuario eh valido.
     * @param login
     *      O login do usuario.
     * @return
     *      True - Se o login for valido.
     *      False - Se o login nao for valido.
     * @throws AutenticacaoUsuarioExcecao
     *      Se houver problemas na autenticacao do login.
     */
    public boolean validaLogin(String login) throws AutenticacaoUsuarioExcecao{
        final int MIN_LENGTH_PASS = 8;// Tamanho minimo do login.
        final int MAX_LENGTH_PASS = 12;// Tamanho maximo do login.

        // Se login for nulo, retorna false.
        if( login == null ){
            throw new AutenticacaoUsuarioExcecao(1);
        }
        // Se login for vazio, retorna false.
        else if( login.equals("")){
            throw new AutenticacaoUsuarioExcecao(2);
        }
        // Se login nao for formado apenas por caracteres alfanumericos,
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
     * Verifica se Senha do Usuario eh valida.
     * @param login
     *      O login do usu�rio.
     * @param senha
     *      A senha do usu�rio.
     * @return
     *      True - Se a senha for valida.
     *      False - Se a senha nao for valida.
     * @throws AutenticacaoUsuarioExcecao
     *      Se houver problemas na autenticacao do login.
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
     * de usuarios s� deve ser realizado por um usuario Administrador.
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
                contadorFalhasAutenticacao < 10 ){
            if( cadastros.get(login).getSenha().equals(Criptografia.criptografa(login, senha)) ){
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
     * @throws IOException
     * 		Em caso de haver erros ao manipular arquivos.
     */
    public boolean geraErroAutenticacao(String login) throws IOException{
    	if( login == null ){
    		login = "";
    	}
    	if( listaDeErros != null ){
    		listaDeErros.addLast(new ErroAutenticacaoUsuario(login));
    		ObjectOutputStream out = null;
    		try {
            	out = new ObjectOutputStream(
                        new FileOutputStream("erros_autenticacao.dat"));
            	out.writeObject(listaDeErros);
    			
        	}catch (Exception e) {
        		e.printStackTrace();
			}finally{
				out.close();
			}
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
    
    public static void main(String[] args) {
    	try{
    		AutenticacaoUsuario a = new AutenticacaoUsuario();

    		System.out.println(a.logaNoSistema("admin", "admin"));
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
	}
}


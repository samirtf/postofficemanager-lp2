
package servicosAutenticacaoUsuario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;

import servicosAutenticacaoUsuario.Usuario.Prioridade;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 2.1
 * @since 11/06/2010
 */
public class AutenticacaoUsuario implements AutenticacaoUsuarioIF{
	
	/**
	 * serialVersionUID
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
        	} catch (Exception e2) {
        		e2.printStackTrace();
			}finally{
				out.close();
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
     * Configura o Bloqueio de Sistema.
     * @param bloqueioSistema
     * 		O bloqueio de Sistema.
     */
    public void setBloqueioSistema(BloqueioSistema bloqueioSistema){
    	this.bloqueioSistema = bloqueioSistema;
    }// fim do metodo setBloqueioSistema.
    
    /**
     * Recupera o bloqueio de sistema atual.
     * @return
     * 		O bloqueio de sistema atual.
     */
    public BloqueioSistema getBloqueioSistema(){
    	return this.bloqueioSistema;
    }// fim do metodo getBloqueioSistema.
    
    /**
     * Recupera o estado de acesso ao sistema.
     * @return
     * 		True - Se o sistema estiver desbloqueado.
     * 		False - Se o sistema nao estiver desbloqueado.
     */
    public boolean getSistemaDesbloqueado(){
    	return this.sistemaDesbloqueado;
    }// fim do metodo getSistemaDesbloqueado.
    
    /**
     * Zera o contador de falhas de autenticacao.
     */
    public void zerarContadorFalhasAutenticacao(){
    	this.contadorFalhasAutenticacao = 0;
    }// fim do metodo zerarContadorFalhasAutenticacao.
    
    /**
     * Recupera o valor do contador de falhas de autenticacao.
     * @return
     * 		O valor do contador de falhas de autenticacao.
     */
    public Integer getContadorFalhasAutenticacao(){
    	return this.contadorFalhasAutenticacao;
    }// fim do metodo getContadorFalhasAutenticacao.

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
    }// fim do metodo validaLogin.
    

    /**
     * Verifica se Senha do Usuario eh valida.
     * @param login
     *      O login do usuario.
     * @param senha
     *      A senha do usuario.
     * @return
     *      True - Se a senha for valida.
     *      False - Se a senha nao for valida.
     * @throws AutenticacaoUsuarioExcecao
     *      Se houver problemas na autenticacao do login.
     */
    public boolean validaSenha(String login, String senha) 
            throws AutenticacaoUsuarioExcecao{
        final int MIN_LENGTH_PASS = 8;// Tamanho mï¿½nimo do login.
        final int MAX_LENGTH_PASS = 12;// Tamanho mï¿½ximo do login.

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
    }// fim do metodo validaSenha.

    /**
     * Cadastra um usuario no sistema a partir de um login e uma senha. O cadastro
     * de usuarios soh deve ser realizado por um usuario Administrador.
     * @param login
     *      O login do usuario.
     * @param senha
     *      A senha do usuario.
     * @return
     *      True - Se o usuario for cadastrado.
     *      False - Se o usuario nao for cadastrado.
     * @throws IOException 
     */
    public boolean cadastraUsuario(String login, String senha, Prioridade prioridade)
              throws AutenticacaoUsuarioExcecao, IOException{
    	
    	// observar a possibilidade de ter sido armazenado apenas na memoria, situacao
    	// na qual o novo cadastro nao tera sido armazenado em arquivo.
        try{
            // Se prioridade for null, um usuario default sera cadastrado
            if ( validaLogin(login) && validaSenha(login, senha) && prioridade == null){
                cadastros.put(login, new Usuario(login, senha));
            }
            // Se prioridade for instancia de Prioridade, serie criado um usuario
            // com prioridade pre-definida.
            else if( validaLogin(login) && validaSenha(login, senha) &&
                    prioridade.getClass() == Prioridade.class ){
                cadastros.put(login, new Usuario(login, senha, prioridade));
            }
        }
        catch(AutenticacaoUsuarioExcecao autenticacaoUsuarioExcecao){
            autenticacaoUsuarioExcecao.printStackTrace();
            return false;
        }
        
        ObjectOutputStream out = null;
    	try {
        	out = new ObjectOutputStream(
                    new FileOutputStream("cadastros_usuarios.dat"));
        	out.writeObject(cadastros);
    	}catch (Exception e) {
    		e.printStackTrace();
    		// se a excecao for chamada, o novo cadastro nao tera sido persistido.
		}finally{
			out.close();
		}
        
		return true;

    }// fim do metodo cadastraUsuario.

    /**
     * Loga usuario no sistema a partir de um login e uma senha.
     * @param login
     *      O login do usuario.
     * @param senha
     *      A senha do usuario.
     * @return
     *      True - Se o Login no sistema for realizado.
     *      False - Se o Login no sistema nao for realizado.
     */
    public boolean logaNoSistema(String login, String senha) {
        return cadastros != null && cadastros.size()!= 0 && 
            contadorFalhasAutenticacao < 10 && 
            cadastros.get(login).getSenha().
                      equals(Criptografia.criptografa(login, senha));
            
    }// fim do metodo logaNoSistema.

    /**
     * Incrementa contador de falha na autenticacao de 1.
     */
    public void incrementaContadorFalhaAutenticacao() {
        this.contadorFalhasAutenticacao++;
    }// fim do contadorFalhaAutenticacao.
    
    /**
     * Configura o estado do sistema. Se está bloqueado ou desbloqueado.
     * @param desbloqueado
     * 		True - Para desbloquear sistema.
     * 		False - Para bloquear sistema.
     */
    public void setSistemaDesbloqueado(boolean desbloqueado){
    	this.sistemaDesbloqueado = desbloqueado;
    }// fim do metodo setSistemaDesbloqueado.

    /**
     * Gera um erro de autenticacao.
     * @return
     * 		True - Se o erro de autenticacao for gerado e adicionada na lista de erros
     *             de autenticacao.
     *      False - Se nao o erro nao for gerado.
     * @throws IOException 
     */
    public boolean geraErroAutenticacao() throws IOException{
    	if( this.getContadorFalhasAutenticacao() >= 10){
    		return false;
    	}
    	if( listaDeErros != null ){
    		listaDeErros.addLast(new ErroAutenticacaoUsuario());
    		this.incrementaContadorFalhaAutenticacao();
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
    }// fim do metodo geraErroAutenticacao.
    
    /**
     * Gera um erro de autenticacao a partir de um login de usuario.
     * @param login
     * 		O login do usuario.
     * @return
     * 		True - Se o erro de autenticacao for gerado e adicionada na lista de erros
     *             de autenticacao.
     *      False - Se nao o erro nao for gerado.
     * @throws IOException
     * 		Em caso de haver erros ao manipular arquivos.
     */
    public boolean geraErroAutenticacao(String login) throws IOException{
    	if( this.getContadorFalhasAutenticacao() >= 10){
    		return false;
    	}
    	if( login == null ){
    		login = "";
    	}
    	if( listaDeErros != null ){
    		listaDeErros.addLast(new ErroAutenticacaoUsuario(login));
    		this.incrementaContadorFalhaAutenticacao();
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
    }// fim do metodo geraErroAutenticacao.
    
    /**
     *  Metodo criado com o intuito de evitar a entrada no sistema por Forca-Bruta.
     *  Bloqueia o sistema por 30 minutos.
     * @throws IOException 
     */
    public boolean bloquearSistema(ErroAutenticacaoUsuario erroAutenticacaoUsuario) throws IOException {
    	if( this.getContadorFalhasAutenticacao() != 9 ){
    		return false;
    	}
        if(listaDeBloqueios != null){
        	listaDeBloqueios.addLast(new BloqueioSistema(listaDeErros.getLast()));
        	setBloqueioSistema(listaDeBloqueios.getLast());
        	this.zerarContadorFalhasAutenticacao();
        	this.setSistemaDesbloqueado(false);
    		ObjectOutputStream out = null;
    		try {
            	out = new ObjectOutputStream(
                        new FileOutputStream("bloqueios_sistema.dat"));
            	out.writeObject(listaDeBloqueios);
            	
    			
        	}catch (Exception e) {
        		e.printStackTrace();
			}finally{
				out.close();
			}
    		return true;
        }
		return false;
    }// fim do metodo bloquearSistema.
    
    public boolean desbloquearSistema(){
    	if( this.getSistemaDesbloqueado() == true ){
    		return false;
    	}
    	if ( this.getBloqueioSistema().getPrevisaoDesbloqueio().before(Calendar.getInstance()) ){
    		this.setSistemaDesbloqueado(true);
    		this.setBloqueioSistema(null);
    		return true;
    	}
    	
    	return false;
    }
    
}// fim da classe AutenticacaoUsuario.


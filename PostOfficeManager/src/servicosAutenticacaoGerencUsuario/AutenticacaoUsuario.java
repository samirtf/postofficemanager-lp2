
package servicosAutenticacaoGerencUsuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import servicosAutenticacaoGerencUsuario.Usuario.Prioridade;

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
	
	private BloqueioSistema bloqueioSistema = new BloqueioSistema();
	
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
    	ObjectOutputStream outCadastrosUsuarios = null;

    	if( new File("cadastros_usuarios.dat").exists() ){
    		try{
            	inCadastrosUsuarios = new ObjectInputStream(
                        new FileInputStream("cadastros_usuarios.dat"));
            	
            	cadastros = (HashMap<String, Usuario>) inCadastrosUsuarios.readObject();
                
            }catch(Exception e){
            	e.printStackTrace();
            }finally{
            	inCadastrosUsuarios.close();
            }
    	}else{
    		try {
            	Usuario admin = new Usuario("administrador", "administrador", Prioridade.ADMINISTRADOR);
            	cadastros.put("administrador", admin);
            	outCadastrosUsuarios = new ObjectOutputStream(
                        new FileOutputStream("cadastros_usuarios.dat"));
            	outCadastrosUsuarios.writeObject(cadastros);
    			
        	}catch (Exception e) {
        		e.printStackTrace();
			}finally{
				outCadastrosUsuarios.close();
			}
    	}
        
        
        // Recupera a lista de erros de autenticacao.
        ObjectInputStream inErrosAutenticacao = null;
        ObjectOutputStream outErrosAutenticacao = null;
        
        if( new File("erros_autenticacao.dat").exists() ){
    		try{
    			inErrosAutenticacao = new ObjectInputStream(
                        new FileInputStream("erros_autenticacao.dat"));
            	
            	listaDeErros = (LinkedList<ErroAutenticacaoUsuario>) inErrosAutenticacao.readObject();
                
            }catch(Exception e){
            	e.printStackTrace();
            }finally{
            	inErrosAutenticacao.close();
            }
    	}else{
    		try {
    			outErrosAutenticacao = new ObjectOutputStream(
                        new FileOutputStream("erros_autenticacao.dat"));
        		outErrosAutenticacao.writeObject(listaDeErros);
    			
        	}catch (Exception e) {
        		e.printStackTrace();
			}finally{
				outErrosAutenticacao.close();
			}
    	}
        
        // Recupera a lista de erros de bloqueio de sistema.
        ObjectInputStream inBloqueioSistema = null;
        ObjectOutputStream outBloqueioSistema = null;
        
        if( new File("bloqueios_sistema.dat").exists() ){
    		try{
    			inBloqueioSistema = new ObjectInputStream(
                        new FileInputStream("bloqueios_sistema.dat"));
            	
            	listaDeBloqueios = (LinkedList<BloqueioSistema>) inBloqueioSistema.readObject();
                
            }catch(Exception e){
            	e.printStackTrace();
            }finally{
            	inBloqueioSistema.close();
            }
    	}else{
    		try {
    			outBloqueioSistema = new ObjectOutputStream(
                        new FileOutputStream("bloqueios_sistema.dat"));
        		outBloqueioSistema.writeObject(listaDeBloqueios);
    			
        	}catch (Exception e) {
        		e.printStackTrace();
			}finally{
				outBloqueioSistema.close();
			}
    	}
        
        // Recupera erros do dia.
        this.recuperaErrosDoDia();
        
        // Recupera bloqueio de sistema.
        this.recuperaBloqueioSistema();
                   
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
     */
    public boolean validaLogin(String login){
        final int MIN_LENGTH_PASS = 8;// Tamanho minimo do login.
        final int MAX_LENGTH_PASS = 13;// Tamanho maximo do login.

        // Se login for nulo, retorna false.
        if( login == null ){
            return false;
        }
        // Se login for vazio, retorna false.
        else if( login.trim().equals("")){
        	return false;
        }
        // Se login nao for formado apenas por caracteres alfanumericos,
        // retorna false.
        else if( !(login.matches("^[a-zA-Z0-9]*$") )){
        	return false;
        }
        // Se tamanho do login for menor que MIN_LENGTH_PASS, retorna false.
        else if( login.length() < MIN_LENGTH_PASS ){
        	return false;
        }
        // Se o tamanho do login for maior que MAX_MIN_PASS, retorna false.
        else if( login.length() > MAX_LENGTH_PASS ){
        	return false;
        }

        return true;
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
     */
    public boolean validaSenha(String login, String senha){
        final int MIN_LENGTH_PASS = 8;// Tamanho mï¿½nimo do login.
        final int MAX_LENGTH_PASS = 13;// Tamanho mï¿½ximo do login.

        // Se senha for nulo, retorna false.
        if( senha == null ){
        	return false;
        }
        // Se senha for vazio, retorna false.
        else if( senha.trim().equals("")){
        	return false;
        }
        // Se tamanho do senha for menor que MIN_LENGTH_PASS, retorna false.
        else if( senha.length() < MIN_LENGTH_PASS ){
        	return false;
        }
        // Se o tamanho do senha for maior que MAX_MIN_PASS, retorna false.
        else if( senha.length() > MAX_LENGTH_PASS ){
        	return false;
        }

        return true;
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
    public boolean cadastraUsuario(String login, String senha, Prioridade prioridade)throws IOException{
    	
    	// observar a possibilidade de ter sido armazenado apenas na memoria, situacao
    	// na qual o novo cadastro nao tera sido armazenado em arquivo.
        
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
        
        ObjectOutputStream out = null;
    	try {
        	out = new ObjectOutputStream(
                    new FileOutputStream("cadastros_usuarios.dat"));
        	out.writeObject(cadastros);
    	}catch (IOException ioe) {
    		ioe.printStackTrace();
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
     * @throws Exception 
     */
    public boolean logaNoSistema(String login, String senha) throws Exception {
        return (login != null && !login.trim().equals("") && senha !=null && !senha.trim().equals("")) 
            && cadastros != null && cadastros.size()!= 0 && 
            contadorFalhasAutenticacao < 10 && 
            cadastros.containsKey(login) &&
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
    	if( this.getSistemaDesbloqueado() == false){
    		return false;
    	}
    	if( listaDeErros != null ){
    		listaDeErros.addLast(new ErroAutenticacaoUsuario());
    		this.incrementaContadorFalhaAutenticacao();
    		
    		// so bloqueia o sistema se o contador for igual a 10.
			this.bloquearSistema(listaDeErros.getLast());
			
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
    	if( this.getSistemaDesbloqueado() == false){
    		return false;
    	}
    	if( login == null ){
    		login = "";
    	}
    	if( listaDeErros != null ){
    		listaDeErros.addLast(new ErroAutenticacaoUsuario(login));
    		this.incrementaContadorFalhaAutenticacao();
    		
    		// so bloqueia o sistema se o contador for igual a 10.
			this.bloquearSistema(listaDeErros.getLast());
    		
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
    	if( this.getContadorFalhasAutenticacao() != 10 ){
    		return false;
    	}
        if(listaDeBloqueios != null){
        	listaDeBloqueios.addLast(new BloqueioSistema(listaDeErros.getLast()));
        	setBloqueioSistema(listaDeBloqueios.getLast());
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
    		this.zerarContadorFalhasAutenticacao();
    		return true;
    	}
    	
    	return false;
    }
    
    public boolean recuperaErrosDoDia(){
    	if ( listaDeErros == null || listaDeErros.isEmpty() ){
    		return false;
    	}
    	Integer cont = 0;
    	GregorianCalendar instante = new GregorianCalendar();
        String anoInit = String.format("%1$tY", instante);
        String diaDoAnoInit = String.format("%d", instante.get(Calendar.DAY_OF_YEAR));
        String idParcialInit = anoInit + "/" + diaDoAnoInit;
        
        Iterator<ErroAutenticacaoUsuario> iteraNaListaDeErros =  listaDeErros.iterator();
        while(iteraNaListaDeErros.hasNext()){
        	ErroAutenticacaoUsuario erro = (ErroAutenticacaoUsuario) iteraNaListaDeErros.next(); 
        	if( idParcialInit.equals(erro.getIdParcial())){
        		cont++;
        	}
        }
        this.contadorFalhasAutenticacao = cont%10;
        return true;
        
    }
    
    public void recuperaBloqueioSistema(){
    	if ( listaDeBloqueios != null && !listaDeBloqueios.isEmpty() ){
        	if( listaDeBloqueios.getLast().getPrevisaoDesbloqueio().after(new GregorianCalendar()) ){
        		bloqueioSistema = listaDeBloqueios.getLast();
            	sistemaDesbloqueado = bloqueioSistema.getDesbloqueado();
        	}
        	else{
        		//bloqueioSistema = null;
        		listaDeBloqueios.getLast().setDesbloqueado(true);
        		this.sistemaDesbloqueado = true;
        	}
        }// fim de recupera bloqueio de sistema
    }
    
    public static void main(String[] args){
    	try{
    		System.out.println(44%10);
    		AutenticacaoUsuario ab = new AutenticacaoUsuario();
    		System.out.println(ab.logaNoSistema("admin", "admin"));
    		System.out.println(ab.logaNoSistema("joao", "admin"));
    		//ab.listaDeErros.clear();
    		//ab.listaDeBloqueios.clear();
    		System.out.println(ab.getListaErros().size());
    		System.out.println(ab.getListaBloqueios().size());
    		System.out.println();
    		ab.geraErroAutenticacao();
    		System.out.println(ab.getListaErros().size());
    		System.out.println(ab.getListaBloqueios().size());
    		System.out.println(ab.sistemaDesbloqueado);
    		System.out.println();
    		
    		ab.geraErroAutenticacao();
    		ab.geraErroAutenticacao();
    		ab.geraErroAutenticacao();
    		/*ab.geraErroAutenticacao();
    		ab.geraErroAutenticacao();
    		ab.geraErroAutenticacao();
    		ab.geraErroAutenticacao();
    		ab.geraErroAutenticacao();
    		*/
    		System.out.println(ab.getListaErros().size());
    		System.out.println(ab.getListaBloqueios().size());
    		
    		ab.geraErroAutenticacao();
    		System.out.println(ab.getListaErros().size());
    		System.out.println(ab.getListaBloqueios().size());
    		
    		ab.geraErroAutenticacao();
    		System.out.println(ab.getListaErros().size());
    		System.out.println(ab.getListaBloqueios().size());
    		
    		System.out.println("oifinal");
    		
    		System.out.println("oi");
    		System.out.println();
    		//mudar novamente para 30 minutos
    		System.out.println(ab.contadorFalhasAutenticacao);
    		System.out.println(ab.getBloqueioSistema().getPrevisaoDesbloqueio());
    		ab.getCadastrosUsuarios();
    		
    		
    		System.out.println(ab.getBloqueioSistema().getPrevisaoDesbloqueio());
    		System.out.println(GregorianCalendar.getInstance());
    		System.out.println(ab.getCadastrosUsuarios().size());
    		System.out.println(ab.validaLogin("Deusehfiel"));
    		GerenciamentoUsuario.cadastraUsuarioPadrao(ab, "Deusehfiel", "Deusehfiel");
    		//GerenciamentoUsuario.cadastraUsuarioPadrao(ab, "Deusehamor", "Deusehfiel");
    		GerenciamentoUsuario.removeUsuario(ab, "Deusehamor");
    		System.out.println(ab.getCadastrosUsuarios().size());
    		//System.out.println(ab.getListaErros().getLast());
    		System.out.println(ab.getCadastrosUsuarios().get("administrador"));
    		System.out.println(ab.getCadastrosUsuarios().entrySet());
    		GerenciamentoUsuario.gerarRelatorioErrosAutenticacaoDiario(ab, "administrador");
    		GerenciamentoUsuario.gerarRelatorioErrosAutenticacaoTotal(ab, "administrador");
    		GerenciamentoUsuario.gerarRelatorioBloqueioSistemaDiario(ab, "administrador");
    		GerenciamentoUsuario.gerarRelatorioBloqueioSistemaTotal(ab, "administrador");
    		
    	}catch(Exception e){
    		System.out.println(e);
    		e.printStackTrace();
    	}
    	
    }
    
}// fim da classe AutenticacaoUsuario.


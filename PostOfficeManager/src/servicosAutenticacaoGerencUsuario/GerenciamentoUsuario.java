package servicosAutenticacaoGerencUsuario;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

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
* @since 13/06/2010
*
*/
public class GerenciamentoUsuario {

	public static boolean cadastraUsuarioPadrao(AutenticacaoUsuario autentUsuario, 
			String login, String senha) throws IOException, AutenticacaoUsuarioExcecao{
		
		// observar a possibilidade de ter sido armazenado apenas na memoria, situacao
	    // na qual o novo cadastro nao tera sido armazenado em arquivo.
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		
		if( autentUsuario.validaLogin(login) && autentUsuario.validaSenha(login, senha)&& 
			  listaUsuarios != null && !listaUsuarios.containsKey(login)){
			
			try {
				listaUsuarios.put(login, new Usuario(login, senha));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
  
        ObjectOutputStream out = null;
	    try {
  	        out = new ObjectOutputStream( new FileOutputStream("cadastros_usuarios.dat"));
  	        out.writeObject(autentUsuario.getCadastrosUsuarios());
  	        
	    }catch (Exception e) {
	      	e.printStackTrace();
	        // se a excecao for chamada, o novo cadastro nao tera sido persistido.
	    }finally{
	      	out.close();
	    }
		return true;
	}
	
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
	public static boolean cadastraUsuario(AutenticacaoUsuario autentUsuario, 
			String login, String senha, Prioridade prioridade)
	             throws AutenticacaoUsuarioExcecao, IOException{
	
	    // observar a possibilidade de ter sido armazenado apenas na memoria, situacao
	    // na qual o novo cadastro nao tera sido armazenado em arquivo.
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
        // Se prioridade for null, um usuario default sera cadastrado
		if ( autentUsuario.validaLogin(login) && autentUsuario.validaSenha(login, senha) && 
				listaUsuarios != null && !listaUsuarios.containsKey(login)){
			
			try {
				listaUsuarios.put(login, new Usuario(login, senha, prioridade));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
  
        ObjectOutputStream out = null;
	    try {
  	        out = new ObjectOutputStream( new FileOutputStream("cadastros_usuarios.dat"));
  	        out.writeObject(autentUsuario.getCadastrosUsuarios());
	    }catch (Exception e) {
	      	e.printStackTrace();
	        // se a excecao for chamada, o novo cadastro nao tera sido persistido.
	    }finally{
	      	out.close();
	    }
  
	    return true;

	}// fim do metodo cadastraUsuario.
	
	public static boolean removeUsuario(AutenticacaoUsuario autentUsuario, String login) throws IOException{
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		
		if( listaUsuarios.containsKey(login) ){
			listaUsuarios.remove(login);
			
			ObjectOutputStream out = null;
		    try {
	  	        out = new ObjectOutputStream( new FileOutputStream("cadastros_usuarios.dat"));
	  	        out.writeObject(autentUsuario.getCadastrosUsuarios());
		    }catch (Exception e) {
		      	e.printStackTrace();
		        // se a excecao for chamada, o novo cadastro nao tera sido persistido.
		    }finally{
		      	out.close();
		    }	
			
			return true;
		}
		return false;
	}// fim do metodo removeUsuario.
	
	public static boolean alteraLoginUsuario(AutenticacaoUsuario autentUsuario, 
			String login, String novoLogin) throws IOException, AutenticacaoUsuarioExcecao{
		
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		if( listaUsuarios.containsKey(login) &&
				autentUsuario.validaLogin(novoLogin)){
			listaUsuarios.get(login).setLogin(novoLogin);
			
		}
		
		ObjectOutputStream out = null;
	    try {
  	        out = new ObjectOutputStream( new FileOutputStream("cadastros_usuarios.dat"));
  	        out.writeObject(autentUsuario.getCadastrosUsuarios());
	    }catch (Exception e) {
	      	e.printStackTrace();
	        // se a excecao for chamada, o novo cadastro nao tera sido persistido.
	    }finally{
	      	out.close();
	    }
		
		return true;
		
	}// fim do metodo alteraLoginUsuario.
	
	public static boolean alteraSenhaUsuario(AutenticacaoUsuario autentUsuario, 
			String login, String senha, String novaSenha) throws Exception{
		
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		try{
			if( listaUsuarios.containsKey(login) &&
					autentUsuario.validaSenha(login, novaSenha)){
				
				if( listaUsuarios.get(login).getSenha().
						equals(Criptografia.criptografa(login, senha))){
					listaUsuarios.get(login).setSenha(novaSenha);
				}
				
			}
		}catch(AutenticacaoUsuarioExcecao aue){
			aue.printStackTrace();
			return false;
		}
		
		ObjectOutputStream out = null;
	    try {
  	        out = new ObjectOutputStream( new FileOutputStream("cadastros_usuarios.dat"));
  	        out.writeObject(autentUsuario.getCadastrosUsuarios());
	    }catch (Exception e) {
	      	e.printStackTrace();
	        // se a excecao for chamada, o novo cadastro nao tera sido persistido.
	    }finally{
	      	out.close();
	    }
		
		return true;
	}// fim do metodo alteraSenhaUsuario.
	
	public static boolean gerarRelatorioErrosAutenticacaoDiario(AutenticacaoUsuario autentUsuario, String login){
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		
		if( listaUsuarios != null && listaUsuarios.containsKey(login) && 
			listaUsuarios.get(login).getPrioridade() == Prioridade.ADMINISTRADOR){
			
			GregorianCalendar instante = new GregorianCalendar();
			String nome_arquivo = String.format("reaud_%1$td_%1$tm_%1$tY.txt", instante);
			PrintWriter out = null;
			try{
				out = new PrintWriter(new BufferedWriter(new FileWriter(nome_arquivo) ) );  
				out.write(gerarStringRelatorioErrosAutentDiario(autentUsuario));
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
			
		}
		return false;
	}// fim do metodo gerarRelatorioErrosAutenticacao.
	
	private static String gerarStringRelatorioErrosAutentDiario(AutenticacaoUsuario autentUsuario){
		final String EOL = System.getProperty("line.separator");
		GregorianCalendar instanteErro = new GregorianCalendar();
        String ano = String.format("%1$tY", instanteErro);
        String diaDoAno = String.format("%d", instanteErro.get(Calendar.DAY_OF_YEAR));
        String idParcial = ano + "/" + diaDoAno;
        
        String relatorio = "######################################################" + EOL +
                           "#                                                    #" + EOL +
                           "#      RELATORIO DIARIO DE ERROS DE AUTENTICACAO     #" + EOL +
                           "#                                                    #" + EOL +
                           "######################################################" + EOL + EOL;
        
        LinkedList<ErroAutenticacaoUsuario> listaErros = autentUsuario.getListaErros();
        
        if( listaErros != null && !listaErros.isEmpty() ){
        	Iterator<ErroAutenticacaoUsuario> iteraListaErros = listaErros.iterator();
        	while(iteraListaErros.hasNext()){
        		ErroAutenticacaoUsuario erro = iteraListaErros.next();
        		if( erro.getIdParcial().equals(idParcial) ){
        			relatorio += erro.toString() + EOL + EOL;
        		}
        		
        	}
        }else{
        	relatorio += "######################################################" + EOL +
                         "#                                                    #" + EOL +
                         "#       NAO OCORRERAM ERROS DE AUTENTICACAO HOJE     #" + EOL +
                         "#                                                    #" + EOL +
                         "######################################################" + EOL;
        }
        
		
		
		return relatorio;
	}
	
	public static boolean gerarRelatorioErrosAutenticacaoTotal(AutenticacaoUsuario autentUsuario, String login){
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		
		if( listaUsuarios != null && listaUsuarios.containsKey(login) && 
			listaUsuarios.get(login).getPrioridade() == Prioridade.ADMINISTRADOR){
			
			GregorianCalendar instante = new GregorianCalendar();
			String nome_arquivo = String.format("reaut_%1$td_%1$tm_%1$tY.txt", instante);
			PrintWriter out = null;
			try{
				out = new PrintWriter(new BufferedWriter(new FileWriter(nome_arquivo) ) );  
				out.write(gerarStringRelatorioErrosAutentTotal(autentUsuario));
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
			
		}
		return false;
	}// fim do metodo gerarRelatorioErrosAutenticacao.
	
	private static String gerarStringRelatorioErrosAutentTotal(AutenticacaoUsuario autentUsuario){
		final String EOL = System.getProperty("line.separator");
        
        String relatorio = "######################################################" + EOL +
                           "#                                                    #" + EOL +
                           "#       RELATORIO TOTAL DE ERROS DE AUTENTICACAO     #" + EOL +
                           "#                                                    #" + EOL +
                           "######################################################" + EOL + EOL;
        
        LinkedList<ErroAutenticacaoUsuario> listaErros = autentUsuario.getListaErros();
        
        if( listaErros != null && !listaErros.isEmpty() ){
        	Iterator<ErroAutenticacaoUsuario> iteraListaErros = listaErros.iterator();
        	while(iteraListaErros.hasNext()){
        		ErroAutenticacaoUsuario erro = iteraListaErros.next();
        			relatorio += erro.toString() + EOL + EOL;
        		
        	}
        }else{
        	relatorio += "######################################################" + EOL +
                         "#                                                    #" + EOL +
                         "#         NAO OCORRERAM ERROS DE AUTENTICACAO        #" + EOL +
                         "#                                                    #" + EOL +
                         "######################################################" + EOL;
        }
        
		return relatorio;
	}
	
	
	public static boolean gerarRelatorioBloqueioSistemaDiario(AutenticacaoUsuario autentUsuario, String login){
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		
		if( listaUsuarios != null && listaUsuarios.containsKey(login) && 
			listaUsuarios.get(login).getPrioridade() == Prioridade.ADMINISTRADOR){
			
			GregorianCalendar instante = new GregorianCalendar();
			String nome_arquivo = String.format("rbsd_%1$td_%1$tm_%1$tY.txt", instante);
			PrintWriter out = null;
			try{
				out = new PrintWriter(new BufferedWriter(new FileWriter(nome_arquivo) ) );  
				out.write(gerarStringRelatorioBloqueioSistemaDiario(autentUsuario));
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
			
		}
		return false;
	}// fim do metodo gerarRelatorioBloqueioSistemaDiario.
	
	private static String gerarStringRelatorioBloqueioSistemaDiario(AutenticacaoUsuario autentUsuario){
		final String EOL = System.getProperty("line.separator");
		GregorianCalendar instanteErro = new GregorianCalendar();
        String ano = String.format("%1$tY", instanteErro);
        String diaDoAno = String.format("%d", instanteErro.get(Calendar.DAY_OF_YEAR));
        String idParcial = ano + "/" + diaDoAno;
        
        String relatorio = "######################################################" + EOL +
                           "#                                                    #" + EOL +
                           "#      RELATORIO DIARIO DE BLOQUEIOS DE SISTEMA      #" + EOL +
                           "#                                                    #" + EOL +
                           "######################################################" + EOL + EOL;
        
        LinkedList<BloqueioSistema> listaBloqueios = autentUsuario.getListaBloqueios();
        
        if( listaBloqueios != null && !listaBloqueios.isEmpty() ){
        	Iterator<BloqueioSistema> iteraListaBloqueios = listaBloqueios.iterator();
        	while(iteraListaBloqueios.hasNext()){
        		BloqueioSistema bloqueio = iteraListaBloqueios.next();
        		if( bloqueio.getErroAutenticacaoUsuario().getIdParcial().equals(idParcial) ){
        			relatorio += bloqueio.toString() + EOL + EOL;
        		}
        		
        	}
        }else{
        	relatorio += "######################################################" + EOL +
                         "#                                                    #" + EOL +
                         "#       NAO OCORRERAM BLOQUEIOS DE SISTEMA HOJE      #" + EOL +
                         "#                                                    #" + EOL +
                         "######################################################" + EOL;
        }
        
		
		
		return relatorio;
	} // fim do metodo gerarStringRelatorioBloqueioSistemaDiario.
	
	
	public static boolean gerarRelatorioBloqueioSistemaTotal(AutenticacaoUsuario autentUsuario, String login){
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		
		if( listaUsuarios != null && listaUsuarios.containsKey(login) && 
			listaUsuarios.get(login).getPrioridade() == Prioridade.ADMINISTRADOR){
			
			GregorianCalendar instante = new GregorianCalendar();
			String nome_arquivo = String.format("rbst_%1$td_%1$tm_%1$tY.txt", instante);
			PrintWriter out = null;
			try{
				out = new PrintWriter(new BufferedWriter(new FileWriter(nome_arquivo) ) );  
				out.write(gerarStringRelatorioBloqueiosSistemTotal(autentUsuario));
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
			
		}
		return false;
	}// fim do metodo gerarRelatorioBloqueioSistemaTotal.
	
	private static String gerarStringRelatorioBloqueiosSistemTotal(AutenticacaoUsuario autentUsuario){
		final String EOL = System.getProperty("line.separator");
        
        String relatorio = "######################################################" + EOL +
                           "#                                                    #" + EOL +
                           "#       RELATORIO TOTAL DE BLOQUEIOS DE SISTEMA      #" + EOL +
                           "#                                                    #" + EOL +
                           "######################################################" + EOL + EOL;
        
        LinkedList<BloqueioSistema> listaBloqueios = autentUsuario.getListaBloqueios();
        
        if( listaBloqueios != null && !listaBloqueios.isEmpty() ){
        	Iterator<BloqueioSistema> iteraListaBloqueios = listaBloqueios.iterator();
        	while(iteraListaBloqueios.hasNext()){
        		BloqueioSistema bloqueio = iteraListaBloqueios.next();
        			relatorio += bloqueio.toString() + EOL + EOL;
        		
        	}
        }else{
        	relatorio += "######################################################" + EOL +
                         "#                                                    #" + EOL +
                         "#         NAO OCORRERAM BLOQUEIOS DE SISTEMA         #" + EOL +
                         "#                                                    #" + EOL +
                         "######################################################" + EOL;
        }
        
		return relatorio;
	}// fim do metodo gerarStringRelatorioBloqueiosSistemTotal.
	
}// fim da classe gerenciamentoUsuario.


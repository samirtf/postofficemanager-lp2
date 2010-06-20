package servicosAutenticacaoGerencUsuario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import servicosAutenticacaoGerencUsuario.Usuario.Prioridade;

public class GerenciamentoUsuario {

	public static boolean cadastraUsuarioPadrao(AutenticacaoUsuario autentUsuario, 
			String login, String senha) throws IOException{
		
		// observar a possibilidade de ter sido armazenado apenas na memoria, situacao
	    // na qual o novo cadastro nao tera sido armazenado em arquivo.
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		
		try{
			if( autentUsuario.validaLogin(login) && autentUsuario.validaSenha(login, senha)&& 
				  listaUsuarios != null && !listaUsuarios.containsKey(login)){
				
				listaUsuarios.put(login, new Usuario(login, senha));
			}
        }
        catch(AutenticacaoUsuarioExcecao autenticacaoUsuarioExcecao){
            autenticacaoUsuarioExcecao.printStackTrace();
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
        try{
	  
            // Se prioridade for null, um usuario default sera cadastrado
            if ( autentUsuario.validaLogin(login) && autentUsuario.validaSenha(login, senha) && 
            		listaUsuarios != null && !listaUsuarios.containsKey(login)){
            	
            	listaUsuarios.put(login, new Usuario(login, senha, prioridade));
            }
        }
        catch(AutenticacaoUsuarioExcecao autenticacaoUsuarioExcecao){
            autenticacaoUsuarioExcecao.printStackTrace();
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
			String login, String novoLogin) throws IOException{
		
		HashMap<String, Usuario> listaUsuarios = autentUsuario.getCadastrosUsuarios();
		try{
			if( listaUsuarios.containsKey(login) &&
					autentUsuario.validaLogin(novoLogin)){
				listaUsuarios.get(login).setLogin(novoLogin);
				
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
		
	}// fim do metodo alteraLoginUsuario.
	
	public static boolean alteraSenhaUsuario(AutenticacaoUsuario autentUsuario, 
			String login, String senha, String novaSenha) throws IOException{
		
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
	
	
}


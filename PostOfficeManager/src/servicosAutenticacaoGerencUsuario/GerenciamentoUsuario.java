package servicosAutenticacaoGerencUsuario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import servicosAutenticacaoGerencUsuario.Usuario.Prioridade;

public class GerenciamentoUsuario {

	public static boolean cadastraUsuario(AutenticacaoUsuario autentUsuario, 
			String login, String senha, Prioridade prioridade)
	             throws AutenticacaoUsuarioExcecao, IOException{
	
	// observar a possibilidade de ter sido armazenado apenas na memoria, situacao
	// na qual o novo cadastro nao tera sido armazenado em arquivo.
  try{
      // Se prioridade for null, um usuario default sera cadastrado
      if ( autentUsuario.validaLogin(login) && autentUsuario.validaSenha(login, senha) && prioridade == null){
    	  autentUsuario.getCadastrosUsuarios().put(login, new Usuario(login, senha));
    	  System.out.println("oxinao");
      }
      // Se prioridade for instancia de Prioridade, serie criado um usuario
      // com prioridade pre-definida.
      else if( autentUsuario.validaLogin(login) && autentUsuario.validaSenha(login, senha) &&
              prioridade.getClass() == Prioridade.class ){
    	  autentUsuario.getCadastrosUsuarios().put(login, new Usuario(login, senha, prioridade));
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
  	out.writeObject(autentUsuario.getCadastrosUsuarios());
	}catch (Exception e) {
		e.printStackTrace();
		// se a excecao for chamada, o novo cadastro nao tera sido persistido.
	}finally{
		out.close();
	}
  
	return true;

	}
}


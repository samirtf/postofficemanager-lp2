package funcionarioServicos.testes;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webServicos.Cep;

/**
 *
 * @author Samir Trajano Feitosa 20921299
 */
public class FuncDadosTeste {
	public void testaErroNoConstrutor(){
		try{
			FuncDados funcDados = new FuncDados( "Samir", dataNascimento,
			 cpf, salario, senha, chave);
		}
		catch(Exception e){
			
		}
		
	}//fim do teste do Construtor
	
}// fim da classe de testes FuncDadosTeste

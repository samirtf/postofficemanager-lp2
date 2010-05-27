package correios.util;

/**
 * Classe de verificação de dados para agencia de correio
 * @author Rafael O. Vieira
 * @version 2.0
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificaDados {
	
	
	/**
	 * Verifica se a string contem apenas numeros(inteiros)
	 * @param numero
	 * @return boolean
	 * @throws NumberFormatException
	 */
	
	public static  boolean verificaSoNumeros(String numero) throws NumberFormatException{
		if(!numero.matches("^[0-9]*$"))
		       	throw new NumberFormatException("Deve conter apenas numeros");
		    		    
	  return true;  
	  	
	}
	
	
	
	/**
	 * Verifica se a string contem exatos 8 digitos(cep e data)
	 * @param numero
	 * @return boolean
	 * @throws IndexOutOfBoundsException
	 */
	
	public static boolean verificaOitoDigitos(String num)throws IndexOutOfBoundsException{
		verificaSoNumeros(num);
		
		if(num.length() != 8 )
			throw new IndexOutOfBoundsException("Deve conter 8 digitos");
					
		return true;
	}
	
	
	/**
	 * Verifica se a string eh valida e nao contem numeros
	 * @param nome do estado
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean verificaNome(String nome) throws Exception{
				
	    if(nome.equals(null) || nome.equals("") || nome.equals(" ")
	    	||!nome.matches("^[a-zA-z àáâãéêíóôõúüçÁÚÍÉÓ]*$") )
	    	
	    	throw new Exception("Informe um nome valido");
	    	
	    
	    return true;  
		
	}
	
	
	/**
	 * Verifica se o cep eh valido(eh um numero com 8 digitos)
	 * @param cep
	 * @return boolean
	 */
		
	public static boolean verificaCep(String cep){
		return verificaOitoDigitos(cep);
	}
	
	
	/**
	 * Verifica se a data eh valida(eh um numero com 8 digitos)
	 * @param data
	 * @return boolean
	 */
	public static boolean verificaData(String data){
		return verificaOitoDigitos(data);
	}

	
	/**
	 * Verifica se o cpf possui so numeros e exatos 11 digitos
	 * @param cpf
	 * @return boolean
	 * @throws IndexOutOfBoundsException
	 */
	public static boolean verificaCpf(String cpf)throws IndexOutOfBoundsException{
		verificaSoNumeros(cpf);
		
		if(cpf.length() != 11 )
			throw new IndexOutOfBoundsException("Deve conter 11 digitos");
			
		return true;
		
		
	}
	
	public static boolean verificaEstado(String estado) throws Exception{
		return verificaNome(estado);
		
	}
}


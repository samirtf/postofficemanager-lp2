package correios.util;

/**
 * Classe de verificação de dados para agencia de correio
 * @author Rafael O. Vieira
 * @version 2.1
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
	
	public static  boolean verificaSoNumeros(String numero) {
		if(!numero.matches("^[0-9]*$"))
		       	return false;
		    		    
	  return true;  
	  	
	}
	
	
	
	/**
	 * Verifica se a string contem exatos 8 digitos(cep e data)
	 * @param numero
	 * @return boolean
	 * @throws IndexOutOfBoundsException
	 */
	
	public static boolean verificaOitoDigitos(String num){
		verificaSoNumeros(num);
		
		if(num.length() != 8 )
			return false;
					
		return true;
	}
	
	
	/**
	 * Verifica se a string eh valida e nao contem numeros
	 * @param nome do estado
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean verificaNome(String nome) {
				
	    if(nome.equals(null) || nome.trim().equals("")
	    	||!nome.matches("^[a-zA-z àáâãéêíóôõúüçÁÚÍÉÓ]*$") )
	    	
	    		return false;	    	
	    
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
		verificaOitoDigitos(data);
		
		int dataHoje = Integer.parseInt(data)/10000;
		if((dataHoje % 100) < 1 || (dataHoje % 100) > 12 || (dataHoje / 100) < 1 || (dataHoje / 100) > 31){
			return false;
		}	
		return true;
			
	}
	
	/**
	 * Verifica se o cpf possui so numeros e exatos 11 digitos
	 * @param cpf
	 * @return boolean
	 * @throws IndexOutOfBoundsException
	 */
	public static boolean verificaCpf(String cpf){
		verificaSoNumeros(cpf);
		
		if(cpf.length() != 11 )
			return false;
			
		return true;
		
		
	}
	
	public static boolean verificaEstado(String estado){
		return verificaNome(estado);
		
	}
}


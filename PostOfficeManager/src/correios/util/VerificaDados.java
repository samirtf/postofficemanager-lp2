package correios.util;

/**
 * Classe de verificacao de dados para agencia de correio
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
	
	public static  boolean ehNumeroInteiro(String numero) {
		if(!numero.matches("^[0-9]*$") || (numero.equals(null)))
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
		ehNumeroInteiro(num);
		
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
	    	||!nome.matches("^[a-zA-z0-9“]*$") )
	    	
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
		ehNumeroInteiro(cpf);
		
		if(cpf.length() != 11 )
			return false;
			
		return true;
		
		
	}
	
	public static boolean verificaEstado(String estado){
		return verificaNome(estado);
		
	}
	
	public static boolean validaCPF(String cpf){
        if ( cpf == null || cpf.trim().equals("")
             || !ehNumeroInteiro(cpf) || cpf.length()!= 11){
            
            return false;
        }
        //0 1 2 3 4 5 6 7 8 9 10
        int digito1 = Integer.valueOf(String.valueOf(cpf.charAt(9)));
        int digito2 = Integer.valueOf(String.valueOf(cpf.charAt(10)));
        
        System.out.println(digito1);
        for (int i = 0; i<cpf.length(); i++){
            System.out.println(cpf.charAt(i));
        }

        int[] arrayCPF = new int[11];
        for (int i=0; i<arrayCPF.length; i++){
            arrayCPF[i] = Integer.valueOf(String.valueOf(cpf.charAt(i)));
        }

        int somaArray = 0;
        //preparando arrays para teste 1 e teste 2
        int[] arrayTeste1 = arrayCPF.clone();
        int[] arrayTeste2 = arrayCPF.clone();

        int somatorio1 = 0;
        int somatorio2 = 0;

        int contador1 = 10;
        for (int i=0; i<9; i++){
            arrayTeste1[i] *= contador1;
            somatorio1 += arrayTeste1[i];
            contador1 -= 1;
        }

        int contador2 = 11;
        for (int i=0; i<10; i++){
            arrayTeste2[i] *= contador2;
            somatorio2 += arrayTeste2[i];
            contador2 -= 1;
        }

        //teste do digito 1
        if ( (somatorio1 % 11)<2 ){
            if ( digito1 != 0 ){
                return false;
            }
        }
        else{
            if ( (11 - ((somatorio1 % 11))) != digito1 ){
                return false;
            }
        }

        //teste do digito 2
        if ( (somatorio2 % 11)<2 ){
            if ( digito2 != 0 ){
                return false;
            }
        }
        else{
            if ( ((11 - (somatorio2 % 11))) != digito2 ){
                return false;
            }
        }

        return true;
    }

	
}


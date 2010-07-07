package correios.util;

/**
 * Classe de verificacao de dados para agencia de correio
  * @author
  * 	Marcus Vinicius Souza de Oliveira<br>
  * 	Rafael O. Vieira<br>
  * 	Samir Trajano Feitosa<br>
  * 	Werton Vinicius Guimaraes Gomes
  * 
 * @version 2.1
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VerificaDados {
	
	
	/**
	 * Verifica se a string contem apenas numeros(inteiros)
	 * @param numero recebe um numero qualquer.
	 * @return boolean, Se for um numero eh retornado True, caso contrario sera retornado False.
	 */
	
	public static  boolean ehNumeroInteiro(String numero) {
		if((numero == null || !numero.matches("^[0-9]*$")))
		       	return false;
		    		    
	  return true;  
	  	
	}
	
	/**
	 * Verifica se a string contem exatos 8 digitos(cep e data)
	 * @param num Recebe um numero qualquer.
	 * @return boolean Retorna <i>True</i> se for do tipo inteiro, caso contrario serah retornado <i>false</i>
	 * */
	
	public static boolean verificaOitoDigitos(String num){
		
		if( !ehNumeroInteiro(num) || num.length() != 8 ){
			return false;
		}
					
		return true;
	}
	
	
	/**
	 * Verifica se a string eh valida e nao contem numeros
	 * @param nome Recebe um nome para ser verificado
	 * @return boolean Se conter, somente Letras e Espacos, eh retornado <i>True</i>, Caso contrario, sera retornado <i>False</i>.
	 * @throws Exception
	 */
	public static boolean verificaNome(String nome) {
				
	    if(nome == null || nome.trim().equals("")
	    	||!nome.matches("^[a-z A-z]*$") )
	    	
	    		return false;	    	
	    
	    return true;  
		
	}
	
	
	/**
	 * Verifica se o cep eh valido(eh um numero com 8 digitos)
	 * @param cep Recebe um conjunto de 8 numeros.
	 * @return <i>True</i> se for valido, caso contrario, retorna <i>False</i>.
	 */
		
	public static boolean verificaCep(String cep){
		return verificaOitoDigitos(cep);
	}
	
	
	/**
	 * Verifica se a data eh valida(eh um numero com 8 digitos)
	 * @param data Recebe um conjuto de 8 digitos.
	 * @return <i>True</i> se for valido, caso contrario, retorna <i>False</i>.
	 */
	public static boolean verificaData(String data){
		
		//int dataHoje = Integer.parseInt(data)/10000;
		//|| (dataHoje % 100) < 1 || (dataHoje % 100) > 12 || (dataHoje / 100) < 1 || (dataHoje / 100) > 31){
		if( data == null || data.trim().equals("") || !verificaOitoDigitos(data) ){
			return false;
		}	
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
        if( cpf.equals("11111111111") || 
            cpf.equals("22222222222") ||
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") ||
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") ||
            cpf.equals("77777777777") ||
            cpf.equals("88888888888") ||
            cpf.equals("99999999999") ||
            cpf.equals("00000000000")){
        	return false;
        }
        //0 1 2 3 4 5 6 7 8 9 10
        int digito1 = Integer.valueOf(String.valueOf(cpf.charAt(9)));
        int digito2 = Integer.valueOf(String.valueOf(cpf.charAt(10)));

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
	
	public static String configuraData(String data){
		return data.substring(0, 2)+"\\"+
		       data.substring(2, 4)+"\\"+
		       data.substring(4);
	}
	
	private static final String PLAIN_ASCII =
        "AaEeIiOoUu"    // grave
      + "AaEeIiOoUuYy"  // acute
      + "AaEeIiOoUuYy"  // circumflex
      + "AaOoNn"        // tilde
      + "AaEeIiOoUuYy"  // umlaut
      + "Aa"            // ring
      + "Cc"            // cedilla
      + "OoUu"          // double acute
      ;

      private static final String UNICODE =
       "\u00C0\u00E0\u00C8\u00E8\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"             
      + "\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD" 
      + "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177" 
      + "\u00C3\u00E3\u00D5\u00F5\u00D1\u00F1"
      + "\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF" 
      + "\u00C5\u00E5"                                                             
      + "\u00C7\u00E7" 
      + "\u0150\u0151\u0170\u0171" 
      ;

    
    public static String convertNonAscii(String s) {
        if (s == null) return null;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
           char c = s.charAt(i);
           int pos = UNICODE.indexOf(c);
           if (pos > -1){
               sb.append(PLAIN_ASCII.charAt(pos));
           }
           else {
               sb.append(c);
           }
        }
        return sb.toString();
     }

	
	public static String configuraCPF(String cpf){
		return cpf.substring(0, 3)+"."+
		cpf.substring(3, 6)+"."+
		cpf.substring(6, 9)+"-"+
		cpf.substring(9);
	}
	
	public static void main(String[] args) {
		System.out.println("verifica dados: " + verificaOitoDigitos("erro no cep"));
	}
	

}


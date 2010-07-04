
package servicosAutenticacaoGerencUsuario;

import java.io.Serializable;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 13/06/2010
 */
public class Criptografia implements Serializable{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Criptografa senha do usuario a partir do login e da senha do usuario.
     * @param login
     *      O login do usuario.
     * @param senha
     *      A senha do usuario.
     * @return
     *      Um valor criptografado.
	 * @throws Exception 
     */
    public static String criptografa(String login, String senha) throws Exception {
    	if(login == null || login.trim().equals("")){
    		throw new Exception("Login inválido!");
    	}
    	if(senha == null || senha.trim().equals("")){
    		throw new Exception("Senha inválida!");
    	}
    	
        String codificado = login + senha;

        try {
            java.security.MessageDigest md =
               java.security.MessageDigest.getInstance("MD5");
            md.update(codificado.getBytes());
            byte[] hash = md.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
               if ((0xff & hash[i]) < 0x10)
                  hexString.append(
                     "0" + Integer.toHexString((0xFF & hash[i])));
               else
                  hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
            codificado = hexString.toString();
        }
        catch (Exception nsae) {
            nsae.printStackTrace();
        }
        return codificado;
    }// fim do metodo estatico criptografia.
    
}// fim da classe Criptografia.


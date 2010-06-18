
package servicosAutenticacaoUsuario;

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
     * Criptografa senha do usu�rio a partir do login e da senha do usu�rio.
     * @param login
     *      O login do usu�rio.
     * @param senha
     *      A senha do usu�rio.
     * @return
     *      Um valor criptografado.
     */
    public static String criptografa(String login, String senha) {
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
            System.out.println("Erro: " + nsae.getMessage() + nsae);
            nsae.printStackTrace();
        }
        return codificado;
    }// fim do m�todo est�tico criptografia.
    
}// fim da classe Criptografia.


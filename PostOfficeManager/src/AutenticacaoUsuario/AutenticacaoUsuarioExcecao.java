

package AutenticacaoUsuario;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public class AutenticacaoUsuarioExcecao extends Exception{

    // C�digo da Exce��o.
    private Integer codigoExcecao = null;

    /**
     * Construtor padr�o(default).
     */
    public AutenticacaoUsuarioExcecao(){
    }// fim do construtor padr�o.

    /**
     * Constroi uma exce��o de autentica��o de usu�rio a partir
     * de uma mensagem.
     * @param mensagem
     *      A mensagem da exce��o.
     */
    public AutenticacaoUsuarioExcecao(String mensagem){
        super(mensagem);
    }// fim do construtor a partir de String mensagem.

    /**
     * Constroi uma exce��o de autentica��o de usu�rio a partir
     * de um c�digo da exce��o.
     * Tabela de c�digos da exce��o:
     *      1 -  Login : nulo
     *      2 -  Login : vazio
     *      3 -  Login : caractere(s) inv�lido(s) - N�o alfanum�rico
     *      4 -  Login : tamanho inferior ao m�nimo(8)
     *      5 -  Login : tamanho superior ao m�ximo(12)
     *      6 -  Senha : nulo
     *      7 -  Senha : vazio
     *      8 -  Senha : tamanho inferior ao m�nimo(8)
     *      9 -  Senha : tamanho superior ao m�ximo(12)
     *      10 - Login : Login incorreto
     *      11 - Senha : Senha incorreta
     *      12 - Cadastro : Usuario j� cadastrado
     *      
     *
     * @param codigoExcecao
     *      O c�digo da exce��o.
     */
    public AutenticacaoUsuarioExcecao(Integer codigoExcecao){
        this.codigoExcecao = codigoExcecao;
    }// fim do construtor a partir de Integer codicoExcecao.

    /**
     * Constroi uma exce��o de autentica��o de usu�rio a partir de uma mensagem e
     * um c�digo de exce��o.
     * @param mensagem
     *      A mensagem de exce��o.
     * @param codigoExcecao
     *      O c�digo de exce��o.
     */
    public AutenticacaoUsuarioExcecao(String mensagem, Integer codigoExcecao){
        super(mensagem);
        this.codigoExcecao = codigoExcecao;
    }// fim do construtor a partir de String mensagem e Integer codigoExcecao.

    /**
     * Recupera o c�digo de exce��o.
     * @return
     *      O c�digo de exce��o.
     */
    public Integer getCodigoExcecao(){
        return this.codigoExcecao;
    }// fim do m�todo getCodigoExcecao

    /**
     * Obt�m a mensagem da exce��o de autentica��o de usu�rio. Se o c�digo de
     * exce��o for nulo, ser� recupera a mensagem de Throwable. A mensagem de
     * Throwable pode ser nula tamb�m.
     * @return
     *      A mensagem de exce��o.
     */
    @Override
    public String getMessage(){
        if( this.codigoExcecao != null && (this.codigoExcecao instanceof Integer )){
            switch(this.getCodigoExcecao()){
              case 1:
                  return "Login : nulo";
              case 2:
                  return "Login : vazio";
              case 3:
                  return "Login : caractere(s) inv�lido(s) - N�o alfanu�rico";
              case 4:
                  return "Login : tamanho inferior ao m�nimo(8)";
              case 5:
                  return "Login : tamanho superior ao m�ximo(12)";
              case 6:
                  return "Senha : nulo";
              case 7:
                  return "Senha : vazio";
              case 8:
                  return "Senha : tamanho inferior ao m�nimo(8)";
              case 9:
                  return "Senha : tamanho superior ao m�ximo(12)";
              case 10:
                  return "Login : Login incorreto";
              case 11:
                  return "Senha : Senha incorreta";
              case 12:
                  return "Cadastro : Usuario j� cadastrado";
              default:
                  return super.getMessage();
            }
        }
        return super.getMessage();
    }// fim do m�todo getMessage()
    
}// fim da classe AutenticacaoUsuarioExcecao



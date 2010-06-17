

package AutenticacaoUsuario;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public class AutenticacaoUsuarioExcecao extends Exception{

    // Código da Exceção.
    private Integer codigoExcecao = null;

    /**
     * Construtor padrão(default).
     */
    public AutenticacaoUsuarioExcecao(){
    }// fim do construtor padrão.

    /**
     * Constroi uma exceção de autenticação de usuário a partir
     * de uma mensagem.
     * @param mensagem
     *      A mensagem da exceção.
     */
    public AutenticacaoUsuarioExcecao(String mensagem){
        super(mensagem);
    }// fim do construtor a partir de String mensagem.

    /**
     * Constroi uma exceção de autenticação de usuário a partir
     * de um código da exceção.
     * Tabela de códigos da exceção:
     *      1 -  Login : nulo
     *      2 -  Login : vazio
     *      3 -  Login : caractere(s) inválido(s) - Não alfanumérico
     *      4 -  Login : tamanho inferior ao mínimo(8)
     *      5 -  Login : tamanho superior ao máximo(12)
     *      6 -  Senha : nulo
     *      7 -  Senha : vazio
     *      8 -  Senha : tamanho inferior ao mínimo(8)
     *      9 -  Senha : tamanho superior ao máximo(12)
     *      10 - Login : Login incorreto
     *      11 - Senha : Senha incorreta
     *      12 - Cadastro : Usuario já cadastrado
     *      
     *
     * @param codigoExcecao
     *      O código da exceção.
     */
    public AutenticacaoUsuarioExcecao(Integer codigoExcecao){
        this.codigoExcecao = codigoExcecao;
    }// fim do construtor a partir de Integer codicoExcecao.

    /**
     * Constroi uma exceção de autenticação de usuário a partir de uma mensagem e
     * um código de exceção.
     * @param mensagem
     *      A mensagem de exceção.
     * @param codigoExcecao
     *      O código de exceção.
     */
    public AutenticacaoUsuarioExcecao(String mensagem, Integer codigoExcecao){
        super(mensagem);
        this.codigoExcecao = codigoExcecao;
    }// fim do construtor a partir de String mensagem e Integer codigoExcecao.

    /**
     * Recupera o código de exceção.
     * @return
     *      O código de exceção.
     */
    public Integer getCodigoExcecao(){
        return this.codigoExcecao;
    }// fim do método getCodigoExcecao

    /**
     * Obtém a mensagem da exceção de autenticação de usuário. Se o código de
     * exceção for nulo, será recupera a mensagem de Throwable. A mensagem de
     * Throwable pode ser nula também.
     * @return
     *      A mensagem de exceção.
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
                  return "Login : caractere(s) inválido(s) - Não alfanuérico";
              case 4:
                  return "Login : tamanho inferior ao mínimo(8)";
              case 5:
                  return "Login : tamanho superior ao máximo(12)";
              case 6:
                  return "Senha : nulo";
              case 7:
                  return "Senha : vazio";
              case 8:
                  return "Senha : tamanho inferior ao mínimo(8)";
              case 9:
                  return "Senha : tamanho superior ao máximo(12)";
              case 10:
                  return "Login : Login incorreto";
              case 11:
                  return "Senha : Senha incorreta";
              case 12:
                  return "Cadastro : Usuario já cadastrado";
              default:
                  return super.getMessage();
            }
        }
        return super.getMessage();
    }// fim do método getMessage()
    
}// fim da classe AutenticacaoUsuarioExcecao





package servicosAutenticacaoUsuario;

/**
 *
 * @author Samir Trajano Feitosa
 * @version 1.0
 * @since 11/06/2010
 */
public class AutenticacaoUsuarioExcecao extends Exception{

    // Codigo da Excecao.
    private Integer codigoExcecao = null;

    /**
     * Construtor padrao(default).
     */
    public AutenticacaoUsuarioExcecao(){
    }// fim do construtor padrao.

    /**
     * Constroi uma excecao de autenticacao de usuario a partir
     * de uma mensagem.
     * @param mensagem
     *      A mensagem da excecao.
     */
    public AutenticacaoUsuarioExcecao(String mensagem){
        super(mensagem);
    }// fim do construtor a partir de String mensagem.

    /**
     * Constroi uma excecao de autenticacao de usuario a partir
     * de um codigo da excecao.
     * Tabela de codigos da excecao:
     *      1 -  Login : nulo
     *      2 -  Login : vazio
     *      3 -  Login : caractere(s) invalido(s) - Nao alfanumerico
     *      4 -  Login : tamanho inferior ao minimo(8)
     *      5 -  Login : tamanho superior ao maximo(12)
     *      6 -  Senha : nulo
     *      7 -  Senha : vazio
     *      8 -  Senha : tamanho inferior ao minimo(8)
     *      9 -  Senha : tamanho superior ao maximo(12)
     *      10 - Login : Login incorreto
     *      11 - Senha : Senha incorreta
     *      12 - Cadastro : Usuario ja cadastrado
     *      
     *
     * @param codigoExcecao
     *      O codigo da excecao.
     */
    public AutenticacaoUsuarioExcecao(Integer codigoExcecao){
        this.codigoExcecao = codigoExcecao;
    }// fim do construtor a partir de Integer codicoExcecao.

    /**
     * Constroi uma excecao de autenticacao de usuario a partir de uma mensagem e
     * um codigo de excecao.
     * @param mensagem
     *      A mensagem de excecao.
     * @param codigoExcecao
     *      O codigo de excecao.
     */
    public AutenticacaoUsuarioExcecao(String mensagem, Integer codigoExcecao){
        super(mensagem);
        this.codigoExcecao = codigoExcecao;
    }// fim do construtor a partir de String mensagem e Integer codigoExcecao.

    /**
     * Recupera o codigo de excecao.
     * @return
     *      O codigo de excecao.
     */
    public Integer getCodigoExcecao(){
        return this.codigoExcecao;
    }// fim do metodo getCodigoExcecao

    /**
     * Obtem a mensagem da excecao de autenticacao de usuario. Se o codigo de
     * excecao for nulo, sera recupera a mensagem de Throwable. A mensagem de
     * Throwable pode ser nula tambem.
     * @return
     *      A mensagem de excecao.
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
                  return "Login : caractere(s) invalido(s) - Nao alfanuerico";
              case 4:
                  return "Login : tamanho inferior ao minimo(8)";
              case 5:
                  return "Login : tamanho superior ao maximo(12)";
              case 6:
                  return "Senha : nulo";
              case 7:
                  return "Senha : vazio";
              case 8:
                  return "Senha : tamanho inferior ao minimo(8)";
              case 9:
                  return "Senha : tamanho superior ao maximo(12)";
              case 10:
                  return "Login : Login incorreto";
              case 11:
                  return "Senha : Senha incorreta";
              case 12:
                  return "Cadastro : Usuario ja cadastrado";
              default:
                  return super.getMessage();
            }
        }
        return super.getMessage();
    }// fim do metodo getMessage()
    
}// fim da classe AutenticacaoUsuarioExcecao



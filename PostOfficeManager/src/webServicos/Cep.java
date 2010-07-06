package webServicos;

/**
*
* @author
* 	Samir Trajano Feitosa 20921299
* 	Marcus Vinicius Souza de Oliveira
* 	Rafael O. Vieira
* 	Werton Vinícius Guimarães Gomes
* 
* @version 1.0
* @Descricao A classe Cep, representacao por objeto do Codigo de Enderecamento Postal, foi criada para uso e tambem cadastro de CEP's <br>
* no banco de dados.
* 
*/
public class Cep {
   private String cep;
   private String logradouro;
   private String bairro;
   private String cidade;
   private String uf;
   private boolean chave = true;

   /**
    * Construtor de Cep. Requer apenas string como parametros. O tratamento do construtor eh simples, pois um tratamento <br>
    * maior sera dado durante a interacao do usuario com o sistema.
    * 
    * @param cep
    * 		Valor numerico de 8 digitos do CEP. Devem ser inseridos apenas valores numericos.
    * @param logradouro
    * 		Designacao de qualquer espaco public reconhecido pela administracao do municipio.
    * @param bairro
    * 		Nome do bairro.
    * @param cidade
    * 		Nome da cidade.
    * @param uf
    * 		Nome da Unidade Federativa.
    * @param chave
    * 		String de valor booleano. Sera aceito apenas a string "true" ou "false". Apesar de no construtor ser
    *       passado uma string como argumento de chave, o atributo chave eh um valor booleano.
    * @throws Exception
    * 		Lanca excecao se o construtor receber algum argumento invalido.
    */
   public Cep(String cep, String logradouro, String bairro, String cidade, String uf, String chave) throws Exception{

	   if ( cep == null || cep.trim().equals("")){
           throw new Exception("Cep invalido.");
       }
       else if ( logradouro == null || logradouro.trim().equals("")){
           throw new Exception("Logradouro invalido.");
       }
       else if ( bairro == null || bairro.trim().equals("")){
           throw new Exception("Bairro invalido.");
       }
       else if ( cidade == null || cidade.trim().equals("")){
           throw new Exception("Cidade invalida.");
       }
       else if ( uf == null || uf.trim().equals("")){
           throw new Exception("UF invalida.");
       }
       else if ( chave == null || ( !chave.trim().equals("true") && !chave.trim().equals("false"))){
           throw new Exception("Chave invalida.");
       }

       this.cep = cep;
       this.logradouro = logradouro;
       this.bairro = bairro;
       this.cidade = cidade;
       this.uf = uf;
       this.chave = Boolean.valueOf(chave);

   }

   /**
    * Recupera o CEP.
    * 
    * @return
    * 		O CEP de 8 digitos.
    */
   public String getCep(){
       return this.cep;
   }

   /**
    * Recupera o logradouro.
    * 
    * @return
    * 		O logradouro.
    */
   public String getLogradouro(){
       return this.logradouro;
   }

   /**
    * Recupera o bairro.
    * 
    * @return
    * 		O bairro.
    */
   public String getBairro(){
       return this.bairro;
   }

   /**
    * Recupera a cidade.
    * 
    * @return
    * 		A cidade.
    */
   public String getCidade(){
       return this.cidade;
   }

   /**
    * Recupera a Unidade Federativa (abreviatura do Estado).
    * 
    * @return
    * 		A Unidade Federativa.
    */
   public String getUf(){
       return this.uf;
   }

   /**
    * Retorna a chave. A chave representa se o CEP esta ativo ou inativo para uso.
    * 
    * @return
    * 		A chave.
    */
   public boolean getChave(){
       return this.chave;
   }

   /**
    * Configura cep.
    * 
    * @param cep
    * 		O valor do CEP.
    */
   public void setCep(String cep){
       this.cep = cep;
   }

   /**
    * Configura logradouro.
    * 
    * @param logradouro
    * 		O valor do logradouro.
    */
   public void setLogradouro(String logradouro){
       this.logradouro = logradouro;
   }

   /**
    * Configura bairro.
    * 
    * @param bairro
    * 		O valor do bairro.
    */
   public void setBairro(String bairro){
       this.bairro = bairro;
   }

   /**
    * Configura cidade.
    * 
    * @param cidade
    * 		O valor da cidade.
    */
   public void setCidade(String cidade){
       this.cidade = cidade;
   }

   /**
    * Configura uf.
    * 
    * @param uf
    * 		O valor da UF.
    */
   public void setUf(String uf){
       this.uf = uf;
   }

   /**
    * Configura a chave.
    * 
    * @param chave
    * 		O valor booleano da chave.
    */
   public void setChave(boolean chave){
       this.chave = chave;
   }
   

}


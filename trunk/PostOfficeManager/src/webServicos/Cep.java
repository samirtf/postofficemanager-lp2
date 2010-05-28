package webServicos;

/**
*
* @author Samir Trajano Feitosa 20921299
*/
public class Cep {
   private String cep;
   private String logradouro;
   private String bairro;
   private String cidade;
   private String uf;
   private boolean chave = true;

   public Cep(String cep, String logradouro, String bairro, String cidade, String uf, String chave) throws Exception{

	   if ( cep == null || cep.trim().equals("")){
           throw new Exception("Cep inválido.");
       }
       else if ( logradouro == null || logradouro.trim().equals("")){
           throw new Exception("Logradouro inválido.");
       }
       else if ( bairro == null || bairro.trim().equals("")){
           throw new Exception("Bairro inválido.");
       }
       else if ( cidade == null || cidade.trim().equals("")){
           throw new Exception("Cidade inválida.");
       }
       else if ( uf == null || uf.trim().equals("")){
           throw new Exception("UF inválida.");
       }
       else if ( chave == null || ( !chave.trim().equals("true") && !chave.trim().equals("false"))){
           throw new Exception("Chave inválida.");
       }

       this.cep = cep;
       this.logradouro = logradouro;
       this.bairro = bairro;
       this.cidade = cidade;
       this.uf = uf;
       this.chave = Boolean.valueOf(chave);

   }

   public String getCep(){
       return this.cep;
   }

   public String getLogradouro(){
       return this.logradouro;
   }

   public String getBairro(){
       return this.bairro;
   }

   public String getCidade(){
       return this.cidade;
   }

   public String getUf(){
       return this.uf;
   }

   public boolean getChave(){
       return this.chave;
   }

   public void setCep(String cep){
       this.cep = cep;
   }

   public void setLogradouro(String logradouro){
       this.logradouro = logradouro;
   }

   public void setBairro(String bairro){
       this.bairro = bairro;
   }

   public void setCidade(String cidade){
       this.cidade = cidade;
   }

   public void setUf(String uf){
       this.uf = uf;
   }

   public void setChave(boolean chave){
       this.chave = chave;
   }
   

}


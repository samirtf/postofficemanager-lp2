package webServicos;

/**
*
* @author Samir Trajano Feitosa 20921299
* Esta interface é de propriedade de Samir T. Feitosa. Qualquer novo método adi-
* cionado a interface deve ter comentário de método com nome do proprietário do
* novo método criado.
*/
public interface BancoDeDadosCepServicoIF {

   public boolean adicCepAoBancoDeDados(Cep cep);
   /**
    * Adiciona Cep ao Banco de Dados Cep.
    *
    * @return
    *      True - Se o Cep for adicionado ao banco de dados.
    *      False - Se o Cep não for adicionado ao banco de dados.
    */

   public boolean delCepDoBancoDeDados(Cep cep);
   /**
    * Remove Cep do DatabaseCep.
    *
    * @return
    *      True - Se o Cep for removido do banco de dados.
    *      False - Se o Cep nao for removido do banco de dados.
    */

   public int totalRegistrosBancoDeDados();
   /**
    * Retorna o número de registros de Ceps no banco de dados.
    *
    * @return
    *      O numero de registros de Ceps no banco de dados.
    */

   public boolean pesquisaCepNoBancoDeDadosLocal(String cep);
   /**
    * Pesquisa cep no banco de dados local.
    *
    * @return
    *      True - Se existir o cep no banco de dados local.
    *      False - Se a existencia for negada.
    */

   public boolean testaConexaoInternet();
   /**
    * Testa se ha conexao com a Internet, especificamente, com um site de banco
    * de dados de CEP.
    *
    * @return
    *      True - Se houver conexao e se o site estiver acessivel.
    *      False - Quando a situacao acima nao for descrita.
    */

   public boolean pequisaCepBancoDeDadosOnline();
   /**
    * Pesquisa cep no banco de dados online.
    */




   

}


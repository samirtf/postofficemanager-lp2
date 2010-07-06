package webServicos;

import java.io.IOException;
import java.net.UnknownHostException;

/**
*
* @author
* 	Samir Trajano Feitosa 20921299
* 	Marcus Vinicius Souza de Oliveira
* 	Rafael O. Vieira
* 	Werton Vinícius Guimarães Gomes
* 
* Esta interface e de propriedade de Samir T. Feitosa. Qualquer novo metodo adi-
* cionado a interface deve ter comentario de metodo com nome do proprietario do
* novo metodo criado.
*/
public interface BancoDeDadosCepServicoIF {

	/**
	 * Adiciona Cep ao Banco de Dados Cep.
	 *
	 * @return
	 *      True - Se o Cep for adicionado ao banco de dados.
	 *      False - Se o Cep naoo for adicionado ao banco de dados.
	 */
   public boolean adicCepAoBancoDeDados(Cep cep);
   

   /**
    * Remove Cep do DatabaseCep.
    *
    * @return
    *      True - Se o Cep for removido do banco de dados.
    *      False - Se o Cep nao for removido do banco de dados.
    */
   public boolean delCepDoBancoDeDados(Cep cep);
   

   /**
    * Retorna o numero de registros de Ceps no banco de dados.
    *
    * @return
    *      O numero de registros de Ceps no banco de dados.
    */
   public int totalRegistrosBancoDeDados();
   

   /**
    * Pesquisa cep no banco de dados local.
    *
    * @return
    *      True - Se existir o cep no banco de dados local.
    *      False - Se a existencia for negada.
    * @throws UnknownHostException
    * 	   Se o servidor estiver nao estiver acessivel	
    * @throws IOException 
    */
   public boolean pesquisaCepNoBancoDeDadosLocal(String cep);
   
   
   /**
    * Testa se ha conexao com a Internet, especificamente, com o site de banco
    * de dados de CEP.
    *
    * @return
    *      True - Se houver conexao e se o site estiver acessivel.
    *      False - Quando a situacao acima nao for descrita.
    */
   public boolean testaConexaoInternet() throws UnknownHostException, IOException;
   

   /**
    * Pesquisa cep no banco de dados online.
    * 
    */
   public boolean pesquisaCepBancoDeDadosOnline(String cep)throws IOException;
   
   /**
    * Recupera Cep no banco de dados online.
    * @throws Exception 
    * 
    */
   public Cep recuperaCepBancoDeDadosOnline(String CEP) throws Exception;


}// Fim da interface.


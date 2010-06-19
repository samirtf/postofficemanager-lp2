package webServicos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Samir Trajano Feitosa 20921299
 * @version 1.0
 * @Descricao Servico de banco de dados de Cep. E criado um arquivo bdcep.dat para o armazenamento<br>
 * dos Cep's. A classe possui uma diversidade de metodos para interagir com o bdcep.dat.
 *
 */
public class BancoDeDadosCepServico implements BancoDeDadosCepServicoIF{

	// Inicializacao do Mapa onde sao adicionados os Cep's recuperados do banco de dados 
	// e/ou adicionados novos Cep's.
    private Map< String, Cep> mapa;

    /**
     * Contrutor padrao do BancoDeDadosCepServico.
     * 
     * @throws Exception
     * 		Caso ocorra algum erro na manipulacao do arquivo.
     */
    public BancoDeDadosCepServico() throws Exception{
        mapa = new HashMap<String, Cep>();
        

        try {
        	// Carrega arquivo do banco de dados - bdcep.dat - para a memoria.
            File arquivoBd = new File("bdcep.dat");
            
            /* Testa se o arquivo bdcep.dat existe, confere o nome do arquivo e verifica se
             * esta disponivel para leitura. Em caso negativo, sera lancada uma excecao do tipo
             * SecurityException.
             */
            if ( !( arquivoBd.exists() && arquivoBd.isFile() && arquivoBd.canRead() ) ){
                throw new FileNotFoundException("Arquivo bdcep.dat nao encontrado.");
            }
            
            // Disponibiliza o arquivo bdcep.dat para leitura na memoria.
            FileReader arquivo = new FileReader("bdcep.dat");

            // Torna possivel uma leitura mais eficiente do banco de dados bdcep.dat.
            BufferedReader leitura = new BufferedReader(arquivo);

            while (leitura.ready()) {
                String dado = leitura.readLine();// Parar armazenar cada linha do arquivo bdcep.dat.
                String[] arrayDados = dado.split("\\|");
                //cep, logradouro, bairro, cidade, uf, chave
                Cep infoCep = new Cep(arrayDados[0], arrayDados[1], arrayDados[2],
                        arrayDados[3], arrayDados[4], arrayDados[5]);

                // Adicionando dado no mapa
                mapa.put(arrayDados[0], infoCep);

            }// while.
            leitura.close();// Fecha a leitura do arquivo.
        }
        catch(SecurityException securityException){
        	System.err.println("ERRO: " + securityException.getMessage() + securityException);
        }
        catch (IOException iOException) {
        	System.err.println("ERRO: " + iOException.getMessage() + iOException);
        }
        catch(Exception exception){
        	System.err.print("Erro: " + exception.getMessage() + exception);
        }
    }// Fim do construtor BancoDeDadosCepServico().
    
    /**
     * Recupera mapa. Objeto mapa e onde estao armazenados os dados carregados do bdcep.dat e os novos
     * dados adicionados.
     * 
     * @return
     * 		O mapa. Dicionario do banco de dados.
     */
    public Map< String, Cep> getMapaBD(){
    	return mapa;
    }// Fim do metodo getMapaBD().

    /**
     * Adiciona Cep ao mapa (no mapa - dicionario - e no banco de dados bdcep.dat).
     * A adicao e feita se o mapa nao for null e se nao ja houver o cep armazenado.
     */
    public boolean adicCepAoBancoDeDados(Cep CEP) {
        if ( mapa != null && !mapa.containsKey(CEP.getCep())){
            //adiciona objeto Cep na memoria em mapa.
        	mapa.put(CEP.getCep(), CEP);
        	
        	//Adiciona o objeto Cep no arquivo "bccep.dat".
        	try{
        		// Obtem o separador de linha do sistema operacional em uso.
        		String ENDLINE = System.getProperty ("line.separator");
        		
        	    // Prepara arquivo para "APPEND - TRUE de dados."
        	    FileWriter fstream = new FileWriter("bdcep.dat", true);
        	    
        	    // Torna possivel uma escrita mais eficiente no banco de dados bdcep.dat.
        	    BufferedWriter saida = new BufferedWriter(fstream);
        	    
        	    // Formata string para ser adicionada no banco de dados.
        	    String textoSaida = String.format("%s|%s|%s|%s|%s|%s" + ENDLINE, CEP.getCep(), CEP.getLogradouro(),
        	    		CEP.getBairro(), CEP.getCidade(), CEP.getUf(), CEP.getChave());
        	    saida.write(textoSaida);// Escreve no banco de dados a string formatada.
        	    
        	    //Fecha saida do fstream
        	    saida.close();
        	}
        	catch(SecurityException securityException){//
        		System.err.println("Error: " + securityException.getMessage() + securityException);
        	}
        	catch(IllegalArgumentException illegalArgumentException){
        		System.err.println("Error: " + illegalArgumentException.getMessage() + illegalArgumentException);
        	}
        	catch (IOException iOException){
        	    System.err.println("Error: " + iOException.getMessage() + iOException);
        	}
        	catch (Exception e){
        	    System.err.println("Error: " + e.getMessage() + e);
        	}
        	
            return true;
        }
        return false;
    }// Fim do metodo adicCepAoBancoDeDados(Cep CEP).

    /**
     * Remove Cep do mapa. Atualiza o banco de dados bdcep.dat.
     * 
     * @return
     * 		True - Em caso do Cep ser removido.
     * 		False - Em caso do Cep nao ser removido.
     */
    public boolean delCepDoBancoDeDados(Cep CEP) {
        
    	// Remove Cep do mapa se mapa nao for null e se contiver uma chave do Cep.
        if ( mapa != null && mapa.containsKey(CEP.getCep())){
            mapa.remove(CEP.getCep());
          //Atualizao BD com o objeto Cep no arquivo "bccep.dat".
        	try{
        	    // Prepara arquivo para leitura.
        		FileWriter leitura = new FileWriter(new File("bdcep.dat"));
        		
        		// Prepara arquivo para leitura otimizada.
    			BufferedWriter saida = new BufferedWriter(leitura, 1*1024*1024);
        	    
    			//Forma como o Cep esta armazenado no bdcep.dat.
    			//cep, logradouro, bairro, cidade, uf, chave
    			
    			// Obtem iterador em cima do conjunto gerado do mapa.
        	    Iterator<Entry<String, Cep>> it = mapa.entrySet().iterator();
    		    
        	    while (it.hasNext()){
        	    	// Analisa cada par chave-valor do conjunto do mapa.
    		        Entry<String, Cep> pairs = (Map.Entry<String, Cep>)it.next();
    		        Cep cepTemp = pairs.getValue();// Constroi Cep a partir do valor do par.
    		        
    		        // Formata string do Cep para ser armazenada n bdcep.dat.
    		        String cepString = String.format("%s|%s|%s|%s|%s|%s", cepTemp.getCep(), 
    		        		cepTemp.getLogradouro(), cepTemp.getBairro(), 
    		        		cepTemp.getCidade(), cepTemp.getUf(), cepTemp.getChave());
    		        
    		        saida.write(cepString);// Escreve no bdcep.dat.
    		    }// while
        	    
        	    //Fecha saida do fstream
        	    saida.close();
        	    return true;
        	}
        	catch(IllegalArgumentException illegalArgumentException){
        		System.err.println("ERRO: " + illegalArgumentException.getMessage() + 
        				illegalArgumentException);
        	}
        	catch (Exception e){ //Pega uma excecao se ocorrer
        	    System.err.println("ERRO: " + e.getMessage() + e);
        	}
            
        }
        
        return false;
    }// Fim do metodo delCepDoBancoDeDados(Cep CEP).

    /**
     * Calcula o total de registros na memoria carregados do
     * banco de dados.
     * 
     * @return
     * 		O total de registros no banco de dados.
     */
    public int totalRegistrosBancoDeDados() {
    	return mapa.size();
    }// Fim do metodo totalRegistrosBancoDeDados().

    /**
     * Pesquisa se CEP existe no bando de dados.
     * 
     * @return
     * 		true - Em caso de existir o Cep no banco de dados.
     * 		false - Em caso da existencia ser negada.
     */
    public boolean pesquisaCepNoBancoDeDadosLocal(String cep) {
        return mapa.containsKey(cep);
    }// Fim do metodo pesquisaCepNoBancoDeDadosLocal(String cep).

    /**
     * Verifica se o endereco http://www.republicavirtual.com.br/cep esta acessivel.
     * 
     * @exception
     * 		Em caso de problemas na conexao ou na acessibilidade ao endereco eletronico.
     */
    public boolean testaConexaoInternet() throws IOException {
    	
    	try{
            java.net.URL mandarMail = new java.net.URL("http://www.republicavirtual.com.br/cep");
            java.net.URLConnection conn = mandarMail.openConnection();

            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) conn;
            httpConn.connect();
            int x = httpConn.getResponseCode();
            if(x == 200){
                // System.out.println("Conectado");
                return true;
            }
        }
        catch(java.net.MalformedURLException urlmal){
            // System.err.println("Nao Conectado");
            return false;
        }
        catch(java.io.IOException ioexcp){
            // System.err.println("Nao Conectado");
            return false;
        }

        return false;

    }// Fim do metodo testaConexaoInternet().

    /**
     * Pesquisa se CEP existe no bando de dados online.
     * 
     * @return
     * 		True - Em caso de existir o Cep no banco de dados.
     * 		False - Em caso da existencia ser negada.
     */
    public boolean pesquisaCepBancoDeDadosOnline(String cep) {
    	WebServiceCep numCep = null;
    	try{
    		// Faz a busca para o cep
    		numCep = CepSearchEngineByQueryString.searchCep(cep);
    	}
    	catch(Exception e){
    		System.err.println("ERRO: " + e.getMessage() + e);
    	}
    	
        return numCep.wasSuccessful();
    }// Fim do metodo pesquisaCepBancoDeDadosOnline(String cep).
    
    /**
     * Verifica se devemos cadastrar o cep no banco de dados local
     * 
     * @param CEP
     * 		O CEP que se pretende cadastrar.
     * @return
     * 		True - Se houver a necessidade de se cadastrar o CEP.
     * 		False - Se a necessidade for negada.
     * @throws IOException
     * 		Excecao em caso de problemas ao se conectar ao site.
     */
    public boolean devoCadastrarCepNoBancoDeDados(String CEP) throws IOException{
    	WebServiceCep cep = null;
		//A ferramenta de busca ignora qualquer caracter que nao seja numero.
    	
    	try{
    		cep = CepSearchEngineByQueryString.searchCep(CEP);
    		return !mapa.containsKey(CEP) && testaConexaoInternet() && !cep.wasSuccessful();
    	}
    	catch(IOException iOException){
    		System.err.print("ERRO: " + iOException.getMessage() + iOException);
    	}
    	return false;
    	
    }// Fim do metodo devoCadastrarCepNoBancoDeDados(String CEP).

    /**
     * Recupera o Cep do banco de dados online.
     * 
     * @return
     * 		O Cep do banco de dados online.
     */
	public Cep recuperaCepBancoDeDadosOnline(String CEP) throws Exception {
		WebServiceCep cep = CepSearchEngineByQueryString.searchCep(CEP);
		Cep recupCep = new Cep(CEP, cep.getLogradouro(), cep.getBairro(), 
				cep.getCidade(), cep.getUf(), "true");
		
		return recupCep;
	}// Fim do metodo recuperaCepBancoDeDadosOnline(String CEP)
    
    

}// Fim da classe.


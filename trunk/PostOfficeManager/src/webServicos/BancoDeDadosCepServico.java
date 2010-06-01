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
 *
 */
public class BancoDeDadosCepServico implements BancoDeDadosCepServicoIF{

    private Map< String, Cep> mapa;

    public BancoDeDadosCepServico() throws Exception{
        mapa = new HashMap<String, Cep>();
        

        try {
            File arquivoBd = new File("bdcep.dat");
            if ( !( arquivoBd.exists() && arquivoBd.isFile() && arquivoBd.canRead() ) ){
                throw new FileNotFoundException("Arquivo bdcep.dat nao encontrado.");
            }
            FileReader arquivo = new FileReader("bdcep.dat");

            BufferedReader leitura = new BufferedReader(arquivo);
            String dado;
            while (leitura.ready()) {
                dado = leitura.readLine();
                String[] arrayDados = dado.split("\\|");
                //cep, logradouro, bairro, cidade, uf, chave
                Cep infoCep = new Cep(arrayDados[0], arrayDados[1], arrayDados[2],
                        arrayDados[3], arrayDados[4], arrayDados[5]);

                //adicionando dado no mapa
                mapa.put(arrayDados[0], infoCep);

            }
            leitura.close();
        }
        catch (IOException e) {
        }
    }

    public boolean adicCepAoBancoDeDados(Cep CEP) {
        if ( mapa != null && mapa.containsKey(CEP.getCep())){
            //adiciona objeto Cep na memoria em mapa.
        	mapa.put(CEP.getCep(), CEP);
        	
        	//Adiciona o objeto Cep no arquivo "bccep.dat".
        	try{
        	    // Cria arquivo para "APPEND - TRUE"
        	    FileWriter fstream = new FileWriter("bdcep.dat", true);
        	    BufferedWriter saida = new BufferedWriter(fstream);
        	    String textoSaida = String.format("%s|%s|%s|%s|%s|%s", CEP.getCep(), CEP.getLogradouro(),
        	    		CEP.getBairro(), CEP.getCidade(), CEP.getUf(), CEP.getChave());
        	    saida.write(textoSaida);
        	    //Fecha saida do fstream
        	    saida.close();
        	}
        	catch (IOException e){//Pega uma excecao se ocorrer
        	    System.err.println("Error: " + e.getMessage() + e);
        	}
        	
            return true;
        }
        return false;
    }

    public boolean delCepDoBancoDeDados(Cep CEP) {
        

        if ( mapa != null && mapa.containsKey(CEP.getCep())){
            mapa.remove(CEP.getCep());
          //Atualizao BD com o objeto Cep no arquivo "bccep.dat".
        	try{
        	    // Cria arquivo
        		FileWriter leitura = new FileWriter(new File("bdfunc.dat"));
    			BufferedWriter saida = new BufferedWriter(leitura, 1*1024*1024);
        	    //cep, logradouro, bairro, cidade, uf, chave
        	    Iterator<Entry<String, Cep>> it = mapa.entrySet().iterator();
    		    
        	    while (it.hasNext()) {
    		        Entry<String, Cep> pairs = (Map.Entry<String, Cep>)it.next();
    		        System.out.println(pairs.getKey() + " = " + pairs.getValue());
    		        Cep cepTemp = pairs.getValue();
    		        String cepString = String.format("%s|%s|%s|%s|%s|%s", cepTemp.getCep(), 
    		        		cepTemp.getLogradouro(), cepTemp.getBairro(), 
    		        		cepTemp.getCidade(), cepTemp.getUf(), cepTemp.getChave());
    		        saida.write(cepString);
    		    }
        	    
        	    //Fecha saida do fstream
        	    saida.close();
        	    return true;
        	}
        	catch (Exception e){ //Pega uma excecao se ocorrer
        	    System.err.println("Error: " + e.getMessage() + e);
        	}
            
        }
        
        return false;
    }

    /**
     * Calcula o total de registros na memoria carregados do
     * banco de dados.
     */
    public int totalRegistrosBancoDeDados() {
    	return mapa.size();
    }

    public boolean pesquisaCepNoBancoDeDadosLocal(String cep) {
        return mapa.containsKey(cep);
    }

    public boolean testaConexaoInternet() throws IOException {
    	
    	try{
    		InetAddress endereco = InetAddress.getByName("http://www.republicavirtual.com.br");
    		int timeout = 30000;  
      	  
        	if (endereco.isReachable(timeout))  {
        		return true;
        	}
        	else{
        		return false;
        	}
        }
    	catch(UnknownHostException unknownHostException){
    		System.err.print("Erro: " + unknownHostException.getMessage() + 
    				unknownHostException);
    	}
    	catch(IOException iOException){
    		System.err.print("Erro: " + iOException.getMessage() + 
    				iOException);
    	}
		return false;
        	  
    	
    	
    }

    public boolean pequisaCepBancoDeDadosOnline() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Verifica se devemos cadastrar o cep no banco de dados local
     * 
     * @param CEP
     * @return
     * @throws IOException 
     */
    public boolean devoCadastrarCepNoBancoDeDados(String CEP) throws IOException{
    	WebServiceCep cep = CepSearchEngineByQueryString.searchCep(CEP);
		//A ferramenta de busca ignora qualquer caracter que nao seja numero.
    	
    	try{
    		return !mapa.containsKey(CEP) && testaConexaoInternet() && !cep.wasSuccessful();
    	}
    	catch(IOException iOException){
    		System.err.print("Erro: " + iOException.getMessage() + iOException);
    	}
    	return false;
    	
    }


}


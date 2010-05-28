package webServicos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
                throw new FileNotFoundException("Arquivo bdcep.dat não encontrado.");
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
            //adiciona objeto Cep na memória em mapa.
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
        	catch (Exception e){//Pega uma exceção se ocorrer
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
        	    FileWriter fstream = new FileWriter("bdcep.dat");
        	    BufferedWriter saida = new BufferedWriter(fstream);
        	    
        	    //Iterando em uma série do mapa
        	    for (Map.Entry<String, Cep> entry : mapa.entrySet()){
        	    	Cep cep = entry.getValue();
        	    	
        	    	String textoSaida = String.format("%s|%s|%s|%s|%s|%s", entry.getKey(),
        	    			cep.getLogradouro(), cep.getBairro(), cep.getCidade(),
        	    			cep.getUf(), cep.getChave());
        	        saida.write(textoSaida);
        	    }
        	    
        	    //Fecha saida do fstream
        	    saida.close();
        	    return true;
        	}
        	catch (Exception e){//Pega uma exceção se ocorrer
        	    System.err.println("Error: " + e.getMessage() + e);
        	}
            
        }
        
        return false;
    }

    /**
     * Calcula o total de registros na memória carregados do
     * banco de dados.
     */
    public int totalRegistrosBancoDeDados() {
    	return mapa.size();
    }

    public boolean pesquisaCepNoBancoDeDadosLocal(String cep) {
        return mapa.containsKey(cep);
    }

    public boolean testaConexaoInternet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean pequisaCepBancoDeDadosOnline() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}


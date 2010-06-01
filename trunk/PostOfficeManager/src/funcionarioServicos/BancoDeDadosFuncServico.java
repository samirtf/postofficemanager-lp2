package funcionarioServicos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class BancoDeDadosFuncServico implements BancoDeDadosFuncServicoIF{
	
	private Map<String, FuncDados> mapa;         
    
    public BancoDeDadosFuncServico() throws Exception{
        mapa = new HashMap<String, FuncDados>();

        try {
            File arquivoBd = new File("bdfunc.dat");
            if ( !( arquivoBd.exists() && arquivoBd.isFile() && arquivoBd.canRead() ) ){
                throw new FileNotFoundException("Arquivo bdfunc.dat nao encontrado.");
            }
            FileReader arquivo = new FileReader("bdfunc.dat");

            BufferedReader leitura = new BufferedReader(arquivo);
            String dado;
            //nome|dataNascimento|cpf|salario|senha|chave
            while (leitura.ready()) {
                dado = leitura.readLine();
                String[] arrayDados = dado.split("\\|");
                FuncDados infoFunc = new FuncDados(arrayDados[0], arrayDados[1], arrayDados[2],
                        arrayDados[3], arrayDados[4], Boolean.valueOf(arrayDados[5]));

                //adicionando dado no mapa
                mapa.put(arrayDados[2], infoFunc);

            }
            leitura.close();
        }
        catch (IOException e) {
        	System.err.print("Erro: " + e.getMessage() + e);
        }
    }

	/**
	 * Adiciona um funcionario no banco de dados de funcionario.
	 * @param
	 * 		Objeto do tipo funcionario.
	 * @return
	 * 		True - Se o funcionario for adicionado ao banco de dados de funcionario.
	 * 		False - Se o funcionario nao for adicionado ao banco de dados de funcionario.
	 * @throws IOException 
	 */
	public boolean adicFuncAoBancoDeDados(FuncDados func) throws IOException{
		if ( mapa == null || !mapa.containsKey( func.getCpf() )){
			mapa.put(func.getCpf(), func);
			
			//adiciona no arquivo do banco de dados
			try{
				File arquivoBd = new File("bdfunc.dat");
	            if ( !( arquivoBd.exists() && arquivoBd.isFile() && arquivoBd.canRead() ) ){
	                throw new FileNotFoundException("Arquivo bdfunc.dat nao encontrado.");
	            }
	            
				FileWriter leitura = new FileWriter(new File("bdfunc.dat"),true);
				BufferedWriter saida = new BufferedWriter(leitura, 1*1024*1024);
				//nome|dataNascimento|cpf|salario|senha|chave
				String funcString = String.format("%s|%s|%s|%s|%s|%s", func.getNome(), func.getDataNascimento(), 
						func.getCpf(), func.getSalario(), func.getSenha(), func.getChave());
				saida.write(funcString);
				saida.close();
			}
			catch(IOException e){
				System.out.print("Erro: " + e.getMessage() + e);
			}
			
	           return true;
	    }
	        return false;
	}
	
	/**
	 * Remove um funcionario do banco de bados de funcionario.
	 * 
	 * @return
	 * 		True - Se o funcionario for removido do banco de dados de funcionario.
	 * 		False - Se o funcionario nao for removido do banco de dados de funcionario.
	 * @throws IOException 
	 */
	public boolean delFuncDoBancoDeDados(FuncDados func) throws IOException{
		boolean chave = false;

        if ( mapa != null && mapa.containsKey(func.getCpf())){
            mapa.remove(func.getCpf());
            chave = true;
            
            FileWriter leitura = new FileWriter(new File("bdfunc.dat"));
			BufferedWriter saida = new BufferedWriter(leitura, 1*1024*1024);
			Iterator<Entry<String, FuncDados>> it = mapa.entrySet().iterator();
			//nome|dataNascimento|cpf|salario|senha|chave
		    while (it.hasNext()) {
		        Map.Entry<String, FuncDados> pairs = (Map.Entry<String, FuncDados>)it.next();
		        FuncDados funcTemp = pairs.getValue();
		        String funcString = String.format("%s|%s|%s|%s|%s|%s", funcTemp.getNome(), 
		        		funcTemp.getDataNascimento(), pairs.getKey(), 
		        		funcTemp.getSalario(), funcTemp.getSenha(), funcTemp.getChave());
		        saida.write(funcString);
		    }
			
			saida.close();
        }
        
        return chave;
	}
	
	/**
	 * Retorna o numero de registros de funcionarios no banco de dados.
	 *
	 * @return
	 *      O numero de registros de funcionarios no banco de dados.
	 */
	public int totalRegistrosBancoDeDados(){
		return mapa.size();
	}
	   
	/**
	 * Pesquisa o funcionario no banco de dados local.
	 *
	 * @return
	 *      True - Se existir o funcionario no banco de dados local.
	 *      False - Se a existencia for negada.
	 */
	public boolean pesquisaFuncionarioNoBancoDeDadosLocal(FuncDados func){
		return this.mapa.containsKey(func.getCpf());
		
	}
	

}

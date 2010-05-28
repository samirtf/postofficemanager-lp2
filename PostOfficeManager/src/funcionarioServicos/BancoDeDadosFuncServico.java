package funcionarioServicos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import webServicos.Cep;
import correios.util.Funcionario;

public class BancoDeDadosFuncServico implements BancoDeDadosFuncServicoIF{
	
	private Map< String, FuncDados> mapa;
    private Map< String, FuncDados> mapaTemp;
    
    public BancoDeDadosFuncServico() throws Exception{
        mapa = new HashMap<String, FuncDados>();
        mapaTemp = new HashMap<String, FuncDados>();

        try {
            File arquivoBd = new File("bdfunc.dat");
            if ( !( arquivoBd.exists() && arquivoBd.isFile() && arquivoBd.canRead() ) ){
                throw new FileNotFoundException("Arquivo bdfunc.dat não encontrado.");
            }
            FileReader arquivo = new FileReader("bdfunc.dat");

            BufferedReader leitura = new BufferedReader(arquivo);
            String dado;
            while (leitura.ready()) {
                dado = leitura.readLine();
                String[] arrayDados = dado.split("\\|");
                //cep, logradouro, bairro, cidade, uf, chave
                FuncDados infoFunc = new FuncDados(arrayDados[0], arrayDados[1], arrayDados[2],
                        arrayDados[3], arrayDados[4], Boolean.valueOf(arrayDados[5]));

                //adicionando dado no mapa
                mapa.put(arrayDados[0], infoFunc);

            }
            leitura.close();
        }
        catch (IOException e) {
        }
    }

	/**
	 * Adiciona um Funcionario no Banco de Dados de Funcionario.
	 * @param
	 * 		Objeto do tipo Funcionario.
	 * @return
	 * 		True - Se o Funcionario for adicionado ao Banco de Dados de Funcionario.
	 * 		False - Se o Funcionario não for adicionado ao Banco de Dados de Funcionario.
	 */
	public boolean adicFuncAoBancoDeDados(FuncDados func){
		if ( (mapa == null && ( mapaTemp == null || !mapaTemp.containsKey(func.getCpf()))) ||
	            (!mapa.containsKey(func.getCpf()) && (mapaTemp == null || !mapaTemp.containsKey(func.getCpf()))) ){
	            mapaTemp.put(func.getCpf(), func);
	            return true;
	        }
	        return false;
	}
	
	/**
	 * Remove um Funcionario do Banco de Dados de Funcionario.
	 * 
	 * @return
	 * 		True - Se o Funcionario for removido do Banco de Dados de Funcionario.
	 * 		False - Se o Funcionario não for removido do Banco de Dados de Funcionario.
	 */
	public boolean delFuncDoBancoDeDados(FuncDados func){
		boolean chave = false;

        if ( mapa != null && mapa.containsKey(func.getCpf())){
            mapa.remove(func.getCpf());
            chave = true;
        }
        if ( mapaTemp != null && mapaTemp.containsKey(func.getCpf())){
            mapaTemp.remove(func.getCpf());
            chave = true;
        }
        return chave;
	}
	
	/**
	    * Retorna o número de registros de Funcionarios no banco de dados.
	    *
	    * @return
	    *      O número de registros de Funcionarios no banco de dados.
	    */
	public int totalRegistrosBancoDeDados(){
		
	}
	   
	
	public boolean pesquisaFuncionarioNoBancoDeDadosLocal();
	   /**
	    * Pesquisa cFuncionario no banco de dados local.
	    *
	    * @return
	    *      True - Se existir o Funcionario no banco de dados local.
	    *      False - Se a existência for negada.
	    */

}

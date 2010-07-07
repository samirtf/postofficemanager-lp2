package funcionarioServicos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import correios.util.Funcionario;
import correios.util.VerificaDados;

public class BancoDeDadosFuncServico implements BancoDeDadosFuncServicoIF{
	
	private Map<String, Funcionario> cadastros;         
    
    @SuppressWarnings("unchecked")
	public BancoDeDadosFuncServico() throws Exception{
        cadastros = new HashMap<String, Funcionario>();
    	
    	// Recupera usuarios cadastrados do banco de dados cadastrosUsuarios.txt.
    	ObjectInputStream inCadastrosFuncionarios = null;
    	ObjectOutputStream outCadastrosFuncionarios = null;

    	if( new File("bd_func.dat").exists() ){
    		try{
    			inCadastrosFuncionarios = new ObjectInputStream(
                        new FileInputStream("bd_func.dat"));
            	
            	cadastros = (HashMap<String, Funcionario>) inCadastrosFuncionarios.readObject();
            	
            }catch(Exception e){

            }finally{
            	inCadastrosFuncionarios.close();
            }
    	}else{
    		try {
    			outCadastrosFuncionarios = new ObjectOutputStream(
                        new FileOutputStream("bd_func.dat"));
    			
        	}catch (Exception e) {

			}finally{
				outCadastrosFuncionarios.close();
			}
    	}
    }

	/**
	 * Adiciona um funcionario no banco de dados de funcionario.
	 * @param func - Objeto do tipo funcionario.
	 * @return
	 * 		True - Se o funcionario for adicionado ao banco de dados de funcionario.
	 * 		False - Se o funcionario nao for adicionado ao banco de dados de funcionario.
	 * @throws IOException 
	 */
	public boolean adicFuncAoBancoDeDados(Funcionario func) throws IOException{
		if ( cadastros == null || !cadastros.containsKey( func.getCpf() )){
			cadastros.put(func.getCpf(), func);
			
			//Adiciona funcionarios ao banco de dados.
	    	ObjectOutputStream outCadastrosFuncionarios = null;

	    	try{
	    		outCadastrosFuncionarios = new ObjectOutputStream(
	                new FileOutputStream("bd_func.dat"));
	    		outCadastrosFuncionarios.writeObject(cadastros);
	                
	        }catch(Exception e){

	        }finally{
	            outCadastrosFuncionarios.close();
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
	public boolean delFuncDoBancoDeDados(Funcionario func) throws IOException{

        if ( cadastros != null && cadastros.containsKey(func.getCpf()) ){
        	cadastros.remove(func.getCpf());
        	ObjectOutputStream outCadastrosFuncionarios = null;
        	try{
	    		outCadastrosFuncionarios = new ObjectOutputStream(
	                new FileOutputStream("bd_func.dat"));
	    		outCadastrosFuncionarios.writeObject(cadastros);
	                
	        }catch(Exception e){

	        }finally{
	            outCadastrosFuncionarios.close();
	        }
	        return true;
            
        }
        return false;
	}
	
	/**
	 * Retorna o numero de registros de funcionarios no banco de dados.
	 *
	 * @return
	 *      O numero de registros de funcionarios no banco de dados.
	 */
	public int totalRegistrosBancoDeDados(){
		return cadastros.size();
	}
	   
	/**
	 * Pesquisa o funcionario no banco de dados local.
	 *
	 * @return
	 *      True - Se existir o funcionario no banco de dados local.
	 *      False - Se a existencia for negada.
	 */
	public boolean pesquisaFuncionarioNoBancoDeDadosLocal(Funcionario func){
		return this.cadastros.containsKey(func.getCpf());
		
	}
	
	/**
	 * Pesquisa um funcionario pelo CPF.
	 * @param cpf
	 * 		O CPF do funcionario.
	 * @return
	 * 		O funcionario procurado.
	 */
	public Funcionario pesquisaFuncionarioPorCpf(String cpf){
		if( cadastros != null && VerificaDados.validaCPF(cpf) &&
				cadastros.containsKey(cpf)){
			return cadastros.get(cpf);
		}
		
		return null;
	}
	
	/**
	 * Recupera os funcionarios cadastrados.
	 * @return
	 * 		Os funcionarios cadastrados.
	 */
	public Map<String, Funcionario> getCadastros(){
		return this.cadastros;
	}
	
	/**
	 * Gera uma representacao dos funcionarios.
	 * @return
	 * 		A representacao dos funcionarios.
	 */
	public String toString(){
		final String EOL = System.getProperty("line.separator"); 
		String toString = "";
		Set<String> chaves = cadastros.keySet();
		Iterator<String> iteraCadastros = chaves.iterator();
		while(iteraCadastros.hasNext()){
			toString += cadastros.get(iteraCadastros.next()).toString() + EOL;
		}
		return toString;
		
	}
	
}


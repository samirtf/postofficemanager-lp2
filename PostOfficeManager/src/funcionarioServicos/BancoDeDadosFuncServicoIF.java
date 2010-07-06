package funcionarioServicos;

import java.io.IOException;

import correios.util.Funcionario;



public interface BancoDeDadosFuncServicoIF {
	
	public boolean adicFuncAoBancoDeDados(Funcionario func) throws IOException;
	/**
	 * Adiciona um Funcionario no Banco de Dados de Funcionario.
	 * 
	 * @return
	 * 		True - Se o Funcionario for adicionado ao Banco de Dados de Funcionario.
	 * 		False - Se o Funcionario nao for adicionado ao Banco de Dados de Funcionario.
	 */
	
	public boolean delFuncDoBancoDeDados(Funcionario func) throws IOException;
	/**
	 * Remove um Funcionario do Banco de Dados de Funcionario.
	 * 
	 * @return
	 * 		True - Se o Funcionario for removido do Banco de Dados de Funcionario.
	 * 		False - Se o Funcionario nao for removido do Banco de Dados de Funcionario.
	 */
	
	public int totalRegistrosBancoDeDados();
	   /**
	    * Retorna o numero de registros de Funcionarios no banco de dados.
	    *
	    * @return
	    *      O numero de registros de Funcionarios no banco de dados.
	    */
	
	public boolean pesquisaFuncionarioNoBancoDeDadosLocal(Funcionario func);
	   /**
	    * Pesquisa o Funcionario no banco de dados local.
	    *
	    * @return
	    *      True - Se existir o Funcionario no banco de dados local.
	    *      False - Se a existencia for negada.
	    */
	
	

}


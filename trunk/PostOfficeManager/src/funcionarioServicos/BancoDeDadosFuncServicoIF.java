package funcionarioServicos;

import correios.util.Funcionario;

public interface BancoDeDadosFuncServicoIF {
	
	public boolean adicFuncAoBancoDeDados(Funcionario func);
	/**
	 * Adiciona um Funcionario no Banco de Dados de Funcionario.
	 * 
	 * @return
	 * 		True - Se o Funcionario for adicionado ao Banco de Dados de Funcionario.
	 * 		False - Se o Funcionario não for adicionado ao Banco de Dados de Funcionario.
	 */
	
	public boolean removeFuncDoBancoDeDados(Funcionario func);
	/**
	 * Remove um Funcionario do Banco de Dados de Funcionario.
	 * 
	 * @return
	 * 		True - Se o Funcionario for removido do Banco de Dados de Funcionario.
	 * 		False - Se o Funcionario não for removido do Banco de Dados de Funcionario.
	 */
	
	public int totalRegistrosBancoDeDados();
	   /**
	    * Retorna o número de registros de Funcionarios no banco de dados.
	    *
	    * @return
	    *      O número de registros de Funcionarios no banco de dados.
	    */
	
	public boolean pesquisaFuncionarioNoBancoDeDadosLocal();
	   /**
	    * Pesquisa cFuncionario no banco de dados local.
	    *
	    * @return
	    *      True - Se existir o Funcionario no banco de dados local.
	    *      False - Se a existência for negada.
	    */
	
	

}
package funcionarioServicos;


/**
 * Classe FuncDados
 * @author Samir TrajanoFeitosa
 * @version 1.0
 * 
 */

public class FuncDados {
	
	public String nome;
	public String dataNascimento;
	public String cpf;
	public String salario;
	public String senha;
	public boolean chave;

	/**
	 * Contrutor FuncDados
	 * @param nome
	 * @param dataNascimento
	 * @param cpf
	 * @param senha
	 * @param chave
	 */
	public FuncDados(String nome,String dataNascimento,
			String cpf, String salario, String senha, boolean chave){
		
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.salario = salario;
		this.senha = senha;
		this.chave = chave;
						
	}
	
	/**
	 * Recupera nome do Funcionario.
	 * 
	 * @return
	 * 		Dome do funcionario
	 */
	public String getNome(){
		return this.nome;
	}
	
	/**
	 * Recupera data de nascimento.
	 * 
	 * @return
	 * 		Data de nascimento do funcionario
	 */
	public String getDataNascimento(){
		return this.dataNascimento;
	}
	
	/**
	 * Recupera CPF do Funcionario.
	 * 
	 * @return
	 * 		O cpf do funcionario
	 */
	public String getCpf(){
		return this.cpf;
	}
	
	/**
	 * Medotodo abstrato implementado em suas subclasses
	 * 
	 * @return O salario do Funcionario.
	 */
	public String getSalario(){
		return this.salario;
	}
	
	
		

}
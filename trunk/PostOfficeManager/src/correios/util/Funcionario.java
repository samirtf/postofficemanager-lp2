package correios.util;

 /**
  * Classe mãe Funcionário
  * @author Rafael O. Vieira
  * @version 1.0
  * 
  */

public abstract class Funcionario {
	
	protected String nome,dataNascimento,cpf,salario,senha;
	protected boolean chave;

	/**
	 * Contrutor Funcionário
	 * @param nome
	 * @param dataNascimento
	 * @param cpf
	 * @param senha
	 * @param chave
	 */
	public Funcionario(String nome,String dataNascimento,
			String cpf, String senha, boolean chave){
		
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
						
	}
	/**
	 * Busca Nome do Funcionario
	 * @return nome do funcionario
	 */
	public String getNome(){
		return this.nome;
	}
	/**
	 * Busca a data de nascimento
	 * @return data de nascimento do funcionario
	 */
	public String getDataNascimento(){
		return this.dataNascimento;
	}
	/**
	 * Busca cpf
	 * @return o cpf do funcionario
	 */
	public String getCpf(){
		return this.cpf;
	}
	/**
	 * Medotodo abstrato implementado em suas subclasses
	 * 
	 */
	public abstract String getSalario();		
		

}

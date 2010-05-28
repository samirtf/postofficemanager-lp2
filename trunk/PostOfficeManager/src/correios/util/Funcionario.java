package correios.util;
import correios.util.VerificaDados;

 /**
  * Classe mãe Funcionário
  * @author Rafael O. Vieira
  * @version 1.0
  * 
  */

public class Funcionario {
	
	protected String nome,dataNascimento,cpf,salario,senha;
	protected boolean chave;

	/**
	 * Contrutor Funcionário
	 * @param nome
	 * @param dataNascimento
	 * @param cpf
	 * @param senha
	 * @param chave
	 * @throws Exception 
	 */
	public Funcionario(String nome,String dataNascimento,
			String cpf, String senha, boolean chave) throws Exception{
		
		VerificaDados.verificaNome(nome);
		VerificaDados.verificaData(dataNascimento);
		VerificaDados.verificaCpf(cpf);
		
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
			

}

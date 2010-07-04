package correios.util;
import correios.util.VerificaDados;

 /**
  * Classe mãe Funcionário
  * @author Rafael O. Vieira
  * @version 1.0
  * 
  */

public class Funcionario {
	
	private String nome,dataNascimento,cpf;
	private boolean chave = false;
	private String login = null;
	private double salario = 0.0;

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
			String cpf, double salario, String login) throws Exception{
		if( !VerificaDados.verificaNome(nome) ){
			throw new Exception("Nome invalido!");
		}
		else if( !VerificaDados.verificaData(dataNascimento) ){
			throw new Exception("Data invalida!");
		}
		else if( !VerificaDados.verificaCpf(cpf) ){
			throw new Exception("CPF invalido!");
		}
		else if( salario < 0 ){
			throw new Exception("Salario invalido!");
		}
		else if( login == null || login.trim().equals("")){
			throw new Exception("Login invalido!");
		}
		
		
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.salario = salario;
		this.login = login;
		this.chave = true;
						
	}//fim do construtor padrao
	
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
	
	public double getSalario(){
		return this.salario;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public boolean getChave(){
		return this.chave;
	}

	public boolean setNome(String nome){
		if( VerificaDados.verificaNome(nome) ){
			this.nome = nome;
			return true;
		}
		return false;
	}
	
	public boolean setDataNasc(String data){
		if( VerificaDados.verificaData(data) ){
			this.dataNascimento = data;
			return true;
		}
		return false;
	}
	
	public boolean setCpf(String cpf){
		if( VerificaDados.verificaCpf(cpf) ){
			this.cpf = cpf;
			return true;
		}
		return false;
	}
	
	public void setSalario(double salario){
		this.salario = salario;
	}
	
	public void setChave(boolean chave){
		this.chave = chave;
	}
	
}

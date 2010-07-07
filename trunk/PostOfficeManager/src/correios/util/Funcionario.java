package correios.util;
import correios.util.VerificaDados;

 /**
  * Classe Funcionario
  * @author
  * 	Marcus Vinicius Souza de Oliveira
  * 	Rafael O. Vieira
  * 	Samir Trajano Feitosa
  * 	Werton Vinícius Guimarães Gomes
  * 		
  * @version 1.0
  * 
  */

public class Funcionario {
	
	private String nome,dataNascimento,cpf;
	private boolean chave = false;
	private String login = null;
	private double salario = 0.0;

	/**
	 * Contrutor Funcionario
	 * @param nome
	 * @param dataNascimento
	 * @param cpf
	 * @param salario
	 * @param login
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
		else if( !VerificaDados.validaCPF(cpf) ){
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
	 * Recupera o nome do funcionario.
	 * @return
	 * 		O nome do funcionario.
	 */
	public String getNome(){
		return this.nome;
	}//fim do metodo getNome
	
	/**
	 * Recupera a data de nascimento do funcionario.
	 * @return
	 * 		Data de nascimento do funcionario.
	 */
	public String getDataNascimento(){
		return this.dataNascimento;
	}//fim do metodo getDataNascimento
	
	/**
	 * Recupera o CPF do funcionario.
	 * @return
	 * 		O CPF do funcionario.
	 */
	public String getCpf(){
		return this.cpf;
	}//fim do metodo getCpf
	
	/**
	 * Recupera o salario do funcionario.
	 * @return
	 * 		O salario do funcionario.
	 */
	public double getSalario(){
		return this.salario;
	}//fim de metodo getSalario
	
	/**
	 * Recupera o login do funcionario.
	 * @return
	 * 		O login do funcionario.
	 */
	public String getLogin(){
		return this.login;
	}//fim do metodo getLogin
	
	/**
	 * Recupera a chave do funcionario.
	 * @return
	 * 		A chave do funcionario.
	 */
	public boolean getChave(){
		return this.chave;
	}//fim do metodo getChave

	/**
	 * Configura o nome do funcionario.
	 * @param nome
	 * 		O nome do funcionario.
	 * @return
	 * 		True - Se o nome do funcionario for modificado.
	 * 		False - Se o nome do funcionario nao for modificado.
	 */
	public boolean setNome(String nome){
		if( VerificaDados.verificaNome(nome) ){
			this.nome = nome.trim();
			return true;
		}
		return false;
	}//fim do metodo setNome
	
	/**
	 * Configura a data de nascimento do funcionario.
	 * @param data
	 * 		A data de nascimento do funcionario.
	 * @return
	 * 		True - Se a data de nascimento for modificada.
	 * 		False - Se a data de nascimento nao for modificada.
	 */
	public boolean setDataNascimento(String data){
		if( VerificaDados.verificaData(data) ){
			this.dataNascimento = data.trim();
			return true;
		}
		return false;
	}//fim do metodo setDataNascimento
	
	/**
	 * Configura o CPF do funcionario.
	 * 
	 * @param cpf
	 * 		O CPF do funcionario.
	 * @return
	 * 		True - Se o CPF for alterado.
	 *      False - Se o CPF nã for alterado.
	 */
	public boolean setCpf(String cpf){
		if( VerificaDados.validaCPF(cpf) ){
			this.cpf = cpf.trim();
			return true;
		}
		return false;
	}//fim do metodo setCpf
	
	/**
	 * Cofigura o salario do funcionario.
	 * 
	 * @param salario
	 * 		O salario do fncionario.
	 */
	public boolean setSalario(double salario){
		if( salario >=0 ){
			this.salario = salario;
			return true;
		}
		return false;
	}//fim do metodo setSalario
	
	/**
	 * Configura a chave(funcionario ativo ou inativo) do funcionario.
	 * @param chave
	 * 		A chave do funcionario.
	 */
	public void setChave(boolean chave){
		this.chave = chave;
	}//fim do metodo setChave
	
	/**
	 * Configura o login do funcionario. Deve ser usado em conjunto com 
	 *     alteraLoginUsuario(GerenciamentoUsuario).
	 * @param login
	 *     O login do funcionario(login do usuario).
	 * @return
	 *     True - Se o login do funcionario(usuario) for trocado.
	 *     False - Se o login do funcionario(usuario) não for trocado.
	 */
	public boolean setLogin(String login){
		if(login != null && !login.trim().equals("") && login.matches("^[a-z A-z“]*$")){
			this.login = login.trim();
			return true;
		}
		return false;
	}//fim metodo setLogin
	
	/**
	 * Verifica a igualdade de dois funcionarios.
	 * 
	 * @return
	 * 		True - Se a igualdade dos funcionarios for verdadeira.
	 * 		False - Se o segundo objeto a ser comparado nao for um funcionario 
	 *              ou se os funcionarios comparados nao forem iguais. 
	 */
	public boolean equals(Object objeto){
		if( !(objeto instanceof Funcionario)){
			return false;
		}
		Funcionario outroFuncionario = (Funcionario) objeto;
		
		return this.getCpf().hashCode() == outroFuncionario.getCpf().hashCode();
	}//fim do metodo equals
	
	/**
	 * Cria uma representacao do funcionario.
	 */
	public String toString(){
		return "nome: " + this.getNome() + ", data nasc.: " + this.getDataNascimento() +
		       ", cpf: " + this.getCpf() + ", chave: " + this.getChave() +
		       ", login: " + this.getLogin() + ", salario: " + this.getSalario();
	}//fim do metodo toString.
	
}//fim da classe

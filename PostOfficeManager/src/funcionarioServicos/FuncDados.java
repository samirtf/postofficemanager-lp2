package funcionarioServicos;


/**
 * Classe FuncDados
 * @author Samir TrajanoFeitosa
 * @version 1.0
 * 
 */

public class FuncDados {
	
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String salario;
	private String senha;
	private boolean chave;

	/**
	 * Contrutor FuncDados
	 * @param nome
	 * @param dataNascimento
	 * @param cpf
	 * @param salario
	 * @param senha
	 * @param chave
	 */
	public FuncDados(String nome, String dataNascimento,
			String cpf, String salario, String senha, boolean chave)throws Exception{
		
		if ( nome == null || nome.trim().equals("") ){
			throw new Exception("Nome invalido.");
		}
		else if ( dataNascimento == null || dataNascimento.trim().equals("") ){
			throw new Exception("Data de Nascimento invalida.");
		}
		else if ( cpf == null || cpf.trim().equals("") ){
			throw new Exception("CPF invalido.");
		}
		else if ( salario == null || salario.trim().equals("") ){
			throw new Exception("Salario invalido.");
		}
		else if ( senha == null || senha.trim().equals("") ){
			throw new Exception("Senha invalida");
		}

		
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
	
	public String getSenha(){
		return this.senha;
	}
	
	public boolean getChave(){
		return this.chave;
	}
	
	/**
	 * Gera o inteiro hashcode de FuncDados
	 * 
	 * @return
	 * 		O hashcode de FuncDados.
	 */
	@Override
	public int hashCode(){
		int result = 17;  
		result = 37 * result + this.nome.hashCode() + this.cpf.hashCode();
		return result;
	}
	
	/**
	 * Compara se um objeto FuncDados é igual a outro.
	 * 
	 * @return
	 * 		True - Se os 2 objetos FuncDados forem iguais.
	 * 		False - Se os 2 objetos forem de instâncias diferentes 
	 *      ou se não forem objetos iguais.
	 */
	@Override
	public boolean equals(Object objeto){
		if ( !(objeto instanceof FuncDados )){
			return false;
		}
		
		FuncDados outroFuncDados = (FuncDados) objeto;
		return this.hashCode() == outroFuncDados.hashCode();
	}
	
	
		

}
package correios.util;
/**
 * Classe Carteiro
 * @author Rafael O. Vieira
 * @version 1.0
 *
 */
public class Carteiro extends Funcionario {
	/**
	 * Contrutor de Carteiro
	 * @param nome
	 * @param dataNascimento
	 * @param cpf
	 * @param senha
	 * @param chave - Status do carteiro no momento
	 * @param salario
	 */
	public Carteiro(String nome,String dataNascimento,
			String cpf,String senha, boolean chave,String salario){
		
		super(nome,dataNascimento,cpf,senha,chave);
		
		this.salario = salario;
		
	}
	
	/**
	 * Construtor 2
	 * @param Objeto Funcionario
	 * @param salario
	 */
	public Carteiro(Funcionario func, String salario){
		super( func.nome, func.dataNascimento, func.cpf, func.senha, 
				func.chave);
			
		this.salario = salario;
		
	}
	/**
	 * Busca o salario do carteiro
	 * @return salario
	 */
	@Override
	public String getSalario() {
		return this.salario;
	}
}

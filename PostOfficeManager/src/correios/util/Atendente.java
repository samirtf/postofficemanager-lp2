package correios.util;
/**
 * Classe Atendente
 * @author Rafael O. Vieira
 * @version 1.0
 */
public class Atendente extends Funcionario{
	/**
	 * Construto de atendente
	 * @param nome
	 * @param dataNascimento
	 * @param cpf
	 * @param senha
	 * @param chave - Status do funcionario no momento
	 * @param salario
	 */
	public Atendente(String nome,String dataNascimento,
			String cpf,String senha, boolean chave,String salario){
		
		super(nome,dataNascimento,cpf,senha,chave);
		
		this.salario = salario;
		
	}
	/**
	 * Contrutor  2 
	 * @param func - Objeto funcionario
	 * @param salario
	 */
	
	public Atendente(Funcionario func, String salario){
		super( func.nome, func.dataNascimento, func.cpf, func.senha, 
				func.chave);
			
		this.salario = salario;
		
	}
	/**
	 * Busca o salario da atendente 
	 * @return salario
	 */
	@Override
	public String getSalario() {
		return this.salario;
	}
}

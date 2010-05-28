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
	 * @throws Exception 
	 */
	public Atendente(String nome,String dataNascimento,
			String cpf,String senha, boolean chave,String salario) throws Exception{
		
		super(nome,dataNascimento,cpf,senha,chave);
		VerificaDados.verificaSoNumeros(salario);
		
		this.salario = salario;
		
	}
	/**
	 * Contrutor  2 
	 * @param func - Objeto funcionario
	 * @param salario
	 * @throws Exception 
	 */
	
	public Atendente(Funcionario func, String salario) throws Exception{
		super( func.nome, func.dataNascimento, func.cpf, func.senha, 
				func.chave);
		VerificaDados.verificaSoNumeros(salario);
			
		this.salario = salario;
		
	}
	/**
	 * Busca o salario da atendente 
	 * @return salario
	 */
	public String getSalario() {
		return this.salario;
	}
}

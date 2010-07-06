package funcionarioServicos.testes;

import correios.util.Funcionario;
import org.junit.*;

import funcionarioServicos.BancoDeDadosFuncServico;

public class BancoDeDadosFuncServicoTest {

	Funcionario func1 = null, func2 = null, func3 = null, func4 = null;
	BancoDeDadosFuncServico bdFunc = null;
	
	@Before
	public void criaFuncionarios(){
		try {
			func1 = new Funcionario("Samir","22031988", "22233366638", 7530.87, "samirtf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func1 = new Funcionario("Rafael","12061987", "50651797608", 7530.87, "rafaelcc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func1 = new Funcionario("Vinicius","06031991", "15601225605", 7530.87, "viniciuscc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func1 = new Funcionario("Werton","18101994", "14754174380", 7530.87, "wertoncc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			bdFunc = new BancoDeDadosFuncServico();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}// fim do metodo criaFuncionarios
	
	@Test
	public void adicFuncAoBancoDeDados(){
		
	}
}

package funcionarioServicos.testes;

import correios.util.Funcionario;
import org.junit.*;

public class BancoDeDadosFuncServicoTest {

	Funcionario func1 = null, func2 = null, func3 = null, func4 = null;
	
	@Before
	public void criaFuncionarios(){
		try {
			func1 = new Funcionario("Samir","22031988", "22233366638", 7530.87, "samirtf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func1 = new Funcionario("Rafael","12061987", "22233366638", 7530.87, "rafaelcc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func1 = new Funcionario("Vinicius","06031991", "22233366638", 7530.87, "viniciuscc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func1 = new Funcionario("Werton","18101994", "22233366638", 7530.87, "wertoncc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

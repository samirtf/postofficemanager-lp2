package funcionarioServicos.testes;

import java.io.IOException;

import correios.util.Funcionario;
import org.junit.*;

import funcionarioServicos.BancoDeDadosFuncServico;

public class BancoDeDadosFuncServicoTest {

	Funcionario func1 = null, func2 = null, func3 = null, func4 = null;
	BancoDeDadosFuncServico bdFunc = null;
	final String EOL = System.getProperty("line.separator"); 
	
	@Before
	public void criaFuncionarios(){
		try {
			func1 = new Funcionario("Samir","22031988", "22233366638", 7530.87, "samirtf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func2 = new Funcionario("Rafael","12061987", "50651797608", 7530.87, "rafaelcc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func3 = new Funcionario("Vinicius","06031991", "15601225605", 7530.87, "viniciuscc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			func4 = new Funcionario("Werton","18101994", "14754174380", 7530.87, "wertoncc");
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
	public void testesGerais(){
		
		//Teste para Adicao de funcionarios.
		
		Assert.assertEquals(0, bdFunc.totalRegistrosBancoDeDados() );
		try {
			Assert.assertTrue( bdFunc.adicFuncAoBancoDeDados(func1) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 1, bdFunc.totalRegistrosBancoDeDados() );
		
		Assert.assertEquals("Nome: Samir Trajano Feitosa\nData nasc.: 22\03\1988\n" +
				"CPF: 222.333.666-38\nEm atividade: SIM\nLogin: samirtf\nSalario: R$ 7530.87",
				bdFunc.pesquisaFuncionarioPorCpf(func1.getCpf()).toString());

		//adiciona o mesmo func1
		Assert.assertEquals(1, bdFunc.totalRegistrosBancoDeDados() );
		try {
			Assert.assertFalse( bdFunc.adicFuncAoBancoDeDados(func1) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 1, bdFunc.totalRegistrosBancoDeDados() );
		
		
		//adiciona func2
		Assert.assertEquals(1, bdFunc.totalRegistrosBancoDeDados() );
		try {
			Assert.assertTrue( bdFunc.adicFuncAoBancoDeDados(func2) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 2, bdFunc.totalRegistrosBancoDeDados() );
		Assert.assertEquals("Nome: Rafael\nData nasc.: 12\06\1987\nCPF: 506.517.976-08\n" +
				"Em atividade: SIM\nLogin: rafaelcc\nSalario: R$ 7530.87",
				bdFunc.pesquisaFuncionarioPorCpf(func2.getCpf()).toString());
		
		//adiciona func3
		Assert.assertEquals(2, bdFunc.totalRegistrosBancoDeDados() );
		try {
			Assert.assertTrue( bdFunc.adicFuncAoBancoDeDados(func3) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 3, bdFunc.totalRegistrosBancoDeDados() );
		Assert.assertEquals("Nome: Vinicius\nData nasc.: 06\03\1991\nCPF: 156.012.256-05\n" +
				"Em atividade: SIM\nLogin: viniciuscc\nsSalario: R$ 7530.87",
				bdFunc.pesquisaFuncionarioPorCpf(func3.getCpf()).toString());
		
		//adiciona func4
		Assert.assertEquals(3, bdFunc.totalRegistrosBancoDeDados() );
		try {
			Assert.assertTrue( bdFunc.adicFuncAoBancoDeDados(func4) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 4, bdFunc.totalRegistrosBancoDeDados() );
		Assert.assertEquals("Nome: Werton\nData nasc.: 18\10\1994\nCPF: 147.541.743-80\n" +
				"Em atividade: SIM\nLogin: wertoncc\nSalario: R$ 7530.87",
				bdFunc.pesquisaFuncionarioPorCpf(func4.getCpf()).toString());

		//Teste 1 de pesquisa de funcionarios
		Assert.assertTrue( bdFunc.pesquisaFuncionarioNoBancoDeDadosLocal(func1) );
		Assert.assertTrue( bdFunc.pesquisaFuncionarioNoBancoDeDadosLocal(func2) );
		Assert.assertTrue( bdFunc.pesquisaFuncionarioNoBancoDeDadosLocal(func3) );
		Assert.assertTrue( bdFunc.pesquisaFuncionarioNoBancoDeDadosLocal(func4) );
		
		String toStringBdFunc = "Nome: Werton\nData nasc.: 18\10\1994\nCPF: 147.541.743-80\n" +
		"Em atividade: SIM\nLogin: wertoncc\nSalario: R$ 7530.87" + EOL +
		"Nome: Vinicius\nData nasc.: 06\03\1991\nCPF: 156.012.256-05\n" +
		"Em atividade: SIM\nLogin: viniciuscc\nsSalario: R$ 7530.87" + EOL +
		"Nome: Samir Trajano Feitosa\nData nasc.: 22\03\1988\n" +
		"CPF: 222.333.666-38\nEm atividade: SIM\nLogin: samirtf\nSalario: R$ 7530.87" + EOL +
		"Nome: Rafael\nData nasc.: 12\06\1987\nCPF: 506.517.976-08\n" +
		"Em atividade: SIM\nLogin: rafaelcc\nSalario: R$ 7530.87" + EOL;

		Assert.assertEquals(toStringBdFunc, bdFunc.toString());
		
		
		
		//Teste 2 de pesquisa de funcionarios
		
		//Remove func1
		try {
			Assert.assertTrue( bdFunc.delFuncDoBancoDeDados(func1) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Tenta remover func1 nao existente.
		try {
			Assert.assertFalse( bdFunc.delFuncDoBancoDeDados(func1) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 3, bdFunc.totalRegistrosBancoDeDados() );
		
		//Remove func3
		try {
			Assert.assertTrue( bdFunc.delFuncDoBancoDeDados(func3) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 2, bdFunc.totalRegistrosBancoDeDados() );
		
		//Remove func2
		try {
			Assert.assertTrue( bdFunc.delFuncDoBancoDeDados(func2) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 1, bdFunc.totalRegistrosBancoDeDados() );
		
		//Remove func4
		try {
			Assert.assertTrue( bdFunc.delFuncDoBancoDeDados(func4) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals( 0, bdFunc.totalRegistrosBancoDeDados() );
		
	}//fim dos testes.
	
}//fim da classe de testes.

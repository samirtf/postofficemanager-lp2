package correios.util.testes;
import correios.util.Funcionario;
import correios.util.Atendente;
import correios.util.Carteiro;

import org.junit.*;


public class FuncionarioTest {
	Funcionario func1,func2,func3,func4,func5,func6;
	
	
	@Before
	public void criaFuncionarios() throws Exception{
		func1 = new Atendente("Rafael", "12111991", "07722185497", "******", true, "1300");
		func2 = new Carteiro("Oliveira", "23071989", "12345678945", "*****", false,"2500");
		func3 = new Funcionario("Vieira","25111996","05786321413","123456",true);
		func4 = new Funcionario("Samir","26051989","98745312697","789456", false);
		func5 = new Carteiro(func3,"3600");
		func6 = new Atendente(func4,"1650");
	}
	
	
	@Test 
	
	public void TestaConstrutor() throws Exception{
		try{
			Funcionario func7 = new Carteiro(func3,"23a44");
			Assert.fail("Devia esperar excecao de apenas numeros");
		}
		catch(Exception e){
			Assert.assertEquals("Deve conter apenas numeros", e.getMessage());
		}
		
		try{
			
		Funcionario func7 = new Carteiro("Vieira","111996","05786321413","123456",true,"2300");
		Assert.fail("Devia esperar excecao de data errada");
		
		}
		catch(Exception ex){
			Assert.assertEquals("Deve conter 8 digitos", ex.getMessage());
		}
		
		
		
	}
	
	@Test
	public void testGetNome(){
		
		Assert.assertEquals("Rafael", func1.getNome());
		Assert.assertEquals("Oliveira", func2.getNome());
		Assert.assertEquals("Vieira", func3.getNome());
		Assert.assertEquals("Samir", func4.getNome());
		Assert.assertEquals("Vieira", func5.getNome());
		Assert.assertEquals("Samir", func6.getNome());
		
	}
	
	@Test
	public void testGetDataDeNascimento(){
		Assert.assertEquals("12111991", func1.getDataNascimento());
		Assert.assertEquals("23071989", func2.getDataNascimento());
		Assert.assertEquals("25111996", func3.getDataNascimento());
		Assert.assertEquals("26051989", func4.getDataNascimento());
		Assert.assertEquals("25111996", func5.getDataNascimento());
		Assert.assertEquals("26051989", func6.getDataNascimento());
	}
	
	@Test
	public void testGetCpf(){
		Assert.assertEquals("07722185497", func1.getCpf());
		Assert.assertEquals("12345678945", func2.getCpf());
		Assert.assertEquals("05786321413", func3.getCpf());
		Assert.assertEquals("98745312697", func4.getCpf());
		Assert.assertEquals("05786321413", func5.getCpf());
		Assert.assertEquals("98745312697", func6.getCpf());
	}
	
	@Test
	public void testgetSalario(){
		
		Assert.assertEquals("1300", ((Atendente) func1).getSalario());
		Assert.assertEquals("2500", ((Carteiro) func2).getSalario());
		Assert.assertEquals("3600", ((Carteiro) func5).getSalario());
		Assert.assertEquals("1650", ((Atendente) func6).getSalario());
		
	}
}

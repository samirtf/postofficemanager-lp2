package correios.util.testes;
import correios.util.Funcionario;
import org.junit.*;


public class FuncionarioTest {
	Funcionario func1,func2,func3,func4,func5,func6;
	
	
	@Before
	public void criaFuncionarios() throws Exception{
		func1 = new Funcionario("Samir","260589", "22233366638", 7530.87
				, "samirtf");
		
	}
	
	
	@Test 
	
	public void TestaConstrutor() throws Exception{
		
		
		try{
			
		Funcionario func2 = new Funcionario(null,"260589", "22233366638",7530.87
				, "samirtf");
		
		
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
		
		
		
	}
}

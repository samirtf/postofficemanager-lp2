package correios.util.testes;
import correios.util.Funcionario;
import org.junit.*;


public class FuncionarioTest {
	Funcionario func1,func2,func3,func4,func5,func6;
	
	
	@Before
	public void criaFuncionarios() throws Exception{
		func1 = new Funcionario("Samir","26051989", "22233366638", 7530.87
				, "samirtf");
		
	}
	
	
	@Test 
	
	public void TestaConstrutor() throws Exception{
		
		try{	
		    Funcionario func2 = new Funcionario(null, "26051989", "22233366638", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de nome invalido - Nulo");
		}
		catch(Exception ex){
			Assert.assertEquals("Nome invalido!", ex.getMessage());
		}
		
		try{	
			Funcionario func2 = new Funcionario("", "26051989", "22233366638", 7530.87, "samirtf");
			Assert.fail("Esperava excecao de nome invalido - Vazio");
			}
			catch(Exception ex){
				Assert.assertEquals("Nome invalido!", ex.getMessage());
			}
			
		try{	
			Funcionario func2 = new Funcionario("3a", "26051989", "22233366638", 7530.87, "samirtf");
			Assert.fail("Esperava excecao de nome invalido - Nome com Digitos");
		}
		catch(Exception ex){
			Assert.assertEquals("Nome invalido!", ex.getMessage());
		}
		
	    try{	
		    Funcionario func1 = new Funcionario("Samir", null, "22233366638", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de data invalida - Nulo");
		}
		catch(Exception ex){
			Assert.assertEquals("Data invalida!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "", "22233366638", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de data invalida - Vazia");
		}
		catch(Exception ex){
			Assert.assertEquals("Data invalida!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "1212121a", "22233366638", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de data invalida - Caractere invalido");
		}
		catch(Exception ex){
			Assert.assertEquals("Data invalida!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", null, 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Nulo");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", "", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Vazio");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", "a3388888897", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Caractere invalido");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", "111111111111", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - DIGITO 1 e 2 Invalidos");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", "2223336", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Tamanho invalido");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", "2223336663844", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Tamanho invalido");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", "22233366638", -7530.87, "samirtf");
		    Assert.fail("Esperava excecao de salario invalido - Inferior a zero");
		}
		catch(Exception ex){
			Assert.assertEquals("Salario invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", "22233366638", 7530.87, null);
		    Assert.fail("Esperava excecao de login invalido - Nulo");
		}
		catch(Exception ex){
			Assert.assertEquals("Login invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "26051989", "22233366638", -7530.87, "");
		    Assert.fail("Esperava excecao de login invalido - Vazio");
		}
		catch(Exception ex){
			Assert.assertEquals("Salario invalido!", ex.getMessage());
		}
			
	}
	
	@Test
	public void testGetNome(){
		Assert.assertEquals("Samir", func1.getNome());
	}
	
	@Test
	public void testGetDataDeNascimento(){
		Assert.assertEquals("26051989", func1.getDataNascimento());
	}
	
	@Test
	public void testGetCpf(){
		Assert.assertEquals("22233366638", func1.getCpf());
	}
	
	@Test
	public void testgetSalario(){	
	}
}

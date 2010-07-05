package correios.util.testes;
import correios.util.Funcionario;
import org.junit.*;


public class FuncionarioTest {
	Funcionario func1,func2,func3,func4,func5,func6;
	
	
	@Before
	public void criaFuncionarios() throws Exception{
		func1 = new Funcionario("Samir","22031988", "22233366638", 7530.87, "samirtf");
	}
	
	@Test 
	public void TestaConstrutor() throws Exception{
		
		try{	
		    Funcionario func2 = new Funcionario(null, "22031988", "22233366638", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de nome invalido - Nulo");
		}
		catch(Exception ex){
			Assert.assertEquals("Nome invalido!", ex.getMessage());
		}
		
		try{	
			Funcionario func2 = new Funcionario("", "22031988", "22233366638", 7530.87, "samirtf");
			Assert.fail("Esperava excecao de nome invalido - Vazio");
			}
			catch(Exception ex){
				Assert.assertEquals("Nome invalido!", ex.getMessage());
			}
			
		try{	
			Funcionario func2 = new Funcionario("3a", "22031988", "22233366638", 7530.87, "samirtf");
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
		    Funcionario func1 = new Funcionario("Samir", "22031988", null, 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Nulo");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "22031988", "", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Vazio");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "22031988", "a3388888897", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Caractere invalido");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "22031988", "111111111111", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - DIGITO 1 e 2 Invalidos");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "22031988", "2223336", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Tamanho invalido");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "22031988", "2223336663844", 7530.87, "samirtf");
		    Assert.fail("Esperava excecao de CPF invalido - Tamanho invalido");
		}
		catch(Exception ex){
			Assert.assertEquals("CPF invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "22031988", "22233366638", -7530.87, "samirtf");
		    Assert.fail("Esperava excecao de salario invalido - Inferior a zero");
		}
		catch(Exception ex){
			Assert.assertEquals("Salario invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "22031988", "22233366638", 7530.87, null);
		    Assert.fail("Esperava excecao de login invalido - Nulo");
		}
		catch(Exception ex){
			Assert.assertEquals("Login invalido!", ex.getMessage());
		}
		
		try{	
		    Funcionario func1 = new Funcionario("Samir", "22031988", "22233366638", -7530.87, "");
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
		Assert.assertEquals("22031988", func1.getDataNascimento());
	}
	
	@Test
	public void testGetCpf(){
		Assert.assertEquals("22233366638", func1.getCpf());
	}
	
	@Test
	public void testGetSalario(){
		Assert.assertEquals(7530.87, func1.getSalario(), 0.007);
	}
	
	@Test
	public void testSetNome(){
		Assert.assertEquals("Samir", func1.getNome());
		Assert.assertFalse(func1.setNome(null));
		Assert.assertEquals("Samir", func1.getNome());
		
		Assert.assertFalse(func1.setNome("  "));
		Assert.assertEquals("Samir", func1.getNome());
		
		Assert.assertFalse(func1.setNome(" aa3a "));
		Assert.assertEquals("Samir", func1.getNome());
		
		Assert.assertTrue(func1.setNome(" Rafael Vieira "));
		Assert.assertEquals("Rafael Vieira", func1.getNome());
		
	}
	
	@Test
	public void testSetDataNascimento(){
		Assert.assertEquals("22031988", func1.getDataNascimento());
		
		Assert.assertFalse(func1.setDataNascimento(null));
		Assert.assertEquals("22031988", func1.getDataNascimento());
		
		Assert.assertFalse(func1.setDataNascimento("  "));
		Assert.assertEquals("22031988", func1.getDataNascimento());
		
		Assert.assertFalse(func1.setDataNascimento(" 3 "));
		Assert.assertEquals("22031988", func1.getDataNascimento());
		
		Assert.assertFalse(func1.setDataNascimento("333333333"));
		Assert.assertEquals("22031988", func1.getDataNascimento());
		
		Assert.assertFalse(func1.setDataNascimento("333sa333"));
		Assert.assertEquals("22031988", func1.getDataNascimento());
		
		Assert.assertTrue(func1.setDataNascimento("18053900"));
		Assert.assertEquals("18053900", func1.getDataNascimento());
	}
	
	@Test
	public void testSetCpf(){
		Assert.assertEquals("22233366638", func1.getCpf());
		
		Assert.assertFalse(func1.setCpf(null));
		Assert.assertEquals("22233366638", func1.getCpf());
		
		Assert.assertFalse(func1.setCpf("  "));
		Assert.assertEquals("22233366638", func1.getCpf());
		
		Assert.assertFalse(func1.setCpf(" 22233366 "));
		Assert.assertEquals("22233366638", func1.getCpf());
		
		Assert.assertFalse(func1.setCpf("223 8aaa8a "));
		Assert.assertEquals("22233366638", func1.getCpf());
		
		Assert.assertTrue(func1.setCpf("91383317135"));
		Assert.assertEquals("91383317135", func1.getCpf());
		
	}
	
	@Test
	public void testSetSalario(){
		Assert.assertEquals(7530.87, func1.getSalario(), 0.0007);
		
		Assert.assertFalse(func1.setSalario(-10.00));
		Assert.assertEquals(7530.87, func1.getSalario(), 0.0007);
		
		Assert.assertTrue(func1.setSalario(10.00));
		Assert.assertEquals(10.00, func1.getSalario(), 0.0007);
	}
	
	@Test
	public void testSetChave(){
		Assert.assertEquals(true, func1.getChave());
		func1.setChave(false);
		Assert.assertEquals(false, func1.getChave());
	}
	
	@Test
	public void testSetLogin(){
		Assert.assertEquals("samirtf", func1.getLogin());
		
		Assert.assertFalse(func1.setLogin(null));
		Assert.assertEquals("samirtf", func1.getLogin());
		
		Assert.assertFalse(func1.setLogin("  "));
		Assert.assertEquals("samirtf", func1.getLogin());
		
		Assert.assertFalse(func1.setLogin(" 3333 "));
		Assert.assertEquals("samirtf", func1.getLogin());
		
		Assert.assertFalse(func1.setLogin(" gftg3g "));
		Assert.assertEquals("samirtf", func1.getLogin());
		
		Assert.assertTrue(func1.setLogin(" jiujitsu "));
		Assert.assertEquals("jiujitsu", func1.getLogin());
	}
	
	@Test
	public void testEquals(){
		Funcionario func2 = null;
		Funcionario func3 = null;
		try {
			func2 = new Funcionario("Samir", "22031988", "91383317135", 7530.87, "samirtf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			func3 = new Funcionario("Samir", "12121212", "22233366638", 7530.87, "samirtf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertFalse( func1.equals(func2) );
		Assert.assertTrue( func1.equals(func3) );
	}
	
	
	
	
	
}

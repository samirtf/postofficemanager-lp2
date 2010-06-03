package funcionarioServicos.testes;

import junit.framework.Assert;


import org.junit.Before;
import org.junit.Test;

import funcionarioServicos.FuncDados;



/**
 *
 * @author Samir Trajano Feitosa 20921299
 */
public class FuncDadosTeste {
	FuncDados funcDados1;
	
	@Before
    public void setUpClass() throws Exception {
		funcDados1 = new FuncDados( "Fulano de Tal", "16121989",
				"22233366638", "195.56", "1234567", true );
    }
	
	public void testaErroNoConstrutor(){
		try{
			FuncDados funcDados = new FuncDados( null, "16121989",
					"22233366638", "195.56", "1234567", true );
			Assert.fail("Esperava mensagem de nome invalido.");
		}
		catch(Exception e){
			Assert.assertEquals("Nome invalido.", e.getMessage());
		}// fim do teste nome nulo.
		
		try{
			FuncDados funcDados = new FuncDados( "", "16121989",
					"22233366638", "195.56", "1234567", true );
			Assert.fail("Esperava mensagem de nome invalido.");
		}
		catch(Exception e){
			Assert.assertEquals("Nome invalido.", e.getMessage());
		}// fim do teste nome vazio.
		
		try{
			FuncDados funcDados = new FuncDados( "Fulano de Tal", null,
					"22233366638", "195.56", "1234567", true );
			Assert.fail("Esperava mensagem de data de nascimento invalida.");
		}
		catch(Exception e){
			Assert.assertEquals("Data de Nascimento invalida.", e.getMessage());
		}// fim do teste data de nascimento nula.
		
		try{
			FuncDados funcDados = new FuncDados( "Fulano de Tal", "",
					"22233366638", "195.56", "1234567", true );
			Assert.fail("Esperava mensagem de data de nascimento invalida.");
		}
		catch(Exception e){
			Assert.assertEquals("Data de Nascimento invalida.", e.getMessage());
		}// fim do teste data de nascimento vazia.
		
		try{
			FuncDados funcDados = new FuncDados( "Fulano de Tal", "16121989",
					null, "195.56", "1234567", true );
			Assert.fail("Esperava mensagem de CPF invalido.");
		}
		catch(Exception e){
			Assert.assertEquals("CPF invalido.", e.getMessage());
		}// fim do teste CPF null.
		
		try{
			FuncDados funcDados = new FuncDados( "Fulano de Tal", "16121989",
					"", "195.56", "1234567", true );
			Assert.fail("Esperava mensagem de CPF invalido.");
		}
		catch(Exception e){
			Assert.assertEquals("CPF invalido.", e.getMessage());
		}// fim do teste CPF vazio.
		
		try{
			FuncDados funcDados = new FuncDados( "Fulano de Tal", "16121989",
					"22233366638", null, "1234567", true );
			Assert.fail("Esperava mensagem de salario invalido.");
		}
		catch(Exception e){
			Assert.assertEquals("Salario invalido.", e.getMessage());
		}// fim do teste salario nulo.
		
		try{
			FuncDados funcDados = new FuncDados( "Fulano de Tal", "16121989",
					"22233366638", "", "1234567", true );
			Assert.fail("Esperava mensagem de salario invalido.");
		}
		catch(Exception e){
			Assert.assertEquals("Salario invalido.", e.getMessage());
		}// fim do teste salario vazio.
		
		try{
			FuncDados funcDados = new FuncDados( "Fulano de Tal", "16121989",
					"22233366638", "195.56", null, true );
			Assert.fail("Esperava mensagem de senha invalida.");
		}
		catch(Exception e){
			Assert.assertEquals("Senha invalida.", e.getMessage());
		}// fim do teste senha nula.
		
		try{
			FuncDados funcDados = new FuncDados( "Fulano de Tal", "16121989",
					"22233366638", "195.56", "", true );
			Assert.fail("Esperava mensagem de senha invalida.");
		}
		catch(Exception e){
			Assert.assertEquals("Senha invalida.", e.getMessage());
		}// fim do teste senha nula.
		
	}//fim do teste do Construtor
	
	@Test
	public void testaGetNome(){
		
		System.out.println("getNome");
        FuncDados instance = funcDados1;
        String expResult = "Fulano de Tal";
        String result = instance.getNome();
        Assert.assertEquals(expResult, result);
	}// fim do teste do metodo getNome.
	
	@Test
	public void testaGetDataDeNascimento(){
		
		System.out.println("getDataDeNascimento");
        FuncDados instance = funcDados1;
        String expResult = "16121989";
        String result = instance.getDataNascimento();
        Assert.assertEquals(expResult, result);
	}// fim do teste do metodo getDataDeNascimento.
	
	@Test
	public void testaGetCpf(){
		
		System.out.println("getCpf");
        FuncDados instance = funcDados1;
        String expResult = "22233366638";
        String result = instance.getCpf();
        Assert.assertEquals(expResult, result);
	}// fim do teste do metodo getCpf.
	
	@Test
	public void testaGetSalario(){
		
		System.out.println("getSalario");
        FuncDados instance = funcDados1;
        String expResult = "195.56";
        String result = instance.getSalario();
        Assert.assertEquals(expResult, result);
	}// fim do teste do metodo getSalario.
	
	@Test
	public void testaGetSenha(){
		
		System.out.println("getSenha");
        FuncDados instance = funcDados1;
        String expResult = "1234567";
        String result = instance.getSenha();
        Assert.assertEquals(expResult, result);
	}// fim do teste do metodo getSenha.
	
	@Test
	public void testaGetChave(){
		
		System.out.println("getChave");
        FuncDados instance = funcDados1;
        boolean expResult = true;
        boolean result = instance.getChave();
        Assert.assertEquals(expResult, result);
	}// fim do teste do metodo getChave.
	
	@Test
	public void testaEquals() throws Exception{
		System.out.println("equals(param)");
		FuncDados outroFuncDados = new FuncDados( "Fulano de Tal", "16121989",
				"22233366638", "1959.56", "12345679969", true );
		Assert.assertTrue(funcDados1.equals(outroFuncDados));
	}
	
}// fim da classe de testes FuncDadosTeste

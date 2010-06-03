package webServicos.testes;

import org.junit.After;
import org.junit.Before;

import webServicos.BancoDeDadosCepServico;
import webServicos.Cep;

public class BancoDeDadosCepServicoTeste {
	Cep cep1;
	BancoDeDadosCepServico correiosBD;
	@Before
	public void setUpClass() throws Exception {
		try{
			cep1 = new Cep(null, "Av. Francisco C. Campos", "Monte", "Caninde", "CE", "true");
			correiosBD = new BancoDeDadosCepServico();
			
			//TODO remover testa conexao para outro lugar
			correiosBD.testaConexaoInternet();
		}
		catch(Exception e){
			System.out.println("ERRO: " + e.getMessage() + e);
		}
    }

    @After
    public void tearDownClass() throws Exception {
    }
    
    public void testaAdicCepAoBancoDeDados(){
    	correiosBD.adicCepAoBancoDeDados(cep1);
    	System.out.println(correiosBD.getMapaBD().size());
    }
	
	
}

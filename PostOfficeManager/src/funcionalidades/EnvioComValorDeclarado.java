package funcionalidades;

import correios.util.Atendente;

public class EnvioComValorDeclarado extends Encomenda {
	
	private double valorDeclarado;
	
	public EnvioComValorDeclarado(String dataDeEnvio, String dataDeChegada, 
	                   String cepRemetente, String cepDestinatario,
	                   double peso, Atendente atendente, int chancesDeSerEntregue,
	                   double valorDeclarado) {
		
		super(dataDeEnvio, dataDeChegada, 
		      cepRemetente, cepDestinatario,
		      peso, atendente, chancesDeSerEntregue);
		
		this.valorDeclarado = valorDeclarado;
		
	}

	public double custo() {
		return 0;
	}
	
	public double getValorDeclarado() {
		return valorDeclarado;
	}
}
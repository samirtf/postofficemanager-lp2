package funcionalidades;

import correios.util.Atendente;

public class EnvioRegistrado extends Encomenda {
	
	public EnvioRegistrado(String dataDeEnvio, String dataDeChegada, 
	                       String cepRemetente, String cepDestinatario,
	                       double peso, Atendente atendente, int chancesDeSerEntregue) {
		
		super(dataDeEnvio, dataDeChegada, 
		      cepRemetente, cepDestinatario,
		      peso, atendente, chancesDeSerEntregue);	
	}

	public double custo() {
		return (double) 1.4 + (int) (getPeso()*10)*0.2;
	}
	
	public String getRegistro() {
		return String.format("%d", hashCode());
	}
}

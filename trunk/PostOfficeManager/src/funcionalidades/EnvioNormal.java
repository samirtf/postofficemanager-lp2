package funcionalidades;

import correios.util.Atendente;

public class EnvioNormal extends Encomenda {

	public EnvioNormal(String dataDeEnvio, String dataDeChegada, 
	                   String cepRemetente, String cepDestinatario,
	                   double peso, Atendente atendente, int chancesDeSerEntregue) {
		
		super(dataDeEnvio, dataDeChegada, 
		      cepRemetente, cepDestinatario,
		      peso, atendente, chancesDeSerEntregue);
		
	}
	
	public double custo() {
		return (double) 0.75 + (int) (getPeso()*10)*0.2;
	}
}

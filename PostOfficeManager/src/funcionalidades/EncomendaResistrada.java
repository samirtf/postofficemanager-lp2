package funcionalidades;

public class EncomendaResistrada {
	private String codigo_rastreamento, endereco_da_entrega;
	private int  hora, minuto;
	public EncomendaResistrada(String codigo_rastreamento, String endereco_da_entrega, int hora, int minuto) throws Exception{
		if (codigo_rastreamento == null || codigo_rastreamento.trim() == "" || endereco_da_entrega == null || endereco_da_entrega.trim() == "" ||
				(hora >= 0 && hora <= 23) || (minuto >= 0 && minuto <=59)){
			throw new Exception();
		}
		this.codigo_rastreamento = codigo_rastreamento;
		this.endereco_da_entrega = endereco_da_entrega;
		this.hora = hora;
		this.minuto = minuto;		
	}
	
	//Metados acessadores
	public String getCodigoRastreamento() {
		return codigo_rastreamento;
	}
	
	public String getEnderecoDaEntrega() {
		return endereco_da_entrega;
	}
	
	public int getHora() {
		return hora;
	}
	
	public int getMinuto() {
		return minuto;
	}

}

package correios.util;

import java.util.ArrayList;


public class Agencia {
	
	private Atendente atendenteAtivo;
	private ArrayList<Encomenda> listaDeEncomendas;
	
	public Agencia(Atendente atendenteAtivo) {
		this.atendenteAtivo = atendenteAtivo;
		listaDeEncomendas = new ArrayList<Encomenda>();
	}
	
	public Atendente getAtendenteAtivo() {
		return atendenteAtivo;
	}
	
	public ArrayList<Encomenda> getEncomendas() {
		return listaDeEncomendas;
	}
	
	/*public ArrayList<Encomenda> getEncomendasCidade(String cidade) {
		ArrayList<Encomeencomendasnda> encomendasCidade;
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getCidade().equals(cidade)) {
				encomendasCidade.add(encomenda);
			}
		}
		return encomendasCidade;
	}
	encomendas
	public ArrayList<Encomenda> getEncomendasEstado(String estado) {
		ArrayList<Encomenda> encomendasEstado;
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getEstado().equals(estado)) {
				encomendasEstado.add(encomenda);
			}
		}
		return encomendasEstado;
	}*/
	
	public ArrayList<Encomenda> getEncomendasCEPDestinatario(String CEP) {
		ArrayList<Encomenda> encomendasCEPDestinatario = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getCEPdestinatario().equals(CEP)) {
				encomendasCEPDestinatario.add(encomenda);
			}
		}
		return encomendasCEPDestinatario;
		
	}
	
	public ArrayList<Encomenda> getEncomendasCEPRemetente(String CEP) {
		ArrayList<Encomenda> encomendasCEPRemetente = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getCEPremetente().equals(CEP)) {
				encomendasCEPRemetente.add(encomenda);
			}
		}
		return encomendasCEPRemetente;
		
	}
	
	public ArrayList<Encomenda> getEncomendasDataEnvio(String data) {
		ArrayList<Encomenda> encomendasDataEnvio = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getData().equals(data)) {
				encomendasDataEnvio.add(encomenda);
			}
		}
		return encomendasDataEnvio;
		
	}
	
	
}
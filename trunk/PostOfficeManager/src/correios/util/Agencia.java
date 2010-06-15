package correios.util;

import java.util.ArrayList;
/**
 * Classe que implementa os atributos e comportamentos de uma agencia de Correios.
 * @author Vinícius Souza
 * @version 1.0
 */
public class Agencia {
	
	private Atendente atendenteAtivo;
	private ArrayList<Encomenda> listaDeEncomendas;
	
	/**
	 * Construtor da classe. O usuário passado como parâmetro tem que estar ativo no momento.
	 * @param Atendente - atendente ativo no momento.
	 */
	public Agencia(Atendente atendenteAtivo) {
		this.atendenteAtivo = atendenteAtivo;
		listaDeEncomendas = new ArrayList<Encomenda>();
	}
	/**
	 * Retorna o atendente ativo no momento.
	 * @return Atendente - atendente ativo
	 */
	public Atendente getAtendenteAtivo() {
		return atendenteAtivo;
	}
	/**
	 * Retorna uma lista com todas as encomendas
	 * @return List<Encomenda> - lista das encomendas.
	 */
	public ArrayList<Encomenda> getEncomendas() {
		return listaDeEncomendas;
	}
	/**
	 * Retorna uma lista com todas as encomendas de uma determinada cidade.
	 * @param String - cidade
	 * @return List<Encomenda> - lista das encomendas.
	 */
	public ArrayList<Encomenda> getEncomendasCidade(String cidade) {
		ArrayList<Encomenda> encomendasCidade = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getCidade().equals(cidade)) {
				encomendasCidade.add(encomenda);
			}
		}
		return encomendasCidade;
	}
	/**
	 * Retorna uma lista com todas as encomendas de um determinado estado.
	 * @param String - estado
	 * @return List<Encomenda> - lista das encomendas.
	 */
	public ArrayList<Encomenda> getEncomendasEstado(String estado) {
		ArrayList<Encomenda> encomendasEstado = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getEstado().equals(estado)) {
				encomendasEstado.add(encomenda);
			}
		}
		return encomendasEstado;
	}
	/**
	 * Retorna uma lista com todas as encomendas, que possuem um determinado CEP destinatário.
	 * @param String - CEP
	 * @return List<Encomenda> - lista das encomendas.
	 */
	public ArrayList<Encomenda> getEncomendasCEPDestinatario(String CEP) {
		ArrayList<Encomenda> encomendasCEPDestinatario = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getCepDestinatario().equals(CEP)) {
				encomendasCEPDestinatario.add(encomenda);
			}
		}
		return encomendasCEPDestinatario;	
	}
	/**
	 * Retorna uma lista com todas as encomendas, que possuem um determinado CEP remetente.
	 * @param String - CEP
	 * @return List<Encomenda> - lista das encomendas.
	 */
	public ArrayList<Encomenda> getEncomendasCEPRemetente(String CEP) {
		ArrayList<Encomenda> encomendasCEPRemetente = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getCepRemetente().equals(CEP)) {
				encomendasCEPRemetente.add(encomenda);
			}
		}
		return encomendasCEPRemetente;
		
	}
	/**
	 * Retorna uma lista com todas as encomendas enviadas numa determinada data.
	 * @param String - data
	 * @return List<Encomenda> - lista das encomendas.
	 */
	public ArrayList<Encomenda> getEncomendasDataEnvio(String data) {
		ArrayList<Encomenda> encomendasDataEnvio = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getDataEnvio().equals(data)) {
				encomendasDataEnvio.add(encomenda);
			}
		}
		return encomendasDataEnvio;
		
	}
	/**
	 * Retorna uma lista com todas as encomendas recebidas numa determinada data.
	 * @param String - data
	 * @return List<Encomenda> - lista das encomendas.
	 */
	public ArrayList<Encomenda> getEncomendasDataRecebimento(String data) {
		ArrayList<Encomenda> encomendasDataRecebimento = new ArrayList<Encomenda>();
		for (Encomenda encomenda: listaDeEncomendas) {
			if (encomenda.getDataRecebimento().equals(data)) {
				encomendasDataRecebimento.add(encomenda);
			}
		}
		return encomendasDataRecebimento;
	}	
}
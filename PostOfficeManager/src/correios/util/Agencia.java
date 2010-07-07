package correios.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que implementa os atributos e comportamentos de uma agencia de Correios.
 * @author Marcus Vinicius Souza de Oliveira
 *         Rafael Oliveira Vieira
 *         Samir Trajano Feitosa
 *         Werton Vinicius Guimaraes Gomes
 * @version 1.6
 */
public class Agencia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomeDoAtendente;
	private ArrayList<Encomenda> listaDeEncomendas;
	
	
	/**
	 * Construtor da classe. Eh passado como parametro um usuario que deverah estar ativo no momento.
	 * @param nomeDoAtendente - atendente ativo no momento.
	 */
	public Agencia(String nomeDoAtendente) {
		this.nomeDoAtendente = nomeDoAtendente;
		
		//LEITURA		
		try {
			FileInputStream fis = new FileInputStream("encomendas_file.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			listaDeEncomendas = (ArrayList<Encomenda>) ois.readObject();
			fis.close();
			ois.close();
		//caso algum erro ocorra uma nova lista de encomendas eh criada
		} catch (Exception e) {
			e.printStackTrace();
			listaDeEncomendas = new ArrayList<Encomenda>();
		}
		salvarEmDisco();
	}
	/**
	 * Retorna o atendente ativo no momento.
	 * @return Atendente - atendente ativo
	 */
	public String getnomeDoAtendente() {
		return nomeDoAtendente;
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
	 * @param cidade - Nome de uma cidade, para ser feita uma pesquisa
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
	 * @param estado - Estado para ser feita a pesquisa.
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
	 * @param CEP - Numero para ser feita a pesquisa.
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
	 * @param CEP - recebe um conjunto de oito numeros, referentes ao CEP, para ser feita uma pesquisa.
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
	 * @param  data - Recebe um conjunto de oito numeros, para ser feita uma pesquisa.
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
	 * @param data - recebe um conjunto de oito numeros, referentes ao CEP, para ser feita uma pesquisa.
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
	
	/**
	 * Metodo utilizado para o envio de encomendas.
	 * @param encomenda - encomenda a ser enviada.
	 * @return boolean - se a operacao realizada.
	 */
	public boolean addEncomenda(Encomenda encomenda) { 
		listaDeEncomendas.add(encomenda);
		return salvarEmDisco();
		

	}
	
	/**
	 * Tenta criar uma encomenda simples com os atributos passados como parametros.
	 * Caso a encomenda tenha que ser de outro tipo(Expressa) o metodo retornara uma encomenda expressa.
	 * Caso haja algum parametros seja invalido, retornara null.
	 * @param cepRemetente - Recebe um conjunto de oito numeros
	 * @param cepDestinatario - Recebe um conjunto de oito numeros
	 * @param dataEnvio - Recebe um conjunto de oito numeros
	 * @param atendente - Recebe um nome de um atendente
	 * @param cidade - Recebe um nome de uma cidade
	 * @param estado - Recebe um nome de um estado, referente a cidade
	 * @param peso - o peso da carta
	 * @return Encomenda - se a encomendar puder ser criada, ela sera retornada,
	 * caso nao retornara <i>null</i>.
	 */
	public Encomenda criaEncomendaSimples(String cepRemetente, String cepDestinatario, String dataEnvio, 
								   String atendente, String cidade, String estado, double peso) {
		try {
			return new Encomenda(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
		} catch (Exception e) {
			if (e.getMessage()=="algum(ns) parametro(s) invalido(s)") {
				return null;
			}
			if (e.getMessage()=="tipo errado de encomenda") {
				try {
					return new EncomendaExpressa(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
				} catch (Exception exc) {
					if (exc.getMessage()=="algum(ns) parametro(s) invalido(s)") {
						return null;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Tenta criar uma encomenda simples (com valor declarado) com os atributos passados como parametros.
	 * Caso a encomenda tenha que ser de outro tipo(Expressa) o metodo retornara uma encomenda expressa.
	 * Caso haja algum parametros seja invalido, retornará null.
	 * @param cepRemetente - Recebe um conjunto de oito numeros
	 * @param cepDestinatario - Recebe um conjunto de oito numeros
	 * @param dataEnvio - Recebe um conjunto de oito numeros
	 * @param atendente - Recebe um nome de um atendente
	 * @param cidade - Recebe um nome de uma cidade
	 * @param estado - Recebe um nome de um estado, referente a cidade
	 * @param peso - O peso da carta
	 * @param valorDeclarado - Pega um valor declarado
	 * @return Encomenda - se a encomendar puder ser criada, ela sera retornada,
	 * caso não retornara <i>null</i>.
	 */
	public Encomenda criaEncomendaSimples(String cepRemetente, String cepDestinatario, String dataEnvio, 
								   String atendente, String cidade, String estado, double peso, double valorDeclarado) {
		try {
			return new Encomenda(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso, valorDeclarado);
		} catch (Exception e) {
			if (e.getMessage()=="algum(ns) parametro(s) inválido(s)") {
				return null;
			}
			if (e.getMessage()=="tipo errado de encomenda") {
				try {
					return new EncomendaExpressa(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso, valorDeclarado);
				} catch (Exception exc) {
					if (exc.getMessage()=="algum(ns) parametro(s) inválido(s)") {
						return null;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Tenta criar uma encomenda registrada com os atributos passados como parâmetros.
	 * Caso a encomenda tenha que ser de outro tipo(Expressa) o metodo retornará uma encomenda expressa.
	 * Caso haja algum parametro seja invalido, retornara null.
	 * @param cepRemetente - Recebe um conjunto de oito numeros
	 * @param cepDestinatario - Recebe um conjunto de oito numeros
	 * @param dataEnvio - Recebe um conjunto de oito numeros
	 * @param atendente - Recebe um nome de um atendente
	 * @param cidade - Recebe um nome de uma cidade
	 * @param estado - Recebe um nome de um estado, referente a cidade
	 * @param peso - o peso da carta
	 * @return Encomenda - se a encomendar puder ser criada, ela sera retornada,
	 * caso nao retornara <i>null</i>.
	 */
	public Encomenda criaEncomendaRegistrada(String cepRemetente, String cepDestinatario, String dataEnvio, 
								   String atendente, String cidade, String estado, double peso) {
		try {
			return new EncomendaRegistrada(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
		} catch (Exception e) {
			if (e.getMessage()=="algum(ns) parametro(s) inválido(s)") {
				return null;
			}
			if (e.getMessage()=="tipo errado de encomenda") {
				try {
					return new EncomendaExpressa(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
				} catch (Exception exc) {
					if (exc.getMessage()=="algum(ns) parametro(s) inválido(s)") {
						return null;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Tenta criar uma encomenda registrada (com valor declarado) com os atributos passados como parâmetros.
	 * Caso a encomenda tenha que ser de outro tipo(Expressa) o método retornará uma encomenda expressa.
	 * Caso haja algum parâmetro seja inválido, retornará null.
	 * @param cepRemetente - Recebe um conjunto de oito numeros
	 * @param cepDestinatario - Recebe um conjunto de oito numeros
	 * @param dataEnvio - Recebe um conjunto de oito numeros
	 * @param atendente - Recebe um nome de um atendente
	 * @param cidade - Recebe um nome de uma cidade
	 * @param estado - Recebe um nome de um estado, referente a cidade
	 * @param peso - O peso da carta
	 * @param valorDeclarado - Pega um valor declarado
	 * @return Encomenda - se a encomendar puder ser criada, ela sera retornada,
	 * caso não retornara <i>null</i>.
	 */
	public Encomenda criaEncomendaRegistrada(String cepRemetente, String cepDestinatario, String dataEnvio, 
								   String atendente, String cidade, String estado, double peso, double valorDeclarado) {
		try {
			return new EncomendaRegistrada(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso, valorDeclarado);
		} catch (Exception e) {
			if (e.getMessage()=="algum(ns) parametro(s) inválido(s)") {
				return null;
			}
			if (e.getMessage()=="tipo errado de encomenda") {
				try {
					return new EncomendaExpressa(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso, valorDeclarado);
				} catch (Exception exc) {
					if (exc.getMessage()=="algum(ns) parametro(s) inválido(s)") {
						return null;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Tenta criar uma encomenda expressa com os atributos passados como parâmetros.
	 * Caso haja algum parâmetro seja inválido, retornará null.
	* @param cepRemetente - Recebe um conjunto de oito numeros
	 * @param cepDestinatario - Recebe um conjunto de oito numeros
	 * @param dataEnvio - Recebe um conjunto de oito numeros
	 * @param atendente - Recebe um nome de um atendente
	 * @param cidade - Recebe um nome de uma cidade
	 * @param estado - Recebe um nome de um estado, referente a cidade
	 * @param peso - O peso da carta
	 * @return Encomenda - tenta retornar uma encomenda expresa, caso não retornará <i>null</i>.
	 */
	public Encomenda criaEncomendaExpressa(String cepRemetente, String cepDestinatario, String dataEnvio, 
								   String atendente, String cidade, String estado, double peso) {
		try {
			return new EncomendaExpressa(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Tenta criar uma encomenda expressa (com valor declarado) com os atributos passados como parâmetros.
	 * Caso haja algum parâmetro seja inválido, retornará null.
	 * @param cepRemetente - Recebe um conjunto de oito numeros
	 * @param cepDestinatario - Recebe um conjunto de oito numeros
	 * @param dataEnvio - Recebe um conjunto de oito numeros
	 * @param atendente - Recebe um nome de um atendente
	 * @param cidade - Recebe um nome de uma cidade
	 * @param estado - Recebe um nome de um estado, referente a cidade
	 * @param peso - O peso da carta
	 * @param valorDeclarado - Pega um valor declarado
	 * @return Encomenda - tenta retornar uma encomenda expresa, caso não retornará <i>null</i>.
	 */
	public Encomenda criaEncomendaExpressa(String cepRemetente, String cepDestinatario, String dataEnvio, 
								   String atendente, String cidade, String estado, double peso, double valorDeclarado) {
		try {
			return new EncomendaExpressa(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso, valorDeclarado);
		} catch (Exception e) {
			return null;
		}
	}
	
	
		
	/**
	 * Salva as informações de encomenda em disco.
	 * @return boolean - Se a operação foi realizada com sucesso
	 */
	public boolean salvarEmDisco() {
		try {
			FileOutputStream arquivo = new FileOutputStream("encomendas_file.dat");
			ObjectOutputStream encomendas = new ObjectOutputStream(arquivo);

			encomendas.writeObject(listaDeEncomendas);
			arquivo.close();
			encomendas.close();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public Encomenda pesquisaId(String id) {
		for (Encomenda e: listaDeEncomendas) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}
	
	public void confirmaEncomenda(Encomenda e) {
		if (!e.equals(null)) {
			int ind = listaDeEncomendas.indexOf(e);
			e.entregouComSucesso();
			listaDeEncomendas.set(ind, e);
		}
	}
	
	public void falharEncomenda(Encomenda e) {
		if (!e.equals(null)) {
			int ind = listaDeEncomendas.indexOf(e);
			e.falhouNaEntrega();
			listaDeEncomendas.set(ind, e);
		}
	}
}
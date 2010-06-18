package correios.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Classe que implementa os atributos e comportamentos de uma agencia de Correios.
 * @author Vinícius Souza
 * @version 1.6
 */
public class Agencia {
	
	private String atendenteAtivo;
	private ArrayList<Encomenda> listaDeEncomendas;
	
	
	/**
	 * Construtor da classe. O usuário passado como parâmetro tem que estar ativo no momento.
	 * @param Atendente - atendente ativo no momento.
	 */
	public Agencia(String atendenteAtivo) {
		this.atendenteAtivo = atendenteAtivo;
		
		//LEITURA		
		try {
			FileInputStream fis = new FileInputStream("t.tmp");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			listaDeEncomendas = (ArrayList<Encomenda>) ois.readObject();
			ois.close();
		//caso algum erro ocorra uma nova lista de encomendas é criada
		} catch (Exception e) {
			listaDeEncomendas = new ArrayList<Encomenda>();
		}
		salvarEmDisco();
	}
	/**
	 * Retorna o atendente ativo no momento.
	 * @return Atendente - atendente ativo
	 */
	public String getAtendenteAtivo() {
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
	
	/**
	 * Método tilizado para o envio de encomendas.
	 * @param Encomenda - encomenda a ser enviada.
	 * @return boolean - se a operação realizada.
	 */
	public boolean addEncomenda(Encomenda encomenda) { 
		listaDeEncomendas.add(encomenda);
		if (salvarEmDisco()) {
			return true;
		}
		listaDeEncomendas.remove(encomenda);
		return false;
	}
	
	/**
	 * Tenta criar uma encomenda simples com os atributos passados como parâmetros.
	 * Caso a encomenda tenha que ser de outro tipo(Expressa) o método retornará uma encomenda expressa.
	 * Caso haja algum parâmetros seja inválido, retornará null.
	 * @param String - cepRemetente
	 * @param String - cepDestinatario
	 * @param String - dataEnvio
	 * @param String - atendente
	 * @param String - cidade
	 * @param String - estado
	 * @param double - peso
	 * @return Encomenda - se a encomendar puder ser criada, ela será retornada,
	 * caso não retornará <i>null</i>.
	 */
	public Encomenda criaEncomendaSimples(String cepRemetente, String cepDestinatario, String dataEnvio, 
								   String atendente, String cidade, String estado, double peso) {
		try {
			return new Encomenda(cepRemetente, cepDestinatario, dataEnvio, atendente, cidade, estado, peso);
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
	 * Tenta criar uma encomenda simples (com valor declarado) com os atributos passados como parâmetros.
	 * Caso a encomenda tenha que ser de outro tipo(Expressa) o método retornará uma encomenda expressa.
	 * Caso haja algum parâmetros seja inválido, retornará null.
	 * @param String - cepRemetente
	 * @param String - cepDestinatario
	 * @param String - dataEnvio
	 * @param String - atendente
	 * @param String - cidade
	 * @param String - estado
	 * @param double - peso
	 * @param double - valorDeclarado
	 * @return Encomenda - se a encomendar puder ser criada, ela será retornada,
	 * caso não retornará <i>null</i>.
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
	 * Caso a encomenda tenha que ser de outro tipo(Expressa) o método retornará uma encomenda expressa.
	 * Caso haja algum parâmetro seja inválido, retornará null.
	 * @param String - cepRemetente
	 * @param String - cepDestinatario
	 * @param String - dataEnvio
	 * @param String - atendente
	 * @param String - cidade
	 * @param String - estado
	 * @param double - peso
	 * @return Encomenda - se a encomendar puder ser criada, ela será retornada,
	 * caso não retornará <i>null</i>.
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
	 * @param String - cepRemetente
	 * @param String - cepDestinatario
	 * @param String - dataEnvio
	 * @param String - atendente
	 * @param String - cidade
	 * @param String - estado
	 * @param double - peso
	 * @param double - valorDeclarado
	 * @return Encomenda - se a encomendar puder ser criada, ela será retornada,
	 * caso não retornará <i>null</i>.
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
	 * @param String - cepRemetente
	 * @param String - cepDestinatario
	 * @param String - dataEnvio
	 * @param String - atendente
	 * @param String - cidade
	 * @param String - estado
	 * @param double - peso
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
	 * @param String - cepRemetente
	 * @param String - cepDestinatario
	 * @param String - dataEnvio
	 * @param String - atendente
	 * @param String - cidade
	 * @param String - estado
	 * @param double - peso
	 * @param double - valorDeclarado
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
			FileOutputStream arquivo = new FileOutputStream("t.tmp");
			ObjectOutputStream encomendas = new ObjectOutputStream(arquivo);

			encomendas.writeObject(listaDeEncomendas);
			encomendas.close();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
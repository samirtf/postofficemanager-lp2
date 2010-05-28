package funcionalidades;


public class Encomenda {
	String CEPremetente, CEPdestinatario, data, atendente;
	double peso, total_a_pagar = -1, valorDeclarado = 0, imposto = 0;
	int enviadas = 0;
	boolean viaExpressa = false, envioResistrado = false;
	
	public Encomenda(String CEPremetente, String CEPdestinatario, String data, double peso, String atendente) throws Exception{
		if((!correios.util.VerificaDados.verificaCep(CEPdestinatario)) || (!correios.util.VerificaDados.verificaCep(CEPdestinatario)) ||
		  (!correios.util.VerificaDados.verificaCep(CEPremetente)) || (!correios.util.VerificaDados.verificaCep(CEPremetente)) ||
		  peso <= 0 || (!correios.util.VerificaDados.verificaNome(atendente))){
			     throw new Exception();
		}
		this.CEPremetente = CEPremetente;
		this.CEPdestinatario = CEPdestinatario;
		this.data = data;
		this.peso = peso;
		this.atendente = atendente;	
	}
	
	public Encomenda(String CEPremetente, String CEPdestinatario, String data, double peso, String atendente, double valor_declarado) throws Exception{
		if((!correios.util.VerificaDados.verificaCep(CEPdestinatario)) || (!correios.util.VerificaDados.verificaCep(CEPdestinatario)) ||
		  (!correios.util.VerificaDados.verificaCep(CEPremetente)) || (!correios.util.VerificaDados.verificaCep(CEPremetente)) ||
		  peso <= 0 || (!correios.util.VerificaDados.verificaNome(atendente)) || valor_declarado < 0){
			     throw new Exception();
		}
		this.CEPremetente = CEPremetente;
		this.CEPdestinatario = CEPdestinatario;
		this.data = data;
		this.peso = peso;
		this.atendente = atendente;	
		this.valorDeclarado = valor_declarado;
	}

	public String getCEPremetente() {
		return CEPremetente;
	}
	
	public String getCEPdestinatario() {
		return CEPdestinatario;
	}

	public double getPeso() {
		return peso;
	}
	
	public boolean getViaExpressa(){
		return viaExpressa;
	}
	
	public String getAtendente(){
		return atendente;
	}
	
	public void ConfirmaViaExpressa(){
		this.viaExpressa = true;
	}
	
	public void ConfirmaEnvioResistrado(){
		this.envioResistrado = true;
	}
	
	public double getValorDeclarado() {
		return valorDeclarado;
	}
	
	
	public double ValorDaEncomenda(){
		int peso_grama = (int) (peso*100); //Descobre o peso em gramas, 0.005kg (eh considerado 0, pois devera ser a cada 10 gramas)!
		
		double totalAPagar = 0;
		
		if (envioResistrado){
			totalAPagar += peso_grama*0.2 + 1.4;
		}
				
		if (valorDeclarado > 500){
			imposto = (getValorDeclarado() + total_a_pagar)*0.05;	
			totalAPagar += peso_grama*1.5 + 10 + imposto;
			this.viaExpressa = true;
		} else {
			totalAPagar += getValorDeclarado()*0.01;
		}
		
		if (viaExpressa && valorDeclarado <= 500){
			totalAPagar += peso_grama*1.5 + 10;
		}
		
		if (!(envioResistrado && valorDeclarado != 0 && viaExpressa)){
			totalAPagar += peso_grama*0.2 + 0.75;
		}
		
		return totalAPagar;
	}
	
	//Retorna a quantidade de envios (da encomenda), e para em 4 (significando que 4 = remetente)
	public int getEnviadas(){
		if (enviadas <= 3){
			return enviadas;
		}
		return 4;
	}
	
	
	public String enviaCarta(){
		this.enviadas += 1;
		if (enviadas <= 3){
			return "A encomenda foi enviada ao detinatario " + getEnviadas() + " vez(es).";
		}
		else if (enviadas == 4){
			return "A encomenda foi entrege ao remetente, pois aconteceu mais de 3 tentaivas";
		}
		return "A carta jah foi enviada ao remetente!";
	}
	
}

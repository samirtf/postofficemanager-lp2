package funcionalidades;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * Objetos dessa classe implementam os estados e comportamentos de encomenda
 * @author Vinícius Souza & Werton Guimarães
 * @version 1.7
 */
public class Encomenda {
    String cepRemetente, cepDestinatario, data, atendente;
    double peso, valorTotalEncomenda = -1, valorDeclarado = 0, imposto = 0;
    int enviadas = 0;
    boolean viaExpressa = false, envioRegistrado = false;
    private String id;

    /**
     * Construtor que não recebe valor declarado.
     */
    public Encomenda(String CEPremetente, String CEPdestinatario, String data, double peso, String atendente) throws Exception{
        if((!correios.util.VerificaDados.verificaCep(CEPdestinatario)) || (!correios.util.VerificaDados.verificaCep(CEPdestinatario)) ||
          (!correios.util.VerificaDados.verificaCep(CEPremetente)) || (!correios.util.VerificaDados.verificaCep(CEPremetente)) ||
          peso <= 0 || (!correios.util.VerificaDados.verificaNome(atendente))){
                 throw new Exception();
        }
        this.cepRemetente = CEPremetente;
        this.cepDestinatario = CEPdestinatario;
        this.data = data;
        this.peso = peso;
        if (peso > 2){
            viaExpressa = true;
        }
        this.atendente = atendente;
        id = new SimpleDateFormat("ddMMyyHHmmss").format((new GregorianCalendar()).getTime());
        Thread.sleep(1000);
    }

    /**
     * Construtor que recebe valor declarado.
     */
    public Encomenda(String CEPremetente, String CEPdestinatario, String data, double peso, String atendente, double valor_declarado) throws Exception{
        if((!correios.util.VerificaDados.verificaCep(CEPdestinatario)) || (!correios.util.VerificaDados.verificaCep(CEPdestinatario)) ||
          (!correios.util.VerificaDados.verificaCep(CEPremetente)) || (!correios.util.VerificaDados.verificaCep(CEPremetente)) ||
          peso <= 0 || (!correios.util.VerificaDados.verificaNome(atendente)) || valor_declarado < 0){
                 throw new Exception();
        }
        this.cepRemetente = CEPremetente;
        this.cepDestinatario = CEPdestinatario;
        this.data = data;
        this.peso = peso;
        this.atendente = atendente;
        if (peso > 2 || valor_declarado >= 500){
            viaExpressa = true;
        }
        this.valorDeclarado = valor_declarado;
        id = new SimpleDateFormat("ddMMyyHHmmss").format((new GregorianCalendar()).getTime());
        Thread.sleep(1000);

    }

    //ACCESOR METHODS
    public String getCEPremetente() {
        return cepRemetente;
    }

    public String getCEPdestinatario() {
        return cepDestinatario;
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

    public void confirmaViaExpressa(){
        viaExpressa = true;
    }

    public void confirmaEnvioResistrado(){
        envioRegistrado = true;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public String getData() {
        return data;
    }

    /**
     * Método que calculo o valor ou custo total da encomenda.
     * @return double valor
     */
    public double valorDaEncomenda(){
        int peso_grama = (int) (peso*100); //Descobre o peso em gramas, 0.005kg (eh considerado 0, pois devera ser a cada 10 gramas)!

        double totalAPagar = 0;

        if (envioRegistrado){
            totalAPagar += peso_grama*0.2 + 1.4;
        }

        if (valorDeclarado > 500){
            imposto = (getValorDeclarado() + valorTotalEncomenda)*0.05;
            totalAPagar += peso_grama*1.5 + 10 + imposto;
            this.viaExpressa = true;
        } else {
            totalAPagar += getValorDeclarado()*0.01;
        }

        if (viaExpressa && valorDeclarado <= 500){
            totalAPagar += peso_grama*1.5 + 10;
        }

        if (!(envioRegistrado && valorDeclarado != 0 && viaExpressa)){
            totalAPagar += peso_grama*0.2 + 0.75;
        }

        return totalAPagar;
    }

    /**
     * Retorna a quantidade de envios (da encomenda), e para em 4 (significando que 4 = remetente)
     * @return int vezes
     */
    public int getEnviadas() {
        if (enviadas <= 3){
          return enviadas;
        }
        return 4;
    }
    
    /**
     * Envia a encomenda.
     */
    public String enviaCarta(){
        enviadas += 1;
        if (enviadas <= 3){
            return "A encomenda foi enviada ao destinatario " + getEnviadas() + " vez(es).";
        }
        return "A carta foi enviada ao remetente";
    }
    
    /**
     * Retorna o id único de cada carta
     * @return String -id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Método que retorna o código de registro de uma encomenda.<br>
     * apenas envios registrados utilizam o método.
     */
    public String registroCode() {
    	if (envioRegistrado) {
    		return "PB" + getId().substring(3,12) + "BR";
    	}
    	return "";
    	
    }
}
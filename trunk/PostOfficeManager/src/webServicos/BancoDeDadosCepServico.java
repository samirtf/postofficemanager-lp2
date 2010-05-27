package webServicos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Samir Trajano Feitosa 20921299
 *
 */
public class BancoDeDadosCepServico implements BancoDeDadosCepServicoIF{

    private Map< String, Cep> mapa;
    private Map< String, Cep> mapaTemp;

    public BancoDeDadosCepServico() throws Exception{
        mapa = new HashMap<String, Cep>();
        mapaTemp = new HashMap<String, Cep>();

        try {
            File arquivoBd = new File("bdcep.dat");
            if ( !( arquivoBd.exists() && arquivoBd.isFile() && arquivoBd.canRead() ) ){
                throw new FileNotFoundException("Arquivo bdcep.dat não encontrado.");
            }
            FileReader arquivo = new FileReader("bdcep.dat");

            BufferedReader leitura = new BufferedReader(arquivo);
            String dado;
            while (leitura.ready()) {
                dado = leitura.readLine();
                String[] arrayDados = dado.split("\\|");
                //cep, logradouro, bairro, cidade, uf, chave
                Cep infoCep = new Cep(arrayDados[0], arrayDados[1], arrayDados[2],
                        arrayDados[3], arrayDados[4], arrayDados[5]);

                //adicionando dado no mapa
                mapa.put(arrayDados[0], infoCep);

            }
            leitura.close();
        }
        catch (IOException e) {
        }
    }

    public boolean adicCepAoBancoDeDados(Cep CEP) {
        if ( (mapa == null && ( mapaTemp == null || !mapaTemp.containsKey(CEP.cep))) ||
            (!mapa.containsKey(CEP.cep) && (mapaTemp == null || !mapaTemp.containsKey(CEP.cep))) ){
            mapaTemp.put(CEP.cep, CEP);
            return true;
        }
        return false;
    }

    public boolean delCepDoBancoDeDados(Cep CEP) {
        boolean chave = false;

        if ( mapa != null && mapa.containsKey(CEP.cep)){
            mapa.remove(CEP.cep);
            chave = true;
        }
        if ( mapaTemp != null && mapaTemp.containsKey(CEP.cep)){
            mapaTemp.remove(CEP.cep);
            chave = true;
        }
        return chave;
    }

    public int totalRegistrosBancoDeDados() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean pesquisaCepNoBancoDeDadosLocal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean testaConexaoInternet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean pequisaCepBancoDeDadosOnline() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}


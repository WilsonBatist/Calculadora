package ApiDados;
import androidx.annotation.ArrayRes;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class ConversorMoedas {
    private String cotacaoDollar;
    private String cotaçaoEuro;
    
    private  String conversorMoeda (BufferedReader buferedReader,String codigo) throws IOException {
        JSONObject respostaServidor = null;
        String resposta = "", jsonEmString = "";
        /*while ((resposta = buferedReader.readLine()) != null) {
            jsonEmString += resposta;
        }*/
        if ((resposta = buferedReader.readLine()) != null){
            try {
                respostaServidor = new JSONObject(resposta);
                String cotacao = respostaServidor.getJSONObject(codigo).getString("bid");
                return  cotacao;
            } catch (JSONException e) {
                System.out.println("Erro no JASON");
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getMoedaDolar(){
        String Weburl = "https://economia.awesomeapi.com.br/json/last/USD-BRL";
        try {
            URL url = new URL (Weburl);
            HttpURLConnection conexao = (HttpsURLConnection) url.openConnection();

            BufferedReader resposta = new BufferedReader( new InputStreamReader(conexao.getInputStream()));
             //retorno da api

            this.cotacaoDollar = conversorMoeda(resposta,"USDBRL") ;

            return this.cotacaoDollar;

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro" + e.toString();
        }
    }


    public String getMoedaEuro() {
        String Weburl = "https://economia.awesomeapi.com.br/last/EUR-BRL";
        try {
            URL url = new URL(Weburl);
            HttpURLConnection conexao = (HttpsURLConnection) url.openConnection();

            BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            //retorno da api

            this.cotacaoDollar = conversorMoeda(resposta,"EURBRL");

            return this.cotacaoDollar;

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro" + e.toString();
        }
    }
}

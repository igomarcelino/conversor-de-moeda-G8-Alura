import Conexao.RequisicaoHTTP;
import Config.ConfiguracaoAPI;
import Modelo.ExchangeRateResponse;
import Parser.DezserializeGson;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       String url =  ConfiguracaoAPI.configuraRequisicao("37944748ebd54fc6b57cf7f3");
       String jsonBody;
       try
       {
           jsonBody = RequisicaoHTTP.requestURl(url);
       }catch (IOException | InterruptedException e){
           throw new RuntimeException("Falha na requisicao: verificar chave digitada: " + e.getMessage());
       }
       ExchangeRateResponse exchangeRateResponse =  DezserializeGson.parser(jsonBody);
        System.out.println(exchangeRateResponse);
    }
}
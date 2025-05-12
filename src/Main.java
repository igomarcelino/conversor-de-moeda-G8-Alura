import Conexao.RequisicaoHTTP;
import Config.ConfiguracaoAPI;
import Enums.IOF;
import Calculo.ConversoesDeValores;
import Modelo.ExchangeRateResponse;
import Parser.DezserializeGson;
import Visualizacao.Menu;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       /*String url =  ConfiguracaoAPI.configuraRequisicao("37944748ebd54fc6b57cf7f3");
       String jsonBody;
       try
       {
           jsonBody = RequisicaoHTTP.requestURl(url);
       }catch (IOException | InterruptedException e){
           throw new RuntimeException("Falha na requisicao: verificar chave digitada: " + e.getMessage());
       }
       ExchangeRateResponse exchangeRateResponse =  DezserializeGson.parser(jsonBody);
        ConversoesDeValores conversoesDeValores = new ConversoesDeValores(exchangeRateResponse);
        double realDollar = conversoesDeValores.cambioComIOF("USD","BRL",100, IOF.CARTAO);
        conversoesDeValores.cotacoes();
        System.out.printf("Conversao de real para dollar: %s", df.format(realDollar));*/
        Menu menu = new Menu();
        menu.menuDeCotacoes();
    }
}
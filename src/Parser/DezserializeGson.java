package Parser;

import Modelo.ExchangeRateResponse;
import com.google.gson.Gson;

/**
 * Classe utilitária responsável por desserializar uma string JSON
 * em uma instância da classe {@link ExchangeRateResponse}, utilizando a biblioteca Gson.
 */
public class DezserializeGson {

    /**
     * Converte (desserializa) uma string JSON em um objeto {@link ExchangeRateResponse}.
     *
     * @param jsonBody A string JSON retornada pela API.
     * @return Um objeto {@link ExchangeRateResponse} com os dados do JSON.
     */
    public static ExchangeRateResponse parser(String jsonBody){
        Gson gson = new Gson();
        return gson.fromJson(jsonBody, ExchangeRateResponse.class);
    }
}

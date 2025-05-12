package Parser;

import Modelo.ExchangeRateResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe utilitária responsável por desserializar uma string JSON
 * em uma instância da classe {@link ExchangeRateResponse}, utilizando a biblioteca Gson.
 *
 * <p>Esta classe registra um {@link com.google.gson.JsonDeserializer} customizado
 * ({@link ExchangeRateResponseDeserializer}) para tratar a conversão do JSON manualmente,
 * sem depender de anotações {@code @SerializedName} na classe modelo.</p>
 *
 * <p>Exemplo de uso:
 * <pre>{@code
 * String json = ... // resposta da API
 * ExchangeRateResponse resposta = DezserializeGson.parser(json);
 * }</pre>
 * </p>
 *
 * @author Igo Marcelino
 */
public class DezserializeGson {

    /**
     * Converte (desserializa) uma string JSON em um objeto {@link ExchangeRateResponse}
     * utilizando um {@link Gson} configurado com o adaptador personalizado.
     *
     * @param jsonBody A string JSON retornada pela API de taxas de câmbio.
     * @return Um objeto {@link ExchangeRateResponse} preenchido com os dados do JSON.
     */
    public static ExchangeRateResponse parser(String jsonBody) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ExchangeRateResponse.class, new ExchangeRateResponseDeserializer())
                .create();

        return gson.fromJson(jsonBody, ExchangeRateResponse.class);
    }
}

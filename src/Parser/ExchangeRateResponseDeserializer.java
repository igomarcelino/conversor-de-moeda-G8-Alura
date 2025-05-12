package Parser;

import Modelo.ExchangeRateResponse;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Classe responsável por desserializar um objeto JSON no formato da API ExchangeRate-API
 * para uma instância da classe {@link ExchangeRateResponse}, sem a necessidade de usar
 * anotações {@code @SerializedName} na classe modelo.
 *
 * <p>Este desserializador utiliza a interface {@link JsonDeserializer} da biblioteca Gson.
 * Ele trata a presença ou ausência de campos no JSON e realiza o mapeamento manual dos atributos.
 * Além disso, converte o objeto {@code "conversion_rates"} em um {@code Map<String, Double>}.</p>
 *
 * <p></> A vantagem na utilização desta classe é que, se houver mudanças nas chaves da API,
 * basta alterar os object.get() correspondentes, sem a necessidade de modificar o corpo da classe ExchangeRateResponse. </p>
 *
 * @author Igo Marcelino
 */
public class ExchangeRateResponseDeserializer implements JsonDeserializer<ExchangeRateResponse> {

    /**
     * Desserializa um {@link JsonElement} em um objeto {@link ExchangeRateResponse}.
     *
     * @param jsonElement               o elemento JSON contendo os dados da API
     * @param type                      o tipo do objeto esperado (ExchangeRateResponse)
     * @param jsonDeserializationContext o contexto de desserialização usado para converter campos complexos
     * @return uma instância populada de {@link ExchangeRateResponse}
     * @throws JsonParseException se ocorrer erro na estrutura ou formato do JSON
     */
    @Override
    public ExchangeRateResponse deserialize(JsonElement jsonElement, Type type,
                                            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject object = jsonElement.getAsJsonObject();

        ExchangeRateResponse response = new ExchangeRateResponse();


        response.setResult(object.has("result") ? object.get("result").getAsString() : null);


        response.setTimeUltimaAtualizacao(object.has("time_last_update_unix")
                ? object.get("time_last_update_unix").getAsLong()
                : null);


        response.setMoedaBase(object.has("base_code") ? object.get("base_code").getAsString() : null);


        JsonObject conversoes = object.getAsJsonObject("conversion_rates");
        if (!conversoes.isJsonNull()) {
            Map<String, Double> conversoesMap = jsonDeserializationContext.deserialize(conversoes, Map.class);
            response.setConversoes(conversoesMap);
        } else {
            response.setConversoes(null);
        }

        return response;
    }
}

package Config;

/**
 * @author Igo Marcelino
 * @
 * */
public class ConfiguracaoAPI {
    public static String configuraRequisicao(String apiKey){
        String requestURL = String.format("https://v6.exchangerate-api.com/v6/%s/latest/BRL",apiKey);

        return requestURL;
    }
}

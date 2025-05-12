package Config;

/**
 * Classe responsável por configurar a URL de requisição para a API ExchangeRate.
 * Utiliza a chave da API fornecida para montar a URL que obtém as taxas de câmbio
 * mais recentes com base na moeda BRL (Real Brasileiro).
 *
 * Exemplo de uso da API:
 * https://v6.exchangerate-api.com/v6/SUA_API_KEY/latest/BRL
 *
 * <p><strong>Exemplo de uso em código:</strong></p>
 * <pre>{@code
 *     String minhaApiKey = "sua_chave_api_aqui";
 *     String url = ConfiguracaoAPI.configuraRequisicao(minhaApiKey);
 *     System.out.println("URL gerada: " + url);
 * }</pre>
 *
 * @author Igo Marcelino
 */
public class ConfiguracaoAPI {

    /**
     * Gera a URL de requisicao para obter as taxas de cambio atualizadas
     *
     * @param apiKey A chave de autenticacao da API
     * @return retorna a url ja formatada com a chave da api  e a moeda de base para busca BRL
     * */
    public static String configuraRequisicao(String apiKey){
        String requestURL = String.format("https://v6.exchangerate-api.com/v6/%s/latest/BRL",apiKey);

        return requestURL;
    }
}

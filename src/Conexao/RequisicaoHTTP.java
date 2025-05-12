package Conexao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 * Classe responsável por realizar uma requisição HTTP GET de forma síncrona
 * e retornar a resposta da API como uma String.
 *
 * <p>Utiliza a API {@code java.net.http} introduzida no Java 11.</p>
 *
 * <p><strong>Exemplo de uso:</strong></p>
 * <pre>{@code
 *     String url = ConfiguracaoAPI.configuraRequisicao("sua_api_key");
 *     try {
 *         String resposta = RequisicaoHTTP.requestURl(url);
 *         System.out.println("Resposta da API: " + resposta);
 *     } catch (IOException | InterruptedException e) {
 *         e.printStackTrace();
 *     }
 * }</pre>
 *
 * @author Igo Marcelino
 */
public class RequisicaoHTTP {

    /**
     * Realiza uma requisição HTTP GET de forma síncrona para a URL fornecida.
     *
     * @param url A URL para onde a requisição será enviada.
     * @return O conteúdo (body) da resposta HTTP como uma String.
     * @throws IOException Se ocorrer um erro de I/O ao enviar a requisição.
     * @throws InterruptedException Se a operação for interrompida durante a execução.
     */
    public static String requestURl(String url)  {
        HttpResponse<String> response;
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().
                    uri(URI.create(url)).
                    build();

           response  = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            throw new RuntimeException("Chave invalida");
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        return response.body();
    }
}

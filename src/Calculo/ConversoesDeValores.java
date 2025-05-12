package Calculo;

import Enums.IOF;
import Modelo.ExchangeRateResponse;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * Classe responsável por realizar cálculos de conversão de valores entre moedas
 * com ou sem a aplicação de taxas, como o IOF.
 * Utiliza os dados de câmbio obtidos a partir de um objeto {@link ExchangeRateResponse}.
 *
 * @author Igo Marcelino
 */
public class ConversoesDeValores {

    private ExchangeRateResponse exchangeRateResponse;

    /**
     * Construtor da classe que recebe um objeto com os dados de câmbio.
     *
     * @param exchangeRateResponse objeto contendo as taxas de conversão entre moedas.
     */
    public ConversoesDeValores(ExchangeRateResponse exchangeRateResponse){
        this.exchangeRateResponse = exchangeRateResponse;
    }

    /**
     * Realiza a conversão de valores entre duas moedas, aplicando a taxa de IOF de acordo com
     * a forma de pagamento especificada.
     *
     * @param moedaBase        Código da moeda que se possui (ex: "BRL").
     * @param moedaParaCambio  Código da moeda desejada (ex: "USD").
     * @param quantidade       Quantidade da moeda base a ser convertida.
     * @param fPagamento       Enum {@link IOF} que define a taxa a ser aplicada (DINHEIRO ou CARTAO).
     * @return Valor convertido com aplicação do IOF.
     */
    public Double cambioComIOF(String moedaBase, String moedaParaCambio, double quantidade, IOF fPagamento){
        Map<String, Double> cotacoes = exchangeRateResponse.getConversoes();
        double moedaEmPosse = cotacoes.get(moedaBase);
        double moedaPretendida = cotacoes.get(moedaParaCambio);

        double valorAPagar = (quantidade / moedaEmPosse) * moedaPretendida;
        return valorAPagar *= fPagamento.getTaxa();
    }

    /**
     * Exibe no console as cotações atuais de três moedas: Dólar, Euro e Peso Argentino.
     * A cotação é calculada como a inversa do valor retornado pela API (moeda base em relação à moeda destino).
     * Aplica formatação com 4 casas decimais.
     */
    public void cotacoes(){
        try {
            System.out.print("Obtendo cotações para Peso Argentino, Euro e Dólar, aguarde.");
            for(int i = 0; i < 11 ; i++){
                System.out.print(".");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        Map<String, Double> cotacoesMoedas = exchangeRateResponse.getConversoes();
        Map<String, String> nomesMoedas = Map.of(
                "USD", "Dólar",
                "EUR", "Euro",
                "ARS", "Peso Argentino"
        );

        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println("Valores sem IOF");
        for (Map.Entry<String, String> entry : nomesMoedas.entrySet()) {
            String codigo = entry.getKey();
            String nome = entry.getValue();

            if (cotacoesMoedas.containsKey(codigo)) {
                double valorMoeda = 1 / cotacoesMoedas.get(codigo);
                System.out.println(nome + ": " + df.format(valorMoeda));
            } else {
                System.out.println(nome + ": cotação não encontrada");
            }
        }
    }

    /**
     * Retorna o objeto {@link ExchangeRateResponse} utilizado nas conversões.
     *
     * @return objeto com as taxas de câmbio atuais.
     */
    public ExchangeRateResponse getExchangeRateResponse() {
        return exchangeRateResponse;
    }

    /**
     * Define um novo objeto {@link ExchangeRateResponse} para ser utilizado nas conversões.
     *
     * @param exchangeRateResponse objeto contendo as novas taxas de câmbio.
     */
    public void setExchangeRateResponse(ExchangeRateResponse exchangeRateResponse) {
        this.exchangeRateResponse = exchangeRateResponse;
    }
}

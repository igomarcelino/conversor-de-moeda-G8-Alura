package Modelo;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.Map;

/**
 * Representa a resposta da API ExchangeRate-API contendo informações sobre taxas de câmbio.
 * <p>
 * Esta classe é usada para deserializar a resposta JSON da API utilizando a biblioteca Gson.
 * Ela inclui o código da moeda base, as taxas de conversão para outras moedas,
 * e informações sobre a última atualização dos dados.
 */

public class ExchangeRateResponse {

    /** Resultado da solicitação à API (por exemplo, "success"). */
    @SerializedName("result")
    private String result;

    @SerializedName("time_last_update_unix")
    private long timeUltimaAtualizacao;


    private String dataUltimaAtualizacao;


    @SerializedName("base_code")
    private String moedaBase;


    @SerializedName("conversion_rates")
    private Map<String, Double> conversoes;


    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }


    public long getTimeUltimaAtualizacao() {
        return timeUltimaAtualizacao;
    }


    public void setTimeUltimaAtualizacao(long timeUltimaAtualizacao) {
        this.timeUltimaAtualizacao = timeUltimaAtualizacao;
    }

    /**
     * Retorna a data da última atualização formatada no padrão brasileiro.
     * Exemplo: "12 de maio de 2025".
     *
     * @return string representando a data formatada.
     */
    public String getDataUltimaAtualizacao() {
        LocalDate dataAtual = Instant.ofEpochSecond(this.timeUltimaAtualizacao)
                .atZone(ZoneId.of("America/Sao_Paulo"))
                .toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
        return dataAtual.format(formatter);
    }


    public String getMoedaBase() {
        return moedaBase;
    }


    public void setMoedaBase(String moedaBase) {
        this.moedaBase = moedaBase;
    }

    /**
     * Retorna o mapa de conversões, onde a chave é o código da moeda e o valor é a taxa.
     *
     * @return mapa de conversões monetárias.
     */
    public Map<String, Double> getConversoes() {
        return conversoes;
    }


    public void setConversoes(Map<String, Double> conversoes) {
        this.conversoes = conversoes;
    }


    @Override
    public String toString() {
        return "ExchangeRateResponse{" +
                "\nresult='" + result + '\'' +
                ", \ntimeLastUpdateUtc='" + getDataUltimaAtualizacao() + '\'' +
                ", \nbaseCode='" + moedaBase + '\'' +
                ", \nconversionRates=" + conversoes +
                '}';
    }
}

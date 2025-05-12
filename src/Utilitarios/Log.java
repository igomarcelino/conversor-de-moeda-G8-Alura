package Utilitarios;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe responsável por registrar logs de conversões de moeda em um arquivo de texto.
 * <p>
 * O log contém informações como: data e hora da conversão, moeda de origem e destino,
 * quantidade convertida, valor obtido e a forma de pagamento utilizada.
 * </p>
 *
 * @author Igo Marcelino
 */
public class Log {

    /**
     * Caminho do arquivo onde os logs serão gravados.
     */
    private static final String LOG_FILE = "conversoes.log";

    /**
     * Registra um log de conversão de moeda em um arquivo.
     *
     * @param origem          A moeda de origem (ex: "BRL").
     * @param destino         A moeda de destino (ex: "USD").
     * @param quantidade      A quantidade de moeda a ser convertida.
     * @param valorConvertido O valor obtido após a conversão com IOF aplicado.
     * @param formaPagamento  A forma de pagamento utilizada na conversão (ex: "CARTAO", "DINHEIRO").
     */
    public static void registrarLog(String origem, String destino, double quantidade, double valorConvertido, String formaPagamento) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) { // true = append
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);

            String log = String.format("[%s] Conversão de %s para %s | Quantidade: %.2f | Resultado: %.2f | Forma: %s\n",
                    timestamp, origem, destino, quantidade, valorConvertido, formaPagamento);

            writer.write(log);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no log: " + e.getMessage());
        }
    }
}

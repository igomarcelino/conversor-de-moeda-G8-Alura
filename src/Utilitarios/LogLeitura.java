package Utilitarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe simples para ler e exibir linhas de log do arquivo conversoes.log.
 * Cada linha representa uma conversão de moeda registrada no sistema.
 *
 * Formato esperado:
 * [data hora] Conversão de origem para destino | Quantidade: valor | Resultado: valor | Forma: tipo
 *
 * Autor: Igo Marcelino
 */
public class LogLeitura {

    private static final String LOG_FILE = "conversoes.log";


    public static void lerLog() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de log: " + e.getMessage());
        }
    }

}

package Visualizacao;

import Calculo.ConversoesDeValores;
import Conexao.RequisicaoHTTP;
import Config.ConfiguracaoAPI;
import Enums.IOF;
import Modelo.ExchangeRateResponse;
import Utilitarios.Log;
import Utilitarios.LogLeitura;
import Parser.DezserializeGson;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void menuDeCotacoes() {

        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        ExchangeRateResponse exchangeRateResponse = getResponse();
        do {
            try {
                System.out.println("[ 1 ] Cotacoes de moedas e Simulador de cambio");
                System.out.println("[ 2 ] Logs");
                System.out.println("[ 3 ] Sair");
                System.out.print("Digite a opcao: ");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        if (exchangeRateResponse.getResult().equalsIgnoreCase("success")) {
                            int opcaoSubmenu = 0;
                            double quantidade = 0;

                            ConversoesDeValores conversoesDeValores = new ConversoesDeValores(exchangeRateResponse);
                            conversoesDeValores.cotacoes();

                            do {
                                try {
                                    double formaPagamento = 0;
                                    double mooedaConversao = 0;
                                    System.out.println("---------- Conververter Valores ----------");
                                    System.out.println("[ 1 ] Real => Dolar");
                                    System.out.println("[ 2 ] Real => Euro");
                                    System.out.println("[ 3 ] Real => Peso Argentino");
                                    System.out.println("[ 4 ] Dolar => Real");
                                    System.out.println("[ 5 ] Euro => Real");
                                    System.out.println("[ 6 ] Peso Argentino => Real");
                                    System.out.println("[ 7 ] Dolar => Euro");
                                    System.out.println("[ 8 ] Euro => Dolar");
                                    System.out.println("[ 9 ] Sair");
                                    System.out.print("Digite a opcao: ");
                                    opcaoSubmenu = scanner.nextInt();
                                    switch (opcaoSubmenu) {
                                        case 1:
                                            System.out.println("Real => Dolar");
                                            System.out.print("Informe a quantidade: ");
                                            quantidade = scanner.nextDouble();
                                            selecionaFPagamento();
                                            formaPagamento = scanner.nextDouble();
                                            if (formaPagamento == 1) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("BRL", "USD", quantidade, IOF.DINHEIRO);
                                            }
                                            if (formaPagamento == 2) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("BRL", "USD", quantidade, IOF.CARTAO);
                                            }
                                            System.out.printf("\nConversao de Real para Dollar: %s", mooedaConversao + "\n");
                                            System.out.println(" ");
                                            System.out.println("--------------------------------------------------");
                                            gravaLog("Real","Dolar",formaPagamento, quantidade, mooedaConversao);
                                            break;
                                        case 2:
                                            System.out.println("Real => Euro");
                                            System.out.print("Informe a quantidade: ");
                                            quantidade = scanner.nextDouble();
                                            selecionaFPagamento();
                                            formaPagamento = scanner.nextDouble();
                                            if (formaPagamento == 1) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("BRL", "EUR", quantidade, IOF.DINHEIRO);
                                            }
                                            if (formaPagamento == 2) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("BRL", "EUR", quantidade, IOF.CARTAO);
                                            }
                                            System.out.printf("\nConversao de Real para Euro: %s", mooedaConversao + "\n");
                                            System.out.println(" ");
                                            System.out.println("--------------------------------------------------");
                                            gravaLog("Real","Euro",formaPagamento, quantidade, mooedaConversao);
                                            break;
                                        case 3:
                                            System.out.println("Real => Peso Argentino");
                                            System.out.print("Informe a quantidade: ");
                                            quantidade = scanner.nextDouble();
                                            selecionaFPagamento();
                                            formaPagamento = scanner.nextDouble();
                                            if (formaPagamento == 1) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("BRL", "ARS", quantidade, IOF.DINHEIRO);
                                            }
                                            if (formaPagamento == 2) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("BRL", "ARS", quantidade, IOF.CARTAO);
                                            }
                                            System.out.printf("\nConversao de Real para Peso Argentino: %s", mooedaConversao + "\n");
                                            System.out.println(" ");
                                            System.out.println("--------------------------------------------------");
                                            gravaLog("Real","Peso Argentino",formaPagamento, quantidade, mooedaConversao);
                                            break;
                                        case 4:
                                            System.out.println("Dolar => Real");
                                            System.out.print("Informe a quantidade: ");
                                            quantidade = scanner.nextDouble();
                                            selecionaFPagamento();
                                            formaPagamento = scanner.nextDouble();
                                            if (formaPagamento == 1) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("USD", "BRL", quantidade, IOF.DINHEIRO);
                                            }
                                            if (formaPagamento == 2) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("USD", "BRL", quantidade, IOF.CARTAO);
                                            }
                                            System.out.printf("\nConversao de Dolar para Real: %s", mooedaConversao + "\n");
                                            System.out.println(" ");
                                            System.out.println("--------------------------------------------------");
                                            gravaLog("Dolar","Real",formaPagamento, quantidade, mooedaConversao);
                                            break;
                                        case 5:
                                            System.out.println("Euro => Real");
                                            System.out.print("Informe a quantidade: ");
                                            quantidade = scanner.nextDouble();
                                            selecionaFPagamento();
                                            formaPagamento = scanner.nextDouble();
                                            if (formaPagamento == 1) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("EUR", "BRL", quantidade, IOF.DINHEIRO);
                                            }
                                            if (formaPagamento == 2) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("EUR", "BRL", quantidade, IOF.CARTAO);
                                            }
                                            System.out.printf("\nConversao de Euro para Real: %s", mooedaConversao + "\n");
                                            System.out.println(" ");
                                            System.out.println("--------------------------------------------------");
                                            gravaLog("Euro","Real",formaPagamento, quantidade, mooedaConversao);
                                            break;
                                        case 6:
                                            System.out.println("Peso Argentino => Real");
                                            System.out.print("Informe a quantidade: ");
                                            quantidade = scanner.nextDouble();
                                            selecionaFPagamento();
                                            formaPagamento = scanner.nextDouble();
                                            if (formaPagamento == 1) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("ARS", "BRL", quantidade, IOF.DINHEIRO);
                                            }
                                            if (formaPagamento == 2) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("ARS", "BRL", quantidade, IOF.CARTAO);
                                            }
                                            System.out.printf("\nConversao de Peso Argentino para Real: %s", mooedaConversao + "\n");
                                            System.out.println(" ");
                                            System.out.println("--------------------------------------------------");
                                            gravaLog("Peso Argentino","Real",formaPagamento, quantidade, mooedaConversao);
                                            break;
                                        case 7:
                                            System.out.println("Dolar => Euro");
                                            System.out.print("Informe a quantidade: ");
                                            quantidade = scanner.nextDouble();
                                            selecionaFPagamento();
                                            formaPagamento = scanner.nextDouble();
                                            if (formaPagamento == 1) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("USD", "EUR", quantidade, IOF.DINHEIRO);
                                            }
                                            if (formaPagamento == 2) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("USD", "EUR", quantidade, IOF.CARTAO);
                                            }
                                            System.out.printf("\nConversao de Dolar para Euro: %s", mooedaConversao + "\n");
                                            System.out.println(" ");
                                            System.out.println("--------------------------------------------------");
                                            gravaLog("Dolar","Euro",formaPagamento, quantidade, mooedaConversao);
                                            break;
                                        case 8:
                                            System.out.println("Euro => Dolar");
                                            System.out.print("Informe a quantidade: ");
                                            quantidade = scanner.nextDouble();
                                            selecionaFPagamento();
                                            formaPagamento = scanner.nextDouble();
                                            if (formaPagamento == 1) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("EUR", "USD", quantidade, IOF.DINHEIRO);
                                            }
                                            if (formaPagamento == 2) {
                                                mooedaConversao = conversoesDeValores.cambioComIOF("EUR", "USD", quantidade, IOF.CARTAO);
                                            }
                                            System.out.printf("\nConversao de Euro para Dolar: %s", mooedaConversao + "\n");
                                            System.out.println(" ");
                                            System.out.println("--------------------------------------------------");
                                            gravaLog("Euro","Dolar",formaPagamento, quantidade, mooedaConversao);
                                            break;
                                        case 9:
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Opcao invalida!");
                                    scanner.nextLine();
                                }
                            } while (opcaoSubmenu != 9);

                        }
                        break;
                    case 2:
                        LogLeitura.lerLog();
                        break;
                    case 3:
                        System.out.println("Saindo da aplicacao");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opcao invalida");
                scanner.nextLine();
            }

        }
        while (opcao != 3);


    }

    private static void gravaLog(String moedaOrigem, String moedaDestino, double formaPagamento, double quantidade, double mooedaConversao) {
        String formaPagamentoEscolhida = formaPagamento == 1 ? "Dinheiro" : "Cartao";
        Log.registrarLog(moedaOrigem,moedaDestino, quantidade, mooedaConversao,formaPagamentoEscolhida);
    }

    private static void selecionaFPagamento() {
        System.out.print("Informe a forma de pagamento: ");
        System.out.println("Selecione a forma de pagamento");
        System.out.println("Cartao taxa de 3,38 %");
        System.out.println("Dinheiro taxa de 1,10%");
        System.out.println("\n[ 1 ] Dinheiro");
        System.out.println("[ 2 ] Cartao");
        System.out.println("\nInforme a forma de pagamento: ");
    }

    private static ExchangeRateResponse getResponse() {
        ExchangeRateResponse exchangeRateResponse = null;
        String url = ConfiguracaoAPI.configuraRequisicao("37944748ebd54fc6b57cf7f3");
        String jsonBody = RequisicaoHTTP.requestURl(url);
        exchangeRateResponse = DezserializeGson.parser(jsonBody);
        return exchangeRateResponse;
    }


}

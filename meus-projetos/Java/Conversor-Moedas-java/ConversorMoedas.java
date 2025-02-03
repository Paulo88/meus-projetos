import java.util.Scanner;

public class ConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taxas de conversao ficticias
        double taxaDolar = 5.50;
        double taxaEuro = 6.20;
        double taxaLibra = 7.10;

        // Menu de opcoes
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Digite o valor em reais (R$) que deseja converter:");
        double valorReais = scanner.nextDouble();

        System.out.println("Escolha a moeda para a conversao:");
        System.out.println("1. Dolar");
        System.out.println("2. Euro");
        System.out.println("3. Libra");

        int opcao = scanner.nextInt();
        double valorConvertido = 0.0;

        // Conversao de acordo com a moeda escolhida
        switch (opcao) {
            case 1:
                valorConvertido = valorReais / taxaDolar;
                System.out.println("Valor convertido em Dolar: $" + valorConvertido);
                break;
            case 2:
                valorConvertido = valorReais / taxaEuro;
                System.out.println("Valor convertido em Euro: €" + valorConvertido);
                break;
            case 3:
                valorConvertido = valorReais / taxaLibra;
                System.out.println("Valor convertido em Libra: £" + valorConvertido);
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }
}

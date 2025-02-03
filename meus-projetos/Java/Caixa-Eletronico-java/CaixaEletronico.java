import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.0; // Saldo inicial

        while (true) {
            // Menu de opcoes
            System.out.println("Bem-vindo ao caixa eletronico! Escolha uma opcao:");
            System.out.println("1. Ver saldo");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();

            // Ver saldo
            if (opcao == 1) {
                System.out.println("Seu saldo atual e: R$ " + saldo);
            } 
            // Sacar
            else if (opcao == 2) {
                System.out.println("Digite o valor para sacar:");
                double valorSaque = scanner.nextDouble();
                
                // Verifica se ha saldo suficiente
                if (valorSaque <= saldo) {
                    saldo -= valorSaque;
                    System.out.println("Saque realizado! Seu novo saldo e: R$ " + saldo);
                } else {
                    System.out.println("Saldo insuficiente!");
                }
            } 
            // Depositar
            else if (opcao == 3) {
                System.out.println("Digite o valor para depositar:");
                double valorDeposito = scanner.nextDouble();
                saldo += valorDeposito;
                System.out.println("Deposito realizado! Seu novo saldo e: R$ " + saldo);
            } 
            // Sair
            else if (opcao == 4) {
                System.out.println("Obrigado por usar o caixa eletronico! Ate logo!");
                break;
            } 
            // Opcao invalida
            else {
                System.out.println("Opcao invalida! Tente novamente.");
            }
        }
    }
}

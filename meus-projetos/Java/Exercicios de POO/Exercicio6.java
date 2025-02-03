import java.util.Scanner;

public class Exercicio6 {

    Exercicio6(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe a quantidade em Kg do quanto consumiu: ");
        double quantidadeConsumida = entrada.nextDouble();

        double totalConsumido = (quantidadeConsumida * 1000) - 750;

       double valorPagar = totalConsumido * 25.00 / 1000;

       System.out.println("\033[H\033[2J");
       System.out.flush();

        System.out.println("O valor a pagar é de " + valorPagar + " R$");

        entrada.close();

    }
    public static void main(String[] args) {
        new Exercicio6();
    }
}

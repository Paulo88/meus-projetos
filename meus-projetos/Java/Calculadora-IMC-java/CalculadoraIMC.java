import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo a Calculadora de IMC!");
        System.out.print("Digite seu peso em kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        // Calcula o IMC
        double imc = peso / (altura * altura);

        System.out.printf("Seu IMC e: %.2f%n", imc);

        // Classifica o IMC
        if (imc < 18.5) {
            System.out.println("Voce esta abaixo do peso.");
        } else if (imc < 24.9) {
            System.out.println("Voce esta com peso normal.");
        } else if (imc < 29.9) {
            System.out.println("Voce esta com sobrepeso.");
        } else {
            System.out.println("Voce esta com obesidade.");
        }
    }
}

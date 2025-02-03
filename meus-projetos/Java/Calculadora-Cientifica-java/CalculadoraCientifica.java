import java.util.Scanner;

public class CalculadoraCientifica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu de opcoes
        System.out.println("Bem-vindo a Calculadora Cientifica!");
        System.out.println("Escolha a operacao:");
        System.out.println("1. Soma");
        System.out.println("2. Subtracao");
        System.out.println("3. Multiplicacao");
        System.out.println("4. Divisao");
        System.out.println("5. Potencia");
        System.out.println("6. Raiz quadrada");

        int opcao = scanner.nextInt();

        double num1, num2, resultado = 0;

        // Calculadora para as operacoes basicas e cientificas
        switch (opcao) {
            case 1:
                System.out.println("Digite o primeiro numero:");
                num1 = scanner.nextDouble();
                System.out.println("Digite o segundo numero:");
                num2 = scanner.nextDouble();
                resultado = num1 + num2;
                System.out.println("Resultado: " + resultado);
                break;
            case 2:
                System.out.println("Digite o primeiro numero:");
                num1 = scanner.nextDouble();
                System.out.println("Digite o segundo numero:");
                num2 = scanner.nextDouble();
                resultado = num1 - num2;
                System.out.println("Resultado: " + resultado);
                break;
            case 3:
                System.out.println("Digite o primeiro numero:");
                num1 = scanner.nextDouble();
                System.out.println("Digite o segundo numero:");
                num2 = scanner.nextDouble();
                resultado = num1 * num2;
                System.out.println("Resultado: " + resultado);
                break;
            case 4:
                System.out.println("Digite o primeiro numero:");
                num1 = scanner.nextDouble();
                System.out.println("Digite o segundo numero:");
                num2 = scanner.nextDouble();
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Erro: Divisao por zero!");
                }
                break;
            case 5:
                System.out.println("Digite a base:");
                num1 = scanner.nextDouble();
                System.out.println("Digite o expoente:");
                num2 = scanner.nextDouble();
                resultado = Math.pow(num1, num2);
                System.out.println("Resultado: " + resultado);
                break;
            case 6:
                System.out.println("Digite o numero:");
                num1 = scanner.nextDouble();
                resultado = Math.sqrt(num1);
                System.out.println("Resultado: " + resultado);
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }
}

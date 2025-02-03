import java.util.Random;
import java.util.Scanner;

public class AdivinheONumero {
    public static void main(String[] args) {
        Random random = new Random(); // Para gerar um numero aleatorio
        Scanner scanner = new Scanner(System.in); // Para capturar a entrada do jogador
        int numeroSecreto = random.nextInt(100) + 1;  // Numero entre 1 e 100
        int tentativas = 0; // Conta o numero de tentativas
        int chute = 0; // Variavel para armazenar o chute do jogador

        System.out.println("Adivinhe o numero entre 1 e 100:");

        // O loop continua enquanto o jogador nao adivinhar o numero
        while (chute != numeroSecreto) {
            System.out.print("Digite seu chute: ");
            chute = scanner.nextInt(); // Jogador faz um chute
            tentativas++; // Conta mais uma tentativa

            // Fornece dicas se o chute foi maior ou menor que o numero secreto
            if (chute < numeroSecreto) {
                System.out.println("Mais alto!");
            } else if (chute > numeroSecreto) {
                System.out.println("Mais baixo!");
            } else {
                // O jogador acertou, exibe o numero de tentativas usadas
                System.out.println("Parabens! Voce acertou em " + tentativas + " tentativas.");
            }
        }
    }
}

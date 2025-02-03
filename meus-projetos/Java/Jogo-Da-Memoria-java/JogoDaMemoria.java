import java.util.Random;
import java.util.Scanner;

public class JogoDaMemoria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int nivel = 1; // Nivel inicial
        boolean acertou = true; // Variavel que controla se o jogador acertou

        // O jogo continua enquanto o jogador estiver acertando
        while (acertou) {
            int[] sequencia = new int[nivel]; // Cria a sequencia a ser memorizada
            System.out.print("Memorize esta sequencia: ");
            
            // Gera e exibe a sequencia
            for (int i = 0; i < nivel; i++) {
                sequencia[i] = random.nextInt(9) + 1;  // Numeros entre 1 e 9
                System.out.print(sequencia[i] + " ");
            }

            System.out.println("\nDigite a sequencia:");
            // Jogador tenta repetir a sequencia
            for (int i = 0; i < nivel; i++) {
                int chute = scanner.nextInt();
                if (chute != sequencia[i]) {
                    acertou = false; // Se errar, o jogo termina
                    break;
                }
            }

            // Se o jogador acertou, aumenta o nivel
            if (acertou) {
                System.out.println("Parabens! Voce passou do nivel " + nivel);
                nivel++; // Aumenta a dificuldade
            } else {
                System.out.println("Voce errou! Fim de jogo.");
            }
        }
    }
}

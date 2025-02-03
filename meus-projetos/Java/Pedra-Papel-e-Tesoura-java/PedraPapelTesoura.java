import java.util.Scanner;
import java.util.Random;

public class PedraPapelTesoura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Leitura da escolha do jogador
        Random random = new Random(); // Para gerar a escolha aleatoria do computador
        String[] opcoes = {"Pedra", "Papel", "Tesoura"}; // Opcoes possiveis do jogo

        // O jogador escolhe uma opcao entre 0 (Pedra), 1 (Papel) ou 2 (Tesoura)
        System.out.println("Escolha: 0 para Pedra, 1 para Papel, 2 para Tesoura:");
        int escolhaJogador = scanner.nextInt(); // Captura a escolha do jogador
        int escolhaComputador = random.nextInt(3); // Computador escolhe aleatoriamente uma das 3 opcoes

        // Exibe as escolhas feitas
        System.out.println("Voce escolheu: " + opcoes[escolhaJogador]);
        System.out.println("Computador escolheu: " + opcoes[escolhaComputador]);

        // Verifica quem ganhou ou se deu empate
        if (escolhaJogador == escolhaComputador) {
            System.out.println("Empate!");
        } else if ((escolhaJogador == 0 && escolhaComputador == 2) ||
                   (escolhaJogador == 1 && escolhaComputador == 0) ||
                   (escolhaJogador == 2 && escolhaComputador == 1)) {
            System.out.println("Voce venceu!"); // Jogador ganha
        } else {
            System.out.println("Voce perdeu!"); // Computador ganha
        }
    }
}

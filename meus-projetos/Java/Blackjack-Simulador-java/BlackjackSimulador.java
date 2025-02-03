import java.util.Random;
import java.util.Scanner;

public class BlackjackSimulador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int fichas = 100; // O jogador comeca com 100 fichas

        System.out.println("Bem-vindo ao Simulador de Blackjack (21)!");
        System.out.println("Voce comeca com 100 fichas.");
        
        while (fichas > 0) {
            System.out.println("\nQuantas fichas voce quer apostar? (Digite 0 para sair)");
            int aposta = scanner.nextInt();

            if (aposta == 0) {
                System.out.println("Voce decidiu sair do jogo com " + fichas + " fichas. Ate mais!");
                break;
            } else if (aposta > fichas) {
                System.out.println("Voce nao tem fichas suficientes! Aposte um valor valido.");
                continue;
            }

            int jogadorPontos = random.nextInt(11) + 16; // Jogador comeca com 16 a 26 pontos
            int dealerPontos = random.nextInt(11) + 16;  // Dealer comeca com 16 a 26 pontos

            System.out.println("Suas cartas somam: " + jogadorPontos + " pontos.");
            System.out.println("O dealer tem " + dealerPontos + " pontos.");

            if (jogadorPontos > 21) {
                System.out.println("Voce estourou com " + jogadorPontos + " pontos. Voce perdeu a aposta.");
                fichas -= aposta;
            } else if (dealerPontos > 21 || jogadorPontos > dealerPontos) {
                System.out.println("Voce venceu o dealer! Voce ganhou " + aposta + " fichas.");
                fichas += aposta;
            } else {
                System.out.println("O dealer venceu! Voce perdeu " + aposta + " fichas.");
                fichas -= aposta;
            }

            System.out.println("Voce agora tem " + fichas + " fichas.");
        }

        if (fichas == 0) {
            System.out.println("Voce perdeu todas as fichas! Jogo encerrado.");
        }
    }
}

import java.util.Random;

public class CorridaDeDados {
    public static void main(String[] args) {
        Random random = new Random();
        int pontosJogador1 = 0; // Pontos do jogador 1
        int pontosJogador2 = 0; // Pontos do jogador 2
        int meta = 100; // Pontuacao para vencer

        // Continua jogando enquanto ninguem alcanca a meta
        while (pontosJogador1 < meta && pontosJogador2 < meta) {
            // Jogador 1 rola o dado
            int dado1 = random.nextInt(6) + 1;
            pontosJogador1 += dado1; // Soma o valor do dado aos pontos do jogador 1

            // Jogador 2 rola o dado
            int dado2 = random.nextInt(6) + 1;
            pontosJogador2 += dado2; // Soma o valor do dado aos pontos do jogador 2

            // Exibe os resultados atuais
            System.out.println("Jogador 1: " + pontosJogador1 + " pontos");
            System.out.println("Jogador 2: " + pontosJogador2 + " pontos");
        }

        // Verifica quem venceu
        if (pontosJogador1 >= meta) {
            System.out.println("Jogador 1 venceu!");
        } else {
            System.out.println("Jogador 2 venceu!");
        }
    }
}

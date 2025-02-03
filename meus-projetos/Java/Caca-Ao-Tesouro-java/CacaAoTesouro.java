import java.util.Scanner;
import java.util.Random;

public class CacaAoTesouro {
    public static void main(String[] args) {
        Random random = new Random(); // Para escolher aleatoriamente a posicao do tesouro
        Scanner scanner = new Scanner(System.in);
        
        int[][] mapa = new int[5][5]; // Um mapa 5x5 (uma matriz)
        int jogadorX = 0, jogadorY = 0; // Ponto inicial do jogador
        int tesouroX = random.nextInt(5), tesouroY = random.nextInt(5); // Ponto aleatorio do tesouro
        mapa[tesouroX][tesouroY] = 9; // Marca a posicao do tesouro

        // O jogo continua ate o jogador encontrar o tesouro
        while (jogadorX != tesouroX || jogadorY != tesouroY) {
            System.out.println("Voce esta em (" + jogadorX + "," + jogadorY + ")");
            System.out.print("Movimente-se (cima, baixo, esquerda, direita): ");
            String movimento = scanner.nextLine().toLowerCase(); // Captura o movimento do jogador

            // Atualiza a posicao do jogador com base no movimento
            switch (movimento) {
                case "cima":
                    if (jogadorX > 0) jogadorX--;
                    break;
                case "baixo":
                    if (jogadorX < 4) jogadorX++;
                    break;
                case "esquerda":
                    if (jogadorY > 0) jogadorY--;
                    break;
                case "direita":
                    if (jogadorY < 4) jogadorY++;
                    break;
                default:
                    System.out.println("Movimento invalido.");
            }
        }

        // O jogador encontrou o tesouro
        System.out.println("Parabens! Voce encontrou o tesouro em (" + tesouroX + "," + tesouroY + ")!");
    }
}

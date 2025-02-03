import java.util.Scanner;

public class JogoMemoria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] cartas = {"🐶", "🐱", "🐭", "🐹", "🐰", "🦊", "🐻", "🐼"};
        boolean[] viradas = new boolean[cartas.length]; // Para controlar quais cartas ja foram viradas
        int tentativas = 0;
        
        System.out.println("Bem-vindo ao Jogo da Memoria! Tente encontrar os pares de animais!");

        // Loop do jogo
        while (!todasViradas(viradas)) {
            exibirCartas(cartas, viradas); // Exibe as cartas
            System.out.println("Escolha duas cartas para virar (0 a " + (cartas.length - 1) + "):");
            
            // Escolha do jogador
            int escolha1 = scanner.nextInt();
            int escolha2 = scanner.nextInt();
            
            // Verifica se as cartas sao iguais
            if (cartas[escolha1].equals(cartas[escolha2])) {
                System.out.println("Par encontrado! " + cartas[escolha1] + " e " + cartas[escolha2]);
                viradas[escolha1] = true;
                viradas[escolha2] = true;
            } else {
                System.out.println("Nao foi dessa vez! Tente novamente.");
            }
            
            tentativas++;
        }
        
        System.out.println("Parabens! Voce encontrou todos os pares em " + tentativas + " tentativas!");
    }

    // Funcao para exibir as cartas
    public static void exibirCartas(String[] cartas, boolean[] viradas) {
        for (int i = 0; i < cartas.length; i++) {
            if (viradas[i]) {
                System.out.print(cartas[i] + " ");
            } else {
                System.out.print("[?] ");
            }
        }
        System.out.println();
    }

    // Verifica se todas as cartas foram viradas
    public static boolean todasViradas(boolean[] viradas) {
        for (boolean carta : viradas) {
            if (!carta) {
                return false;
            }
        }
        return true;
    }
}

import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palavraSecreta = "java"; // Define a palavra secreta
        char[] progresso = new char[palavraSecreta.length()]; // Para mostrar o progresso do jogador
        int tentativasRestantes = 6; // O jogador tem 6 tentativas para errar

        // Inicializa o progresso com underscores (ainda nao descoberto)
        for (int i = 0; i < progresso.length; i++) {
            progresso[i] = '_';
        }

        // Continua enquanto o jogador tiver tentativas e nao adivinhar todas as letras
        while (tentativasRestantes > 0 && new String(progresso).contains("_")) {
            System.out.print("Palavra: ");
            System.out.println(progresso); // Exibe o progresso do jogador
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Adivinhe uma letra: ");
            char chute = scanner.next().charAt(0); // Jogador chuta uma letra

            boolean acertou = false;
            // Verifica se o chute esta correto
            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == chute) {
                    progresso[i] = chute; // Atualiza o progresso
                    acertou = true;
                }
            }

            if (!acertou) {
                tentativasRestantes--; // Se o jogador errou, perde uma tentativa
            }
        }

        // Verifica se o jogador venceu ou perdeu
        if (tentativasRestantes == 0) {
            System.out.println("Voce perdeu! A palavra era: " + palavraSecreta);
        } else {
            System.out.println("Parabens! Voce adivinhou a palavra: " + palavraSecreta);
        }
    }
}

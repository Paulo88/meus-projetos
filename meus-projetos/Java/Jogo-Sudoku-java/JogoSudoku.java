import java.util.Scanner;

public class JogoSudoku {
    public static void main(String[] args) {
        int[][] tabuleiro = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sudoku! Complete o tabuleiro preenchendo os espacos vazios.");
        while (!tabuleiroCompleto(tabuleiro)) {
            exibirTabuleiro(tabuleiro);

            System.out.println("Digite a linha (0-8): ");
            int linha = scanner.nextInt();
            System.out.println("Digite a coluna (0-8): ");
            int coluna = scanner.nextInt();
            System.out.println("Digite o valor (1-9): ");
            int valor = scanner.nextInt();

            // Verifica se o valor e valido
            if (valor >= 1 && valor <= 9 && tabuleiro[linha][coluna] == 0) {
                tabuleiro[linha][coluna] = valor;
            } else {
                System.out.println("Movimento invalido! Tente novamente.");
            }
        }

        System.out.println("Parabens! Voce completou o Sudoku!");
    }

    // Exibe o tabuleiro
    public static void exibirTabuleiro(int[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Verifica se o tabuleiro esta completo
    public static boolean tabuleiroCompleto(int[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

import java.util.Scanner;

public class JogoDaVelha {

    // Cria o tabuleiro 3x3 para o jogo da velha
    private static char[][] tabuleiro = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}; 
    private static char jogadorAtual = 'X';  // O jogador 'X' sempre começa o jogo
    private static String nomeJogadorX;  // Nome do jogador que será 'X'
    private static String nomeJogadorO;  // Nome do jogador que será 'O'
    private static String nomeJogadorAtual;  // Armazena o nome do jogador que está jogando no momento
    private static Scanner scanner = new Scanner(System.in);  // Scanner para capturar a entrada do jogador

    public static void main(String[] args) {
        // Saudação inicial do jogo
        System.out.println("Bem-vindo ao Jogo da Velha");
        
        // Pedindo os nomes dos dois jogadores
        System.out.print("Jogador 1, insira seu nome (voce sera o X): ");
        nomeJogadorX = scanner.nextLine();  // Jogador X insere seu nome
        System.out.print("Jogador 2, insira seu nome (voce sera o O): ");
        nomeJogadorO = scanner.nextLine();  // Jogador O insere seu nome
        nomeJogadorAtual = nomeJogadorX;  // Começa com o jogador X

        boolean jogoAtivo = true;  // Variável que controla se o jogo está em andamento
        imprimirTabuleiro();  // Mostra o tabuleiro vazio no início do jogo

        // Enquanto o jogo estiver ativo, as jogadas continuam
        while (jogoAtivo) {
            realizarJogada();  // O jogador atual faz sua jogada
            imprimirTabuleiro();  // Atualiza o tabuleiro após a jogada
            
            // Verifica se o jogador atual venceu
            if (verificarVitoria()) {
                System.out.println("\n" + nomeJogadorAtual + " venceu!");  // Mostra o nome do vencedor
                mostrarPersonagens(nomeJogadorAtual);  // Exibe R2D2 e C3PO comemorando
                jogoAtivo = false;  // Termina o jogo
            } else if (verificarEmpate()) {
                System.out.println("O jogo terminou em empate!");  // Informa que o jogo empatou
                jogoAtivo = false;  // Termina o jogo
            }
            
            // Alterna para o outro jogador se o jogo não terminou
            trocarJogador();
        }
    }

    // Exibe o tabuleiro no console
    public static void imprimirTabuleiro() {
        System.out.println("  0 1 2");  // Mostra os números das colunas
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");  // Mostra os números das linhas
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);  // Exibe o valor de cada célula ('X', 'O' ou espaço)
                if (j < 2) System.out.print("|");  // Coloca uma barra vertical entre as colunas
            }
            System.out.println();  // Pula para a linha seguinte
            if (i < 2) System.out.println("  -----");  // Coloca linhas horizontais entre as linhas do tabuleiro
        }
    }

    // Realiza a jogada do jogador atual
    public static void realizarJogada() {
        int linha, coluna;
        while (true) {
            // Pede ao jogador atual para inserir a linha e a coluna da jogada
            System.out.println(nomeJogadorAtual + " (" + jogadorAtual + "), insira sua jogada (linha e coluna): ");
            linha = scanner.nextInt();  // Recebe a linha
            coluna = scanner.nextInt();  // Recebe a coluna
            
            // Verifica se a jogada é válida (dentro do tabuleiro e em uma célula vazia)
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual;  // Atualiza o tabuleiro com a jogada
                break;  // Sai do loop quando a jogada é válida
            } else {
                System.out.println("Movimento invalido, tente novamente.");  // Informa que a jogada foi inválida
            }
        }
    }

    // Alterna o jogador atual (de 'X' para 'O' ou de 'O' para 'X')
    public static void trocarJogador() {
        if (jogadorAtual == 'X') {
            jogadorAtual = 'O';  // Se era o 'X', passa a ser o 'O'
            nomeJogadorAtual = nomeJogadorO;  // Atualiza o nome do jogador atual
        } else {
            jogadorAtual = 'X';  // Se era o 'O', passa a ser o 'X'
            nomeJogadorAtual = nomeJogadorX;  // Atualiza o nome do jogador atual
        }
    }

    // Verifica se o jogador atual venceu o jogo
    public static boolean verificarVitoria() {
        // Verifica as linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;  // Se todos os valores da linha forem iguais, o jogador venceu
            }
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                return true;  // Se todos os valores da coluna forem iguais, o jogador venceu
            }
        }
        // Verifica as diagonais
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;  // Se todos os valores da diagonal principal forem iguais, o jogador venceu
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;  // Se todos os valores da diagonal secundária forem iguais, o jogador venceu
        }
        return false;  // Se nenhuma condição foi satisfeita, o jogo continua
    }

    // Verifica se houve um empate (quando todas as células estão preenchidas e ninguém venceu)
    public static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;  // Ainda há células vazias, então não é empate
                }
            }
        }
        return true;  // Todas as células estão preenchidas e não houve vencedor
    }

    // Exibe os personagens R2D2 e C3PO comemorando a vitória do jogador
    public static void mostrarPersonagens(String vencedor) {
        System.out.println("\nParabéns, " + vencedor + "! o R2D2 e C3PO estao comemorando sua vitória!");
        System.out.println("                     __         ");
        System.out.println("                    oo \\      ");
        System.out.println("                   _\\= /_      ");
        System.out.println("      ___      #  /  _   \\     ");
        System.out.println("     / ()\\     \\\\//|/_\\ |\\\\ ");
        System.out.println("   _|_____|_    \\/ |\\_/ | ||  ");
        System.out.println("  | | === | |      \\_  _/ #    ");
        System.out.println("  |_|  0  |_|      | || |      ");
        System.out.println("   ||__*__||       | || |      ");
        System.out.println("   |~\\___/~|       [ ][ ]      ");
        System.out.println("   /=\\/=\\/=\\       | || |      ");
        System.out.println("   [_][_][_]       /_] [_\\    ");
    }
}

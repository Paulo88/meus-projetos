import java.util.Random;  // Importa a classe Random para gerar números aleatórios
import java.util.Scanner; // Importa a classe Scanner para entrada do usuário

public class trabalhoFinal {

    // Definição das constantes para o jogo
    private static final int TAMANHO_TABULEIRO = 8;  // Tamanho do tabuleiro (8x8)
    private static final int NUMERO_NAVIOS = 10;     // Número de navios no jogo
    private static final int MAX_TENTATIVAS = 30;    // Máximo de tentativas para o jogador

    // Matriz que representa o tabuleiro do jogo e variável para contar os navios restantes
    private static char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
    private static int naviosRestantes = NUMERO_NAVIOS;

    public static void main(String[] args) {
        // Inicializa o jogo
        inicializarTabuleiro();   // Preenche o tabuleiro com água ('~')
        posicionarNavios();       // Posiciona os navios aleatoriamente
        jogar();                  // Inicia a lógica principal do jogo
    }

    // Função que preenche o tabuleiro com água ('~') em todas as posições
    private static void inicializarTabuleiro() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = '~';  // '~' simboliza uma posição sem navio (água)
            }
        }
    }

    // Função que posiciona os navios aleatoriamente no tabuleiro
    private static void posicionarNavios() {
        Random random = new Random();  // Cria um gerador de números aleatórios
        int naviosPosicionados = 0;    // Contador para controlar a quantidade de navios posicionados

        // Enquanto não atingir o número de navios desejado, continua posicionando
        while (naviosPosicionados < NUMERO_NAVIOS) {
            int linha = random.nextInt(TAMANHO_TABULEIRO);  // Escolhe uma linha aleatória
            int coluna = random.nextInt(TAMANHO_TABULEIRO); // Escolhe uma coluna aleatória

            // Se a posição estiver vazia (água), posiciona o navio ('N')
            if (tabuleiro[linha][coluna] == '~') {
                tabuleiro[linha][coluna] = 'N';  // 'N' representa um navio
                naviosPosicionados++;  // Incrementa o número de navios posicionados
            }
        }
    }

    // Função principal que controla o jogo
    private static void jogar() {
        Scanner scanner = new Scanner(System.in);  // Objeto para ler a entrada do jogador
        int tentativas = 0;  // Contador de tentativas realizadas pelo jogador

        // Loop do jogo: continua enquanto houver tentativas disponíveis e navios no tabuleiro
        while (tentativas < MAX_TENTATIVAS && naviosRestantes > 0) {
            mostrarTabuleiro();  // Mostra o estado atual do tabuleiro

            // Solicita ao jogador as coordenadas para atacar
            System.out.println("Tentativa " + (tentativas + 1) + " de " + MAX_TENTATIVAS);
            System.out.print("Digite as coordenadas para atacar (linha e coluna, separadas por espaco): ");
            int linha = scanner.nextInt();  // Lê a linha digitada
            int coluna = scanner.nextInt(); // Lê a coluna digitada

            // Verifica se as coordenadas são válidas (dentro do tabuleiro)
            if (linha < 0 || linha >= TAMANHO_TABULEIRO || coluna < 0 || coluna >= TAMANHO_TABULEIRO) {
                System.out.println("Esta posicao nao e valida... Tente novamente...");
                continue;  // Volta ao início do loop para uma nova tentativa
            }

            // Verifica se a posição já foi atacada
            if (tabuleiro[linha][coluna] == 'N') {
                // Caso acerte um navio
                System.out.println("Acertou um navio, parabens!!!");
                tabuleiro[linha][coluna] = 'X';  // Marca a posição como acertada
                naviosRestantes--;  // Diminui o número de navios restantes
            } else if (tabuleiro[linha][coluna] == '~') {
                // Caso erre o tiro (apenas água)
                System.out.println("Você errou... aqui so tem agua...");
                tabuleiro[linha][coluna] = 'O';  // Marca a posição como água atacada
            } else {
                // Caso já tenha atacado a mesma posição
                System.out.println("Voce já atacou aqui... Tente novamente!!!");
                continue;  // Permite que o jogador faça uma nova tentativa
            }

            tentativas++;  // Incrementa o número de tentativas
        }

        // Após o término do jogo, verifica o resultado
        if (naviosRestantes == 0) {
            System.out.println("Parabens! Você destruiu todos os navios!!!");
        } else {
            System.out.println("Fim do jogo... você usou todas as suas tentativas. =(");
        }

        revelarTabuleiro();  // Revela todas as posições dos navios ao final do jogo
        scanner.close();  // Fecha o Scanner (boa prática de programação)
    }

    // Função que exibe o estado atual do tabuleiro, ocultando os navios ainda não atingidos
    private static void mostrarTabuleiro() {
        System.out.println("  0 1 2 3 4 5 6 7");  // Cabeçalho com os números das colunas
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            System.out.print(i + " ");  // Mostra o número da linha
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                // Se for um navio não atingido, mostra água (~), caso contrário, mostra o que está no tabuleiro
                if (tabuleiro[i][j] == 'N') {
                    System.out.print("~ ");  // Oculta os navios não atingidos
                } else {
                    System.out.print(tabuleiro[i][j] + " ");  // Mostra a posição (X, O, ou água)
                }
            }
            System.out.println();  // Pula para a próxima linha após exibir todas as colunas
        }
    }

    // Função que revela o tabuleiro completo ao final do jogo, mostrando onde os navios estavam
    private static void revelarTabuleiro() {
        System.out.println("Aqui esta o tabuleiro final:");
        System.out.println("  0 1 2 3 4 5 6 7");  // Cabeçalho das colunas
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            System.out.print(i + " ");  // Mostra o número da linha
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro[i][j] + " ");  // Mostra todas as posições do tabuleiro
            }
            System.out.println();  // Pula para a próxima linha
        }
    }
}

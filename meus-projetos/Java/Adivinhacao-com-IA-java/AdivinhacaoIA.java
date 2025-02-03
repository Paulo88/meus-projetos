import java.util.Scanner;
import java.util.Random;

public class AdivinhacaoIA {
    public static void main(String[] args) {
        // Scanner para receber input do usuario
        Scanner scanner = new Scanner(System.in);
        
        // Definir os limites de adivinhacao
        int min = 1;
        int max = 100;
        
        // O computador tenta adivinhar o numero que voce pensou
        Random random = new Random();
        int chute = random.nextInt(max - min + 1) + min;
        
        // Variavel para armazenar a resposta do usuario
        String resposta = "";
        
        System.out.println("Pense em um numero entre 1 e 100. A IA vai tentar adivinhar!");
        
        // Loop de adivinhacao
        while (!resposta.equals("acertou")) {
            System.out.println("A IA acha que o numero e " + chute + ". Esta certo? (responda com 'maior', 'menor' ou 'acertou')");
            resposta = scanner.nextLine();
            
            if (resposta.equals("maior")) {
                min = chute + 1; // Ajusta o minimo
            } else if (resposta.equals("menor")) {
                max = chute - 1; // Ajusta o maximo
            }
            
            // IA ajusta o chute baseado nas dicas
            chute = random.nextInt(max - min + 1) + min;
        }
        
        System.out.println("A IA acertou o numero! Parabens para o computador!");
    }
}

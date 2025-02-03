import java.util.Random;
import java.util.Scanner;

public class SimuladorTransito {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao Simulador de Transito!");
        System.out.println("Escolha o tipo de transito: ");
        System.out.println("1. Leve");
        System.out.println("2. Moderado");
        System.out.println("3. Pesado");

        int escolha = scanner.nextInt();
        int tempoEspera = 0;

        // Define o tempo de espera com base no tipo de transito
        switch (escolha) {
            case 1:
                tempoEspera = random.nextInt(5) + 1; // 1 a 5 minutos
                System.out.println("Transito leve, voce chegara rapidinho!");
                break;
            case 2:
                tempoEspera = random.nextInt(10) + 5; // 5 a 15 minutos
                System.out.println("Transito moderado, pegue sua playlist favorita.");
                break;
            case 3:
                tempoEspera = random.nextInt(20) + 15; // 15 a 35 minutos
                System.out.println("Transito pesado, paciencia e tudo...");
                break;
            default:
                System.out.println("Opcao invalida! O transito nao gosta de brincadeira.");
                return;
        }

        System.out.println("Voce vai esperar " + tempoEspera + " minutos ate chegar ao seu destino.");
    }
}

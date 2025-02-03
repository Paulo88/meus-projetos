import java.util.Scanner;

public class Exercicio4 {

    Exercicio4(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe a 1° nota do aluno: ");
        double nota1 = entrada.nextDouble();

        System.out.println("Informe a 2° nota do aluno: ");
        double nota2 = entrada.nextDouble();

        System.out.println("Informe a 3° nota do aluno: ");
        double nota3 = entrada.nextDouble();

        // peso da nota 1° é 5
        // peso da nota 2° é 3
        // peso da nota 3° é 2
        
        double media = (nota1 * 5 + nota2 * 3 + nota3 * 2) / (5 + 3 + 2);
        
        System.out.println("A sua nota final é " + media);

        entrada.close();
    }
    public static void main(String[] args) {
        new Exercicio4();
    }
}

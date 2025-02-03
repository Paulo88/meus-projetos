import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio1 {

    Exercicio1(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a largura (m): ");
        double largura = entrada.nextDouble();

        System.out.println("Digite comprimento (m): ");
        double comprimento = entrada.nextDouble();

        double area = largura * comprimento;

        DecimalFormat df = new DecimalFormat("0.0");

        System.out.println("Área do terreno = " + df.format(area) + " M ");


        entrada.close();
    }
 public static void main(String[] args) {
    new Exercicio1();
 }   
}
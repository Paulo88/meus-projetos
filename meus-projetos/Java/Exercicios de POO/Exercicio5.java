import java.util.Scanner;

public class Exercicio5 {

    Exercicio5(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("O anel direito custa 4,00 R$");
        System.out.println("O anel esquerdo custa 3,50 R$, porém são duas unidades usadas");
        System.out.println("Informe quantos frangos vôce possui:");
        double quantidadadeFrango = entrada.nextDouble();

        double valorTotalPagar = quantidadadeFrango * 11.00;

        System.out.println("O total a pagar é " + valorTotalPagar);


        entrada.close();
    }
    public static void main(String[] args) {
        new Exercicio5();
    }
}

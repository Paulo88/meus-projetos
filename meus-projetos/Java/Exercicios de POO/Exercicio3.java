import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio3 {
    
    Exercicio3(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Qual o preço do litro(L): ");
        double valorLitro = entrada.nextDouble();

        System.out.println("Valor do pagamento: ");
        double valorPagamento = entrada.nextDouble();

        double litrosAbastecido = valorPagamento / valorLitro;

        DecimalFormat df = new DecimalFormat("0.0");

        System.out.println("Com " + valorPagamento +" reais, vôce abasteceu " + df.format(litrosAbastecido) + " litros de gasolina");

    

        entrada.close();

    }
    public static void main(String[] args) {
       new Exercicio3();
    }
}

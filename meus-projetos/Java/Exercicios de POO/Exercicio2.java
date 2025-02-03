import java.util.Scanner;

public class Exercicio2 {


    Exercicio2(){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o valor do desconto: ");
        double desconto = entrada.nextDouble();

        System.out.println("Informe o valor do preço do sapato");
        double precoSapato = entrada.nextDouble();

        double descontoEmReais = (precoSapato * desconto) / 100;

        double precoComDesconto = precoSapato - descontoEmReais;

        double valorDesconto = precoSapato - precoComDesconto;


        System.out.println("O valor do desconto é de " + desconto + "%");
        System.out.println("Seu sapato custou " + precoSapato + "R$, mas, com o desconto de " + valorDesconto + " Reais");
        System.out.println("O preço do par de sapatos com o desconto é de R$ " + precoComDesconto + " Reais");

        entrada.close();


    }


    public static void main(String[] args) {
        new Exercicio2();
    }
}

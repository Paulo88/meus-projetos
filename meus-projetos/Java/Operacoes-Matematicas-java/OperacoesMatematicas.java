import java.util.Scanner; // Importa a classe Scanner para entrada de dados

public class OperacoesMatematicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler entradas do usuário

        // Solicita o nome do usuário
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine(); // Lê o nome do usuário

        // Exibe as boas-vindas e o menu de opções
        System.out.println("Ola, " + nome + "! Bem-vindo ao Menu de Operacoes Matematicas");
        System.out.println("Escolha uma operacao:");
        System.out.println("Basicas:");
        System.out.println("1 - Adicao");
        System.out.println("2 - Subtracao");
        System.out.println("3 - Multiplicacao");
        System.out.println("4 - Divisao");
        System.out.println("5 - Potenciacao");
        System.out.println("6 - Radiciacao");
        System.out.println("7 - Logaritmacao");
        System.out.println("Avancadas:");
        System.out.println("9 - Pre-calculo <<APENAS EXEMPLIFICACAO>>");
        System.out.println("10 - Calculo diferencial");
        System.out.println("11 - Calculo integral");
        System.out.println("12 - Equacoes diferenciais");
        System.out.println("13 - Calculo multivariavel <<APENAS EXEMPLIFICACAO>>");
        System.out.println("14 - Algebra linear <<APENAS EXEMPLIFICACAO>>");

        // Lê a escolha do usuário
        System.out.print("Escolha uma operacao pelo numero: ");
        int opcao = scanner.nextInt(); // Lê a opção escolhida

        // Declara variáveis para os números que serão usados nas operações
        double num1, num2;

        // Usa um switch para tratar cada opção escolhida
        switch (opcao) {
            case 1:
                // Adição
                System.out.println("Adicao e a soma de dois numeros.");
                System.out.print("Digite o primeiro numero: ");
                num1 = scanner.nextDouble(); // Lê o primeiro número
                System.out.print("Digite o segundo numero: ");
                num2 = scanner.nextDouble(); // Lê o segundo número
                System.out.println("Resultado: " + num1 + " + " + num2 + " = " + (num1 + num2)); // Calcula e exibe o resultado
                break; // Encerra este case

            case 2:
                // Subtração
                System.out.println("Subtracao e a operacao de encontrar a diferenca entre dois numeros.");
                System.out.print("Digite o primeiro numero: ");
                num1 = scanner.nextDouble();
                System.out.print("Digite o segundo numero: ");
                num2 = scanner.nextDouble();
                System.out.println("Resultado: " + num1 + " - " + num2 + " = " + (num1 - num2));
                break;

            case 3:
                // Multiplicação
                System.out.println("Multiplicacao e o ato de multiplicar dois numeros.");
                System.out.print("Digite o primeiro numero: ");
                num1 = scanner.nextDouble();
                System.out.print("Digite o segundo numero: ");
                num2 = scanner.nextDouble();
                System.out.println("Resultado: " + num1 + " * " + num2 + " = " + (num1 * num2));
                break;

            case 4:
                // Divisão
                System.out.println("Divisao e a operacao de dividir um numero pelo outro.");
                System.out.print("Digite o primeiro numero: ");
                num1 = scanner.nextDouble();
                System.out.print("Digite o segundo numero: ");
                num2 = scanner.nextDouble();
                // Verifica se o segundo número não é zero para evitar divisão por zero
                if (num2 != 0) {
                    System.out.println("Resultado: " + num1 + " / " + num2 + " = " + (num1 / num2));
                } else {
                    System.out.println("Nao e possivel dividir por zero."); // Mensagem de erro
                }
                break;

            case 5:
                // Potenciação
                System.out.println("Potenciacao e elevar um numero a uma potencia.");
                System.out.print("Digite a base: ");
                num1 = scanner.nextDouble();
                System.out.print("Digite o expoente: ");
                num2 = scanner.nextDouble();
                // Usa Math.pow para calcular a potência
                System.out.println("Resultado: " + num1 + "^" + num2 + " = " + Math.pow(num1, num2));
                break;

            case 6:
                // Radiciação
                System.out.println("Radiciacao e a operacao inversa da potenciacao.");
                System.out.print("Digite o numero para calcular a raiz: ");
                num1 = scanner.nextDouble();
                // Usa Math.sqrt para calcular a raiz quadrada
                System.out.println("Resultado: raiz de " + num1 + " = " + Math.sqrt(num1));
                break;

            case 7:
                // Logaritmagem
                System.out.println("Logaritmacao e encontrar o expoente ao qual um numero deve ser elevado.");
                System.out.print("Digite o numero para calcular o logaritmo: ");
                num1 = scanner.nextDouble();
                // Usa Math.log10 para calcular o logaritmo na base 10
                System.out.println("Resultado: log10(" + num1 + ") = " + Math.log10(num1));
                break;

            case 9:
                // Pré-cálculo
                System.out.println("Pre-calculo envolve estudar funcoes e limites.");
                System.out.println("Exemplo: f(x) = 2x + 3 e uma funcao linear.");
                break;

            case 10:
                // Cálculo diferencial
                System.out.println("Calculo diferencial: Vamos derivar uma funcao numericamente.");
                System.out.print("Digite um ponto x: ");
                num1 = scanner.nextDouble(); // Lê o ponto onde se quer calcular a derivada
                System.out.print("Digite o incremento dx: ");
                double dx = scanner.nextDouble(); // Lê o pequeno incremento
                System.out.println("Vamos derivar a funcao f(x) = x^2.");
                // Calcula a derivada usando a fórmula da diferença finita
                double derivada = (Math.pow(num1 + dx, 2) - Math.pow(num1, 2)) / dx;
                System.out.println("A derivada aproximada de f(x) = x^2 no ponto " + num1 + " e: " + derivada);
                break;

            case 11:
                // Cálculo integral
                System.out.println("Calculo integral: Vamos integrar a funcao f(x) = x^2 no intervalo [a, b].");
                System.out.print("Digite o limite inferior a: ");
                double a = scanner.nextDouble(); // Lê o limite inferior
                System.out.print("Digite o limite superior b: ");
                double b = scanner.nextDouble(); // Lê o limite superior
                System.out.print("Digite o numero de subdivisoes: ");
                int n = scanner.nextInt(); // Lê o número de subdivisões para a regra do trapézio
                double h = (b - a) / n; // Calcula a largura dos trapézios
                double soma = 0.5 * (Math.pow(a, 2) + Math.pow(b, 2)); // Inicia a soma com os limites
                for (int i = 1; i < n; i++) { // Loop para somar as áreas dos trapézios
                    double x = a + i * h; // Calcula o valor de x em cada subdivisão
                    soma += Math.pow(x, 2); // Adiciona a área do trapézio atual
                }
                double integral = soma * h; // Multiplica pela largura para obter a integral
                System.out.println("A integral aproximada de f(x) = x^2 no intervalo [" + a + ", " + b + "] e: " + integral);
                break;

            case 12:
                // Equações diferenciais
                System.out.println("Equacoes diferenciais: Resolveremos numericamente dy/dx = y.");
                System.out.print("Digite o valor inicial de y (y0): ");
                double y0 = scanner.nextDouble(); // Lê o valor inicial de y
                System.out.print("Digite o valor inicial de x (x0): ");
                double x0 = scanner.nextDouble(); // Lê o valor inicial de x
                System.out.print("Digite o incremento dx: ");
                dx = scanner.nextDouble(); // Lê o incremento
                System.out.print("Digite o numero de passos: ");
                int passos = scanner.nextInt(); // Lê o número de passos a serem dados
                for (int i = 0; i < passos; i++) { // Loop para calcular y usando o método de Euler
                    y0 = y0 + dx * y0; // Atualiza y com a fórmula de Euler
                    x0 += dx; // Atualiza x
                }
                System.out.println("O valor aproximado de y apos " + passos + " passos e: " + y0);
                break;

            case 13:
                // Cálculo multivariável
                System.out.println("Calculo multivariavel envolve funcoes com mais de uma variavel.");
                System.out.println("Exemplo: f(x, y) = x^2 + y^2 e uma funcao de duas variaveis.");
                break;

            case 14:
                // Álgebra linear
                System.out.println("Algebra linear estuda sistemas de equacoes lineares.");
                System.out.println("Exemplo: Ax = b, onde A e uma matriz e x e um vetor.");
                break;

            default:
                // Caso o usuário digite uma opção inválida
                System.out.println("Opcao invalida! Tente novamente."); // Mensagem de erro
                break; // Encerra o switch
        }

        // Fecha o scanner para evitar vazamento de recursos
        scanner.close();
    }
}

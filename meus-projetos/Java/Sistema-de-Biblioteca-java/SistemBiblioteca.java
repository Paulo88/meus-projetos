import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    String titulo;
    String autor;

    // Construtor da classe Livro
    Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Metodo para exibir informacoes do livro
    void exibirInfo() {
        System.out.println("Titulo: " + titulo + ", Autor: " + autor);
    }
}

public class Biblioteca {
    public static void main(String[] args) {
        // Lista para armazenar os livros
        ArrayList<Livro> livros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Bem-vindo ao sistema de biblioteca! Escolha uma opcao:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Sair");
            
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            
            // Opcoes do menu
            if (escolha == 1) {
                System.out.println("Digite o titulo do livro:");
                String titulo = scanner.nextLine();
                System.out.println("Digite o autor do livro:");
                String autor = scanner.nextLine();
                livros.add(new Livro(titulo, autor)); // Adiciona o livro
                System.out.println("Livro adicionado com sucesso!");
            } else if (escolha == 2) {
                System.out.println("Lista de livros na biblioteca:");
                for (Livro livro : livros) {
                    livro.exibirInfo();
                }
            } else if (escolha == 3) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
}

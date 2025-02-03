import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tarefas = new ArrayList<>();

        System.out.println("Bem-vindo ao seu super eficiente aplicativo de To-do List!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Marcar tarefa como concluida");
            System.out.println("4. Exibir todas as tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome o '\n' pendente

            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa que deseja adicionar: ");
                    String novaTarefa = scanner.nextLine();
                    tarefas.add(novaTarefa);
                    System.out.println("Tarefa adicionada: " + novaTarefa);
                    break;
                case 2:
                    System.out.print("Digite o numero da tarefa que deseja remover: ");
                    int indiceRemover = scanner.nextInt() - 1;
                    if (indiceRemover >= 0 && indiceRemover < tarefas.size()) {
                        System.out.println("Tarefa removida: " + tarefas.remove(indiceRemover));
                    } else {
                        System.out.println("Numero de tarefa invalido.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o numero da tarefa que deseja marcar como concluida: ");
                    int indiceConcluir = scanner.nextInt() - 1;
                    if (indiceConcluir >= 0 && indiceConcluir < tarefas.size()) {
                        String tarefaConcluida = tarefas.get(indiceConcluir);
                        System.out.println("Tarefa concluida: " + tarefaConcluida + " ✔");
                    } else {
                        System.out.println("Numero de tarefa invalido.");
                    }
                    break;
                case 4:
                    System.out.println("\nTarefas atuais:");
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println((i + 1) + ". " + tarefas.get(i));
                    }
                    break;
                case 5:
                    System.out.println("Saindo... Nao esquece de fazer suas tarefas!");
                    return;
                default:
                    System.out.println("Opcao invalida, tente novamente.");
            }
        }
    }
}

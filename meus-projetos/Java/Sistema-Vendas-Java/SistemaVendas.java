import java.util.ArrayList; // Importa a classe ArrayList para armazenar listas dinâmicas
import java.util.Scanner; // Importa a classe Scanner para ler entrada do usuário

public class SistemaVendas {
    // Cria uma lista de clientes
    static ArrayList<String> clientes = new ArrayList<>();
    // Cria uma lista que armazena as compras de cada cliente
    static ArrayList<ArrayList<String>> compras = new ArrayList<>();
    // Variável para armazenar o desconto aplicado
    static double desconto = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para ler dados do usuário
        int opcao; // Variável para armazenar a opção escolhida pelo usuário

        // Laço principal do programa
        do {
            // Exibe o menu de opções
            System.out.println("=== Sistema de Vendas ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Ver Lista de Clientes");
            System.out.println("3 - Excluir Cliente");
            System.out.println("4 - Adicionar Compra");
            System.out.println("5 - Excluir Compra");
            System.out.println("6 - Total a Pagar");
            System.out.println("7 - Desconto do Dia");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt(); // Lê a opção escolhida
            scanner.nextLine();  // Limpa o buffer do scanner

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner); // Chama a função para cadastrar cliente
                    break;
                case 2:
                    listarClientes(); // Chama a função para listar clientes
                    break;
                case 3:
                    excluirCliente(scanner); // Chama a função para excluir cliente
                    break;
                case 4:
                    adicionarCompra(scanner); // Chama a função para adicionar compra
                    break;
                case 5:
                    excluirCompra(scanner); // Chama a função para excluir compra
                    break;
                case 6:
                    totalAPagar(scanner); // Chama a função para calcular o total a pagar
                    break;
                case 7:
                    aplicarDesconto(scanner); // Chama a função para aplicar desconto
                    break;
                case 0:
                    System.out.println("Saindo..."); // Mensagem ao sair
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente."); // Mensagem de erro
            }
        } while (opcao != 0); // Continua até que o usuário escolha sair

        scanner.close(); // Fecha o scanner ao final do programa
    }

    // Função para cadastrar cliente
    public static void cadastrarCliente(Scanner scanner) {
        String nome; // Variável para armazenar o nome do cliente
        do {
            System.out.print("Digite o nome do cliente: "); // Solicita o nome do cliente
            nome = scanner.nextLine(); // Lê o nome do cliente
            clientes.add(nome); // Adiciona o nome à lista de clientes
            compras.add(new ArrayList<>());  // Adiciona uma nova lista de compras para o cliente
            System.out.print("Deseja cadastrar outro cliente? (S/N): "); // Pergunta se deseja cadastrar mais
        } while (scanner.nextLine().equalsIgnoreCase("S")); // Repete se a resposta for "S"
    }

    // Função para listar clientes
    public static void listarClientes() {
        // Verifica se a lista de clientes está vazia
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado."); // Mensagem se não houver clientes
        } else {
            // Lista todos os clientes
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println((i + 1) + " - " + clientes.get(i)); // Mostra o número e nome do cliente
            }
        }
    }

    // Função para excluir cliente
    public static void excluirCliente(Scanner scanner) {
        listarClientes(); // Exibe a lista de clientes
        // Verifica se a lista de clientes não está vazia
        if (!clientes.isEmpty()) {
            System.out.print("Digite o numero do cliente a ser excluido: "); // Solicita o número do cliente
            int clienteId = scanner.nextInt() - 1; // Lê o número e ajusta para índice
            // Verifica se o índice é válido
            if (clienteId >= 0 && clienteId < clientes.size()) {
                clientes.remove(clienteId); // Remove o cliente da lista
                compras.remove(clienteId); // Remove as compras do cliente
                System.out.println("Cliente removido com sucesso."); // Mensagem de sucesso
            } else {
                System.out.println("Cliente invalido."); // Mensagem de erro
            }
        }
    }

    // Função para adicionar compra
    public static void adicionarCompra(Scanner scanner) {
        listarClientes(); // Exibe a lista de clientes
        // Verifica se a lista de clientes não está vazia
        if (!clientes.isEmpty()) {
            System.out.print("Digite o numero do cliente que deseja adicionar compras: "); // Solicita o número do cliente
            int clienteId = scanner.nextInt() - 1; // Lê o número e ajusta para índice
            scanner.nextLine(); // Limpa o buffer
            // Verifica se o índice é válido
            if (clienteId >= 0 && clienteId < clientes.size()) {
                String produto; // Variável para armazenar o produto
                do {
                    // Exibe a lista de produtos disponíveis
                    System.out.println("Lista de produtos disponiveis:");
                    System.out.println("1 - Blusa Masculina (R$ 20,00)");
                    System.out.println("2 - Blusa Feminina (R$ 20,00)");
                    System.out.println("3 - Short Masculino (R$ 30,00)");
                    System.out.println("4 - Short Feminino (R$ 30,00)");
                    System.out.println("5 - Boné Masculino (R$ 10,30)");
                    System.out.println("6 - Celular (R$ 4.500,00)");
                    System.out.println("7 - Computador (R$ 5.550,00)");
                    System.out.println("8 - Fone de Ouvido (R$ 550,00)");
                    System.out.print("Escolha o produto para adicionar (ou 0 para sair): "); // Solicita escolha do produto
                    int produtoId = scanner.nextInt(); // Lê a escolha do produto
                    switch (produtoId) {
                        case 1:
                            produto = "Blusa Masculina (R$ 20,00)"; // Adiciona blusa masculina
                            compras.get(clienteId).add(produto); // Adiciona à lista de compras do cliente
                            break;
                        case 2:
                            produto = "Blusa Feminina (R$ 20,00)"; // Adiciona blusa feminina
                            compras.get(clienteId).add(produto); // Adiciona à lista de compras do cliente
                            break;
                        case 3:
                            produto = "Short Masculino (R$ 30,00)"; // Adiciona short masculino
                            compras.get(clienteId).add(produto); // Adiciona à lista de compras do cliente
                            break;
                        case 4:
                            produto = "Short Feminino (R$ 30,00)"; // Adiciona short feminino
                            compras.get(clienteId).add(produto); // Adiciona à lista de compras do cliente
                            break;
                        case 5:
                            produto = "Bone (R$ 10,30)"; // Adiciona boné masculino
                            compras.get(clienteId).add(produto); // Adiciona à lista de compras do cliente
                            break;
                        case 6:
                            produto = "Celular (R$ 4.500,00)"; // Adiciona celular
                            compras.get(clienteId).add(produto); // Adiciona à lista de compras do cliente
                            break;
                        case 7:
                            produto = "Computador (R$ 5.550,00)"; // Adiciona computador
                            compras.get(clienteId).add(produto); // Adiciona à lista de compras do cliente
                            break;
                        case 8:
                            produto = "Fone de Ouvido (R$ 550,00)"; // Adiciona fone de ouvido
                            compras.get(clienteId).add(produto); // Adiciona à lista de compras do cliente
                            break;
                        case 0:
                            return; // Sai da função se 0 for escolhido
                        default:
                            System.out.println("Produto invalido."); // Mensagem de erro
                    }
                    System.out.print("Deseja adicionar outro produto? (S/N): "); // Pergunta se deseja adicionar mais produtos
                } while (scanner.next().equalsIgnoreCase("S")); // Repete se a resposta for "S"
            } else {
                System.out.println("Cliente invalido."); // Mensagem de erro
            }
        }
    }

    // Função para excluir compra
    public static void excluirCompra(Scanner scanner) {
        listarClientes(); // Exibe a lista de clientes
        // Verifica se a lista de clientes não está vazia
        if (!clientes.isEmpty()) {
            System.out.print("Digite o numero do cliente que deseja excluir compras: "); // Solicita o número do cliente
            int clienteId = scanner.nextInt() - 1; // Lê o número e ajusta para índice
            scanner.nextLine(); // Limpa o buffer
            // Verifica se o índice é válido
            if (clienteId >= 0 && clienteId < clientes.size()) {
                // Lista as compras do cliente
                ArrayList<String> comprasCliente = compras.get(clienteId); // Obtém a lista de compras do cliente
                if (comprasCliente.isEmpty()) {
                    System.out.println("Nenhuma compra registrada para este cliente."); // Mensagem se não houver compras
                } else {
                    // Exibe as compras do cliente
                    for (int i = 0; i < comprasCliente.size(); i++) {
                        System.out.println((i + 1) + " - " + comprasCliente.get(i)); // Mostra as compras
                    }
                    System.out.print("Digite o numero da compra a ser excluida: "); // Solicita o número da compra
                    int compraId = scanner.nextInt() - 1; // Lê o número e ajusta para índice
                    // Verifica se o índice é válido
                    if (compraId >= 0 && compraId < comprasCliente.size()) {
                        comprasCliente.remove(compraId); // Remove a compra da lista
                        System.out.println("Compra removida com sucesso."); // Mensagem de sucesso
                    } else {
                        System.out.println("Compra invalida."); // Mensagem de erro
                    }
                }
            } else {
                System.out.println("Cliente invalido."); // Mensagem de erro
            }
        }
    }

    // Função para calcular total a pagar
    public static void totalAPagar(Scanner scanner) {
        listarClientes(); // Exibe a lista de clientes
        // Verifica se a lista de clientes não está vazia
        if (!clientes.isEmpty()) {
            System.out.print("Digite o numero do cliente para calcular total: "); // Solicita o número do cliente
            int clienteId = scanner.nextInt() - 1; // Lê o número e ajusta para índice
            scanner.nextLine(); // Limpa o buffer
            // Verifica se o índice é válido
            if (clienteId >= 0 && clienteId < clientes.size()) {
                ArrayList<String> comprasCliente = compras.get(clienteId); // Obtém a lista de compras do cliente
                double total = 0; // Inicializa o total
                for (String compra : comprasCliente) {
                    // Soma os preços das compras
                    if (compra.contains("Blusa Masculina") || compra.contains("Blusa Feminina")) {
                        total += 20.00; // Preço da blusa
                    } else if (compra.contains("Short Masculino") || compra.contains("Short Feminino")) {
                        total += 30.00; // Preço do short
                    } else if (compra.contains("Bone")) {
                        total += 10.30; // Preço do boné
                    } else if (compra.contains("Celular")) {
                        total += 4500.00; // Preço do celular
                    } else if (compra.contains("Computador")) {
                        total += 5550.00; // Preço do computador
                    } else if (compra.contains("Fone de Ouvido")) {
                        total += 550.00; // Preço do fone de ouvido
                    }
                }
                total -= desconto; // Aplica o desconto no total
                System.out.println("Total a pagar: R$ " + total); // Exibe o total
            } else {
                System.out.println("Cliente invalido."); // Mensagem de erro
            }
        }
    }

    // Função para aplicar desconto
    public static void aplicarDesconto(Scanner scanner) {
        System.out.print("Digite o valor do desconto a ser aplicado: R$ "); // Solicita o valor do desconto
        desconto = scanner.nextDouble(); // Lê o desconto
        System.out.println("Desconto aplicado: R$ " + desconto); // Mensagem de confirmação
    }
}
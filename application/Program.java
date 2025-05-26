package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Estoque;
import model.entities.Produto;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Listar todos os produtos");
            System.out.println("3. Buscar produto por ID");
            System.out.println("4. Atualizar produto");
            System.out.println("5. Remover produto");
            System.out.println("6. Adicionar quantidade ao estoque");
            System.out.println("7. Remover quantidade do estoque");
            System.out.println("0. Sair");
            System.out.print("Digite sua opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto(sc, estoque);
                    break;
                case 2:
                    estoque.listarProdutos();
                    break;
                case 3:
                    buscarProduto(sc, estoque);
                    break;
                case 4:
                    atualizarProduto(sc, estoque);
                    break;
                case 5:
                    removerProduto(sc, estoque);
                    break;
                case 6:
                    adicionarEstoque(sc, estoque);
                    break;
                case 7:
                    removerEstoque(sc, estoque);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    // Função para cadastrar um novo produto no estoque
    private static void cadastrarProduto(Scanner sc, Estoque estoque) {
        System.out.println("\n--- CADASTRO DE PRODUTO ---");
        System.out.print("ID: ");
        int id = sc.nextInt(); 
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine(); 

        System.out.print("Preço: ");
        double preco = sc.nextDouble(); 

        System.out.print("Quantidade inicial: ");
        int quantidade = sc.nextInt(); 
        sc.nextLine();

        // Cria um novo objeto Produto com os dados fornecidos
        Produto novoProduto = new Produto(id, nome, preco, quantidade);

        // Adiciona o produto ao estoque
        estoque.adicionarProduto(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Função para buscar um produto no estoque pelo ID
    private static void buscarProduto(Scanner sc, Estoque estoque) {
        System.out.print("\nDigite o ID do produto: ");
        int id = sc.nextInt(); 
        sc.nextLine();

        // Busca o produto no estoque
        Produto produto = estoque.buscarProdutoPorId(id);
        if (produto != null) {
            // Exibe os detalhes do produto encontrado
            System.out.println("\n--- PRODUTO ENCONTRADO ---");
            System.out.println("ID: " + produto.getId() +
            " | Nome: " + produto.getNome() +
            " | Preço: R$" + String.format("%.2f", produto.getPreco()) +
            " | Estoque: " + produto.getQuantidadeEmEstoque());
        } else {
            // Mensagem caso o produto não seja encontrado
            System.out.println("Produto não encontrado!");
        }
    }

    // Função para atualizar o preço e a quantidade de um produto no estoque
    private static void atualizarProduto(Scanner sc, Estoque estoque) {
        System.out.print("\nDigite o ID do produto a atualizar: ");
        int id = sc.nextInt(); 
        sc.nextLine();

        System.out.print("Novo preço: ");
        double preco = sc.nextDouble(); 

        System.out.print("Nova quantidade: ");
        int quantidade = sc.nextInt(); 
        sc.nextLine();

        // Atualiza o produto no estoque com os novos valores
        estoque.atualizarProduto(id, preco, quantidade);
    }

    // Função para remover um produto do estoque pelo ID
    private static void removerProduto(Scanner sc, Estoque estoque) {
        System.out.print("\nDigite o ID do produto a remover: ");
        int id = sc.nextInt(); 
        sc.nextLine();

        // Remove o produto do estoque
        estoque.removerProduto(id);
    }

    // Função para adicionar uma quantidade ao estoque de um produto
    private static void adicionarEstoque(Scanner sc, Estoque estoque) {
        System.out.print("\nDigite o ID do produto: ");
        int id = sc.nextInt(); 

        System.out.print("Quantidade a adicionar: ");
        int quantidade = sc.nextInt(); 
        sc.nextLine();

        // Adiciona a quantidade ao estoque do produto
        estoque.adicionarEstoque(id, quantidade);
    }

    // Função para remover uma quantidade do estoque de um produto
    private static void removerEstoque(Scanner sc, Estoque estoque) {
        System.out.print("\nDigite o ID do produto: ");
        int id = sc.nextInt(); 

        System.out.print("Quantidade a remover: ");
        int quantidade = sc.nextInt(); 
        sc.nextLine();

        // Remove a quantidade do estoque do produto
        estoque.removerEstoque(id, quantidade);
    }
}

package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Adiciona um novo produto ao estoque
    public void adicionarProduto(Produto produto) {
        // Verifica se já existe um produto com o mesmo ID
        if (buscarProdutoPorId(produto.getId()) != null) {
            System.out.println("Já existe um produto com esse id!");
            return;
        }
        // Adiciona o produto à lista
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso! ");
    }

    // Busca um produto pelo ID
    public Produto buscarProdutoPorId(int id) {
        // Percorre a lista de produtos para encontrar o produto com o ID especificado
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto; // Retorna o produto encontrado
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

    // Atualiza os dados de um produto existente
    public void atualizarProduto(int id, double novoPreco, int novaQuantidade) {
        // Busca o produto pelo ID
        Produto produto = buscarProdutoPorId(id);
        if (produto != null) {
            // Atualiza o preço e a quantidade do produto
            produto.setPreco(novoPreco);
            produto.setQuantidadeEmEstoque(novaQuantidade);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto nao encontrado!");
        }
    }

    // Remove um produto do estoque
    public void removerProduto(int id) {
        // Busca o produto pelo ID
        Produto produto = buscarProdutoPorId(id);
        if (produto != null) {
            // Remove o produto da lista
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // Lista todos os produtos cadastrados no estoque
    public void listarProdutos() {
        // Verifica se a lista de produtos está vazia
        if (produtos.isEmpty()) {
            System.out.println("Nenhum Produto cadastrado!");
            return;
        }
        // Exibe os detalhes de cada produto na lista
        System.out.println("LISTA DE PRODUTOS");
        for (Produto p : produtos) {
            System.out.println("ID: " + p.getId() +
                    " | Nome: " + p.getNome() +
                    " | Preço: R$ " + String.format("%.2f", p.getPreco()) +
                    " | Estoque: " + p.getQuantidadeEmEstoque());
        }
        System.out.println();
    }

    // Adiciona uma quantidade ao estoque de um produto
    public void adicionarEstoque(int id, int quantidade) {
        // Busca o produto pelo ID
        Produto produto = buscarProdutoPorId(id);
        if (produto != null) {
            // Adiciona a quantidade ao estoque do produto
            produto.adicionarEstoque(quantidade);
            System.out.println("Estoque atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // Remove uma quantidade do estoque de um produto
    public void removerEstoque(int id, int quantidade) {
        // Busca o produto pelo ID
        Produto produto = buscarProdutoPorId(id);
        if (produto != null) {
            // Verifica se há quantidade suficiente no estoque
            if (produto.getQuantidadeEmEstoque() >= quantidade) {
                // Remove a quantidade do estoque do produto
                produto.removerEstoque(quantidade);
                System.out.println("Estoque atualizado com sucesso!");
            } else {
                System.out.println("Quantidade insuficiente em estoque!");
            }
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}

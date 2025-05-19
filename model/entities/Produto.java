package model.entities;

public class Produto {
    
    private int id;
    private String nome;
    private Double preco;
    private int quantidadeEmEstoque;

    public Produto(){

    }

    public Produto(int id, String nome, Double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // Método para adicionar uma quantidade ao estoque do produto
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) { // Verifica se a quantidade é válida
            quantidadeEmEstoque += quantidade; // Adiciona a quantidade ao estoque
            System.out.println(quantidade + " unidades adicionadas ao estoque do produto " + nome);
        } else {
            System.out.println("Quantidade inválida!"); // Mensagem de erro para quantidade inválida
        }
    }

    // Método para remover uma quantidade do estoque do produto
    public void removerEstoque(int quantidade) {
        if (quantidade > 0) { // Verifica se a quantidade é válida
            if (quantidadeEmEstoque >= quantidade) { // Verifica se há estoque suficiente
                quantidadeEmEstoque -= quantidade; // Remove a quantidade do estoque
                System.out.println(quantidade + " unidades removidas do estoque do produto " + this.nome);
            } else {
                System.out.println("Quantidade insuficiente em estoque!"); // Mensagem de erro para estoque insuficiente
            }
        } else {
            System.out.println("Quantidade inválida para remover!"); // Mensagem de erro para quantidade inválida
        }
    }

    // Método sobrescrito para exibir os detalhes do produto como uma string
    @Override
    public String toString() {
        return "ID: " +
                id +
                " | Nome: " +
                nome +
                " | Preço: R$ " +
                String.format("%.2f", preco) +
                " | Quantidade em estoque: " +
                quantidadeEmEstoque;
    }
}

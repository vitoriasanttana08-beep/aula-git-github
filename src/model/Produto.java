package model;

public class Produto {
    private int codigo;
    private String nome;
    private double valor;
    private int quantidadeEmEstoque;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto(int codigo, String nome, double valor, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto() {
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void exibirDados() {
        System.out.println("\n--- Dados do produto ---");
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
    }

    public void adicionarEstoque(int quantidade) {
        quantidadeEmEstoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        quantidadeEmEstoque -= quantidade;
    }

    @Override
    public String toString() {
        return nome;
    }
}
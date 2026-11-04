import java.util.ArrayList;
import java.util.Scanner;

import model.Produto;

public class Cadastro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        
        int opcao;

        do {
            System.out.println("======== Cadastro de Produto ========");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Ver dados do produto");
            System.out.println("3 - Adicionar quantidade ao estoque");
            System.out.println("4 - Remover quantidade do estoque");
            System.out.println("5 - Buscar produto");
            System.out.println("6 - Alterar produto");
            System.out.println("7 - Remover produto");
            System.out.println("8 - Relatório de estoque");
            System.out.println("0 - Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto(sc, produtos);
                    break;
                case 2:
                    listarProdutos(produtos);
                    break;
                case 3:
                    adicionarQuantidadeEstoque(sc, produtos);
                    break;
                case 4:
                    removerQuantidadeEstoque(sc, produtos);
                    break;
                case 5:
                    buscarProduto(sc, produtos);
                    break;
                case 6:
                    alterarProduto(sc, produtos);
                    break;
                case 7:
                    removerProduto(sc, produtos);
                    break;
                case 8:
                    gerarRelatorioEstoque(produtos);
                    break;
                case 0: System.out.println("Programa encerrado.");
                break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            } while (opcao != 0);
            
            sc.close();
        }

        private static void cadastrarProduto(Scanner sc, ArrayList<Produto> produtos) {
            int codigo;
            boolean codigoExiste;
            do {
                System.out.print("Código: ");
                codigo = sc.nextInt();

                codigoExiste = buscarProdutoPorCodigo(produtos, codigo) != null;

                if (codigo <= 0) {
                    System.out.println("Código inválido!");
                } else if (codigoExiste) {
                    System.out.println("Este código já está cadastrado!");
                }
            } while (codigo <= 0 || codigoExiste);

            sc.nextLine();

            String nome;
            do {
                System.out.print(Nome: );
                nome = sc.nextLine();

                if (nome.isBlank()) {
                    System.out.println("Nome vazio! Digite novamente.");
                }
            } while (nome.isBlank());

            double valor;
            do {
                System.out.print("Valor: ");
                valor = sc.nextDouble();

                if (valor <= 0) {
                    System.out.println("Valor inválido! O valor não pode ser zero e nem negativo. Tente novamente. ");
                }
            } while (valor <= 0);
        }
           
                    int codigo;
                    do{
                        System.out.print("Código: ");
                    codigo = sc.nextInt();
                    if (codigo <=0) {
                        System.out.print("Código inválido. Digite o código novamente: ");
                        } 
                    codigo = sc.nextInt();
                    }while (codigo <= 0); 

                    sc.nextLine();

                    String nome;
                    do{
                        System.out.print("Nome: ");
                    nome = sc.nextLine();
                    if (nome.isEmpty()) {
                         System.out.print("Nome inválido. Digite o nome novamente: ");
                    }
                    }while (nome.isEmpty());

                    sc.nextLine();
                    
                    double valor;
                    do{
                    System.out.print("Valor: ");
                    valor = sc.nextDouble();
                    if (valor < 0 ) {
                        System.out.print("Valor inválido. Digite o valor novamente: ");
                    }
                    }while (valor < 0);

                    sc.nextLine();

                    int quantidade;
                    do{
                    System.out.print("Quantidade inicial em estoque: ");
                    quantidade = sc.nextInt();
                    if (quantidade < 0 ) {
                        System.out.print("Quantidade inválido. Digite a quantidade novamente: ");
                    }
                    }while (quantidade < 0);

                    sc.nextLine();

                    Produto produto = new Produto(codigo, nome, valor, quantidade);
                    produtos.add(produto);
                    System.out.println("Produto cadastrado com sucesso.");

                    if (codigo <=0) {
                        System.out.println("Código inválido.");
                        System.out.print("Digte o código novamente: ");
                    }

                    break;
                case 2:
                    if (produtos.isEmpty()) {
                        System.out.println("Não há produtos cadastrados");
                    }else{
                          for (Produto p : produtos) {
                            System.out.println("===== PRODUTOS CADASTRADOS =====");
                            p.exibirDados();
                            System.out.println("--------------------------------");
                          }
                    }
                    break;
                case 3:
                    System.out.println("===== ADICIONAR QUANTIDADE =====");
                    System.out.println("Qual o código do Produto: ");
                    int codigoProduto = sc.nextInt();

                    Produto produtoAdicionar = new Produto();

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoProduto) {
                            produtoAdicionar = p;
                            break;
                        }
                    }

                    if (produtoAdicionar == null) {
                        System.out.println("Produto não encontrado!");
                    }else{
                         System.out.print("Quantidade para adicionar: ");
                         int quantidadeAdicionar = sc.nextInt();

                         produtoAdicionar.adicionarEstoque(quantidadeAdicionar);
                         System.out.println("Estoque atualizado com sucesso.");
                    }
                    break;
                case 4:
                    System.out.println("===== REMOVER QUANTIDADE =====");
                    System.out.println("Qual o código do Produto: ");
                    int codigoProdutoRemover = sc.nextInt();

                    Produto produtoRemover = new Produto();

                    for (Produto p : produtos) {
                        if (p.getCodigo() == codigoProdutoRemover) {
                            produtoRemover = p;
                            break;
                        }
                    }

                    if (produtoRemover == null) {
                        System.out.println("Produto não encontrado!");
                    }else{
                         System.out.print("Quantidade para adicionar: ");
                         int quantidadeRemover = sc.nextInt();

                         produtoRemover.removerEstoque(quantidadeRemover);
                         System.out.println("Estoque atualizado com sucesso.");
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
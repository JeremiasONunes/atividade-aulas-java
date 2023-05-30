package vierws;

import java.util.Scanner;

import Models.Produto;
import services.GerenciadorProdutos;

public class Programa {
    private GerenciadorProdutos gerenciador;
    private Scanner scanner;

    public Programa() {
        gerenciador = new GerenciadorProdutos();
        scanner = new Scanner(System.in);
    }

    public void executar() {
        boolean executar = true;

        while (executar) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    removerProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    encerrarPrograma();
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("===== Menu =====");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Listar produtos");
        System.out.println("4. Encerrar programa");
        System.out.println("================");
    }

    private int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    private void adicionarProduto() {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        Produto produto = new Produto(id, nome, preco);
        gerenciador.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void removerProduto() {
        System.out.print("Digite o ID do produto a ser removido: ");
        int id = scanner.nextInt();

        boolean produtoRemovido = gerenciador.removerProduto(id);

        if (produtoRemovido) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void listarProdutos() {
        gerenciador.listarProdutos();
    }

    private void encerrarPrograma() {
        System.out.println("Encerrando o programa. Até logo!");
    }
}

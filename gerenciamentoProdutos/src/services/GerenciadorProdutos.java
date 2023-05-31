package services;

import java.util.ArrayList;
import java.util.List;

import Models.Produto;

public class GerenciadorProdutos {
    private List<Produto> produtos;

    public GerenciadorProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public boolean removerProduto(int id) {
        Produto produtoRemover = null;
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtoRemover = produto;
                break;
            }
        }
        if (produtoRemover != null) {
            produtos.remove(produtoRemover);
        }
		return false;
    }

    public String listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.println("Produtos cadastrados:");
            for (Produto produto : produtos) {
                System.out.println("ID: " + produto.getId() + " | Nome: " + produto.getNome() + " | Preço: " + produto.getPreco());
            }
        }
		return null;
    }
}

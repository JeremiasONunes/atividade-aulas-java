package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Produto;

public class Programa {
    private java.util.List<Produto> produtos;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton adicionarButton;
    private JButton removerButton;
    private JButton listarButton;
    private JButton encerrarButton;

    public Programa() {
        produtos = new java.util.ArrayList<>();
        frame = new JFrame("Gerenciador de Produtos");
        panel = new JPanel();
        label = new JLabel("Selecione uma opção:");
        adicionarButton = new JButton("Adicionar produto");
        removerButton = new JButton("Remover produto");
        listarButton = new JButton("Listar produtos");
        encerrarButton = new JButton("Encerrar programa");
    }

    public void executar() {
        configurarInterface();
        adicionarListeners();
        exibirInterface();
    }

    private void configurarInterface() {
        panel.setLayout(new GridLayout(5, 1));
        panel.add(label);
        panel.add(adicionarButton);
        panel.add(removerButton);
        panel.add(listarButton);
        panel.add(encerrarButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(panel);
    }

    private void adicionarListeners() {
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProduto();
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        encerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarPrograma();
            }
        });
    }

    private void exibirInterface() {
        frame.setVisible(true);
    }

    private void adicionarProduto() {
        
        String nome = JOptionPane.showInputDialog(frame, "Digite o nome do produto:", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);

        String precoInput = JOptionPane.showInputDialog(frame, "Digite o preço do produto:", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);
        double preco = Double.parseDouble(precoInput);

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);
        JOptionPane.showMessageDialog(frame, "Produto adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void removerProduto() {
        String idInput = JOptionPane.showInputDialog(frame, "Digite o ID do produto a ser removido:", "Remover Produto", JOptionPane.QUESTION_MESSAGE);
        int id = Integer.parseInt(idInput);

        boolean produtoRemovido = false;
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                produtoRemovido = true;
                break;
            }
        }

        if (produtoRemovido) {
            JOptionPane.showMessageDialog(frame, "Produto removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarProdutos() {
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Não há produtos cadastrados.", "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder listaProdutos = new StringBuilder();
            listaProdutos.append("Produtos cadastrados:\n");
            for (Produto produto : produtos) {
                listaProdutos.append("ID: ").append(produto.getId()).append(" | Nome: ").append(produto.getNome()).append(" | Preço: ").append(produto.getPreco()).append("\n");
            }

            JFrame listaFrame = new JFrame("Lista de Produtos");
            JTextArea listaTextArea = new JTextArea(listaProdutos.toString());
            listaTextArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(listaTextArea);
            listaFrame.add(scrollPane);
            listaFrame.setSize(300, 200);
            listaFrame.setVisible(true);
        }
    }

    private void encerrarPrograma() {
        JOptionPane.showMessageDialog(frame, "Encerrando o programa. Até logo!", "Encerramento", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        Programa programa = new Programa();
        programa.executar();
    }
}
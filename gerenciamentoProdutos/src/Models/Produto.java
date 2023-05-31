package Models;

public class Produto {
    private static int contador = 1;
    private int id;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.id = contador++;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

	public void setId(int id) {
		this.id = id;
	}

	

	
}

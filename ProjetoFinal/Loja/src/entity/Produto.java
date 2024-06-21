package entity;

import java.util.ArrayList;
import java.util.List;

//Produtos serão roupas
public class Produto extends Entity{
    private String tipo; //vestido, blusa, calça, saia, short etc.
    private int quantidadeEstoque; //Quantidade daquela peça
    private double preco; //Valor do produto
    private String material;

   public Produto(String tipo, int quantidadeEstoque, double preco, String material)
    {
        this.tipo = tipo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
        this.material = material;
    }

    public String getTipo()
    {
        return this.tipo;
    }

    public int getQuantidadeEstoque()
    {
        return this.quantidadeEstoque;
    }

    public double getPreco()
    {
        return this.preco;
    }

    public String getMaterial()
    {
        return this.material;
    }


    public void setQuantidadeEstoque(int quantidadeEstoque)
    {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }

}

package entity;

public class Item extends Entity{
    private Produto produto;
    private int quantidade;

    public Item(Produto produto, int quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Item()
    {
        this.produto = null;
        this.quantidade = 0;
    }

    public void setProduto(Produto produto)
    {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public Produto getProduto()
    {
        return produto;
    }

    public int getQuantidade()
    {
        return quantidade;
    }
}

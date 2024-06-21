package entity;

//extend usuario

public class Cliente extends Usuario{
    private Endereco endereco;
    private Pedido pedido;

   public Cliente(String nome, String sobrenome, String email, String senha, Endereco endereco, Pedido pedido)
    {
        super(nome, sobrenome, email, senha);

        this.endereco = endereco;
        this.pedido = pedido != null ? pedido : new Pedido();
    }

    public Cliente()
    {
        super("", "", "", "");
        this.endereco = null;
        this.pedido = new Pedido();
    }

    public String getEstado()
    {
        return endereco.getEstado();
    }

    public String getCidade()
    {
        return endereco.getCidade();
    }

    public String getRua()
    {
        return endereco.getRua();
    }

    public int getNumero()
    {
        return endereco.getNumero();
    }

    public Pedido getPedido()
    {
        return this.pedido;
    }

    public void setPedido(Pedido pedido)
    {
        this.pedido = pedido;
    }


}

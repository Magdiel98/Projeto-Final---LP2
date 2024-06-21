package entity;

public class Endereco extends Entity{
    private String estado;
    private String cidade;
    private String rua;
    private int numero;

    public Endereco(String estado, String cidade, String rua, int numero)
    {
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

    public String getEstado()
    {
        return this.estado;
    }

    public String getCidade()
    {
        return this.cidade;
    }

    public String getRua()
    {
        return this.rua;
    }

    public int getNumero()
    {
        return this.numero;
    }
}

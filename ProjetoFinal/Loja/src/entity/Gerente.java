package entity;
//Responsável por comprar produtos dos fornecedores, pagar algumas contas, funcionários etc

public class Gerente extends Usuario{

    public Gerente()
    {
        super("João", "Costa Silva", "joaosilva@gmail.com", "joao123");
    }

    @Override
    public String toString()
    {
        return this.nome + '\n' + this.sobrenome + '\n' + this.email;
    }
}

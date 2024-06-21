package service;

import dao.ClienteDAO;
import entity.Cliente;
import entity.Endereco;
import entity.Pedido;

import java.util.Collection;

public class ClienteService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    private String email;

    private Endereco endereco1 = new Endereco("RN", "Natal", "Avenida Senador Salgado Filho", 2007);
    private Pedido pedido1 = new Pedido();
    private Cliente cliente1 = new Cliente("José", "da Silva Pereira", "josepereira@gmail.com", "jose123", endereco1, pedido1);


    private Endereco endereco2 = new Endereco("PB", "João Pessoa", "Avenida Presidente Getúlio Vargas", 371);
    private Pedido pedido2 = new Pedido();
    private Cliente cliente2 = new Cliente("Ana", "Costa Santos", "anasantos@gmail.com", "ana123", endereco2, pedido2);


    private Endereco endereco3 = new Endereco("PE", "Recife", "Avenida Conde da Boa Vista", 312);
    private Pedido pedido3 = new Pedido();
    private Cliente cliente3 = new Cliente("Patrícia", "Lima Martins", "patriciamartins@gmail.com", "patricia123", endereco3, pedido3);


    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void salvar()
    {
        try
        {
           clienteDAO.save(cliente1);
           clienteDAO.save(cliente2);
           clienteDAO.save(cliente3);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean login(String email, String senha)
    {
        try {
            Collection<Cliente> clientes = clienteDAO.findAll();
            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public void mostrarDados()
    {
        try{
            Collection<Cliente> clientes = clienteDAO.findAll();
            for(Cliente cliente : clientes)
            {
                if(cliente.getEmail().equalsIgnoreCase(this.email))
                {
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Sobrenome: " + cliente.getSobrenome());
                    System.out.println("E-mail: " + cliente.getEmail());
                    System.out.println("Estado: " + cliente.getEstado());
                    System.out.println("Cidade: " + cliente.getCidade());
                    System.out.println("Rua: " + cliente.getRua());
                    System.out.println("Número: "+ cliente.getNumero());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

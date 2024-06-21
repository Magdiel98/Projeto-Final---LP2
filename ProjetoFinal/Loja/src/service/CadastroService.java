package service;

import dao.ClienteDAO;
import entity.Cliente;
import entity.Endereco;
import entity.Pedido;

public class CadastroService {
    private ClienteDAO clienteDAO = new ClienteDAO();

    private Cliente cliente;

    private Endereco endereco;

    private Pedido pedido = new Pedido();


    public void cadastrar(String nome, String sobrenome, String email, String senha, String estado, String cidade, String rua, int numero)
    {
        endereco = new Endereco(estado, cidade, rua, numero);
        cliente = new Cliente(nome, sobrenome, email, senha, endereco, pedido);
        try{
            clienteDAO.save(cliente);
        }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
}

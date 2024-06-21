package service;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import entity.Cliente;
import entity.Item;
import entity.Pedido;
import entity.Produto;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PedidoService {

    ClienteDAO clienteDAO = new ClienteDAO();
    ProdutoDAO produtoDAO = new ProdutoDAO();


    public void pedido(String email, int opcao, int quantidade)
    {
        try {
            Collection<Cliente> clientes = clienteDAO.findAll();
            Collection<Produto> produtos = produtoDAO.findAll();
            for(Cliente cliente : clientes)
            {
                if(cliente.getEmail().equalsIgnoreCase(email));
                {
                    for(Produto produto : produtos)
                    {
                        if(produto.getId() == opcao)
                        {
                            if(cliente.getPedido() == null)
                            {
                                cliente.setPedido(new Pedido());
                            }

                            if(cliente.getPedido().getItems() == null)
                            {
                                cliente.getPedido().setItems(new ArrayList<>());
                            }

                            Item item = new Item();

                            item.setProduto(produto);
                            item.setQuantidade(quantidade);
                            cliente.getPedido().getItems().add(item);


                            break;
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void mostrarPedidos(String email)
    {
        try
        {
            Collection<Cliente> clientes = clienteDAO.findAll();
            for(Cliente cliente : clientes)
            {
                if(cliente.getEmail().equalsIgnoreCase(email))
                {
                   if(cliente.getPedido() != null && cliente.getPedido().getItems() != null && !cliente.getPedido().getItems().isEmpty())
                   {
                       for(Item item : cliente.getPedido().getItems())
                       {
                           Produto produto = item.getProduto();
                           System.out.println("Produto: " + produto.getTipo() +
                                             "\nQuantidade: " + item.getQuantidade() +
                                              "\nPreço: " + produto.getPreco() + "\n");
                       }
                   }else
                   {
                       System.out.println("Nenhum pedido encontrado");
                   }
                   return;
                }
            }
        }
        catch (Exception e)
        {

        }
    }




}

package service;

import dao.ProdutoDAO;
import entity.Produto;

import java.util.Collection;
import java.util.Iterator;

public class AtualizarProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void atualizaquantidade(int id, int quantidade)
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();
            Iterator<Produto> iterator = produtos.iterator();

            while(iterator.hasNext()){
                Produto produto = iterator.next();
                if(produto.getId() == id)
                {
                    produto.setQuantidadeEstoque(quantidade);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void atualizapreco(int id, double preco)
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();
            Iterator<Produto> iterator = produtos.iterator();

            while(iterator.hasNext()){
                Produto produto = iterator.next();
                if(produto.getId() == id)
                {
                    produto.setPreco(preco);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void atualizamaterial(int id, String material)
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();
            Iterator<Produto> iterator = produtos.iterator();

            while(iterator.hasNext()){
                Produto produto = iterator.next();
                if(produto.getId() == id)
                {
                    produto.setMaterial(material);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

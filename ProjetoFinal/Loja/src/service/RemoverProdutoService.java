package service;

import dao.ProdutoDAO;
import entity.Produto;

import java.util.Collection;
import java.util.Iterator;

public class RemoverProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    public void remover(int opcao)
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();
            Iterator<Produto> iterator = produtos.iterator();
            Produto produtoRemover = null;

            while(iterator.hasNext()){
                Produto produto = iterator.next();
                if(produto.getId() == opcao)
                {
                    produtoRemover = produto;
                    break;
                }
            }

            if(produtoRemover != null)
            {
                produtoDAO.delete(opcao);
                System.out.println("Produto Removido!");
            }
            else{
                System.out.println("Produto não encontrado!");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public void atualizarIds()
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();

            int id = 1;

            for(Produto produto: produtos)
            {
                produto.setId(id);
                id++;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}

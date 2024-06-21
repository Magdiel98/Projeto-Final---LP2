package service;

import dao.ProdutoDAO;
import entity.Produto;

public class AdicionarProdutoService {

    private Produto produto;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void salvar(String tipo, int quantidade, double preco, String material)
    {
        try {
            produto = new Produto(tipo, quantidade, preco, material);
            produtoDAO.save(produto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

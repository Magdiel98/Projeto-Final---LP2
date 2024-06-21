package service;

import dao.ProdutoDAO;
import entity.Produto;
import exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ProdutoService {
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    private Produto produto;
    private Produto produto1 = new Produto("Vestido", 100, 95.90, "Seda");
    private Produto produto2 = new Produto("Blusa", 200, 56.46, "Algodão");
    private Produto produto3 = new Produto("Saia", 150, 82.95, "Linho");
    private Produto produto4 = new Produto("Casaco", 300, 44.76, "Lã");


    public void salvar()
    {
        try {
            produtoDAO.save(produto1);
            produtoDAO.save(produto2);
            produtoDAO.save(produto3);
            produtoDAO.save(produto4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarProdutos()
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();

            for(Produto produto : produtos)
            {
                System.out.println(produto.getId() + " - " + produto.getTipo());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void especificarProduto(int opcao)
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();

            for(Produto produto : produtos)
            {
                if(produto.getId() == opcao)
                {
                    System.out.println(produto.getTipo());
                    System.out.println("Quantidade: " + produto.getQuantidadeEstoque());
                    System.out.println("Preço: R$" + produto.getPreco());
                    System.out.println("Material: " + produto.getMaterial());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void especificarProdutoNumero(int opcao)
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();

            for(Produto produto : produtos)
            {
                if(produto.getId() == opcao)
                {
                    System.out.println(produto.getTipo());
                    System.out.println("1 - Quantidade: " + produto.getQuantidadeEstoque());
                    System.out.println("2 - Preço: R$" + produto.getPreco());
                    System.out.println("3 - Material: " + produto.getMaterial());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    //Adicionar Produtos
    public void adicionarProduto(String tipo, int quantidade, double preco, String material)
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



    //Atualizar Produtos
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



    //Remover
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



    public void filtrarProdutoPorTipo(String tipo) throws ProductNotFoundException
    {
        try {
            Collection<Produto> produtos = produtoDAO.findAll();
            List<Produto> produtosFiltrados = new ArrayList<>();

            for (Produto produto : produtos) {
                if (produto.getTipo().toLowerCase().contains(tipo.toLowerCase())) {
                    produtosFiltrados.add(produto);
                }
            }

            if (produtosFiltrados.isEmpty()) {
                throw new ProductNotFoundException("Nenhum produto encontrado com o tipo: " + tipo);
            } else {
                for (Produto produto : produtosFiltrados) {
                    exibirDetalhesProduto(produto);
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
            throw new ProductNotFoundException("Erro ao buscar produtos por tipo");
        }
    }

    public void filtrarProdutoPorMaterial(String material) throws ProductNotFoundException
    {
        try {
            Collection<Produto> produtos = produtoDAO.findAll();
            List<Produto> produtosFiltrados = new ArrayList<>();

            for (Produto produto : produtos) {
                if (produto.getMaterial().toLowerCase().contains(material.toLowerCase())) {
                    produtosFiltrados.add(produto);
                }
            }

            if (produtosFiltrados.isEmpty()) {
                throw new ProductNotFoundException("Nenhum produto encontrado com o material: " + material);
            } else {
                for (Produto produto : produtosFiltrados) {
                    exibirDetalhesProduto(produto);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void filtrarProdutoPorPreco(Double preco) throws ProductNotFoundException
    {
        try {
            Collection<Produto> produtos = produtoDAO.findAll();
            List<Produto> produtosFiltrados = new ArrayList<>();

            for (Produto produto : produtos) {
                if (produto.getPreco() <= preco) {
                    produtosFiltrados.add(produto);
                }
            }

            if (produtosFiltrados.isEmpty()) {
                throw new ProductNotFoundException("Nenhum produto encontrado com o preço igual ou inferior a: " + preco);
            }else {
                for (Produto produto : produtosFiltrados) {
                    exibirDetalhesProduto(produto);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void exibirDetalhesProduto(Produto produto) {
        System.out.println(produto.getId() + " - " + produto.getTipo());
        System.out.println("Quantidade: " + produto.getQuantidadeEstoque());
        System.out.println("Preço: R$" + produto.getPreco());
        System.out.println("Material: " + produto.getMaterial());
        System.out.println("----------------------");
    }


    public boolean testeOpcao(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }


    public boolean testeQuantidade(int quantidade, int opcao)
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();

            for(Produto produto : produtos){
                if(produto.getId() == opcao)
                {
                    if(produto.getQuantidadeEstoque() >= quantidade)
                    {
                        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
                        return true;
                    }
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean testarExistenciaProduto(int opcao)
    {
        try{
            Collection<Produto> produtos = produtoDAO.findAll();

            for(Produto produto : produtos)
            {
                if(produto.getId() == opcao)
                {
                    return true;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

}

package view;

import service.ProdutoService;

import java.util.Scanner;

/*
*   Adicionar Produto, quantidade, alterar o preço
* */

public class AdicionarView implements View{

    private EstoqueView estoqueView;

    public AdicionarView(EstoqueView estoqueView)
    {
        this.estoqueView = estoqueView;
    }

    @Override
    public void startView()
    {
        ProdutoService produtoService = new ProdutoService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Adicionar Produto--");
        System.out.println();
        System.out.println("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.println("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Material: ");
        String material = scanner.nextLine();
        produtoService.adicionarProduto(tipo, quantidade, preco, material);

        System.out.println("Adicionando Produto");
        try{
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".\n");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        estoqueView.startView();
    }
}

package view;

import service.ProdutoService;

import java.util.Scanner;

/*
*   Remover Produto, quantidade ou alterar o preço
* */
public class RemoverView implements View{

    private EstoqueView estoqueView;
    ProdutoService produtoService = new ProdutoService(); //Mostrar os produtos
    public RemoverView(EstoqueView estoqueView)
    {
        this.estoqueView = estoqueView;
    }

    @Override
    public void startView()
    {
        int escolha = 0;

        while(escolha == 1 || escolha != 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--Remover Produto--");
            produtoService.mostrarProdutos();
            System.out.println("\n\nEscolha o produto para remover: ");
            int opcao = scanner.nextInt();
            produtoService.remover(opcao);
            produtoService.atualizarIds();

            System.out.println("\n\n1 - Remover mais algum produto");
            System.out.println("2 - Voltar");
            System.out.println("Escolha: ");
            escolha = scanner.nextInt();
        }

        estoqueView.startView();

    }
}

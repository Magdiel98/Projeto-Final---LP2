package view;

import service.ProdutoService;

import java.util.Scanner;

public class AtualizarView implements View{

    private EstoqueView estoqueView;
    private AtualizarProdutoView atualizarProdutoView;
    ProdutoService produtoService = new ProdutoService();

    public AtualizarView(EstoqueView estoqueView)
    {
        this.estoqueView = estoqueView;
        atualizarProdutoView = new AtualizarProdutoView(this);
    }

    @Override
    public void startView()
    {
        int opcao = 1;
        while(opcao != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--Atualizar Produto--");
            produtoService.mostrarProdutos();
            System.out.println("0 - Voltar");
            System.out.println("\nEscolha a opção: ");
            opcao = scanner.nextInt();

            while(!(produtoService.testarExistenciaProduto(opcao)) && opcao != 0){
                System.out.println("Não existe essa opção");
                System.out.println("Digite uma opção válida: ");
                opcao = scanner.nextInt();
            }

            if (opcao >= 1) {
                atualizarProdutoView.setOpcao(opcao);
                atualizarProdutoView.startView();
            }
        }
        estoqueView.startView();
    }
}

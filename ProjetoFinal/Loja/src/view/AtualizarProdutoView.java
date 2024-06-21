package view;

import service.ProdutoService;

import java.util.Scanner;

public class AtualizarProdutoView implements View{
    private AtualizarView atualizarView;

    private int opcao;

    public void setOpcao(int opcao)
    {
        this.opcao = opcao;
    }
    public AtualizarProdutoView(AtualizarView atualizarView)
    {
        this.atualizarView = atualizarView;
    }

    @Override
    public void startView()
    {   int decisao = 0;
        while(decisao != 2 || decisao == 1) {
            ProdutoService produtoService = new ProdutoService();
            Scanner scanner = new Scanner(System.in);
            while (decisao == 1 || decisao != 2) {
                System.out.println("--Produto--");
                produtoService.especificarProdutoNumero(opcao);
                int escolha = 0;
                while (escolha < 1 || escolha > 3) {
                    System.out.println("O que quer atualizar?");
                    escolha = scanner.nextInt();
                }
                scanner.nextLine();
                switch (escolha) {
                    case 1:
                        System.out.println("Digite a nova quantidade: ");
                        int quantidade = scanner.nextInt();
                        produtoService.atualizaquantidade(opcao, quantidade);
                        break;
                    case 2:
                        System.out.println("Digite o novo preço: ");
                        double preco = scanner.nextDouble();
                        produtoService.atualizapreco(opcao, preco);
                        break;
                    case 3:
                        System.out.println("Digite o material: ");
                        String material = scanner.nextLine();
                        produtoService.atualizamaterial(opcao, material);
                        break;
                }

                System.out.println("1 - Atualizar mais alguma coisa");
                System.out.println("2 - Voltar");
                decisao = scanner.nextInt();
            }
        }
        atualizarView.startView();
    }
}

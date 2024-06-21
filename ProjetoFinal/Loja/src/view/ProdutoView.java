package view;

import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;

import java.util.List;
import java.util.Scanner;

public class ProdutoView implements View{

    private int opcao;

    private VitrineView vitrineView;

    private PagamentoView pagamentoView;

    private ClienteService clienteService;

    private PedidoService pedidoService = new PedidoService();

    public void setOpcao(int opcao)
    {
        this.opcao = opcao;
    }

    public ProdutoView(VitrineView vitrineView, ClienteService clienteService)
    {
        this.vitrineView = vitrineView;
        this.clienteService = clienteService;
        pagamentoView = new PagamentoView(this, clienteService, pedidoService, vitrineView);
    }

    @Override
    public void startView()
    {
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        int quantidade, desejo = 0;
        ProdutoService produtoService = new ProdutoService();

        while(valor == 0) {

            System.out.println("--Produto--");
            produtoService.especificarProduto(opcao);

            System.out.println();
            System.out.println();
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Voltar");
            System.out.println("Escolha uma opção: ");
            valor = scanner.nextInt();

            switch (valor) {
                case 1:
                    System.out.println("\nDigite a quantidade: ");
                    quantidade = scanner.nextInt();

                    while(!(produtoService.testeQuantidade(quantidade, opcao)))
                    {
                        System.out.println("Digite uma quantidade correta: ");
                        quantidade = scanner.nextInt();
                    }

                    pedidoService.pedido(clienteService.getEmail(), opcao, quantidade);

                    while(desejo < 1 || desejo > 2) {
                        System.out.println("\n1 - Finalizar compra");
                        System.out.println("2 - Continuar comprando");
                        System.out.println("Digite uma opção: ");
                        desejo = scanner.nextInt();
                    }
                    switch (desejo) {
                        case 1:
                            pagamentoView.startView();
                            break;
                        case 2:
                            vitrineView.startView();
                            break;
                    }
                    break;
                case 2:
                    vitrineView.startView();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    valor = 0;
                    break;
            }
        }

    }
}

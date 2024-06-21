package view;

import entity.Cliente;
import exception.ProductNotFoundException;
import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;

import java.util.Scanner;


public class FiltrarProdutoView implements View {
    public ProdutoView produtoView;
    public PagamentoView pagamentoView;
    public VitrineView vitrineView;
    private ProdutoService produtoService;
    private PedidoService pedidoService;
    private ClienteService clienteService;

    public FiltrarProdutoView(ProdutoView produtoView, PagamentoView pagamentoView, VitrineView vitrineView,
                              ProdutoService produtoService, PedidoService pedidoService, ClienteService clienteService) {
        this.produtoView = produtoView;
        this.pagamentoView = pagamentoView;
        this.vitrineView = vitrineView;
        this.produtoService = produtoService;
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
    }

    @Override
    public void startView() {
        ProdutoService produtoService = new ProdutoService();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while(opcao < 1 || opcao > 3) {
            System.out.println("--Filtrar Produto--");
            System.out.println("1 - Pelo tipo");
            System.out.println("2 - Pelo material");
            System.out.println("3 - Pelo preço");
            System.out.println("Digite uma opção: ");
            opcao = scanner.nextInt();
        }
        scanner.nextLine();

        switch (opcao) {
            case 1:
                try {
                    System.out.println("Digite o tipo: ");
                    String tipo = scanner.nextLine();

                    produtoService.filtrarProdutoPorTipo(tipo);
                } catch (ProductNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    System.out.println("Digite o material: ");
                    String material = scanner.nextLine();

                    produtoService.filtrarProdutoPorMaterial(material);
                } catch (ProductNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                try {
                    System.out.println("Digite o preço: ");
                    double preco = scanner.nextDouble();

                    produtoService.filtrarProdutoPorPreco(preco);
                } catch (ProductNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }

        System.out.println("1 - Adicionar Produto");
        System.out.println("2 - Voltar");
        System.out.println("Escolha uma opção: ");
        int opcaoAdicao = scanner.nextInt();

        switch (opcaoAdicao) {
            case 1:
                System.out.println("\nDigite a quantidade: ");
                int quantidade = scanner.nextInt();
                pedidoService.pedido(clienteService.getEmail(), opcao, quantidade);

                System.out.println("\n1 - Finalizar compra");
                System.out.println("2 - Continuar comprando");
                int desejo = scanner.nextInt();
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
        }

    }
}

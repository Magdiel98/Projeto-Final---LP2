package view;

import entity.Produto;
import service.ClienteService;
import service.PedidoService;

import java.util.Scanner;
public class PagamentoView implements View{

    public ProdutoView produtoView;
    private ClienteService clienteService;
    private PedidoService pedidoService;
    private VitrineView vitrineView;

    public PagamentoView(ProdutoView produtoView, ClienteService clienteService, PedidoService pedidoService, VitrineView vitrineView)
    {
        this.produtoView =  produtoView;
        this.clienteService = clienteService;
        this.pedidoService = pedidoService;
        this.vitrineView = vitrineView;
    }

    @Override
    public void startView()
    {

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while(opcao == 0) {
            System.out.println("--Forma de Pagamento--");
            System.out.println();
            System.out.println("1 - Pix");
            System.out.println("2 - Cartão");
            System.out.println("3 - Boleto");
            System.out.println("4 - Voltar");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
        }

        System.out.println();
        System.out.println("-- Resumo do Pedido --");
        System.out.println();
        System.out.println("-- CLIENTE: ");
        clienteService.mostrarDados();
        String emailCliente = clienteService.getEmail();

        System.out.println();
        System.out.println("-- ITENS: ");
        pedidoService.mostrarPedidos(emailCliente);

        System.out.println();
        System.out.println("-- FORMA DE PAGAMENTO: ");
        switch (opcao)
        {
            case 1:
                System.out.println("Pix");
                break;
            case 2:
                System.out.println("Cartão");
                break;
            case 3:
                System.out.println("Boleto");
                break;
            case 4:
                produtoView.startView();
                break;
        }
        System.out.println();
        System.out.println("Seu pedido foi finalizado com sucesso!\n");
        try {
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".\n");
            vitrineView.startView();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package view;

import service.ClienteService;
import service.PedidoService;

import java.util.Scanner;

public class CarrinhoView implements View{

    private VitrineView vitrineView;
    private ClienteService clienteService;
    private PedidoService pedidoService;
    public CarrinhoView(VitrineView vitrineView, ClienteService clienteService)
    {
        this.clienteService = clienteService;
        this.vitrineView = vitrineView;
        this.pedidoService = new PedidoService();
    }

    @Override
    public void startView()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Lista--");
        pedidoService.mostrarPedidos(clienteService.getEmail());
        int opcao = 0;

        while(opcao != 1)
        {
            System.out.println("1 - Voltar");
            System.out.println("Digite: ");
            opcao = scanner.nextInt();
        }

        vitrineView.startView();
    }

}

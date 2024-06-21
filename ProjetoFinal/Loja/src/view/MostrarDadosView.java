package view;

import service.ClienteService;

import java.util.Scanner;

public class MostrarDadosView implements View{
    private VitrineView vitrineView;
    private ClienteService clienteService;
    public MostrarDadosView(VitrineView vitrineView, ClienteService clienteService)
    {
        this.clienteService = clienteService;
        this.vitrineView = vitrineView;
    }


    @Override
    public void startView()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Dados do Cliente--");
        clienteService.mostrarDados();
        int opcao = 0;

        while(opcao != 1) {
            System.out.println("\n1 - Voltar");
            System.out.println("Digite para voltar: ");
            opcao = scanner.nextInt();
        }

        vitrineView.startView();
    }
}

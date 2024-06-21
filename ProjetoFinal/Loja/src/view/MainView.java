package view;
import service.PedidoService;
import service.ProdutoService;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Tela principal, onde o usuário terá a opção de escolher entre usuário, gerente ou encerrar o programa
* Ao escolher Usuário, será chamado o método startView do objeto usuarioView da classe UsuarioView
* De forma semelhante acontecerá ao escolher a opção Gerente
* Ao encerrar o programa será exibido a palavra Encerrando seguido de pontos em intervalo de 1 segundo
* */
public class MainView implements View{
    private GerenteView gerenteView;
    private ClienteView clienteView;
    private PedidoService pedidoService;
    private ProdutoService produtoService;

    public MainView()
    {
        gerenteView = new GerenteView(this);
        clienteView = new ClienteView(this, pedidoService, produtoService);
    }

    @Override
    public void startView()
    {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while(opcao < 1 || opcao > 3)
        {
                System.out.println("--Tela Inicial--");
                System.out.println("1 - Cliente");
                System.out.println("2 - Gerente");
                System.out.println("3 - Encerrar");
                System.out.println("Escolha uma opção: ");
                opcao = scanner.nextInt();
        }

        switch (opcao)
        {
            case 1:
                clienteView.startView();
                break;
            case 2:
                gerenteView.startView();
                break;
            case 3:
                System.out.print("Encerrando");
                try{
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                break;
        }

        scanner.close();
    }
}

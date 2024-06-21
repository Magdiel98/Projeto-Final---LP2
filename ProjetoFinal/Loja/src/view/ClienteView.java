package view;
/*
* Essa classe implementa a interface View usando o método startView
* Esse método será chamado pela classe MainView
* */

import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;

import java.util.Scanner;

public class ClienteView implements View{

    //Acessar outras telas
    private CadastroView cadastroView;

    private VitrineView vitrineView;

    //Voltar
    private MainView mainView;

    ClienteService clienteService = new ClienteService();

    public ClienteView(MainView mainView, PedidoService pedidoService, ProdutoService produtoService)
    {
        this.mainView = mainView;
        cadastroView = new CadastroView(this);
        vitrineView = new VitrineView(this, clienteService, pedidoService, produtoService);
    }

    @Override
    public void startView()
    {
        int acesso = 0;
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);

        while(acesso == 0) {

            System.out.println("--Cliente--");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Fazer Cadastro");
            System.out.println("3 - Voltar");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();

            while (opcao < 1 || opcao > 3){
                System.out.println("\nOpção inválida!");
                System.out.println("Digite uma opção válida: ");
                opcao = scanner.nextInt();
                 //Capturar o dado no buffer
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite seu E-mail: ");
                    scanner.nextLine();
                    String email = scanner.nextLine();

                    System.out.println("Digite sua Senha: ");
                    String senha = scanner.nextLine();

                    if (clienteService.login(email, senha)) {
                        clienteService.setEmail(email);
                        System.out.println("Acesso permitido!");
                        try {
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".\n");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        vitrineView.startView();
                    } else {
                        System.out.println("\nAcesso negado!\n");
                    }
                    break;
                case 2:
                    cadastroView.startView();
                    break;
                case 3:
                    mainView.startView();
                    break;

            }

        }

        scanner.close();
    }
}

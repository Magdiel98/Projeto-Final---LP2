package view;
import service.GerenteService;

import java.util.Scanner;
/*
*  Tela para fazer login do gerente (pré-definido) ou voltar para a tela principal
*
* */


public class GerenteView implements View{
    private MainView mainView; //Voltar

    //Acesar o PainelGerenteView
    private PainelGerenteView painelGerenteView;

    public GerenteView(MainView mainView)
    {
        this.mainView = mainView;
        painelGerenteView = new PainelGerenteView(this);
    }
    @Override
    public void startView()
    {

        int acesso = 0;
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);

        while(acesso == 0) {
            System.out.println("--Gerente--");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Voltar");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();

            while (opcao < 1 || opcao > 2){
                System.out.println("\nOpção inválida!");
                System.out.println("Digite uma opção válida: ");
                opcao = scanner.nextInt();

            }

            switch (opcao) {
                case 1:
                    GerenteService gerenteService = new GerenteService();
                    System.out.println("Digite seu E-mail: ");
                    scanner.nextLine();
                    String email = scanner.nextLine();
                    System.out.println("Digite sua Senha: ");
                    String senha = scanner.nextLine();

                    if (gerenteService.login(email, senha)) {
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
                        painelGerenteView.startView();
                    } else {
                        System.out.println("\nAcesso negado!\n");
                    }
                    break;
                case 2:
                    mainView.startView();
                    break;
            }
        }
        scanner.close();
    }
}

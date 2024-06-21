package view;

import java.util.Scanner;

public class EstoqueView implements View{

    private PainelGerenteView painelGerenteView;
    private AdicionarView adicionar;
    private AtualizarView atualizar;
    private RemoverView remover;

    public EstoqueView(PainelGerenteView painelGerenteView)
    {
        this.painelGerenteView = painelGerenteView;
        adicionar = new AdicionarView(this);
        remover = new RemoverView(this);
        atualizar = new AtualizarView(this);
    }

    @Override
    public void startView()
    {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        while(opcao == 0) {
            System.out.println("--Estoque--");
            System.out.println("");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Voltar");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionar.startView();
                    break;
                case 2:
                    remover.startView();
                    break;
                case 3:
                    atualizar.startView();
                case 4:
                    painelGerenteView.startView();
                    break;
                default:
                    System.out.println("\nOpção inválida!\n");
                    opcao = 0;
                    break;
            }
        }
    }
}

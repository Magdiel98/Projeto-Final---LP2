package view;

import java.util.Scanner;

/*
*   Painel onde o gerente pode ver e trabalhar as informações:
*   Funcionários, Produto, Finanças
* */
public class PainelGerenteView implements View{

    private GerenteView gerenteView; //Voltar

    //Opções para outra tela:
    private EstoqueView estoqueView;

    public PainelGerenteView(GerenteView gerenteView)
    {
        this.gerenteView = gerenteView;
        estoqueView = new EstoqueView(this);
    }

    @Override
    public void startView()
    {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("--Painel Gerente--");
        System.out.println();
        System.out.println("1 - Estoque");
        System.out.println("2 - Sair");
        System.out.println("Escolha uma opção: ");
        opcao = scanner.nextInt();

        while(opcao < 1 || opcao > 2)
        {
            System.out.println("Opcão inválida!");
            System.out.println("Digite uma opção válida: ");
            opcao = scanner.nextInt();
        }

        switch(opcao)
        {
            case 1:
                estoqueView.startView();
                break;
            case 2:
                gerenteView.startView();
                break;
        }
    }
}

package view;

import service.CadastroService;

import java.util.Scanner;
/*
* O método dessa classe é chamado pela classe UsuarioView, quando o usuário opta por fazer
* o cadastro (Opção 2)
*
* Após fazer o cadastro, volta para a tela de UsuarioView
* */
public class CadastroView implements View{

    private ClienteView clienteView;

    public CadastroView(ClienteView clienteView)
    {
        this.clienteView = clienteView;
    }

    @Override
    public void startView()
    {
        Scanner scanner = new Scanner(System.in);
        CadastroService cadastroService = new CadastroService();
        System.out.println("--Cadastro--");
        System.out.println();
        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.println("E-mail: ");
        String email = scanner.nextLine();

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        System.out.println("Estado: ");
        String estado = scanner.nextLine();

        System.out.println("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.println("Rua: ");
        String rua = scanner.nextLine();

        System.out.println("Número(Digite SN se não houver número): ");
        int numero = scanner.nextInt();

        cadastroService.cadastrar(nome, sobrenome, email, senha, estado, cidade, rua, numero);
        System.out.println("Cadastro concluído!");
        try{
            Thread.sleep(2000);
            clienteView.startView();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}

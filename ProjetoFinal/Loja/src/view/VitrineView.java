package view;

import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;

import java.util.Scanner;

/*
*   Buscar do banco de dados, os nomes dos produtos
*   Depois fazer a escolha e comparar essa escolha com o valor (Um mapa por exemplo)
* */
public class VitrineView implements View{

    private ClienteView clienteView;
    private ProdutoView produtoView;

    private ClienteService clienteService;

    private CarrinhoView carrinhoView;

    private PagamentoView pagamentoView;

    private MostrarDadosView mostrarDadosView;

    private FiltrarProdutoView filtrarProdutoView;

    private PedidoService pedidoService;
    private ProdutoService produtoService;

    public VitrineView(ClienteView clienteView, ClienteService clienteService, PedidoService pedidoService, ProdutoService produtoService)
    {
        this.clienteView = clienteView;
        this.clienteService = clienteService;
        produtoView = new ProdutoView(this, clienteService);
        mostrarDadosView = new MostrarDadosView(this, clienteService);
        carrinhoView = new CarrinhoView(this, clienteService);
        pagamentoView = new PagamentoView(this.produtoView, clienteService, pedidoService, this);
        filtrarProdutoView = new FiltrarProdutoView(produtoView, pagamentoView, this, produtoService, pedidoService, clienteService);

    }
    @Override
    public void startView()
    {
        ProdutoService produtoService = new ProdutoService();
        Scanner scanner = new Scanner(System.in);

        int flag = 0;

        while(flag == 0){
            System.out.println("--Produtos--");
            produtoService.mostrarProdutos();
            System.out.println("\n\ns/S - Sair");
            System.out.println("f/F - Filtrar produto");
            System.out.println("c/C - Carrinho");
            System.out.println("p/P - Compras/Pagamentos");
            System.out.println("m/M - Mostrar Dados");
            System.out.println("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            if(opcao.equalsIgnoreCase("s") || opcao.equalsIgnoreCase("S") )
            {
                clienteView.startView();
            }
            else if(opcao.equalsIgnoreCase("f") || opcao.equalsIgnoreCase("F")){
                filtrarProdutoView.startView();
            }
            else if(opcao.equalsIgnoreCase("c") || opcao.equalsIgnoreCase("C"))
            {
                carrinhoView.startView();
            }
            else if(opcao.equalsIgnoreCase("p") || opcao.equalsIgnoreCase("P"))
            {
                pagamentoView.startView();
            }
            else if(opcao.equalsIgnoreCase("m") || opcao.equalsIgnoreCase("M"))
            {
                mostrarDadosView.startView();
            }
            else
            {
                try{
                    if(produtoService.testeOpcao(opcao)) {
                        int escolha = Integer.parseInt(opcao);
                        if (produtoService.testarExistenciaProduto(escolha)) {
                            produtoView.setOpcao(escolha);
                            produtoView.startView();
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            System.out.println("\nOpção inválida!\n");
        }
    }
}

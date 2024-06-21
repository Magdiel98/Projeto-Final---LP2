import dao.GerenteDAO;
import database.Database;
import entity.Cliente;
import entity.Gerente;
import entity.Produto;
import entity.Usuario;
import service.ClienteService;
import service.ProdutoService;
import view.MainView;

public class Main {
    public static void main(String[] args) {

        ProdutoService produtoService = new ProdutoService();
        produtoService.salvar();


        ClienteService clienteService = new ClienteService();
        clienteService.salvar();

        MainView mainView = new MainView();
        mainView.startView();

    }

}
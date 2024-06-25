package view;

import java.util.ArrayList;
import java.util.List;
import model.Client;

public class ClienteCadastro {
    private static List<Client> listaClientes = new ArrayList<>();

    public static void cadastroCliente() {
        System.out.println("Cadastro de cliente ");
        System.out.println("Digite o nome do cliente: ");
        String name = ConsoleNovo.lerString();
        System.out.println("Digite o numero do CEP: ");
        String cep = ConsoleNovo.lerString(); 
        System.out.println("Digite o e-mail: ");
        String email = ConsoleNovo.lerString();
        System.out.println("Informe o caso: ");
        String cases = ConsoleNovo.lerString();

        Client client = new Client(null, name, email, cep, null);
        listaClientes.add(client);

        System.out.println("Cliente cadastrado com sucesso! ");
        System.out.println(client);
    }

    public static List<Client> getListaClientes() {
        return listaClientes;
    }
}

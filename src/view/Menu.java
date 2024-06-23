package view;


import java.util.List;
import java.util.Scanner;
import model.Client;
import model.Lawyer;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("MENU\n");
            System.out.println("Selecione a opcao desejada");
            System.out.println("Digite 1 para cadastrar advogado");
            System.out.println("Digite 2 para cadastrar cliente");
            System.out.println("Digite 3 para listar clientes");
            System.out.println("Digite 4 para listar advogados\n");
            System.out.println("Digite 0 para sair.");

            int op = scanner.nextInt();
            scanner.nextLine(); 

            switch (op) {
                case 1:
                    CadastroAdv.cadastroAdv();
                    break;
                case 2:
                    ClienteCadastro.cadastroCliente();
                    break;
                case 3:
                    List<Client> clientesCadastrados = ClienteCadastro.getListaClientes();
                    System.out.println("\nLista de Clientes Cadastrados:");
                    for (Client cliente : clientesCadastrados) {
                        System.out.println(cliente);
                    }
                    break;
                case 4:
                    List<Lawyer> advogadosCadastrados = CadastroAdv.getListaAdvogados();
                    System.out.println("\nLista de Advogados Cadastrados:");
                    for (Lawyer advogado : advogadosCadastrados) {
                        System.out.println(advogado);
                    }
                    break;
                case 0:
                    sair = true;
                    
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}

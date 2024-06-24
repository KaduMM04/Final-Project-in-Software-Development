package view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import application.Console;
import Controller.GerenciadorAdvogados;
import Controller.GerenciadorCasos;
import Controller.GerenciadorCliente;
import Controller.GerenciadorSecretarias;
import Controller.ListaCases;
import Controller.ListaAdvogado;
import Controller.ListaSecretarias;
import Controller.ListaClientes;

import model.Case;
import model.Client;
import model.Lawyer;
import model.Secretary;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\nMENU\n");
            System.out.println("Selecione a opção desejada:");
            System.out.println("1. Cadastrar advogado");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Listar advogados");
            System.out.println("5. Cadastrar caso");
            System.out.println("6. Listar casos");
            System.out.println("7. Cadastrar secretária");
            System.out.println("8. Listar secretárias");
            System.out.println("9. Buscar cliente");
            System.out.println("10. Buscar advogado");
            System.out.println("0. Sair");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    cadastrarAdvogado();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    listarAdvogados();
                    break;
                case 5:
                    cadastrarCaso();
                    break;
                case 6:
                    listarCases();
                    break;
                case 7:
                    cadastrarSecretaria();
                    break;
                case 8:
                    listarSecretarias();
                    break;
                case 9:
                    buscarCliente();
                    break;
                case 10:
                    buscarAdvogado();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }

    public static void cadastrarAdvogado() {
        String nomeAdv = Console.lerString("Digite o nome do advogado: ");
        String oab = Console.lerString("Digite o número da OAB: ");
        String emailAdv = Console.lerString("Digite o e-mail: ");
        String especialidade = Console.lerString("Informe a especialidade: ");
        Lawyer lawyer = new Lawyer(null, nomeAdv, emailAdv, emailAdv, oab, especialidade, null);
        ListaAdvogado.salvarAdvogado(lawyer);
        try {
            GerenciadorAdvogados.salvarAdvogadoNoArquivo(ListaAdvogado.getListaAdvogados());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarCliente() {
        String nomeCli = Console.lerString("Digite o nome do cliente: ");
        String cpf = Console.lerString("Digite o CPF: ");
        String emailCli = Console.lerString("Digite o e-mail: ");
        Client cliente = new Client(null, nomeCli, cpf, emailCli, null);
        ListaClientes.salvarCliente(cliente);
        try {
            GerenciadorCliente.salvarClienteNoArquivo(ListaClientes.getListaClientes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarClientes() {
        ListaClientes.listarClientes();
    }

    public static void listarAdvogados() {
        ListaAdvogado.listarAdvogados();
    }

    public static void cadastrarCaso() {
        int id = Console.lerInt("Digite o ID do caso: ");
        String descricao = Console.lerString("Digite a descrição do caso: ");
        String clienteCpf = Console.lerString("Digite o CPF do cliente: ");
        String advogadoOab = Console.lerString("Digite o número da OAB do advogado: ");

        try {
            Client cliente = ListaClientes.buscarCliente(null);
            Lawyer advogado = ListaAdvogado.buscarAdvogado(advogadoOab);
            Case caso = new Case(null, advogadoOab, cliente, advogado, descricao, null);
            ListaCases.salvarCase(caso);
            GerenciadorCasos.salvarCasoNoArquivo(ListaCases.getListaCases());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarCases() {
        ListaCases.listarCases();
    }

    public static void cadastrarSecretaria() {
        String nomeSec = Console.lerString("Digite o nome da secretária: ");
        int registro = Console.lerInt("Digite o número de registro: ");
        Secretary secretaria = new Secretary(nomeSec, nomeSec, nomeSec, null);
        ListaSecretarias.salvarSecretaria(secretaria);
        try {
            GerenciadorSecretarias.salvarSecretariaNoArquivo(ListaSecretarias.getListaSecretarias());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listarSecretarias() {
        ListaSecretarias.listarSecretarias();
    }

    public static void buscarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente que deseja buscar: ");
        String cpf = scanner.nextLine();

        try {
            Client cliente = ListaClientes.buscarCliente(null);
            System.out.println("Cliente encontrado: " + cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscarAdvogado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da OAB do advogado que deseja buscar: ");
        String oab = scanner.nextLine();

        try {
            Lawyer advogado = ListaAdvogado.buscarAdvogado(oab);
            System.out.println("Advogado encontrado: " + advogado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

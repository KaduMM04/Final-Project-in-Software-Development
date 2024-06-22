package application;

import java.io.IOException;
import java.util.ArrayList;
import controller.GerenciadorCasos;
import controller.ListaAdvogado;
import controller.ListaCases;
import controller.ListaSecretarias;
import controller.ListaClientes;
import model.Case;
import model.Client;
import model.Lawyer;
import model.Secretary;

public class Program {

    public static void main(String[] args) {
        // Exemplo de criação de dados
        Client client1 = new Client(111111111, "Alice Silva", "alice.silva@example.com", "12345-678", new ArrayList<>());
        Lawyer lawyer1 = new Lawyer(222222222, "Dr. Bruno Costa", "bruno.costa@example.com", "OAB-98765", "Direito Penal", new ArrayList<>());
        Secretary secretary1 = new Secretary(333333333, "Carla Souza", "carla.souza@example.com", 1001);

        Case caso1 = new Case(1, "Criminal", client1, lawyer1, "Assalto à mão armada");
        Case caso2 = new Case(2, "Civil", client1, lawyer1, "Divórcio consensual");

        // Testar salvar casos
        ListaCases.salvarCase(caso1);
        ListaCases.salvarCase(caso2);

        // Testar listar casos
        System.out.println("\nListando todos os casos:");
        ListaCases.listarCases();

        // Testar buscar e apagar caso
        try {
            Case casoEncontrado = ListaCases.buscarCase(2);
            System.out.println("\nCaso encontrado: " + casoEncontrado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Case casoParaApagar = ListaCases.buscarCase(1);
            ListaCases.apagarCase(casoParaApagar);
            System.out.println("Caso com ID 1 apagado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Testar listar casos após apagar
        System.out.println("\nListando todos os casos após apagar:");
        ListaCases.listarCases();

        // Testar salvar advogados
        ListaAdvogado.salvarAdvogado(lawyer1);

        // Testar listar advogados
        System.out.println("\nListando todos os advogados:");
        ListaAdvogado.listarAdvogados();

        // Testar buscar e apagar advogado
        try {
            Lawyer advogadoEncontrado = ListaAdvogado.buscarAdvogado("OAB-98765");
            System.out.println("\nAdvogado encontrado: " + advogadoEncontrado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Lawyer advogadoParaApagar = ListaAdvogado.buscarAdvogado("OAB-98765");
            ListaAdvogado.apagarAdvogado(advogadoParaApagar);
            System.out.println("Advogado com OAB OAB-98765 apagado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Testar listar advogados após apagar
        System.out.println("\nListando todos os advogados após apagar:");
        ListaAdvogado.listarAdvogados();

        // Testar salvar secretárias
        ListaSecretarias.salvarSecretaria(secretary1);

        // Testar listar secretárias
        System.out.println("\nListando todas as secretárias:");
        ListaSecretarias.listarSecretarias();

        // Testar buscar e apagar secretária
        try {
            Secretary secretariaEncontrada = ListaSecretarias.buscarSecretaria(1001);
            System.out.println("\nSecretária encontrada: " + secretariaEncontrada);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Secretary secretariaParaApagar = ListaSecretarias.buscarSecretaria(1001);
            ListaSecretarias.apagarSecretaria(secretariaParaApagar);
            System.out.println("Secretária com número de registro 1001 apagada com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Testar listar secretárias após apagar
        System.out.println("\nListando todas as secretárias após apagar:");
        ListaSecretarias.listarSecretarias();

        // Testar salvar clientes
        ListaClientes.salvarCliente(client1);

        // Testar listar clientes
        System.out.println("\nListando todos os clientes:");
        ListaClientes.listarClientes();

        // Testar buscar e apagar cliente
        try {
            Client clienteEncontrado = ListaClientes.buscarCliente(111111111);
            System.out.println("\nCliente encontrado: " + clienteEncontrado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Client clienteParaApagar = ListaClientes.buscarCliente(111111111);
            ListaClientes.apagarCliente(clienteParaApagar);
            System.out.println("Cliente com CPF 111111111 apagado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Testar listar clientes após apagar
        System.out.println("\nListando todos os clientes após apagar:");
        ListaClientes.listarClientes();
    }
}

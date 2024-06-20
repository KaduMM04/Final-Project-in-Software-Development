package controller;

import java.util.ArrayList;
import model.Client;

public abstract class ListaClientes {

    private static ArrayList<Client> listaClientes = new ArrayList<>();

    public static void salvarCliente(Client cliente) {
        listaClientes.add(cliente);
        System.out.println("Cliente salvo: " + cliente);
    }

    public static ArrayList<Client> getListaClientes() {
        return listaClientes;
    }

    public static void verificarListaVazia() throws Exception {
        if (listaClientes.isEmpty()) {
            throw new Exception("Não há clientes cadastrados");
        }
    }

    public static Client buscarCliente(Integer cpf) throws Exception {
        for (Client tempCliente : listaClientes) {
            if (tempCliente.getCpf().equals(cpf)) {
                return tempCliente;
            }
        }
        throw new Exception("Cliente com CPF " + cpf + " não encontrado");
    }

    public static void apagarCliente(Client cliente) {
        listaClientes.remove(cliente);
        System.out.println("Cliente removido: " + cliente);
    }

    public static void listarClientes() {
        try {
            verificarListaVazia();
            System.out.println("\nClientes Cadastrados:");
            for (Client tempCliente : listaClientes) {
                System.out.println(tempCliente);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

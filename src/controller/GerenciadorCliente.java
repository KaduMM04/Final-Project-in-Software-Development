package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Client;

public abstract class GerenciadorCliente {

    private static final String ARQUIVO_CLIENTE = "lista-clientes.txt";

    public static void criarArquivoSeNaoExistir() {

        File arquivo = new File(ARQUIVO_CLIENTE);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    // public static void lerArquivo(ArrayList<Client> listaClientes) throws IOException {

    //     listaClientes.clear();

    //     try (FileReader fileReader = new FileReader(ARQUIVO_CLIENTE);
    //          BufferedReader bufferedReader = new BufferedReader(fileReader)) {

    //         String linhaAtualDoArquivo;

    //         while ((linhaAtualDoArquivo = bufferedReader.readLine()) != null) {

    //            Client tempCliente = new Client();
    //             tempCliente.fromString(linhaAtualDoArquivo);

    //             listaClientes.add(tempCliente);
    //         }

    //     }

    // }

    public static void salvarClienteNoArquivo(ArrayList<Client> listaClientes) throws IOException {

        try (FileWriter fileWriter = new FileWriter(ARQUIVO_CLIENTE);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Client tempCliente : listaClientes) {
                bufferedWriter.write(tempCliente.toString() + "\n");
            }
        }
    }

}
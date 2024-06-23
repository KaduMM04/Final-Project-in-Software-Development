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


    public static void salvarClienteNoArquivo(ArrayList<Client> listaClientes) throws IOException {

        try (FileWriter fileWriter = new FileWriter(ARQUIVO_CLIENTE);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Client tempCliente : listaClientes) {
                bufferedWriter.write(tempCliente.toString() + "\n");
            }
        }
    }

}
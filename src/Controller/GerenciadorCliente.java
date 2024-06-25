package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Case;
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
    
    public static  void lerClientesDoArquivo(ArrayList<Client> listClientes) throws IOException {
       listClientes.clear();

        try (FileReader fileReader = new FileReader(ARQUIVO_CLIENTE);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                List<String> linhasCasos = new ArrayList<>();
                // Leitura de casos relacionados
                while ((linha = bufferedReader.readLine()) != null && linha.startsWith("\t")) {
                    linhasCasos.add(linha.trim());
                }
                Client cliente = Client.fromString(linha);
                listClientes.add(cliente);
                
                for (String caso : linhasCasos) {
                    Case c = Case.fromString(caso); // Criar caso a partir da linha de caso
                    cliente.addCase(c); // Adicionar o caso ao advogado
                }
            }
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
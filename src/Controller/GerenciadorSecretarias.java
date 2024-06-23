package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Secretary;

public abstract class GerenciadorSecretarias {

    private static final String ARQUIVO_SECRETARIA = "lista-secretarias.txt";

    public static void criarArquivoSeNaoExistir() {

        File arquivo = new File(ARQUIVO_SECRETARIA);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void salvarSecretariaNoArquivo(ArrayList<Secretary> listaSecretarias) throws IOException {

        try (FileWriter fileWriter = new FileWriter(ARQUIVO_SECRETARIA);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Secretary secretaria : listaSecretarias) {
                bufferedWriter.write(secretaria.toString() + "\n");
            }
        }
    }

}
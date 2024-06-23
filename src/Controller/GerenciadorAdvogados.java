package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Lawyer;

public abstract class GerenciadorAdvogados {

    private static final String ARQUIVO_ADVOGADO = "lista-advogados.txt";

    public static void criarArquivoSeNaoExistir() {

        File arquivo = new File(ARQUIVO_ADVOGADO);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void salvarAdvogadoNoArquivo(ArrayList<Lawyer> listaAdvogados) throws IOException {

        try (FileWriter fileWriter = new FileWriter(ARQUIVO_ADVOGADO);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Lawyer advogado : listaAdvogados) {
                bufferedWriter.write(advogado.toString() + "\n");
            }
        }
    }

}
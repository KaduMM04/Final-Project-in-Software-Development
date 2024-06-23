package controller;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Case;

public abstract class GerenciadorCasos {

    private static final String ARQUIVO_CASO = "lista-casos.txt";

    public static void criarArquivoSeNaoExistir() {

        File arquivo = new File(ARQUIVO_CASO);

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }



    public static void salvarCasoNoArquivo(ArrayList<Case> listaCasos) throws IOException {

        try (FileWriter fileWriter = new FileWriter(ARQUIVO_CASO);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Case tempCaso : listaCasos) {
                bufferedWriter.write(tempCaso.toString() + "\n");
            }
        }
    }

}

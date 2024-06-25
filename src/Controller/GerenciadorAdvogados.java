package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    
    public static void lerAdvogadosDoArquivo(List<Lawyer> listaAdvogados) {
        listaAdvogados.clear();

        try (FileReader fileReader = new FileReader(ARQUIVO_ADVOGADO);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                Lawyer advogado = Lawyer.fromString(linha);
                listaAdvogados.add(advogado);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de advogados: " + e.getMessage());
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
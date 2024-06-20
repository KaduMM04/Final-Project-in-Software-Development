package application;

import java.io.IOException;
import java.util.ArrayList;
import controller.GerenciadorAdvogados;
import controller.GerenciadorSecretarias;
import controller.ListaAdvogados;
import controller.ListaSecretarias;
import model.Lawyer;
import model.Secretary;

public class Program {

    public static void main(String[] args) {
        
        // Exemplo de criação de advogados
        Lawyer advogado1 = new Lawyer(111111111, "Dr. João Silva", "joao.silva@example.com", "OAB-12345", "Direito Penal", null);
        Lawyer advogado2 = new Lawyer(222222222, "Dra. Maria Souza", "maria.souza@example.com", "OAB-54321", "Direito Civil", null);

        // Exemplo de criação de secretárias
        Secretary secretaria1 = new Secretary(333333333, "Ana Oliveira", "ana.oliveira@example.com", 1001);
        Secretary secretaria2 = new Secretary(444444444, "Pedro Santos", "pedro.santos@example.com", 1002);

        // Lista de advogados
        ArrayList<Lawyer> listaAdvogados = new ArrayList<>();
        listaAdvogados.add(advogado1);
        listaAdvogados.add(advogado2);

        // Lista de secretárias
        ArrayList<Secretary> listaSecretarias = new ArrayList<>();
        listaSecretarias.add(secretaria1);
        listaSecretarias.add(secretaria2);

        // Testar criar arquivo se não existir para advogados e secretárias
        GerenciadorAdvogados.criarArquivoSeNaoExistir();
        GerenciadorSecretarias.criarArquivoSeNaoExistir();

        // Testar salvar advogados no arquivo
        try {
            GerenciadorAdvogados.salvarAdvogadoNoArquivo(listaAdvogados);
            System.out.println("Advogados salvos com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar advogados no arquivo: " + e.getMessage());
        }

        // Testar salvar secretárias no arquivo
        try {
            GerenciadorSecretarias.salvarSecretariaNoArquivo(listaSecretarias);
            System.out.println("Secretárias salvas com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar secretárias no arquivo: " + e.getMessage());
        }

        // Testar buscar advogado pelo OAB
        try {
            Lawyer advogadoEncontrado = ListaAdvogados.buscarAdvogado("OAB-12345");
            System.out.println("Advogado encontrado:\n" + advogadoEncontrado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Testar buscar secretária pelo número de registro
        try {
            Secretary secretariaEncontrada = ListaSecretarias.buscarSecretaria(1002);
            System.out.println("Secretária encontrada:\n" + secretariaEncontrada);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        // Testar listar secretárias
        System.out.println("\nListagem de Secretárias:");
        ListaSecretarias.listarSecretarias();
    }

}

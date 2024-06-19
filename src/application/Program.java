package application;

import java.io.IOException;
import java.util.ArrayList;
import controller.GerenciadorCasos;
import controller.ListaCasos.ListaCases;
import model.Case;
import model.Client;
import model.Lawyer;

public class Program {

	public static void main(String[] args) {     
         // Exemplo de criação de casos
		 Client client1 = new Client(111111111, "Alice Silva", "alice.silva@example.com", "12345-678", null);
		 Lawyer lawyer1 = new Lawyer(222222222, "Dr. Bruno Costa", "bruno.costa@example.com", "OAB-98765", "Direito Penal", null);
 
		 Case caso1 = new Case(1, "Criminal", client1, lawyer1, "Assalto à mão armada");
		 Case caso2 = new Case(2, "Civil", client1, lawyer1, "Divórcio consensual");
 
		 // Lista de casos
		 ArrayList<Case> listaCasos = new ArrayList<>();
		 listaCasos.add(caso1);
		 listaCasos.add(caso2);
 
		 // Testar criar arquivo se não existir
		 GerenciadorCasos.criarArquivoSeNaoExistir();
 
		 // Testar salvar casos no arquivo
		 try {
			 GerenciadorCasos.salvarCasoNoArquivo(listaCasos);
			 System.out.println("Casos salvos com sucesso no arquivo.");
		 } catch (IOException e) {
			 System.out.println("Erro ao salvar casos no arquivo: " + e.getMessage());
		 }
 
		 // Testar ler casos do arquivo
		//  ArrayList<Case> casosLidos = new ArrayList<>();
		//  try {
		// 	 GerenciadorCasos.lerArquivo(casosLidos);
		// 	 System.out.println("Casos lidos do arquivo:");
		// 	 for (Case caso : casosLidos) {
		// 		 System.out.println(caso);
		// 	 }
		//  } catch (IOException e) {
		// 	 System.out.println("Erro ao ler casos do arquivo: " + e.getMessage());
		//  }
 
		 // Exemplo de impressão de informações
		//  System.out.println("\nInformações dos advogados e clientes:");
		//  System.out.println("Advogado: " + lawyer1);
		//  System.out.println("Cliente: " + client1);

		try {
            Case casoEncontrado = ListaCases.buscarCase(2);
            System.out.println("Caso encontrado:\n" + casoEncontrado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


		try {
            Case casoParaApagar = ListaCases.buscarCase(1);
            ListaCases.apagarCase(casoParaApagar);
            System.out.println("Caso com ID " + 1 + " apagado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	 }

}

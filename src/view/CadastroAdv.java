package view;

import java.util.ArrayList;
import java.util.List;
import model.Lawyer;

public class CadastroAdv {
    private static List<Lawyer> listaAdvogados = new ArrayList<>();

    public static void cadastroAdv() {
        System.out.println("Cadastro de advogado");
        System.out.println("Digite o nome do advogado:");
        String name = ConsoleNovo.lerString();
        System.out.println("Digite o numero do CEP: ");
        String cep = ConsoleNovo.lerString(); 
        System.out.println("Digite o e-mail:");
        String email = ConsoleNovo.lerString();
        System.out.println("Informe o caso:");
        String cases = ConsoleNovo.lerString();

        Lawyer lawyer = new Lawyer(null, name, email, email, cases, cep, null);
        
        listaAdvogados.add(lawyer);

        System.out.println("Advogado cadastrado com sucesso!");
        System.out.println(lawyer);
    }

    // Método para obter a lista de advogados (caso necessário)
    public static List<Lawyer> getListaAdvogados() {
        return listaAdvogados;
    }
}

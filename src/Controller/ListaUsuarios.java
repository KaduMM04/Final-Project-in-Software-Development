package Controller;
import java.util.ArrayList;

import model.Person;


public class ListaUsuarios{
    private static final ArrayList<Person> ListaUsarios = new ArrayList<>();
    
    public static void salvarUsuario(Person person) {
        ListaUsarios.add(person);
    }

    public static ArrayList<Person> getLista() {
        return ListaUsarios;
    }

    public static void verificarListaVazia() throws Exception {
        if (ListaUsarios.isEmpty()) {
            throw new Exception("Não há usuários cadastrados");
        }
    }
    public static Person buscarUsuario(String name) throws Exception {
        for (Person tempUsuario : ListaUsarios) {
            if (tempUsuario.getName().equals(name)) {
                return tempUsuario;
            }
        }
        throw new Exception("Usuário com o nome " + name + " não encontrado");
    }

    public static void apagarUsuario(Person usuario) {
        ListaUsarios.remove(usuario);
    }

    public static void listarUsuarios() {
        try {
            verificarListaVazia();
            System.out.println("\nUsuários Cadastrados:");
            for (Person tempUsuario : ListaUsarios) {
                System.out.println(tempUsuario.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
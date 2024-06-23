package Controller;
import java.util.arrayList;

class ListarUsuarios {
    private static ArrayList<Person> ListaUsarios = new ArrayList<Person>();

    public static void salvarUsuario(Person) {
        ListarUsuarios.add(Person);
    }

    public static ArrayList<Person> getLista() {
        return ListarUsuarios;
    }

    public static void verificarListaVazia() throws Exception {
        if (ListarUsuarios.isEmpty()) {
            throw new Exception("Não há usuários cadastrados");
        }
    }

    public static Person buscarUsuario(Integer cpf) throws Exception {
        for (Person tempUsuario : ListaUsuarios) {
            if (tempUsuario.getCpf().equals(cpf)) {
                return tempUsuario;
            }
        }
        throw new Exception("Usuário com CPF " + cpf + " não encontrado");
    }

    public static void apagarUsuario(Person usuario) {
        ListarUsuarios.remove(usuario);
    }

    public static void listarUsuarios() {
        try {
            verificarListaVazia();
            System.out.println("\nUsuários Cadastrados:");
            for (Person tempUsuario : ListaUsuarios) {
                System.out.println(tempUsuario.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
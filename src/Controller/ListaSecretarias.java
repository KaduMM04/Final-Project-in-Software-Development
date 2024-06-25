package Controller;

import java.util.ArrayList;
import model.Secretary;

public abstract class ListaSecretarias {

    private static ArrayList<Secretary> listaSecretarias = new ArrayList<>();

    public static void salvarSecretaria(Secretary secretaria) {
        listaSecretarias.add(secretaria);
        System.out.println("Secretária salva: " + secretaria);
    }

    public static ArrayList<Secretary> getListaSecretarias() {
        return listaSecretarias;
    }

    public static void verificarListaVazia() throws Exception {
        if (listaSecretarias.isEmpty()) {
            throw new Exception("Não há secretárias cadastradas");
        }
    }

    public static Secretary buscarSecretaria(Integer registrationNum) throws Exception {
        for (Secretary tempSecretaria : listaSecretarias) {
            if (tempSecretaria.getRegistrationNum().equals(registrationNum)) {
                return tempSecretaria;
            }
        }
        throw new Exception("Secretária com número de registro " + registrationNum + " não encontrada");
    }

    public static void apagarSecretaria(Secretary secretaria) {
        listaSecretarias.remove(secretaria);
        System.out.println("Secretária removida: " + secretaria);
    }

    public static void listarSecretarias() {
        try {
            verificarListaVazia();
            System.out.println("\nSecretárias Cadastradas:");
            for (Secretary tempSecretaria : listaSecretarias) {
                System.out.println(tempSecretaria.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
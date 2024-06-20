package controller;

import java.util.ArrayList;
import java.util.Objects;
import model.Secretary;

public abstract class ListaSecretarias {

    private static ArrayList<Secretary> listaSecretarias = new ArrayList<>();

    public static void salvarSecretaria(Secretary secretaria) {
        listaSecretarias.add(secretaria);
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
        for (Secretary secretaria : listaSecretarias) {
            if (Objects.equals(secretaria.getRegistrationNum(), registrationNum)) {
                return secretaria;
            }
        }
        throw new Exception("Secretária com número de registro " + registrationNum + " não encontrada");
    }

    public static void apagarSecretaria(Secretary secretaria) {
        listaSecretarias.remove(secretaria);
    }

    public static void listarSecretarias() {
        try {
            verificarListaVazia();
            System.out.println("\nSecretárias Cadastradas:");
            for (Secretary secretaria : listaSecretarias) {
                System.out.println(secretaria);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    

}

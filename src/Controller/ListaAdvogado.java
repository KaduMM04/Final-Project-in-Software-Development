package Controller;

import java.util.ArrayList;
import model.Lawyer;

public abstract class ListaAdvogado {

    private static ArrayList<Lawyer> listaAdvogados = new ArrayList<>();

    public static void salvarAdvogado(Lawyer advogado) {
        listaAdvogados.add(advogado);
        System.out.println("Advogado salvo: " + advogado);
    }

    public static ArrayList<Lawyer> getListaAdvogados() {
        return listaAdvogados;
    }

    public static void verificarListaVazia() throws Exception {
        if (listaAdvogados.isEmpty()) {
            throw new Exception("Não há advogados cadastrados");
        }
    }

    public static Lawyer buscarAdvogado(String oab) throws Exception {
        for (Lawyer tempAdvogado : listaAdvogados) {
            if (tempAdvogado.getOab().equals(oab)) {
                return tempAdvogado;
            }
        }
        throw new Exception("Advogado com OAB " + oab + " não encontrado");
    }

    public static void apagarAdvogado(Lawyer advogado) {
        listaAdvogados.remove(advogado);
        System.out.println("Advogado removido: " + advogado);
    }

    public static void listarAdvogados() {
        try {
            verificarListaVazia();
            System.out.println("\nAdvogados Cadastrados:");
            for (Lawyer tempAdvogado : listaAdvogados) {
                System.out.println(tempAdvogado.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
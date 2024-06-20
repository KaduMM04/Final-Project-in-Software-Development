package controller;

import java.util.ArrayList;
import java.util.Objects;
import model.Lawyer;

public abstract class ListaAdvogados {

    private static ArrayList<Lawyer> listaAdvogados = new ArrayList<>();

    public static void salvarAdvogado(Lawyer advogado) {
        listaAdvogados.add(advogado);
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
        for (Lawyer advogado : listaAdvogados) {
            if (Objects.equals(advogado.getOab(), oab)) {
                return advogado;
            }
        }
        throw new Exception("Advogado com OAB " + oab + " não encontrado");
    }

    public static void apagarAdvogado(Lawyer advogado) {
        listaAdvogados.remove(advogado);
    }

}

    


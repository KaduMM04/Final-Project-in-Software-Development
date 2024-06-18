package controller;
import java.util.ArrayList;

import model.Case;

public class ListaCasos {


public abstract class ListaCases {

    private static ArrayList<Case> listaCases = new ArrayList<>();

    public static void salvarCase(Case caso) {
        listaCases.add(caso);
    }

    public static ArrayList<Case> getListaCases() {
        return listaCases;
    }

    public static void verificarListaVazia() throws Exception {

        if (listaCases.isEmpty()) {
            throw new Exception("\nNão há casos cadastrados");
        }

    }

    public static Case buscarCase(int id) throws Exception {

        for(Case tempCase : listaCases) {

           /// if (tempCase.getId().contains(id)) {
           ///    return tempCase;
           /// }
        }

        throw new Exception("Caso " + id + " não encontrado");
    }

    public static void apagarCase(Case caso) {
        listaCases.remove(caso);
    }
}

}
    


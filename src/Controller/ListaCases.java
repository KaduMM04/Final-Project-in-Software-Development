package Controller;

import java.util.ArrayList;
import model.Case;

public abstract class ListaCases {

    private static ArrayList<Case> listaCases = new ArrayList<>();

    public static void salvarCase(Case caso) {
        listaCases.add(caso);
        System.out.println("\nCaso salvo: " + caso.showCaseData());
    }

    public static ArrayList<Case> getListaCases() {
        return listaCases;
    }

    public static void verificarListaVazia() throws Exception {
        if (listaCases.isEmpty()) {
            throw new Exception("Não há casos cadastrados");
        }
    }

    public static Case buscarCase(Integer id) throws Exception {
        for (Case tempCase : listaCases) {
            if (tempCase.getId().equals(id)) {
                return tempCase;
            }
        }
        throw new Exception("Caso " + id + " não encontrado");
    }

    public static void apagarCase(Case caso) {
        listaCases.remove(caso);
        System.out.println("Caso removido: " + caso);
    }

    public static void listarCases() {

        try {

            ListaCases.verificarListaVazia();

            System.out.println("\nCasos Cadastrados");

            for(Case tempCase : listaCases) {

                System.out.println(tempCase.showCaseData());

            }


        } catch (Exception e) {

            System.out.println(e.getMessage());
        }


    }

}

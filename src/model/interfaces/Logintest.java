package model.interfaces;

import Controller.ListaUsuarios;
import model.Person;

public class Logintest{
    public boolean login(String email, String password) {
        for (Person user : ListaUsuarios.getLista()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login efetuado com sucesso!");
                return true;
            }
        }
        System.out.println("Falha no login!");
        return false;
    }
}
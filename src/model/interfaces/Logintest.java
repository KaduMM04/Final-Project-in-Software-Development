package model.interfaces;

class Logintest{
    public boolean login(String email, String password) {
      for (Person user : ListarUsuarios.getLista()) {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            System.out.println("Login efetuado com sucesso!");
            return true;
        }
    }
    return false;
    }
}
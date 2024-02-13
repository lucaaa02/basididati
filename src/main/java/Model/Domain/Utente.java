package Model.Domain;

public class Utente {

    private final String username;
    private final String password;
    public Utente(String user, String pass){
        username=user;
        password=pass;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}

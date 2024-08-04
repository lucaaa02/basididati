package Model.Domain;

public class Utente {

    private final String username;
    private final String password;
    private String role;
    public Utente(String user, String pass){
        username=user;
        password=pass;
    }
    public Utente(String user, String pass, int rol){
        username=user;
        password=pass;
        if(rol==1){
            role="magazzino";
            }
        else{
            role="segreteria";
        }
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public String getRole() {
        return role;
    }

}

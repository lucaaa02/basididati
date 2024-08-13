package Model.Domain;

public class Utente {

    private final String username;
    private final String password;
    private int role;
    public Utente(String user, String pass){
        username=user;
        password=pass;
    }
    public Utente(String user, String pass, int rol){
        username = user;
        password = pass;
        role = rol;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    public String getRole() {
        if(role==1){
            return "segreteria";
        }
        else if(role==2){
            return "magazzino";
        }
        else {
            return "tecnico";
        }
    }
    public int getNumber() {
        return role;
    }

}

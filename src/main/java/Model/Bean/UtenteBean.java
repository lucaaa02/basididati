package Model.Bean;

public class UtenteBean {
    private final String username;
    private final String password;
    public int role;

    public UtenteBean(String user, String pass) {
        username = user;
        password = pass;
    }

    public UtenteBean(String user, String pass, int rol) {
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
        if (role == 1) {
            return "segreteria";
        } else {
            return "magazzino";
        }
    }

    public int getNumber() {
        return role;
    }
}

package Controller;

import Model.Bean.UtenteBean;
import Model.DAO.UtenteDAO;
import Model.Domain.Utente;
import View.LoginView;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    public static Utente login() throws SQLException {
        UtenteBean utente;
        try{
            utente = LoginView.getCredential();
        }
        catch(IOException e){
            throw new RuntimeException("errore durante recupero credenziali " + e.getMessage());
        }
        Utente user;
        try {
            UtenteDAO utenteDAO = new UtenteDAO();
            user = utenteDAO.execute(utente);
            if (user.getPassword()==null||!user.getPassword().equals(utente.getPassword())){
                throw new RuntimeException("credenziali errate");
            }
            return user;
        }
        catch(SQLException e ){
            throw new SQLException(e.getMessage());
        }





    }
}

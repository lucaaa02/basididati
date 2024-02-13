package Controller;

import Model.DAO.UtenteDAO;
import Model.Domain.Utente;
import View.LoginView;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    public static boolean login() throws SQLException {
        Utente utente;
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
            if (user.getPassword()==null){
                throw new RuntimeException("credenziali errate");
            }
            return user.getPassword().equals(utente.getPassword());
        }
        catch(SQLException e ){
            throw new SQLException(e.getMessage());
        }





    }
}

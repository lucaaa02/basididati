package Controller;

import java.sql.SQLException;

public class MainController {
    public void start() throws SQLException {
        if(LoginController.login()){
            System.out.println("accesso effettuato");
        }
        else{System.out.println("accesso non effettuato");}


    }
}

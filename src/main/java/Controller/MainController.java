package Controller;

import Model.DAO.Connectivity;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {
    public void start() throws SQLException, IOException {
        if(LoginController.login()){
            System.out.println("accesso effettuato");
            AgencyController pagina =new AgencyController();
            pagina.start();
        }
        else{
            System.out.println("accesso non effettuato");
        }

        try{
            Connectivity.getSingletonInstance();
        } catch (SQLException|IOException e) {
            throw new RuntimeException("connessione fallita"+e);
        }




    }


}

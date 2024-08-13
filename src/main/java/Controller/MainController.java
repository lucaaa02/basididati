package Controller;

import Model.DAO.Connectivity;
import Model.Domain.Utente;
import View.SegreteriaView;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {
    Utente currentUser;
    public void start() throws SQLException, IOException {
        try {
            currentUser=LoginController.login();
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
            this.start();
        }
        System.out.println("accesso effettuato come "+ currentUser.getRole());
        int n=currentUser.getNumber();
        switch(n){
            case 1:
                SegreteriaView spagina=new SegreteriaView();
                spagina.getChoice();
            case 2:
                MagazzinoController magazzinoController= new MagazzinoController();
                magazzinoController.start();


        }

        try{
            Connectivity.getSingletonInstance();
        } catch (SQLException|IOException e) {
            throw new RuntimeException("connessione fallita"+e);
        }




    }


}

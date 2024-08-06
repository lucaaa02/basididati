package Controller;

import Model.DAO.RicambiDAO;
import Model.Domain.Ricambi;
import View.MagazzinoView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazzinoController {
    MagazzinoView pagina;
    public void start() throws IOException, SQLException {

        pagina =new MagazzinoView();
        int n;
        n= pagina.getChoice();
        switch(n){
            case 1:
                getProductC();
        }
    }
    public void getProductC() throws SQLException, IOException {
        int n;
        n=MagazzinoView.getTypeC();
        RicambiDAO ricambiDAO=new RicambiDAO();
        List<Ricambi> ricambi;
        ricambi=ricambiDAO.getProduct(n);
        pagina.printRicambi(ricambi);
        this.start();

    }
}

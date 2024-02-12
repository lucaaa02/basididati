package Controller;

import Model.DAO.Connectivity;
import Model.DAO.RicambiCellDAO;
import Model.Domain.Ricambi;
import View.AziendaView;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {
    public void start() throws SQLException {
        if(LoginController.login()){
            System.out.println("accesso effettuato");
        }
        else{
            System.out.println("accesso non effettuato");
        }

        try{
            Connectivity.getSingletonInstance();
        } catch (SQLException|IOException e) {
            throw new RuntimeException("connessione fallita"+e);
        }

        while(true){
            int choice=0;
            try {
                choice = AziendaView.getChoice();
            }
            catch(IOException e){
                throw new RuntimeException("errore durante lettura dell'operazione"+e);
            }
            switch (choice) {
                case 1:
                    System.out.println("Codice|Descrizione                |Partita iva azienda|Prodotto|Quantità");
                    RicambiCellPrint();
                    break;
                case 2:
                    System.out.println("Hai selezionato l'opzione 2");
                    break;
                case 3:
                    System.out.println("Hai selezionato l'opzione 3");
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }

        }


    }
    private void RicambiCellPrint() throws SQLException {
        Ricambi ricambio;
        try {
            RicambiCellDAO ricambiDAO = new RicambiCellDAO();
            ricambio = ricambiDAO.execute();
            System.out.println(ricambio.getCodice()+" |"+ricambio.getDescrizione()+"|"+ricambio.getPartitaIva()+"        |"+ricambio.getTipo()+" |"+ricambio.getDisponibilita());
        }
        catch(SQLException e ){
            throw new SQLException(e.getMessage());
        }

    }

}

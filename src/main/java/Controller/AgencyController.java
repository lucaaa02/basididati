package Controller;

import Model.DAO.RicambiDAO;
import Model.Domain.Ricambi;
import View.AziendaView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AgencyController {
    public void start() throws SQLException {
        boolean exit=true;
        while (exit) {
            int choice;
            try {
                choice = AziendaView.getChoice();
            } catch (IOException e) {
                throw new RuntimeException("errore durante lettura dell'operazione" + e);
            }
            switch (choice) {
                case 0:
                    exit=false;
                case 1:
                    RicambiCellPrint(choice);
                    break;
                case 2:
                    RicambiCellPrint(choice);
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
    private void RicambiCellPrint(int n) throws SQLException {
        List<Ricambi> ricambi;
        try {
            RicambiDAO ricambiDAO = new RicambiDAO();
            ricambi=ricambiDAO.execute(n);
        }
        catch(SQLException e ) {
            throw new SQLException(e.getMessage());
        }
        System.out.println("Disponibilità | Descrizione                      | Tipo");
        System.out.println("--------------------------------------------------------------");

// Determina la larghezza massima per ogni colonna
        int maxWidthDisponibilita = 12;
        int maxWidthDescrizione = 30;
        int maxWidthTipo = 12;

// Itera su ogni oggetto Ricambi nella lista e stampa gli attributi
        for (Ricambi ricambio : ricambi) {
            // Costruisci la stringa formattata per ogni riga
            String formattedRow = String.format(" %-"+ maxWidthDisponibilita +"s | %-"+ maxWidthDescrizione +"s | %-"+ maxWidthTipo +"s",
                    ricambio.getDisponibilita(),
                    ricambio.getDescrizione(),
                    ricambio.getTipo());
            // Stampare la riga formattata
            System.out.println(formattedRow);
        }

    }
}

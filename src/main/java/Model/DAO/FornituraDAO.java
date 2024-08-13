package Model.DAO;

import Model.Domain.Fornitura;
import exception.NoDataFoundException;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornituraDAO {
    private final Connectivity connection;

    public FornituraDAO() {
        try {
            connection = Connectivity.getSingletonInstance();
        } catch (SQLException | IOException e) {
            throw new RuntimeException("errore durante la connessione al db " + e.getMessage());
        }
    }

    public List<Fornitura> getFornitura(String code) throws SQLException, NoDataFoundException {
        List<Fornitura> allFornitura = new ArrayList<>();
        CallableStatement cs = connection.conn.prepareCall("{call GetFornitura(?)}");
            cs.setString(1, code);
            boolean status = cs.execute();
            if (status) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    int prezzo = rs.getInt(1);
                    String nome = rs.getString(2);
                    int quantita = rs.getInt(3);
                    int tipo = rs.getInt(4);
                    String descrizione = rs.getString(5);
                    String iva = rs.getString(6);
                    Fornitura fornitura = new Fornitura(descrizione, nome, prezzo, quantita, tipo,iva);
                    allFornitura.add(fornitura);
                }
            }
            if(allFornitura.isEmpty()){
                throw new NoDataFoundException("Nessun dato trovato per il codice: " + code);
            }

        return allFornitura;


    }

    public void doOrder(int prezzo, int quantita, String code, String iva) {
        int prezzoTotale = prezzo * quantita;
        try (CallableStatement cs = connection.conn.prepareCall("{call doOrder(?,?,?,?)}")) {
            cs.setString(1, code);
            cs.setInt(2, prezzoTotale);
            cs.setInt(3, quantita);
            cs.setString(4, iva);
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace(); // Stampa dettagli sull'errore
            throw new RuntimeException(e);
        }
    }
    public List<Fornitura> getOrder(int n) throws SQLException, NoDataFoundException {
        List<Fornitura> allFornitura = new ArrayList<>();
        CallableStatement cs = connection.conn.prepareCall("{call GetOrder(?)}");
        cs.setInt(1, n);
        boolean status = cs.execute();
        if (status) {
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                String nome = rs.getString(1);
                int quantita = rs.getInt(2);
                int prezzo = rs.getInt(3);
                String descrizione = rs.getString(4);
                String order = rs.getString(5);
                Fornitura fornitura = new Fornitura(descrizione, nome, prezzo, quantita,order);
                allFornitura.add(fornitura);
            }
        }
        if(allFornitura.isEmpty()){
            throw new NoDataFoundException("Nessun ordine trovato");
        }

        return allFornitura;


    }
    public void setOrder(String code) throws SQLException {
        try(CallableStatement cs = connection.conn.prepareCall("{call confirmOrder(?)}")){
            cs.setString(1,code);
            cs.execute();
        }
        catch (SQLException e){
            throw new SQLException();
        }


    }
}

package Model.DAO;

import Model.Domain.Ricambi;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RicambiDAO implements GenericDAO<List<Ricambi>> {
    private final Connectivity connection;
    public RicambiDAO() throws SQLException {
        try {
            connection =Connectivity.getSingletonInstance();
        }
        catch(SQLException | IOException e){
            throw new RuntimeException("errore durante la connessione al db "+e.getMessage());
        }
    }
    @Override
    public List<Ricambi> execute(Object... params) throws SQLException {
        List<Ricambi> ricambi = new ArrayList<>();
        int n = (int) params[0];
        CallableStatement cs=null;
        try {
        switch (n) {
            case 1:

                    cs = connection.getConn().prepareCall("{call GetRicambiCell()}");


                    break;
                    case 2:
                        cs = connection.getConn().prepareCall("{call GetRicambiCom()}");

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + n);

        }
        assert cs != null;
        boolean status = cs.execute();
                    if (status) {
                        ResultSet rs = cs.getResultSet();
                        while (rs.next()) {
                            Ricambi ricambio = new Ricambi(rs.getString(1), rs.getString(2), rs.getInt(3));
                            ricambi.add(ricambio);
                        }

                    }
        }
        catch (SQLException e) {
            throw new SQLException("errore durante la lettura: " + e.getMessage());
        }
        finally {
            // Chiudi l'oggetto CallableStatement nel blocco finally
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    throw new SQLException("errore durante chiusura"+e.getMessage()); // o gestione dell'eccezione appropriata
                }
            }
        }
                return ricambi;}
    }


package Model.DAO;

import Model.Domain.Ricambi;
import Model.Domain.Utente;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
                            Ricambi ricambio = new Ricambi(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
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
                } catch (SQLException ignored) {

                }
            }
        }
                return ricambi;
    }

    public boolean CheckProduct(String code) throws SQLException {
        boolean result;
        try (CallableStatement cs = connection.conn.prepareCall("{call VerificaEsistenzaProdotto(?,?)}")) {

            cs.setString(1, code);
            cs.registerOutParameter(2, Types.BINARY);
            cs.executeQuery();
            result =(cs.getBoolean(2));
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return result;

    }
    public boolean CheckPiva(String primo, String secondo) throws SQLException {
        int result;
        try (CallableStatement cs = connection.conn.prepareCall("{call VerificaCompatibilitàPIva(?,?,?)}")) {

            cs.setString(1, primo);
            cs.setString(2, secondo);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.executeQuery();
            result =cs.getInt(3);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        if (result==1){
            return true;
        }
        else{
            return false;
        }

    }
    }





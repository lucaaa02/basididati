package Model.DAO;

import Model.Domain.Ordine;
import Model.Domain.Ricambi;
import Model.Domain.Utente;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class OrdineDAO implements GenericDAO<List<Ordine>> {
    private final Connectivity connection;
    public OrdineDAO() throws SQLException {
        try {
            connection =Connectivity.getSingletonInstance();
        }
        catch(SQLException | IOException e){
            throw new RuntimeException("errore durante la connessione al db "+e.getMessage());
        }
    }
    @Override
    public List<Ordine> execute(Object... params) throws SQLException{
        return null;
    }

    public void ordination(List <Ordine> ordine) throws SQLException {
        int n;
        try (CallableStatement cs = connection.conn.prepareCall("{call InserisciOrdine(?)}")) {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.executeQuery();
            n = cs.getInt(1);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        for (int i=0;i<ordine.size();i++) {
            try (CallableStatement cs = connection.conn.prepareCall("{call CompletaOrdine(?,?,?)}")) {
                cs.setString(1, ordine.get(i).getCodici());
                cs.setInt(2, ordine.get(i).getQuantita());
                cs.setInt(3, n);
                cs.executeQuery();
            } catch (SQLException e) {
                throw new SQLException(e.getMessage());
            }
        }
    }//problema quantità degli ordini
}
package Model.DAO;

import Model.Domain.CompTel;
import Model.Domain.Ricambi;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RicambiDAO {
    private final Connectivity connection;
    public RicambiDAO(){
        try {
            connection =Connectivity.getSingletonInstance();
        }
        catch(SQLException | IOException e){
            throw new RuntimeException("errore durante la connessione al db "+e.getMessage());
        }
    }
    public List<Ricambi> getProduct(int n) throws SQLException {
        String tipo=CompTel.getDescriptionByCode(n);
        List<Ricambi> allRicambi = new ArrayList<>();
        try (CallableStatement cs = connection.conn.prepareCall("{call GetCompT(?)}")) {
            cs.setString(1, tipo);
            boolean status=cs.execute();
            if(status){
                ResultSet rs=cs.getResultSet();
                while(rs.next()){
                    int quantita=rs.getInt(1);
                    String codice=rs.getString(2);
                    Ricambi ricambio=new Ricambi(codice,tipo,quantita);
                    allRicambi.add(ricambio);
                }
            }
        }
        catch (SQLException e) {
            throw new SQLException("errore durante la lettura: " + e.getMessage());
        }
        return allRicambi;

    }
}

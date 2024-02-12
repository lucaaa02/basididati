package Model.DAO;

import Model.Domain.Ricambi;
import Model.Domain.TipologiaRicambioCell;
import Model.Domain.Utente;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class RicambiCellDAO implements GenericDAO<Ricambi> {
    private final Connectivity connection;
    public RicambiCellDAO(){
        try {
            connection =Connectivity.getSingletonInstance();
        }
        catch(SQLException | IOException e){
            throw new RuntimeException("errore durante la connessione al db "+e.getMessage());
        }
    }
    @Override
    public Ricambi execute(Object... params) throws SQLException {
        Ricambi ricambio;

        try {
            CallableStatement cs = connection.conn.prepareCall("{call GetRicambiCell(?,?,?,?,?,?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.executeQuery();
            String codice= cs.getString(1);
            int disponibilita = cs.getInt(2);
            String descrizione = cs.getString(3);
            double prezzo = cs.getDouble(4);
            String tipo=cs.getString(5);
            String pIva=cs.getString(6);
            ricambio=new Ricambi(codice,disponibilita,prezzo,descrizione,pIva,tipo);

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return ricambio;

    }
}

package Model.DAO;

import Model.Bean.UtenteBean;
import Model.Domain.Utente;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class UtenteDAO implements GenericDAO<Utente> {
    private final Connectivity connection;
    public UtenteDAO(){
        try {
            connection =Connectivity.getSingletonInstance();
        }
        catch(SQLException | IOException e){
                throw new RuntimeException("errore durante la connessione al db "+e.getMessage());
            }
        }
    @Override
    public Utente execute(Object... params) throws SQLException {
        UtenteBean user = (UtenteBean) params[0];
        Utente credenziali;
        try (CallableStatement cs = connection.conn.prepareCall("{call GetLogin(?,?,?)}")) {

            cs.setString(1, user.getUsername());
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.executeQuery();
            String password = cs.getString(2);
            int role = cs.getInt(3);
            String username = user.getUsername();
            credenziali = new Utente(username, password,role);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        // Chiudi l'oggetto CallableStatement nel blocco finally
        return credenziali;

    }
}

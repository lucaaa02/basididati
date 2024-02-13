package Model.DAO;

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
        Utente user = (Utente) params[0];
        Utente credenziali;
        try (CallableStatement cs = connection.conn.prepareCall("{call GetLogin(?,?)}")) {

            cs.setString(1, user.getUsername());
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.executeQuery();
            String password = cs.getString(2);
            String username = user.getUsername();
            credenziali = new Utente(username, password);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        // Chiudi l'oggetto CallableStatement nel blocco finally
        return credenziali;

    }
}

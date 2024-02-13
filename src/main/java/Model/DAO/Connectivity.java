package Model.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Connectivity {
    protected Connection conn;
    private static Connectivity singletonClass =null;

    protected Connectivity() throws IOException, SQLException {
        InputStream input;
        try{
            input = new FileInputStream("src/main/resources/db.properties");
        }
        catch(IOException e){
            throw new IOException("errore apertura file");
        }
        Properties properties = new Properties();
        properties.load(input);
        String connectionUrl = properties.getProperty("CONNECTION_URL");
        String user = properties.getProperty("DB_USER");
        String pass = properties.getProperty("DB_PASS");
        conn = DriverManager.getConnection(connectionUrl, user, pass);

    }

    public Connection getConn(){
        return conn;
    }


    //creo un singleton per assicurarmi di avere solo un'istanza di connessione
    public static synchronized Connectivity getSingletonInstance () throws SQLException, IOException {
        if(Connectivity.singletonClass ==null) {
            Connectivity.singletonClass = new Connectivity();
        }
        return singletonClass;
    }
}
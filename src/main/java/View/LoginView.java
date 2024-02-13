package View;

import Model.Domain.Utente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginView {
    public static Utente getCredential() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("username: ");
        String username = reader.readLine();
        System.out.print("password: ");
        String password = reader.readLine();
        return new Utente(username,password);
    }
}

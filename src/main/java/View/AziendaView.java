package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AziendaView {
    public static int getChoice() throws IOException {
        int choice;
        System.out.println("Benvenuto nel sistema interno di FixIT");
        System.out.println("/*************************************/");
        System.out.println("Selezionare un numero per procedere con le operazioni");
        System.out.println("1-Controllare giacenza ricambi per cellulari");
        System.out.println("2-Controllare giacenza ricambi per computer");
        System.out.println("3-uscire dal programma");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.println("numero non valido");
        }


        return choice;
    }

    public static String getProduct() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserire il codice di prodotto che si vuole inserire(i prodotti che si desidera ordinare devono essere distribuiti dalla stessa azienda)=>");
        String code = reader.readLine();
        return code;
    }
}

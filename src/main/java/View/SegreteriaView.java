package View;

import java.io.IOException;
import java.util.Scanner;

public class SegreteriaView {
    public int getChoice() throws IOException {
        int choice;
        System.out.println("Benvenuto nel sistema interno di FixIT");
        System.out.println("/*************************************/");
        System.out.println("Selezionare un numero per procedere con le operazioni");
        System.out.println("1-Inserire nuovo intervento");
        System.out.println("2-Visualizzare interventi");
        System.out.println("3-Confermare pagamento intervento");
        Scanner input = new Scanner(System.in);
        while (true) {
            choice = input.nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.println("numero non valido");
        }


        return choice;
    }
}

package View;

import java.io.IOException;
import java.util.Scanner;

public class AziendaView {
    public static int getChoice() throws IOException {
        int choice=0;
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
}

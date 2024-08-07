package View;

import Model.Domain.Ricambi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class MagazzinoView {
    public int getChoice() throws IOException {
        int choice;
        System.out.println("Benvenuto nel sistema interno di FixIT");
        System.out.println("/*************************************/");
        System.out.println("Selezionare un numero per procedere con le operazioni");
        System.out.println("1-Controllare giacenza ricambi per cellulari");
        System.out.println("2-Controllare giacenza ricambi per computer");
        System.out.println("3-Ordinare ricambi");
        System.out.println("4-Confermare ordini arrivati");
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

    public static String getProduct() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserire il codice di prodotto che si vuole inserire(i prodotti che si desidera ordinare devono essere distribuiti dalla stessa azienda)=>");
        String code = reader.readLine();
        return code;
    }
    public static int getTypeC(){

        int choice;
        System.out.println("Selezionare un numero per la lista delle componenti");
        System.out.println("/*************************************/");
        System.out.println("1-schede madri");
        System.out.println("2-connettori USB");
        System.out.println("3-batterie");
        System.out.println("4-schermi");
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

    public void printRicambi(List<Ricambi> allRicambi){
        for (Ricambi ricambio : allRicambi){
            System.out.println(ricambio.getCodice()+"|"+ricambio.getDescrizione()+"|"+ricambio.getQuantita());
            System.out.println("/******************/");
        }
    }
}

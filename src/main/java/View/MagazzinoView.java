package View;

import Model.Domain.CompCom;
import Model.Domain.CompTel;
import Model.Domain.Fornitura;
import Model.Domain.Ricambi;

import java.util.List;
import java.util.Scanner;

public class MagazzinoView {
    public int getChoice() {
        int choice;
        System.out.println("Benvenuto nel sistema interno di FixIT");
        System.out.println("/*************************************/");
        System.out.println("Selezionare un numero per procedere con le operazioni");
        System.out.println("1-Controllare giacenza ricambi per cellulari");
        System.out.println("2-Controllare giacenza ricambi per computer");
        System.out.println("3-Ordinare ricambi");
        System.out.println("4-Controllare ordini");
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

    public static int getTypeT() {

        int choice;
        System.out.println("Selezionare un numero per la lista delle componenti");
        System.out.println("0-per tornare indietro");
        System.out.println("1-schede madri");
        System.out.println("2-connettori USB");
        System.out.println("3-batterie");
        System.out.println("4-schermi");
        Scanner input = new Scanner(System.in);
        while (true) {
            choice = input.nextInt();
            if (choice >= 0 && choice <= 4) {
                break;
            }
            System.out.println("numero non valido");
        }


        return choice;

    }

    public static int getTypeC() {

        int choice;
        System.out.println("Selezionare un numero per la lista delle componenti");
        System.out.println("0-per tornare indietro");
        System.out.println("1-schede madri");
        System.out.println("2-moduli RAM");
        System.out.println("3-batterie");
        System.out.println("4-schermi");
        System.out.println("5-tastiere");
        System.out.println("6-trackpad");
        System.out.println("7-ventole");
        Scanner input = new Scanner(System.in);
        while (true) {
            choice = input.nextInt();
            if (choice >= 0 && choice <= 7) {
                break;
            }
            System.out.println("numero non valido");
        }


        return choice;

    }

    public void printRicambi(List<Ricambi> allRicambi) {
        for (Ricambi ricambio : allRicambi) {
            System.out.println(ricambio.getCodice() + "|" + ricambio.getDescrizione() + "|" + ricambio.getQuantita());
        }
    }

    public int[] printFornito(List<Fornitura> allFornitura) {
        int i = 1;
        int choice;
        int number;

        if (allFornitura.get(1).getTipo() == 0) {
            System.out.println("Componente per telefono");
        } else {
            System.out.println("Componente per computer");
        }
        System.out.println("TIPO->" + allFornitura.get(1).getDescrizione());
        System.out.println("quantità rimanente in magazzino->" + allFornitura.get(1).getQuantita());

        System.out.println("------------------------------------------");
        for (Fornitura fornitura : allFornitura) {
            System.out.println(i + ") azienda->" + fornitura.getNome() + " prezzo" + fornitura.getPrezzo() + "€");
            System.out.println("-----------------------------------------------");
            i++;
        }
        System.out.println("inserire numero per indicare da chi si desidera acquistare");
        Scanner input = new Scanner(System.in);
        while (true) {
            choice = input.nextInt();
            if (choice >= 0 && choice <= allFornitura.size()) {
                break;
            }
            System.out.println("numero non valido");
        }
        System.out.println("inserire numero per indicare quanti componenti acquistare, 0 per annullare");
        input = new Scanner(System.in);
        number = input.nextInt();
        int[] info = {choice, number};
        return info;

    }

    public String ricambio() {
        String code;
        System.out.println("Inserire il codice della componente da ordinare, 0 per annullare");
        Scanner scanner = new Scanner(System.in);
        code = scanner.nextLine();
        return code;

    }

    public void printOrder(String code) {
        System.out.println("l'ordine della componente con codice" + code + "è stata eseguita con successo");
    }

    public int getTypeOrder() {
        int choice;
        System.out.println("Selezionare un numero per l'azione da compiere");
        System.out.println("0-per tornare indietro");
        System.out.println("1-confermare ordini arrivati");
        System.out.println("2-visualizzare ordini passati");
        Scanner input = new Scanner(System.in);
        while (true) {
            choice = input.nextInt();
            if (choice >= 0 && choice <= 2) {
                break;
            }
            System.out.println("numero non valido");
        }


        return choice;

    }

    public void printOrdeer(List<Fornitura> allFornitura) {
        int i = 1;
        for (Fornitura fornitura : allFornitura) {
            System.out.println(i + ") " + fornitura.getDescrizione() + " ordinato da: " + fornitura.getNome() + " " + fornitura.getQuantita() + " pezzi, acquistati per €:" + fornitura.getPrezzo());
            i++;
        }
    }

    public int getOrderConfirm(int n) {
        System.out.println("inserire ordine da convalidare, 0 per annullare");
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            choice = input.nextInt();
            if (choice >= 0 && choice <= n) {
                break;
            }
            System.out.println("numero non valido");
        }
        return choice;

    }
}

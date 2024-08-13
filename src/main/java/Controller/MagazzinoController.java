package Controller;

import Model.DAO.FornituraDAO;
import Model.DAO.RicambiDAO;
import Model.Domain.Fornitura;
import Model.Domain.Ricambi;
import View.MagazzinoView;
import exception.NoDataFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MagazzinoController {
    MagazzinoView pagina;
    public void start() throws IOException, SQLException {

        pagina =new MagazzinoView();
        int n;
        n= pagina.getChoice();
        switch(n){
            case 1:
                getProductT();
            case 2:
                getProductC();
            case 3:
                order();
            case 4:
                checkOrder();
        }
    }
    private void getProductT() throws SQLException, IOException {
        int n = 10;
        while(n!=0){
            n=MagazzinoView.getTypeT();
            RicambiDAO ricambiDAO=new RicambiDAO();
            List<Ricambi> ricambi;
            ricambi=ricambiDAO.getProduct(n, 1);
            pagina.printRicambi(ricambi);
        }
        this.start();

    }
    private void getProductC() throws SQLException, IOException {
        int n = 10;
        while(n!=0){
            n=MagazzinoView.getTypeC();
            RicambiDAO ricambiDAO=new RicambiDAO();
            List<Ricambi> ricambi;
            ricambi=ricambiDAO.getProduct(n, 0);
            pagina.printRicambi(ricambi);
        }
        this.start();


    }
    private void order() throws SQLException, IOException {
        String code=pagina.ricambio();
        if (code.equals("0")){
            this.start();
        }
            FornituraDAO fornituraDAO=new FornituraDAO();
            try {
                List<Fornitura> allFornitura=fornituraDAO.getFornitura(code);
                fornituraDAO.getFornitura(code);
                int[] n = pagina.printFornito(allFornitura);
                if (n[1]==0) {
                    this.start();
                }
                int prezzo = allFornitura.get(n[0] - 1).getPrezzo();
                int quantita = n[1];
                String iva = allFornitura.get(n[0] - 1).getPartitaIVA();
                fornituraDAO.doOrder(prezzo, quantita, code, iva);
            } catch (NoDataFoundException e) {
                System.out.println(e.getMessage());
                this.order();
            }
            pagina.printOrder(code);

    }
    private void checkOrder() throws SQLException, IOException {
        int choice;
        choice=pagina.getTypeOrder();
        FornituraDAO fornituraDAO=new FornituraDAO();
        if (choice==0){
            this.start();
        }

            List<Fornitura> allFornitura;
            try{
                if(choice==1) {
                    allFornitura = fornituraDAO.getOrder(0);
                    pagina.printOrdeer(allFornitura);
                    choice=pagina.getOrderConfirm(allFornitura.size());
                    String code;
                    code=allFornitura.get(choice-1).getCode();
                    fornituraDAO.setOrder(code);
                    System.out.println("quantità aggiornata e ordine confermato correttamente");
                    this.start();

                    if (choice==0){
                        this.start();
                    }
                }
                else{
                    allFornitura = fornituraDAO.getOrder(1);
                    pagina.printOrdeer(allFornitura);
                    Thread.sleep(3000);
                    this.start();
                }
            } catch (NoDataFoundException e) {
                System.out.println(e.getMessage());
                this.start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }

    }



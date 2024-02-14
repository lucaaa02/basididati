package Controller;

import Model.DAO.OrdineDAO;
import Model.DAO.RicambiDAO;
import Model.Domain.Ordine;
import View.AziendaView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController {


    public void OrderProduct() throws IOException, SQLException {
        String code;
        List<String> codici=new ArrayList<>();
        List<Integer> numeri=new ArrayList<>();
        List<Ordine> ordini=new ArrayList<>();
        RicambiDAO ricambiDAO;
        Scanner input = new Scanner(System.in);
            System.out.print("Quanti tipi di prodotti si desidera acqusitare? ");
            int n = input.nextInt();
        try{
            ricambiDAO=new RicambiDAO();
        }
        catch(SQLException e){
            throw new SQLException("errore connessione"+e.getMessage());
        }
        for (int i=0;i<n;i++){
        code= AziendaView.getProduct();


        if(!ricambiDAO.CheckProduct(code)){
                System.out.println("il prodotto non esiste");
                System.out.println("inserire un prodotto valido");
                i--;
                continue;
            }
        if (i>0){
            if(!ricambiDAO.CheckPiva(code, codici.get(i-1))){
                System.out.println("il prodotto non appartiene alla stessa azienda del precedente");
                AgencyController ag=new AgencyController();
                ag.start();
            }
        }
            System.out.print("Quanti oggetti di questo tipo si desidera acqusitare? ");
            int m = input.nextInt();

        codici.add(code);
        numeri.add(m);
        ordini.add(new Ordine(code,m));

        }
        OrdineDAO ordineDao;
      try{
          ordineDao=new OrdineDAO();
      }
      catch(SQLException e){
          throw new SQLException("errore connessione"+e.getMessage());
      }
        ordineDao.ordination(ordini);
        System.out.println("ordine eseguito");
        AgencyController ag=new AgencyController();
        ag.start();

    }

    public List <Ordine> GetOrder() throws SQLException {
        List<Ordine> ordini=new ArrayList<>();
        OrdineDAO ordineDao;
        try{
            ordineDao=new OrdineDAO();
        }
        catch(SQLException e){
            throw new SQLException("errore connessione"+e.getMessage());
        }
        ordini=ordineDao.execute();
        return ordini;
    }

}

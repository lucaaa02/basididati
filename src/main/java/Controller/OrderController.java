package Controller;

import Model.DAO.RicambiDAO;
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
        Scanner input = new Scanner(System.in);
            System.out.print("Quanti tipi di prodotti si desidera acqusitare? ");
            int n = input.nextInt();
        for (int i=0;i<n;i++){
        code= AziendaView.getProduct();
        RicambiDAO ricambiDAO=new RicambiDAO();
        if(!ricambiDAO.CheckProduct(code)){
                System.out.println("il prodotto non esiste");
                AgencyController ag=new AgencyController();
                ag.start();
            }
        if (i>0){
            if(!ricambiDAO.CheckPiva(code, codici.get(i-1))){
                System.out.println("il prodotto non appartiene alla stessa azienda del precedente");
                AgencyController ag=new AgencyController();
                ag.start();
            }
        }
        codici.add(code);

        }




    }



}

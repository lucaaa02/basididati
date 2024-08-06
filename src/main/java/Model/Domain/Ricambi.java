package Model.Domain;

public class Ricambi {
    private String codice;
    private String descrizione;
    private int quantita;
    private int prezzo;

    public Ricambi (String codice,String descrizione,int quantita){
        this.codice=codice;
        this.quantita=quantita;
        this.descrizione=descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public int getQuantita() {
        return quantita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getPrezzo() {
        return prezzo;
    }
}

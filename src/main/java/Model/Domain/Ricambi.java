package Model.Domain;

public class Ricambi {
    private String codice;
    private int disponibilita;
    private double prezzo;
    private String descrizione;
    private String partitaIva;
    private String tipo;

    public Ricambi(String codice, int disponibilita, double prezzo, String descrizione, String partitaIva, String tipo){
        this.codice=codice;
        this.disponibilita=disponibilita;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        this.partitaIva=partitaIva;
        this.tipo=tipo;
    }
    public Ricambi(String tipo,String descrizione,int disponibilita, String codice, String piva){
        this.tipo=tipo;
        this.disponibilita=disponibilita;
        this.descrizione=descrizione;
        this.codice=codice;
        this.partitaIva=piva;

    }


    public double getPrezzo() {
        return prezzo;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getTipo() {
        return tipo;
    }

}

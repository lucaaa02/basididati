package Model.Domain;

public class Ricambi {
    private final String codice;
    private final int disponibilita;
    private final double prezzo;
    private final String descrizione;
    private final String partitaIva;
    private final String tipo;

    public Ricambi(String codice, int disponibilita, double prezzo, String descrizione, String partitaIva, String tipo){
        this.codice=codice;
        this.disponibilita=disponibilita;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        this.partitaIva=partitaIva;
        this.tipo=tipo;
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

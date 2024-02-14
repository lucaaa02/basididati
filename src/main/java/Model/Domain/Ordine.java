package Model.Domain;


import java.util.List;

public class Ordine {

private String codici;
private int quantita;

public Ordine(String codici, int quantità){
    this.codici=codici;
    this.quantita=quantita;
}

    public int getQuantita() {
        return quantita;
    }

    public String getCodici() {
        return codici;
    }
}

package Model.Domain;


public class Ordine {

private int codice_o;
private int quantita;
private String codice_p;
String tipo;

public Ordine(String codici, int quantita){
    this.codice_p =codici;
    this.quantita=quantita;
}
public Ordine(String codice_p, String tipo, int quantita, int codice_o){
    this.codice_o=codice_o;
    this.codice_p=codice_p;
    this.quantita=quantita;
    this.tipo=tipo;
}

    public int getQuantita() {
        return quantita;
    }

    public String getCodice_p() {
        return codice_p;
    }

    public int getCodice_o() {
        return codice_o;
    }

    public String getTipo() {
        return tipo;
    }
}

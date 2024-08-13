package Model.Domain;

public class Fornitura {
    private String descrizione;
    private String nome;
    private int prezzo;
    private int quantita;
    private int tipo;
    private String partitaIVA;
    private String code;

    public Fornitura(String descrizione, String nome, int prezzo, int quantita, int tipo, String iva){
        this.descrizione=descrizione;
        this.nome=nome;
        this.prezzo=prezzo;
        this.quantita=quantita;
        this.tipo=tipo;
        partitaIVA=iva;
    }
    public Fornitura(String descrizione, String nome, int prezzo, int quantita, String code){
        this.descrizione=descrizione;
        this.nome=nome;
        this.prezzo=prezzo;
        this.quantita=quantita;
        this.code=code;
    }


    public String getDescrizione() {
        return descrizione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public int getTipo() {
        return tipo;
    }

    public String getPartitaIVA() {
        return partitaIVA;
    }

    public String getCode() {
        return code;
    }
}

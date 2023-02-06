package com.example.pandica;

public class Komentar {

    private String tekst;
    private int idZivotinje;
    private String korime;

    public Komentar(String tekst, int idZivotinje, String korime) {
        this.tekst = tekst;
        this.idZivotinje = idZivotinje;
        this.korime = korime;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getIdZivotinje() {
        return idZivotinje;
    }

    public void setIdZivotinje(int idZivotinje) {
        this.idZivotinje = idZivotinje;
    }

    public String getKorime() {
        return korime;
    }

    public void setKorime(String korime) {
        this.korime = korime;
    }
}

package com.example.pandica;

import android.graphics.drawable.Drawable;

public class Desavanje {

    int id;
    String naziv;
    String opis;
    Drawable slika;
    String datum;
    int lajk;

    public Desavanje(int id, String naziv, String opis, Drawable slika, String datum, int lajk) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.slika = slika;
        this.datum = datum;
        this.lajk = lajk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Drawable getSlika() {
        return slika;
    }

    public void setSlika(Drawable slika) {
        this.slika = slika;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getLajk() {
        return lajk;
    }

    public void setLajk(int lajk) {
        this.lajk = lajk;
    }
}

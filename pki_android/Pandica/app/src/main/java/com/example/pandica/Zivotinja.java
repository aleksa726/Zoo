package com.example.pandica;

import android.graphics.drawable.Drawable;

public class Zivotinja {

    int id;
    String naziv;
    String opis;
    Drawable slika;

    public Zivotinja(int id, String naziv, String opis, Drawable slika) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.slika = slika;
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
}

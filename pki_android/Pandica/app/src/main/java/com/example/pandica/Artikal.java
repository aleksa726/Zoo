package com.example.pandica;

public class Artikal {

    int id;
    String naziv;
    int kolicina;
    int cena;

    public Artikal(int id, String naziv, int kolicina, int cena) {
        this.id = id;
        this.naziv = naziv;
        this.kolicina = kolicina;
        this.cena = cena;
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

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}

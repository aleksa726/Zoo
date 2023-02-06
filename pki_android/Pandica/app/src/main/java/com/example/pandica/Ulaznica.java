package com.example.pandica;

public class Ulaznica {

    int id;
    int cena;
    String naslov;

    public Ulaznica(int id, int cena, String naslov) {
        this.id = id;
        this.cena = cena;
        this.naslov = naslov;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }
}

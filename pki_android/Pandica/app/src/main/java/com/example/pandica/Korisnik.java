package com.example.pandica;

import java.util.ArrayList;

public class Korisnik {

    private String korime;
    private String lozinka;
    private String ime;
    private String prezime;
    private String adresa;
    private String telefon;
    private int tip;
    ArrayList<Integer> lajkovanaDesavanja = new ArrayList<>();

    public Korisnik(String korime, String lozinka, String ime, String prezime, String adresa, String telefon, int tip) {
        this.korime = korime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.telefon = telefon;
        this.tip = tip;
        this.lajkovanaDesavanja.add(1);
        this.lajkovanaDesavanja.add(3);
    }

    public String getKorime() {
        return korime;
    }

    public void setKorime(String korime) {
        this.korime = korime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
}

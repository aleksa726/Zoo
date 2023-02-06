package com.example.pandica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.pandica.databinding.ActivityMojProfilBinding;

public class MojProfilActivity extends AppCompatActivity {

    ActivityMojProfilBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMojProfilBinding.inflate(getLayoutInflater());

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#82966D"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Korisnik korisnik = MainActivity.prijavljeniKorisnik;

        binding.korimePrikaz.setText(korisnik.getKorime());
        binding.imePrikaz.setText(korisnik.getIme());
        binding.prezimePrikaz.setText(korisnik.getPrezime());
        binding.adresaPrikaz.setText(korisnik.getAdresa());
        binding.telefonPrikaz.setText(korisnik.getTelefon());

        setContentView(binding.getRoot());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.paketi:
                Intent intentPaketi = new Intent(this, PaketiActivity.class);
                startActivity(intentPaketi);
                return true;
            case R.id.zivotinje:
                Intent intentZivotinje = new Intent(this, ZivotinjeActivity.class);
                startActivity(intentZivotinje);
                return true;
            case R.id.desavanja:
                Intent intentDesavanja = new Intent(this, DesavanjaActivity.class);
                startActivity(intentDesavanja);
                return true;
            case R.id.mojprofil:
                Intent intentMojProfil = new Intent(this, MojProfilActivity.class);
                startActivity(intentMojProfil);
                return true;
            case R.id.korpa:
                Intent intentKorpa = new Intent(this, KropaActivity.class);
                startActivity(intentKorpa);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void mojiPodaci(View view){
        Intent intentPaketi = new Intent(this, MojProfilActivity.class);
        startActivity(intentPaketi);
    }

    public void promenaPodataka(View view){
        Intent intentPaketi = new Intent(this, PromenaPodatakaActivity.class);
        startActivity(intentPaketi);
    }

    public void promenaLozinke(View view){
        Intent intentPaketi = new Intent(this, PromenaLozinkeActivity.class);
        startActivity(intentPaketi);
    }

    public void obavestenja(View view){
        Intent intentPaketi = new Intent(this, ObavestenjaActivity.class);
        startActivity(intentPaketi);
    }

    public void odjava(View view){
        MainActivity.prijavljeniKorisnik = null;
        Intent intentPaketi = new Intent(this, MainActivity.class);
        startActivity(intentPaketi);
    }

}
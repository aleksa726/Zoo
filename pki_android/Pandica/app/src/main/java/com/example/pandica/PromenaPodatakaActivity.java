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
import android.widget.Toast;

import com.example.pandica.databinding.ActivityPromenaPodatakaBinding;

public class PromenaPodatakaActivity extends AppCompatActivity {

    ActivityPromenaPodatakaBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPromenaPodatakaBinding.inflate(getLayoutInflater());

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#82966D"));
        actionBar.setBackgroundDrawable(colorDrawable);

        Korisnik korisnik = MainActivity.prijavljeniKorisnik;

        binding.korimePromena.setText(korisnik.getKorime());
        binding.imePromena.setText(korisnik.getIme());
        binding.prezimePromena.setText(korisnik.getPrezime());
        binding.adresaPromena.setText(korisnik.getAdresa());
        binding.telefonPromena.setText(korisnik.getTelefon());

        setContentView(binding.getRoot());
    }

    public void sacuvajPodatke(View view){

        MainActivity.prijavljeniKorisnik.setKorime(binding.korimePromena.getText().toString());
        MainActivity.prijavljeniKorisnik.setIme(binding.imePromena.getText().toString());
        MainActivity.prijavljeniKorisnik.setPrezime(binding.prezimePromena.getText().toString());
        MainActivity.prijavljeniKorisnik.setAdresa(binding.adresaPromena.getText().toString());
        MainActivity.prijavljeniKorisnik.setTelefon(binding.telefonPromena.getText().toString());

        Toast.makeText(getApplicationContext(), "Podaci su uspesno promenjeni!", Toast.LENGTH_LONG).show();

        Intent intentMojProfil = new Intent(this, MojProfilActivity.class);
        startActivity(intentMojProfil);
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
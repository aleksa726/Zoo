package com.example.pandica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.pandica.databinding.ActivityObavestenjaBinding;
import com.example.pandica.databinding.ActivityZivotinjeBinding;

import java.util.ArrayList;

public class ObavestenjaActivity extends AppCompatActivity {

    ActivityObavestenjaBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityObavestenjaBinding.inflate(getLayoutInflater());

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#82966D"));
        actionBar.setBackgroundDrawable(colorDrawable);

        inicijalizacijaObavestenja();

        setContentView(binding.getRoot());
    }

    private void inicijalizacijaObavestenja(){
        String[] nazivi = getResources().getStringArray(R.array.tekstObavestenja);

        ArrayList<Obavestenje> obavestenja = new ArrayList<>();

        for(int i = 0; i < nazivi.length; i++){
            Obavestenje obavestenje = new Obavestenje(nazivi[i]);
            obavestenja.add(obavestenje);
        }

        binding.listaObavestenja.setLayoutManager(new LinearLayoutManager(this));

        ObavestenjaAdapater adapter = new ObavestenjaAdapater(obavestenja);

        binding.listaObavestenja.setAdapter(adapter);
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
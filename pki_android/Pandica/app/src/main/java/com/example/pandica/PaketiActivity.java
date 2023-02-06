package com.example.pandica;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.pandica.databinding.ActivityMainBinding;
import com.example.pandica.databinding.ActivityPaketiBinding;

import java.util.ArrayList;

public class PaketiActivity extends AppCompatActivity {

    ActivityPaketiBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPaketiBinding.inflate(getLayoutInflater());

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#82966D"));
        actionBar.setBackgroundDrawable(colorDrawable);

        inicijalizacijaPaketa();
        inicijalizacijaUlaznica();

        setContentView(binding.getRoot());
    }

    private void inicijalizacijaPaketa(){
        String[] nazivi = getResources().getStringArray(R.array.naslov);
        TypedArray slike = getResources().obtainTypedArray(R.array.slika);
        String[] opisi = getResources().getStringArray(R.array.opis);
        int[] ids = getResources().getIntArray(R.array.id);
        int[] cene = getResources().getIntArray(R.array.cena);


        ArrayList<Paket> paketi = new ArrayList<>();

        for(int i = 0; i < nazivi.length; i++){
            Paket paket = new Paket(ids[i], nazivi[i], opisi[i], cene[i], slike.getDrawable(i));
            paketi.add(paket);
        }

        binding.listaPaketa.setLayoutManager(new LinearLayoutManager(this));

        PaketAdapter adapter = new PaketAdapter(paketi);

        binding.listaPaketa.setAdapter(adapter);
    }

    private void inicijalizacijaUlaznica(){
        String[] nazivi = getResources().getStringArray(R.array.naslovUlaznica);
        int[] ids = getResources().getIntArray(R.array.idUlaznica);
        int[] cene = getResources().getIntArray(R.array.cenaUlaznica);

        ArrayList<Ulaznica> ulaznice = new ArrayList<>();

        for(int i = 0; i < nazivi.length; i++){
            Ulaznica ulaznica = new Ulaznica(ids[i], cene[i], nazivi[i]);
            ulaznice.add(ulaznica);
        }

        binding.listaUlaznica.setLayoutManager(new LinearLayoutManager(this));

        UlaznicaAdapter adapter = new UlaznicaAdapter(ulaznice);

        binding.listaUlaznica.setAdapter(adapter);
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

}
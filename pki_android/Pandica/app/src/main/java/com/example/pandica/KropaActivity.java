package com.example.pandica;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.pandica.databinding.ActivityKropaBinding;

import java.util.ArrayList;
import java.util.List;

public class KropaActivity extends AppCompatActivity {

    ActivityKropaBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityKropaBinding.inflate(getLayoutInflater());

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#82966D"));
        actionBar.setBackgroundDrawable(colorDrawable);

        izbacivanjeDuplihArtikala();

        binding.listaArtikala.setLayoutManager(new LinearLayoutManager(this));

        ArtikliAdapter adapter = new ArtikliAdapter(MainActivity.artikli);

        binding.listaArtikala.setAdapter(adapter);

        int iznos = 0;
        for(int i = 0; i < MainActivity.artikli.size(); i++){
            iznos += MainActivity.artikli.get(i).cena * MainActivity.artikli.get(i).kolicina;
        }
        binding.iznos.setText(iznos + " dinara");

        int finalIznos = iznos;
        binding.poljePromokod.setOnKeyListener((v, keyCode, event) -> {
            String[] kodovi = getResources().getStringArray(R.array.kod);
            int[] popust = getResources().getIntArray(R.array.popust);
            for(int i = 0; i < kodovi.length; i++){
                if(binding.poljePromokod.getText().toString().equals(kodovi[i])){
                    binding.iznos.setText(finalIznos * popust[i] / 100 + " dinara");
                    break;
                }
                else{
                    binding.iznos.setText(finalIznos + " dinara");
                }
            }
            return false;
        });

        binding.kupi.setOnClickListener(v -> MainActivity.artikli = new ArrayList<>());

        setContentView(binding.getRoot());
    }

    private void izbacivanjeDuplihArtikala(){
        for(int i = 0; i < MainActivity.artikli.size(); i++){
            for(int j = i + 1; j < MainActivity.artikli.size(); ){
                if(MainActivity.artikli.get(i).naziv.equals(MainActivity.artikli.get(j).naziv)){
                    MainActivity.artikli.remove(j);
                    MainActivity.artikli.get(i).kolicina++;
                }
                else{
                    j++;
                }
            }
        }
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
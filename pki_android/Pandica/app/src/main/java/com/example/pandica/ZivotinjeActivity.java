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

import com.example.pandica.databinding.ActivityPaketiBinding;
import com.example.pandica.databinding.ActivityZivotinjeBinding;

import java.util.ArrayList;

public class ZivotinjeActivity extends AppCompatActivity {

    ActivityZivotinjeBinding binding = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityZivotinjeBinding.inflate(getLayoutInflater());

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#82966D"));
        actionBar.setBackgroundDrawable(colorDrawable);

        inicijalizacijaZivotinja();

        setContentView(binding.getRoot());
    }

    private void inicijalizacijaZivotinja(){
        String[] nazivi = getResources().getStringArray(R.array.nazivZivotinje);
        TypedArray slike = getResources().obtainTypedArray(R.array.slikaZivotinje);
        String[] opisi = getResources().getStringArray(R.array.opisZivotinje);
        int[] ids = getResources().getIntArray(R.array.idZivotinje);


        ArrayList<Zivotinja> zivoitnje = new ArrayList<>();

        for(int i = 0; i < nazivi.length; i++){
            Zivotinja zivotinja = new Zivotinja(ids[i], nazivi[i], opisi[i], slike.getDrawable(i));
            zivoitnje.add(zivotinja);
        }

        binding.listaZivotinja.setLayoutManager(new LinearLayoutManager(this));

        ZivotinjaAdapter adapter = new ZivotinjaAdapter(this, zivoitnje);

        binding.listaZivotinja.setAdapter(adapter);
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
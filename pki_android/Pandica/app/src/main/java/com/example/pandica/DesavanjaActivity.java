package com.example.pandica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.pandica.databinding.ActivityDesavanjaBinding;
import com.example.pandica.databinding.ActivityZivotinjeBinding;

import java.util.ArrayList;

public class DesavanjaActivity extends AppCompatActivity {

    ActivityDesavanjaBinding binding = null;
    public static Drawable slikaLajkovano;
    public static Drawable slikaNijeLajkovano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDesavanjaBinding.inflate(getLayoutInflater());

        slikaLajkovano = getResources().getDrawable(R.drawable.liked);
        slikaNijeLajkovano = getResources().getDrawable(R.drawable.like);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#82966D"));
        actionBar.setBackgroundDrawable(colorDrawable);

        inicijalizacijaDesavanja();

        setContentView(binding.getRoot());
    }


    private void inicijalizacijaDesavanja(){
        String[] nazivi = getResources().getStringArray(R.array.nazivDesavanja);
        TypedArray slike = getResources().obtainTypedArray(R.array.slikaDesavanja);
        String[] opisi = getResources().getStringArray(R.array.opisDesavanja);
        String[] datumi = getResources().getStringArray(R.array.datumDesavanja);
        int[] lajkovi = getResources().getIntArray(R.array.lajkoviDesavanja);
        int[] ids = getResources().getIntArray(R.array.idDesavanja);


        ArrayList<Desavanje> desavanja = new ArrayList<>();

        for(int i = 0; i < nazivi.length; i++){
            Desavanje desavanje = new Desavanje(ids[i], nazivi[i], opisi[i], slike.getDrawable(i), datumi[i], lajkovi[i]);
            desavanja.add(desavanje);
        }

        binding.listaDesavanja.setLayoutManager(new LinearLayoutManager(this));

        DesavanjaAdapter adapter = new DesavanjaAdapter(desavanja);

        binding.listaDesavanja.setAdapter(adapter);
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
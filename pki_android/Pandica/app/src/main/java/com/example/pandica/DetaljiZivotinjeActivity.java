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

import com.example.pandica.databinding.ActivityDetaljiZivotinjeBinding;
import com.example.pandica.databinding.ActivityZivotinjeBinding;

import java.util.ArrayList;

public class DetaljiZivotinjeActivity extends AppCompatActivity {

    ActivityDetaljiZivotinjeBinding binding = null;
    int idZivotinje = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetaljiZivotinjeBinding.inflate(getLayoutInflater());

        Intent invocationIntent = getIntent();
        String naziv = invocationIntent.getStringExtra("naziv");

        String[] nazivi = getResources().getStringArray(R.array.nazivZivotinje);
        TypedArray slike = getResources().obtainTypedArray(R.array.slikaZivotinje);
        String[] opisi = getResources().getStringArray(R.array.opisZivotinje);
        int[] ids = getResources().getIntArray(R.array.idZivotinje);


        Zivotinja zivotinja = null;

        for(int i = 0; i < nazivi.length; i++){
            if(naziv.equals(nazivi[i])){
                zivotinja = new Zivotinja(ids[i], nazivi[i], opisi[i], slike.getDrawable(i));
            }
        }

        this.idZivotinje = zivotinja.getId();

        binding.detaljiZovitenjeNaziv.setText(zivotinja.getNaziv());
        binding.detaljiZivotinjeSlika.setImageDrawable(zivotinja.getSlika());
        binding.detaljiZivotinjeOpis.setText(zivotinja.getOpis());


        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#82966D"));
        actionBar.setBackgroundDrawable(colorDrawable);


        inicijalizacijaKomentara(idZivotinje);

        binding.posaljiKomentar.setOnClickListener(v -> {
          Komentar komentar = new Komentar(binding.novikomentar.getText().toString(), idZivotinje, MainActivity.prijavljeniKorisnik.getKorime());
          MainActivity.komentari.add(komentar);
          inicijalizacijaKomentara(idZivotinje);
          binding.novikomentar.setText("");
        });

        setContentView(binding.getRoot());
    }

    private void inicijalizacijaKomentara(int id){

        ArrayList<Komentar> kom = new ArrayList<>();

        for(int i = 0; i < MainActivity.komentari.size(); i++){
            if(MainActivity.komentari.get(i).getIdZivotinje() == id){
                kom.add(MainActivity.komentari.get(i));
            }
        }

        binding.listaKomentara.setLayoutManager(new LinearLayoutManager(this));

        KomentariAdapter adapter = new KomentariAdapter(kom);

        binding.listaKomentara.setAdapter(adapter);
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
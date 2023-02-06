package com.example.pandica;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.pandica.databinding.ActivityMainBinding;
import com.example.pandica.databinding.ActivityPaketiBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding = null;

    public static ArrayList<Korisnik> korisnici = new ArrayList<>();
    public static Korisnik prijavljeniKorisnik = null;
    public static ArrayList<Artikal> artikli = new ArrayList<>();
    public static ArrayList<Komentar> komentari = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        inicijalizacijaKorisnika();

        inicijalizacijaKomentara();

        setContentView(binding.getRoot());

    }

    private void inicijalizacijaKomentara(){
        String[] tekst = getResources().getStringArray(R.array.tekstKomentara);
        String[] korisnik = getResources().getStringArray(R.array.korisnikKomentara);
        int[] idZivotinje = getResources().getIntArray(R.array.idZivotinjeKomentara);

        for(int i = 0; i < tekst.length; i++){
            Komentar komentar = new Komentar(tekst[i], idZivotinje[i], korisnik[i]);
            komentari.add(komentar);
        }
    }

    private void inicijalizacijaKorisnika(){
        if(korisnici.size() == 0) {
            String[] korime = getResources().getStringArray(R.array.korime);
            String[] lozinka = getResources().getStringArray(R.array.lozinka);
            String[] ime = getResources().getStringArray(R.array.ime);
            String[] prezime = getResources().getStringArray(R.array.prezime);
            String[] adresa = getResources().getStringArray(R.array.adresa);
            String[] telefon = getResources().getStringArray(R.array.telefon);
            int[] tip = getResources().getIntArray(R.array.tip);

            for (int i = 0; i < korime.length; i++) {
                Korisnik korisnik = new Korisnik(korime[i], lozinka[i], ime[i], prezime[i], adresa[i], telefon[i], tip[i]);
                korisnici.add(korisnik);
            }
        }

    }

    public void registracija(View view){
        Intent intent = new Intent(this, RegistracijaActivity.class);
        startActivity(intent);
    }

    public void prijaviSe(View view) {
        for (Korisnik k : korisnici) {
            if (binding.username.getText().toString().equals(k.getKorime()) &&
                    binding.password.getText().toString().equals(k.getLozinka())) {
                prijavljeniKorisnik = k;
                break;
            }
        }

        if (prijavljeniKorisnik == null) {
            Toast.makeText(getApplicationContext(), "Uneti podaci nisu ispravni!", Toast.LENGTH_LONG).show();
        } else {
            if(prijavljeniKorisnik.getTip() == 0) {
                Intent intent = new Intent(this, PaketiActivity.class);
                startActivity(intent);
            }
        }
    }

}
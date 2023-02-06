package com.example.pandica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.pandica.databinding.ActivityRegistracijaBinding;

public class RegistracijaActivity extends AppCompatActivity {

    ActivityRegistracijaBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegistracijaBinding.inflate(getLayoutInflater());

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        binding.registrujSe.setOnClickListener(v -> {
            Korisnik korisnik = new Korisnik(
                    binding.korimeRegistracija.getText().toString(),
                    binding.lozinkaRegistracija.getText().toString(),
                    binding.imeRegistracija.getText().toString(),
                    binding.prezimeRegistracija.getText().toString(),
                    binding.adresaRegistracija.getText().toString(),
                    binding.telefonRegistracija.getText().toString(),
                    0
                    );
            MainActivity.korisnici.add(korisnik);

            Toast.makeText(getApplicationContext(), "Korisnik je uspesno registrovan!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        setContentView(binding.getRoot());
    }

    public void prijava(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
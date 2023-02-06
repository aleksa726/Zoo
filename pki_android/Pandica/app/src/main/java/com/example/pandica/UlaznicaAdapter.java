package com.example.pandica;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UlaznicaAdapter extends RecyclerView.Adapter<UlaznicaAdapter.MyViewHolder> {

    private List<Ulaznica> ulaznice;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nazivUlaznice;
        public TextView cenaUlaznice;
        public Button kupiUlaznicu;

        public MyViewHolder(View v) {
            super(v);
            nazivUlaznice = v.findViewById(R.id.ulaznicaNaslov);
            cenaUlaznice = v.findViewById(R.id.ulaznicaCena);
            kupiUlaznicu = v.findViewById(R.id.kupiUlaznicu);

            kupiUlaznicu.setOnClickListener(v1 -> {
                switch (nazivUlaznice.getText().toString()) {
                    case "ULAZNICA ZA 1 OSOBU":
                        Artikal artikal = new Artikal(1, nazivUlaznice.getText().toString(), 1, 500);
                        MainActivity.artikli.add(artikal);
                        break;
                    case "ULAZNICA ZA 2 OSOBE":
                        Artikal artikal2 = new Artikal(2, nazivUlaznice.getText().toString(), 1, 900);
                        MainActivity.artikli.add(artikal2);
                        break;
                    case "ULAZNICA ZA PORODICU":
                        Artikal artikal3 = new Artikal(3, nazivUlaznice.getText().toString(), 1, 1200);
                        MainActivity.artikli.add(artikal3);
                        break;
                    case "ULAZNICA ZA DETE":
                        Artikal artikal4 = new Artikal(4, nazivUlaznice.getText().toString(), 1, 300);
                        MainActivity.artikli.add(artikal4);
                        break;
                    case "ULAZNICA ZA 5 OSOBA":
                        Artikal artikal5 = new Artikal(5, nazivUlaznice.getText().toString(), 1, 1800);
                        MainActivity.artikli.add(artikal5);
                        break;
                    case "ULAZNICA ZA 10 OSOBA":
                        Artikal artikal6 = new Artikal(6, nazivUlaznice.getText().toString(), 1, 3500);
                        MainActivity.artikli.add(artikal6);
                        break;
                }
            });
        }
    }

    public UlaznicaAdapter(List<Ulaznica> ulaznice) {
        this.ulaznice = ulaznice;
    }

    @Override
    public UlaznicaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ulaznica, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nazivUlaznice.setText(ulaznice.get(position).getNaslov());
        holder.cenaUlaznice.setText(String.valueOf(ulaznice.get(position).getCena()));
    }

    @Override
    public int getItemCount() {
        return ulaznice.size();
    }
}
package com.example.pandica;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArtikliAdapter extends RecyclerView.Adapter<ArtikliAdapter.MyViewHolder> {

    private List<Artikal> artikli;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nazivArtikla;
        public TextView cenaArtikla;
        public TextView kolicinaArtikla;

        public MyViewHolder(View v) {
            super(v);
            nazivArtikla = v.findViewById(R.id.nazivArtikla);
            cenaArtikla = v.findViewById(R.id.cenaArtikla);
            kolicinaArtikla = v.findViewById(R.id.kolicinaArtikla);
        }
    }

    public ArtikliAdapter(List<Artikal> artikli) {
        this.artikli = artikli;
    }

    @Override
    public ArtikliAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artikal, parent, false);
        ArtikliAdapter.MyViewHolder vh = new ArtikliAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ArtikliAdapter.MyViewHolder holder, int position) {
        holder.nazivArtikla.setText(artikli.get(position).getNaziv());
        holder.cenaArtikla.setText(String.valueOf(artikli.get(position).getCena()));
        holder.kolicinaArtikla.setText(String.valueOf(artikli.get(position).getKolicina()));
    }

    @Override
    public int getItemCount() {
        return artikli.size();
    }
}
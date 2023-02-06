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

public class PaketAdapter extends RecyclerView.Adapter<PaketAdapter.MyViewHolder> {

    private List<Paket> paketi;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nazivPaketa;
        public TextView opisPaketa;
        public ImageView slikaPaketa;
        public Button kupi;

        public MyViewHolder(View v) {
            super(v);
            nazivPaketa = v.findViewById(R.id.naslovPaketa);
            opisPaketa = v.findViewById(R.id.opis);
            slikaPaketa = v.findViewById(R.id.slika);
            kupi = v.findViewById(R.id.buttonKupi);
            kupi.setOnClickListener(v1 -> {
                switch (nazivPaketa.getText().toString()) {
                    case "VIKEND PAKET":
                        Artikal artikal = new Artikal(7, nazivPaketa.getText().toString(), 1, 300);
                        MainActivity.artikli.add(artikal);
                        break;
                    case "NOVOGODISNJI PAKET":
                        Artikal artikal2 = new Artikal(8, nazivPaketa.getText().toString(), 1, 1000);
                        MainActivity.artikli.add(artikal2);
                        break;
                    case "BLACK FRIDAY":
                        Artikal artikal3 = new Artikal(9, nazivPaketa.getText().toString(), 1, 500);
                        MainActivity.artikli.add(artikal3);
                        break;
                }
            });
        }

    }

    public PaketAdapter(List<Paket> paketi) {
        this.paketi = paketi;
    }

    @Override
    public PaketAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.paket, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nazivPaketa.setText(paketi.get(position).getNaziv());
        holder.opisPaketa.setText(paketi.get(position).getOpis());
        holder.slikaPaketa.setImageDrawable(paketi.get(position).getSlika());
    }

    @Override
    public int getItemCount() {
        return paketi.size();
    }
}
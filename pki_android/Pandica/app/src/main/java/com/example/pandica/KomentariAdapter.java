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

public class KomentariAdapter extends RecyclerView.Adapter<KomentariAdapter.MyViewHolder> {

    private List<Komentar> komentari;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tekstKomentara;
        public TextView korisnikKomentara;

        public MyViewHolder(View v) {
            super(v);
            tekstKomentara = v.findViewById(R.id.tekstKomentara);
            korisnikKomentara = v.findViewById(R.id.korimeKomentara);
        }
    }

    public KomentariAdapter(List<Komentar> komentari) {
        this.komentari = komentari;
    }

    @Override
    public KomentariAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.komentar, parent, false);
        KomentariAdapter.MyViewHolder vh = new KomentariAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(KomentariAdapter.MyViewHolder holder, int position) {
        holder.tekstKomentara.setText(komentari.get(position).getTekst());
        holder.korisnikKomentara.setText(komentari.get(position).getKorime());
    }

    @Override
    public int getItemCount() {
        return komentari.size();
    }
}
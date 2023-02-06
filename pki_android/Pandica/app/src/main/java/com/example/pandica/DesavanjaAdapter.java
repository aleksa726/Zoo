package com.example.pandica;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DesavanjaAdapter extends RecyclerView.Adapter<DesavanjaAdapter.MyViewHolder> {

    private List<Desavanje> desavanja;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nazivDesavanja;
        public ImageView slikaDesavanja;
        public TextView opisDesavanja;
        public TextView datumDesavanja;
        public TextView lajkDesavanja;
        public ImageView lajkDugme;

        public MyViewHolder(View v) {
            super(v);
            nazivDesavanja = v.findViewById(R.id.nazivDesavanja);
            slikaDesavanja = v.findViewById(R.id.slikaDesavanja);
            opisDesavanja = v.findViewById(R.id.opisDesavanja);
            datumDesavanja = v.findViewById(R.id.datumDesavanja);
            lajkDesavanja = v.findViewById(R.id.brojLajkovaDesavanja);
            lajkDugme = v.findViewById(R.id.lajkDesavanja);
            lajkDugme.setOnClickListener(v1 -> {
                if(lajkDugme.getBackground() == DesavanjaActivity.slikaLajkovano) {
                    lajkDugme.setBackground(DesavanjaActivity.slikaNijeLajkovano);
                    int lajk = Integer.valueOf(lajkDesavanja.getText().toString());
                    lajk--;
                    lajkDesavanja.setText(String.valueOf(lajk));
                }
                else {
                    lajkDugme.setBackground(DesavanjaActivity.slikaLajkovano);
                    int lajk = Integer.valueOf(lajkDesavanja.getText().toString());
                    lajk++;
                    lajkDesavanja.setText(String.valueOf(lajk));
                }
            });
        }
    }

    public DesavanjaAdapter(List<Desavanje> desavanja) {
        this.desavanja = desavanja;
    }

    @Override
    public DesavanjaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.desavanje, parent, false);
        DesavanjaAdapter.MyViewHolder vh = new DesavanjaAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DesavanjaAdapter.MyViewHolder holder, int position) {
        holder.nazivDesavanja.setText(desavanja.get(position).getNaziv());
        holder.slikaDesavanja.setImageDrawable(desavanja.get(position).getSlika());
        holder.opisDesavanja.setText(desavanja.get(position).getOpis());
        holder.datumDesavanja.setText(desavanja.get(position).getDatum());
        holder.lajkDesavanja.setText(String.valueOf(desavanja.get(position).getLajk()));
        for(int i = 0; i < MainActivity.prijavljeniKorisnik.lajkovanaDesavanja.size(); i++){
            if(position == (MainActivity.prijavljeniKorisnik.lajkovanaDesavanja.get(i) - 1)){
                holder.lajkDugme.setBackground(DesavanjaActivity.slikaLajkovano);
            }
        }
    }

    @Override
    public int getItemCount() {
        return desavanja.size();
    }
}
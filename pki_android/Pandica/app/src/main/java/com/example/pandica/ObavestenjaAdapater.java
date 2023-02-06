package com.example.pandica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ObavestenjaAdapater extends RecyclerView.Adapter<ObavestenjaAdapater.MyViewHolder> {

    private List<Obavestenje> obavestenja;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tekstObavestenja;

        public MyViewHolder(View v) {
            super(v);
            tekstObavestenja = v.findViewById(R.id.tekstObavestenja);
        }
    }

    public ObavestenjaAdapater(List<Obavestenje> obavestenja) {
        this.obavestenja = obavestenja;
    }

    @Override
    public ObavestenjaAdapater.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.obavestenje, parent, false);
        ObavestenjaAdapater.MyViewHolder vh = new ObavestenjaAdapater.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ObavestenjaAdapater.MyViewHolder holder, int position) {
        holder.tekstObavestenja.setText(obavestenja.get(position).getTekst());
    }

    @Override
    public int getItemCount() {
        return obavestenja.size();
    }
}
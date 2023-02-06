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

public class ZivotinjaAdapter extends RecyclerView.Adapter<ZivotinjaAdapter.MyViewHolder> {

    private final ZivotinjeActivity zivotinjeActivity;
    private List<Zivotinja> zivotinje;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nazivZivotinje;
        public ImageView slikaZivotinje;

        public MyViewHolder(View v) {
            super(v);
            nazivZivotinje = v.findViewById(R.id.nazivZivotinje);
            slikaZivotinje = v.findViewById(R.id.slikaZivotinje);

            LinearLayout linearLayout = v.findViewById(R.id.okvirZivotinje);
            linearLayout.setOnClickListener(v1 -> {
                Intent intentDetaljiZivotinje = new Intent();
                intentDetaljiZivotinje.setClass(zivotinjeActivity, DetaljiZivotinjeActivity.class);
                intentDetaljiZivotinje.putExtra("naziv", nazivZivotinje.getText());
                zivotinjeActivity.startActivity(intentDetaljiZivotinje);
            });
        }
    }

    public ZivotinjaAdapter(ZivotinjeActivity zivotinjeActivity, List<Zivotinja> zivotinje) {
        this.zivotinjeActivity = zivotinjeActivity;
        this.zivotinje = zivotinje;
    }

    @Override
    public ZivotinjaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.zivotinja, parent, false);
        ZivotinjaAdapter.MyViewHolder vh = new ZivotinjaAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ZivotinjaAdapter.MyViewHolder holder, int position) {
        holder.nazivZivotinje.setText(zivotinje.get(position).getNaziv());
        holder.slikaZivotinje.setImageDrawable(zivotinje.get(position).getSlika());
    }

    @Override
    public int getItemCount() {
        return zivotinje.size();
    }
}
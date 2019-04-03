package com.example.mapsku;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    String[] listKota;
    int[] listImage;

    public RecAdapter(String[] listKota, int[] listImage) {
        this.listKota = listKota;
        this.listImage = listImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_kota, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.tvKota.setText(listKota[position]);
        viewHolder.imgKota.setImageResource(listImage[position]);
    }

    @Override
    public int getItemCount() {
        return listKota.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgKota;
        TextView tvKota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgKota = itemView.findViewById(R.id.img_kota);
            tvKota = itemView.findViewById(R.id.tv_kota);

        }
    }
}

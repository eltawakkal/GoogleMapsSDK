package com.example.mapsku.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapsku.R;

public class RecMainAdapter extends RecyclerView.Adapter<RecMainAdapter.ViewHolder> {

    String[] namaKota;
    int[] listImage;

    public RecMainAdapter(String[] namaKota, int[] listImage) {
        this.namaKota = namaKota;
        this.listImage = listImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_kota, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setData(namaKota[i], listImage[i]);
        viewHolder.onItemsClick();
    }

    @Override
    public int getItemCount() {
        return namaKota.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgKota;
        TextView tvKota;

        public ViewHolder(@NonNull View v) {
            super(v);

            imgKota = v.findViewById(R.id.img_kota);
            tvKota = v.findViewById(R.id.tv_kota);
        }

        void setData(String namaKota, int img) {
            tvKota.setText(namaKota);
            imgKota.setImageResource(img);
        }

        void onItemsClick() {
            tvKota.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Hellow There", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

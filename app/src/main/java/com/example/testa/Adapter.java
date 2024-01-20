package com.example.testa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private List<Country> countryList;

    @NonNull
    @Override
    public Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Holder holder, int position) {
        if (countryList != null && position < countryList.size()) {
            Country country = countryList.get(position);

            // Bind data to views
            holder.txt.setText(country.getCountries_name());
            holder.txt1.setText(country.getCountries_iso_code());

            // Use Glide to load the image from the URL
            Glide.with(holder.itemView.getContext())
                    .load(country.getFlag())
                    .into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return countryList != null ? countryList.size() : 0;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
        notifyDataSetChanged();
    }

    static class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt, txt1;

        public Holder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);
            txt1 = itemView.findViewById(R.id.txt1);
        }
    }
}

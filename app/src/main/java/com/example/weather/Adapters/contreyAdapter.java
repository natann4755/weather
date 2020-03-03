package com.example.weather.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;
import com.example.weather.modul.Contry;

import java.util.ArrayList;

public class contreyAdapter extends RecyclerView.Adapter<contreyAdapter.contreyHolder> {

    private ArrayList<Contry> AllContrey;

    public contreyAdapter(ArrayList<Contry> AllContrey) {
        this.AllContrey = AllContrey;
    }

    @NonNull
    @Override
    public contreyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contrey,parent,false);
        return new contreyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull contreyHolder holder, int position) {
        holder.setData(AllContrey.get(position));

    }

    @Override
    public int getItemCount() {
        return AllContrey.size();
    }

    public class contreyHolder extends RecyclerView.ViewHolder{

        private TextView contryName;

        public contreyHolder(@NonNull View itemView) {
            super(itemView);
            contryName = itemView.findViewById(R.id.IContrey_contreyName_TV);
        }

        private void setData (Contry contry){
            contryName.setText(contry.getName());

        }
    }
}

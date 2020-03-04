package com.example.weather.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Fragments.FragmentsRegion;
import com.example.weather.R;
import com.example.weather.modul.Region;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class regionAdapter extends RecyclerView.Adapter<regionAdapter.RHolder> {

    private FragmentsRegion.OnFragmentAllContreysListener mOnListenerRegionAdapter;
    private ArrayList<Region> myRegions;
    private OnAdapterclickListener mOnAdapterclickListener;


    public regionAdapter(ArrayList<Region> myRegions,OnAdapterclickListener mOnAdapterclickListener) {
        this.myRegions = myRegions;
        this.mOnAdapterclickListener = mOnAdapterclickListener;
    }

    @NonNull
    @Override
    public RHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemc_ringe,parent,false);
        return new RHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RHolder holder, final int position) {
        holder.setData(myRegions.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnAdapterclickListener.onContreysClick(myRegions.get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return myRegions.size();
    }

    public class RHolder extends RecyclerView.ViewHolder{
        private TextView contreyName;
        private ImageView imegRegion;
        private TextView somContrey;

        public RHolder(View itemView) {
            super(itemView);
            contreyName = itemView.findViewById(R.id.IC_contreyName_TV);
            somContrey = itemView.findViewById(R.id.IC_totalCaontrey_TV);
            imegRegion = itemView.findViewById(R.id.ringIV);

        }

        public void setData (Region region){

            contreyName.setText(region.getName());
            somContrey.setText(String.valueOf(region.getSome()));
            Picasso.get().load(region.getUrl()).into(imegRegion);
        }
    }
    public interface OnAdapterclickListener {
        void onContreysClick(String ringName);
    }

}

package com.example.weather.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.example.weather.R;
import com.example.weather.modul.Contry;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class contreyAdapter extends RecyclerView.Adapter<contreyAdapter.contreyHolder> implements Filterable {

    private ArrayList<Contry> AllContrey;
    private ArrayList<Contry> filterContrey = new ArrayList<>();
    private FragmentActivity mfragmentActivity;
    private countryClickLisener mCountryClickLisener;

    public contreyAdapter(ArrayList<Contry> AllContrey, FragmentActivity activity, countryClickLisener mcountryClickLisener) {
        this.AllContrey = AllContrey;
        filterContrey.addAll(this.AllContrey);
        this.mfragmentActivity = activity;
        mCountryClickLisener = mcountryClickLisener;

    }

    @NonNull
    @Override
    public contreyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contrey, parent, false);
        return new contreyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull contreyHolder holder, final int position) {
        holder.setData(filterContrey.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountryClickLisener.countryClick(filterContrey.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return filterContrey.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList <Contry> arreyMyContrey = new ArrayList<>();
                for (Contry c : AllContrey) {
                    if (c.getName().toLowerCase().contains(constraint.toString().toLowerCase())){
                        arreyMyContrey.add(c);
                    }
                }
              results.values = arreyMyContrey;
              results.count = arreyMyContrey.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (constraint ==null || constraint.length()==0){ return; }
                filterContrey.clear();
                filterContrey = (ArrayList<Contry>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public class contreyHolder extends RecyclerView.ViewHolder {

        private TextView contryName;
        private TextView contreyRing;
        private ImageView imegFlag;

        public contreyHolder(@NonNull View itemView) {
            super(itemView);
            contryName = itemView.findViewById(R.id.IContrey_contreyName_TV);
            contreyRing = itemView.findViewById(R.id.IContrey_contrey_TV);
            imegFlag = itemView.findViewById(R.id.contryImegIV);

        }

        private void setData(Contry contry) {
            contryName.setText(contry.getName());
            contreyRing.setText(contry.getRegion());
            SvgLoader.pluck()
                    .with(mfragmentActivity)
                    .load(contry.getFlag(), imegFlag);
        }
    }
   public interface countryClickLisener{
        void countryClick (Contry myContry);
   }
}


//    private String getFlagByCode(String country){
//        int flagOffset = 0x1F1E6;
//        int asciiOffset = 0x41;
//
////          String country = "US";
//
//        int firstChar = Character.codePointAt(country, 0) - asciiOffset + flagOffset;
//        int secondChar = Character.codePointAt(country, 1) - asciiOffset + flagOffset;
//
//        String flag = new String(Character.toChars(firstChar))
//                + new String(Character.toChars(secondChar));
//
//        return flag;
//
//    }


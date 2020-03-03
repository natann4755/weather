package com.example.weather.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather.Adapters.regionAdapter;
import com.example.weather.R;
import com.example.weather.modul.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FragmentsRegion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentsRegion extends Fragment implements regionAdapter.OnAdapterclickListener {



    private OnFragmentAllContreysListener mListener;
    private static final String keyAreeyRegion = "keyAreeyContreys";
    private RecyclerView mRecyclerView;
    private regionAdapter mRegionAdapter;
    private ArrayList<Region> myArreyRegion;








    public FragmentsRegion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FragmentsRegion.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentsRegion newInstance(List<Region> allRegion) {
        FragmentsRegion fragment = new FragmentsRegion();
        Bundle args = new Bundle();
        args.putParcelableArrayList(keyAreeyRegion, (ArrayList<? extends Parcelable>) allRegion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            myArreyRegion = getArguments().getParcelableArrayList(keyAreeyRegion);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragments_all_contrey, container, false);
        initRecyclerview(v);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentAllContreys();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentAllContreysListener) {
            mListener = (OnFragmentAllContreysListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void initRecyclerview(View view) {
        mRecyclerView = view.findViewById(R.id.AM_RecyclerView_RV);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRegionAdapter = new regionAdapter(myArreyRegion,this);
        mRecyclerView.setAdapter(mRegionAdapter);
    }

    @Override
    public void onContreysClick(String ringName) {
        mListener.onContreysClick(ringName);
    }


    public interface OnFragmentAllContreysListener {
        void onFragmentAllContreys();
        void onContreysClick(String ringName);
    }

}

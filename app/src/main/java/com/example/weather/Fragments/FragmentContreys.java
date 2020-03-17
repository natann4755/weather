package com.example.weather.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.weather.Adapters.contreyAdapter;
import com.example.weather.Adapters.regionAdapter;
import com.example.weather.R;
import com.example.weather.modul.Contry;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link FragmentContreys#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentContreys extends Fragment implements contreyAdapter.countryClickLisener {

    private ArrayList<Contry> Contreys;
    private OnFragmentContreysListener mListener;
    private static final String keyAreeyContreys = "keyAreeyContreys";
    private RecyclerView mRecyclerView;
    private contreyAdapter mContreyAdapter;
    private SearchView countreySearchView;

    public FragmentContreys() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FragmentContreys.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentContreys newInstance(ArrayList<Contry> Contreys) {
        FragmentContreys fragment = new FragmentContreys();
        Bundle args = new Bundle();
        args.putParcelableArrayList(keyAreeyContreys,Contreys);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Contreys = getArguments().getParcelableArrayList(keyAreeyContreys);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_contreys, container, false);
        initRV(v);
        return v;
    }

    private void initRV(View v) {
        mRecyclerView = v.findViewById(R.id.AM_RecyclerView_contrey_RV);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mContreyAdapter = new contreyAdapter(Contreys,getActivity(),this);
        mRecyclerView.setAdapter(mContreyAdapter);
        countreySearchView = v.findViewById(R.id.countrey_SearchView_SV);
        countreySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mContreyAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentContreys();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentContreysListener) {
            mListener = (OnFragmentContreysListener) context;
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

    @Override
    public void countryClick(Contry myContry) {
        mListener.onContreyClick(myContry);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentContreysListener {
        // TODO: Update argument type and name
        void onFragmentContreys();
        void onContreyClick(Contry contry);
    }
}

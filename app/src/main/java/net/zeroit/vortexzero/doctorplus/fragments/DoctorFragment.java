package net.zeroit.vortexzero.doctorplus.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.zeroit.vortexzero.doctorplus.R;
import net.zeroit.vortexzero.doctorplus.adapter.CardViewAdapter;

import java.util.ArrayList;

public class DoctorFragment extends Fragment {

    private ArrayList doctorTitle;

    private RecyclerView recyclerView;
    private CardViewAdapter adapter;
    View view;

    public DoctorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_doctor, container, false);

        doctorTitle = new ArrayList();
        doctorTitle.add("Accupunture");
        doctorTitle.add("Dentist");
        doctorTitle.add("Physiotherapist");
        doctorTitle.add("Eye Specialist");

        adapter = new CardViewAdapter(getContext(), doctorTitle);
        initializeView();
        return view;

    }

    public void initializeView(){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_card_view);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}

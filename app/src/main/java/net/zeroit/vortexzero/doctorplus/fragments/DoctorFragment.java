package net.zeroit.vortexzero.doctorplus.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import net.zeroit.vortexzero.doctorplus.ListActivity;
import net.zeroit.vortexzero.doctorplus.R;
import net.zeroit.vortexzero.doctorplus.SelectionActivity;
import net.zeroit.vortexzero.doctorplus.adapter.CardViewAdapter;
import net.zeroit.vortexzero.doctorplus.adapter.GridViewAdapter;

import java.util.ArrayList;

public class DoctorFragment extends Fragment {

    private ArrayList doctorTitle;

    private GridView gridView;
    private GridViewAdapter adapter;

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

        adapter = new GridViewAdapter(getContext(), doctorTitle);
        initializeView();
        return view;

    }

    public void initializeView(){
        gridView = (GridView) view.findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ListActivity.class);
                intent.putExtra("LAYOUT", "Doctor_List");
                startActivityForResult(intent, 1111);
            }
        });
    }

}

package net.zeroit.vortexzero.doctorplus.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.zeroit.vortexzero.doctorplus.R;

public class BloodFragment extends Fragment {


    public BloodFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blood, container, false);
    }


}

package net.zeroit.vortexzero.doctorplus;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import net.zeroit.vortexzero.doctorplus.fragments.DoctorFragment;

public class SelectionActivity extends FragmentActivity {

    private LayoutInflater inflater;
    private Fragment fragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        fragment = new DoctorFragment();

        if (fragment != null){
            transaction = SelectionActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.layout_frame, fragment);
            transaction.commit();
        }

    }

    public void ReplaceFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (addToBackStack){
            transaction.addToBackStack(null);
        }

        transaction.replace(R.id.layout_frame, fragment);
        transaction.commit();
        getFragmentManager().executePendingTransactions();
    }
}

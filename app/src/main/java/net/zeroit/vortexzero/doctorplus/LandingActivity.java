package net.zeroit.vortexzero.doctorplus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import net.zeroit.vortexzero.doctorplus.fragments.BloodFragment;
import net.zeroit.vortexzero.doctorplus.fragments.DoctorFragment;
import net.zeroit.vortexzero.doctorplus.fragments.MedicineFragment;

public class LandingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout doctorView;
    private LinearLayout medicineView;
    private LinearLayout hospitalView;
    private LinearLayout bloodView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        initializeView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void initializeView(){
        doctorView = (LinearLayout) findViewById(R.id.view_doctor);
        medicineView = (LinearLayout) findViewById(R.id.view_medicine);
        hospitalView = (LinearLayout) findViewById(R.id.view_hospital);
        bloodView = (LinearLayout) findViewById(R.id.view_blood);

        doctorView.setOnClickListener(clickListener);
        medicineView.setOnClickListener(clickListener);
        hospitalView.setOnClickListener(clickListener);
        bloodView.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = (new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            Intent intent;

            switch (id){
                case R.id.view_doctor:
                    intent = new Intent(getApplicationContext(), SelectionActivity.class);
                    intent.putExtra("LAYOUT", "Doctor");
                    startActivity(intent);
                    break;
                case R.id.view_medicine:
                    intent = new Intent(getApplicationContext(), SelectionActivity.class);
                    intent.putExtra("LAYOUT", "Medicine");
                    startActivity(intent);
                    break;
                case R.id.view_hospital:
                    intent = new Intent(getApplicationContext(), SelectionActivity.class);
                    intent.putExtra("LAYOUT", "Hospital");
                    startActivity(intent);
                    break;
                case R.id.view_blood:
                    intent = new Intent(getApplicationContext(), SelectionActivity.class);
                    intent.putExtra("LAYOUT", "Blood");
                    startActivity(intent);
                    break;
                default:
                    break;

            }


        }
    });

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.landing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

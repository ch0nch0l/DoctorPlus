package net.zeroit.vortexzero.doctorplus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.zeroit.vortexzero.doctorplus.fragments.BloodFragment;
import net.zeroit.vortexzero.doctorplus.fragments.DoctorFragment;
import net.zeroit.vortexzero.doctorplus.fragments.DoctorListFragment;
import net.zeroit.vortexzero.doctorplus.fragments.HospitalFragment;
import net.zeroit.vortexzero.doctorplus.fragments.MedicineFragment;

public class SelectionActivity extends FragmentActivity {

    private LinearLayout layoutBottomBar;
    private TextView txtTitle;
    private ImageView btnBack;
    private ImageView btnSearch;
    private ImageView btnDoctor;
    private ImageView btnMedicine;
    private ImageView btnHospital;
    private ImageView btnBlood;


    private LayoutInflater inflater;
    private Fragment fragment;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        initializeView();
        setClickListener();

        if (getIntent().hasExtra("LAYOUT")){
            switch (getIntent().getStringExtra("LAYOUT")){
                case "Doctor":
                    txtTitle.setText("Search Doctor");
                    btnDoctor.setImageResource(R.drawable.doctor_accent);
                    btnMedicine.setImageResource(R.drawable.medicine);
                    btnHospital.setImageResource(R.drawable.hospital);
                    btnBlood.setImageResource(R.drawable.blood);
                    fragment = new DoctorFragment();
                    ReplaceFragment(fragment, false);
                    break;
                case "Medicine":
                    txtTitle.setText("Search Medicine");
                    btnDoctor.setImageResource(R.drawable.doctor);
                    btnMedicine.setImageResource(R.drawable.medicine_accent);
                    btnHospital.setImageResource(R.drawable.hospital);
                    btnBlood.setImageResource(R.drawable.blood);
                    fragment = new MedicineFragment();
                    ReplaceFragment(fragment, false);
                    break;
                case "Hospital":
                    txtTitle.setText("Search Hospital");
                    btnDoctor.setImageResource(R.drawable.doctor);
                    btnMedicine.setImageResource(R.drawable.medicine);
                    btnHospital.setImageResource(R.drawable.hospital_accent);
                    btnBlood.setImageResource(R.drawable.blood);
                    fragment = new HospitalFragment();
                    ReplaceFragment(fragment, false);
                    break;
                case "Blood":
                    txtTitle.setText("Search Blood");
                    btnDoctor.setImageResource(R.drawable.doctor);
                    btnMedicine.setImageResource(R.drawable.medicine);
                    btnHospital.setImageResource(R.drawable.hospital);
                    btnBlood.setImageResource(R.drawable.blood_accent);
                    fragment = new BloodFragment();
                    ReplaceFragment(fragment, false);
                    break;
                case "Doctor_List":
                    txtTitle.setText("Select Doctor");
                    layoutBottomBar.setVisibility(View.GONE);
                    fragment = new DoctorListFragment();
                    ReplaceFragment(fragment, false);
                    break;
                default:
                    break;
            }
        }

    }

    public void setClickListener(){
        btnBack.setOnClickListener(clickListener);
        btnSearch.setOnClickListener(clickListener);
        btnDoctor.setOnClickListener(clickListener);
        btnMedicine.setOnClickListener(clickListener);
        btnHospital.setOnClickListener(clickListener);
        btnBlood.setOnClickListener(clickListener);
    }

    public void initializeView(){
        layoutBottomBar = (LinearLayout) findViewById(R.id.layout_bottom_bar);
        txtTitle = (TextView) findViewById(R.id.layout_title);
        btnBack = (ImageView) findViewById(R.id.btn_back);
        btnSearch = (ImageView) findViewById(R.id.btn_search);
        btnDoctor = (ImageView) findViewById(R.id.btn_bottom_doctor);
        btnMedicine = (ImageView) findViewById(R.id.btn_bottom_medicine);
        btnHospital = (ImageView) findViewById(R.id.btn_bottom_hospital);
        btnBlood = (ImageView) findViewById(R.id.btn_bottom_blood);


        btnDoctor.setImageResource(R.drawable.doctor_accent);
        btnMedicine.setImageResource(R.drawable.medicine);
        btnHospital.setImageResource(R.drawable.hospital);
        btnBlood.setImageResource(R.drawable.blood);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();

            switch (id){
                case R.id.btn_back:
                    finish();
                    break;
                case R.id.btn_search:
                    //Search method
                    break;
                case R.id.btn_bottom_doctor:
                    btnDoctor.setImageResource(R.drawable.doctor_accent);
                    btnMedicine.setImageResource(R.drawable.medicine);
                    btnHospital.setImageResource(R.drawable.hospital);
                    btnBlood.setImageResource(R.drawable.blood);
                    fragment = new DoctorFragment();
                    ReplaceFragment(fragment, false);
                    break;
                case R.id.btn_bottom_medicine:
                    btnDoctor.setImageResource(R.drawable.doctor);
                    btnMedicine.setImageResource(R.drawable.medicine_accent);
                    btnHospital.setImageResource(R.drawable.hospital);
                    btnBlood.setImageResource(R.drawable.blood);
                    fragment = new MedicineFragment();
                    ReplaceFragment(fragment, false);
                    break;
                case R.id.btn_bottom_hospital:
                    btnDoctor.setImageResource(R.drawable.doctor);
                    btnMedicine.setImageResource(R.drawable.medicine);
                    btnHospital.setImageResource(R.drawable.hospital_accent);
                    btnBlood.setImageResource(R.drawable.blood);
                    fragment = new HospitalFragment();
                    ReplaceFragment(fragment, false);
                    break;
                case R.id.btn_bottom_blood:
                    btnDoctor.setImageResource(R.drawable.doctor);
                    btnMedicine.setImageResource(R.drawable.medicine);
                    btnHospital.setImageResource(R.drawable.hospital);
                    btnBlood.setImageResource(R.drawable.blood_accent);
                    fragment = new BloodFragment();
                    ReplaceFragment(fragment, false);
                    break;
                default:
                    break;
            }
        }
    };

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

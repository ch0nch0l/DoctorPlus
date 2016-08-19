package net.zeroit.vortexzero.doctorplus;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.zeroit.vortexzero.doctorplus.adapter.ViewPagerSliderAdapter;
import net.zeroit.vortexzero.doctorplus.helper.AppPrefManager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerSliderAdapter sliderAdapter;
    private LinearLayout dotLayout;
    private TextView[] dots;
    private int[] sliderLayout;
    private Button btnSkip, btnNext;
    private AppPrefManager prefManager;

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefManager = new AppPrefManager(this);
        if (!prefManager.isFirstTimeLunch()){
            lunchBaseScreen();
            finish();
        }

        if (Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }

        setContentView(R.layout.activity_main);

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewPager = (ViewPager) findViewById(R.id.viewPagerSlider);
        dotLayout = (LinearLayout) findViewById(R.id.layoutDot);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        btnNext = (Button) findViewById(R.id.btnNext);

        sliderLayout = new int[]{
                R.layout.welcome_one,
                R.layout.welcome_two,
                R.layout.welcome_three
        };

        addDots(0);

        changeBarColor();

        sliderAdapter = new ViewPagerSliderAdapter(inflater, sliderLayout);
        viewPager.setAdapter(sliderAdapter);



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDots(position);

                if (position == sliderLayout.length - 1){
                    btnNext.setText("GOT IT");
                    btnSkip.setVisibility(View.GONE);
                } else {
                    btnNext.setText("NEXT");
                    btnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lunchBaseScreen();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current = getItem(+1);
                if (current < sliderLayout.length){
                    viewPager.setCurrentItem(current);
                } else {
                    lunchBaseScreen();
                }
            }
        });
    }

    private void changeBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void addDots(int currentPage) {
        dots = new TextView[sliderLayout.length];

        int[] colorActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInactive[currentPage]);
            dotLayout.addView(dots[i]);
        }

        if (dots.length > 0){
            dots[currentPage].setTextColor(colorActive[currentPage]);
        }
    }

    private int getItem(int i){
        return viewPager.getCurrentItem() + i;
    }

    private void lunchBaseScreen(){
        prefManager.setIsFirstTime(false);
        startActivity(new Intent(MainActivity.this, LandingActivity
                .class));
        finish();
    }
}

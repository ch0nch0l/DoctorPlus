package net.zeroit.vortexzero.doctorplus.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chonchol on 16-Aug-16.
 */
public class ViewPagerSliderAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    int[] layout;

    public ViewPagerSliderAdapter() {
    }

    public ViewPagerSliderAdapter(LayoutInflater inflater, int[] layout) {
        this.inflater = inflater;
        this.layout = layout;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(layout[position], container, false);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public int getCount() {
        return layout.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}

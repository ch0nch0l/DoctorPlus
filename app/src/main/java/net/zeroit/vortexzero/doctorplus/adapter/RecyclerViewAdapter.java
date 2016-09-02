package net.zeroit.vortexzero.doctorplus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.zeroit.vortexzero.doctorplus.R;
import net.zeroit.vortexzero.doctorplus.viewholder.ItemListViewHolder;

/**
 * Created by Chonchol on 28-Aug-16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<ItemListViewHolder>{


    @Override
    public ItemListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ItemListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

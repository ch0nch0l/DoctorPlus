package net.zeroit.vortexzero.doctorplus.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Chonchol on 28-Aug-16.
 */
public class ItemListViewHolder extends RecyclerView.ViewHolder {

    protected ImageView itemImage;
    protected TextView itemName;
    protected TextView itemAddress;
    protected TextView itemPhone;

    public ItemListViewHolder(View itemView) {
        super(itemView);
    }
}

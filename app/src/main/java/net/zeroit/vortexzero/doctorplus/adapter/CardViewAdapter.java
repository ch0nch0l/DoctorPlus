package net.zeroit.vortexzero.doctorplus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.zeroit.vortexzero.doctorplus.R;

import java.util.ArrayList;

/**
 * Created by Chonchol on 19-Aug-16.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {

    private Context context;
    private ArrayList list = new ArrayList();

    public class CardViewHolder extends RecyclerView.ViewHolder{

        public TextView title, count;
        public ImageView logo;

        public CardViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_title);
            count = (TextView) itemView.findViewById(R.id.item_count);
            logo = (ImageView) itemView.findViewById(R.id.item_logo);
        }
    }

    public CardViewAdapter(Context context, ArrayList list) {
        this.context = context;
        this.list = list;
    }

    public CardViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.title.setText(list.get(position).toString());
        holder.count.setText(list.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

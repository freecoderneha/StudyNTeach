package com.example.neha.studynteach;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private Context context;
    private List<PickItem> cartList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description, price;
        public ImageView thumbnail;
        public RelativeLayout viewBackground, viewForeground;

        public MyViewHolder(View v) {
            super(v);
           name= (TextView) v.findViewById(R.id.name);
            description =(TextView) v.findViewById(R.id.description);
            price = (TextView)v.findViewById(R.id.likes);
            thumbnail = (ImageView)v.findViewById(R.id.thumbnail);
            viewBackground = (RelativeLayout) v.findViewById(R.id.view_background);
            viewForeground = (RelativeLayout)v.findViewById(R.id.view_foreground);
        }
    }


    public ItemAdapter(Context context, List<PickItem> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final PickItem item = cartList.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.price.setText(item.getLikes()+" ratings");

        Glide.with(context)
                .load(item.getThumbnail())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public void removeItem(int position) {
        cartList.remove(position);

        notifyItemRemoved(position);
    }

    public void restoreItem(PickItem item, int position) {
        cartList.add(position, item);

        notifyItemInserted(position);
    }
}
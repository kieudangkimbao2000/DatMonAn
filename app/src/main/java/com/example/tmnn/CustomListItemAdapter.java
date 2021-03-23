package com.example.tmnn;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListItemAdapter extends ArrayAdapter<ItemsList> {
    Context context;
    ItemsList[] items;

     public CustomListItemAdapter(Context context, int layoutTobeInflated, ItemsList[] items){
        super(context, R.layout.list_item_lnk_img, items);
        this.context = context;
        this.items = items;
     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.list_item_lnk_img, null);
        TextView foodName = (TextView) row.findViewById(R.id.tvName);
        TextView foodLocation = (TextView) row.findViewById(R.id.tvLocation);
        ImageView foodImage = (ImageView) row.findViewById(R.id.ivFood);

        foodName.setText(items[position].getFoodName());
        foodLocation.setText(items[position].getFoodLocation());
        foodImage.setImageResource(items[position].getFoodImage());

        return row;
    }
}

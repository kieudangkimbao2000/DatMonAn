package com.example.tmnn;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomListItemAdapter extends ArrayAdapter<Item> {
    Context context;
    Item[] items;

    public CustomListItemAdapter(Context context, int layoutTobeInflated, Item[] items){
        super(context, R.layout.list_item_lnk_img, items);
        this.context = context;
        this.items = items;
     }

     private View.OnClickListener itemClickLítener = new View.OnClickListener(){
         @Override
         public void onClick(View v) {
             switch (v.getId()){
                 case R.id.tvName:
                     int i = Integer.parseInt(v.getTag().toString());
                     Intent intent = new Intent(context, ChiTietActivity.class);
                     intent.putExtra("Chi tiet", items[i]);
                     context.startActivity(intent);
                     return;
                 case R.id.tvLocation:
                     onBrowseClick(v);
                     return;
             }
         }
     };

    private CompoundButton.OnCheckedChangeListener itemChangeChecked = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                int i = Integer.parseInt(buttonView.getTag().toString());
                items[i].setSelected(true);
            }
            else {
                int i = Integer.parseInt(buttonView.getTag().toString());
                items[i].setSelected(false);
            }

        }
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.list_item_lnk_img, null);
        TextView foodName = (TextView) row.findViewById(R.id.tvName);
        TextView foodLocation = (TextView) row.findViewById(R.id.tvLocation);
        ImageView foodImage = (ImageView) row.findViewById(R.id.ivFood);

        foodName.setText(items[position].getFoodName());
        foodName.setTag(position);

        foodLocation.setText(items[position].getFoodLocation());
        foodLocation.setTag(items[position].getFoodLink());

        foodImage.setImageResource(items[position].getFoodImage());

        CheckBox cbSelected = row.findViewById(R.id.cbFood);
        cbSelected.setChecked(items[position].isSelected());
        cbSelected.setTag(position);

        cbSelected.setOnCheckedChangeListener( itemChangeChecked);
        cbSelected.setOnCheckedChangeListener( itemChangeChecked);

        foodName.setOnClickListener(itemClickLítener);
        foodLocation.setOnClickListener(itemClickLítener);
        return row;

    }

    public void onBrowseClick(View v) {
        String url = v.getTag().toString();
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            // Here we use an intent without a Chooser unlike the next example
            context.startActivity(intent);
        }
    }
}

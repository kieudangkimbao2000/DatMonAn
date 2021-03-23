package com.example.tmnn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ItemsList[] items;
    ListView _myList;
    CustomListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareDate();
        _myList = (ListView) findViewById(R.id.myList);
        adapter = new CustomListItemAdapter(this, R.layout.list_item_lnk_img, items);
        _myList.setAdapter(adapter);
    }

    public void prepareDate(){
        items = new ItemsList[10];
        items[0] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
        items[1] = new ItemsList("Quán Nướng Việt", "http://123-zo.vn", "ha noi", R.drawable.food);
        items[2] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
        items[3] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
        items[4] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
        items[5] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
        items[6] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
        items[7] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
        items[8] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
        items[9] = new ItemsList("Quán ăn ngon Sài Gòn", "http://www.google.com", "ho chi minh", R.drawable.food);
    }
}
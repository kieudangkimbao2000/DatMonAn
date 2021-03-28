package com.example.tmnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ChiTietActivity extends AppCompatActivity {
    ImageView _ivFoodDetails;
    TextView _tvName, _tvPrice, _tvContet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        Intent intent = getIntent();
        Item item = (Item)intent.getSerializableExtra("Chi tiet");

        _ivFoodDetails = (ImageView) findViewById(R.id.ivFoodDetails);
        _tvName = (TextView) findViewById(R.id.tvNameDetails);
        _tvPrice = (TextView) findViewById(R.id.tvPriceDetails);
        _tvContet = (TextView) findViewById(R.id.tvContentDetails);

        _ivFoodDetails.setImageResource(item.getFoodImage());
        _tvName.setText(item.getFoodName().toString());
        _tvPrice.setText(String.valueOf(item.getPrice()));
        _tvContet.setText(item.getFoodDetails());
    }
}
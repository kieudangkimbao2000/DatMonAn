package com.example.tmnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ChiTietActivity extends AppCompatActivity {
    TextView _tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        Intent intent = getIntent();
        _tvContent = (TextView) findViewById(R.id.tvChiTiet);
        _tvContent.setText(intent.getStringExtra(MainActivity.EXTRA_TEXT));
    }
}
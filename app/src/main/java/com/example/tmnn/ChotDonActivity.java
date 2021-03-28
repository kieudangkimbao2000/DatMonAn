package com.example.tmnn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ChotDonActivity extends AppCompatActivity {
    ListView _foodsChecked;
    EditText _edtDiaChi;
    Button _btnChoDon;
    ArrayAdapter<String> adapter;
    String numberPhone = "0342617369";
    String content = "Đặt: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chot_don);

        Intent intent = getIntent();
        ItemsList itemsList = (ItemsList)intent.getSerializableExtra("ItemsChecked");
        Item[] items = itemsList.getItems();
        String[] name = new String[items.length];
        for(int i = 0; i < items.length; i++){
            name[i] = items[i].getFoodName();
            if(i < (items.length - 1)){
                content = content + name[i] +", ";
            }else{
                content = content + name[i]+".";
            }
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        _foodsChecked = (ListView) findViewById(R.id.foodCheckedList);
        _foodsChecked.setAdapter(adapter);

        _edtDiaChi = (EditText) findViewById(R.id.edtDiaChi);
        _btnChoDon = (Button) findViewById(R.id.btnChotDon);
        _btnChoDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                if(_edtDiaChi.getText().toString().equals("")){
                    Toast.makeText( ChotDonActivity.this, " Nhập địa chỉ", Toast.LENGTH_SHORT).show();
                }else{
                    content = content + " Địa chỉ: " + _edtDiaChi.getText().toString() + ".";
                    for(; i < content.length(); i ++){
                        if(content.charAt(i) == '.'){
                            guiSMS(numberPhone, content.substring(0, i + 1));
                            break;
                        }
                    }
                    guiSMS(numberPhone, content.substring(i + 1, content.length()));
                    Toast.makeText(ChotDonActivity.this, "Đã đặt món", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ChotDonActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void guiSMS(String numberPhone, String content){
        if(checkPermission(Manifest.permission.SEND_SMS)){
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numberPhone, null, content, null, null);
        }
    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return check == PackageManager.PERMISSION_GRANTED;
    }
}
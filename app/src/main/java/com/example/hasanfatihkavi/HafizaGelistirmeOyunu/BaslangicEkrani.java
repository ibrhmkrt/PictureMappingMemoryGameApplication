package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BaslangicEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Kullanılan activity

        final EditText et = (EditText)findViewById(R.id.editText);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {     // Butona tıklandığında
                Intent i = new Intent(BaslangicEkrani.this, seviye1.class); // seviye1 sayfasını aç
                i.putExtra("isim",et.getText().toString());                 // Kullanıcı ismini gönder
                startActivity(i);
            }
        });
    }
}

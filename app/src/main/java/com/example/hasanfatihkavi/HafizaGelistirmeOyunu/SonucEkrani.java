package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SonucEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i=getIntent();
        String isim = i.getStringExtra("isim");
        int puan = i.getIntExtra("puan",0);

        TextView tv = (TextView)findViewById(R.id.tvSonuc);
        tv.setText("Tebrikler "+isim+".\n"+puan+" puan ile oyunu tamamladın. ");

        Button b = (Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(SonucEkrani.this,seviye1.class);
                startActivity(i);
            }
        });

        Toast.makeText(getApplicationContext(),"HADİ TEKRAR DENEYİN",Toast.LENGTH_LONG).show();
    }
}

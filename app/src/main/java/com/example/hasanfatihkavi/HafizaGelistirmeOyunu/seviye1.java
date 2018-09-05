package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by TheGMS on 26.05.2017.
 */

public class seviye1 extends AppCompatActivity {
    card1 lastClick=null;
    int puan=100;
    int hata=2;
    int eslesmeSayisi=0;

    MediaPlayer MP;
    public static TextToSpeech stringiSeseCevir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye1);

        stringiSeseCevir = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener(){
                   @Override
                    public void onInit(int status){
                       if(status != TextToSpeech.ERROR)
                           stringiSeseCevir.setLanguage(new Locale("tr","TR"));
                       else{}
                   }
                });

        GridLayout kartlarGridi= (GridLayout)findViewById(R.id.cardLayout1); // Gridlayout nesnesi oluştur
        card1 kartDizisi [] = new card1[4]; // myCard sınıfından 16 boyutluk bir dizi nesnesi oluştur

        Intent i = getIntent();
        final String isim = i.getStringExtra("isim");

        for(int j=0;j<4;j++){
            kartDizisi[j] = new card1(this, j); // Bütün kartları bu dizinin bir elemanı yap sırasıyla
        }
        for(int j=0;j<4;j++){  // Kartları karıştırma işlemini bu for'da yapıyorum
            int r = (int)(Math.random()*4);
            card1 guncelKart = kartDizisi[r];
            kartDizisi[r] = kartDizisi[j];
            kartDizisi[j] = guncelKart;
        }

        for(int k=0;k<4;k++)  // Kartların başlangıçta 2 saniye açık kalıp sonra kapanmasını sağlayan döngü
        {
            final card1 aktifKart = kartDizisi[k];
            Handler baslangic=new Handler();
            baslangic.postDelayed(new Runnable(){
                @Override
                public void run(){
                    aktifKart.kartiDonder();
                }
            },1000);
            aktifKart.kartiDonder();
        }

        puan=100;
        hata=2;
        TextView tvBaslangic=(TextView)findViewById(R.id.tvPuan1);
        tvBaslangic.setText("Puan: "+puan+"\nKalan Hata Sayısı: "+hata);

        for(int j =0;j<4;j++) {
            final card1 guncelKart = kartDizisi[j]; // O anki kart'ı güncelkart değişkenine ata

            kartlarGridi.addView(guncelKart); // Güncelkartı grid'e ekle
            guncelKart.setOnClickListener(new View.OnClickListener() {  // Güncel kart'a tıklandığında  ...
                @Override
                public void onClick(View v) {
                    if(lastClick!=null) { // Herhangi bir kart'a tıklanmışsa
                        guncelKart.kartiDonder(); // Tıklanan ikinci kartı da dönder ve altta eşleşmiş mi kontrol et
                        TextView tvPuanVeHata=(TextView)findViewById(R.id.tvPuan1);

                        if(guncelKart.id != lastClick.id && guncelKart.id%2 == lastClick.id%2){
                            // Kartlar eşleştiyse

                            if(guncelKart.id%2 == 1){
                                stringiSeseCevir.speak("Dogru", TextToSpeech.QUEUE_FLUSH,null);
                                Toast.makeText(getApplicationContext(),"Doğru", Toast.LENGTH_SHORT).show();
                            }
                            else if(guncelKart.id%2 == 0) {
                                stringiSeseCevir.speak("Yanlis", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(),"Yanlış", Toast.LENGTH_SHORT).show();
                            }
                            puan+=100;
                            eslesmeSayisi++;

                            guncelKart.cevrilebilirlik=false; // Açılan kart geri kapatılamasın
                            lastClick.cevrilebilirlik=false;  // Açılan kartın bir diğeri de geri kapatılamasın
                            lastClick = null; // Tıklama değişkenimizi de temizleyelim

                            tvPuanVeHata.setText("Puan: "+puan+"\nKalan Hata Sayısı: "+hata);

                            if(eslesmeSayisi==2){
                                MP=MediaPlayer.create(seviye1.this, R.raw.supermario);
                                Handler h1 = new Handler();
                                h1.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        MP.start();
                                    }
                                },1000);

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent i = new Intent(seviye1.this,seviye2.class);
                                        i.putExtra("puan",puan);
                                        i.putExtra("isim",isim);
                                        startActivity(i);
                                    }
                                },8000);
                            }
                        }
                        else {
                            // Kartlar eşleşmemişse

                            hata--;
                            puan-=20;

                            if(hata==0){
                                MP=MediaPlayer.create(seviye1.this, R.raw.toing6);
                                MP.start();

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        puan=0;
                                        hata=2;
                                        eslesmeSayisi=0;

                                        Intent tekrar = getIntent();
                                        finish();
                                        startActivity(tekrar);
                                    }
                                },2000);
                            }

                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() { // 500 milisaniye bekle ve eşleşmeyen kartları tekrar arkaya dönder
                                    lastClick.kartiDonder();
                                    lastClick=null;
                                    guncelKart.kartiDonder();
                                }
                            },500);

                            tvPuanVeHata.setText("Puan: "+puan+"\nKalan Hata Sayısı: "+hata);
                        }
                    }
                    else {
                        // Hiçbir kart'a tıklanmamışsa ilk tıklandıktan sonra ...
                        guncelKart.kartiDonder(); // Tıklanan kartı dönder
                        lastClick=guncelKart; // lastClick tıklanma değişkenimizin son değerini güncelle
                    }
                }
            });
        }
    }
}

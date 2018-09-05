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

import java.util.Locale;

/**
 * Created by TheGMS on 10.05.2017.
 */

public class seviye2 extends AppCompatActivity {
    card2 lastClick=null;
    int puan;
    int hata=4;
    int eslesmeSayisi=0;

    MediaPlayer MP;
    //public static TextToSpeech stringiSeseCevir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye2);

       /* stringiSeseCevir = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener(){
                    @Override
                    public void onInit(int status){
                        if(status != TextToSpeech.ERROR)
                            stringiSeseCevir.setLanguage(new Locale("tr","TR"));
                        else{}
                    }
                });*/

        GridLayout kartlarGridi= (GridLayout)findViewById(R.id.cardLayout2); // Gridlayout nesnesi oluştur
        card2 kartDizisi [] = new card2[8]; // myCard sınıfından 16 boyutluk bir dizi nesnesi oluştur

        Intent i = getIntent();
        final String isim = i.getStringExtra("isim");

        for(int j=0;j<8;j++){

            kartDizisi[j] = new card2(this, j); // Bütün kartları bu dizinin bir elemanı yap sırasıyla
        }
        for(int j=0;j<8;j++){  // Kartları karıştırma işlemini bu for'da yapıyorum
            int r = (int)(Math.random()*8);
            card2 guncelKart = kartDizisi[r];
            kartDizisi[r] = kartDizisi[j];
            kartDizisi[j] = guncelKart;
        }

        for(int k=0;k<8;k++)  // Kartların başlangıçta 2 saniye açık kalıp sonra kapanmasını sağlayan döngü
        {
            final card2 aktifKart = kartDizisi[k];
            Handler baslangic=new Handler();
            baslangic.postDelayed(new Runnable(){
                @Override
                public void run(){
                    aktifKart.kartiDonder();
                }
            },1500);
            aktifKart.kartiDonder();
        }

        Intent IT = getIntent();
        puan=IT.getIntExtra("puan",0);
        final int puanKayit=puan;

        TextView tvBaslangic=(TextView)findViewById(R.id.tvPuan2);
        tvBaslangic.setText("Puan: "+puan+"\nKalan Hata Sayısı: "+hata);

        for(int j =0;j<8;j++) {
            final card2 guncelKart = kartDizisi[j]; // O anki kart'ı güncelkart değişkenine ata

            kartlarGridi.addView(guncelKart); // Güncelkartı grid'e ekle
            guncelKart.setOnClickListener(new View.OnClickListener() {  // Güncel kart'a tıklandığında  ...
                @Override
                public void onClick(View v) {
                    if(lastClick!=null) { // Herhangi bir kart'a tıklanmışsa
                        guncelKart.kartiDonder(); // Tıklanan ikinci kartı da dönder ve altta eşleşmiş mi kontrol et
                        TextView tvPuanVeHata=(TextView)findViewById(R.id.tvPuan2);

                        if(guncelKart.id != lastClick.id && guncelKart.id%4 == lastClick.id%4){
                            // Kartlar eşleştiyse

                            if(guncelKart.id%4 == 1) {
                                //stringiSeseCevir.speak("Cat", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Kedi", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye2.this,R.raw.cat);
                                MP.start();
                            }
                            else if(guncelKart.id%4 == 2) {
                                //stringiSeseCevir.speak("Elephant", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Fil", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye2.this,R.raw.fil);
                                MP.start();
                            }
                            else if(guncelKart.id%4 == 3) {
                                //stringiSeseCevir.speak("Monkey", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Maymun", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye2.this,R.raw.maymun);
                                MP.start();
                            }
                            else if(guncelKart.id%4 == 0) {
                                //stringiSeseCevir.speak("Lion", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Aslan", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye2.this,R.raw.roar);
                                MP.start();
                            }

                            puan+=100;
                            eslesmeSayisi++;

                            guncelKart.cevrilebilirlik=false; // Açılan kart geri kapatılamasın
                            lastClick.cevrilebilirlik=false;  // Açılan kartın bir diğeri de geri kapatılamasın
                            lastClick = null; // Tıklama değişkenimizi de temizleyelim

                            tvPuanVeHata.setText("Puan: "+puan+"\nKalan Hata Sayısı: "+hata);

                            if(eslesmeSayisi==4){
                                MP=MediaPlayer.create(seviye2.this, R.raw.supermario);
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

                                        Intent i = new Intent(seviye2.this,seviye3.class);
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
                                MP=MediaPlayer.create(seviye2.this, R.raw.toing6);
                                MP.start();

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        puan=puanKayit;
                                        hata=4;
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

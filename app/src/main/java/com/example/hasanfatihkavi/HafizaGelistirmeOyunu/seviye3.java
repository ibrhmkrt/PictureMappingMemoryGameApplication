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
public class seviye3 extends AppCompatActivity {
    card3 lastClick=null;
    int puan;
    int hata=6;
    int eslesmeSayisi=0;
    MediaPlayer MP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye3);


        GridLayout kartlarGridi= (GridLayout)findViewById(R.id.cardLayout3); // Gridlayout nesnesi oluştur
        card3 kartDizisi [] = new card3[12]; // myCard sınıfından 16 boyutluk bir dizi nesnesi oluştur

        Intent i = getIntent();
        final String isim = i.getStringExtra("isim");

        for(int j=0;j<12;j++){
            kartDizisi[j] = new card3(this, j); // Bütün kartları bu dizinin bir elemanı yap sırasıyla
        }
        for(int j=0;j<12;j++){  // Kartları karıştırma işlemini bu for'da yapıyorum
            int r = (int)(Math.random()*12);
            card3 guncelKart = kartDizisi[r];
            kartDizisi[r] = kartDizisi[j];
            kartDizisi[j] = guncelKart;
        }

        for(int k=0;k<12;k++)  // Kartların başlangıçta 2 saniye açık kalıp sonra kapanmasını sağlayan döngü
        {
            final card3 aktifKart = kartDizisi[k];
            Handler baslangic=new Handler();
            baslangic.postDelayed(new Runnable(){
                @Override
                public void run(){
                    aktifKart.kartiDonder();
                }
            },2000);
            aktifKart.kartiDonder();
        }

        Intent IT = getIntent();
        puan=IT.getIntExtra("puan",0);
        final int puanKayit=puan;

        TextView tvBaslangic=(TextView)findViewById(R.id.tvPuan3);
        tvBaslangic.setText("Puan: "+puan+"\nKalan Hata Sayısı: "+hata);

        for(int j =0;j<12;j++) {
            final card3 guncelKart = kartDizisi[j]; // O anki kart'ı güncelkart değişkenine ata

            kartlarGridi.addView(guncelKart); // Güncelkartı grid'e ekle
            guncelKart.setOnClickListener(new View.OnClickListener() {  // Güncel kart'a tıklandığında  ...
                @Override
                public void onClick(View v) {
                    if(lastClick!=null) { // Herhangi bir kart'a tıklanmışsa
                        guncelKart.kartiDonder(); // Tıklanan ikinci kartı da dönder ve altta eşleşmiş mi kontrol et
                        TextView tvPuanVeHata=(TextView)findViewById(R.id.tvPuan3);

                        if(guncelKart.id != lastClick.id && guncelKart.id%6 == lastClick.id%6){
                            // Kartlar eşleştiyse

                            if(guncelKart.id%6 == 1) {
                                //stringiSeseCevir.speak("Horse", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "At", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye3.this,R.raw.at);
                                MP.start();
                            }
                            else if(guncelKart.id%6 == 2){
                                //stringiSeseCevir.speak("Frog", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Kurbağa", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye3.this,R.raw.frog);
                                MP.start();
                            }
                            else if(guncelKart.id%6 == 3){
                                //stringiSeseCevir.speak("Duck", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Ördek", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye3.this,R.raw.ordek);
                                MP.start();
                            }
                            else if(guncelKart.id%6 == 4){
                                //stringiSeseCevir.speak("Chick", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Civciv", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye3.this,R.raw.civciv);
                                MP.start();
                            }
                            else if(guncelKart.id%6 == 5){
                                //stringiSeseCevir.speak("Cock", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Horoz", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye3.this,R.raw.horoz);
                                MP.start();
                            }
                            else if(guncelKart.id%6 == 0){
                                //stringiSeseCevir.speak("Dog", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Köpek", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye3.this,R.raw.dog);
                                MP.start();
                            }

                            puan+=100;
                            eslesmeSayisi++;

                            guncelKart.cevrilebilirlik=false; // Açılan kart geri kapatılamasın
                            lastClick.cevrilebilirlik=false;  // Açılan kartın bir diğeri de geri kapatılamasın
                            lastClick = null; // Tıklama değişkenimizi de temizleyelim

                            tvPuanVeHata.setText("Puan: "+puan+"\nKalan Hata Sayısı: "+hata);

                            if(eslesmeSayisi==6){
                                MP=MediaPlayer.create(seviye3.this, R.raw.supermario);
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

                                        Intent i = new Intent(seviye3.this,seviye4.class);
                                        i.putExtra("puan",puan);
                                        i.putExtra("hata",hata);
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
                                MP=MediaPlayer.create(seviye3.this, R.raw.toing6);
                                MP.start();

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        puan=puanKayit;
                                        hata=6;
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

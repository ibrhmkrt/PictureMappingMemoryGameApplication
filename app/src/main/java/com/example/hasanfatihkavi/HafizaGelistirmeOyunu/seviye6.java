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
public class seviye6 extends AppCompatActivity {
    card6 lastClick=null;
    int puan;
    int hata=18;
    int eslesmeSayisi=0;
    MediaPlayer MP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye6);
        GridLayout kartlarGridi= (GridLayout)findViewById(R.id.cardLayout6); // Gridlayout nesnesi oluştur
        card6 kartDizisi [] = new card6[24]; // myCard sınıfından 16 boyutluk bir dizi nesnesi oluştur

        Intent i = getIntent();
        final String isim = i.getStringExtra("isim");

        for(int j=0;j<24;j++){

            kartDizisi[j] = new card6(this, j); // Bütün kartları bu dizinin bir elemanı yap sırasıyla
        }
        for(int j=0;j<24;j++){  // Kartları karıştırma işlemini bu for'da yapıyorum
            int r = (int)(Math.random()*24);
            card6 guncelKart = kartDizisi[r];
            kartDizisi[r] = kartDizisi[j];
            kartDizisi[j] = guncelKart;
        }

        for(int k=0;k<24;k++)  // Kartların başlangıçta 2 saniye açık kalıp sonra kapanmasını sağlayan döngü
        {
            final card6 aktifKart = kartDizisi[k];
            Handler baslangic=new Handler();
            baslangic.postDelayed(new Runnable(){
                @Override
                public void run(){
                    aktifKart.kartiDonder();
                }
            },5000);
            aktifKart.kartiDonder();
        }

        Intent IT = getIntent();
        puan=IT.getIntExtra("puan",0);
        final int puanKayit = puan;

        TextView tvBaslangic=(TextView)findViewById(R.id.tvPuan6);
        tvBaslangic.setText("Puan: " + puan + "\nKalan Hata Sayısı: " + hata);

        for (int j = 0; j < 24; j++) {
            final card6 guncelKart = kartDizisi[j]; // O anki kart'ı güncelkart değişkenine ata

            kartlarGridi.addView(guncelKart); // Güncelkartı grid'e ekle
            guncelKart.setOnClickListener(new View.OnClickListener() {  // Güncel kart'a tıklandığında  ...
                @Override
                public void onClick(View v) {
                    if (lastClick != null) { // Herhangi bir kart'a tıklanmışsa

                        guncelKart.kartiDonder(); // Tıklanan ikinci kartı da dönder ve altta eşleşmiş mi kontrol et
                        TextView tvPuanVeHata = (TextView) findViewById(R.id.tvPuan6);

                        if (guncelKart.id != lastClick.id && guncelKart.id % 12 == lastClick.id % 12) {
                            // Kartlar eşleştiyse

                            if(guncelKart.id%12 == 1) {
                                //stringiSeseCevir.speak("Apple", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Elma", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.elma);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 2) {
                                //stringiSeseCevir.speak("Pear", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Armut", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.armut);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 3){
                                //stringiSeseCevir.speak("Melon", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Kavun", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.kavun);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 4){
                                //stringiSeseCevir.speak("Watermelon", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Karpuz", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.karpuz);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 5){
                                //stringiSeseCevir.speak("Kiwi", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Kivi", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.kivi);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 6){
                                //stringiSeseCevir.speak("Peach", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Şeftali", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.seftali);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 7){
                                //stringiSeseCevir.speak("Tangerine", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Mandalina", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.mandalina);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 8){
                                //stringiSeseCevir.speak("Raspberry", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Muz", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.muz);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 9){
                                //stringiSeseCevir.speak("Cherry", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Kiraz", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.kiraz);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 10){
                                //stringiSeseCevir.speak("Strawberry", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Çilek", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.cilek);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 11){
                                //stringiSeseCevir.speak("Berry", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Portakal", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.portakal);
                                MP.start();
                            }
                            else if(guncelKart.id%12 == 0){
                                //stringiSeseCevir.speak("Grape", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Üzüm", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye6.this,R.raw.uzum);
                                MP.start();
                            }

                            puan += 100;
                            eslesmeSayisi++;

                            guncelKart.cevrilebilirlik = false; // Açılan kart geri kapatılamasın
                            lastClick.cevrilebilirlik = false;  // Açılan kartın bir diğeri de geri kapatılamasın
                            lastClick = null; // Tıklama değişkenimizi de temizleyelim

                            tvPuanVeHata.setText("Puan: " + puan + "\nKalan Hata Sayısı: " + hata);

                            if (eslesmeSayisi == 12) {
                                MP=MediaPlayer.create(seviye6.this, R.raw.cocuklar);
                                Handler h1 = new Handler();
                                h1.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        MP.start();
                                    }
                                }, 1000);

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        Intent i = new Intent(seviye6.this, SonucEkrani.class);
                                        i.putExtra("puan", puan);
                                        i.putExtra("isim", isim);
                                        startActivity(i);
                                    }
                                }, 4000);
                            }
                        }
                        else {
                            // Kartlar eşleşmemişse

                            hata--;
                            puan -= 20;

                            if (hata == 0) {
                                MP = MediaPlayer.create(seviye6.this, R.raw.toing6);
                                MP.start();

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        puan = puanKayit;
                                        hata = 20;
                                        eslesmeSayisi = 0;

                                        Intent tekrar = getIntent();
                                        finish();
                                        startActivity(tekrar);
                                    }
                                }, 2000);
                            }

                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() { // 500 milisaniye bekle ve eşleşmeyen kartları tekrar arkaya dönder
                                    lastClick.kartiDonder();
                                    lastClick = null;
                                    guncelKart.kartiDonder();
                                }
                            }, 500);

                            tvPuanVeHata.setText("Puan: " + puan + "\nKalan Hata Sayısı: " + hata);
                        }
                    }
                    else {
                        // Hiçbir kart'a tıklanmamışsa ilk tıklandıktan sonra ...
                        guncelKart.kartiDonder(); // Tıklanan kartı dönder
                        lastClick = guncelKart; // lastClick tıklanma değişkenimizin son değerini güncelle
                    }
                }
            });
        }
    }
}

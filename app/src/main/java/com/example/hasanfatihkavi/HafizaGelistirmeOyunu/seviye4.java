package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class seviye4 extends AppCompatActivity {
    card4 lastClick = null;
    int puan;
    int hata = 8;
    int eslesmeSayisi = 0;

    MediaPlayer MP;
    //public static TextToSpeech stringiSeseCevir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye4);

        /*stringiSeseCevir = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener(){
                    @Override
                    public void onInit(int status){
                        if(status != TextToSpeech.ERROR)
                            stringiSeseCevir.setLanguage(new Locale("tr","TR"));
                        else{}
                    }
                });*/

        GridLayout kartlarGridi = (GridLayout) findViewById(R.id.cardLayout4); // Gridlayout nesnesi oluştur
        card4 kartDizisi[] = new card4[16]; // myCard sınıfından 16 boyutluk bir dizi nesnesi oluştur

        Intent i = getIntent();
        final String isim = i.getStringExtra("isim");

        for (int j = 0; j < 16; j++) {

            kartDizisi[j] = new card4(this, j); // Bütün kartları bu dizinin bir elemanı yap sırasıyla
        }
        for (int j = 0; j < 16; j++) {  // Kartları karıştırma işlemini bu for'da yapıyorum
            int r = (int) (Math.random() * 16);
            card4 guncelKart = kartDizisi[r];
            kartDizisi[r] = kartDizisi[j];
            kartDizisi[j] = guncelKart;
        }


        for (int k = 0; k < 16; k++)  // Kartların başlangıçta 2 saniye açık kalıp sonra kapanmasını sağlayan döngü
        {
            final card4 aktifKart = kartDizisi[k];
            Handler baslangic = new Handler();
            baslangic.postDelayed(new Runnable() {
                @Override
                public void run() {
                    aktifKart.kartiDonder();
                }
            }, 3000);
            aktifKart.kartiDonder();
        }

        Intent IT = getIntent();
        puan = IT.getIntExtra("puan", 0);
        final int puanKayit = puan;

        TextView tvBaslangic = (TextView) findViewById(R.id.tvPuan4);
        tvBaslangic.setText("Puan: " + puan + "\nKalan Hata Sayısı: " + hata);

        for (int j = 0; j < 16; j++) {
            final card4 guncelKart = kartDizisi[j]; // O anki kart'ı güncelkart değişkenine ata

            kartlarGridi.addView(guncelKart); // Güncelkartı grid'e ekle
            guncelKart.setOnClickListener(new View.OnClickListener() {  // Güncel kart'a tıklandığında  ...
                @Override
                public void onClick(View v) {
                    if (lastClick != null) { // Herhangi bir kart'a tıklanmışsa

                        guncelKart.kartiDonder(); // Tıklanan ikinci kartı da dönder ve altta eşleşmiş mi kontrol et
                        TextView tvPuanVeHata = (TextView) findViewById(R.id.tvPuan4);

                        if (guncelKart.id != lastClick.id && guncelKart.id % 8 == lastClick.id % 8) {
                            // Kartlar eşleştiyse

                            if(guncelKart.id%8 == 1) {
                                //stringiSeseCevir.speak("A", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "A", Toast.LENGTH_SHORT).show();
                                MP=MediaPlayer.create(seviye4.this,R.raw.a);
                                MP.start();
                            }
                            else if(guncelKart.id%8 == 2) {
                                Toast.makeText(getApplicationContext(), "B", Toast.LENGTH_SHORT).show();
                                //stringiSeseCevir.speak("B", TextToSpeech.QUEUE_FLUSH, null);
                                MP=MediaPlayer.create(seviye4.this,R.raw.b);
                                MP.start();
                            }
                            else if(guncelKart.id%8 == 3){
                                Toast.makeText(getApplicationContext(), "C", Toast.LENGTH_SHORT).show();
                                //stringiSeseCevir.speak("C", TextToSpeech.QUEUE_FLUSH, null);
                                MP=MediaPlayer.create(seviye4.this,R.raw.c);
                                MP.start();
                            }
                            else if(guncelKart.id%8 == 4){
                                Toast.makeText(getApplicationContext(), "D", Toast.LENGTH_SHORT).show();
                                //stringiSeseCevir.speak("D", TextToSpeech.QUEUE_FLUSH, null);
                                MP=MediaPlayer.create(seviye4.this,R.raw.d);
                                MP.start();
                            }
                            else if(guncelKart.id%8 == 5){
                                Toast.makeText(getApplicationContext(), "E", Toast.LENGTH_SHORT).show();
                                //stringiSeseCevir.speak("E", TextToSpeech.QUEUE_FLUSH, null);
                                MP=MediaPlayer.create(seviye4.this,R.raw.e);
                                MP.start();
                            }
                            else if(guncelKart.id%8 == 6){
                                Toast.makeText(getApplicationContext(), "F", Toast.LENGTH_SHORT).show();
                                //stringiSeseCevir.speak("F", TextToSpeech.QUEUE_FLUSH, null);
                                MP=MediaPlayer.create(seviye4.this,R.raw.f);
                                MP.start();
                            }
                            else if(guncelKart.id%8 == 7){
                                Toast.makeText(getApplicationContext(), "G", Toast.LENGTH_SHORT).show();
                                //stringiSeseCevir.speak("G", TextToSpeech.QUEUE_FLUSH, null);
                                MP=MediaPlayer.create(seviye4.this,R.raw.g);
                                MP.start();
                            }
                            else if(guncelKart.id%8 == 0){
                                Toast.makeText(getApplicationContext(), "H", Toast.LENGTH_SHORT).show();
                                //stringiSeseCevir.speak("H", TextToSpeech.QUEUE_FLUSH, null);
                                MP=MediaPlayer.create(seviye4.this,R.raw.h);
                                MP.start();
                            }

                            puan += 100;
                            eslesmeSayisi++;

                            guncelKart.cevrilebilirlik = false; // Açılan kart geri kapatılamasın
                            lastClick.cevrilebilirlik = false;  // Açılan kartın bir diğeri de geri kapatılamasın
                            lastClick = null; // Tıklama değişkenimizi de temizleyelim

                            tvPuanVeHata.setText("Puan: " + puan + "\nKalan Hata Sayısı: " + hata);

                            if (eslesmeSayisi == 8) {
                                MP=MediaPlayer.create(seviye4.this, R.raw.supermario);
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

                                        Intent i = new Intent(seviye4.this, seviye5.class);
                                        i.putExtra("puan", puan);
                                        i.putExtra("isim", isim);
                                        startActivity(i);
                                    }
                                }, 8000);
                            }
                        }
                        else {
                            // Kartlar eşleşmemişse

                            hata--;
                            puan -= 20;

                            if (hata == 0) {
                                MP = MediaPlayer.create(seviye4.this, R.raw.toing6);
                                MP.start();

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        puan = puanKayit;
                                        hata = 10;
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

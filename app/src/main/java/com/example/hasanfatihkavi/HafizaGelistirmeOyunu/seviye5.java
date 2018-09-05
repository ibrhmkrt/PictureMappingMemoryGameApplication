package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
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

public class seviye5 extends AppCompatActivity {
    card5 lastClick=null;
    int puan;
    int hata=10;
    int eslesmeSayisi=0;

    MediaPlayer MP;
    //public static TextToSpeech stringiSeseCevir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye5);

        /*stringiSeseCevir = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener(){
                    @Override
                    public void onInit(int status){
                        if(status != TextToSpeech.ERROR)
                            stringiSeseCevir.setLanguage(new Locale("tr","TR"));
                        else{}
                    }
                });*/

        GridLayout kartlarGridi= (GridLayout)findViewById(R.id.cardLayout5); // Gridlayout nesnesi oluştur
        card5 kartDizisi [] = new card5[20]; // myCard sınıfından 16 boyutluk bir dizi nesnesi oluştur

        Intent i = getIntent();
        final String isim = i.getStringExtra("isim");

        for(int j=0;j<20;j++){

            kartDizisi[j] = new card5(this, j); // Bütün kartları bu dizinin bir elemanı yap sırasıyla
        }
        for(int j=0;j<20;j++){  // Kartları karıştırma işlemini bu for'da yapıyorum
            int r = (int)(Math.random()*20);
            card5 guncelKart = kartDizisi[r];
            kartDizisi[r] = kartDizisi[j];
            kartDizisi[j] = guncelKart;
        }

        for(int k=0;k<20;k++)  // Kartların başlangıçta 2 saniye açık kalıp sonra kapanmasını sağlayan döngü
        {
            final card5 aktifKart = kartDizisi[k];
            Handler baslangic=new Handler();
            baslangic.postDelayed(new Runnable(){
                @Override
                public void run(){
                    aktifKart.kartiDonder();
                }
            },4000);
            aktifKart.kartiDonder();
        }

        Intent IT = getIntent();
        puan=IT.getIntExtra("puan",0);
        final int puanKayit = puan;

        TextView tvBaslangic=(TextView)findViewById(R.id.tvPuan5);
        tvBaslangic.setText("Puan: " + puan + "\nKalan Hata Sayısı: " + hata);

        for (int j = 0; j < 20; j++) {
            final card5 guncelKart = kartDizisi[j]; // O anki kart'ı güncelkart değişkenine ata

            kartlarGridi.addView(guncelKart); // Güncelkartı grid'e ekle
            guncelKart.setOnClickListener(new View.OnClickListener() {  // Güncel kart'a tıklandığında  ...
                @Override
                public void onClick(View v) {
                    if (lastClick != null) { // Herhangi bir kart'a tıklanmışsa

                        guncelKart.kartiDonder(); // Tıklanan ikinci kartı da dönder ve altta eşleşmiş mi kontrol et
                        TextView tvPuanVeHata = (TextView) findViewById(R.id.tvPuan5);

                        if (guncelKart.id != lastClick.id && guncelKart.id % 10 == lastClick.id % 10) {
                            // Kartlar eşleştiyse

                            if(guncelKart.id%10 == 1) {
                                //stringiSeseCevir.speak("0", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Sıfır", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.sifir);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 2) {
                                //stringiSeseCevir.speak("1", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Bir", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.bir);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 3){
                                //stringiSeseCevir.speak("2", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "İki", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.iki);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 4){
                                //stringiSeseCevir.speak("3", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Üç", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.uc);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 5){
                                //stringiSeseCevir.speak("4", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Dört", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.dort);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 6){
                                //stringiSeseCevir.speak("5", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Beş", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.bes);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 7){
                                //stringiSeseCevir.speak("6", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Altı", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.alti);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 8){
                                //stringiSeseCevir.speak("7", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Yedi", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.yedi);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 9){
                                //stringiSeseCevir.speak("8", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Sekiz", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.sekiz);
                                MP.start();
                            }
                            else if(guncelKart.id%10 == 0){
                                //stringiSeseCevir.speak("9", TextToSpeech.QUEUE_FLUSH, null);
                                Toast.makeText(getApplicationContext(), "Dokuz", Toast.LENGTH_SHORT).show();
                                MP= MediaPlayer.create(seviye5.this,R.raw.dokuz);
                                MP.start();
                            }

                            puan += 100;
                            eslesmeSayisi++;

                            guncelKart.cevrilebilirlik = false; // Açılan kart geri kapatılamasın
                            lastClick.cevrilebilirlik = false;  // Açılan kartın bir diğeri de geri kapatılamasın
                            lastClick = null; // Tıklama değişkenimizi de temizleyelim

                            tvPuanVeHata.setText("Puan: " + puan + "\nKalan Hata Sayısı: " + hata);

                            if (eslesmeSayisi == 10) {
                               MP=MediaPlayer.create(seviye5.this, R.raw.supermario);
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

                                        Intent i = new Intent(seviye5.this, seviye6.class);
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
                                MP = MediaPlayer.create(seviye5.this, R.raw.toing6);
                                MP.start();

                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        puan = puanKayit;
                                        hata = 15;
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

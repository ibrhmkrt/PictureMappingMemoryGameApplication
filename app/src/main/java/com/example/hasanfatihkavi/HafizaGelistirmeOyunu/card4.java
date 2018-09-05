package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

public class card4 extends Button {
    int id;
    boolean kartCevrilmismi= false;
    boolean cevrilebilirlik= true;

    Drawable arkaTaraf,onTaraf=null; // Grid'de ki resimler için drawable tipinde 2 tane değişken oluşturyoruz

    public card4(Context c, int id){
        super(c);  // Bu content ve id için işlem yapacağız
        this.id =id;
        setId(id);

        // Başlangıçta tüm kartların arkaTarafı aynı resim olsun. (back.jpg)
        // Hepsinin ön yüzü de kendi resmi olsun.
        arkaTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.back2);
        if(id %8 == 1)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.aa2);
        if(id %8 == 2)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.bb2);
        if(id %8 == 3)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.cc2);
        if(id %8 == 4)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.dd2);
        if(id %8 == 5)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.ee2);
        if(id %8 == 6)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.ff2);
        if(id %8 == 7)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.gg2);
        if(id %8 == 0)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.hh2);
        setBackground(arkaTaraf); // Başlangıçta hiçbir kart açılmamış olmalı.
    }
    public void kartiDonder(){
        if(!cevrilebilirlik)
            return;
        if(!kartCevrilmismi) {  // Kartın açılması gerekiyorsa
            setBackground(onTaraf);        // Kartın kendi resmini göster
            kartCevrilmismi = true;        // İlgili değişkeni true yap
        }
        else {                 // Kartın kapalı olması gerekiyorsa
            setBackground(arkaTaraf);      // Kartı arkasına dönder
            kartCevrilmismi = false;       // İlgili değişkeni false yap
        }
    }
}

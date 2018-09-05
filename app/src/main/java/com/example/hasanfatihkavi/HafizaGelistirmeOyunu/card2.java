package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

/**
 * Created by TheGMS on 10.05.2017.
 */

public class card2 extends Button {
    int id;
    boolean kartCevrilmismi= false;
    boolean cevrilebilirlik= true;
    Drawable arkaTaraf,onTaraf=null; // Grid'de ki resimler için drawable tipinde 2 tane değişken oluşturyoruz

    public card2(Context c, int id){
        super(c);  // Bu content ve id için işlem yapacağız
        this.id =id;
        setId(id);

        arkaTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.back2);
        if(id %4 == 1)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.cat2);
        if(id %4 == 2)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.elephant2);
        if(id %4 == 3)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.monkey2);
        if(id %4 == 0)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.lion2);
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

package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

/**
 * Created by TheGMS on 10.05.2017.
 */

public class card5 extends Button {
    int id;
    boolean kartCevrilmismi= false;
    boolean cevrilebilirlik= true;
    Drawable arkaTaraf,onTaraf=null; // Grid'de ki resimler için drawable tipinde 2 tane değişken oluşturyoruz

    public card5(Context c, int id){
        super(c);  // Bu content ve id için işlem yapacağız
        this.id =id;
        setId(id);

        arkaTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.back2);
        if(id %10 == 1)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.zero2);
        if(id %10 == 2)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.one2);
        if(id %10 == 3)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.two2);
        if(id %10 == 4)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.three2);
        if(id %10 == 5)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.four2);
        if(id %10 == 6)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.five2);
        if(id %10 == 7)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.six2);
        if(id %10 == 8)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.seven2);
        if(id %10 == 9)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.eight2);
        if(id %10 == 0)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.nine2);
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

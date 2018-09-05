package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
public class card3 extends Button {
    int id;
    boolean kartCevrilmismi= false;
    boolean cevrilebilirlik= true;
    Drawable arkaTaraf,onTaraf=null; // Grid'de ki resimler için drawable tipinde 2 tane değişken oluşturyoruz

    public card3(Context c, int id){
        super(c);  // Bu content ve id için işlem yapacağız
        this.id =id;
        setId(id);
        arkaTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.back2);
        if(id %6 == 1)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.horse2);
        if(id %6 == 2)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.frog2);
        if(id %6 == 3)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.duck2);
        if(id %6 == 4)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.chick2);
        if(id %6 == 5)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.cock2);
        if(id %6 == 0)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.dog2);
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

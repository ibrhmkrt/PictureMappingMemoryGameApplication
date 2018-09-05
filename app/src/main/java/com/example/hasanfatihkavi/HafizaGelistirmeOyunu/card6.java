package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
public class card6 extends Button {
    int id;
    boolean kartCevrilmismi= false;
    boolean cevrilebilirlik= true;
    Drawable arkaTaraf,onTaraf=null; // Grid'de ki resimler için drawable tipinde 2 tane değişken oluşturyoruz
    public card6(Context c, int id){
        super(c);  // Bu content ve id için işlem yapacağız
        this.id =id;
        setId(id);
        arkaTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.back2);
        if(id %12 == 1)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.apple2);
        if(id %12 == 2)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.pear2);
        if(id %12 == 3)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.melon2);
        if(id %12 == 4)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.watermelon2);
        if(id %12 == 5)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.kiwi2);
        if(id %12 == 6)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.peach2);
        if(id %12 == 7)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.mandarin2);
        if(id %12 == 8)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.banana2);//ahududu yerine muz
        if(id %12 == 9)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.cherry2);
        if(id %12 == 10)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.strawberry2);
        if(id %12 == 11)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.orange2);//dut yerine protakal
        if(id %12 == 0)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.grape2);
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

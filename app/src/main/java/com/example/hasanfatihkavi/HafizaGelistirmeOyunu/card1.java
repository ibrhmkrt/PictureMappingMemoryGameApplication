package com.example.hasanfatihkavi.HafizaGelistirmeOyunu;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
public class card1 extends Button {
    int id;
    boolean kartCevrilmismi= false;
    boolean cevrilebilirlik= true;
    Drawable arkaTaraf,onTaraf=null; // Grid'de ki resimler için drawable tipinde 2 tane değişken oluşturyoruz

    public card1(Context c, int id){
        super(c);  // Bu content ve id için işlem yapacağız
        this.id =id;
        setId(id);

        arkaTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.back2);
        if(id %2 == 1)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.dogru2);
        if(id %2 == 0)
            onTaraf = AppCompatDrawableManager.get().getDrawable(c,R.drawable.yanlis2);
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

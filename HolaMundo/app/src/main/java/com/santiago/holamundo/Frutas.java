package com.santiago.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Frutas extends AppCompatActivity {

    ImageView imagen,imagen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas);

        imagen = (ImageView) findViewById(R.id.fruta_1);
        imagen2 = (ImageView) findViewById(R.id.fruta_2);

        Picasso.with(getApplicationContext()).load("https://mejorconsalud.com/wp-content/uploads/2013/07/fresas.jpg").into(imagen);

        Picasso.with(getApplicationContext()).load("https://s2.hdstatic.net/gridfs/holadoctor/625x470_53696d66b937954a54bc9258_11_28-1399418830685.jpg").into(imagen2);



    }
}

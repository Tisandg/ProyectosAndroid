package com.santiago.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class picasso extends AppCompatActivity {

    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        imagen = (ImageView) findViewById(R.id.image_picasso);

        Picasso.with(this).load("https://goo.gl/JS2R4s").into(imagen);
    }
}

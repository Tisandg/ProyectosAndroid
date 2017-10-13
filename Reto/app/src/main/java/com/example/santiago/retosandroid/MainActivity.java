package com.example.santiago.retosandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_ciudadesP,btn_peliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ciudadesP = (Button) findViewById(R.id.ciudadesPais);
        btn_peliculas = (Button) findViewById(R.id.peliculas);

        btn_ciudadesP.setOnClickListener(this);
        btn_peliculas.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intento = new Intent();
        switch (view.getId()){
            case R.id.ciudadesPais:
                Intent intent = new Intent(MainActivity.this,CiudadesPais.class);
                startActivity(intent);
                break;

            case R.id.peliculas:
                intento = new Intent(MainActivity.this,Peliculas.class);
                startActivity(intento);
                break;
        }
    }
}

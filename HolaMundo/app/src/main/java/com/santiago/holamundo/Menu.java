package com.santiago.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    Button btn_animales, btn_frutas, btn_colores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_animales = (Button) findViewById(R.id.btn_animales);
        btn_animales.setOnClickListener(this);

        btn_frutas = (Button) findViewById(R.id.btn_frutas);
        btn_frutas.setOnClickListener(this);

        btn_colores = (Button) findViewById(R.id.btn_colores);
        btn_colores.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_animales:
                Intent redireccionAnimales = new Intent(Menu.this,Animales.class);
                startActivity(redireccionAnimales);
                break;
            case R.id.btn_colores:
                Intent redireccionColores = new Intent(Menu.this,Colores.class);
                startActivity(redireccionColores);
                break;
            case R.id.btn_frutas:
                Intent redireccionFrutas = new Intent(Menu.this,Frutas.class);
                startActivity(redireccionFrutas);
                break;
        }
    }
}

package com.santiago.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button btn_animales, btn_frutas, btn_colores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_animales = (Button) findViewById(R.id.btn_animales);
        btn_animales.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent redireccionAnimales = new Intent(Menu.this,Animales.class);
                    startActivity(redireccionAnimales);
                }
            }
        );

        btn_frutas = (Button) findViewById(R.id.btn_frutas);
        btn_frutas.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      Intent redireccionFrutas = new Intent(Menu.this,Frutas.class);
                      startActivity(redireccionFrutas);
                  }
            }
        );

        btn_colores = (Button) findViewById(R.id.btn_colores);
        btn_colores.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent redireccionColores = new Intent(Menu.this,Colores.class);
                   startActivity(redireccionColores);
               }
           }
        );
    }

}

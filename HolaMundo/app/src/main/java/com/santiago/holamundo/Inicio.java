package com.santiago.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button btn_aMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    /*Proceso llamado al dar click en el boton*/
    public void goToMenu(View view){
        Intent redireccionMenu = new Intent(Inicio.this,Menu.class);
        startActivity(redireccionMenu);
    }

}

package com.example.santiago.retosvistas.actividades;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.santiago.retosvistas.R;
import com.example.santiago.retosvistas.fragmentos.ArgentinaFragment;
import com.example.santiago.retosvistas.fragmentos.ChileFragment;
import com.example.santiago.retosvistas.fragmentos.ColombiaFragment;

public class CampeonatoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campeonato);

        ImageButton primero = (ImageButton) findViewById(R.id.numero1);
        primero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                if(fm.findFragmentByTag("fragment1") == null){
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.contenedor, new ChileFragment(),"fragment1");
                    ft.commit();
                }else{
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.contenedor, new ChileFragment(),"fragment1");
                    ft.commit();
                }
            }
        });

        ImageButton segundo = (ImageButton) findViewById(R.id.numero2);
        segundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                if(fm.findFragmentByTag("fragment1") != null){
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.contenedor, new ArgentinaFragment(),"fragment1");
                    ft.commit();
                }else{
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.contenedor, new ArgentinaFragment(),"fragment1");
                    ft.commit();
                }
            }
        });

        ImageButton tercero = (ImageButton) findViewById(R.id.numero3);
        tercero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                if(fm.findFragmentByTag("fragment1") != null){
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.contenedor, new ColombiaFragment(),"fragment1");
                    ft.commit();
                }else{
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.contenedor, new ColombiaFragment(),"fragment1");
                    ft.commit();
                }
            }
        });

        Button buttonLogOut = (Button) findViewById(R.id.button_log_out);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("InfoSharedPreference",MODE_APPEND);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("session",1);
                editor.commit();
                System.out.println("Redirigiendo a logIn");
                irAInicio();
            }
        });
    }

    public void irAInicio(){
        startActivity(new Intent(this, LoginActivity.class));
    }

}

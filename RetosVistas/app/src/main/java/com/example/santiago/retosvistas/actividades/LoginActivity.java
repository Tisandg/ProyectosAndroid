package com.example.santiago.retosvistas.actividades;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.santiago.retosvistas.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private TextView crearCuenta;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validarSesion();
        setContentView(R.layout.activity_login);

        this.username = (EditText) findViewById(R.id.txt_username);
        this.password = (EditText) findViewById(R.id.txt_password);
        this.crearCuenta = (TextView) findViewById(R.id.txt_crear_cuenta);
        this.buttonLogin = (Button) findViewById(R.id.button_Login);

        this.buttonLogin.setOnClickListener(this);
        this.crearCuenta.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_Login:
                SharedPreferences sp = getSharedPreferences("InfoSharedPreference",MODE_APPEND);
                SharedPreferences.Editor editor = sp.edit();
                String nombre = sp.getString("username","noUserName");
                String password = sp.getString("password","noPassword");
                int sesion = sp.getInt("session",0);
                if(sesion == 2){
                    //Ya ha iniciado sesion. Redirigir
                    System.out.println("Redirigiendo");
                    redirigirPrincipal();
                }
                if(sesion == 1){
                    //No ha iniciado sesion. Comparar datos
                    if(nombre.equals(this.username.getText().toString()) && password.equals(this.password.getText().toString())){
                        //Iniciar Sesion
                        System.out.println("Iniciando sesion");
                        editor.putInt("session",2);
                        editor.commit();
                        redirigirPrincipal();
                    }else{
                        Toast.makeText(this,"Los datos no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.txt_crear_cuenta:

                this.crearCuenta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println("Redirigiendo a crear cuenta");
                        crearCuenta();
                    }
                });
        }
    }

    public void redirigirPrincipal(){
        Intent intent = new Intent(this, CampeonatoActivity.class);
        startActivity(intent);
    }

    public void crearCuenta(){
        Intent intent = new Intent(this, SigInActivity.class);
        startActivity(intent);
    }

    public void validarSesion(){
        SharedPreferences sp = getSharedPreferences("InfoSharedPreference",MODE_APPEND);
        SharedPreferences.Editor editor = sp.edit();
        String nombre = sp.getString("username","");
        String password = sp.getString("password","");
        if(!nombre.equals("") && !password.equals("")){
            int sesion = sp.getInt("session",0);
            if(sesion == 2){
                redirigirPrincipal();
            }
            if(sesion == 0){
                Toast.makeText(this,"No hay datos registrados", Toast.LENGTH_SHORT).show();
            }

        }
    }
}

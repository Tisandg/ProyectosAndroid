package com.example.santiago.entregables;

import android.content.DialogInterface;
import android.support.annotation.MainThread;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnToastC, btnToastL, btnAlertaOk,btnAlertaOkCancelar, btnPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*"Conectando" los botones*/
        btnToastC = (Button) findViewById(R.id.toastCorto);
        btnToastL = (Button) findViewById(R.id.toastLargo);
        btnAlertaOk = (Button) findViewById(R.id.alertaOk);
        btnAlertaOkCancelar = (Button) findViewById(R.id.alertaOkCancelar);
        btnPersonalizado = (Button) findViewById(R.id.personalizado);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.toastCorto:
                Toast.makeText(getApplicationContext(),"Toast de corta duracion", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toastLargo:
                Toast.makeText(MainActivity.this,"Toast de larga duracion", Toast.LENGTH_LONG).show();
                break;
            case R.id.alertaOk:
                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setMessage("Esta seguro de realizar la accion?")
                        .setTitle("Alerta dialogo")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "A seleccionado Ok", Toast.LENGTH_SHORT).show();
                                dialogInterface.cancel();
                            }
                        });
                alerta.show();
                break;

            case R.id.alertaOkCancelar:
                AlertDialog.Builder alerta2 = new AlertDialog.Builder(MainActivity.this);
                alerta2.setMessage("Esta seguro de realizar la accion?")
                        .setTitle("Alerta dialogo")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "A seleccionado Ok", Toast.LENGTH_SHORT).show();
                                dialogInterface.cancel();
                            }
                        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "A seleccionado cancelar", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                alerta2.show();
                break;

            case R.id.personalizado:
                Toast personalizado = new Toast(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_personalizado, (ViewGroup) findViewById(R.id.lytPersonalizado));
                TextView txtMsg = (TextView)layout.findViewById(R.id.mensage);
                txtMsg.setText("Toast personalizado");

                personalizado.setDuration(Toast.LENGTH_SHORT);
                personalizado.setView(layout);
                personalizado.show();
                break;
        }
    }
}

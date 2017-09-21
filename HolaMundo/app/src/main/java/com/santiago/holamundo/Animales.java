package com.santiago.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Animales extends AppCompatActivity {

    Button btn_vaca,btn_oso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);

        btn_vaca = (Button) findViewById(R.id.btn_vaca);
        btn_vaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Animales.this, "Ha presionado la Vaca", Toast.LENGTH_SHORT).show();
            }
        });

        btn_oso = (Button) findViewById(R.id.btn_oso);
        btn_oso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Animales.this, "Ha presionado el oso", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

package com.example.santiago.retosvistas.actividades;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.santiago.retosvistas.R;

public class SigInActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText username;
    private EditText password;
    private Button buttonSigIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_in);

        this.username = (EditText) findViewById(R.id.txt_username);
        this.password = (EditText) findViewById(R.id.txt_password);
        this.buttonSigIn = (Button) findViewById(R.id.button_sig_in);

        this.buttonSigIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_sig_in:
                SharedPreferences sp = getSharedPreferences("InfoSharedPreference",MODE_APPEND);
                SharedPreferences.Editor editor = sp.edit();
                System.out.println("********************************");
                System.out.println("user: "+this.username.getText().toString()+" pass:"+this.password.getText().toString());
                System.out.println("********************************");
                editor.putString("username",this.username.getText().toString());
                editor.putString("password",this.password.getText().toString());
                editor.putInt("session",2);
                editor.commit();
                redirigirPrincipal();
                break;
        }
    }

    public void redirigirPrincipal(){
        Intent intent = new Intent(this, CampeonatoActivity.class);
        startActivity(intent);
    }
}

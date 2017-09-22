package com.example.santiago.calculadorawindows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    StringBuilder textoSalida = new StringBuilder();
    TextView pantallaSalida;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0, btnMas,btnMenos,btnMul,btnDiv,btnIgual,btnBorrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantallaSalida = (TextView) findViewById(R.id.txt_salida);

        /*Botones numeros*/
        btn1 = (Button) findViewById(R.id.button_1);
        btn2 = (Button) findViewById(R.id.button_2);
        btn3 = (Button) findViewById(R.id.button_3);
        btn4 = (Button) findViewById(R.id.button_4);
        btn5 = (Button) findViewById(R.id.button_5);
        btn6 = (Button) findViewById(R.id.button_6);
        btn7 = (Button) findViewById(R.id.button_7);
        btn8 = (Button) findViewById(R.id.button_8);
        btn9 = (Button) findViewById(R.id.button_9);
        btn0 = (Button) findViewById(R.id.button_0);

        /*Botones operaciones*/
        btnMas = (Button) findViewById(R.id.button_mas);
        btnMenos = (Button) findViewById(R.id.button_menos);
        btnMul = (Button) findViewById(R.id.button_mul);
        btnDiv = (Button) findViewById(R.id.button_div);
        btnIgual = (Button) findViewById(R.id.button_igual);
        btnBorrar = (Button) findViewById(R.id.button_borrar);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btnMas.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_0:
                textoSalida.append("0");
                break;

            case R.id.button_1:
                textoSalida.append('1');
                break;

            case R.id.button_2:
                textoSalida.append("2");
                break;

            case R.id.button_3:
                textoSalida.append("3");
                break;

            case R.id.button_4:
                textoSalida.append("4");
                break;

            case R.id.button_5:
                textoSalida.append("5");
                break;

            case R.id.button_6:
                textoSalida.append("6");
                break;

            case R.id.button_7:
                textoSalida.append("7");
                break;

            case R.id.button_8:
                textoSalida.append("8");
                break;

            case R.id.button_9:
                textoSalida.append("9");
                break;

            case R.id.button_mas:
                textoSalida.append("+");
                break;

            case R.id.button_menos:
                textoSalida.append("-");
                break;

            case R.id.button_mul:
                textoSalida.append("x");
                break;

            case R.id.button_div:
                textoSalida.append("/");
                break;

            case R.id.button_igual:
                //Toast.makeText(this, "Calculando respuesta", Toast.LENGTH_SHORT).show();
                resultado();
                break;

            case R.id.button_borrar:
                textoSalida.setLength(0);
                break;
        }
        pantallaSalida.setText(textoSalida.toString());
    }

    public void resultado(){
        /*Analizamos el strig*/
        String txtSalida= textoSalida.toString();
        int tam = txtSalida.length();
        String num1,num2;
        int i;
        float resultado = 0;
        System.out.println(txtSalida);
        for (i = 0; i<tam;i++){
            if(txtSalida.charAt(i) == '+'){
                num1 = txtSalida.substring(0,(i));
                num2 = txtSalida.substring((i+1),(tam));
                System.out.println("1:"+num1+" 2:"+num2);
                resultado = Float.parseFloat(num1) + Float.parseFloat(num2);
                break;
            }
            if(txtSalida.charAt(i) == '-'){
                num1 = txtSalida.substring(0,(i));
                num2 = txtSalida.substring((i+1),(tam));
                resultado = Float.parseFloat(num1) - Float.parseFloat(num2);
                break;
            }
            if(txtSalida.charAt(i) == 'x'){
                num1 = txtSalida.substring(0,(i));
                num2 = txtSalida.substring((i+1),(tam));
                resultado = Float.parseFloat(num1) * Float.parseFloat(num2);
                break;
            }
            if(txtSalida.charAt(i) == '/'){
                num1 = txtSalida.substring(0,(i));
                num2 = txtSalida.substring((i+1),(tam));
                resultado = Float.parseFloat(num1) / Float.parseFloat(num2);
                break;
            }
        }
        System.out.println(resultado);
        textoSalida.setLength(0);
        textoSalida.append(""+resultado);
    }
}

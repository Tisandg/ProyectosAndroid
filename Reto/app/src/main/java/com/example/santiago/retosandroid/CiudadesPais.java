package com.example.santiago.retosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class CiudadesPais extends AppCompatActivity {

    ListView listaPaises;
    Spinner listaCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudades_pais);

        listaPaises = (ListView) findViewById(R.id.listaPaises);
        listaCiudades = (Spinner) findViewById(R.id.listaCiudades);

        ArrayAdapter<String> adaptadorPaises = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.listaPaises));
        listaPaises.setAdapter(adaptadorPaises);

        /*Listeners*/
        listaPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {

                String[] arrayCiudades = new String[0];
                switch (adapter.getItemAtPosition(i).toString()){
                    case "Colombia":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesCol);
                        break;
                    case "Argentina":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesArg);
                        break;
                    case "Peru":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesPer);
                        break;
                    case "Ecuador":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesEcu);
                        break;
                    case "Venezuela":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesVen);
                        break;
                    case "Brazil":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesBra);
                        break;
                    case "Canada":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesCan);
                        break;
                    case "Chile":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesChi);
                        break;
                    case "Mexico":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesMex);
                        break;
                    case "Panama":
                        arrayCiudades = getResources().getStringArray(R.array.ciudadesPan);
                        break;

                }
                ArrayAdapter<String> adaptadorCiudades = new ArrayAdapter<String>(CiudadesPais.this, android.R.layout.simple_list_item_1,arrayCiudades);
                listaCiudades.setAdapter(adaptadorCiudades);
            }
        });

        listaCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String ciudad = adapterView.getItemAtPosition(i).toString();
                if(!ciudad.equals("Seleccione una ciudad")){
                    Toast.makeText(CiudadesPais.this,"Selecciono "+ciudad,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}

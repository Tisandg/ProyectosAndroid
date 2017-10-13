package com.example.santiago.retosandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.santiago.retosandroid.adapters.peliculaImagenAdapter;
import com.example.santiago.retosandroid.adapters.peliculasArrayAdapter;
import com.example.santiago.retosandroid.models.Pelicula;

public class Peliculas extends AppCompatActivity {

    final Pelicula[] misPeliculas={
            new Pelicula("3 Idiots", "Mejor pelicula con critica educativa","2011",
                    "http://s3.india.com/wp-content/uploads/2016/01/3-idiots-sequel-1.jpg"),
            new Pelicula("Liga de la justicia","Accion al estilo DC Comics", "2017","" +
                    "https://www.cinemascomics.com/wp-content/uploads/2017/03/liga-de-la-justicia-imagen-grupal-pagina-web.jpg"),
            new Pelicula("Toy Stories","Pelicula animada de Pixar","2005",
                    "http://wdwdailynews.com/wp-content/uploads/2014/11/Pixar-Toy-Story-Characters-600x445.jpg"),
            new Pelicula("Fragmentado","Para los que les gusta el suspenso", "2016",
                    "https://cinetvymas.cl/wp-content/uploads/2017/08/split.jpg"),
            new Pelicula("Chappie","Un robot que siente","2016",
                    "http://3.bp.blogspot.com/-fOxa8wDGGo0/VGusorG_WjI/AAAAAAAA7ws/pgDMGjeONyA/s1600/chappie.jpg")
    };
    String[] peliculas = {"3 Idiots","Liga de la justicia","Toy stories",
                            "Fragmentado","Chappie"};

    ArrayAdapter<Pelicula> miArrayAdapter;
    peliculaImagenAdapter peliculaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, peliculas);
        AutoCompleteTextView autoCompletado  = (AutoCompleteTextView) findViewById(R.id.autocompletado);
        autoCompletado.setAdapter(adapter);

       // miArrayAdapter = new ArrayAdapter<Pelicula> (this,android.R.layout.simple_list_item_1, misPeliculas);

        //peliculasArrayAdapter peliculaAdapter = new peliculasArrayAdapter(this, R.layout.item_pelicula, misPeliculas);

        peliculaImagen = new peliculaImagenAdapter(this, misPeliculas);
        ListView lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(peliculaImagen);
    }
}

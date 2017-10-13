package com.example.santiago.retosandroid.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.santiago.retosandroid.R;
import com.example.santiago.retosandroid.models.Pelicula;

import java.util.List;

/**
 * Created by Santiago on 11/10/2017.
 */
class ViewHolder{
    TextView titulo;
    TextView descripcion;
    TextView anio;
}

public class peliculasArrayAdapter extends ArrayAdapter{

    Activity actividad;
    Pelicula[] peliculas;

    public peliculasArrayAdapter(Context context, int resource, Pelicula[] peliculas){
        super(context, resource, peliculas);
        this.peliculas = peliculas;
        this.actividad = (Activity) context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View item = convertView;
        ViewHolder viewHolder;
        if (item==null){
            /*Si no existe lo creamos*/
            LayoutInflater inflador = this.actividad.getLayoutInflater();
            item = inflador.inflate(R.layout.item_pelicula, null);
            viewHolder = new ViewHolder();
            viewHolder.titulo = (TextView) item.findViewById(R.id.titulo);
            viewHolder.descripcion = (TextView) item.findViewById(R.id.descripcion);
            viewHolder.anio = (TextView) item.findViewById(R.id.anio);
            item.setTag(viewHolder);
        }else{
            /*Si ya existe se reutiliza*/
            viewHolder = (ViewHolder) item.getTag();
        }
        viewHolder.titulo.setText(peliculas[position].getTitulo());
        viewHolder.descripcion.setText(peliculas[position].getDescripcion());
        viewHolder.anio.setText(peliculas[position].getAnio());
        return item;
    }


}

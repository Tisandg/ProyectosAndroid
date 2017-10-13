package com.example.santiago.retosandroid.adapters;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.santiago.retosandroid.R;
import com.example.santiago.retosandroid.models.Pelicula;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by Santiago on 11/10/2017.
 */
class ViewHolderPelicula{
    TextView titulo;
    TextView descripcion;
    TextView anio;
    ImageView imagen;
}

public class peliculaImagenAdapter extends BaseAdapter{

    Activity actividad;
    Pelicula[] peliculas;

    public peliculaImagenAdapter(Activity actividad, Pelicula[] peliculas){
        this.actividad = actividad;
        this.peliculas = peliculas;
    }

    @Override
    public int getCount() {
        return peliculas.length;
    }

    @Override
    public Object getItem(int i) {
        return peliculas[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item = view;
        ViewHolderPelicula viewHolder;
        if (item==null){
            /*Si no existe lo creamos*/
            LayoutInflater inflador = this.actividad.getLayoutInflater();
            item = inflador.inflate(R.layout.item_pelicula, null);
            viewHolder = new ViewHolderPelicula();
            viewHolder.titulo = (TextView) item.findViewById(R.id.titulo);
            viewHolder.descripcion = (TextView) item.findViewById(R.id.descripcion);
            viewHolder.anio = (TextView) item.findViewById(R.id.anio);
            viewHolder.imagen = (ImageView) item.findViewById(R.id.imagen);
            item.setTag(viewHolder);
        }else{
            /*Si ya existe se reutiliza*/
            viewHolder = (ViewHolderPelicula) item.getTag();
        }
        viewHolder.titulo.setText(peliculas[i].getTitulo());
        viewHolder.descripcion.setText(peliculas[i].getDescripcion());
        viewHolder.anio.setText(peliculas[i].getAnio());
        Picasso.with(actividad).load(peliculas[i].getImagen()).into(viewHolder.imagen);
        return item;
    }
}

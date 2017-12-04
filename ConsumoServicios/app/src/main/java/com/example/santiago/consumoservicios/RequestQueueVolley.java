package com.example.santiago.consumoservicios;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Patron singleton para manejar la cosa de solicitudes.
 * Una solicitud a la vez
 * Created by Santiago on 29/11/2017.
 */

public class RequestQueueVolley {

    private static RequestQueueVolley instanciaRQVolley;
    private static Context contexto;
    private RequestQueue mRequestQueue;

    private RequestQueueVolley(Context context){
        this.contexto = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized RequestQueueVolley getInstance(Context context){
        if(instanciaRQVolley == null){
            instanciaRQVolley = new RequestQueueVolley(context);
        }
        return instanciaRQVolley;
    }

    public RequestQueue getRequestQueue(){
        if(mRequestQueue == null){
            //Cache de 10mb
            Cache cache = new DiskBasedCache(contexto.getCacheDir(),100*1024*1024);
            Network network = new BasicNetwork(new HurlStack());
            mRequestQueue = new RequestQueue(cache,network);
            //Se inicia la cola de solicitudes
            mRequestQueue.start();
        }
        return mRequestQueue;
    }
}

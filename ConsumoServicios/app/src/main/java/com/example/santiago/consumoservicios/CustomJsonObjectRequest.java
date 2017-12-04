package com.example.santiago.consumoservicios;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Santiago on 29/11/2017.
 */

public class CustomJsonObjectRequest extends JsonArrayRequest{

    public CustomJsonObjectRequest(int method, String url, JSONArray jsonRequest,
                                   Response.Listener<JSONArray> listener,
                                   Response.ErrorListener errorListener){
        super(method, url, jsonRequest, listener, errorListener);
    }

    /**
     * Metodo para agregar datos como el content-type, tambien tokens de
     * seguridad.
     * @return
     * @throws AuthFailureError
     */
    @Override
    public Map<String,String> getHeaders() throws AuthFailureError{
        HashMap<String,String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }

    @Override
    public RetryPolicy getRetryPolicy(){
        return super.getRetryPolicy();
    }
}

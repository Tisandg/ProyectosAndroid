package com.example.santiago.consumoservicios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class VolleyActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener{

    public static final String REQUEST_TAG = "Volley";
    private TextView mTextView;
    private ListView mListView;
    private Button mButton;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        mTextView = (TextView) findViewById(R.id.texto);
        mListView = (ListView) findViewById(R.id.lista);
        mButton = (Button) findViewById(R.id.button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQueue = RequestQueueVolley.getInstance(this.getApplicationContext()).getRequestQueue();
        //String url = "https://jsonplaceholder.typicode.com/posts";
        String url = "https://jsonplaceholder.typicode.com/photos";
        //String url = "https://jsonplaceholder.typicode.com/albums";
        //String url = "https://jsonplaceholder.typicode.com/users";
        final CustomJsonObjectRequest jsonRequest = new CustomJsonObjectRequest(Request.Method.GET,
                url, new JSONArray(), this, this);
        jsonRequest.setTag(REQUEST_TAG);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("VolleyActivity","Añadiendo peticion a la cola");
                mQueue.add(jsonRequest);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mQueue != null){
            mQueue.cancelAll(REQUEST_TAG);
        }
    }

    //Cuando ocurra un error en la respuesta
    @Override
    public void onErrorResponse(VolleyError error) {
        mTextView.setText("Error: "+error.getMessage());
        Log.d("VolleyActivity","Error en la respuesta");
    }

    @Override
    public void onResponse(JSONArray response) {

        try{
            int i = 0;
            for(i = 0; i< response.length();i++){
                mTextView.setText(mTextView.getText().toString()+"\n\n\n"+response.get(i).toString());
            }

        }catch(JSONException e){
            mTextView.setText(e.getMessage());
        }

    }


}

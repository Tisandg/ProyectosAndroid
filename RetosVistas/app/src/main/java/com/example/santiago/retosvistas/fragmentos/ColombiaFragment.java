package com.example.santiago.retosvistas.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.santiago.retosvistas.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColombiaFragment extends Fragment {


    public ColombiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_colombia, container, false);
    }

}

package com.example.andres.pf_amarillas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment4 extends Fragment implements View.OnClickListener {

    private Button but1;

    public Fragment4() {}


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);
        but1 = (Button) view.findViewById(R.id.eGps);
        but1.setOnClickListener(this);
        return view;

    }

    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.eGps:
                Intent ven;
                ven = new Intent(getContext(),MapsActivity.class);
                startActivity(ven);
                break;
        }
    }
}

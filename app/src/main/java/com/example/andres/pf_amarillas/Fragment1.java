package com.example.andres.pf_amarillas;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment1 extends Fragment implements View.OnClickListener {

    private Cursor fila;
    private EditText bq,f1_name,f1_tele,f1_celu,f1_dire;
    private Button bus;
    String name;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);


        bus = (Button) view.findViewById(R.id.bus);
        bq = (EditText) view.findViewById(R.id.bq);

        f1_name = (EditText) view.findViewById(R.id.f1_name);
        f1_tele = (EditText) view.findViewById(R.id.f1_tele);
        f1_celu = (EditText) view.findViewById(R.id.f1_celu);
        f1_dire = (EditText) view.findViewById(R.id.f1_dire);

       bus.setOnClickListener(this);

        return view;}

    public Fragment1() {}


    public void onClick(View view) {


        name = bq.getText().toString();
        int id = view.getId();

        switch (id)
        {
            case R.id.bus:

                if (name.equals(""))
                    Toast.makeText(getActivity().getApplication(), "Busqueda en Blanco", Toast.LENGTH_SHORT).show();
                else{
                    DataBaseManager manager = new DataBaseManager(getContext());
                    fila = manager.db.rawQuery("select * FROM Usuarios  where nombre='" + name + "'", null);


                    if(fila.moveToFirst()) {
                        Toast.makeText(getActivity().getApplicationContext(), "Consultando", Toast.LENGTH_SHORT).show();

                        String nombre1 = fila.getString(1);
                        f1_name.setText(nombre1);

                        String tele1 = fila.getString(4);
                        f1_tele.setText(tele1);

                        String celu1 = fila.getString(3);
                        f1_celu.setText(celu1);

                        String dire1 = fila.getString(6);
                        f1_dire.setText(dire1);

                    } else{ Toast.makeText(getActivity().getApplicationContext(), "usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();}
                    }

                break;}


                                    }
}








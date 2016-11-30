package com.example.andres.pf_amarillas;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class Fragment2 extends Fragment implements View.OnClickListener{

    private DataBaseManager manager;
    private Cursor cursor;
    private ListView lista;
    private SimpleCursorAdapter adapter;
    private ImageButton bt, bt2,bt3,bt4,bt5,bt6;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_fragment2, container, false);

        manager = new DataBaseManager(getContext());

        lista = (ListView) view.findViewById(R.id.listView);
        bt = (ImageButton) view.findViewById(R.id.imageButton_tienda);
        bt2 = (ImageButton) view.findViewById(R.id.imageButton_hotel);
        bt3 = (ImageButton) view.findViewById(R.id.imageButton_music);
        bt4 = (ImageButton) view.findViewById(R.id.imageButton_hospi);
        bt5 = (ImageButton) view.findViewById(R.id.imageButton_resta);
        bt6 = (ImageButton) view.findViewById(R.id.imageButton_otro);


        bt.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);


        String[] from = new String[]{manager.CN_NAME, manager.CN_TEL,manager.CN_EMAIL};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};

        adapter = new SimpleCursorAdapter(getContext(), android.R.layout.two_line_list_item, cursor, from, to, 0);
        lista.setAdapter(adapter);

        return view;}

    public Fragment2() {}

    public void onClick(View view) {
        int id = view.getId();

        switch (id)
        {
            case R.id.imageButton_tienda:
                Cursor c = manager.BuscarContacto("Tienda");
                adapter.changeCursor(c);
                break;
            case R.id.imageButton_hotel:
                Cursor s = manager.BuscarContacto("Hotel");
                adapter.changeCursor(s);
                break;
            case R.id.imageButton_music:
                Cursor x = manager.BuscarContacto("Music");
                adapter.changeCursor(x);
                break;
            case R.id.imageButton_hospi:
                Cursor z = manager.BuscarContacto("Medicina");
                adapter.changeCursor(z);
                break;
            case R.id.imageButton_resta:
                Cursor r = manager.BuscarContacto("Restaurante");
                adapter.changeCursor(r);
                break;
            case R.id.imageButton_otro:
                Cursor p = manager.BuscarContacto("Otros");
                adapter.changeCursor(p);
                break;
        }
    }
}
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
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;

public class Fragment3 extends Fragment implements View.OnClickListener {

    private EditText nom2,tele2,nick2,email2;

    private Button but1;

    public Fragment3() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        AppEventsLogger.activateApp(getContext());
      if (AccessToken.getCurrentAccessToken()== null){goMainActivity();}


        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);


        String nombre = getArguments().getString("nombre1");


        nom2 = (EditText) view.findViewById(R.id.nom2);
        tele2 = (EditText) view.findViewById(R.id.tele2);
        nick2 = (EditText) view.findViewById(R.id.nick2);
        email2 = (EditText) view.findViewById(R.id.email2);

        but1 = (Button) view.findViewById(R.id.Lout);
        but1.setOnClickListener(this);


        DataBaseManager manager = new DataBaseManager(getContext());
        Cursor fila = manager.db.rawQuery("select * FROM Usuarios  where nombre='" + nombre + "'", null);


        if(fila.moveToFirst()) {
            String nombre1 = fila.getString(1);
            nom2.setText(nombre1);

            String tele1 = fila.getString(4);
            tele2.setText(tele1);

            String celu1 = fila.getString(3);
            nick2.setText(celu1);

            String ema1 = fila.getString(5);
            email2.setText(ema1);}

    return view;}

    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.Lout:
                LoginManager.getInstance().logOut();
                Intent ven = new Intent(getContext(),Loggin.class);
                startActivity(ven);
                break;}}

  private void goMainActivity(){}

}

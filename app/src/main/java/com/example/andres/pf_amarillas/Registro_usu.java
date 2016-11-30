package com.example.andres.pf_amarillas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro_usu extends AppCompatActivity {

    EditText eUsuario,eNickname,eCell,eTel,eEmail,eContrasena,eRcontrasena;
    Button eAceptar,eCancelar;

    private String nombre,nickname,celular,telefono,email,contrasena, rcontrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usu);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eNickname= (EditText) findViewById(R.id.eNickname);
        eCell =(EditText) findViewById(R.id.eCell);
        eTel=(EditText) findViewById(R.id.eTel);
        eEmail = (EditText) findViewById(R.id.eEmail);
        eContrasena= (EditText) findViewById(R.id.eContrasena);
        eRcontrasena= (EditText) findViewById(R.id.eRcontrasena);


        eAceptar= (Button) findViewById (R.id.eAceptar);
        eCancelar= (Button) findViewById (R.id.eCancelar);


        eAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombre = eUsuario.getText().toString();
                nickname = eNickname.getText().toString();
                celular = eCell.getText().toString();
                telefono = eTel.getText().toString();
                email = eEmail.getText().toString();
                contrasena = eContrasena.getText().toString();
                rcontrasena = eRcontrasena.getText().toString();


                DataBaseManager manager = new DataBaseManager(Registro_usu.this);

                if(nombre.equals("") || nickname.equals("") || celular.equals("")|| telefono.equals("")||email.equals("")|| contrasena.equals("") || rcontrasena.equals("") ){
                    Toast.makeText(getApplication(),"debe digitar todos los campos",Toast.LENGTH_SHORT).show();
                }
                else {

                    manager.insertar(nombre,nickname,celular,telefono,email,null,contrasena,rcontrasena,"usuario");
                    Toast.makeText(getApplication(),"Ingresado",Toast.LENGTH_SHORT).show();}

                Intent intent = new Intent(Registro_usu.this, Loggin.class);
                startActivity(intent);

            }                      }
        );

        eCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            } } );

    }}
package com.example.andres.pf_amarillas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroEmp extends AppCompatActivity {

    EditText eUsuario,eNickname,eCell,eTel,eEmail,eDire,eContrasena,eRcontrasena,eCategoria;
    Button eAceptar,eCancelar;

    private String nombre,nickname,celular,telefono,email,direccion,contrasena, rcontrasena,categoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_emp);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eNickname= (EditText) findViewById(R.id.eNickname);
        eCell =(EditText) findViewById(R.id.eCell);
        eTel=(EditText) findViewById(R.id.eTel);
        eEmail = (EditText) findViewById(R.id.eEmail);
        eDire = (EditText) findViewById(R.id.eDire);
        eContrasena= (EditText) findViewById(R.id.eContrasena);
        eRcontrasena=(EditText) findViewById(R.id.eRcontrasena);
        eCategoria=(EditText) findViewById(R.id.eCategoria);


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
                direccion = eDire.getText().toString();
                contrasena = eContrasena.getText().toString();
                rcontrasena = eRcontrasena.getText().toString();
                categoria = eCategoria.getText().toString();


                DataBaseManager manager = new DataBaseManager(RegistroEmp.this);

                if(nombre.equals("") || nickname.equals("") || celular.equals("")|| telefono.equals("")||email.equals("")||direccion.equals("")|| contrasena.equals("") || rcontrasena.equals("") || categoria.equals("") ){
                    Toast.makeText(getApplication(),"debe digitar todos los campos",Toast.LENGTH_SHORT).show();
                }
                else {

                    manager.insertar(nombre,nickname,celular,telefono,email,direccion,contrasena,rcontrasena,categoria);
                    Toast.makeText(getApplication(),"Ingresado",Toast.LENGTH_SHORT).show();}

                Intent intent = new Intent(RegistroEmp.this, Loggin.class);
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

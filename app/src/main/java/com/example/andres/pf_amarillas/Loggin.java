package com.example.andres.pf_amarillas;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.PublicKey;

public class Loggin extends AppCompatActivity {


    EditText eNick, eContrasena;
    Button eEntrar;
    TextView bRegistro,bRegistroE;

    private Cursor fila;

    private String nombre;

    ContentValues dataBD;
    SQLiteDatabase dbContactos;

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    String nombre1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_loggin);


        if (AccessToken.getCurrentAccessToken() != null && com.facebook.Profile.getCurrentProfile() != null){

            Profile perfil = com.facebook.Profile.getCurrentProfile();
            String name = perfil.getName();
            //String name = "Andres Dorado";
            Intent ven = new Intent(Loggin.this,MainActivity.class);
            ven.putExtra("nombre1",name);
            startActivity(ven);
            finish();}


        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.loginbutton);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            public void onSuccess(LoginResult loginResult) {

                Profile perfil = com.facebook.Profile.getCurrentProfile();
                String name = perfil.getName();
                 //String name = "Andres Dorado";
                 Intent ven = new Intent(Loggin.this,MainActivity.class);

                ven.putExtra("nombre1",name);
                startActivity(ven);
                finish();}

            public void onCancel() {Toast.makeText(getApplicationContext(),"Loggin cancelado", Toast.LENGTH_LONG).show();}

            public void onError(FacebookException error) {Toast.makeText(getApplicationContext(),"Error Login", Toast.LENGTH_LONG).show();}
        });


        eNick = (EditText) findViewById(R.id.eNick);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        eEntrar = (Button) findViewById(R.id.eEntrar);

        bRegistro = (TextView) findViewById(R.id.bRegistro);
        bRegistroE = (TextView) findViewById(R.id.bRegi);
        bRegistro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Loggin.this,Registro_usu.class);
                startActivityForResult(intent, 1234);}});


        bRegistroE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Loggin.this,RegistroEmp.class);
                startActivityForResult(intent, 1234);}
        });

        eEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nick,password;

                nick = eNick.getText().toString();
                password = eContrasena.getText().toString();

                if (nick.equals("") || password.equals(""))
                    Toast.makeText(getApplication(), "debe digitar todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    DataBaseManager manager = new DataBaseManager(Loggin.this);
                    fila = manager.db.rawQuery("select * FROM Usuarios  where nickname='"+ nick +"' and contrasena='"+password+"'",null);

                    if (fila.moveToFirst()){
                        Toast.makeText(getApplicationContext(), "Ingresando", Toast.LENGTH_SHORT).show();
                        nombre1=fila.getString(1);
                        Intent ven = new Intent(Loggin.this,MainActivity.class);
                        ven.putExtra("nombre1",nombre1);
                        startActivity(ven);

                    } else {Toast.makeText(getApplicationContext(), "usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();}
                }
            }
        });

        }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);}

}





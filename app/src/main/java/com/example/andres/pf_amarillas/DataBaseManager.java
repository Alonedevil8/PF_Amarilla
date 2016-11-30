package com.example.andres.pf_amarillas;

/**
 * Created by Andres on 23/11/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class DataBaseManager {

    public static final String TABLE_NAME = "Usuarios";
    public static final String CN_ID = "_id";
    public static final String CN_NAME = "nombre";
    public static final String CN_NICK = "nickname";
    public static final String CN_CELL = "celular";
    public static final String CN_TEL = "telefono";
    public static final String CN_EMAIL = "email";
    public static final String CN_DIR = "direccion";
    public static final String CN_PASS = "contrasena";
    public static final String CN_RPASS = "rcontrasena";
    public static final String CN_CATE = "categoria";

    private Cursor fila;


    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + CN_ID + " integer primary key Autoincrement,"
            + CN_NAME + " text not null,"
            + CN_NICK + " text not null,"
            + CN_CELL + " text,"
            + CN_TEL + " text,"
            + CN_EMAIL + " text,"
            + CN_DIR + " text,"
            + CN_PASS + " text,"
            + CN_RPASS + " text,"
            + CN_CATE + " text);";


    private DbHelper helper;
    public SQLiteDatabase db;

    public DataBaseManager(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();}


    public ContentValues generarContentValues(String nombre, String nickname, String celular, String telefono, String email, String direccion, String contrasena, String rcontrasena,String categoria) {
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME, nombre);
        valores.put(CN_NICK, nickname);
        valores.put(CN_CELL, celular);
        valores.put(CN_TEL, telefono);
        valores.put(CN_EMAIL, email);
        valores.put(CN_DIR, direccion);
        valores.put(CN_PASS, contrasena);
        valores.put(CN_RPASS, rcontrasena);
        valores.put(CN_CATE,categoria );
        return valores;}

    public void insertar(String nombre, String nickname, String celular, String telefono, String email, String direccion, String contrasena, String rcontrasena,String categoria)
    { db.insert(TABLE_NAME, null, generarContentValues(nombre, nickname, celular, telefono, email, direccion, contrasena, rcontrasena,categoria)
    );}

    public void actualizar(String nombre, String nickname, String celular, String telefono, String email, String direccion, String contrasena, String rcontrasena,String categoria)
    {db.execSQL("UPDATE Usuarios SET telefono='" +telefono+"', celular='" +celular+"', direccion='"+categoria+"', categoria='"  +direccion+ "', nickname='" +nickname+ "', contrasena='" +contrasena+"', rcontrasena='" +rcontrasena+ "', correo='" +email+  "'WHERE nombre='" +nombre+ "'");}

    public void borrar(String nombre) {db.execSQL("DELETE FROM Usuarios WHERE nombre ='" + nombre + "'");}

    public Cursor BuscarContacto(String categoria){
        String [] columnas = new String[]{CN_ID,CN_NAME,CN_TEL,CN_EMAIL};
        return db.query(TABLE_NAME,columnas,CN_CATE + "=?",new String[]{categoria},null,null,null );}
}

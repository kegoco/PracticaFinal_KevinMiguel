package com.example.kevin.practicafinal_kevinmiguel;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Btn03_SQLite extends AppCompatActivity {

    private Button btnCrear, btnInsertar, btnConsultar, btnActualizar, btnEliminar;
    private EditText etCrear, etIdProducto, etTipo, etMarca, etNombre, etPrecio;
    private UsuariosSQLiteHelper usdbh;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn03__sqlite);

        btnCrear = (Button) findViewById(R.id.btnCrear);
        btnInsertar = (Button) findViewById(R.id.btnInsertar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        etCrear = (EditText) findViewById(R.id.etBaseDatos);
        etIdProducto = (EditText) findViewById(R.id.etIdProducto);
        etTipo = (EditText) findViewById(R.id.etTipo);
        etMarca = (EditText) findViewById(R.id.etMarca);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etPrecio = (EditText) findViewById(R.id.etPrecio);



        btnCrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                String dataBase = etCrear.getText().toString();
                usdbh = new UsuariosSQLiteHelper(Btn03_SQLite.this, dataBase, null, 1);
                db = usdbh.getWritableDatabase();
            }
        });

        btnInsertar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    if (!etIdProducto.getText().toString().equals("") && !etTipo.getText().toString().equals("")
                            && !etMarca.getText().toString().equals("") && !etNombre.getText().toString().equals("")
                            && !etPrecio.getText().toString().equals("")) {
                        db.execSQL("INSERT INTO PRODUCTES (idProducto, tipo, marca, nombre, preu) " +
                                "VALUES (" + etIdProducto.getText().toString() + ", '" + etTipo.getText().toString() +"', '"
                                + etMarca.getText().toString() + "', '" + etNombre.getText().toString() +"', "
                                + etPrecio.getText().toString() + ")");

                        etIdProducto.setText("");
                        etTipo.setText("");
                        etMarca.setText("");
                        etNombre.setText("");
                        etPrecio.setText("");
                    }
                } catch (Exception e) {

                }
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    Cursor cu = db.rawQuery(" SELECT idProducto,tipo,marca,nombre,preu FROM PRODUCTES WHERE idProducto=" + etIdProducto.getText().toString(), null);
                    if (cu.moveToFirst()) {
                        //Recorremos el cursor hasta que no haya más registros
                        do {
                            String idProducto= cu.getString(0);
                            String tipo = cu.getString(1);
                            String marca = cu.getString(2);
                            String nombre = cu.getString(3);
                            String precio = cu.getString(4);

                            etIdProducto.setText(idProducto);
                            etTipo.setText(tipo);
                            etMarca.setText(marca);
                            etNombre.setText(nombre);
                            etPrecio.setText(precio);
                        } while(cu.moveToNext());
                    } else {
                        etIdProducto.setText("");
                        etTipo.setText("");
                        etMarca.setText("");
                        etNombre.setText("");
                        etPrecio.setText("");
                    }
                } catch (Exception e) {

                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    if (!etIdProducto.getText().toString().equals("") && !etTipo.getText().toString().equals("")
                            && !etMarca.getText().toString().equals("") && !etNombre.getText().toString().equals("")
                            && !etPrecio.getText().toString().equals("")) {
                        ContentValues valores = new ContentValues();
                        valores.put("tipo", etTipo.getText().toString());
                        valores.put("marca", etMarca.getText().toString());
                        valores.put("nombre", etNombre.getText().toString());
                        valores.put("preu", etPrecio.getText().toString());

                        db.update("PRODUCTES", valores, "idProducto=" + etIdProducto.getText().toString(), null);
                        etIdProducto.setText("");
                        etTipo.setText("");
                        etMarca.setText("");
                        etNombre.setText("");
                        etPrecio.setText("");
                    }
                } catch (Exception e) {

                }

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                try {
                    if (!etIdProducto.getText().toString().equals("")) {
                        db.delete("PRODUCTES", "idProducto=" + etIdProducto.getText().toString(), null);
                        etIdProducto.setText("");
                        etTipo.setText("");
                        etMarca.setText("");
                        etNombre.setText("");
                        etPrecio.setText("");
                    }
                } catch (Exception e) {

                }

            }
        });
    }


}

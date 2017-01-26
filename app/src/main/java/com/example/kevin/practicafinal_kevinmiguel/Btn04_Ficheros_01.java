package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Btn04_Ficheros_01 extends AppCompatActivity {

    private String opcBoton;
    private EditText etNombre, etTexto;
    private TextView tvResultado, tvRuta;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn04__ficheros_01);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etTexto = (EditText) findViewById(R.id.etTexto);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        tvRuta = (TextView) findViewById(R.id.tvRuta);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        Bundle bundle = getIntent().getExtras();
        opcBoton= bundle.getString("VALOR");

        btnGuardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                if (opcBoton.equals("1")) {
                    try
                    {
                        File ruta_sd = getExternalFilesDir(Environment.DIRECTORY_MUSIC);

                        File f = new File(ruta_sd.getAbsolutePath(), etNombre.getText().toString() + ".txt");

                        OutputStreamWriter fout =
                                new OutputStreamWriter(
                                        new FileOutputStream(f));

                        fout.write(etTexto.getText().toString());
                        fout.close();
                        tvResultado.setText("Todo ha ido OK");
                        tvRuta.setText(ruta_sd.getAbsolutePath());
                    }
                    catch (Exception ex)
                    {
                        tvResultado.setText("Todo ha ido MAL");
                        tvRuta.setText("");
                    }
                } else {
                    try
                    {
                        OutputStreamWriter fout=
                                new OutputStreamWriter(
                                        openFileOutput(etNombre.getText().toString() + ".txt", Context.MODE_PRIVATE));

                        fout.write(etTexto.getText().toString());
                        fout.close();
                        tvResultado.setText("Todo ha ido OK");
                    }
                    catch (Exception ex)
                    {
                        tvResultado.setText("Todo ha ido MAL");
                        tvRuta.setText("");
                    }
                }

            }
        });
    }
}

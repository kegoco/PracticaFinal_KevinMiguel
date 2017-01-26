package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Btn01_Intent extends AppCompatActivity {

    private EditText numTelefono;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn01__intent);

        numTelefono = (EditText) findViewById(R.id.etTelefono);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Btn01_Intent.this, Btn01_Intent_Resultado.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("TELEFONO", numTelefono.getText().toString());

                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}

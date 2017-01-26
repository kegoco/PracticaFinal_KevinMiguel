package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Btn01_Intent_Resultado extends AppCompatActivity {

    private TextView visualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn01__intent__resultado);

        visualizar = (TextView) findViewById(R.id.tvMostrar);

        Bundle bundle = this.getIntent().getExtras();

        visualizar.setText("Telèfon introduït: " + bundle.getString("TELEFONO"));
    }
}

package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Btn04_Ficheros extends AppCompatActivity {

    private Button btnMemInterna, btnMemExterna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn04__ficheros);

        btnMemInterna = (Button) findViewById(R.id.btnMemInterna);
        btnMemExterna = (Button) findViewById(R.id.btnMemExterna);

        btnMemInterna.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(Btn04_Ficheros.this, Btn04_Ficheros_01.class);
                Bundle bundle = new Bundle();
                bundle.putString("VALOR", "0");
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        btnMemExterna.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(Btn04_Ficheros.this, Btn04_Ficheros_01.class);
                Bundle bundle = new Bundle();
                bundle.putString("VALOR", "1");
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}

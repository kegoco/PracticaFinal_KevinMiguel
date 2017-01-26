package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = (Button) findViewById(R.id.btn01);
        btn02 = (Button) findViewById(R.id.btn02);
        btn03 = (Button) findViewById(R.id.btn03);
        btn04 = (Button) findViewById(R.id.btn04);
        btn05 = (Button) findViewById(R.id.btn05);
        btn06 = (Button) findViewById(R.id.btn06);
        btn07 = (Button) findViewById(R.id.btn07);
        btn08 = (Button) findViewById(R.id.btn08);

        btn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn01_Intent.class);
                startActivity(i);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn02_SharedPreferences.class);
                startActivity(i);
            }
        });

        btn03.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn03_SQLite.class);
                startActivity(i);
            }
        });

        btn04.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn04_Ficheros.class);
                startActivity(i);
            }
        });

        btn05.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn05_StartActivityForResult.class);
                startActivity(i);
            }
        });

        btn06.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn06_ContentProvider.class);
                startActivity(i);
            }
        });

        btn07.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn07_BroadcastReceiver.class);
                startActivity(i);
            }
        });

        btn08.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(MainActivity.this, Btn08_Missatgeria.class);
                startActivity(i);
            }
        });
    }
}

package com.example.kevin.practicafinal_kevinmiguel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Btn08_Missatgeria extends AppCompatActivity {

    private EditText etTelefono;
    private EditText etTexto;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn08__missatgeria);

        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etTexto = (EditText) findViewById(R.id.etTexto);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);



        btnEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SmsManager sms = SmsManager.getDefault();
                String numTelefono = etTelefono.getText().toString();
                String missatge = etTexto.getText().toString();

                sms.sendTextMessage(numTelefono, null, missatge, null, null);
            }
        });
    }
}

//15555215554
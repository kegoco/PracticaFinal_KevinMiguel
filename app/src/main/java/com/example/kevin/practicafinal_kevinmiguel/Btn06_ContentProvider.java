package com.example.kevin.practicafinal_kevinmiguel;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Btn06_ContentProvider extends AppCompatActivity {

    private TextView tvLlamadas;
    private Button btnLlamadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn06__content_provider);

        tvLlamadas = (TextView) findViewById(R.id.tvLlamadas);
        btnLlamadas = (Button) findViewById(R.id.btnLlamadas);

        //tvLlamadas.setText("A\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\n" +
        //        "A\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nA\nB\n");

        btnLlamadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri llamadasUri = CallLog.Calls.CONTENT_URI;
                ContentResolver cr = getContentResolver();  //De la clase "Context"

                String[] projection = new String[]{
                        CallLog.Calls.TYPE,
                        CallLog.Calls.NUMBER,
                        CallLog.Calls.CACHED_NAME,
                        CallLog.Calls.DURATION
                };
                if (ActivityCompat.checkSelfPermission(Btn06_ContentProvider.this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Cursor cur = cr.query(llamadasUri, projection, null, null, null);

                if (cur.moveToFirst()) {
                    int tipo;
                    String tipoLlamada = "";
                    String telefono;

                    int colTipo = cur.getColumnIndex(CallLog.Calls.TYPE);
                    int colTelefono = cur.getColumnIndex(CallLog.Calls.NUMBER);

                    tvLlamadas.setText("");

                    do {
                        tipo = cur.getInt(colTipo);
                        telefono = cur.getString(colTelefono);

                        if (tipo == CallLog.Calls.INCOMING_TYPE)
                            tipoLlamada = "ENTRADA";
                        else if (tipo == CallLog.Calls.OUTGOING_TYPE)
                            tipoLlamada = "SALIDA";
                        else if (tipo == CallLog.Calls.MISSED_TYPE)
                            tipoLlamada = "PERDIDA";

                        tvLlamadas.append(tipoLlamada + " - " + telefono + "\n"); //El "append" es para ir añadiento texto.
                    } while(cur.moveToNext());
                }
            }
        });
    }
}

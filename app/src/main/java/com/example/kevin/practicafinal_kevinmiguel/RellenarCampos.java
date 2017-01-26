package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RellenarCampos extends AppCompatActivity {

    private Button btnAceptar, btnCancelar;
    // Declaramos el EditText para recoger el resultado.
    private EditText etResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rellenar_campos);

        // Enlazamos las variables con los componentes que tenemos en el XML
        btnAceptar = (Button)findViewById(R.id.btnAceptar);
        btnCancelar = (Button)findViewById(R.id.btnCancelar);
        etResultado = (EditText)findViewById(R.id.etResultado);

        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Si el EditText no está vacío recogemos el resultado.
                if(etResultado.getText().length()!=0) {
                    // Guardamos el texto del EditText en un String.
                    String resultado = etResultado.getText().toString();
                    // Recogemos el intent que ha llamado a esta actividad.
                    Intent i = getIntent();
                    // Le metemos el resultado que queremos mandar a la
                    // actividad principal.
                    i.putExtra("RESULTADO", resultado);
                    // Establecemos el resultado, y volvemos a la actividad
                    // principal. La variable que introducimos en primer lugar
                    // "RESULT_OK" es de la propia actividad, no tenemos que
                    // declararla nosotros.
                    setResult(RESULT_OK, i);

                    // Finalizamos la Activity para volver a la anterior
                    finish();
                } else {
                    // Si no tenía nada escrito el EditText lo avisamos.
                    Toast.makeText(RellenarCampos.this, ""
                            /*&quot;No se ha introducido nada en el campo de texto&quot;*/,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Definimos el listener que ejecutará el método onClick del botón cancelar.
        btnCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Si se pulsa el botón, establecemos el resultado como cancelado.
                // Al igual que con "RESULT_OK", esta variable es de la activity.
                setResult(RESULT_CANCELED);

                // Finalizamos la Activity para volver a la anterior
                finish();
            }
        });
    }
}

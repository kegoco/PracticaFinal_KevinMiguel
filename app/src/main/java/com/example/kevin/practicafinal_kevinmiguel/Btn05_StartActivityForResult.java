package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Btn05_StartActivityForResult extends AppCompatActivity {

    private final static int MARCA = 0;
    private final static int TIPO = 1;

    private EditText etMarca, etTipo;
    private Button btnMarca, btnTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn05__start_for_result);

        etMarca = (EditText) findViewById(R.id.etMarca);
        etTipo = (EditText) findViewById(R.id.etTipo);
        btnMarca = (Button) findViewById(R.id.btnMarca);
        btnTipo = (Button) findViewById(R.id.btnTipo);

        btnMarca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(Btn05_StartActivityForResult.this, RellenarCampos.class);
                // Iniciamos la segunda actividad, y le indicamos que la iniciamos
                // para rellenar el nombre:
                startActivityForResult(i, MARCA);
            }
        });

        btnTipo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent i = new Intent(Btn05_StartActivityForResult.this, RellenarCampos.class);
                // Iniciamos la segunda actividad, y le indicamos que la iniciamos
                // para rellenar el nombre:
                startActivityForResult(i, TIPO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Comprobamos si el resultado de la segunda actividad es "RESULT_CANCELED".
        if (resultCode == RESULT_CANCELED) {
            // Si es así mostramos mensaje de cancelado por pantalla.
            Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_SHORT)
                    .show();
        } else {
            // De lo contrario, recogemos el resultado de la segunda actividad.
            String resultado = data.getExtras().getString("RESULTADO");
            // Y tratamos el resultado en función de si se lanzó para rellenar el
            // nombre o el apellido.
            switch (requestCode) {
                case MARCA:
                    etMarca.setText(resultado);
                    break;
                case TIPO:
                    etTipo.setText(resultado);
                    break;
            }
        }
    }
}

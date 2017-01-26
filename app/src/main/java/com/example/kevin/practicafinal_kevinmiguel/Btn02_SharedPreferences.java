package com.example.kevin.practicafinal_kevinmiguel;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Btn02_SharedPreferences extends AppCompatActivity {

    boolean hayPunto = false;
    String punto = ",";
    String pantalla = "";
    String pantalla2 = "";
    double v0 = 0;
    double v1 = 0;
    double mem = 0;
    String memVar = "Mem: 0.0";
    String temp = "";
    int operacion = 0;
    int op = 0;
    int opsig = 0;
    boolean resultado = false;
    boolean masMenos = true;
    DecimalFormat decimales = new DecimalFormat("0.00");

    EditText texto;
    TextView log;
    TextView memoria;
    Button boton;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn02__shared_preferences);

        texto = (EditText) findViewById(R.id.etResultado);
        log = (TextView) findViewById(R.id.tvLog);

        prefs = getSharedPreferences("ResulCalc", Context.MODE_PRIVATE);
        editor = prefs.edit();
        pantalla = prefs.getString("resultado", null);
        muestra(pantalla, pantalla2, memVar);
    }

    public double queDouble(String s) {
        String ss = s.replace(punto.charAt(0), '.');
        double res = Double.parseDouble(ss);
        return res;
    }

    double opera(double a, double b, int op) {
        double res = b;
        temp = "";
        //vigilar con la división entre 0. Se puede poner una variable para indicar los errores
        if (a != 0) {
            switch (op) { //aprovechamos la referencia al botón para especificar que operación haremos
                case R.id.btnSuma:
                    res = a + b;
                    break;
                case R.id.btnResta:
                    res = a - b;
                    break;
                case R.id.btnMulti:
                    res = a * b;
                    break;
                case R.id.btnDivi:
                    if (b != 0) {
                        res = a / b;
                    }
                    else {
                        res = 0;
                    }
                    break;
                case R.id.btnPorcentaje:
                    res = a;
                    break;
            }
        }
        else {
            switch (op) { //aprovechamos la referencia al botón para especificar que operación haremos
                case R.id.btnSuma:
                    res = a + b;
                    break;
                case R.id.btnResta:
                    res = a - b;
                    break;
                case R.id.btnMulti:
                    res = b;
                    break;
                case R.id.btnDivi:
                    if (a != 0) {
                        res = a / b;
                    }
                    else {
                        if (v0 != 0) {
                            res = 0;
                        }
                        else {
                            res = b;
                        }
                    }
                    break;
                case R.id.btnPorcentaje:
                    res = a;
                    break;
            }
        }
        return res;
    }

    void muestra(String s, String x, String y) {
        texto.setText(s);
        log.setText(x);
    }

    public void segundaPantalla () {
        if (resultado == true) {
            //pantalla2 = texto.getText().toString();
            resultado = false;
        }
    }

    public void clickBoton(View v) {
        //pantalla = pantalla + boton.getText();
        //texto.setText(pantalla);

        int n;
        Button b = (Button) v;
        switch (b.getId()) {
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                n = Integer.parseInt(b.getText().toString());
                pantalla = pantalla + n;
                temp = temp + n;
                //pantalla2 = pantalla2 + n;
                muestra(pantalla, pantalla2, memVar);
                break;
            case R.id.btnPunto: //pulsado punto
                if ((hayPunto == false) && (texto.getText().toString() != "")) {
                    pantalla = pantalla + punto;
                    hayPunto = true;
                    //pantalla2 = pantalla2 + punto;
                    temp = temp + punto;
                    muestra(pantalla, pantalla2, memVar);
                }
                break;
            case R.id.btnSuma:
                if (!texto.getText().toString().equals("")) {
                    segundaPantalla();
                    hayPunto = false;

                    v1 = queDouble(pantalla);
                    v0 = opera(v0, v1, opsig);
                    opsig = b.getId();
                    //muestra(String.valueOf(v0));
                    if (masMenos == false) {
                        pantalla2 = pantalla2 + "(" + pantalla + ")" + " + ";
                    }
                    else {
                        pantalla2 = pantalla2 + pantalla + " + ";
                    }
                    masMenos = true;
                    pantalla = "";
                    op = opsig;
                    muestra(pantalla, pantalla2, memVar);
                }
                break;
            case R.id.btnDivi:
                if (!texto.getText().toString().equals("")) {
                    segundaPantalla();
                    hayPunto = false;

                    v1 = queDouble(pantalla);
                    v0 = opera(v0, v1, opsig);
                    opsig = b.getId();
                    //muestra(String.valueOf(v0));
                    if (masMenos == false) {
                        pantalla2 = pantalla2 + "(" + pantalla + ")" + " ÷ ";
                    }
                    else {
                        pantalla2 = pantalla2 + pantalla + " ÷ ";
                    }
                    masMenos = true;
                    pantalla = "";
                    op = opsig;
                    muestra(pantalla, pantalla2, memVar);
                }
                break;
            case R.id.btnResta:
                if (!texto.getText().toString().equals("")) {
                    segundaPantalla();
                    hayPunto = false;

                    v1 = queDouble(pantalla);
                    v0 = opera(v0, v1, opsig);
                    opsig = b.getId();
                    //muestra(String.valueOf(v0));
                    if (masMenos == false) {
                        pantalla2 = pantalla2 + "(" + pantalla + ")" + " - ";
                    }
                    else {
                        pantalla2 = pantalla2 + pantalla + " - ";
                    }
                    masMenos = true;
                    pantalla = "";
                    op = opsig;
                    muestra(pantalla, pantalla2, memVar);
                }
                break;
            case R.id.btnMulti:
                if (!texto.getText().toString().equals("")) {
                    segundaPantalla();
                    hayPunto = false;

                    v1 = queDouble(pantalla);
                    v0 = opera(v0, v1, opsig);
                    opsig = b.getId();
                    //muestra(String.valueOf(v0));
                    if (masMenos == false) {
                        pantalla2 = pantalla2 + "(" + pantalla + ")" + " × ";
                    }
                    else {
                        pantalla2 = pantalla2 + pantalla + " × ";
                    }
                    masMenos = true;
                    pantalla = "";
                    op = opsig;
                    muestra(pantalla, pantalla2, memVar);
                }
                break;
            case R.id.btnIgual:
                resultado = true;
                if ((op != 0) && (!texto.getText().toString().equals("")) || opsig == R.id.btnPorcentaje) {
                    hayPunto = true;
                    if (opsig != R.id.btnPorcentaje) {
                        v1 = queDouble(pantalla);
                        v0 = opera(v0, v1, op);
                    }
                    if (masMenos == false) {
                        pantalla2 = pantalla2 + "(" + pantalla + ")" + " = " + (decimales.format(v0));
                    }
                    else {
                        pantalla2 = pantalla2 + pantalla + " = " + (decimales.format(v0));
                    }
                    masMenos = true;
                    //pantalla2 = pantalla2 + pantalla  + " = " + (decimales.format(v0));
                    pantalla = String.valueOf(decimales.format(v0));
                    muestra(pantalla, pantalla2, memVar);
                    pantalla2 = "";
                    temp = "" + v0;
                    opsig = -1;
                }
                v0 = 0;
                op = 0;
                break;
            case R.id.btnPorcentaje:
                if (!texto.getText().toString().equals("")) {
                    segundaPantalla();
                    hayPunto = false;

                    v1 = queDouble(pantalla);
                    if (masMenos == false) {
                        pantalla2 = pantalla2 + "(" + pantalla + ")" + " % ";
                    }
                    else {
                        pantalla2 = pantalla2 + pantalla + " % ";
                    }
                    v1 = (v0 * v1) / 100;
                    v0 = opera(v0, v1, opsig);
                    //opsig = b.getId();
                    //muestra(String.valueOf(v0));
                    /*if (masMenos == false) {
                        pantalla2 = pantalla2 + "(" + pantalla + ")" + " × ";
                    }
                    else {
                        pantalla2 = pantalla2 + pantalla + " × ";
                    }*/
                    masMenos = true;
                    pantalla = "";
                    opsig = b.getId();
                    op = opsig;
                    muestra(pantalla, pantalla2, memVar);
                }
                break;
            /*case R.id.btnMC:
                mem = 0;
                memVar = "Mem: " + mem;
                muestra(pantalla, pantalla2, memVar);
                break;
            case R.id.btnMR:
                pantalla = "" + mem;
                temp = ""+ mem;
                muestra(pantalla, pantalla2, memVar);
                break;
            case R.id.btnMmas:
                if (texto.getText().toString() != "") {
                    mem += queDouble(pantalla);
                    memVar = "Mem: " + mem;
                    muestra(pantalla, pantalla2, memVar);
                }
                break;
            case R.id.btnMmenos:
                if (texto.getText().toString() != "") {
                    mem -= queDouble(pantalla);
                    memVar = "Mem: " + mem;
                    muestra(pantalla, pantalla2, memVar);
                }
                break;*/
            case R.id.btnMasMenos:
                if (masMenos == true) {
                    pantalla = "-" + temp;
                    //pantalla2 = pantalla2 + "-" + pantalla;
                    muestra(pantalla, pantalla2, memVar);
                    masMenos = false;
                }
                else {
                    pantalla = "" + temp;
                    //pantalla2 = pantalla2 + "";
                    muestra(pantalla, pantalla2, memVar);
                    masMenos = true;
                }
                break;
            case R.id.btnClear:
                pantalla = "";
                pantalla2 = "";
                temp = "";
                resultado = false;
                hayPunto = false;
                masMenos = true;
                v0 = 0;
                v1 = 0;
                opsig = 0;
                op = 0;
                muestra(pantalla, pantalla2, memVar);
                break;
            case R.id.btnGuardar:

                editor.putString("resultado", pantalla);
                editor.commit();
                break;

        }
        //muestra(pantalla, pantalla2);
        //pantalla = pantalla + n;
        //texto.setText(pantalla);
        //muestra(pantalla, pantalla2);
    }
}

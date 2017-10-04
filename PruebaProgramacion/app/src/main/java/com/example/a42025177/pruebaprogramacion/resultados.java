package com.example.a42025177.pruebaprogramacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView textView = (TextView)findViewById(R.id.resultados);
        int proceso = getIntent().getExtras().getInt("cantproceso");
        int iguales = getIntent().getExtras().getInt("cantiguales");
        int cantcheck = getIntent().getExtras().getInt("cantcheck");
        int canterrores = getIntent().getExtras().getInt("canterrores");
        int mascorta = getIntent().getExtras().getInt("palabramascorta");
        int cantL = getIntent().getExtras().getInt("cantL");

        textView.setText("Se hicieron: " + proceso + " procesos" + "\n"
                +"Se ingresaron " + iguales + " palabras iguales" + "\n"
                + "Se tildó el checkbox " + cantcheck + " veces" +"\n"
                +"La palabra mas corta tenía " + mascorta + " letras" +"\n"
                + "Se detectó que alguno de los 2 textos tenía la letra L " + cantL + " veces" + "\n"
                + "Se denegó el proceso " + canterrores + " veces");
    }

}

package com.example.a42025177.pruebaprogramacion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int cantproceso= 0;
    int canterrores = 0;
    int cantcheck = 0;
    int cantiguales = 0;
    int palabramascorta = 999999;
    int cantL = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Procesar (View vista)
    {
        EditText editText = (EditText)findViewById(R.id.txt1);
        EditText editText2 = (EditText)findViewById(R.id.txt2);
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkbox);
        TextView textView = (TextView)findViewById(R.id.label);
        String Texto1 = editText.getText().toString();
        String Texto2 = editText2.getText().toString();
    if (Texto1.length()> 0 && Texto2.length()>0)
    {
        cantproceso++;
        if (Texto1.toLowerCase().contains("l") || Texto2.toLowerCase().contains("l"))
        {
            cantL++;
        }
        if (checkBox.isChecked())
        {
            cantcheck++;
        }
        else
        {
            if (Texto1.length() < Texto2.length() && Texto1.length()<palabramascorta)
            {
                palabramascorta = Texto1.length();
            }
            else if (Texto2.length() < Texto1.length() && Texto2.length()< palabramascorta)
            {
                palabramascorta = Texto2.length();
            }
            else if (Texto1.length() == Texto2.length() && Texto1.length()==palabramascorta)
            {
                palabramascorta = Texto1.length();
            }

        }
        if (Texto1.equals(Texto2))
        {
            cantiguales++;
        }
        /*
        si lo quisiera hacer para que solo detecte cuando solo esta escrito fin
        habria que hacer esto
        if(Texto1.trim.toLowerCase().equals("fin") || Texto2.trim.toLowerCase().equals("fin"))
        */
        if (Texto1.toLowerCase().contains("fin") || Texto2.toLowerCase().contains("fin")) // lo hice asumiendo que siempre que aparezca fin en alguna parte de alguno de los textos termine
        {
            Intent intent = new Intent(this,resultados.class);
            Bundle extras = new Bundle();
            extras.putInt("cantcheck" ,cantcheck);
            extras.putInt("cantproceso" , cantproceso);
            extras.putInt("cantiguales" , cantiguales);
            extras.putInt("palabramascorta" , palabramascorta);
            extras.putInt("canterrores", canterrores);
            extras.putInt("cantL", cantL);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
    else
    {
        canterrores++;
        textView.setText("Debe ingresar texto en ambos renglones");
        textView.setTextColor(Color.RED);
        if (Texto1.length()== 0)
        {
            editText.setError("Debe ingresar texto");
        }
        else if (Texto2.length() == 0)
        {
            editText2.setError("Debe Ingresar texto");
        }
        else if (Texto1.length() == 0 && Texto2.length() == 0)
        {
            editText.setError("Debe ingresar texto");
            editText2.setError("Debe Ingresar texto");
        }
    }

}
}

package com.kevinmcr.operacionesmovil;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private EditText n1,n2;
    private TextView res;
    private Resources recursos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        n1 = findViewById(R.id.txtNumeroUno);
        n2 = findViewById(R.id.txtNumeroDos);
        res = findViewById(R.id.lblResultado);
        recursos = this.getResources();
    }



    public void calcular(View v){
        double num1, num2, resultado;

        if(n1.getText().toString().isEmpty()){
            n1.requestFocus();
            n1.setError(recursos.getString(R.string.error_numero_uno_vacio));
        }else if(n2.getText().toString().isEmpty()){
            n2.requestFocus();
            n2.setError(recursos.getString(R.string.error_numero_dos_vacio));
        }else{
            num1 =  Double.parseDouble(n1.getText().toString());
            num2 =  Double.parseDouble(n2.getText().toString());

            resultado = Methods.add(num1,num2);
            res.setText("" + resultado);
        }

    }

    public void limpiar(View v){
        res.setText("");
        n1.setText("");
        n2.setText("");
        n1.requestFocus();
    }
}

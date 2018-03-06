package com.kevinmcr.operacionesmovil;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private EditText n1,n2;
    private Button botonOperacion;
    private TextView res;
    private Resources recursos;
    private Spinner operaciones;
    private String op[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        n1 = findViewById(R.id.txtNumeroUno);
        n2 = findViewById(R.id.txtNumeroDos);

        res = findViewById(R.id.lblResultado);
        operaciones = findViewById(R.id.cmbOperacion);
        recursos = this.getResources();
        op = recursos.getStringArray(R.array.operaciones);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,op);
        operaciones.setAdapter(adapter);
        botonOperacion = findViewById(R.id.btnOperacion);

        operaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        botonOperacion.setText(recursos.getString(R.string.sumar));
                        break;
                    case 1:
                        botonOperacion.setText(recursos.getString(R.string.restar));
                        break;
                    case 2:
                        botonOperacion.setText(recursos.getString(R.string.multiplicar));
                        break;
                    case 3:
                        botonOperacion.setText(recursos.getString(R.string.dividir));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public boolean validar(){
        int opcion = operaciones.getSelectedItemPosition();

        if(n1.getText().toString().isEmpty()){
            n1.requestFocus();
            n1.setError(recursos.getString(R.string.error_numero_uno_vacio));
            return false;
        }

        if(n2.getText().toString().isEmpty()){
            n2.requestFocus();
            n2.setError(recursos.getString(R.string.error_numero_dos_vacio));
            return false;
        }

        if(opcion == 3 && Double.parseDouble(n2.getText().toString()) == 0){
            n2.requestFocus();
            n2.setError(recursos.getString(R.string.error_division_por_cero));
            return false;
        }

        return true;
    }

    public void calcular(View v){
        double num1, num2, resultado = 0;
        int opcion;

        res.setText("");
        if(validar()){
            opcion = operaciones.getSelectedItemPosition();
            num1 =  Double.parseDouble(n1.getText().toString());
            num2 =  Double.parseDouble(n2.getText().toString());

            switch(opcion){
                case 0:
                    resultado = Methods.sumar(num1,num2);
                break;

                case 1:
                    resultado = Methods.restar(num1,num2);
                break;

                case 2:
                    resultado = Methods.multiplicar(num1,num2);
                break;

                case 3:
                    resultado = Methods.dividir(num1,num2);
                break;
            }

            res.setText("" +String.format("%.2f",resultado));
        }


    }

    public void limpiar(View v){
        res.setText("");
        n1.setText("");
        n2.setText("");
        operaciones.setSelection(0);
        n1.requestFocus();
    }
}

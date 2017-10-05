package com.example.a2dam.activitat1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity2 extends AppCompatActivity{
    private EditText et_edad;
    TextView benv;
    private Button botonAceptar;
    private Button botonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        botonAceptar = (Button) findViewById(R.id.boton_edad);
        et_edad = (EditText) findViewById(R.id.editText_edad);
        benv = (TextView) findViewById( R.id.bienvenida );
        botonCancelar =(Button) findViewById(R.id.boton_cancelar);


        Intent i=getIntent();
        Bundle extras =i.getExtras();
        if (extras != null) {
            String datoNombre=(String)extras.get("nombre");

            benv.setText("Hola "+datoNombre+" indica tu edad");
        };


        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent();
                String ediEdad = et_edad.getText().toString();
                data.setData(Uri.parse(ediEdad));
                setResult(RESULT_OK, data);

                finish();

            }});

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_CANCELED);
                finish();

            }});




    }


}

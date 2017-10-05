package com.example.a2dam.activitat1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity implements View.OnClickListener {
    private EditText et_nombre;
    private Button boton_info;
    TextView textEdad;
    int ActivityEdad = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton_info = (Button) findViewById(R.id.boton_info);
        et_nombre = (EditText) findViewById(R.id.editText_nombre);
        textEdad = (TextView) findViewById(R.id.textEdad);


        boton_info.setOnClickListener(this);
        }


        public void onClick(View v) {


           Intent i = new Intent(this,Activity2.class);
            String ediNombre=et_nombre.getText().toString();
            i.putExtra("nombre",ediNombre);

            startActivityForResult(i, ActivityEdad);
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            // TODO Auto-generated method stub
            if ((requestCode == ActivityEdad) && (resultCode == RESULT_OK)) {
                int numero=Integer.parseInt(data.getDataString());
                if (numero<18)
                    textEdad.setText("Tienes "+data.getDataString()+ " años, aun eres menor de edad");
                if (numero>18 && numero<25)
                textEdad.setText("Tienes "+data.getDataString()+ " años, ya eres mayor de edad");
                if (numero>25 && numero<35)
                    textEdad.setText("Tienes "+data.getDataString()+ " años, estás en la flor de la vida");
                if (numero>35)
                    textEdad.setText("Tienes "+data.getDataString()+ " años, ay ay ay");

            }else {Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();}}


    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButtonHombre:
                if (checked)

                    break;
            case R.id.radioButtonMujer:
                if (checked)

                    break;

        }
    }

}


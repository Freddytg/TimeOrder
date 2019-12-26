package com.example.timeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class FechaActivity extends AppCompatActivity {

    private TextView txtFecha;
    private EditText editFechain;
    private Button btnCancelarFecha;
    private Button btnOkFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha);

        this.txtFecha = (TextView) findViewById(R.id.txtFecha);
        this.editFechain = (EditText) findViewById(R.id.editFechain);
        this.btnCancelarFecha = (Button) findViewById(R.id.btnCancelarFecha);
        this.btnOkFecha = (Button) findViewById(R.id.btnOkFecha);


        btnOkFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(FechaActivity.this, IngresoActivity.class);

                startActivity(intento);
            }
        });

        btnCancelarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(FechaActivity.this, MainActivity.class);


                startActivity(intento);
            }
        });
    }
}

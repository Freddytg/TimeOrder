package com.example.timeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class FechaEditActivity extends AppCompatActivity {

    private TextView txtFecha;
    private Date dateFecha;
    private Button btnCancelarFecha;
    private Button btnOkFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_edit);

        this.txtFecha = (TextView) findViewById(R.id.txtFecha);
        this.btnCancelarFecha = (Button) findViewById(R.id.btnCancelarFecha);
        this.btnOkFecha = (Button) findViewById(R.id.btnOkFecha);

        btnOkFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(FechaEditActivity.this, EditarActivity.class);

                startActivity(intento);
            }
        });

        btnCancelarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(FechaEditActivity.this, DetalleActivity.class);


                startActivity(intento);
            }
        });
    }
}

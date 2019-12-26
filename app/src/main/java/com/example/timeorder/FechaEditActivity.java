package com.example.timeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timeorder.dal.EventoDAL;
import com.example.timeorder.dto.Evento;

import java.util.Date;

public class FechaEditActivity extends AppCompatActivity {

    private TextView txtFecha;
    private EditText editFecha;
    private Button btnCancelarFecha;
    private Button btnOkFecha;
    private EventoDAL eventoDAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_edit);

        this.txtFecha = (TextView) findViewById(R.id.txtFecha);
        this.editFecha = (EditText) findViewById(R.id.editFecha);
        this.btnCancelarFecha = (Button) findViewById(R.id.btnCancelarFecha);
        this.btnOkFecha = (Button) findViewById(R.id.btnOkFecha);

        this.eventoDAL = new EventoDAL(getApplicationContext(), (Evento) getIntent().getSerializableExtra("evento") );

        this.editFecha.setText(eventoDAL.getEvento().getFecha());

        btnOkFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Evento e = eventoDAL.getEvento();
                e.setFecha(String.valueOf(editFecha.getText()));

                if(eventoDAL.actualizar(e)) {
                    Toast.makeText(getApplicationContext(), "Fecha Correctamente Actualizada", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Fecha Incorrectamente Actualizada", Toast.LENGTH_LONG).show();
                }
            }
        });

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

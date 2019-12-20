package com.example.timeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity {

    private TextView txtDetalle;
    private TextView txtNombreDetalle;
    private TextView txtHoraDetalle;
    private TextView txtFechaDetalle;
    private TextView txtComentarioDetalle;
    private TextView txtName;
    private TextView txtTime;
    private TextView txtDate;
    private TextView txtComment;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        this.txtDetalle = (TextView) findViewById(R.id.txtDetalle);
        this.txtNombreDetalle = (TextView) findViewById(R.id.txtNombreDetalle);
        this.txtHoraDetalle = (TextView) findViewById(R.id.txtHoraDetalle);
        this.txtFechaDetalle = (TextView) findViewById(R.id.txtFechaDetalle);
        this.txtComentarioDetalle = (TextView) findViewById(R.id.txtComentarioDetalle);
        this.txtName = (TextView) findViewById(R.id.txtName);
        this.txtTime = (TextView) findViewById(R.id.txtTime);
        this.txtDate = (TextView) findViewById(R.id.txtDate);
        this.txtComment = (TextView) findViewById(R.id.txtComment);
        this.btnEditar = (Button) findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(DetalleActivity.this, FechaEditActivity.class);

                startActivity(intento);
            }
        });
    }
}

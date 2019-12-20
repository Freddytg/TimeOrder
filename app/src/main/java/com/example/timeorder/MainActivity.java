package com.example.timeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtDescripcion;
    private TextView txtEventos;
    private Button btnAgregarEvento;
    private ImageView imgReloj;
    private ListView listEventos;
    private Button btnPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        this.txtEventos = (TextView) findViewById(R.id.txtEventos);
        this.btnAgregarEvento = (Button) findViewById(R.id.btnAgregarEvento);
        this.imgReloj = (ImageView) findViewById(R.id.imgReloj);
        this.listEventos = (ListView) findViewById(R.id.listEventos);
        this.btnPrueba = (Button) findViewById(R.id.btnPrueba);

        btnAgregarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, FechaActivity.class);

                startActivity(intento);
            }
        });

        btnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, DetalleActivity.class);

                startActivity(intento);
            }
        });
    }
}

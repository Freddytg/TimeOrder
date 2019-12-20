package com.example.timeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditarActivity extends AppCompatActivity {

    private TextView txtIngreso;
    private TextView txtHora;
    private TextView txtComentarios;
    private EditText editNombre;
    private EditText editHora;
    private EditText editMinutos;
    private EditText editComentarios;
    private CheckBox checkRecordatorios;
    private Button btnEditarEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        this.txtIngreso = (TextView) findViewById(R.id.txtIngreso);
        this.txtHora = (TextView) findViewById(R.id.txtHora);
        this.txtComentarios = (TextView) findViewById(R.id.txtComentarios);
        this.editNombre = (EditText) findViewById(R.id.editNombre);
        this.editHora = (EditText) findViewById(R.id.editHora);
        this.editMinutos = (EditText) findViewById(R.id.editMinutos);
        this.editComentarios = (EditText) findViewById(R.id.editComentarios);
        this.checkRecordatorios = (CheckBox) findViewById(R.id.checkRecordatorio);
        this.btnEditarEvento = (Button) findViewById(R.id.btnEditarEvento);

        btnEditarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(EditarActivity.this, MainActivity.class);
                intento.putExtra("mensaje", "Evento Editado Exitosamente");
                Toast.makeText(getApplicationContext(),
                        "Evento Editado Exitosamente",
                        Toast.LENGTH_LONG).show();
                startActivity(intento);
            }
        });
    }


}

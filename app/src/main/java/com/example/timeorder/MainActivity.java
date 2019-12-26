package com.example.timeorder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timeorder.dal.EventoDAL;
import com.example.timeorder.dto.Evento;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtDescripcion;
    private TextView txtEventos;
    private Button btnAgregarEvento;
    private ImageView imgReloj;
    private ListView listEventos;
    private Button btnPrueba;
    private ArrayAdapter<Evento> adapter;
    private ArrayList<Evento> listaEventos;
    private EventoDAL eventoDAL;
    private int codPosicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.eventoDAL = new EventoDAL(getApplicationContext(), new Evento());
        this.listaEventos = new EventoDAL(getBaseContext()).seleccionar();

        this.listEventos = (ListView) findViewById(R.id.listEventos);

        this.adapter = new ArrayAdapter<Evento>(
                getApplicationContext(), android.R.layout.simple_list_item_1, this.listaEventos);

        this.listEventos.setAdapter(adapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        this.txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        this.txtEventos = (TextView) findViewById(R.id.txtEventos);
        this.btnAgregarEvento = (Button) findViewById(R.id.btnAgregarEvento);
        this.imgReloj = (ImageView) findViewById(R.id.imgReloj);


        builder.setTitle("Confirmación");
        builder.setMessage("¿Desea borrar el evento?");
        builder.setPositiveButton("Si, borrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int id = ((Evento) listaEventos.get(codPosicion)).getId();
                boolean r = eventoDAL.eliminar(id);
                if(r){
                    Toast.makeText(getApplicationContext(), "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
                    actualizarLista();
                } else {
                    Toast.makeText(getApplicationContext(), "No se ha podido eliminar el evento", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { dialogInterface.cancel();
            }
        });

        final AlertDialog dialog = builder.create();

        listEventos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                dialog.show();
                return true;
            }
        });


        listEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                abrirDetalleActivity();
            }
        });



        btnAgregarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, FechaActivity.class);

                startActivity(intento);
            }
        });


    }

    private void actualizarLista() {
        adapter.clear();
        adapter.addAll(eventoDAL.seleccionar());
        adapter.notifyDataSetChanged();
    }

    private void abrirDetalleActivity() {
        Intent intento = new Intent(MainActivity.this, DetalleActivity.class);
        Evento e = (Evento) listaEventos.get(codPosicion);

        intento.putExtra("evento", e);
        startActivityForResult(intento, 100);
    }
}

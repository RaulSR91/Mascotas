package com.salazar.raul.bkfo;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //Toolbar miActioBar = (Toolbar)findViewById(R.id.miActionBar);
       // setSupportActionBar(miActioBar);

        //Lista que se va a llenar
        listaMascotas  = (RecyclerView)findViewById(R.id.rvMascotas);

        /*Layout*/
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        this.inicializarListaMascotas();
        this.inicializarAdaptador();


    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(this.mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas("UNO",3,R.drawable.gato1));
        mascotas.add(new Mascotas("DOS",23,R.drawable.gatos2));
        mascotas.add(new Mascotas("TRES",27,R.drawable.gato3));
        mascotas.add(new Mascotas("CUATRO",26,R.drawable.gato4));
        mascotas.add(new Mascotas("CINCO",9,R.drawable.gato5));
        mascotas.add(new Mascotas("SEIS",89,R.drawable.gato6));
        mascotas.add(new Mascotas("SIETE",91,R.drawable.gato7));
        mascotas.add(new Mascotas("OCHO",28,R.drawable.gato8));
        mascotas.add(new Mascotas("NUEVE",93,R.drawable.gato9));
        mascotas.add(new Mascotas("DIEZ",12,R.drawable.gato10));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mAbout:
                Toast.makeText(this,"Seleccionaste About ",Toast.LENGTH_SHORT).show();

                break;

            case R.id.mEstrella:
                //Obtener los 5 mas Raiteados
                Intent top5 = new Intent(MainActivity.this,top5.class);
               startActivity(top5);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}

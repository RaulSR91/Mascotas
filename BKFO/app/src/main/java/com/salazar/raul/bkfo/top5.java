package com.salazar.raul.bkfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class top5 extends AppCompatActivity {
    ArrayList<Mascotas> mascotasTop5;
    private RecyclerView listaMascotasTop5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);


       // Toolbar miActioBar = (Toolbar)findViewById(R.id.miActionBar);
        //setSupportActionBar(miActioBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Lista que se va a llenar
        listaMascotasTop5  = (RecyclerView)findViewById(R.id.rvMascotasTop5);

        /*Layout*/
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasTop5.setLayoutManager(llm);

        this.Top5();
        MascotaAdaptador adaptador = new MascotaAdaptador(this.mascotasTop5,this);
        listaMascotasTop5.setAdapter(adaptador);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_top5,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mAbout:
                Toast.makeText(this,"Seleccionaste About ",Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onOptionsItemSelected(item);
    }


    public void Top5(){
        this.mascotasTop5  = new ArrayList<Mascotas>();
        mascotasTop5.add(new Mascotas("NUEVE",93,R.drawable.gato9));
        mascotasTop5.add(new Mascotas("SIETE",91,R.drawable.gato7));
        mascotasTop5.add(new Mascotas("SEIS",89,R.drawable.gato6));
        mascotasTop5.add(new Mascotas("OCHO",28,R.drawable.gato8));
        mascotasTop5.add(new Mascotas("TRES",27,R.drawable.gato3));
    }
}

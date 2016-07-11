package com.salazar.raul.bkfo;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Spartan117 on 10/07/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascotas> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder MascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);

        MascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        MascotaViewHolder.tvRatingCV.setText(Integer.toString(mascota.getRating()));


        MascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Te ha gustado : "+mascota.getNombre(),Toast.LENGTH_SHORT).show();




            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView   imgFotoCV;
        private TextView    tvNombreCV;
        private TextView    tvRatingCV;
        private ImageButton btnLikeCV;
        private ImageButton btnRatingCV;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV       = (ImageView)   itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV      = (TextView)    itemView.findViewById(R.id.tvNombreCV);
            btnLikeCV       = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            tvRatingCV      = (TextView)    itemView.findViewById(R.id.tvRatingCV);
        }
    }



}

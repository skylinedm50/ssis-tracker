package com.example.ssis_tracker.adapter.proyectos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ssis_tracker.R;
import com.example.ssis_tracker.model.Meta;

import java.util.ArrayList;

public class AdapterMetas extends  RecyclerView.Adapter<AdapterMetas.HolderMetas>{
    private ArrayList<Meta> metaArrayList;

    public AdapterMetas(ArrayList<Meta> metaArrayList){
        this.metaArrayList = metaArrayList;
    }

    public class HolderMetas extends RecyclerView.ViewHolder{
        TextView textViewActividad;
        TextView textViewMetrica;
        View viewDivider;

        public HolderMetas(@NonNull View itemView) {
            super(itemView);
            textViewActividad = itemView.findViewById(R.id.textViewActividad);
            textViewMetrica = itemView.findViewById(R.id.textViewMetrica);
            viewDivider = itemView.findViewById(R.id.viewDivider);
        }
    }

    @NonNull
    @Override
    public HolderMetas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_metas, viewGroup ,false);
        return new HolderMetas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderMetas holderMetas, int i) {
        holderMetas.textViewActividad.setText(metaArrayList.get(i).getActividad());
        holderMetas.textViewMetrica.setText(metaArrayList.get(i).getUnidad() +  " - " +  String.valueOf(metaArrayList.get(i).getProgramado()));
    }

    @Override
    public int getItemCount() {
        return metaArrayList.size();
    }

    public void adapterDataChange(ArrayList<Meta> arrayList){
        this.metaArrayList = arrayList;
        notifyDataSetChanged();
    }
}

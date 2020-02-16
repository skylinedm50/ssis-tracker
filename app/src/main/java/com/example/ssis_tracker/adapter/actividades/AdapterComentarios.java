package com.example.ssis_tracker.adapter.actividades;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.model.Agenda;
import com.example.ssis_tracker.model.Comentario;

import java.util.ArrayList;


public class AdapterComentarios extends RecyclerView.Adapter<AdapterComentarios.HolderComentarios> {

    private ArrayList<Comentario> comentarios = new ArrayList<>();

    public AdapterComentarios(){

       /* comentarios.add(new String[]{"USUARIO 1" , "15/2/2019", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "});
        comentarios.add(new String[]{"USUARIO 1" , "2/3/2019", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "});
        comentarios.add(new String[]{"USUARIO 2" , "29/3/2019", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "});
        comentarios.add(new String[]{"USUARIO 3" , "1/4/2019", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "});*/
    }

    @NonNull
    @Override
    public HolderComentarios onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_comentarios, viewGroup, false);
        return new HolderComentarios(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderComentarios holderComentarios, int i) {
        holderComentarios.txtUsuario.setText(comentarios.get(i).getNombreUsuario());
        holderComentarios.txtFchActualizacion.setText(comentarios.get(i).getFechaComentario());
        holderComentarios.txtComentario.setText(comentarios.get(i).getComentario());
    }


    @Override
    public int getItemCount() {
        return comentarios.size();
    }

    public void AgregarComentarios(ArrayList<Comentario> comentarios){
        this.comentarios = comentarios;
        notifyDataSetChanged();
    }

    public class HolderComentarios extends RecyclerView.ViewHolder {

        private TextView     txtUsuario;
        private TextView     txtFchActualizacion;
        private TextView     txtComentario;

        public HolderComentarios(@NonNull View itemView) {
            super(itemView);

            txtUsuario  = itemView.findViewById(R.id.txt_UsuarioNombre);
            txtFchActualizacion = itemView.findViewById(R.id.txt_fchComentario);
            txtComentario = itemView.findViewById(R.id.txtComentario);

        }
    }
}

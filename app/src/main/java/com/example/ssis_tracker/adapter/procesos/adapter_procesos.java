package com.example.ssis_tracker.adapter.procesos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.ssis_tracker.R;
import com.example.ssis_tracker.model.Proceso;

import java.util.ArrayList;

public class adapter_procesos extends RecyclerView.Adapter<adapter_procesos.HolderProcess>{
    private ArrayList<Proceso> arrayListProcess;
    private adapter_procesos.OnItemClickListener onClickListener;
    private Context context;

    private int lastPosition = -1;

    public class HolderProcess extends RecyclerView.ViewHolder{
        private TextView tvTituloProcess;
        private TextView tvDescProcess;
        private TextView tvNumProcess;

        public HolderProcess(View itemView, adapter_procesos.OnItemClickListener listener){
            super(itemView);

            this.tvTituloProcess = itemView.findViewById(R.id.tvTituloProceso);
            this.tvDescProcess = itemView.findViewById(R.id.tvDescProceso);
            this.tvNumProcess  = itemView.findViewById(R.id.tvNumProceso);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onClickListener != null){
                        if(getAdapterPosition() != RecyclerView.NO_POSITION){
                            onClickListener.onitemClick(getAdapterPosition());
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onitemClick(int position);
    }

    public void setOnClickListener(adapter_procesos.OnItemClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull adapter_procesos.HolderProcess holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    public adapter_procesos(ArrayList<Proceso> arrayListProyects, Context context){
        this.arrayListProcess = arrayListProyects;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_procesos.HolderProcess onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemproceso, viewGroup, false);
        return new adapter_procesos.HolderProcess(view, this.onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_procesos.HolderProcess viewHolder, int i) {
        Proceso proceso = this.arrayListProcess.get(i);
        viewHolder.tvTituloProcess.setText(proceso.getNombre_Proyecto());
        viewHolder.tvDescProcess.setText(proceso.getDescripcion());
        i++;
        viewHolder.tvNumProcess.setText(i+"/"+getItemCount());

        /*seccion animacion */
        Animation animation = AnimationUtils.loadAnimation(context, (i > lastPosition) ? R.anim.top_from_down : R.anim.down_from_top);
        viewHolder.itemView.startAnimation(animation);
        lastPosition = i;
    }

    @Override
    public int getItemCount() {
        return this.arrayListProcess.size();
    }
}

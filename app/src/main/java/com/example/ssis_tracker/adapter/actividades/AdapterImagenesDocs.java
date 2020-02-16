package com.example.ssis_tracker.adapter.actividades;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.view.imagenesdocs.ImagenesDocActivity;
import java.util.ArrayList;

public class AdapterImagenesDocs extends RecyclerView.Adapter<AdapterImagenesDocs.HolderImagenes> {

    private ArrayList<String> arrayListImagenes = new ArrayList<>();
    private Context context;

    public AdapterImagenesDocs(Context cntx){
        this.context = cntx;
       /* arrayListImagenes.add("https://source.unsplash.com/user/erondu/1600x900");
        arrayListImagenes.add("https://source.unsplash.com/user/erondu/daily");
        arrayListImagenes.add("https://source.unsplash.com/1600x900/?nature,water");
        arrayListImagenes.add("https://source.unsplash.com/WLUHO9A_xik/1600x900");
        arrayListImagenes.add("https://source.unsplash.com/user/erondu/1600x900");
        arrayListImagenes.add("https://source.unsplash.com/user/erondu/daily");
        arrayListImagenes.add("https://source.unsplash.com/1600x900/?nature,water");
        arrayListImagenes.add("https://source.unsplash.com/WLUHO9A_xik/1600x900"); */
    }

    @NonNull
    @Override
    public HolderImagenes onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_imagenes, viewGroup , false);
        return new HolderImagenes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderImagenes holderImagenes, final int i) {
        Glide.with(this.context).load(arrayListImagenes.get(i)).centerCrop().into(holderImagenes.ImageViewDocs);
        holderImagenes.ImageViewDocs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( v.getContext(), ImagenesDocActivity.class);
                intent.putStringArrayListExtra("imagenes",arrayListImagenes);
                intent.putExtra("positionImg",i);
                v.getContext().startActivity(intent);
            }
        });
    }

    public void AgregarImagenes(ArrayList<String> imagenes){
        this.arrayListImagenes = imagenes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return arrayListImagenes.size();
    }

    public class HolderImagenes extends RecyclerView.ViewHolder {

        ImageView ImageViewDocs;

        public HolderImagenes(@NonNull View itemView) {
            super(itemView);
            ImageViewDocs = itemView.findViewById(R.id.ImageViewDocs);
        }
    }
}

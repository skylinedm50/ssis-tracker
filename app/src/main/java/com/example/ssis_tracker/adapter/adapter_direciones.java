package com.example.ssis_tracker.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.ssis_tracker.R;
import java.util.ArrayList;
import java.util.Random;

public class adapter_direciones extends RecyclerView.Adapter<adapter_direciones.HolderDirecciones> {

    private ArrayList<String[]> arrayDirecciones = new ArrayList<>();
    private Context context;
    private int lastPosition = -1;

    public adapter_direciones(Context context){
        this.context = context;
        arrayDirecciones.add(new String[]{"1" , "SIG" ,
                                          "SISTEMA DE INFORMACIÓN GERENCIAL" ,"CARLOS JOSUÉ ROMERO PUERTO" ,
                                          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "2" , "TMC" ,
                                            "TRANSFERENCIA MONETARIA CONDICIONADA" ,"LUIS ORTEGA" ,
                                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});

        arrayDirecciones.add(new String[]{  "3" , "UCP" ,
                "UNIDAD CORDINADORA DE PROYECTOS" ,"WIL CASTRO" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."});



    }

    @NonNull
    @Override
    public HolderDirecciones onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_direcciones, viewGroup ,false);
        return  new HolderDirecciones(view);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull HolderDirecciones holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDirecciones holderDirecciones, int i) {

        /*seccion bind de datos */
        switch (arrayDirecciones.get(i)[0]){
            case "1":
                    Glide.with(this.context).load(R.drawable.ssis1)
                            .centerCrop()
                            .into(holderDirecciones.ImgDireccion);
                    break;
            case "2":
                    Glide.with(this.context).load(R.drawable.ssis2)
                            .centerCrop()
                            .into(holderDirecciones.ImgDireccion);
                    break;
            case "3":
                Glide.with(this.context).load(R.drawable.ssis3)
                        .centerCrop()
                        .into(holderDirecciones.ImgDireccion);
                break;
        }

        holderDirecciones.TxtAcronym.setText(arrayDirecciones.get(i)[1])   ;
        holderDirecciones.TxtDireccion.setText(arrayDirecciones.get(i)[2]) ;
        holderDirecciones.TxtDirector.setText(arrayDirecciones.get(i)[3])  ;
        holderDirecciones.TxtDescripcion.setText(arrayDirecciones.get(i)[4]) ;

        /*seccion color y animacion */
        Animation animation = AnimationUtils.loadAnimation(context, (i > lastPosition) ? R.anim.top_from_down : R.anim.down_from_top);
        holderDirecciones.itemView.startAnimation(animation);
        lastPosition = i;

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        Drawable mDrawable = context.getResources().getDrawable(R.drawable.drw_acronym);
        mDrawable.setColorFilter(color , PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public int getItemCount() {
        return arrayDirecciones.size();
    }

    public class HolderDirecciones extends RecyclerView.ViewHolder {

        ImageView ImgDireccion;
        TextView  TxtAcronym;
        TextView  TxtDireccion;
        TextView  TxtDirector;
        TextView  TxtDescripcion;

        public HolderDirecciones(@NonNull View itemView) {
            super(itemView);
            ImgDireccion    = itemView.findViewById(R.id.direccion_img);
            TxtAcronym      = itemView.findViewById(R.id.txt_acronym);
            TxtDireccion    = itemView.findViewById(R.id.txt_direccion);
            TxtDirector     = itemView.findViewById(R.id.txt_director);
            TxtDescripcion  = itemView.findViewById(R.id.txt_descripcion);
        }
    }
}

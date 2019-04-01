package com.example.ssis_tracker.view.actividades;


import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.actividades.AdapterComentarios;


public class ActividadesFragment extends Fragment {

    private int minHeight;
    private CardView CardActividad;
    private LinearLayout  LinearLayoutComentarios;

    public static ActividadesFragment NuevaInstancia(int position, int size){

        ActividadesFragment actividadesFragment = new ActividadesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        bundle.putInt("size"    ,size);
        actividadesFragment.setArguments(bundle);
        return actividadesFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentActividad    = inflater.inflate(R.layout.fragment_actividades , container , false);
        TextView txt_position     = fragmentActividad.findViewById(R.id.txt_posicion);
        TextView TxtDireccion  = fragmentActividad.findViewById(R.id.txt_direccion);

        RelativeLayout  rl_Expand = fragmentActividad.findViewById(R.id.rl_Expand_Comentarios);
        RelativeLayout  RelativeLayoutBottomSheet = fragmentActividad.findViewById(R.id.RelativeLayoutBottomSheet);

        LinearLayoutComentarios = fragmentActividad.findViewById(R.id.LinearLayoutComentarios);
        CardActividad = fragmentActividad.findViewById(R.id.card_view_actividad);

        RecyclerView rvComentarios = fragmentActividad.findViewById(R.id.rvComentarios);
        AdapterComentarios adapterComentarios = new AdapterComentarios();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());


       /* final BottomSheetBehavior bsb = BottomSheetBehavior.from(RelativeLayoutBottomSheet);
        RelativeLayoutBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bsb.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });*/
        rvComentarios.setLayoutManager(linearLayoutManager);
        rvComentarios.setAdapter(adapterComentarios);

        txt_position.setText(
                String.valueOf( getArguments().getInt("position") + 1 )+"/"+String.valueOf(getArguments().getInt("size"))
        );

        rl_Expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator anim = ValueAnimator.ofInt(CardActividad.getMeasuredHeightAndState(), 8000);
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if(LinearLayoutComentarios.getVisibility() == View.GONE){
                            LinearLayoutComentarios.setVisibility(View.VISIBLE);
                        }else{
                            LinearLayoutComentarios.setVisibility(View.GONE);
                        }
                    }
                });
                anim.start();

            }
        });

        return fragmentActividad;
    }



}

package com.example.ssis_tracker.view.actividades;


import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.ssis_tracker.R;


public class ActividadesFragment extends Fragment {

    private int minHeight;
    private CardView CardActividad;

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
        RelativeLayout  rl_Expand = fragmentActividad.findViewById(R.id.rl_Expand_Comentarios);
        CardActividad = fragmentActividad.findViewById(R.id.card_view_actividad);
        iniciar_card();

        txt_position.setText(
                String.valueOf( getArguments().getInt("position") + 1 )+"/"+String.valueOf(getArguments().getInt("size"))
        );

        rl_Expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleCardViewnHeight();
            }
        });

        return fragmentActividad;
    }


    private void iniciar_card(){
        WindowManager windowManager = (WindowManager) this.getContext().getSystemService(this.getContext().WINDOW_SERVICE);
        DisplayMetrics dimension = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dimension);

        CardActividad.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                minHeight = CardActividad.getHeight();
                ViewGroup.LayoutParams layoutParams = CardActividad.getLayoutParams();
                layoutParams.height = 3000;
                return true;
            }
        });
    }

    private void toggleCardViewnHeight( ) {
        if (CardActividad.getHeight() < 4000) {
            expandView(4000);
        } else {
            collapseView();
        }
    }

    public void collapseView() {

        ValueAnimator anim = ValueAnimator.ofInt(CardActividad.getMeasuredHeightAndState(), minHeight);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = CardActividad.getLayoutParams();
                layoutParams.height = 3000;
                CardActividad.setLayoutParams(layoutParams);
            }
        });
        anim.start();
    }

    public void expandView(int height) {

        ValueAnimator anim = ValueAnimator.ofInt(CardActividad.getMeasuredHeightAndState(), height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = CardActividad.getLayoutParams();
                layoutParams.height = val;
                CardActividad.setLayoutParams(layoutParams);
            }
        });
        anim.start();

    }

}

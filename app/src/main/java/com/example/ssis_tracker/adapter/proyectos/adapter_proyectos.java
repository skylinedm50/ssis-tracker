package com.example.ssis_tracker.adapter.proyectos;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.view.procesos.ProcesoActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class adapter_proyectos extends RecyclerView.Adapter<adapter_proyectos.HolderProyectos> {

    private ArrayList<String[]> arrayProyectos = new ArrayList<>();
    private Context context;
    private int lastPosition = -1;
    private int minHeight;

    public adapter_proyectos(Context cntx){

        this.context = cntx;
        arrayProyectos.add(new String[]{"ENTREGA DE MOCHILAS EN LEPAERA" , "28/03/2019 - 01/04/2019" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." ,
                "Iniciado" , "#2E9AFE" , "55" , "88" , "40" , "Meta actualizada: 30/03/2019"
        });

        arrayProyectos.add(new String[]{"ENTREGA DE MOCHILAS EN LEPAERA" , "28/03/2019 - 01/04/2019" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." ,
                "Iniciado" , "#2E9AFE" , "40" , "30", "60", "Meta actualizada: 30/03/2019"
        });

        arrayProyectos.add(new String[]{"ENTREGA DE MOCHILAS EN LEPAERA" , "28/03/2019 - 01/04/2019" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." ,
                "Iniciado" , "#2E9AFE" , "100" , "15" , "50", "Meta actualizada: 30/03/2019"
        });

        arrayProyectos.add(new String[]{"ENTREGA DE MOCHILAS EN LEPAERA" , "28/03/2019 - 01/04/2019" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." ,
                "Iniciado" , "#2E9AFE" , "10" , "25", "90", "Meta actualizada: 30/03/2019"
        });

        arrayProyectos.add(new String[]{"ENTREGA DE MOCHILAS EN LEPAERA" , "28/03/2019 - 01/04/2019" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." ,
                "Iniciado" , "#2E9AFE" , "30" , "55", "80", "Meta actualizada: 30/03/2019"
        });

        arrayProyectos.add(new String[]{"ENTREGA DE MOCHILAS EN LEPAERA" , "28/03/2019 - 01/04/2019" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." ,
                "Iniciado" , "#2E9AFE" , "15" , "78", "60", "Meta actualizada: 30/03/2019"
        });

        arrayProyectos.add(new String[]{"ENTREGA DE MOCHILAS EN LEPAERA" , "28/03/2019 - 01/04/2019" ,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." ,
                "Iniciado" , "#2E9AFE" , "44" , "98", "20", "Meta actualizada: 30/03/2019"
        });
    }

    @NonNull
    @Override
    public HolderProyectos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_proyecto, viewGroup ,false);
        return new HolderProyectos(view);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull adapter_proyectos.HolderProyectos holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderProyectos holderProyectos, final int i) {
        holderProyectos.txtNombreProy.setText(arrayProyectos.get(i)[0]);
        holderProyectos.fchProyecto.setText(arrayProyectos.get(i)[1]);
        holderProyectos.descProyecto.setText(arrayProyectos.get(i)[2]);
        holderProyectos.txtEstadoD.setText(arrayProyectos.get(i)[3]);
        holderProyectos.txtActualizacionMeta.setText(arrayProyectos.get(i)[8]);
        iniciar_card(holderProyectos.CardProyect);

        Drawable drawable = holderProyectos.viewEstadoProyecto.getBackground();
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(Color.parseColor( arrayProyectos.get(i)[4] ));

        GenerarChart(Integer.parseInt( arrayProyectos.get(i)[5] ) , holderProyectos.pieRealizado , 8f);
        GenerarChart(Integer.parseInt( arrayProyectos.get(i)[6] ) , holderProyectos.pieDias,8f);

        /*seccion de color y animacion */
        Animation animation = AnimationUtils.loadAnimation(context, (i > lastPosition) ? R.anim.top_from_down : R.anim.down_from_top);
        holderProyectos.itemView.startAnimation(animation);
        lastPosition = i;

        /*Eventos*/
        holderProyectos.CardProyect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProcesoActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        holderProyectos.expand_collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleCardViewnHeight(holderProyectos.EstadoMetas , holderProyectos.CardProyect, holderProyectos.pieMetas ,Integer.parseInt( arrayProyectos.get(i)[7] ));
            }
        });

        holderProyectos.Pumpunear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                if(vibrator.hasVibrator()){
                    vibrator.vibrate(300);
                }
            }
        });

    }
    /*-------------- ViewHolder -------------------------------------*/
    @Override
    public int getItemCount() {
        return arrayProyectos.size();
    }

    public class HolderProyectos extends RecyclerView.ViewHolder {

        TextView      txtNombreProy;
        TextView      fchProyecto;
        TextView      descProyecto;
        TextView      txtEstadoD;
        TextView      txtActualizacionMeta;
        View          viewEstadoProyecto;
        PieChart      pieRealizado;
        PieChart      pieDias;
        PieChart      pieMetas;
        ImageView     expand_collapse;
        CardView      CardProyect;
        LinearLayout  Pumpunear;
        LinearLayout  EstadoMetas;

        public HolderProyectos(@NonNull View itemView) {
            super(itemView);

            this.CardProyect            = itemView.findViewById(R.id.card_view_proy);
            this.txtNombreProy          = itemView.findViewById(R.id.nombre_proyecto);
            this.fchProyecto            = itemView.findViewById(R.id.fechas_proyecto);
            this.descProyecto           = itemView.findViewById(R.id.descripcion_proyecto);
            this.viewEstadoProyecto     = itemView.findViewById(R.id.viewEstadoColor);
            this.txtEstadoD             = itemView.findViewById(R.id.estadoD);
            this.pieRealizado           = itemView.findViewById(R.id.realizadoChart);
            this.pieDias                = itemView.findViewById(R.id.transcurridosChart);
            this.pieMetas               = itemView.findViewById(R.id.MetasChart);
            this.expand_collapse        = itemView.findViewById(R.id.expand_collapse);
            this.Pumpunear              = itemView.findViewById(R.id.LyPumpunear);
            this.txtActualizacionMeta   = itemView.findViewById(R.id.txt_actualizacion_meta);
            this.EstadoMetas            = itemView.findViewById(R.id.LyEstadoMetas);
        }
    }

    /*---------------- funciones para el manejo de los controles --------------*/

    private void GenerarChart(int procentaje , PieChart PieChart , float size){
        ArrayList<PieEntry> circleyVals  = new ArrayList<>();
        ArrayList<Integer>  circleColors = new ArrayList<>();
        PieDataSet circleDataSet;
        PieData circleData;

        PieChart.getDescription().setText("");
        PieChart.setHoleRadius(80f);
        PieChart.setRotationEnabled(false);
        PieChart.animateXY(0, 1500);
        PieChart.setCenterText(procentaje+"%");
        PieChart.setCenterTextSize(size);
        PieChart.setTouchEnabled(false);
        PieChart.getLegend().setEnabled(false);
        PieChart.setDrawSliceText(false);

        circleyVals.add(new PieEntry(procentaje,"Valx"));
        circleyVals.add(new PieEntry(100-procentaje,"Valy"));

        circleColors.add(ColorTemplate.MATERIAL_COLORS[2]);
        circleColors.add(Color.parseColor("#F2F2F2"));

        circleDataSet = new PieDataSet(circleyVals,"");
        circleDataSet.setColors(circleColors);
        circleDataSet.setDrawValues(false);
        circleData = new PieData(circleDataSet);

        PieChart.setData(circleData);
    }

    private void iniciar_card(final CardView cardView){
        WindowManager windowManager = (WindowManager) this.context.getSystemService(this.context.WINDOW_SERVICE);
        DisplayMetrics dimension = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dimension);

        cardView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
               // minHeight = cardView.getHeight();
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                return true;
            }
        });
    }

    private void toggleCardViewnHeight(LinearLayout estadoMetas , CardView cardView , PieChart pieChart , int porcentaje) {
        if (cardView.getHeight() < 1900) {
            estadoMetas.setVisibility(View.VISIBLE);
            expandView(1900, cardView, pieChart, porcentaje);
        } else {
            estadoMetas.setVisibility(View.GONE);
            collapseView(cardView);
        }
    }

    public void collapseView(final CardView cardView) {

        ValueAnimator anim = ValueAnimator.ofInt(cardView.getMeasuredHeightAndState(), minHeight);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                cardView.setLayoutParams(layoutParams);
            }
        });
        anim.start();
    }

    public void expandView(int height, final CardView cardView , PieChart pieChart , int porcentaje) {

        GenerarChart(porcentaje , pieChart,30f);
        ValueAnimator anim = ValueAnimator.ofInt(cardView.getMeasuredHeightAndState(), height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                layoutParams.height = val;
                cardView.setLayoutParams(layoutParams);
            }
        });
        anim.start();

    }


}

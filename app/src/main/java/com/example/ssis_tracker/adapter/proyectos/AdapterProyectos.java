package com.example.ssis_tracker.adapter.proyectos;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
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
import com.example.ssis_tracker.api.proyectos.ApiAdapterProyectos;
import com.example.ssis_tracker.api.proyectos.ApiServiceProyectos;
import com.example.ssis_tracker.model.Meta;
import com.example.ssis_tracker.model.Proyecto;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterProyectos extends RecyclerView.Adapter<AdapterProyectos.HolderProyectos> {
    private ArrayList<Proyecto> arrayList;
    private final Context context;
    private int lastPosition = -1;
    private int minHeight;
    private ApiAdapterProyectos adapterProyectos;
    private ApiServiceProyectos serviceProyectos;
    private AlertDialog alertDialog;
    private AdapterMetas adapterMetas;

    public AdapterProyectos(Context context, ArrayList<Proyecto> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        adapterProyectos = new ApiAdapterProyectos();
        serviceProyectos = adapterProyectos.getClientService();
    }

    @NonNull
    @Override
    public HolderProyectos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_proyecto, viewGroup ,false);
        return new HolderProyectos(view);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull AdapterProyectos.HolderProyectos holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderProyectos holderProyectos, final int i) {
        holderProyectos.textViewNombreProyecto.setText(arrayList.get(i).getNombre());
        holderProyectos.textViewFechasProyecto.setText(arrayList.get(i).getFechas());
        holderProyectos.textViewDescripcionProyecto.setText(arrayList.get(i).getDescripcion());
        holderProyectos.textViewEstado.setText(arrayList.get(i).getEstado());
        expandAndAddInfoCardView(holderProyectos.cardViewProyecto);

        Drawable drawable = holderProyectos.viewEstadoColor.getBackground();
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(Color.parseColor( arrayList.get(i).getColor()));

        generarChart(arrayList.get(i).getPorcentajeProcesos(), holderProyectos.pieChartRealizado, 8f);
        generarChart(arrayList.get(i).getPorcentajeDias(), holderProyectos.pieChartDiasTranscurridos,8f);

       /**Sección de color y animación*/
        Animation animation = AnimationUtils.loadAnimation(context, (i > lastPosition) ? R.anim.top_from_down : R.anim.down_from_top);
        holderProyectos.itemView.startAnimation(animation);
        lastPosition = i;

        /**Evento*/
        holderProyectos.imageViewExpandCollapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleCardViewnHeight(holderProyectos.linearLayoutEstadoMetas, holderProyectos.cardViewProyecto, holderProyectos.pieChartMetas, arrayList.get(i).getPorcentajeMetas());
            }
        });

        holderProyectos.linearLayoutPumpunear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                if(vibrator.hasVibrator()){
                    vibrator.vibrate(300);
                }
            }
        });

        holderProyectos.imageViewMetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPoppupMetas(arrayList.get(i).getId(), v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class HolderProyectos extends RecyclerView.ViewHolder {
        TextView textViewNombreProyecto;
        TextView textViewFechasProyecto;
        TextView textViewDescripcionProyecto;
        View viewEstadoColor;
        TextView textViewEstado;
        TextView textViewActualizacionMetas;
        PieChart pieChartRealizado;
        PieChart pieChartDiasTranscurridos;
        PieChart pieChartMetas;
        ImageView imageViewExpandCollapse;
        CardView cardViewProyecto;
        LinearLayout linearLayoutPumpunear;
        LinearLayout linearLayoutEstadoMetas;
        ImageView imageViewMetas;

        public HolderProyectos(@NonNull View itemView) {
            super(itemView);
            cardViewProyecto = itemView.findViewById(R.id.cardViewProyecto);
            textViewNombreProyecto = itemView.findViewById(R.id.textViewNombreProyecto);
            textViewFechasProyecto = itemView.findViewById(R.id.textViewFechasProyecto);
            textViewDescripcionProyecto = itemView.findViewById(R.id.textViewDescripcionProyecto);
            viewEstadoColor = itemView.findViewById(R.id.viewEstadoColor);
            textViewEstado = itemView.findViewById(R.id.textViewEstado);
            pieChartRealizado = itemView.findViewById(R.id.pieChartRealizado);
            pieChartDiasTranscurridos = itemView.findViewById(R.id.pieChartDiasTranscurridos);
            pieChartMetas = itemView.findViewById(R.id.pieChartMetas);
            imageViewExpandCollapse = itemView.findViewById(R.id.imageViewExpandCollapse);
            linearLayoutPumpunear = itemView.findViewById(R.id.linearLayoutPumpunear);
            linearLayoutEstadoMetas = itemView.findViewById(R.id.linearLayoutEstadoMetas);
            textViewActualizacionMetas = itemView.findViewById(R.id.textViewActualizacionMetas);
            imageViewMetas = itemView.findViewById(R.id.imageViewMetas);
        }
    }

    private void generarChart(int procentaje , PieChart pieChart , float size){
        ArrayList<PieEntry> circleyVals  = new ArrayList<>();
        ArrayList<Integer>  circleColors = new ArrayList<>();
        PieDataSet circleDataSet;
        PieData circleData;

        pieChart.getDescription().setText("");
        pieChart.setHoleRadius(80f);
        pieChart.setRotationEnabled(false);
        pieChart.animateXY(0, 1500);
        pieChart.setCenterText(procentaje+"%");
        pieChart.setCenterTextSize(size);
        pieChart.setTouchEnabled(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setDrawEntryLabels(false);

        circleyVals.add(new PieEntry(procentaje,"Valx"));
        circleyVals.add(new PieEntry(100-procentaje,"Valy"));

        circleColors.add(ColorTemplate.MATERIAL_COLORS[2]);
        circleColors.add(Color.parseColor("#F2F2F2"));

        circleDataSet = new PieDataSet(circleyVals,"");
        circleDataSet.setColors(circleColors);
        circleDataSet.setDrawValues(false);
        circleData = new PieData(circleDataSet);

        pieChart.setData(circleData);
    }

    private void expandAndAddInfoCardView(final CardView cardView){
        WindowManager windowManager = (WindowManager)context.getSystemService(context.WINDOW_SERVICE);
        DisplayMetrics dimension = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dimension);

        cardView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                minHeight = cardView.getHeight();
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                layoutParams.height = 1417;
                return true;
            }
        });
    }

    private void toggleCardViewnHeight(LinearLayout linearLayoutEstadoMetas, CardView cardView , PieChart pieChart , int porcentaje) {
        if (cardView.getHeight() < 1900) {
            linearLayoutEstadoMetas.setVisibility(View.VISIBLE);
            expandView(1900, cardView, pieChart, porcentaje);
        } else {
            linearLayoutEstadoMetas.setVisibility(View.GONE);
            collapseView(cardView);
        }
    }

    private void collapseView(final CardView cardView) {
        ValueAnimator anim = ValueAnimator.ofInt(cardView.getMeasuredHeightAndState(), minHeight);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                layoutParams.height = 1417;
                cardView.setLayoutParams(layoutParams);
            }
        });
        anim.start();
    }

    private void expandView(int height, final CardView cardView , PieChart pieChart , int porcentaje) {
        generarChart(porcentaje , pieChart,30f);
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

    public void adapterDataChange(ArrayList<Proyecto> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    private void showPoppupMetas(int proyecto, final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        View viewInflate = LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_metas_proyecto, null);

        TextView ngButtonContinue = viewInflate.findViewById(R.id.ngButtonContinue);
        RecyclerView recyclerViewMetas = viewInflate.findViewById(R.id.recyclerViewMetas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        adapterMetas = new AdapterMetas(new ArrayList<Meta>());
        recyclerViewMetas.setAdapter(adapterMetas);
        recyclerViewMetas.setLayoutManager(linearLayoutManager);

        getMetas(proyecto, viewInflate);

        ngButtonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        builder.setView(viewInflate);
        alertDialog = builder.create();
        alertDialog.show();
    }

    private void getMetas(int proyecto, final View view){
        Call<ArrayList<Meta>> call = serviceProyectos.getMetas(proyecto);
        call.enqueue(new Callback<ArrayList<Meta>>() {
            @Override
            public void onResponse(Call<ArrayList<Meta>> call, Response<ArrayList<Meta>> response) {
                if(response.isSuccessful() && !response.body().isEmpty()){
                    adapterMetas.adapterDataChange(response.body());
                }else{
                    Snackbar.make(view, "No se detectaron metas.", Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Meta>> call, Throwable t) {
                Snackbar.make(view, t.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
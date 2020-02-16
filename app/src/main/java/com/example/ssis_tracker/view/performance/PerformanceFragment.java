package com.example.ssis_tracker.view.performance;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.model.Performance;
import com.example.ssis_tracker.presenter.performance.PerformanceFragmentPresenter;
import com.example.ssis_tracker.presenter.performance.PerformanceFragmentPresenterImpl;
import java.util.ArrayList;

public class PerformanceFragment extends Fragment implements PerformanceFragmentView {

    private TextView textViewPorcentajeDes1,textViewPorcentajeDes2,textViewPorcentajeDes3,
                     textViewPorcentajeDes4,textViewPorcentajeDes5;
    private View view;
    private PerformanceFragmentPresenter performanceFragmentPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_performance, container, false);
        performanceFragmentPresenter = new PerformanceFragmentPresenterImpl(this);
        textViewPorcentajeDes1= this.view.findViewById(R.id.textViewPorcentajeDes1);
        textViewPorcentajeDes2= this.view.findViewById(R.id.textViewPorcentajeDes2);
        textViewPorcentajeDes3= this.view.findViewById(R.id.textViewPorcentajeDes3);
        textViewPorcentajeDes4= this.view.findViewById(R.id.textViewPorcentajeDes4);
        textViewPorcentajeDes5= this.view.findViewById(R.id.textViewPorcentajeDes5);

        super.onCreate(savedInstanceState);
        SolicitarDatosPerformance();
        return view;
    }

    public void animateTextView(final TextView textView, int count, final boolean showPercent){
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(0, count);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                if(showPercent){
                    textView.setText(String.valueOf(animation.getAnimatedValue())+"%");
                }else{
                    textView.setText(String.valueOf(animation.getAnimatedValue()));
                }
            }
        });
        animator.setEvaluator(new TypeEvaluator<Integer>() {
            public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                return Math.round(startValue + (endValue - startValue) * fraction);
            }
        });
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    public void SolicitarDatosPerformance() {
        this.performanceFragmentPresenter.SolicitarDatosPerformance();
    }

    @Override
    public void PresentarDatosPerformance(ArrayList<Performance> performances) {

        textViewPorcentajeDes1.setText(String.valueOf(  performances.get(0).getProcentaje() ));
        textViewPorcentajeDes2.setText(String.valueOf(  performances.get(1).getProcentaje() ));
        textViewPorcentajeDes3.setText(String.valueOf(  performances.get(2).getProcentaje() ));
        textViewPorcentajeDes4.setText(String.valueOf(  performances.get(3).getProcentaje() ));
        textViewPorcentajeDes5.setText(String.valueOf(  performances.get(4).getProcentaje() ));

        animateTextView(textViewPorcentajeDes1,performances.get(0).getProcentaje() ,false);
        animateTextView(textViewPorcentajeDes2,performances.get(1).getProcentaje() ,true);
        animateTextView(textViewPorcentajeDes3,performances.get(2).getProcentaje() ,false);
        animateTextView(textViewPorcentajeDes4,performances.get(3).getProcentaje() ,false);
        animateTextView(textViewPorcentajeDes5,performances.get(4).getProcentaje() ,false);
    }
}

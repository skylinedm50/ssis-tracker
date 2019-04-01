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

public class PerformanceFragment extends Fragment {

    private TextView textViewPorcentajeDes1,textViewPorcentajeDes2,textViewPorcentajeDes3,
            textViewPorcentajeDes4,textViewPorcentajeDes5,textViewPorcentajeDes6;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_performance, container, false);


        textViewPorcentajeDes1= this.view.findViewById(R.id.textViewPorcentajeDes1);
        textViewPorcentajeDes2= this.view.findViewById(R.id.textViewPorcentajeDes2);
        textViewPorcentajeDes3= this.view.findViewById(R.id.textViewPorcentajeDes3);
        textViewPorcentajeDes4= this.view.findViewById(R.id.textViewPorcentajeDes4);
        textViewPorcentajeDes5= this.view.findViewById(R.id.textViewPorcentajeDes5);
        textViewPorcentajeDes6= this.view.findViewById(R.id.textViewPorcentajeDes6);


            animateTextView(textViewPorcentajeDes1,90,false);
            animateTextView(textViewPorcentajeDes2,53,true);
            animateTextView(textViewPorcentajeDes3,69,true);
            animateTextView(textViewPorcentajeDes4,200,false);
            animateTextView(textViewPorcentajeDes5,15,false);
            animateTextView(textViewPorcentajeDes6,61,true);


        super.onCreate(savedInstanceState);
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
}

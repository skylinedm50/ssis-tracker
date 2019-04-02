package com.example.ssis_tracker.view.imagenesdocs;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.adapter.actividades.FragmentAdapterImageDocs;
import java.util.ArrayList;

public class ImagenesDocActivity extends AppCompatActivity {

    private ViewPager imagenesDocViewPager;
    private FragmentAdapterImageDocs viewPagerAdapter;
    private  ArrayList<String> arrayImagenes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagendocs);

        arrayImagenes = getIntent().getStringArrayListExtra("imagenes");
        this.imagenesDocViewPager = findViewById(R.id.viewPagerImgDocs);
        SetViewPager();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void SetViewPager(){
        viewPagerAdapter = new FragmentAdapterImageDocs(getSupportFragmentManager());
        for(int i = 0; i  < arrayImagenes.size(); i++) {
            viewPagerAdapter.AddFragment(ImagenesDocsFragment.NuevaInstancia(arrayImagenes.get(i)));
        }
        imagenesDocViewPager.setAdapter(viewPagerAdapter);
        imagenesDocViewPager.setCurrentItem(getIntent().getIntExtra("positionImg",0) );
    }


}

package com.example.ssis_tracker.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.ssis_tracker.R;
import com.example.ssis_tracker.view.direcciones.DireccionesFragment;

import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeActivityView {
    int itemIdSelect;
    DrawerLayout drawerLayout;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        constraintLayout = findViewById(R.id.constraintLayout);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void onBackPressed() {
        drawerLayout.cancelLongPress();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int itemId = item.getItemId();

        if(itemId != itemIdSelect) {
            if (itemId == R.id.nav_direcciones) {
                getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout, new DireccionesFragment()).addToBackStack(null).commit();
            } else if (itemId == R.id.nav_gallery) {

            } else if (itemId == R.id.nav_slideshow) {

            } else if (itemId == R.id.nav_manage) {

            } else if (itemId == R.id.nav_share) {

            } else if (itemId == R.id.nav_send) {

            }
            cleanFragmmentViewGroup();
        }

        itemIdSelect = itemId;
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void cleanFragmmentViewGroup() {
        List<android.support.v4.app.Fragment> fragmentsList = getSupportFragmentManager().getFragments();
        for(android.support.v4.app.Fragment fragment: fragmentsList){
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }
}
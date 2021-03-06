package com.example.taskapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;


import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import com.example.taskapp.ui.home.HomeFragment;

import com.example.taskapp.ui.onBoard.OnBoardActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {


    private AppBarConfiguration mAppBarConfiguration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isShown()) {
            startActivity(new Intent(this, OnBoardActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, FormActivity.class), 100);
            }
        });




        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View header=navigationView.getHeaderView(0);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);


            }
        });


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }
    private  boolean sort;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {


            case R.id.action_sort:
                if (sort) {
                    Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                    ((HomeFragment) navHostFragment.getChildFragmentManager().getFragments().get(0)).sortList();
                    sort = false;

                }





                else {
                    Fragment navHostFragment1 = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                    ((HomeFragment) navHostFragment1.getChildFragmentManager().getFragments().get(0)).initialList();

                    sort = true;
                }
                return true;






        }
        return super.onOptionsItemSelected(item); }



    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp(); }


              @Override
   protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       Fragment fragment = getSupportFragmentManager()

               .findFragmentById(R.id.nav_host_fragment);
        fragment.getChildFragmentManager().getFragments().get(0).onActivityResult(requestCode,resultCode,data); }



    public void exit_click(MenuItem item) {

        if (true) {
            this.finish();
        }
   if (true){

    SharedPreferences preferences=getSharedPreferences("settings",MODE_PRIVATE);
     preferences.edit().clear().apply();
   } }



    public  boolean isShown(){
    SharedPreferences sharedPreferences=getSharedPreferences("settings",MODE_PRIVATE);

    return sharedPreferences.getBoolean("isShown",false);

}













    // public void Buttock(View view) {
    //    startActivity(new Intent(this,ProfileActivity.class));
  //  }



}

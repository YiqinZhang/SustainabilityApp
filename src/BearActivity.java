package com.example.a327_prototype_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//Bear Activity
public class BearActivity extends AppCompatActivity {

    Button home_step, home_recycle;
    TextView textView_home_recycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bear);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        home_recycle = findViewById(R.id.button_home_recycle);
        home_step = findViewById(R.id.button_home_step);
        textView_home_recycle = findViewById(R.id.textView_home_recycle);






        home_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//click on home to start step counting activity
                Intent intent = new Intent(BearActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        home_recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//click on recycle to start recycle activity
                Intent intent = new Intent(BearActivity.this, RecycleActivity.class);
                startActivity(intent);
            }
        });





        bottomNavigationView.setSelectedItemId(R.id.bear);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.bear://bottom selection of bear, which stays in the same page
                        return true;
                    case R.id.home://bottom selection of home to Home Activity
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.setting://bottom selection of setting to Setting Activity
                        startActivity(new Intent(getApplicationContext(),SettingActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.recycle://bottom selection of recycle to Recycle Activity
                        startActivity(new Intent(getApplicationContext(),RecycleActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
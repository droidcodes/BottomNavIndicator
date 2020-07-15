package com.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    TextView textTabName;
    View notificationIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        textTabName = findViewById(R.id.text_tab_name);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        showNotificationIndicator();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_home:

                textTabName.setText(item.getTitle());

                break;

            case R.id.menu_dashboard:

                textTabName.setText(item.getTitle());

                break;

            case R.id.menu_notifications:

                textTabName.setText(item.getTitle());
                if(notificationIndicator!=null){
                    if(notificationIndicator.getVisibility()==View.VISIBLE){
                        notificationIndicator.setVisibility(View.GONE);
                    }
                }

                break;

        }


        return true;
    }

    private void showNotificationIndicator(){

        BottomNavigationItemView itemView = bottomNavigationView.findViewById(R.id.menu_notifications);

        notificationIndicator = LayoutInflater.from(this).inflate(R.layout.layout_indicator,bottomNavigationView,false);
        notificationIndicator.setVisibility(View.VISIBLE);

        itemView.addView(notificationIndicator);


    }

}

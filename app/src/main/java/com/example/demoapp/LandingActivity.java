package com.example.demoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ActionBar actionBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            actionBar = getSupportActionBar();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    actionBar.setTitle("Home");
                    selectedFragment = new HomeFragment();
                    break;
                    //return true;
                case R.id.navigation_search:
                    actionBar.setTitle("Search");
                    selectedFragment = new SearchFragment();
                    break;
                    //return true;
                case R.id.navigation_cart:
                    actionBar.setTitle("Cart");
                    selectedFragment = new CartFragment();
                    break;
                    //return true;
                case R.id.navigation_profile:
                    actionBar.setTitle("Profile");
                    selectedFragment = new ProfileFragment();
                    break;
                    //return true;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return  true;
            //return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportActionBar().setTitle("Home");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

}

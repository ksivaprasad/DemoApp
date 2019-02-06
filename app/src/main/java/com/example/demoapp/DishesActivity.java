package com.example.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.SearchView;

import com.example.demoapp.model.Dishes;

import java.util.ArrayList;
import java.util.List;

public class DishesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DishAdapter dishAdapter;
    List<Dishes> dishesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getIntent().getStringExtra("title"));

        dishesList = new ArrayList<>();
        recyclerView = findViewById(R.id.id_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dishesList.add(new Dishes(
                "Chicken Biriyani",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Mutton Biriyani",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Beef Biriyani",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Fish Biriyani",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Veg Biriyani",
                "100",
                R.drawable.vegitarian
        ));
        dishesList.add(new Dishes(
                "Al fahm",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Kuzhimandi",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Shawaya",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Porotta",
                "10",
                R.drawable.vegitarian
        ));
        dishesList.add(new Dishes(
                "Chappathi",
                "10",
                R.drawable.vegitarian
        ));
        dishesList.add(new Dishes(
                "Kubbus",
                "100",
                R.drawable.vegitarian
        ));
        dishesList.add(new Dishes(
                "Dish 8",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Fish Fry",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Chicken Fry",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Chicken Roast",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Beef Roast",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Chicken Noodle",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Veg Noodle",
                "100",
                R.drawable.vegitarian
        ));
        dishesList.add(new Dishes(
                "Chicken Fried rice",
                "100",
                R.drawable.nonveg
        ));
        dishesList.add(new Dishes(
                "Veg Fried rice",
                "100",
                R.drawable.vegitarian
        ));
        dishesList.add(new Dishes(
                "Masala dhosha",
                "100",
                R.drawable.vegitarian
        ));
        dishesList.add(new Dishes(
                "Ghee Roast",
                "100",
                R.drawable.vegitarian
        ));
        dishAdapter = new DishAdapter(this, dishesList);
        recyclerView.setAdapter(dishAdapter);


        //Toast.makeText(this, dishesList.size(), Toast.LENGTH_SHORT).show();
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.id_menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                s = s.toLowerCase();
                List<Dishes> filteredList = new ArrayList<>();
                for ( Dishes dishes: dishesList ) {
                    if ( (dishes.getName().toLowerCase()).contains(s) ) {
                        filteredList.add(dishes);
                    }
                }
                dishAdapter.setFilter(filteredList);
                return true;
            }
        });
        return true;
    }
}

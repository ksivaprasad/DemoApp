package com.example.demoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import com.example.demoapp.model.Hotels;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    RecyclerView recyclerView;
    SearchAdapter searchAdapter;

    List<Hotels> hotelsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        hotelsList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.id_recycler_view_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        hotelsList.add(new Hotels(
                "Le Arabia",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Halais",
                "Description",
                "10 - 15 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Al Baike",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Al Saj",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Ambrosia",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Ajwa",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Dhaba Project",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Terrace",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Cricket Shack",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Dhe Kozhikkodan",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Sharavanabhavan",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Dominos",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Poomaram",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Dhaba Project",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Arabian Tasty Cafe",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Turf",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Arabic Paradice",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        searchAdapter = new SearchAdapter(getContext(), hotelsList);
        recyclerView.setAdapter(searchAdapter);


        final TextView textViewRecent = view.findViewById(R.id.id_recent);
        EditText editText = view.findViewById(R.id.id_editText_search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = s.toString();
                List<Hotels> filteredList = new ArrayList<>();
                if (searchText != null && !searchText.equals("")){
                    textViewRecent.setVisibility(View.INVISIBLE);
                    for ( Hotels hotels: hotelsList ) {
                        if ( (hotels.getTitle().toLowerCase()).contains(searchText) ) {
                            filteredList.add(hotels);
                        }
                    }
                }
                else {
                    textViewRecent.setVisibility(View.VISIBLE);
                }
                searchAdapter.setFilter(filteredList);
            }
        });

        return view;
    }





}


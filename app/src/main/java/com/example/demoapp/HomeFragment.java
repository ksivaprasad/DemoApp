package com.example.demoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.demoapp.model.Hotels;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeActivity";
    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;
    private LinearLayout dotsLayout;
    private int customPostion = 0;

    RecyclerView recyclerView;
    HotelAdapter hotelAdapter;

    List<Hotels> hotelsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.id_img_slider);
        dotsLayout = view.findViewById(R.id.id_slider_dot);

        viewPageAdapter = new ViewPageAdapter(getContext());
        viewPager.setAdapter(viewPageAdapter);
        prepareDots(customPostion++);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                prepareDots(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        hotelsList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.id_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        hotelsList.add(new Hotels(
                "Hotel Name 1  grt gre re ter re tre tret er tre tertertrtre ter Hotel Name 1  grt gre re ter re tre tret er tre tertertrtre ter Hotel Name 1  grt gre re ter re tre tret er tre tertertrtre ter",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Hotel Name 2",
                "Description",
                "10 - 15 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Hotel Name 3",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelsList.add(new Hotels(
                "Hotel Name 4",
                "Description",
                "10 mins",
                4.5f,
                R.drawable.food));
        hotelAdapter = new HotelAdapter(getContext(), hotelsList);
        recyclerView.setAdapter(hotelAdapter);
        return view;
    }


    private void prepareDots(int customSlidePostion){
        if(dotsLayout.getChildCount() > 0){
            dotsLayout.removeAllViews();
        }
        ImageView dots[] = new ImageView[viewPageAdapter.getCount()];

        for(int i = 0; i < viewPageAdapter.getCount(); i++){
            dots[i] = new ImageView(getContext());
            if(i == customSlidePostion){
                dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.inactive_dot));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4, 0, 4, 0);
            dotsLayout.addView(dots[i], layoutParams);
        }
    }
}

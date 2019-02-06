package com.example.demoapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demoapp.model.Hotels;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.TestViewHolder> {

    private Context context;
    private List<Hotels> hotelsList;
    //private LandingActivity landingActivity;

    public SearchAdapter(Context context, List<Hotels> hotelsList) {
        this.context = context;
        this.hotelsList = new ArrayList<>();
        //landingActivity = (LandingActivity) context;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.search_item_layout, null);
        return new TestViewHolder(view, context, hotelsList);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder hotelViewHolder, int i) {
        Hotels hotels = hotelsList.get(i);

        hotelViewHolder.title.setText(hotels.getTitle());
        hotelViewHolder.description.setText(hotels.getDescription());
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }

    public void setFilter(List<Hotels> list) {
        hotelsList = new ArrayList<>();
        hotelsList.addAll(list);
        notifyDataSetChanged();
    }

    class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        TextView description;

        List<Hotels> list;
        Context ctx;

        public TestViewHolder(@NonNull View itemView, Context ctx, List<Hotels> list) {
            super(itemView);
            this.ctx = ctx;
            this.list = list;
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.id_hotel_name);
            description = itemView.findViewById(R.id.id_food_type);
        }

        @Override
        public void onClick(View v) {

            //landingActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoadingPage()).commit();
            int position = getAdapterPosition();
            Hotels hotels = this.list.get(position);
            Intent intent = new Intent(this.ctx, DishesActivity.class);
            intent.putExtra("title", hotels.getTitle());
            this.ctx.startActivity(intent);
        }
    }
}

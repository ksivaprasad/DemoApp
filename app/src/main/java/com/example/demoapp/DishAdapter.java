package com.example.demoapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoapp.model.Dishes;
import com.example.demoapp.model.Hotels;

import java.util.ArrayList;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    private Context context;
    private List<Dishes> dishList;

    public DishAdapter(Context context, List<Dishes> dishList) {
        this.context = context;
        this.dishList = dishList;
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dish_list_layout, null);
        return new DishViewHolder(view, context, dishList);
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder hotelViewHolder, int i) {
        Dishes dishes = dishList.get(i);

        hotelViewHolder.name.setText(dishes.getName());
        hotelViewHolder.price.setText(dishes.getPrice());
        hotelViewHolder.imageView.setImageDrawable(context.getResources().getDrawable(dishes.getImage()));
    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }

    public void setFilter(List<Dishes> list) {
        dishList = new ArrayList<>();
        dishList.addAll(list);
        notifyDataSetChanged();
    }

    class DishViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView name;
        TextView price;

        List<Dishes> list;
        Context ctx;

        public DishViewHolder(@NonNull View itemView, Context ctx, List<Dishes> list) {
            super(itemView);
            this.ctx = ctx;
            this.list = list;
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.id_dish_tag_icon);
            name = itemView.findViewById(R.id.id_dish_name);
            price = itemView.findViewById(R.id.id_dish_price);
        }

        @Override
        public void onClick(View v) {

            //landingActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoadingPage()).commit();
            int position = getAdapterPosition();
            Dishes dishes = this.list.get(position);
            Intent intent = new Intent(this.ctx, CartActivity.class);
            intent.putExtra("name", dishes.getName());
            this.ctx.startActivity(intent);
        }
    }
}

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

import com.example.demoapp.model.Hotels;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private Context context;
    private List<Hotels> hotelsList;
    //private LandingActivity landingActivity;

    public HotelAdapter(Context context, List<Hotels> hotelsList) {
        this.context = context;
        this.hotelsList = hotelsList;
        //landingActivity = (LandingActivity) context;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hotels_card_layout, null);
        return new HotelViewHolder(view, context, hotelsList);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i) {
        Hotels hotels = hotelsList.get(i);

        hotelViewHolder.title.setText(hotels.getTitle());
        hotelViewHolder.description.setText(hotels.getDescription());
        hotelViewHolder.time.setText(hotels.getTime());
        hotelViewHolder.rating.setText(String.valueOf(hotels.getRating()));
        hotelViewHolder.imageView.setImageDrawable(context.getResources().getDrawable(hotels.getImage()));
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }

    class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView title;
        TextView description;
        TextView time;
        TextView rating;

        List<Hotels> list;
        Context ctx;

        public HotelViewHolder(@NonNull View itemView, Context ctx, List<Hotels> list) {
            super(itemView);
            this.ctx = ctx;
            this.list = list;
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textViewTitle);
            description = itemView.findViewById(R.id.textViewShortDesc);
            time = itemView.findViewById(R.id.textViewTime);
            rating = itemView.findViewById(R.id.textViewRating);
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

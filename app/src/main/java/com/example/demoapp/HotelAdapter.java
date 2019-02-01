package com.example.demoapp;

import android.content.Context;
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

    public HotelAdapter(Context context, List<Hotels> hotelsList) {
        this.context = context;
        this.hotelsList = hotelsList;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hotels_card_layout, null);
        return new HotelViewHolder(view);
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

    class HotelViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title;
        TextView description;
        TextView time;
        TextView rating;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textViewTitle);
            description = itemView.findViewById(R.id.textViewShortDesc);
            time = itemView.findViewById(R.id.textViewTime);
            rating = itemView.findViewById(R.id.textViewRating);
        }
    }
}

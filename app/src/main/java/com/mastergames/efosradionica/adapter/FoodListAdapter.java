/*
 * Copyright (c) 2019. Matej Arlović
 * Sva prava pridržana.
 */

package com.mastergames.efosradionica.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mastergames.efosradionica.R;
import com.mastergames.efosradionica.models.Food;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodListAdapter extends ArrayAdapter<Food>
{
    /**
     * FoodListAdapter constructor.
     * @param context Application activity context.
     * @param foods ArrayList of available food inside application.
     */
    public FoodListAdapter(@NonNull Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.order_list_item, parent, false);
        }

        Food food = getItem(position);
        TextView foodTitle = convertView.findViewById(R.id.foodTitle);
        RatingBar foodRating = convertView.findViewById(R.id.foodRating);
        TextView foodType = convertView.findViewById(R.id.foodType);
        ImageView foodImage = convertView.findViewById(R.id.foodImage);
        TextView foodPrice = convertView.findViewById(R.id.priceText);
        TextView foodDeliveryTime = convertView.findViewById(R.id.deliveryText);

        foodTitle.setText(food.getName());
        foodRating.setRating(food.getRating());
        foodType.setText(food.getType());
        foodImage.setImageDrawable(food.getImage());
        foodPrice.setText(String.format("Cijena: %.2fkn", food.getPrice()));
        foodDeliveryTime.setText(String.format("%d min", food.getDeliveryTime()));
        return convertView;
    }
}

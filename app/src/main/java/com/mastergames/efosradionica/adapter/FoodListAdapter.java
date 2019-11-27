/*
 * Copyright (c) 2019. Matej Arlović
 * Sva prava pridržana.
 */

package com.mastergames.efosradionica.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mastergames.efosradionica.CheckoutActivity;
import com.mastergames.efosradionica.R;
import com.mastergames.efosradionica.models.Food;

import org.w3c.dom.Text;

import java.io.Serializable;
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

        // Get Information From Model For Given Item
        final Food food = getItem(position);

        // Get Items From Activity Frontend
        TextView foodTitle = convertView.findViewById(R.id.foodTitle);
        RatingBar foodRating = convertView.findViewById(R.id.foodRating);
        TextView foodType = convertView.findViewById(R.id.foodType);
        ImageView foodImage = convertView.findViewById(R.id.foodImage);
        TextView foodPrice = convertView.findViewById(R.id.priceText);
        TextView foodDeliveryTime = convertView.findViewById(R.id.deliveryText);
        Button foodBuyButton = convertView.findViewById(R.id.foodBuy);

        // Set Information From Food Model
        foodTitle.setText(food.getName());
        foodRating.setRating(food.getRating());
        foodType.setText(food.getType());
        foodImage.setImageDrawable(getContext().getDrawable(food.getImage()));
        foodPrice.setText(String.format("%.2fkn", food.getPrice()));
        foodDeliveryTime.setText(String.format("%d min", food.getDeliveryTime()));

        // Handle Order Button
        foodBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage(String.format("Želite li naručiti \"%s\"?", food.getName()))
                        .setPositiveButton(R.string.app_yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getContext(), CheckoutActivity.class);
                                intent.putExtra("order", food);
                                getContext().startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.app_no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
        return convertView;
    }
}

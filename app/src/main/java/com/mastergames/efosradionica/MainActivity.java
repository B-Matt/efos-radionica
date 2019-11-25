/*
 * Copyright (c) 2019. Matej Arlović
 * Sva prava pridržana.
 */

package com.mastergames.efosradionica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.mastergames.efosradionica.adapter.FoodListAdapter;
import com.mastergames.efosradionica.models.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Populates Food List
        ArrayList<Food> foodArray = new ArrayList<>();
        foodArray.add(new Food("Ćevapi", 5.0f, "Roštilj", getDrawable(R.drawable.ic_cevapi), 39.25f, 40));
        foodArray.add(new Food("Miješano meso", 4.2f, "Roštilj", getDrawable(R.drawable.ic_mjesano_meso), 68f, 45));
        foodArray.add(new Food("Gurmanska pljeskavica", 3.8f, "Roštilj", getDrawable(R.drawable.ic_pljeskavice), 52f, 45));
        foodArray.add(new Food("Fiš", 4.6f, "Kuhano", getDrawable(R.drawable.ic_fis), 96f, 60));
        foodArray.add(new Food("Čobanac", 4.3f, "Kuhano", getDrawable(R.drawable.ic_cobanac), 48f, 60));
        foodArray.add(new Food("Palačinke", 4.0f, "Desert", getDrawable(R.drawable.ic_palacinke), 20f, 25));

        // Initializes Food List
        FoodListAdapter adapter = new FoodListAdapter(this, foodArray);
        ListView listView = findViewById(R.id.foodOrderList);
        listView.setAdapter(adapter);
    }
}

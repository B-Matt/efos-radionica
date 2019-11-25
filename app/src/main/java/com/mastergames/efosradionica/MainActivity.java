/*
 * Copyright (c) 2019. Matej Arlović
 * Sva prava pridržana.
 */

package com.mastergames.efosradionica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.mastergames.efosradionica.adapter.FoodListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

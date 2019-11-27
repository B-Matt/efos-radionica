/*
 * Copyright (c) 2019. Matej Arlović
 * Sva prava pridržana.
 */

package com.mastergames.efosradionica;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.mastergames.efosradionica.models.Food;

import java.util.concurrent.TimeUnit;

public class CheckoutActivity extends AppCompatActivity
{
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Get Information From Model For Given Order
        Food order = (Food) getIntent().getSerializableExtra("order");

        // Get Items From Activity Frontend
        TextView mInfoText = findViewById(R.id.infoText);
        final TextView mDeliveryTimeText = findViewById(R.id.deliveryTimeText);
        TextView mPriceText = findViewById(R.id.priceText);

        // Set Information From Food Model
        mInfoText.setText(Html.fromHtml(String.format("Izdržite još samo malo!<br>Vaša narudžba(<b>%s</b>) dolazi za otprilike:", order.getName())));
        mDeliveryTimeText.setText(String.format("%2d:00", order.getDeliveryTime()));
        mPriceText.setText(Html.fromHtml(String.format("Narudžba će iznositi: <i>%.2fkn</i>", order.getPrice())));

        // Starts Delivery Timer
        new CountDownTimer(TimeUnit.MINUTES.toMillis(order.getDeliveryTime()), 1000)
        {
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                mDeliveryTimeText.setText(String.format("%02d:%02d", minutes, seconds));
            }
            public void onFinish() {

            }
        }.start();
    }
}

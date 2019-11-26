/*
 * Copyright (c) 2019. Matej Arlović
 * Sva prava pridržana.
 */

package com.mastergames.efosradionica.models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Food implements Serializable
{
    private String name;
    private Float rating;
    private String type;
    private Integer image;
    private Float price;
    private Integer deliveryTime;

    public Food(String name, Float rating, String type, Integer image, Float price, Integer deliveryTime)
    {
        this.name = name;
        this.rating = rating;
        this.type = type;
        this.image = image;
        this.price = price;
        this.deliveryTime = deliveryTime;
    }

    /**
     * Gets food name
     * @return name
     */
    public String getName() {
        if(name == null)
        {
            return "";
        }
        return name;
    }

    /**
     * Gets food rating.
     * @return rating
     */
    public Float getRating() {
        return rating;
    }

    /**
     * Gets food type.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets food image (16:9).
     * @return BitmapDrawable Index.
     */
    public Integer getImage() {
        return image;
    }

    /**
     * Gets food price.
     * @return price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Gets food delivery time.
     * @return delivery time.
     */
    public Integer getDeliveryTime() {
        return deliveryTime;
    }
}

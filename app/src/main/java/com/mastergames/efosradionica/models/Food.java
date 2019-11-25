/*
 * Copyright (c) 2019. Matej Arlović
 * Sva prava pridržana.
 */

package com.mastergames.efosradionica.models;

public class Food
{
    private String name;
    private Float rating;
    private String type;
    private Float price;
    private Float deliveryTime;

    public Food(String name, Float rating, String type, Float price, Float deliveryTime)
    {
        this.name = name;
        this.rating = rating;
        this.type = type;
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
    public Float getDeliveryTime() {
        return deliveryTime;
    }
}

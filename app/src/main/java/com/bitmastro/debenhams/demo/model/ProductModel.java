/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.model;

import com.bitmastro.debenhams.demo.product.ProductCursor;
import com.google.gson.annotations.SerializedName;

/**
 * Model object for the {@code product}.
 */
public class ProductModel {
    @SerializedName("prodnum")
    public String prodnum;
    @SerializedName("brand")
    public String brand;
    @SerializedName("name")
    public String name;
    @SerializedName("minGBP")
    public String mingbp;
    @SerializedName("maxGBP")
    public String maxgbp;
    @SerializedName("minGBP_was")
    public String mingbpWas;
    @SerializedName("maxGBP_was")
    public String maxgbpWas;
    @SerializedName("img")
    public String img;
    @SerializedName("sizes")
    public String sizes;
    @SerializedName("colours")
    public String colours;
    @SerializedName("category")
    public String category;
    @SerializedName("noImg")
    public Integer noimg;
    @SerializedName("Rating")
    public String rating;
    @SerializedName("rating_number")
    public Integer ratingNumber;
    @SerializedName("Style")
    public String style;
    @SerializedName("Length")
    public String length;
    @SerializedName("Sleeve length")
    public String sleeve;

    public ProductModel() {
    }

    public ProductModel(ProductCursor cursor) {
        this.prodnum = cursor.getProdnum();
        this.brand = cursor.getBrand();
        this.name = cursor.getName();
        this.mingbp = cursor.getMingbp();
        this.maxgbp = cursor.getMaxgbp();
        this.mingbpWas = cursor.getMingbpWas();
        this.maxgbpWas = cursor.getMaxgbpWas();
        this.img = cursor.getImg();
        this.sizes = cursor.getSizes();
        this.colours = cursor.getColours();
        this.category = cursor.getCategory();
        this.noimg = cursor.getNoimg();
        this.rating = cursor.getRating();
        this.ratingNumber = cursor.getRatingNumber();
        this.style = cursor.getStyle();
        this.length = cursor.getLength();
        this.sleeve = cursor.getSleeve();
    }
}
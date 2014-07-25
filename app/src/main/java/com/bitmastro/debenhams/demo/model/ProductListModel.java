package com.bitmastro.debenhams.demo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by francescoc on 25/07/14.
 */
public class ProductListModel {
    public List<ProductModel> getProducts() {
        return products;
    }

    @SerializedName("Products")
    public List<ProductModel> products;
}

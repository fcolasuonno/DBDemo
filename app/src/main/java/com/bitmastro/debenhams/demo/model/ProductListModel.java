package com.bitmastro.debenhams.demo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductListModel {
    @SerializedName("Products")
    public List<ProductModel> products;

    public List<ProductModel> getProducts() {
        return products;
    }
}

package com.bitmastro.debenhams.demo.api;

import com.bitmastro.debenhams.demo.model.ProductListModel;

import retrofit.http.GET;

public interface RestService {
    @GET("/productLists/json/Women_Dresses_Day-dresses.json")
    ProductListModel listProduct(
    );
}
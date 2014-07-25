package com.bitmastro.debenhams.demo.api;

import com.bitmastro.debenhams.demo.model.ProductListModel;
import com.bitmastro.debenhams.demo.model.ProductModel;
import java.util.List;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface RestService{
    @GET("/productLists/json/Women_Dresses_Day-dresses.json")
    ProductListModel listProduct(
        );
}
package com.bitmastro.debenhams.demo.api;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import com.bitmastro.debenhams.demo.model.ProductModel;
import com.bitmastro.debenhams.demo.product.ProductColumns;
import com.bitmastro.debenhams.demo.product.ProductContentValues;
import com.bitmastro.debenhams.demo.DebenhamsProvider;
import retrofit.RestAdapter;

public class ApiService extends IntentService {
    public static final String API_TYPE = "api_type";
    public static final int PRODUCT = 0;

    RestService service;

    public ApiService() {
        super("Api Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://retailtwo.nn4m.co.uk/DB/sv4")
            .build();
        service = restAdapter.create(RestService.class);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        switch(intent.getExtras().getInt(API_TYPE)){
            case PRODUCT:
                getProductFromApi(intent.getExtras());
                break;
        }
    }

    private void getProductFromApi(Bundle intent){
        List<ProductModel> items = service.listProduct().getProducts();
        //getContentResolver().bulkInsert(ProductColumns.CONTENT_URI, ProductContentValues.getContentValues(items.toArray(new ProductModel[items.size()])));
        getContentResolver().bulkInsert(DebenhamsProvider.selection(ProductColumns.CONTENT_URI,ProductColumns.PRODNUM), ProductContentValues.getContentValues(items.toArray(new ProductModel[items.size()])));
    }
}
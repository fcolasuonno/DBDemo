package com.bitmastro.debenhams.demo.api;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bitmastro.debenhams.demo.DebenhamsProvider;
import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.model.ProductModel;
import com.bitmastro.debenhams.demo.product.ProductColumns;
import com.bitmastro.debenhams.demo.product.ProductContentValues;

import org.androidannotations.annotations.EService;
import org.androidannotations.annotations.UiThread;

import java.util.List;

import retrofit.RestAdapter;

@EService
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
        switch (intent.getExtras().getInt(API_TYPE)) {
            case PRODUCT:
                getProductFromApi(intent.getExtras());
                break;
            default:
                showToast(getString(R.string.unrecognized_request));
        }
    }

    private void getProductFromApi(Bundle intent) {
        try {
            List<ProductModel> items = service.listProduct().getProducts();
            //getContentResolver().bulkInsert(ProductColumns.CONTENT_URI, ProductContentValues.getContentValues(items.toArray(new ProductModel[items.size()])));
            getContentResolver().bulkInsert(DebenhamsProvider.selection(ProductColumns.CONTENT_URI, ProductColumns.PRODNUM), ProductContentValues.getContentValues(items.toArray(new ProductModel[items.size()])));
        } catch (Exception e) {
            showToast(getString(R.string.no_endpoint_connection));
        }
    }

    @UiThread
    void showToast(String string) {
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_LONG).show();
    }
}
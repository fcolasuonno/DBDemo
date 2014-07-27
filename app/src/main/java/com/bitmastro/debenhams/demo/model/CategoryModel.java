package com.bitmastro.debenhams.demo.model;

import android.net.Uri;

public class CategoryModel {
    private String mainCategory;
    private String category;
    private int drawable;
    private Uri contentUri;

    public CategoryModel(String pMainCategory, String categoryName, int dresses, Uri contentUri) {
        this.mainCategory = pMainCategory;
        this.category = categoryName;
        this.drawable = dresses;
        this.contentUri = contentUri;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public String getCategory() {
        return category;
    }

    public int getDrawable() {
        return drawable;
    }

    public Uri getContentUri() {
        return contentUri;
    }
}

package com.bitmastro.debenhams.demo.model;

public class CategoryModel {
    private String mainCategory;
    private String category;
    private int drawable;


    private int apiContent;

    public CategoryModel(String pMainCategory, String categoryName, int dresses, int content) {
        this.mainCategory = pMainCategory;
        this.category = categoryName;
        this.drawable = dresses;
        this.apiContent = content;
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

    public int getApiContent() {
        return apiContent;
    }
}

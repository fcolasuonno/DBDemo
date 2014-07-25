/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.product;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

import com.bitmastro.debenhams.demo.base.AbstractContentValues;
import com.bitmastro.debenhams.demo.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Content values wrapper for the {@code product} table.
 */
public class ProductContentValues extends AbstractContentValues {
    public static ContentValues[] getContentValues(ProductModel... items) {
        List<ContentValues> values = new ArrayList<ContentValues>();
        for (ProductModel item : items) {
            values.add(getSingleContentValue(item));
        }
        return values.toArray(new ContentValues[values.size()]);
    }

    public static ContentValues getSingleContentValue(ProductModel item) {
        ProductContentValues values = new ProductContentValues();
        values.putProdnum(item.prodnum);
        values.putBrand(item.brand);
        values.putName(item.name);
        values.putMingbp(item.mingbp);
        values.putMaxgbp(item.maxgbp);
        values.putMingbpWas(item.mingbpWas);
        values.putMaxgbpWas(item.maxgbpWas);
        values.putImg(item.img);
        values.putSizes(item.sizes);
        values.putColours(item.colours);
        values.putCategory(item.category);
        values.putNoimg(item.noimg);
        values.putRating(item.rating);
        values.putRatingNumber(item.ratingNumber);
        values.putStyle(item.style);
        values.putLength(item.length);
        values.putSleeve(item.sleeve);
        return values.values();
    }

    @Override
    public Uri uri() {
        return ProductColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where           The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, ProductSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public ProductContentValues putProdnum(String value) {
        mContentValues.put(ProductColumns.PRODNUM, value);
        return this;
    }

    public ProductContentValues putProdnumNull() {
        mContentValues.putNull(ProductColumns.PRODNUM);
        return this;
    }

    public ProductContentValues putBrand(String value) {
        mContentValues.put(ProductColumns.BRAND, value);
        return this;
    }

    public ProductContentValues putBrandNull() {
        mContentValues.putNull(ProductColumns.BRAND);
        return this;
    }

    public ProductContentValues putName(String value) {
        mContentValues.put(ProductColumns.NAME, value);
        return this;
    }

    public ProductContentValues putNameNull() {
        mContentValues.putNull(ProductColumns.NAME);
        return this;
    }

    public ProductContentValues putMingbp(String value) {
        mContentValues.put(ProductColumns.MINGBP, value);
        return this;
    }

    public ProductContentValues putMingbpNull() {
        mContentValues.putNull(ProductColumns.MINGBP);
        return this;
    }

    public ProductContentValues putMaxgbp(String value) {
        mContentValues.put(ProductColumns.MAXGBP, value);
        return this;
    }

    public ProductContentValues putMaxgbpNull() {
        mContentValues.putNull(ProductColumns.MAXGBP);
        return this;
    }

    public ProductContentValues putMingbpWas(String value) {
        mContentValues.put(ProductColumns.MINGBP_WAS, value);
        return this;
    }

    public ProductContentValues putMingbpWasNull() {
        mContentValues.putNull(ProductColumns.MINGBP_WAS);
        return this;
    }

    public ProductContentValues putMaxgbpWas(String value) {
        mContentValues.put(ProductColumns.MAXGBP_WAS, value);
        return this;
    }

    public ProductContentValues putMaxgbpWasNull() {
        mContentValues.putNull(ProductColumns.MAXGBP_WAS);
        return this;
    }

    public ProductContentValues putImg(String value) {
        mContentValues.put(ProductColumns.IMG, value);
        return this;
    }

    public ProductContentValues putImgNull() {
        mContentValues.putNull(ProductColumns.IMG);
        return this;
    }

    public ProductContentValues putSizes(String value) {
        mContentValues.put(ProductColumns.SIZES, value);
        return this;
    }

    public ProductContentValues putSizesNull() {
        mContentValues.putNull(ProductColumns.SIZES);
        return this;
    }

    public ProductContentValues putColours(String value) {
        mContentValues.put(ProductColumns.COLOURS, value);
        return this;
    }

    public ProductContentValues putColoursNull() {
        mContentValues.putNull(ProductColumns.COLOURS);
        return this;
    }

    public ProductContentValues putCategory(String value) {
        mContentValues.put(ProductColumns.CATEGORY, value);
        return this;
    }

    public ProductContentValues putCategoryNull() {
        mContentValues.putNull(ProductColumns.CATEGORY);
        return this;
    }

    public ProductContentValues putNoimg(Integer value) {
        mContentValues.put(ProductColumns.NOIMG, value);
        return this;
    }

    public ProductContentValues putNoimgNull() {
        mContentValues.putNull(ProductColumns.NOIMG);
        return this;
    }

    public ProductContentValues putRating(String value) {
        mContentValues.put(ProductColumns.RATING, value);
        return this;
    }

    public ProductContentValues putRatingNull() {
        mContentValues.putNull(ProductColumns.RATING);
        return this;
    }

    public ProductContentValues putRatingNumber(Integer value) {
        mContentValues.put(ProductColumns.RATING_NUMBER, value);
        return this;
    }

    public ProductContentValues putRatingNumberNull() {
        mContentValues.putNull(ProductColumns.RATING_NUMBER);
        return this;
    }

    public ProductContentValues putStyle(String value) {
        mContentValues.put(ProductColumns.STYLE, value);
        return this;
    }

    public ProductContentValues putStyleNull() {
        mContentValues.putNull(ProductColumns.STYLE);
        return this;
    }

    public ProductContentValues putLength(String value) {
        mContentValues.put(ProductColumns.LENGTH, value);
        return this;
    }

    public ProductContentValues putLengthNull() {
        mContentValues.putNull(ProductColumns.LENGTH);
        return this;
    }

    public ProductContentValues putSleeve(String value) {
        mContentValues.put(ProductColumns.SLEEVE, value);
        return this;
    }

    public ProductContentValues putSleeveNull() {
        mContentValues.putNull(ProductColumns.SLEEVE);
        return this;
    }
}

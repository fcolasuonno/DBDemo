/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.product;

import android.database.Cursor;

import com.bitmastro.debenhams.demo.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code product} table.
 */
public class ProductCursor extends AbstractCursor {
    public ProductCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Get the {@code prodnum} value.
     * Can be {@code null}.
     */
    public String getProdnum() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.PRODNUM);
        return getString(index);
    }

    /**
     * Get the {@code brand} value.
     * Can be {@code null}.
     */
    public String getBrand() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.BRAND);
        return getString(index);
    }

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    public String getName() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.NAME);
        return getString(index);
    }

    /**
     * Get the {@code mingbp} value.
     * Can be {@code null}.
     */
    public String getMingbp() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.MINGBP);
        return getString(index);
    }

    /**
     * Get the {@code maxgbp} value.
     * Can be {@code null}.
     */
    public String getMaxgbp() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.MAXGBP);
        return getString(index);
    }

    /**
     * Get the {@code mingbp_was} value.
     * Can be {@code null}.
     */
    public String getMingbpWas() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.MINGBP_WAS);
        return getString(index);
    }

    /**
     * Get the {@code maxgbp_was} value.
     * Can be {@code null}.
     */
    public String getMaxgbpWas() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.MAXGBP_WAS);
        return getString(index);
    }

    /**
     * Get the {@code img} value.
     * Can be {@code null}.
     */
    public String getImg() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.IMG);
        return getString(index);
    }

    /**
     * Get the {@code sizes} value.
     * Can be {@code null}.
     */
    public String getSizes() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.SIZES);
        return getString(index);
    }

    /**
     * Get the {@code colours} value.
     * Can be {@code null}.
     */
    public String getColours() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.COLOURS);
        return getString(index);
    }

    /**
     * Get the {@code category} value.
     * Can be {@code null}.
     */
    public String getCategory() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.CATEGORY);
        return getString(index);
    }

    /**
     * Get the {@code noimg} value.
     * Can be {@code null}.
     */
    public Integer getNoimg() {
        return getIntegerOrNull(ProductColumns.NOIMG);
    }

    /**
     * Get the {@code rating} value.
     * Can be {@code null}.
     */
    public String getRating() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.RATING);
        return getString(index);
    }

    /**
     * Get the {@code rating_number} value.
     * Can be {@code null}.
     */
    public Integer getRatingNumber() {
        return getIntegerOrNull(ProductColumns.RATING_NUMBER);
    }

    /**
     * Get the {@code style} value.
     * Can be {@code null}.
     */
    public String getStyle() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.STYLE);
        return getString(index);
    }

    /**
     * Get the {@code length} value.
     * Can be {@code null}.
     */
    public String getLength() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.LENGTH);
        return getString(index);
    }

    /**
     * Get the {@code sleeve} value.
     * Can be {@code null}.
     */
    public String getSleeve() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.SLEEVE);
        return getString(index);
    }
}

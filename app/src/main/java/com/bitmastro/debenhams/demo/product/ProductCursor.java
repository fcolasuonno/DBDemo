/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.product;

import java.util.Date;

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
     * Get the {@code first_name} value.
     * Can be {@code null}.
     */
    public String getFirstName() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.FIRST_NAME);
        return getString(index);
    }

    /**
     * Get the {@code last_name} value.
     * Can be {@code null}.
     */
    public String getLastName() {
        Integer index = getCachedColumnIndexOrThrow(ProductColumns.LAST_NAME);
        return getString(index);
    }

    /**
     * Get the {@code age} value.
     */
    public int getAge() {
        return getIntegerOrNull(ProductColumns.AGE);
    }

    /**
     * Get the {@code is_blue_eyes} value.
     * Can be {@code null}.
     */
    public Boolean getIsBlueEyes() {
        return getBoolean(ProductColumns.IS_BLUE_EYES);
    }

    /**
     * Get the {@code date_of_birth} value.
     * Can be {@code null}.
     */
    public Date getDateOfBirth() {
        return getDate(ProductColumns.DATE_OF_BIRTH);
    }

    /**
     * Get the {@code height} value.
     * Can be {@code null}.
     */
    public Float getHeight() {
        return getFloatOrNull(ProductColumns.HEIGHT);
    }

    /**
     * Get the {@code company_id} value.
     */
    public long getCompanyId() {
        return getLongOrNull(ProductColumns.COMPANY_ID);
    }

    /**
     * Get the {@code gender} value.
     * Cannot be {@code null}.
     */
    public Gender getGender() {
        Integer intValue = getIntegerOrNull(ProductColumns.GENDER);
        if (intValue == null) return null;
        return Gender.values()[intValue];
    }
}

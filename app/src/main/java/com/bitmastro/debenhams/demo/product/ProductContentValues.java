/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import com.bitmastro.debenhams.demo.model.ProductModel;
import com.bitmastro.debenhams.demo.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code product} table.
 */
public class ProductContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ProductColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     * 
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, ProductSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public ProductContentValues putFirstName(String value) {
        mContentValues.put(ProductColumns.FIRST_NAME, value);
        return this;
    }

    public ProductContentValues putFirstNameNull() {
        mContentValues.putNull(ProductColumns.FIRST_NAME);
        return this;
    }


    public ProductContentValues putLastName(String value) {
        mContentValues.put(ProductColumns.LAST_NAME, value);
        return this;
    }

    public ProductContentValues putLastNameNull() {
        mContentValues.putNull(ProductColumns.LAST_NAME);
        return this;
    }


    public ProductContentValues putAge(int value) {
        mContentValues.put(ProductColumns.AGE, value);
        return this;
    }



    public ProductContentValues putIsBlueEyes(Boolean value) {
        mContentValues.put(ProductColumns.IS_BLUE_EYES, value);
        return this;
    }

    public ProductContentValues putIsBlueEyesNull() {
        mContentValues.putNull(ProductColumns.IS_BLUE_EYES);
        return this;
    }


    public ProductContentValues putDateOfBirth(Date value) {
        mContentValues.put(ProductColumns.DATE_OF_BIRTH, value == null ? null : value.getTime());
        return this;
    }

    public ProductContentValues putDateOfBirthNull() {
        mContentValues.putNull(ProductColumns.DATE_OF_BIRTH);
        return this;
    }

    public ProductContentValues putDateOfBirth(Long value) {
        mContentValues.put(ProductColumns.DATE_OF_BIRTH, value);
        return this;
    }


    public ProductContentValues putHeight(Float value) {
        mContentValues.put(ProductColumns.HEIGHT, value);
        return this;
    }

    public ProductContentValues putHeightNull() {
        mContentValues.putNull(ProductColumns.HEIGHT);
        return this;
    }


    public ProductContentValues putCompanyId(long value) {
        mContentValues.put(ProductColumns.COMPANY_ID, value);
        return this;
    }



    public ProductContentValues putGender(Gender value) {
        if (value == null) throw new IllegalArgumentException("value for gender must not be null");
        mContentValues.put(ProductColumns.GENDER, value.ordinal());
        return this;
    }



    public static ContentValues[] getContentValues(ProductModel... items){
        List<ContentValues> values = new ArrayList<ContentValues>();
        for(ProductModel item : items){
            values.add(getSingleContentValue(item));
        }
        return values.toArray(new ContentValues[values.size()]);
    }

    public static ContentValues getSingleContentValue(ProductModel item){
        ProductContentValues values = new ProductContentValues();
        values.putFirstName(item.firstName);
        values.putLastName(item.lastName);
        values.putAge(item.age);
        values.putIsBlueEyes(item.isBlueEyes);
        values.putDateOfBirth(item.dateOfBirth);
        values.putHeight(item.height);
        values.putCompanyId(item.companyId);
        values.putGender(item.gender);
        return values.values();
    }
}

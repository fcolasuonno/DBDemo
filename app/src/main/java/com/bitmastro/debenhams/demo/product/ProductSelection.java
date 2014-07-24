/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.product;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.bitmastro.debenhams.demo.base.AbstractSelection;

/**
 * Selection for the {@code product} table.
 */
public class ProductSelection extends AbstractSelection<ProductSelection> {
    @Override
    public Uri uri() {
        return ProductColumns.CONTENT_URI;
    }
    
    /**
     * Query the given content resolver using this selection.
     * 
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code ProductCursor} object, which is positioned before the first entry, or null.
     */
    public ProductCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new ProductCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null}.
     */
    public ProductCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null}.
     */
    public ProductCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }
    
    
    public ProductSelection id(long... value) {
        addEquals(ProductColumns._ID, toObjectArray(value));
        return this;
    }

    public ProductSelection firstName(String... value) {
        addEquals(ProductColumns.FIRST_NAME, value);
        return this;
    }
    
    public ProductSelection firstNameNot(String... value) {
        addNotEquals(ProductColumns.FIRST_NAME, value);
        return this;
    }


    public ProductSelection lastName(String... value) {
        addEquals(ProductColumns.LAST_NAME, value);
        return this;
    }
    
    public ProductSelection lastNameNot(String... value) {
        addNotEquals(ProductColumns.LAST_NAME, value);
        return this;
    }


    public ProductSelection age(int... value) {
        addEquals(ProductColumns.AGE, toObjectArray(value));
        return this;
    }
    
    public ProductSelection ageNot(int... value) {
        addNotEquals(ProductColumns.AGE, toObjectArray(value));
        return this;
    }

    public ProductSelection ageGt(int value) {
        addGreaterThan(ProductColumns.AGE, value);
        return this;
    }

    public ProductSelection ageGtEq(int value) {
        addGreaterThanOrEquals(ProductColumns.AGE, value);
        return this;
    }

    public ProductSelection ageLt(int value) {
        addLessThan(ProductColumns.AGE, value);
        return this;
    }

    public ProductSelection ageLtEq(int value) {
        addLessThanOrEquals(ProductColumns.AGE, value);
        return this;
    }

    public ProductSelection isBlueEyes(Boolean... value) {
        addEquals(ProductColumns.IS_BLUE_EYES, value);
        return this;
    }
    
    public ProductSelection isBlueEyesNot(Boolean... value) {
        addNotEquals(ProductColumns.IS_BLUE_EYES, value);
        return this;
    }


    public ProductSelection dateOfBirth(Date... value) {
        addEquals(ProductColumns.DATE_OF_BIRTH, value);
        return this;
    }
    
    public ProductSelection dateOfBirthNot(Date... value) {
        addNotEquals(ProductColumns.DATE_OF_BIRTH, value);
        return this;
    }

    public ProductSelection dateOfBirth(Long... value) {
        addEquals(ProductColumns.DATE_OF_BIRTH, value);
        return this;
    }

    public ProductSelection dateOfBirthAfter(Date value) {
        addGreaterThan(ProductColumns.DATE_OF_BIRTH, value);
        return this;
    }

    public ProductSelection dateOfBirthAfterEq(Date value) {
        addGreaterThanOrEquals(ProductColumns.DATE_OF_BIRTH, value);
        return this;
    }

    public ProductSelection dateOfBirthBefore(Date value) {
        addLessThan(ProductColumns.DATE_OF_BIRTH, value);
        return this;
    }

    public ProductSelection dateOfBirthBeforeEq(Date value) {
        addLessThanOrEquals(ProductColumns.DATE_OF_BIRTH, value);
        return this;
    }

    public ProductSelection height(Float... value) {
        addEquals(ProductColumns.HEIGHT, value);
        return this;
    }
    
    public ProductSelection heightNot(Float... value) {
        addNotEquals(ProductColumns.HEIGHT, value);
        return this;
    }

    public ProductSelection heightGt(float value) {
        addGreaterThan(ProductColumns.HEIGHT, value);
        return this;
    }

    public ProductSelection heightGtEq(float value) {
        addGreaterThanOrEquals(ProductColumns.HEIGHT, value);
        return this;
    }

    public ProductSelection heightLt(float value) {
        addLessThan(ProductColumns.HEIGHT, value);
        return this;
    }

    public ProductSelection heightLtEq(float value) {
        addLessThanOrEquals(ProductColumns.HEIGHT, value);
        return this;
    }

    public ProductSelection companyId(long... value) {
        addEquals(ProductColumns.COMPANY_ID, toObjectArray(value));
        return this;
    }
    
    public ProductSelection companyIdNot(long... value) {
        addNotEquals(ProductColumns.COMPANY_ID, toObjectArray(value));
        return this;
    }

    public ProductSelection companyIdGt(long value) {
        addGreaterThan(ProductColumns.COMPANY_ID, value);
        return this;
    }

    public ProductSelection companyIdGtEq(long value) {
        addGreaterThanOrEquals(ProductColumns.COMPANY_ID, value);
        return this;
    }

    public ProductSelection companyIdLt(long value) {
        addLessThan(ProductColumns.COMPANY_ID, value);
        return this;
    }

    public ProductSelection companyIdLtEq(long value) {
        addLessThanOrEquals(ProductColumns.COMPANY_ID, value);
        return this;
    }

    public ProductSelection gender(Gender... value) {
        addEquals(ProductColumns.GENDER, value);
        return this;
    }
    
    public ProductSelection genderNot(Gender... value) {
        addNotEquals(ProductColumns.GENDER, value);
        return this;
    }

}

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

    public ProductSelection prodnum(String... value) {
        addEquals(ProductColumns.PRODNUM, value);
        return this;
    }
    
    public ProductSelection prodnumNot(String... value) {
        addNotEquals(ProductColumns.PRODNUM, value);
        return this;
    }


    public ProductSelection brand(String... value) {
        addEquals(ProductColumns.BRAND, value);
        return this;
    }
    
    public ProductSelection brandNot(String... value) {
        addNotEquals(ProductColumns.BRAND, value);
        return this;
    }


    public ProductSelection name(String... value) {
        addEquals(ProductColumns.NAME, value);
        return this;
    }
    
    public ProductSelection nameNot(String... value) {
        addNotEquals(ProductColumns.NAME, value);
        return this;
    }


    public ProductSelection mingbp(String... value) {
        addEquals(ProductColumns.MINGBP, value);
        return this;
    }
    
    public ProductSelection mingbpNot(String... value) {
        addNotEquals(ProductColumns.MINGBP, value);
        return this;
    }


    public ProductSelection maxgbp(String... value) {
        addEquals(ProductColumns.MAXGBP, value);
        return this;
    }
    
    public ProductSelection maxgbpNot(String... value) {
        addNotEquals(ProductColumns.MAXGBP, value);
        return this;
    }


    public ProductSelection mingbpWas(String... value) {
        addEquals(ProductColumns.MINGBP_WAS, value);
        return this;
    }
    
    public ProductSelection mingbpWasNot(String... value) {
        addNotEquals(ProductColumns.MINGBP_WAS, value);
        return this;
    }


    public ProductSelection maxgbpWas(String... value) {
        addEquals(ProductColumns.MAXGBP_WAS, value);
        return this;
    }
    
    public ProductSelection maxgbpWasNot(String... value) {
        addNotEquals(ProductColumns.MAXGBP_WAS, value);
        return this;
    }


    public ProductSelection img(String... value) {
        addEquals(ProductColumns.IMG, value);
        return this;
    }
    
    public ProductSelection imgNot(String... value) {
        addNotEquals(ProductColumns.IMG, value);
        return this;
    }


    public ProductSelection sizes(String... value) {
        addEquals(ProductColumns.SIZES, value);
        return this;
    }
    
    public ProductSelection sizesNot(String... value) {
        addNotEquals(ProductColumns.SIZES, value);
        return this;
    }


    public ProductSelection colours(String... value) {
        addEquals(ProductColumns.COLOURS, value);
        return this;
    }
    
    public ProductSelection coloursNot(String... value) {
        addNotEquals(ProductColumns.COLOURS, value);
        return this;
    }


    public ProductSelection category(String... value) {
        addEquals(ProductColumns.CATEGORY, value);
        return this;
    }
    
    public ProductSelection categoryNot(String... value) {
        addNotEquals(ProductColumns.CATEGORY, value);
        return this;
    }


    public ProductSelection noimg(Integer... value) {
        addEquals(ProductColumns.NOIMG, value);
        return this;
    }
    
    public ProductSelection noimgNot(Integer... value) {
        addNotEquals(ProductColumns.NOIMG, value);
        return this;
    }

    public ProductSelection noimgGt(int value) {
        addGreaterThan(ProductColumns.NOIMG, value);
        return this;
    }

    public ProductSelection noimgGtEq(int value) {
        addGreaterThanOrEquals(ProductColumns.NOIMG, value);
        return this;
    }

    public ProductSelection noimgLt(int value) {
        addLessThan(ProductColumns.NOIMG, value);
        return this;
    }

    public ProductSelection noimgLtEq(int value) {
        addLessThanOrEquals(ProductColumns.NOIMG, value);
        return this;
    }

    public ProductSelection rating(String... value) {
        addEquals(ProductColumns.RATING, value);
        return this;
    }
    
    public ProductSelection ratingNot(String... value) {
        addNotEquals(ProductColumns.RATING, value);
        return this;
    }


    public ProductSelection ratingNumber(Integer... value) {
        addEquals(ProductColumns.RATING_NUMBER, value);
        return this;
    }
    
    public ProductSelection ratingNumberNot(Integer... value) {
        addNotEquals(ProductColumns.RATING_NUMBER, value);
        return this;
    }

    public ProductSelection ratingNumberGt(int value) {
        addGreaterThan(ProductColumns.RATING_NUMBER, value);
        return this;
    }

    public ProductSelection ratingNumberGtEq(int value) {
        addGreaterThanOrEquals(ProductColumns.RATING_NUMBER, value);
        return this;
    }

    public ProductSelection ratingNumberLt(int value) {
        addLessThan(ProductColumns.RATING_NUMBER, value);
        return this;
    }

    public ProductSelection ratingNumberLtEq(int value) {
        addLessThanOrEquals(ProductColumns.RATING_NUMBER, value);
        return this;
    }

    public ProductSelection style(String... value) {
        addEquals(ProductColumns.STYLE, value);
        return this;
    }
    
    public ProductSelection styleNot(String... value) {
        addNotEquals(ProductColumns.STYLE, value);
        return this;
    }


    public ProductSelection length(String... value) {
        addEquals(ProductColumns.LENGTH, value);
        return this;
    }
    
    public ProductSelection lengthNot(String... value) {
        addNotEquals(ProductColumns.LENGTH, value);
        return this;
    }


    public ProductSelection sleeve(String... value) {
        addEquals(ProductColumns.SLEEVE, value);
        return this;
    }
    
    public ProductSelection sleeveNot(String... value) {
        addNotEquals(ProductColumns.SLEEVE, value);
        return this;
    }

}

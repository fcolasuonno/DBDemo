/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.product;

import android.net.Uri;
import android.provider.BaseColumns;

import com.bitmastro.debenhams.demo.ProductProvider;

/**
 * Columns for the {@code product} table.
 */
public interface ProductColumns extends BaseColumns {
    String TABLE_NAME = "product";
    Uri CONTENT_URI = Uri.parse(ProductProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    String _ID = BaseColumns._ID;
    String FIRST_NAME = "first_name";
    String LAST_NAME = "last_name";
    String AGE = "age";
    String IS_BLUE_EYES = "is_blue_eyes";
    String DATE_OF_BIRTH = "date_of_birth";
    String HEIGHT = "height";
    String COMPANY_ID = "company_id";
    String GENDER = "gender";

    String DEFAULT_ORDER = _ID;

	// @formatter:off
    String[] FULL_PROJECTION = new String[] {
            _ID,
            FIRST_NAME,
            LAST_NAME,
            AGE,
            IS_BLUE_EYES,
            DATE_OF_BIRTH,
            HEIGHT,
            COMPANY_ID,
            GENDER
    };
    // @formatter:on
}
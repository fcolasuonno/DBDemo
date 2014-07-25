/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.product;

import android.net.Uri;
import android.provider.BaseColumns;

import com.bitmastro.debenhams.demo.DebenhamsProvider;

/**
 * Columns for the {@code product} table.
 */
public interface ProductColumns extends BaseColumns {
    String TABLE_NAME = "product";
    Uri CONTENT_URI = Uri.parse(DebenhamsProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    String _ID = BaseColumns._ID;
    String PRODNUM = "prodnum";
    String BRAND = "brand";
    String NAME = "name";
    String MINGBP = "mingbp";
    String MAXGBP = "maxgbp";
    String MINGBP_WAS = "mingbp_was";
    String MAXGBP_WAS = "maxgbp_was";
    String IMG = "img";
    String SIZES = "sizes";
    String COLOURS = "colours";
    String CATEGORY = "category";
    String NOIMG = "noimg";
    String RATING = "rating";
    String RATING_NUMBER = "rating_number";
    String STYLE = "style";
    String LENGTH = "length";
    String SLEEVE = "sleeve";

    String DEFAULT_ORDER = _ID;

	// @formatter:off
    String[] FULL_PROJECTION = new String[] {
            _ID,
            PRODNUM,
            BRAND,
            NAME,
            MINGBP,
            MAXGBP,
            MINGBP_WAS,
            MAXGBP_WAS,
            IMG,
            SIZES,
            COLOURS,
            CATEGORY,
            NOIMG,
            RATING,
            RATING_NUMBER,
            STYLE,
            LENGTH,
            SLEEVE
    };
    // @formatter:on
}
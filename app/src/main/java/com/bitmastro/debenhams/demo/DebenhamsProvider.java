/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

import com.bitmastro.debenhams.demo.product.ProductColumns;

import java.util.ArrayList;
import java.util.Arrays;

public class DebenhamsProvider extends ContentProvider {
    public static final String AUTHORITY = "com.bitmastro.debenhams.demo";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;
    public static final String QUERY_NOTIFY = "QUERY_NOTIFY";
    public static final String QUERY_GROUP_BY = "QUERY_GROUP_BY";
    public static final String QUERY_SELECTION = "QUERY_SELECTION";
    private static final String TAG = DebenhamsProvider.class.getSimpleName();
    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";
    private static final int URI_TYPE_PRODUCT = 0;
    private static final int URI_TYPE_PRODUCT_ID = 1;


    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, ProductColumns.TABLE_NAME, URI_TYPE_PRODUCT);
        URI_MATCHER.addURI(AUTHORITY, ProductColumns.TABLE_NAME + "/#", URI_TYPE_PRODUCT_ID);
    }

    protected CustomSQLiteOpenHelper mCustomSQLiteOpenHelper;

    public static Uri notify(Uri uri, boolean notify) {
        return uri.buildUpon().appendQueryParameter(QUERY_NOTIFY, String.valueOf(notify)).build();
    }

    public static Uri groupBy(Uri uri, String groupBy) {
        return uri.buildUpon().appendQueryParameter(QUERY_GROUP_BY, groupBy).build();
    }

    public static Uri selection(Uri uri, String selection) {
        return uri.buildUpon().appendQueryParameter(QUERY_SELECTION, selection).build();
    }

    @Override
    public boolean onCreate() {
        mCustomSQLiteOpenHelper = CustomSQLiteOpenHelper.newInstance(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        final int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_PRODUCT:
                return TYPE_CURSOR_DIR + ProductColumns.TABLE_NAME;
            case URI_TYPE_PRODUCT_ID:
                return TYPE_CURSOR_ITEM + ProductColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (BuildConfig.DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        final String table = uri.getLastPathSegment();
        final long rowId = mCustomSQLiteOpenHelper.getWritableDatabase().insert(table, null, values);
        String notify;
        if (rowId != -1 && ((notify = uri.getQueryParameter(QUERY_NOTIFY)) == null || "true".equals(notify))) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return uri.buildUpon().appendEncodedPath(String.valueOf(rowId)).build();
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final String table = uri.getLastPathSegment();
        final String selection = uri.getQueryParameter(QUERY_SELECTION);
        final SQLiteDatabase db = mCustomSQLiteOpenHelper.getWritableDatabase();
        int res = 0;
        if (selection != null) {
            if (BuildConfig.DEBUG)
                Log.d(TAG, "bulkUpdate uri=" + uri + " values.length=" + values.length);
            String selectionClause = selection + "=?";
            String[] selectionValue = new String[1];
            db.beginTransaction();
            try {
                for (final ContentValues v : values) {
                    selectionValue[0] = v.getAsString(selection);
                    final long id = db.update(table, v, selectionClause, selectionValue);
                    db.yieldIfContendedSafely();
                    if (id == 1) {
                        res++;
                    } else {
                        final long id2 = db.insert(table, null, v);
                        db.yieldIfContendedSafely();
                        if (id2 != -1) {
                            res++;
                        }
                    }
                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        } else {
            if (BuildConfig.DEBUG)
                Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
            db.beginTransaction();
            try {
                for (final ContentValues v : values) {
                    final long id = db.insert(table, null, v);
                    db.yieldIfContendedSafely();
                    if (id != -1) {
                        res++;
                    }
                }
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
        String notify;
        if (res != 0 && ((notify = uri.getQueryParameter(QUERY_NOTIFY)) == null || "true".equals(notify))) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return res;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        final QueryParams queryParams = getQueryParams(uri, selection);
        final int res = mCustomSQLiteOpenHelper.getWritableDatabase().update(queryParams.table, values, queryParams.selection, selectionArgs);
        String notify;
        if (res != 0 && ((notify = uri.getQueryParameter(QUERY_NOTIFY)) == null || "true".equals(notify))) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return res;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        final QueryParams queryParams = getQueryParams(uri, selection);
        final int res = mCustomSQLiteOpenHelper.getWritableDatabase().delete(queryParams.table, queryParams.selection, selectionArgs);
        String notify;
        if (res != 0 && ((notify = uri.getQueryParameter(QUERY_NOTIFY)) == null || "true".equals(notify))) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return res;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        final String groupBy = uri.getQueryParameter(QUERY_GROUP_BY);
        if (BuildConfig.DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + groupBy);
        final QueryParams queryParams = getQueryParams(uri, selection);
        final Cursor res = mCustomSQLiteOpenHelper.getReadableDatabase().query(queryParams.table, projection, queryParams.selection, selectionArgs, groupBy,
                null, sortOrder == null ? queryParams.orderBy : sortOrder);
        res.setNotificationUri(getContext().getContentResolver(), uri);
        return res;
    }

    @Override
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations) throws OperationApplicationException {
        SQLiteDatabase db = mCustomSQLiteOpenHelper.getWritableDatabase();
        db.beginTransaction();
        try {
            int numOperations = operations.size();
            ContentProviderResult[] results = new ContentProviderResult[numOperations];
            int i = 0;
            for (ContentProviderOperation operation : operations) {
                results[i] = operation.apply(this, results, i);
                if (operation.isYieldAllowed()) {
                    db.yieldIfContendedSafely();
                }
                i++;
            }
            db.setTransactionSuccessful();
            return results;
        } finally {
            db.endTransaction();
        }
    }

    private QueryParams getQueryParams(Uri uri, String selection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_PRODUCT:
            case URI_TYPE_PRODUCT_ID:
                res.table = ProductColumns.TABLE_NAME;
                res.orderBy = ProductColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_PRODUCT_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = BaseColumns._ID + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = BaseColumns._ID + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }

    private static class QueryParams {
        public String table;
        public String selection;
        public String orderBy;
    }
}

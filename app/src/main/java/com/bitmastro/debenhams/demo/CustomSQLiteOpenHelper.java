/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.bitmastro.debenhams.demo.BuildConfig;
import com.bitmastro.debenhams.demo.product.ProductColumns;

public class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = CustomSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "product.db";
    private static final int DATABASE_VERSION = 1;

    // @formatter:off
    private static final String SQL_CREATE_TABLE_PRODUCT = "CREATE TABLE IF NOT EXISTS "
            + ProductColumns.TABLE_NAME + " ( "
            + ProductColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ProductColumns.FIRST_NAME + " TEXT, "
            + ProductColumns.LAST_NAME + " TEXT, "
            + ProductColumns.AGE + " INTEGER NOT NULL, "
            + ProductColumns.IS_BLUE_EYES + " INTEGER DEFAULT '1', "
            + ProductColumns.DATE_OF_BIRTH + " INTEGER, "
            + ProductColumns.HEIGHT + " REAL, "
            + ProductColumns.COMPANY_ID + " INTEGER NOT NULL, "
            + ProductColumns.GENDER + " INTEGER NOT NULL "
            + ", CONSTRAINT UNIQUE_NAME UNIQUE (FIRST_NAME, LAST_NAME) ON CONFLICT REPLACE"
            + " );";

    private static final String SQL_CREATE_INDEX_PRODUCT_DATE_OF_BIRTH = "CREATE INDEX IDX_PRODUCT_DATE_OF_BIRTH "
            + " ON " + ProductColumns.TABLE_NAME + " ( " + ProductColumns.DATE_OF_BIRTH + " );";
    // @formatter:on

    public static CustomSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */

    private static CustomSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new CustomSQLiteOpenHelper(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
    }

    private CustomSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    /*
     * Post Honeycomb.
     */

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static CustomSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new CustomSQLiteOpenHelper(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private CustomSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        db.execSQL(SQL_CREATE_TABLE_PRODUCT);
        db.execSQL(SQL_CREATE_INDEX_PRODUCT_DATE_OF_BIRTH);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (BuildConfig.DEBUG) Log.d(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
    }
}

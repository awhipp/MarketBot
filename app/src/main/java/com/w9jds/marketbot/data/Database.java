package com.w9jds.marketbot.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.w9jds.marketbot.data.DataContracts.MarketBotEntry;

public final class Database {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MarketBotDb";

    private final Helper mDatabaseOpenHelper;

    public Database(Context context) {
        mDatabaseOpenHelper = new Helper(context);
    }

    public SQLiteDatabase getWritableDatabaseHelper() {
        return mDatabaseOpenHelper.getWritableDatabase();
    }

    public SQLiteDatabase getReadableDatabaseHelper() {
        return mDatabaseOpenHelper.getReadableDatabase();
    }

    private static class Helper extends SQLiteOpenHelper {

        public Helper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            database.beginTransaction();

            database.execSQL(MarketBotEntry.CREATE_TABLE);

            database.setTransactionSuccessful();
            database.endTransaction();
        }

        @Override
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
            database.beginTransaction();

            database.execSQL("DROP TABLE IF EXISTS " + MarketBotEntry.TABLE_NAME);

            database.setTransactionSuccessful();
            database.endTransaction();

            onCreate(database);

            database.close();
        }
    }
}
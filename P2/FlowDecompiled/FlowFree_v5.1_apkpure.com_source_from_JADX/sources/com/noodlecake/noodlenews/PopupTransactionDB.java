package com.noodlecake.noodlenews;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PopupTransactionDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "noodlenews";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CREATE = "CREATE TABLE popups ( popup_id INTEGER PRIMARY KEY, acked INTEGER(1) DEFAULT 0)";
    private static final String TABLE_NAME = "popups";

    /* renamed from: db */
    private SQLiteDatabase f5606db = getWritableDatabase();

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public PopupTransactionDB(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public synchronized void close() {
        SQLiteDatabase sQLiteDatabase = this.f5606db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(TABLE_CREATE);
    }

    public boolean popupIdNotAcked(int i) {
        SQLiteDatabase sQLiteDatabase = this.f5606db;
        Cursor query = sQLiteDatabase.query(TABLE_NAME, (String[]) null, "popup_id =" + i, (String[]) null, (String) null, (String) null, (String) null);
        boolean z = !query.moveToFirst() || query.getCount() <= 0;
        query.close();
        return z;
    }

    public void markPopupIdAcked(int i) {
        this.f5606db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("popup_id", Integer.valueOf(i));
            contentValues.put("acked", 1);
            this.f5606db.insert(TABLE_NAME, (String) null, contentValues);
            this.f5606db.setTransactionSuccessful();
        } finally {
            this.f5606db.endTransaction();
        }
    }
}

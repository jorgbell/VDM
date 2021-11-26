package com.flurry.android.agent;

import android.app.ActivityManager;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.flurry.sdk.C1673dk;
import com.flurry.sdk.C1676dl;

public class FlurryContentProvider extends ContentProvider {
    public static final String PERFORMANCE_DATA_TYPE = "performance";
    public static final int RUNTIME_USED_MEMORY_COLUMN = 1;
    public static final int START_TIME_COLUMN = 0;
    public static final int SYSTEM_USED_MEMORY_COLUMN = 2;

    /* renamed from: a */
    private static UriMatcher f3571a;

    /* renamed from: b */
    private static final long f3572b = System.nanoTime();

    /* renamed from: c */
    private MatrixCursor f3573c;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        String providerName = getProviderName(getContext());
        UriMatcher uriMatcher = new UriMatcher(-1);
        f3571a = uriMatcher;
        uriMatcher.addURI(providerName, PERFORMANCE_DATA_TYPE, 1);
        Runtime runtime = Runtime.getRuntime();
        ActivityManager.MemoryInfo a = C1676dl.m4398a(getContext());
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"START_TIME", "RUNTIME_USED_MEMORY", "SYSTEM_USED_MEMORY"});
        this.f3573c = matrixCursor;
        matrixCursor.newRow().add(Long.valueOf(f3572b)).add(Long.valueOf(runtime.totalMemory() - runtime.freeMemory())).add(Long.valueOf(a.totalMem - a.availMem));
        C1673dk.m4390a().mo11468a(getContext(), this.f3573c);
        return true;
    }

    public static String getProviderName(Context context) {
        String packageName = context.getApplicationContext().getPackageName();
        return packageName + ".FlurryContentProvider";
    }

    public static Uri getProviderUri(Context context, String str) {
        String providerName = getProviderName(context);
        return Uri.parse("content://" + providerName + "/" + str);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (f3571a.match(uri) != 1) {
            return null;
        }
        return this.f3573c;
    }
}

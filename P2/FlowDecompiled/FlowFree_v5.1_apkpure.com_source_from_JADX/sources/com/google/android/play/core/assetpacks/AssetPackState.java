package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.internal.C2109i;

public abstract class AssetPackState {
    /* renamed from: c */
    public static AssetPackState m4863c(String str, int i, int i2, long j, long j2, double d, int i3, String str2) {
        return new C1974az(str, i, i2, j, j2, (int) Math.rint(100.0d * d), i3, str2);
    }

    /* renamed from: d */
    static AssetPackState m4864d(Bundle bundle, String str, C1989bo boVar, C1968as asVar) {
        Bundle bundle2 = bundle;
        String str2 = str;
        int i = bundle2.getInt(C2109i.m5273e("status", str2));
        asVar.mo21872a(i, str2);
        int i2 = bundle2.getInt(C2109i.m5273e("error_code", str2));
        long j = bundle2.getLong(C2109i.m5273e("bytes_downloaded", str2));
        long j2 = bundle2.getLong(C2109i.m5273e("total_bytes_to_download", str2));
        double b = boVar.mo21932b(str2);
        long j3 = bundle2.getLong(C2109i.m5273e("pack_version", str2));
        long j4 = bundle2.getLong(C2109i.m5273e("pack_base_version", str2));
        int i3 = 1;
        if (!(i != 4 || j4 == 0 || j4 == j3)) {
            i3 = 2;
        }
        return m4863c(str, i, i2, j, j2, b, i3, bundle2.getString(C2109i.m5273e("pack_version_tag", str2), ""));
    }

    /* renamed from: a */
    public abstract int mo21829a();

    /* renamed from: b */
    public abstract String mo21830b();

    public abstract long bytesDownloaded();

    public abstract int errorCode();

    public abstract String name();

    public abstract int status();

    public abstract long totalBytesToDownload();

    public abstract int transferProgressPercentage();
}

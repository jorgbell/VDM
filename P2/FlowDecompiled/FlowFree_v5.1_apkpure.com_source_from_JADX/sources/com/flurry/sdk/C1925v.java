package com.flurry.sdk;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.flurry.sdk.v */
public final class C1925v {

    /* renamed from: c */
    private static SimpleDateFormat f4759c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    /* renamed from: a */
    public String f4760a;

    /* renamed from: b */
    public long f4761b;

    public C1925v(String str, long j) {
        this.f4760a = str;
        this.f4761b = j;
    }

    public final String toString() {
        return f4759c.format(Long.valueOf(this.f4761b)) + ": " + this.f4760a + "\n";
    }
}

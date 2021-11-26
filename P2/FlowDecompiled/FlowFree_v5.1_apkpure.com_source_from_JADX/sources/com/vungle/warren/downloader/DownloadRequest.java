package com.vungle.warren.downloader;

import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadRequest {
    private AtomicBoolean cancelled = new AtomicBoolean(false);
    public final String cookieString;

    /* renamed from: id */
    final String f5622id;
    public final int networkType;
    public final String path;
    public final boolean pauseOnConnectionLost;
    private final AtomicInteger priority;
    public final String url;

    public String toString() {
        return "DownloadRequest{networkType=" + this.networkType + ", priority=" + this.priority + ", url='" + this.url + '\'' + ", path='" + this.path + '\'' + ", pauseOnConnectionLost=" + this.pauseOnConnectionLost + ", id='" + this.f5622id + '\'' + ", cookieString='" + this.cookieString + '\'' + ", cancelled=" + this.cancelled + '}';
    }

    public DownloadRequest(int i, int i2, String str, String str2, boolean z, String str3) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.priority = atomicInteger;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Url or path is empty");
        }
        this.networkType = i;
        atomicInteger.set(i2);
        this.url = str;
        this.path = str2;
        this.f5622id = UUID.nameUUIDFromBytes((str2 + "_" + str).getBytes()).toString();
        this.pauseOnConnectionLost = z;
        this.cookieString = str3;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.cancelled.set(true);
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        return this.cancelled.get();
    }

    public void setPriority(int i) {
        this.priority.set(i);
    }

    public int getPriority() {
        return this.priority.get();
    }
}

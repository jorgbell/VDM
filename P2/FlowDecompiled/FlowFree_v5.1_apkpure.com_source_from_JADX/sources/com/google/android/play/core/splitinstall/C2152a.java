package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.a */
final class C2152a extends SplitInstallSessionState {

    /* renamed from: a */
    private final int f5275a;

    /* renamed from: b */
    private final int f5276b;

    /* renamed from: c */
    private final int f5277c;

    /* renamed from: d */
    private final long f5278d;

    /* renamed from: e */
    private final long f5279e;

    /* renamed from: f */
    private final List<String> f5280f;

    /* renamed from: g */
    private final List<String> f5281g;

    /* renamed from: h */
    private final PendingIntent f5282h;

    /* renamed from: i */
    private final List<Intent> f5283i;

    C2152a(int i, int i2, int i3, long j, long j2, List<String> list, List<String> list2, PendingIntent pendingIntent, List<Intent> list3) {
        this.f5275a = i;
        this.f5276b = i2;
        this.f5277c = i3;
        this.f5278d = j;
        this.f5279e = j2;
        this.f5280f = list;
        this.f5281g = list2;
        this.f5282h = pendingIntent;
        this.f5283i = list3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<String> mo22159a() {
        return this.f5280f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final List<String> mo22160b() {
        return this.f5281g;
    }

    public final long bytesDownloaded() {
        return this.f5278d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final List<Intent> mo22162c() {
        return this.f5283i;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SplitInstallSessionState) {
            SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) obj;
            if (this.f5275a == splitInstallSessionState.sessionId() && this.f5276b == splitInstallSessionState.status() && this.f5277c == splitInstallSessionState.errorCode() && this.f5278d == splitInstallSessionState.bytesDownloaded() && this.f5279e == splitInstallSessionState.totalBytesToDownload() && ((list = this.f5280f) != null ? list.equals(splitInstallSessionState.mo22159a()) : splitInstallSessionState.mo22159a() == null) && ((list2 = this.f5281g) != null ? list2.equals(splitInstallSessionState.mo22160b()) : splitInstallSessionState.mo22160b() == null) && ((pendingIntent = this.f5282h) != null ? pendingIntent.equals(splitInstallSessionState.resolutionIntent()) : splitInstallSessionState.resolutionIntent() == null)) {
                List<Intent> list3 = this.f5283i;
                List<Intent> c = splitInstallSessionState.mo22162c();
                if (list3 != null ? list3.equals(c) : c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int errorCode() {
        return this.f5277c;
    }

    public final int hashCode() {
        int i = this.f5275a;
        int i2 = this.f5276b;
        int i3 = this.f5277c;
        long j = this.f5278d;
        long j2 = this.f5279e;
        int i4 = (((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List<String> list = this.f5280f;
        int i5 = 0;
        int hashCode = (i4 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.f5281g;
        int hashCode2 = (hashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.f5282h;
        int hashCode3 = (hashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List<Intent> list3 = this.f5283i;
        if (list3 != null) {
            i5 = list3.hashCode();
        }
        return hashCode3 ^ i5;
    }

    @Deprecated
    public final PendingIntent resolutionIntent() {
        return this.f5282h;
    }

    public final int sessionId() {
        return this.f5275a;
    }

    public final int status() {
        return this.f5276b;
    }

    public final String toString() {
        int i = this.f5275a;
        int i2 = this.f5276b;
        int i3 = this.f5277c;
        long j = this.f5278d;
        long j2 = this.f5279e;
        String valueOf = String.valueOf(this.f5280f);
        String valueOf2 = String.valueOf(this.f5281g);
        String valueOf3 = String.valueOf(this.f5282h);
        String valueOf4 = String.valueOf(this.f5283i);
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", moduleNamesNullable=");
        sb.append(valueOf);
        sb.append(", languagesNullable=");
        sb.append(valueOf2);
        sb.append(", resolutionIntent=");
        sb.append(valueOf3);
        sb.append(", splitFileIntents=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f5279e;
    }
}

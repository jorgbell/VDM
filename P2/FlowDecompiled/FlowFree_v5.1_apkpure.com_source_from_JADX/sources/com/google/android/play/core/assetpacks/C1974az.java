package com.google.android.play.core.assetpacks;

import java.util.Objects;

/* renamed from: com.google.android.play.core.assetpacks.az */
final class C1974az extends AssetPackState {

    /* renamed from: a */
    private final String f4866a;

    /* renamed from: b */
    private final int f4867b;

    /* renamed from: c */
    private final int f4868c;

    /* renamed from: d */
    private final long f4869d;

    /* renamed from: e */
    private final long f4870e;

    /* renamed from: f */
    private final int f4871f;

    /* renamed from: g */
    private final int f4872g;

    /* renamed from: h */
    private final String f4873h;

    C1974az(String str, int i, int i2, long j, long j2, int i3, int i4, String str2) {
        Objects.requireNonNull(str, "Null name");
        this.f4866a = str;
        this.f4867b = i;
        this.f4868c = i2;
        this.f4869d = j;
        this.f4870e = j2;
        this.f4871f = i3;
        this.f4872g = i4;
        Objects.requireNonNull(str2, "Null versionTag");
        this.f4873h = str2;
    }

    /* renamed from: a */
    public final int mo21829a() {
        return this.f4872g;
    }

    /* renamed from: b */
    public final String mo21830b() {
        return this.f4873h;
    }

    public final long bytesDownloaded() {
        return this.f4869d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            return this.f4866a.equals(assetPackState.name()) && this.f4867b == assetPackState.status() && this.f4868c == assetPackState.errorCode() && this.f4869d == assetPackState.bytesDownloaded() && this.f4870e == assetPackState.totalBytesToDownload() && this.f4871f == assetPackState.transferProgressPercentage() && this.f4872g == assetPackState.mo21829a() && this.f4873h.equals(assetPackState.mo21830b());
        }
    }

    public final int errorCode() {
        return this.f4868c;
    }

    public final int hashCode() {
        int hashCode = this.f4866a.hashCode();
        int i = this.f4867b;
        int i2 = this.f4868c;
        long j = this.f4869d;
        long j2 = this.f4870e;
        return ((((((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f4871f) * 1000003) ^ this.f4872g) * 1000003) ^ this.f4873h.hashCode();
    }

    public final String name() {
        return this.f4866a;
    }

    public final int status() {
        return this.f4867b;
    }

    public final String toString() {
        String str = this.f4866a;
        int i = this.f4867b;
        int i2 = this.f4868c;
        long j = this.f4869d;
        long j2 = this.f4870e;
        int i3 = this.f4871f;
        int i4 = this.f4872g;
        String str2 = this.f4873h;
        StringBuilder sb = new StringBuilder(str.length() + 230 + str2.length());
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append(", updateAvailability=");
        sb.append(i4);
        sb.append(", versionTag=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f4870e;
    }

    public final int transferProgressPercentage() {
        return this.f4871f;
    }
}

package com.google.android.play.core.assetpacks;

import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ba */
final class C1976ba extends AssetPackStates {

    /* renamed from: a */
    private final long f4877a;

    /* renamed from: b */
    private final Map<String, AssetPackState> f4878b;

    C1976ba(long j, Map<String, AssetPackState> map) {
        this.f4877a = j;
        this.f4878b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackStates) {
            AssetPackStates assetPackStates = (AssetPackStates) obj;
            return this.f4877a == assetPackStates.totalBytes() && this.f4878b.equals(assetPackStates.packStates());
        }
    }

    public final int hashCode() {
        long j = this.f4877a;
        return this.f4878b.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    public final Map<String, AssetPackState> packStates() {
        return this.f4878b;
    }

    public final String toString() {
        long j = this.f4877a;
        String valueOf = String.valueOf(this.f4878b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
        sb.append("AssetPackStates{totalBytes=");
        sb.append(j);
        sb.append(", packStates=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytes() {
        return this.f4877a;
    }
}

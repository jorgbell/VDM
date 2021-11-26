package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.ay */
final class C1973ay extends AssetPackLocation {

    /* renamed from: a */
    private final int f4863a;

    /* renamed from: b */
    private final String f4864b;

    /* renamed from: c */
    private final String f4865c;

    C1973ay(int i, String str, String str2) {
        this.f4863a = i;
        this.f4864b = str;
        this.f4865c = str2;
    }

    public final String assetsPath() {
        return this.f4865c;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackLocation) {
            AssetPackLocation assetPackLocation = (AssetPackLocation) obj;
            if (this.f4863a == assetPackLocation.packStorageMethod() && ((str = this.f4864b) != null ? str.equals(assetPackLocation.path()) : assetPackLocation.path() == null)) {
                String str2 = this.f4865c;
                String assetsPath = assetPackLocation.assetsPath();
                if (str2 != null ? str2.equals(assetsPath) : assetsPath == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f4863a ^ 1000003) * 1000003;
        String str = this.f4864b;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f4865c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    public final int packStorageMethod() {
        return this.f4863a;
    }

    public final String path() {
        return this.f4864b;
    }

    public final String toString() {
        int i = this.f4863a;
        String str = this.f4864b;
        String str2 = this.f4865c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}

package com.google.android.play.core.assetpacks;

public abstract class AssetPackLocation {
    /* renamed from: b */
    static AssetPackLocation m4862b(String str, String str2) {
        return new C1973ay(0, str, str2);
    }

    public abstract String assetsPath();

    public abstract int packStorageMethod();

    public abstract String path();
}

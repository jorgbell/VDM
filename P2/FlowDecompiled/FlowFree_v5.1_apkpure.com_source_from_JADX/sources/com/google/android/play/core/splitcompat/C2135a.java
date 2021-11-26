package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.google.android.play.core.internal.C2086bh;
import java.io.File;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.a */
public final class C2135a {
    public C2135a(C2137c cVar) {
    }

    /* renamed from: c */
    public static final int m5363c(AssetManager assetManager, File file) {
        int intValue = ((Integer) C2086bh.m5222a(assetManager, "addAssetPath", Integer.class, String.class, file.getPath())).intValue();
        StringBuilder sb = new StringBuilder(39);
        sb.append("addAssetPath completed with ");
        sb.append(intValue);
        Log.d("SplitCompat", sb.toString());
        return intValue;
    }

    /* renamed from: b */
    public final synchronized void mo22131b(Context context, Set<File> set) {
        AssetManager assets = context.getAssets();
        for (File c : set) {
            m5363c(assets, c);
        }
    }
}

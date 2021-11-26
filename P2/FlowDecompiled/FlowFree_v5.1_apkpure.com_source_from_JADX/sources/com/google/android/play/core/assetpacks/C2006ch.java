package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.ch */
final /* synthetic */ class C2006ch implements FilenameFilter {

    /* renamed from: a */
    private final String f5009a;

    C2006ch(String str) {
        this.f5009a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.f5009a).concat("-")) && str.endsWith(".apk");
    }
}

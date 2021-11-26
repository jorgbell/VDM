package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.da */
final /* synthetic */ class C2025da implements FilenameFilter {

    /* renamed from: a */
    static final FilenameFilter f5083a = new C2025da();

    private C2025da() {
    }

    public final boolean accept(File file, String str) {
        return C2026db.f5084a.matcher(str).matches();
    }
}

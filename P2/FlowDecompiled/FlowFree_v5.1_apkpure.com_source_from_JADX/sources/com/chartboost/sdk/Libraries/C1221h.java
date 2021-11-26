package com.chartboost.sdk.Libraries;

import com.mopub.common.AdType;
import java.io.File;

/* renamed from: com.chartboost.sdk.Libraries.h */
public class C1221h {

    /* renamed from: a */
    public final File f2680a;

    /* renamed from: b */
    public final File f2681b;

    /* renamed from: c */
    public final File f2682c;

    /* renamed from: d */
    public final File f2683d;

    C1221h(File file) {
        File file2 = new File(file, ".chartboost");
        this.f2680a = file2;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        m2961a(file2, "css");
        m2961a(file2, AdType.HTML);
        this.f2681b = m2961a(file2, "images");
        m2961a(file2, "js");
        this.f2682c = m2961a(file2, "templates");
        this.f2683d = m2961a(file2, "videos");
    }

    /* renamed from: a */
    private static File m2961a(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2;
    }
}

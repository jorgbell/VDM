package com.flurry.sdk;

import android.os.FileObserver;

/* renamed from: com.flurry.sdk.jw */
public final class C1903jw extends FileObserver {

    /* renamed from: a */
    private C1899ju f4702a;

    /* renamed from: b */
    private String f4703b;

    public C1903jw(String str, C1899ju juVar) {
        super(str);
        this.f4703b = str;
        this.f4702a = juVar;
    }

    public final void onEvent(int i, String str) {
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            if ((i & 8) != 0) {
                sb.append(this.f4703b + "/" + str + " is written and closed\n");
                StringBuilder sb2 = new StringBuilder("Observer triggered ");
                sb2.append(sb.toString());
                C1648cy.m4317a(3, "VNodeObserver", sb2.toString());
                this.f4702a.mo11563a(str);
            }
        }
    }
}

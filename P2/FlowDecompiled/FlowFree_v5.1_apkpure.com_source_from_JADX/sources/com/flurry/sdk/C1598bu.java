package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.bu */
public final class C1598bu {

    /* renamed from: a */
    boolean f4022a;

    /* renamed from: b */
    private final C1599bv f4023b;

    /* renamed from: c */
    private final File f4024c;

    /* renamed from: d */
    private String f4025d;

    public C1598bu() {
        this(C1536b.m4057a());
    }

    public C1598bu(Context context) {
        this.f4023b = new C1599bv();
        File fileStreamPath = context.getFileStreamPath(".flurryinstallreceiver.");
        this.f4024c = fileStreamPath;
        C1648cy.m4317a(3, "InstallLogger", "Referrer file name if it exists:  " + fileStreamPath);
    }

    /* renamed from: b */
    private void m4161b(String str) {
        if (str != null) {
            this.f4025d = str;
        }
    }

    /* renamed from: a */
    public final synchronized void mo11350a(String str) {
        this.f4022a = true;
        m4161b(str);
        C1696dy.m4433a(this.f4024c, this.f4025d);
    }

    /* renamed from: a */
    public final synchronized Map<String, List<String>> mo11349a() {
        if (!this.f4022a) {
            this.f4022a = true;
            C1648cy.m4317a(4, "InstallLogger", "Loading referrer info from file: " + this.f4024c.getAbsolutePath());
            String c = C1696dy.m4438c(this.f4024c);
            C1648cy.m4319a("InstallLogger", "Referrer file contents: ".concat(String.valueOf(c)));
            m4161b(c);
        }
        return C1599bv.m4164a(this.f4025d);
    }
}

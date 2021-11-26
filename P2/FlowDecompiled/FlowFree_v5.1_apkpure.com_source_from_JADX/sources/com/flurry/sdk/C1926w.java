package com.flurry.sdk;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.flurry.sdk.w */
public final class C1926w {

    /* renamed from: b */
    private static final char[] f4762b;

    /* renamed from: c */
    private static final String f4763c;

    /* renamed from: d */
    private static final int f4764d;

    /* renamed from: e */
    private static final int f4765e;

    /* renamed from: f */
    private static final int f4766f;

    /* renamed from: g */
    private static final int f4767g;

    /* renamed from: a */
    public ByteBuffer f4768a;

    /* renamed from: h */
    private short f4769h;

    /* renamed from: i */
    private boolean f4770i;

    /* renamed from: b */
    public static int m4822b() {
        return 1;
    }

    static {
        char[] cArr = {'F', 'C', 'B', 'M'};
        f4762b = cArr;
        f4763c = new String(cArr);
        f4764d = (cArr.length * 2) + 2 + 1 + 105984;
        int length = cArr.length * 2;
        f4765e = length;
        int i = length + 2;
        f4766f = i;
        f4767g = i + 1;
    }

    C1926w() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f4764d);
        this.f4768a = allocateDirect;
        allocateDirect.asCharBuffer().put(f4762b);
    }

    public C1926w(File file) {
        int i;
        boolean z = true;
        C1648cy.m4317a(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "YCrashBreadcrumbs from %s", new Object[]{file.getAbsolutePath()}));
        this.f4768a = ByteBuffer.allocate(f4764d);
        if (file.length() != ((long) this.f4768a.capacity())) {
            C1648cy.m4317a(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "Crash breadcrumbs invalid file length %s != %s", new Object[]{Long.valueOf(file.length()), Integer.valueOf(this.f4768a.capacity())}));
            this.f4768a = null;
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            try {
                i = channel.read(this.f4768a);
            } catch (IOException unused) {
                C1648cy.m4317a(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", "Issue reading breadcrumbs from file.");
                i = 0;
            }
            C1698dz.m4444a((Closeable) channel);
            C1698dz.m4444a((Closeable) fileInputStream);
            if (i != this.f4768a.capacity()) {
                C1648cy.m4317a(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "YCrashBreadcrumbs unexpected read size %s != %s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f4768a.capacity())}));
                this.f4768a = null;
                return;
            }
            this.f4768a.position(0);
            String obj = this.f4768a.asCharBuffer().limit(f4762b.length).toString();
            if (!obj.equals(f4763c)) {
                C1648cy.m4317a(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid magic string: '%s'", new Object[]{obj}));
                this.f4768a = null;
                return;
            }
            short s = this.f4768a.getShort(f4765e);
            this.f4769h = s;
            if (s < 0 || s >= 207) {
                C1648cy.m4317a(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", String.format(Locale.getDefault(), "YCrashBreadcrumbs invalid index: '%s'", new Object[]{Short.valueOf(this.f4769h)}));
                this.f4768a = null;
                return;
            }
            this.f4770i = this.f4768a.get(f4766f) != 1 ? false : z;
        } catch (FileNotFoundException unused2) {
            C1648cy.m4317a(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", "Issue reading breadcrumbs file.");
            this.f4768a = null;
        }
    }

    /* renamed from: a */
    private C1925v m4821a(int i) {
        this.f4768a.position(f4767g + (i * 512));
        return new C1925v(this.f4768a.asCharBuffer().limit(this.f4768a.getInt()).toString(), this.f4768a.getLong());
    }

    /* renamed from: a */
    public final List<C1925v> mo11577a() {
        ArrayList arrayList = new ArrayList();
        if (this.f4768a == null) {
            return arrayList;
        }
        if (this.f4770i) {
            for (int i = this.f4769h; i < 207; i++) {
                arrayList.add(m4821a(i));
            }
        }
        for (int i2 = 0; i2 < this.f4769h; i2++) {
            arrayList.add(m4821a(i2));
        }
        return arrayList;
    }

    /* renamed from: a */
    public final synchronized void mo11578a(C1925v vVar) {
        String str = vVar.f4760a;
        if (TextUtils.isEmpty(str)) {
            C1648cy.m4317a(6, "com.flurry.android.common.newProviders.errorCrashBreadcrumbsManager", "Breadcrumb may not be null or empty.");
            return;
        }
        long j = vVar.f4761b;
        int min = Math.min(str.length(), 250);
        this.f4768a.position((this.f4769h * 512) + f4767g);
        this.f4768a.putLong(j);
        this.f4768a.putInt(min);
        byte b = 0;
        this.f4768a.asCharBuffer().put(str, 0, min);
        short s = (short) (this.f4769h + 1);
        this.f4769h = s;
        if (s >= 207) {
            this.f4769h = 0;
            this.f4770i = true;
        }
        this.f4768a.putShort(f4765e, this.f4769h);
        ByteBuffer byteBuffer = this.f4768a;
        int i = f4766f;
        if (this.f4770i) {
            b = 1;
        }
        byteBuffer.put(i, b);
    }

    public final synchronized String toString() {
        short s;
        StringBuilder sb;
        if (this.f4768a == null) {
            s = 0;
        } else {
            s = this.f4770i ? 207 : this.f4769h;
        }
        sb = new StringBuilder();
        sb.append("Total number of breadcrumbs: " + s + "\n");
        for (C1925v vVar : mo11577a()) {
            sb.append(vVar.toString());
        }
        return sb.toString();
    }
}

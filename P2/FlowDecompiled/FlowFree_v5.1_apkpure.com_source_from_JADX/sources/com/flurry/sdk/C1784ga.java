package com.flurry.sdk;

import com.flurry.sdk.C1548be;
import com.flurry.sdk.C1720ex;
import com.flurry.sdk.C1789gd;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.flurry.sdk.ga */
public final class C1784ga extends C1730f implements C1789gd {

    /* renamed from: a */
    protected static BufferedOutputStream f4469a;

    /* renamed from: d */
    private static int f4470d;

    /* renamed from: b */
    private C1788gc f4471b;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ReentrantLock f4472e;

    public C1784ga() {
        super("BufferedFrameAppender", C1720ex.m4478a(C1720ex.C1722a.CORE));
        this.f4471b = null;
        this.f4472e = new ReentrantLock(true);
        this.f4471b = new C1788gc();
    }

    /* renamed from: a */
    public final void mo11537a(final C1895jq jqVar, final C1789gd.C1790a aVar) {
        C1648cy.m4317a(2, "BufferedFrameAppender", "Appending Frame:" + jqVar.mo11542a());
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1784ga.this.f4472e.lock();
                try {
                    C1784ga.m4622a(C1784ga.this, jqVar);
                    C1789gd.C1790a aVar = aVar;
                    if (aVar != null) {
                        aVar.mo11511a();
                    }
                } finally {
                    C1784ga.this.f4472e.unlock();
                }
            }
        });
    }

    /* renamed from: a */
    public final void mo11536a(final C1895jq jqVar) {
        C1648cy.m4317a(2, "BufferedFrameAppender", "Appending Frame:" + jqVar.mo11542a());
        runSync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                C1784ga.this.f4472e.lock();
                try {
                    C1784ga.m4622a(C1784ga.this, jqVar);
                } finally {
                    C1784ga.this.f4472e.unlock();
                }
            }
        });
    }

    /* renamed from: a */
    public final void mo11264a() {
        C1648cy.m4317a(2, "BufferedFrameAppender", "Close");
        this.f4472e.lock();
        try {
            f4470d = 0;
            C1698dz.m4444a((Closeable) f4469a);
            f4469a = null;
        } finally {
            this.f4472e.unlock();
        }
    }

    /* renamed from: a */
    public final boolean mo11538a(String str, String str2) {
        C1648cy.m4317a(2, "BufferedFrameAppender", "Open");
        this.f4472e.lock();
        boolean z = true;
        try {
            File file = new File(str, str2);
            if (!file.exists()) {
                if (!C1696dy.m4434a(file)) {
                    throw new IOException("Frame file: Error creating directory for :" + file.getAbsolutePath());
                }
            }
            f4469a = new BufferedOutputStream(new FileOutputStream(file, true));
            try {
                f4470d = 0;
            } catch (IOException e) {
                e = e;
            }
        } catch (IOException e2) {
            e = e2;
            z = false;
            try {
                C1648cy.m4317a(6, "BufferedFrameAppender", "Error in opening file:" + str2 + " Message:" + e.getMessage());
                this.f4472e.unlock();
                return z;
            } catch (Throwable th) {
                this.f4472e.unlock();
                throw th;
            }
        }
        this.f4472e.unlock();
        return z;
    }

    /* renamed from: b */
    public final void mo11539b() {
        C1893jo joVar;
        this.f4472e.lock();
        try {
            if (mo11540c()) {
                mo11264a();
            }
            C1897js jsVar = new C1897js(C1740ff.m4521c(), "currentFile");
            File file = new File(jsVar.f4694a, jsVar.f4695b);
            C1548be.C1550b a = C1787gb.m4631a(file);
            boolean z = false;
            if (a != C1548be.C1550b.SUCCEED) {
                C1548be a2 = C1548be.m4072a();
                HashMap hashMap = new HashMap();
                hashMap.put("fl.length", String.valueOf(a.f3929h));
                hashMap.put("fl.frame.count", String.valueOf(a.f3930i));
                List<C1893jo> list = a.f3931j;
                if (list == null || list.isEmpty()) {
                    joVar = C1893jo.UNKNOWN;
                } else {
                    List<C1893jo> list2 = a.f3931j;
                    joVar = list2.get(list2.size() - 1);
                }
                hashMap.put("fl.last.frame.type", String.valueOf(joVar));
                hashMap.put("fl.failure.type", String.valueOf(a));
                hashMap.put("fl.failure.reason", a.f3928g);
                hashMap.put("fl.mandatory.frames", String.valueOf(a.f3932k));
                a.f3928g = null;
                a.f3929h = 0;
                a.f3930i = 0;
                a.f3931j = null;
                a.f3932k = null;
                a2.f3917a++;
                C1548be.m4074a("Flurry.SDKReport.PayloadError", hashMap);
                C1648cy.m4317a(5, "BufferedFrameAppender", "File deleted status: " + file.delete() + " InProgress.");
            } else {
                C1897js jsVar2 = new C1897js(C1740ff.m4519b(), String.format(Locale.US, "completed-%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                if (C1742fg.m4523a(jsVar, jsVar2)) {
                    if (C1742fg.m4524a(jsVar.f4694a, jsVar.f4695b, jsVar2.f4694a, jsVar2.f4695b)) {
                        boolean a3 = C1898jt.m4788a(jsVar, jsVar2);
                        z = a3 ? C1898jt.m4787a(jsVar) : a3;
                    }
                }
                C1648cy.m4317a(4, "BufferedFrameAppender", "File moved status: " + z + " InProgress to Completed.");
            }
        } finally {
            this.f4472e.unlock();
        }
    }

    /* renamed from: c */
    public final boolean mo11540c() {
        return f4469a != null;
    }

    /* renamed from: a */
    static /* synthetic */ void m4622a(C1784ga gaVar, C1895jq jqVar) {
        boolean z = true;
        f4470d++;
        byte[] a = gaVar.f4471b.mo11541a(jqVar);
        if (a != null) {
            try {
                f4469a.write(a);
                f4469a.flush();
            } catch (IOException e) {
                C1648cy.m4317a(2, "BufferedFrameAppender", "Error appending frame:" + e.getMessage());
            }
            C1648cy.m4317a(2, "BufferedFrameAppender", "Appending Frame " + jqVar.mo11542a() + " frameSaved:" + z + " frameCount:" + f4470d);
        }
        z = false;
        C1648cy.m4317a(2, "BufferedFrameAppender", "Appending Frame " + jqVar.mo11542a() + " frameSaved:" + z + " frameCount:" + f4470d);
    }
}

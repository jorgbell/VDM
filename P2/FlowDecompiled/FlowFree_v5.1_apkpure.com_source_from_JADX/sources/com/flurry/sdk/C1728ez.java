package com.flurry.sdk;

import com.flurry.sdk.C1548be;
import com.flurry.sdk.C1720ex;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;

/* renamed from: com.flurry.sdk.ez */
public final class C1728ez extends C1730f implements C1896jr {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PriorityQueue<String> f4335a;

    /* renamed from: a */
    public final void mo11264a() {
    }

    public C1728ez() {
        super("FrameLogTestHandler", C1720ex.m4478a(C1720ex.C1722a.CORE));
        this.f4335a = null;
        this.f4335a = new PriorityQueue<>(4, new C1743fh());
    }

    /* renamed from: a */
    public final void mo11493a(final List<String> list) {
        if (list.size() == 0) {
            C1648cy.m4325b("FrameLogTestHandler", "File List is null or empty");
            return;
        }
        C1648cy.m4325b("FrameLogTestHandler", "Number of files being added:" + list.toString());
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1728ez.this.f4335a.addAll(list);
                C1728ez.this.m4496c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4496c() {
        C1648cy.m4325b("FrameLogTestHandler", " Starting processNextFile " + this.f4335a.size());
        if (this.f4335a.peek() == null) {
            C1648cy.m4325b("FrameLogTestHandler", "No file present to process.");
            return;
        }
        String poll = this.f4335a.poll();
        if (C1740ff.m4520b(poll)) {
            File file = new File(poll);
            File a = C1696dy.m4432a();
            boolean a2 = C1898jt.m4789a(file, new File(a.toString() + File.separator + "fCompletedInApp", String.format(Locale.US, "completedInApp-%d", new Object[]{Long.valueOf(System.currentTimeMillis())})));
            if (a2) {
                a2 = file.delete();
            }
            m4494a(poll, a2);
        }
    }

    /* renamed from: a */
    private synchronized void m4494a(String str, boolean z) {
        C1648cy.m4325b("FrameLogTestHandler", "File move to test folder for file: " + str + " fileMoved:" + z);
        boolean a = C1740ff.m4518a(str);
        C1648cy.m4317a(2, "FrameLogTestHandler", "Deleting file " + str + " deleted " + a);
        m4496c();
    }

    /* renamed from: b */
    public final C1548be.C1551c mo11494b() {
        C1548be.C1551c cVar = new C1548be.C1551c();
        cVar.f3934a = this.f4335a.size();
        return cVar;
    }
}

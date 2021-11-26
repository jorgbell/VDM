package com.flurry.sdk;

import com.flurry.sdk.C1548be;
import com.flurry.sdk.C1720ex;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

/* renamed from: com.flurry.sdk.ey */
public final class C1725ey extends C1730f implements C1896jr {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PriorityQueue<String> f4329a;

    /* renamed from: b */
    private C1566bn f4330b;

    /* renamed from: d */
    private C1566bn f4331d;

    public C1725ey() {
        super("FrameLogDataSender", C1720ex.m4478a(C1720ex.C1722a.CORE));
        this.f4329a = null;
        this.f4329a = new PriorityQueue<>(4, new C1743fh());
        this.f4330b = new C1590bs();
        this.f4331d = new C1589br();
    }

    /* renamed from: a */
    public final void mo11264a() {
        this.f4330b.mo11264a();
        this.f4331d.mo11264a();
    }

    /* renamed from: a */
    public final void mo11493a(final List<String> list) {
        if (list.size() == 0) {
            C1648cy.m4317a(6, "FrameLogDataSender", "File List is null or empty");
            return;
        }
        C1648cy.m4329c("FrameLogDataSender", "Number of files being added:" + list.toString());
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() throws Exception {
                C1725ey.this.f4329a.addAll(list);
                C1725ey.this.m4486c();
            }
        });
    }

    /* renamed from: a */
    private static byte[] m4484a(File file) throws IOException {
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int read = fileInputStream.read(bArr, 0, length);
            if (read < length) {
                int i = length - read;
                while (i > 0) {
                    int read2 = fileInputStream.read(bArr2, 0, i);
                    System.arraycopy(bArr2, 0, bArr, length - i, read2);
                    i -= read2;
                }
            }
        } catch (IOException e) {
            C1648cy.m4317a(6, "FrameLogDataSender", "Error reading file. ".concat(String.valueOf(e)));
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
        fileInputStream.close();
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4486c() {
        C1648cy.m4329c("FrameLogDataSender", " Starting processNextFile " + this.f4329a.size());
        if (this.f4329a.peek() == null) {
            C1648cy.m4329c("FrameLogDataSender", "No file present to process.");
            return;
        }
        String poll = this.f4329a.poll();
        if (C1740ff.m4520b(poll)) {
            C1648cy.m4329c("FrameLogDataSender", "Starting to upload file: ".concat(String.valueOf(poll)));
            byte[] bArr = new byte[0];
            try {
                bArr = m4484a(new File(poll));
            } catch (IOException e) {
                C1648cy.m4317a(6, "FrameLogDataSender", "Error in getting bytes form the file: " + e.getMessage());
            }
            String b = C1561bi.m4088a().mo11318b();
            StringBuilder sb = new StringBuilder();
            C1564bl.m4094a();
            sb.append(322);
            this.f4330b.mo11325a(bArr, b, sb.toString());
            this.f4330b.mo11324a((C1565bm) new C1565bm() {
                /* renamed from: a */
                public final void mo11321a() {
                    C1735fb.m4502a().mo11504a(new C1878ja(new C1879jb(true)));
                }

                /* renamed from: b */
                public final void mo11322b() {
                    C1735fb.m4502a().mo11504a(new C1878ja(new C1879jb(false)));
                }
            });
            m4482a(poll);
            C1648cy.m4329c("FrameLogDataSender", "File appended for upload: ".concat(String.valueOf(poll)));
            return;
        }
        C1648cy.m4317a(6, "FrameLogDataSender", "Something wrong with the file. File does not exist.");
    }

    /* renamed from: a */
    private synchronized void m4482a(String str) {
        C1648cy.m4329c("FrameLogDataSender", "File upload status: ".concat(String.valueOf(str)));
        boolean a = C1740ff.m4518a(str);
        C1648cy.m4317a(2, "FrameLogDataSender", "Deleting file " + str + " deleted " + a);
        m4486c();
    }

    /* renamed from: b */
    public final C1548be.C1551c mo11494b() {
        C1566bn bnVar = this.f4330b;
        C1548be.C1551c cVar = new C1548be.C1551c();
        for (String f : bnVar.f3965f.mo11333a()) {
            cVar.f3934a += bnVar.f3965f.mo11339f(f).size();
        }
        return cVar;
    }
}

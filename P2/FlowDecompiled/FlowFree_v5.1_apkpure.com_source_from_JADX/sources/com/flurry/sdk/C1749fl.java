package com.flurry.sdk;

import com.flurry.sdk.C1752fm;
import com.flurry.sdk.C1762fr;
import com.flurry.sdk.C1789gd;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* renamed from: com.flurry.sdk.fl */
public final class C1749fl extends C1762fr {

    /* renamed from: a */
    protected C1789gd f4368a;

    /* renamed from: b */
    protected C1898jt f4369b;

    C1749fl() {
        super("FileWriterModule", (C1752fm) null);
        this.f4368a = null;
        this.f4369b = null;
        this.f4368a = new C1784ga();
        this.f4369b = new C1898jt();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4539a(String str) {
        if (this.f4368a.mo11540c()) {
            C1648cy.m4317a(6, "FileWriterModule", "File was open, closing now.");
            this.f4368a.mo11264a();
        }
        return this.f4368a.mo11538a(C1740ff.m4521c(), str);
    }

    /* renamed from: b */
    public final C1752fm.C1753a mo11510b(C1895jq jqVar) {
        C1784ga gaVar = new C1784ga();
        if (gaVar.mo11538a(C1740ff.m4521c(), "crashFile")) {
            gaVar.mo11536a(jqVar);
            gaVar.mo11264a();
        } else {
            C1648cy.m4317a(4, "FileWriterModule", "Can't create crash file. Cannot write crash frame to disc");
        }
        return C1752fm.C1753a.QUEUED;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01a8  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.flurry.sdk.C1801gl m4540e() {
        /*
            r0 = 4
            java.lang.String r1 = "FileWriterModule"
            java.lang.String r2 = "Start getting native crash entity."
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r2)
            android.content.Context r2 = com.flurry.sdk.C1536b.m4057a()
            java.lang.String r3 = ".yflurrynativecrash"
            java.io.File r2 = r2.getFileStreamPath(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = ".*"
            r3.<init>(r4)
            java.lang.String r5 = ".dmp"
            java.lang.String r5 = java.util.regex.Pattern.quote(r5)
            r3.append(r5)
            java.lang.String r5 = "$"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)
            boolean r5 = r2.exists()
            r6 = 0
            if (r5 != 0) goto L_0x0039
            java.lang.String[] r3 = new java.lang.String[r6]
            goto L_0x0046
        L_0x0039:
            com.flurry.sdk.ff$1 r5 = new com.flurry.sdk.ff$1
            r5.<init>(r3)
            java.lang.String[] r3 = r2.list(r5)
            if (r3 != 0) goto L_0x0046
            java.lang.String[] r3 = new java.lang.String[r6]
        L_0x0046:
            r5 = 0
            if (r3 == 0) goto L_0x01b8
            int r7 = r3.length
            if (r7 != 0) goto L_0x004e
            goto L_0x01b8
        L_0x004e:
            int r7 = r3.length
            r9 = r5
            r8 = 0
        L_0x0051:
            if (r8 >= r7) goto L_0x01b2
            r10 = r3[r8]
            java.lang.String r11 = java.lang.String.valueOf(r10)
            java.lang.String r12 = "Native crash occurred in previous session! Found minidump file - "
            java.lang.String r11 = r12.concat(r11)
            com.flurry.sdk.C1648cy.m4329c(r1, r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            java.lang.String r12 = ".fcb"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r4)
            java.lang.String r11 = java.util.regex.Pattern.quote(r11)
            r12.append(r11)
            r12.append(r4)
            java.lang.String r11 = r12.toString()
            java.util.regex.Pattern r11 = java.util.regex.Pattern.compile(r11)
            java.lang.String[] r11 = com.flurry.sdk.C1696dy.m4435a((java.io.File) r2, (java.util.regex.Pattern) r11)
            int r12 = r11.length
            if (r12 <= 0) goto L_0x0094
            r11 = r11[r6]
            goto L_0x0095
        L_0x0094:
            r11 = r5
        L_0x0095:
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 == 0) goto L_0x00a2
            java.lang.String r12 = "There was no breadcrumbs file associated with the minidump file."
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r12)
            r12 = 1
            goto L_0x00a3
        L_0x00a2:
            r12 = 0
        L_0x00a3:
            java.lang.String r14 = java.lang.String.valueOf(r11)
            java.lang.String r15 = "Breadcrumbs file associated with minidump file - "
            java.lang.String r14 = r15.concat(r14)
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r14)
            boolean r14 = android.text.TextUtils.isEmpty(r11)
            r15 = 5
            java.lang.String r6 = "\\."
            if (r14 == 0) goto L_0x00bb
        L_0x00b9:
            r13 = r5
            goto L_0x00c6
        L_0x00bb:
            java.lang.String[] r14 = r11.split(r6)
            int r13 = r14.length
            if (r13 == r15) goto L_0x00c3
            goto L_0x00b9
        L_0x00c3:
            r13 = 3
            r13 = r14[r13]
        L_0x00c6:
            boolean r14 = android.text.TextUtils.isEmpty(r11)
            if (r14 == 0) goto L_0x00ce
        L_0x00cc:
            r6 = r5
            goto L_0x00d8
        L_0x00ce:
            java.lang.String[] r6 = r11.split(r6)
            int r14 = r6.length
            if (r14 == r15) goto L_0x00d6
            goto L_0x00cc
        L_0x00d6:
            r6 = r6[r0]
        L_0x00d8:
            boolean r14 = android.text.TextUtils.isEmpty(r13)
            if (r14 == 0) goto L_0x00ec
            java.lang.String r12 = java.lang.String.valueOf(r11)
            java.lang.String r14 = "There is no session id specified with crash breadcrumbs file: "
            java.lang.String r12 = r14.concat(r12)
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r12)
            r12 = 1
        L_0x00ec:
            long r14 = java.lang.System.currentTimeMillis()
            java.lang.Long.parseLong(r13)     // Catch:{ NumberFormatException -> 0x00fa }
            long r14 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x00fa }
            r19 = r14
            goto L_0x010a
        L_0x00fa:
            java.lang.String r6 = java.lang.String.valueOf(r13)
            java.lang.String r12 = "Issue parsing session id into start time: "
            java.lang.String r6 = r12.concat(r6)
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r6)
            r19 = r14
            r12 = 1
        L_0x010a:
            java.io.File r6 = new java.io.File
            r6.<init>(r2, r11)
            boolean r11 = r6.exists()
            if (r11 == 0) goto L_0x013a
            com.flurry.sdk.w r11 = new com.flurry.sdk.w
            r11.<init>(r6)
            java.util.List r11 = r11.mo11577a()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Number of crash breadcrumbs - "
            r13.<init>(r14)
            int r14 = r11.size()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r13)
            r6.delete()
            r29 = r11
            r13 = r12
            goto L_0x0142
        L_0x013a:
            java.lang.String r6 = "Breadcrumbs file does not exist."
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r6)
            r29 = r5
            r13 = 1
        L_0x0142:
            com.flurry.sdk.y r6 = com.flurry.sdk.C1928y.NATIVE_CRASH
            java.lang.String r6 = r6.f4774c
            java.io.File r11 = new java.io.File
            r11.<init>(r2, r10)
            boolean r10 = r11.exists()
            if (r10 == 0) goto L_0x01a8
            if (r13 == 0) goto L_0x015c
            java.lang.String r6 = "Some error occurred with minidump file. Deleting it."
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r6)
            r11.delete()
            goto L_0x01ad
        L_0x015c:
            java.lang.String r30 = com.flurry.sdk.C1696dy.m4438c(r11)
            r11.delete()
            java.lang.String r31 = m4541f()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Logcat size: "
            r9.<init>(r10)
            int r10 = r31.length()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r9)
            java.util.concurrent.atomic.AtomicInteger r9 = com.flurry.sdk.C1798gk.m4652b()
            int r17 = r9.incrementAndGet()
            com.flurry.sdk.gl r9 = new com.flurry.sdk.gl
            com.flurry.sdk.gk$a r10 = com.flurry.sdk.C1798gk.C1799a.UNRECOVERABLE_CRASH
            int r10 = r10.f4488d
            com.flurry.sdk.gk$b r11 = com.flurry.sdk.C1798gk.C1800b.NATIVE_CRASH_ATTACHED
            int r11 = r11.f4493d
            r26 = 0
            r27 = 0
            int r28 = com.flurry.sdk.C1926w.m4822b()
            java.lang.String r21 = ""
            java.lang.String r22 = ""
            java.lang.String r23 = ""
            r16 = r9
            r18 = r6
            r24 = r10
            r25 = r11
            r16.<init>(r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            goto L_0x01ad
        L_0x01a8:
            java.lang.String r6 = "Minidump file doesn't exist."
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r6)
        L_0x01ad:
            int r8 = r8 + 1
            r6 = 0
            goto L_0x0051
        L_0x01b2:
            java.lang.String r2 = "Finished getting native crash entity."
            com.flurry.sdk.C1648cy.m4317a((int) r0, (java.lang.String) r1, (java.lang.String) r2)
            return r9
        L_0x01b8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C1749fl.m4540e():com.flurry.sdk.gl");
    }

    /* renamed from: f */
    private static String m4541f() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d").getInputStream()));
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || i >= 1000 || sb.length() + readLine.length() > 524288) {
                    C1648cy.m4317a(4, "FileWriterModule", "Get Logcat lines: ".concat(String.valueOf(i)));
                } else {
                    sb.append(readLine);
                    sb.append("\n");
                    i++;
                }
            }
            C1648cy.m4317a(4, "FileWriterModule", "Get Logcat lines: ".concat(String.valueOf(i)));
            return sb.toString();
        } catch (IOException unused) {
            return "";
        }
    }

    /* renamed from: a_ */
    public final void mo11509a_() {
        C1740ff.m4517a();
        File file = new File(C1740ff.m4521c());
        if (!file.exists()) {
            file.mkdirs();
        }
        C1740ff.m4517a();
        File file2 = new File(C1740ff.m4519b());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        C1801gl e = m4540e();
        C1798gk a = e != null ? C1798gk.m4650a(e) : null;
        StringBuilder sb = new StringBuilder();
        sb.append(C1740ff.m4521c());
        String str = File.separator;
        sb.append(str);
        sb.append("currentFile");
        if (C1740ff.m4520b(sb.toString())) {
            if (C1740ff.m4520b(C1740ff.m4521c() + str + "crashFile")) {
                C1897js jsVar = new C1897js(C1740ff.m4521c(), "currentFile");
                C1897js jsVar2 = new C1897js(C1740ff.m4521c(), "crashFile");
                if (C1742fg.m4523a(jsVar, jsVar2)) {
                    if (C1742fg.m4524a(jsVar.f4694a, jsVar.f4695b, jsVar2.f4694a, jsVar2.f4695b) && C1898jt.m4790b(jsVar, jsVar2)) {
                        C1898jt.m4787a(jsVar2);
                    }
                }
                C1898jt.m4787a(jsVar2);
            }
            this.f4368a.mo11539b();
        }
        if (m4539a("currentFile")) {
            this.f4368a.mo11537a((C1895jq) C1867iq.m4732b(), (C1789gd.C1790a) null);
            if (a != null) {
                this.f4368a.mo11536a(a);
            }
        }
    }

    /* renamed from: a */
    public final void mo11508a(final C1895jq jqVar) {
        if (this.f4396e == C1762fr.C1767b.f4405c) {
            this.f4397f.add(jqVar);
            C1648cy.m4317a(4, "FileWriterModule", "In paused state, cannot process message now. " + jqVar.mo11542a());
            return;
        }
        runAsync(new C1702eb() {
            /* renamed from: a */
            public final void mo11257a() {
                if (!C1749fl.this.f4368a.mo11540c()) {
                    if (C1749fl.this.m4539a("currentFile")) {
                        C1648cy.m4317a(4, "FileWriterModule", "File created. Adding counter");
                        C1749fl.this.f4368a.mo11537a((C1895jq) C1867iq.m4732b(), (C1789gd.C1790a) null);
                    } else {
                        C1648cy.m4317a(4, "FileWriterModule", "File creation failed.");
                    }
                }
                if (jqVar.mo11542a().equals(C1893jo.FLUSH_FRAME)) {
                    C1749fl.this.f4396e = C1762fr.C1767b.f4405c;
                    C1648cy.m4317a(4, "FileWriterModule", "Adding flush frame:" + jqVar.mo11559e());
                    C1749fl.this.f4368a.mo11537a(jqVar, (C1789gd.C1790a) new C1789gd.C1790a() {
                        /* renamed from: a */
                        public final void mo11511a() {
                            C1749fl.this.f4396e = C1762fr.C1767b.f4405c;
                            C1749fl.this.f4368a.mo11539b();
                            C1749fl.this.f4396e = C1762fr.C1767b.f4406d;
                            C1749fl.this.mo11525d();
                        }
                    });
                    return;
                }
                C1648cy.m4317a(4, "FileWriterModule", "Adding frame " + jqVar.mo11542a() + ": " + jqVar.mo11559e());
                C1749fl.this.f4368a.mo11537a(jqVar, (C1789gd.C1790a) null);
            }
        });
    }
}

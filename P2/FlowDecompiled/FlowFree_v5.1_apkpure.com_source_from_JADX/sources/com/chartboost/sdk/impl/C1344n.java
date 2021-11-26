package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.C1220g;
import com.chartboost.sdk.Libraries.C1224j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1229b;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Networking.C1247g;
import com.chartboost.sdk.Networking.C1248h;
import java.io.File;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.chartboost.sdk.impl.n */
public class C1344n {

    /* renamed from: a */
    private final Executor f3294a;

    /* renamed from: b */
    private final C1247g f3295b;

    /* renamed from: c */
    private final C1248h f3296c;

    /* renamed from: d */
    private final AtomicReference<C1236h> f3297d;

    /* renamed from: e */
    private final C1224j f3298e;

    /* renamed from: f */
    private final C1220g f3299f;

    /* renamed from: g */
    int f3300g = 1;

    /* renamed from: h */
    private C1339m f3301h = null;

    /* renamed from: i */
    private final PriorityQueue<C1334l> f3302i;

    /* renamed from: com.chartboost.sdk.impl.n$a */
    class C1345a implements Comparator<File> {
        C1345a(C1344n nVar) {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    public C1344n(Executor executor, C1220g gVar, C1247g gVar2, C1248h hVar, AtomicReference<C1236h> atomicReference, C1224j jVar) {
        this.f3294a = executor;
        this.f3299f = gVar;
        this.f3295b = gVar2;
        this.f3296c = hVar;
        this.f3297d = atomicReference;
        this.f3298e = jVar;
        this.f3302i = new PriorityQueue<>();
    }

    /* renamed from: d */
    private void m3633d() {
        C1334l poll;
        C1334l peek;
        if (!(this.f3301h == null || (peek = this.f3302i.peek()) == null)) {
            C1339m mVar = this.f3301h;
            if (mVar.f3281l.f3261b > peek.f3261b && mVar.mo10146b()) {
                this.f3302i.add(this.f3301h.f3281l);
                this.f3301h = null;
            }
        }
        while (this.f3301h == null && (poll = this.f3302i.poll()) != null) {
            if (poll.f3266g.get() > 0) {
                File file = new File(this.f3299f.mo10046a().f2680a, poll.f3264e);
                if (file.exists() || file.mkdirs() || file.isDirectory()) {
                    File file2 = new File(file, poll.f3262c);
                    if (file2.exists()) {
                        this.f3299f.mo10052c(file2);
                        poll.mo10501a(this.f3294a, true);
                    } else {
                        C1339m mVar2 = new C1339m(this, this.f3296c, poll, file2);
                        this.f3301h = mVar2;
                        this.f3295b.mo10147a(mVar2);
                    }
                } else {
                    CBLogging.m2905b("Downloader", "Unable to create directory " + file.getPath());
                    poll.mo10501a(this.f3294a, false);
                }
            }
        }
        if (this.f3301h != null) {
            if (this.f3300g != 2) {
                CBLogging.m2903a("Downloader", "Change state to DOWNLOADING");
                this.f3300g = 2;
            }
        } else if (this.f3300g != 1) {
            CBLogging.m2903a("Downloader", "Change state to IDLE");
            this.f3300g = 1;
        }
    }

    /* renamed from: a */
    public synchronized void mo10519a(int i, Map<String, C1229b> map, AtomicInteger atomicInteger, C1328j jVar, String str) {
        synchronized (this) {
            long b = this.f3298e.mo10067b();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            AtomicReference atomicReference = new AtomicReference(jVar);
            for (C1229b next : map.values()) {
                long j = b;
                long j2 = b;
                C1334l lVar = r2;
                C1334l lVar2 = new C1334l(this.f3298e, i, next.f2729b, next.f2730c, next.f2728a, atomicInteger, atomicReference, j, atomicInteger2, str);
                this.f3302i.add(lVar);
                atomicReference = atomicReference;
                b = j2;
            }
            int i2 = this.f3300g;
            if (i2 == 1 || i2 == 2) {
                m3633d();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x013b A[Catch:{ Exception -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x017c A[SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo10522b() {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            int r0 = r1.f3300g     // Catch:{ all -> 0x01a8 }
            r2 = 1
            if (r0 == r2) goto L_0x000a
            monitor-exit(r24)
            return
        L_0x000a:
            java.lang.String r0 = "Downloader"
            java.lang.String r3 = "########### Trimming the disk cache"
            com.chartboost.sdk.Libraries.CBLogging.m2903a(r0, r3)     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.g r0 = r1.f3299f     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.h r0 = r0.mo10046a()     // Catch:{ Exception -> 0x018b }
            java.io.File r0 = r0.f2680a     // Catch:{ Exception -> 0x018b }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x018b }
            r3.<init>()     // Catch:{ Exception -> 0x018b }
            java.lang.String[] r4 = r0.list()     // Catch:{ Exception -> 0x018b }
            if (r4 == 0) goto L_0x0065
            int r6 = r4.length     // Catch:{ Exception -> 0x018b }
            if (r6 <= 0) goto L_0x0065
            int r6 = r4.length     // Catch:{ Exception -> 0x018b }
            r7 = 0
        L_0x0029:
            if (r7 >= r6) goto L_0x0065
            r8 = r4[r7]     // Catch:{ Exception -> 0x018b }
            java.lang.String r9 = "requests"
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x018b }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = "track"
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x018b }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = "session"
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x018b }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = "videoCompletionEvents"
            boolean r9 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x018b }
            if (r9 != 0) goto L_0x0062
            java.lang.String r9 = "."
            boolean r9 = r8.contains(r9)     // Catch:{ Exception -> 0x018b }
            if (r9 == 0) goto L_0x0056
            goto L_0x0062
        L_0x0056:
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x018b }
            r9.<init>(r0, r8)     // Catch:{ Exception -> 0x018b }
            java.util.ArrayList r8 = com.chartboost.sdk.Libraries.CBUtility.m2913a((java.io.File) r9, (boolean) r2)     // Catch:{ Exception -> 0x018b }
            r3.addAll(r8)     // Catch:{ Exception -> 0x018b }
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0029
        L_0x0065:
            int r0 = r3.size()     // Catch:{ Exception -> 0x018b }
            java.io.File[] r4 = new java.io.File[r0]     // Catch:{ Exception -> 0x018b }
            r3.toArray(r4)     // Catch:{ Exception -> 0x018b }
            if (r0 <= r2) goto L_0x0078
            com.chartboost.sdk.impl.n$a r3 = new com.chartboost.sdk.impl.n$a     // Catch:{ Exception -> 0x018b }
            r3.<init>(r1)     // Catch:{ Exception -> 0x018b }
            java.util.Arrays.sort(r4, r3)     // Catch:{ Exception -> 0x018b }
        L_0x0078:
            if (r0 <= 0) goto L_0x0185
            java.util.concurrent.atomic.AtomicReference<com.chartboost.sdk.Model.h> r3 = r1.f3297d     // Catch:{ Exception -> 0x018b }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Model.h r3 = (com.chartboost.sdk.Model.C1236h) r3     // Catch:{ Exception -> 0x018b }
            int r6 = r3.f2819m     // Catch:{ Exception -> 0x018b }
            long r6 = (long) r6     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.g r8 = r1.f3299f     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.h r9 = r8.mo10046a()     // Catch:{ Exception -> 0x018b }
            java.io.File r9 = r9.f2683d     // Catch:{ Exception -> 0x018b }
            long r8 = r8.mo10045a((java.io.File) r9)     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.j r10 = r1.f3298e     // Catch:{ Exception -> 0x018b }
            long r10 = r10.mo10066a()     // Catch:{ Exception -> 0x018b }
            java.util.List<java.lang.String> r12 = r3.f2810d     // Catch:{ Exception -> 0x018b }
            java.lang.String r13 = "Downloader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
            r14.<init>()     // Catch:{ Exception -> 0x018b }
            java.lang.String r15 = "Total local file count:"
            r14.append(r15)     // Catch:{ Exception -> 0x018b }
            r14.append(r0)     // Catch:{ Exception -> 0x018b }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.CBLogging.m2903a(r13, r14)     // Catch:{ Exception -> 0x018b }
            java.lang.String r13 = "Downloader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
            r14.<init>()     // Catch:{ Exception -> 0x018b }
            java.lang.String r15 = "Video Folder Size in bytes :"
            r14.append(r15)     // Catch:{ Exception -> 0x018b }
            r14.append(r8)     // Catch:{ Exception -> 0x018b }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.CBLogging.m2903a(r13, r14)     // Catch:{ Exception -> 0x018b }
            java.lang.String r13 = "Downloader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
            r14.<init>()     // Catch:{ Exception -> 0x018b }
            java.lang.String r15 = "Max Bytes allowed:"
            r14.append(r15)     // Catch:{ Exception -> 0x018b }
            r14.append(r6)     // Catch:{ Exception -> 0x018b }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.CBLogging.m2903a(r13, r14)     // Catch:{ Exception -> 0x018b }
            r13 = 0
        L_0x00dc:
            if (r13 >= r0) goto L_0x0185
            r14 = r4[r13]     // Catch:{ Exception -> 0x018b }
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x018b }
            long r16 = r14.lastModified()     // Catch:{ Exception -> 0x018b }
            r18 = r6
            long r5 = r10 - r16
            long r5 = r15.toDays(r5)     // Catch:{ Exception -> 0x018b }
            int r7 = r3.f2821o     // Catch:{ Exception -> 0x018b }
            r16 = r3
            long r2 = (long) r7     // Catch:{ Exception -> 0x018b }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 < 0) goto L_0x00f9
            r2 = 1
            goto L_0x00fa
        L_0x00f9:
            r2 = 0
        L_0x00fa:
            java.lang.String r3 = r14.getName()     // Catch:{ Exception -> 0x018b }
            java.lang.String r5 = ".tmp"
            boolean r3 = r3.endsWith(r5)     // Catch:{ Exception -> 0x018b }
            java.io.File r5 = r14.getParentFile()     // Catch:{ Exception -> 0x018b }
            java.lang.String r6 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x018b }
            java.lang.String r7 = "/videos"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x018b }
            int r7 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r7 <= 0) goto L_0x011a
            if (r6 == 0) goto L_0x011a
            r7 = 1
            goto L_0x011b
        L_0x011a:
            r7 = 0
        L_0x011b:
            long r20 = r14.length()     // Catch:{ Exception -> 0x018b }
            r22 = 0
            int r17 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r17 == 0) goto L_0x0138
            if (r3 != 0) goto L_0x0138
            if (r2 != 0) goto L_0x0138
            java.lang.String r2 = r5.getName()     // Catch:{ Exception -> 0x018b }
            boolean r2 = r12.contains(r2)     // Catch:{ Exception -> 0x018b }
            if (r2 != 0) goto L_0x0138
            if (r7 == 0) goto L_0x0136
            goto L_0x0138
        L_0x0136:
            r2 = 0
            goto L_0x0139
        L_0x0138:
            r2 = 1
        L_0x0139:
            if (r2 == 0) goto L_0x017c
            if (r6 == 0) goto L_0x0142
            long r2 = r14.length()     // Catch:{ Exception -> 0x018b }
            long r8 = r8 - r2
        L_0x0142:
            java.lang.String r2 = "Downloader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
            r3.<init>()     // Catch:{ Exception -> 0x018b }
            java.lang.String r5 = "Deleting file at path:"
            r3.append(r5)     // Catch:{ Exception -> 0x018b }
            java.lang.String r5 = r14.getPath()     // Catch:{ Exception -> 0x018b }
            r3.append(r5)     // Catch:{ Exception -> 0x018b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.CBLogging.m2903a(r2, r3)     // Catch:{ Exception -> 0x018b }
            boolean r2 = r14.delete()     // Catch:{ Exception -> 0x018b }
            if (r2 != 0) goto L_0x017c
            java.lang.String r2 = "Downloader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
            r3.<init>()     // Catch:{ Exception -> 0x018b }
            java.lang.String r5 = "Unable to delete "
            r3.append(r5)     // Catch:{ Exception -> 0x018b }
            java.lang.String r5 = r14.getPath()     // Catch:{ Exception -> 0x018b }
            r3.append(r5)     // Catch:{ Exception -> 0x018b }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x018b }
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r2, r3)     // Catch:{ Exception -> 0x018b }
        L_0x017c:
            int r13 = r13 + 1
            r3 = r16
            r6 = r18
            r2 = 1
            goto L_0x00dc
        L_0x0185:
            com.chartboost.sdk.Libraries.g r0 = r1.f3299f     // Catch:{ Exception -> 0x018b }
            r0.mo10048b()     // Catch:{ Exception -> 0x018b }
            goto L_0x01a6
        L_0x018b:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a8 }
            r2.<init>()     // Catch:{ all -> 0x01a8 }
            java.lang.String r3 = "reduceCacheSize: "
            r2.append(r3)     // Catch:{ all -> 0x01a8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01a8 }
            r2.append(r0)     // Catch:{ all -> 0x01a8 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01a8 }
            java.lang.String r2 = "Downloader"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r2, r0)     // Catch:{ all -> 0x01a8 }
        L_0x01a6:
            monitor-exit(r24)
            return
        L_0x01a8:
            r0 = move-exception
            monitor-exit(r24)
            goto L_0x01ac
        L_0x01ab:
            throw r0
        L_0x01ac:
            goto L_0x01ab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1344n.mo10522b():void");
    }

    /* renamed from: c */
    public synchronized void mo10523c() {
        int i = this.f3300g;
        if (i == 3) {
            CBLogging.m2903a("Downloader", "Change state to DOWNLOADING");
            this.f3300g = 2;
        } else if (i == 4) {
            CBLogging.m2903a("Downloader", "Change state to IDLE");
            this.f3300g = 1;
            m3633d();
        }
    }

    /* renamed from: a */
    public synchronized void mo10521a(AtomicInteger atomicInteger) {
        atomicInteger.set(-10000);
        if (this.f3300g == 2) {
            C1339m mVar = this.f3301h;
            if ((mVar.f3281l.f3266g == atomicInteger) && mVar.mo10146b()) {
                this.f3301h = null;
                m3633d();
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo10518a() {
        int i = this.f3300g;
        if (i == 1) {
            CBLogging.m2903a("Downloader", "Change state to PAUSED");
            this.f3300g = 4;
        } else if (i == 2) {
            if (this.f3301h.mo10146b()) {
                this.f3302i.add(this.f3301h.f3281l);
                this.f3301h = null;
                CBLogging.m2903a("Downloader", "Change state to PAUSED");
                this.f3300g = 4;
            } else {
                CBLogging.m2903a("Downloader", "Change state to PAUSING");
                this.f3300g = 3;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f0, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo10520a(com.chartboost.sdk.impl.C1339m r7, com.chartboost.sdk.Model.CBError r8, com.chartboost.sdk.Networking.C1246f r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r6.f3300g     // Catch:{ all -> 0x00f1 }
            r1 = 2
            r2 = 3
            if (r0 == r1) goto L_0x000b
            if (r0 == r2) goto L_0x000b
            goto L_0x00ef
        L_0x000b:
            com.chartboost.sdk.impl.m r0 = r6.f3301h     // Catch:{ all -> 0x00f1 }
            if (r7 == r0) goto L_0x0011
            monitor-exit(r6)
            return
        L_0x0011:
            com.chartboost.sdk.impl.l r0 = r7.f3281l     // Catch:{ all -> 0x00f1 }
            r1 = 0
            r6.f3301h = r1     // Catch:{ all -> 0x00f1 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x00f1 }
            long r3 = r7.f2852f     // Catch:{ all -> 0x00f1 }
            long r3 = r1.toMillis(r3)     // Catch:{ all -> 0x00f1 }
            java.util.concurrent.atomic.AtomicInteger r5 = r0.f3269j     // Catch:{ all -> 0x00f1 }
            int r4 = (int) r3     // Catch:{ all -> 0x00f1 }
            r5.addAndGet(r4)     // Catch:{ all -> 0x00f1 }
            java.util.concurrent.Executor r3 = r6.f3294a     // Catch:{ all -> 0x00f1 }
            if (r8 != 0) goto L_0x002a
            r4 = 1
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            r0.mo10501a(r3, r4)     // Catch:{ all -> 0x00f1 }
            long r3 = r7.f2853g     // Catch:{ all -> 0x00f1 }
            r1.toMillis(r3)     // Catch:{ all -> 0x00f1 }
            long r3 = r7.f2854h     // Catch:{ all -> 0x00f1 }
            r1.toMillis(r3)     // Catch:{ all -> 0x00f1 }
            if (r8 != 0) goto L_0x0054
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r7.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r8 = "Downloaded "
            r7.append(r8)     // Catch:{ all -> 0x00f1 }
            java.lang.String r8 = r0.f3263d     // Catch:{ all -> 0x00f1 }
            r7.append(r8)     // Catch:{ all -> 0x00f1 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00f1 }
            java.lang.String r8 = "Downloader"
            com.chartboost.sdk.Libraries.CBLogging.m2903a(r8, r7)     // Catch:{ all -> 0x00f1 }
            goto L_0x00dd
        L_0x0054:
            java.lang.String r1 = ""
            com.chartboost.sdk.impl.l r7 = r7.f3281l     // Catch:{ all -> 0x00f1 }
            if (r7 == 0) goto L_0x005c
            java.lang.String r1 = r7.f3265f     // Catch:{ all -> 0x00f1 }
        L_0x005c:
            java.lang.String r7 = r8.getErrorDesc()     // Catch:{ all -> 0x00f1 }
            java.lang.String r8 = "Downloader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r3.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r4 = "Failed to download "
            r3.append(r4)     // Catch:{ all -> 0x00f1 }
            java.lang.String r4 = r0.f3263d     // Catch:{ all -> 0x00f1 }
            r3.append(r4)     // Catch:{ all -> 0x00f1 }
            if (r9 == 0) goto L_0x0087
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r4.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r5 = " Status code="
            r4.append(r5)     // Catch:{ all -> 0x00f1 }
            int r9 = r9.f2861a     // Catch:{ all -> 0x00f1 }
            r4.append(r9)     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x00f1 }
            goto L_0x0089
        L_0x0087:
            java.lang.String r9 = ""
        L_0x0089:
            r3.append(r9)     // Catch:{ all -> 0x00f1 }
            if (r7 == 0) goto L_0x00a0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r9.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r4 = " Error message="
            r9.append(r4)     // Catch:{ all -> 0x00f1 }
            r9.append(r7)     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00f1 }
            goto L_0x00a2
        L_0x00a0:
            java.lang.String r9 = ""
        L_0x00a2:
            r3.append(r9)     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x00f1 }
            com.chartboost.sdk.Libraries.CBLogging.m2903a(r8, r9)     // Catch:{ all -> 0x00f1 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r8.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = "Name: "
            r8.append(r9)     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = r0.f3262c     // Catch:{ all -> 0x00f1 }
            r8.append(r9)     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = " Url: "
            r8.append(r9)     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = r0.f3263d     // Catch:{ all -> 0x00f1 }
            r8.append(r9)     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = " Error: "
            r8.append(r9)     // Catch:{ all -> 0x00f1 }
            r8.append(r7)     // Catch:{ all -> 0x00f1 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x00f1 }
            com.chartboost.sdk.Tracking.c r8 = new com.chartboost.sdk.Tracking.c     // Catch:{ all -> 0x00f1 }
            java.lang.String r9 = "cache_asset_download_error"
            java.lang.String r0 = ""
            r8.<init>(r9, r7, r1, r0)     // Catch:{ all -> 0x00f1 }
            com.chartboost.sdk.Tracking.C1266e.m3223e(r8)     // Catch:{ all -> 0x00f1 }
        L_0x00dd:
            int r7 = r6.f3300g     // Catch:{ all -> 0x00f1 }
            if (r7 != r2) goto L_0x00ec
            java.lang.String r7 = "Downloader"
            java.lang.String r8 = "Change state to PAUSED"
            com.chartboost.sdk.Libraries.CBLogging.m2903a(r7, r8)     // Catch:{ all -> 0x00f1 }
            r7 = 4
            r6.f3300g = r7     // Catch:{ all -> 0x00f1 }
            goto L_0x00ef
        L_0x00ec:
            r6.m3633d()     // Catch:{ all -> 0x00f1 }
        L_0x00ef:
            monitor-exit(r6)
            return
        L_0x00f1:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.C1344n.mo10520a(com.chartboost.sdk.impl.m, com.chartboost.sdk.Model.CBError, com.chartboost.sdk.Networking.f):void");
    }
}

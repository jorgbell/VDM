package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.play.core.internal.C2071at;
import com.google.android.play.core.internal.C2073av;
import com.google.android.play.core.internal.C2075ax;
import com.google.android.play.core.internal.C2084bf;
import com.google.android.play.core.splitinstall.C2157l;
import com.google.android.play.core.splitinstall.C2159o;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class SplitCompat {

    /* renamed from: a */
    private static final AtomicReference<SplitCompat> f5245a = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C2137c f5246b;

    /* renamed from: c */
    private final Set<String> f5247c = new HashSet();

    /* renamed from: d */
    private final C2135a f5248d;

    private SplitCompat(Context context) {
        try {
            C2137c cVar = new C2137c(context);
            this.f5246b = cVar;
            this.f5248d = new C2135a(cVar);
        } catch (PackageManager.NameNotFoundException e) {
            throw new C2084bf((Throwable) e);
        }
    }

    /* renamed from: a */
    public static boolean m5357a(Context context) {
        return m5361g(context, true);
    }

    /* renamed from: b */
    public static boolean m5358b() {
        return f5245a.get() != null;
    }

    /* renamed from: e */
    private static boolean m5360e() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* renamed from: g */
    private static boolean m5361g(Context context, boolean z) {
        if (m5360e()) {
            return false;
        }
        AtomicReference<SplitCompat> atomicReference = f5245a;
        boolean compareAndSet = atomicReference.compareAndSet((Object) null, new SplitCompat(context));
        SplitCompat splitCompat = atomicReference.get();
        if (compareAndSet) {
            C2157l.f5284a.mo22175b(new C2071at(context, C2150p.m5400a(), new C2073av(context, splitCompat.f5246b, new C2075ax(), (byte[]) null), splitCompat.f5246b, new C2150p()));
            C2159o.m5419b(new C2146l(splitCompat));
            C2150p.m5400a().execute(new C2147m(context));
        }
        try {
            splitCompat.m5362h(context, z);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2 A[SYNTHETIC, Splitter:B:79:0x01a2] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m5362h(android.content.Context r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r10 == 0) goto L_0x0009
            com.google.android.play.core.splitcompat.c r0 = r8.f5246b     // Catch:{ all -> 0x0242 }
            r0.mo22133a()     // Catch:{ all -> 0x0242 }
            goto L_0x0015
        L_0x0009:
            java.util.concurrent.Executor r0 = com.google.android.play.core.splitcompat.C2150p.m5400a()     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.n r1 = new com.google.android.play.core.splitcompat.n     // Catch:{ all -> 0x0242 }
            r1.<init>(r8)     // Catch:{ all -> 0x0242 }
            r0.execute(r1)     // Catch:{ all -> 0x0242 }
        L_0x0015:
            java.lang.String r0 = r9.getPackageName()     // Catch:{ all -> 0x0242 }
            r1 = 0
            android.content.pm.PackageManager r2 = r9.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0230 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r0, r1)     // Catch:{ NameNotFoundException -> 0x0230 }
            java.lang.String[] r2 = r2.splitNames     // Catch:{ NameNotFoundException -> 0x0230 }
            if (r2 != 0) goto L_0x002c
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ NameNotFoundException -> 0x0230 }
            r2.<init>()     // Catch:{ NameNotFoundException -> 0x0230 }
            goto L_0x0030
        L_0x002c:
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ NameNotFoundException -> 0x0230 }
        L_0x0030:
            com.google.android.play.core.splitcompat.c r0 = r8.f5246b     // Catch:{ all -> 0x0242 }
            java.util.Set r0 = r0.mo22141i()     // Catch:{ all -> 0x0242 }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x0242 }
            r3.<init>()     // Catch:{ all -> 0x0242 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ all -> 0x0242 }
        L_0x003f:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0242 }
            if (r5 == 0) goto L_0x0064
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.q r5 = (com.google.android.play.core.splitcompat.C2151q) r5     // Catch:{ all -> 0x0242 }
            java.lang.String r5 = r5.mo22155b()     // Catch:{ all -> 0x0242 }
            boolean r6 = r2.contains(r5)     // Catch:{ all -> 0x0242 }
            if (r6 == 0) goto L_0x003f
            if (r10 == 0) goto L_0x005d
            com.google.android.play.core.splitcompat.c r6 = r8.f5246b     // Catch:{ all -> 0x0242 }
            r6.mo22146n(r5)     // Catch:{ all -> 0x0242 }
            goto L_0x0060
        L_0x005d:
            r3.add(r5)     // Catch:{ all -> 0x0242 }
        L_0x0060:
            r4.remove()     // Catch:{ all -> 0x0242 }
            goto L_0x003f
        L_0x0064:
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x0242 }
            if (r4 != 0) goto L_0x0076
            java.util.concurrent.Executor r4 = com.google.android.play.core.splitcompat.C2150p.m5400a()     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.o r5 = new com.google.android.play.core.splitcompat.o     // Catch:{ all -> 0x0242 }
            r5.<init>(r8, r3)     // Catch:{ all -> 0x0242 }
            r4.execute(r5)     // Catch:{ all -> 0x0242 }
        L_0x0076:
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x0242 }
            r3.<init>()     // Catch:{ all -> 0x0242 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ all -> 0x0242 }
        L_0x007f:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0242 }
            if (r5 == 0) goto L_0x0099
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.q r5 = (com.google.android.play.core.splitcompat.C2151q) r5     // Catch:{ all -> 0x0242 }
            java.lang.String r5 = r5.mo22155b()     // Catch:{ all -> 0x0242 }
            boolean r6 = com.google.android.play.core.splitinstall.C2160p.m5421e(r5)     // Catch:{ all -> 0x0242 }
            if (r6 != 0) goto L_0x007f
            r3.add(r5)     // Catch:{ all -> 0x0242 }
            goto L_0x007f
        L_0x0099:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0242 }
        L_0x009d:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0242 }
            if (r4 == 0) goto L_0x00b3
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0242 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0242 }
            boolean r5 = com.google.android.play.core.splitinstall.C2160p.m5421e(r4)     // Catch:{ all -> 0x0242 }
            if (r5 != 0) goto L_0x009d
            r3.add(r4)     // Catch:{ all -> 0x0242 }
            goto L_0x009d
        L_0x00b3:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0242 }
            int r4 = r0.size()     // Catch:{ all -> 0x0242 }
            r2.<init>(r4)     // Catch:{ all -> 0x0242 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0242 }
        L_0x00c0:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0242 }
            if (r4 == 0) goto L_0x00f6
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.q r4 = (com.google.android.play.core.splitcompat.C2151q) r4     // Catch:{ all -> 0x0242 }
            java.lang.String r5 = r4.mo22155b()     // Catch:{ all -> 0x0242 }
            boolean r5 = com.google.android.play.core.splitinstall.C2160p.m5420d(r5)     // Catch:{ all -> 0x0242 }
            if (r5 != 0) goto L_0x00f2
            java.lang.String r5 = r4.mo22155b()     // Catch:{ all -> 0x0242 }
            boolean r6 = com.google.android.play.core.splitinstall.C2160p.m5420d(r5)     // Catch:{ all -> 0x0242 }
            if (r6 == 0) goto L_0x00e3
            java.lang.String r5 = ""
            goto L_0x00ec
        L_0x00e3:
            java.lang.String r6 = "\\.config\\."
            r7 = 2
            java.lang.String[] r5 = r5.split(r6, r7)     // Catch:{ all -> 0x0242 }
            r5 = r5[r1]     // Catch:{ all -> 0x0242 }
        L_0x00ec:
            boolean r5 = r3.contains(r5)     // Catch:{ all -> 0x0242 }
            if (r5 == 0) goto L_0x00c0
        L_0x00f2:
            r2.add(r4)     // Catch:{ all -> 0x0242 }
            goto L_0x00c0
        L_0x00f6:
            com.google.android.play.core.splitcompat.k r0 = new com.google.android.play.core.splitcompat.k     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.c r1 = r8.f5246b     // Catch:{ all -> 0x0242 }
            r0.<init>(r1)     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.internal.aw r1 = com.google.android.play.core.internal.C2075ax.m5191a()     // Catch:{ all -> 0x0242 }
            java.lang.ClassLoader r3 = r9.getClassLoader()     // Catch:{ all -> 0x0242 }
            if (r10 == 0) goto L_0x010f
            java.util.Set r0 = r0.mo22149a()     // Catch:{ all -> 0x0242 }
            r1.mo22047a(r3, r0)     // Catch:{ all -> 0x0242 }
            goto L_0x012d
        L_0x010f:
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x0242 }
        L_0x0113:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0242 }
            if (r5 == 0) goto L_0x012d
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.q r5 = (com.google.android.play.core.splitcompat.C2151q) r5     // Catch:{ all -> 0x0242 }
            java.util.Set r5 = r0.mo22150b(r5)     // Catch:{ all -> 0x0242 }
            if (r5 != 0) goto L_0x0129
            r4.remove()     // Catch:{ all -> 0x0242 }
            goto L_0x0113
        L_0x0129:
            r1.mo22047a(r3, r5)     // Catch:{ all -> 0x0242 }
            goto L_0x0113
        L_0x012d:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0242 }
            r0.<init>()     // Catch:{ all -> 0x0242 }
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x0242 }
        L_0x0136:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0242 }
            if (r5 == 0) goto L_0x01ab
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.q r5 = (com.google.android.play.core.splitcompat.C2151q) r5     // Catch:{ all -> 0x0242 }
            java.util.zip.ZipFile r6 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x019e }
            java.io.File r7 = r5.mo22154a()     // Catch:{ IOException -> 0x019e }
            r6.<init>(r7)     // Catch:{ IOException -> 0x019e }
            java.lang.String r7 = "classes.dex"
            java.util.zip.ZipEntry r7 = r6.getEntry(r7)     // Catch:{ IOException -> 0x019c }
            r6.close()     // Catch:{ IOException -> 0x019c }
            if (r7 == 0) goto L_0x0194
            com.google.android.play.core.splitcompat.c r6 = r8.f5246b     // Catch:{ all -> 0x0242 }
            java.lang.String r7 = r5.mo22155b()     // Catch:{ all -> 0x0242 }
            java.io.File r6 = r6.mo22140h(r7)     // Catch:{ all -> 0x0242 }
            java.io.File r7 = r5.mo22154a()     // Catch:{ all -> 0x0242 }
            boolean r6 = r1.mo22048b(r3, r6, r7, r10)     // Catch:{ all -> 0x0242 }
            if (r6 == 0) goto L_0x016b
            goto L_0x0194
        L_0x016b:
            java.io.File r5 = r5.mo22154a()     // Catch:{ all -> 0x0242 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0242 }
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0242 }
            int r6 = r6.length()     // Catch:{ all -> 0x0242 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0242 }
            int r6 = r6 + 24
            r7.<init>(r6)     // Catch:{ all -> 0x0242 }
            java.lang.String r6 = "split was not installed "
            r7.append(r6)     // Catch:{ all -> 0x0242 }
            r7.append(r5)     // Catch:{ all -> 0x0242 }
            java.lang.String r5 = "SplitCompat"
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0242 }
            android.util.Log.w(r5, r6)     // Catch:{ all -> 0x0242 }
            goto L_0x0136
        L_0x0194:
            java.io.File r5 = r5.mo22154a()     // Catch:{ all -> 0x0242 }
            r0.add(r5)     // Catch:{ all -> 0x0242 }
            goto L_0x0136
        L_0x019c:
            r9 = move-exception
            goto L_0x01a0
        L_0x019e:
            r9 = move-exception
            r6 = 0
        L_0x01a0:
            if (r6 == 0) goto L_0x01aa
            r6.close()     // Catch:{ IOException -> 0x01a6 }
            goto L_0x01aa
        L_0x01a6:
            r10 = move-exception
            com.google.android.play.core.internal.C2098bz.m5252a(r9, r10)     // Catch:{ all -> 0x0242 }
        L_0x01aa:
            throw r9     // Catch:{ all -> 0x0242 }
        L_0x01ab:
            com.google.android.play.core.splitcompat.a r10 = r8.f5248d     // Catch:{ all -> 0x0242 }
            r10.mo22131b(r9, r0)     // Catch:{ all -> 0x0242 }
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ all -> 0x0242 }
            r9.<init>()     // Catch:{ all -> 0x0242 }
            java.util.Iterator r10 = r2.iterator()     // Catch:{ all -> 0x0242 }
        L_0x01b9:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x0242 }
            if (r1 == 0) goto L_0x0222
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x0242 }
            com.google.android.play.core.splitcompat.q r1 = (com.google.android.play.core.splitcompat.C2151q) r1     // Catch:{ all -> 0x0242 }
            java.io.File r2 = r1.mo22154a()     // Catch:{ all -> 0x0242 }
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x0242 }
            if (r2 == 0) goto L_0x01fc
            java.lang.String r2 = r1.mo22155b()     // Catch:{ all -> 0x0242 }
            int r3 = r2.length()     // Catch:{ all -> 0x0242 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0242 }
            int r3 = r3 + 30
            r4.<init>(r3)     // Catch:{ all -> 0x0242 }
            java.lang.String r3 = "Split '"
            r4.append(r3)     // Catch:{ all -> 0x0242 }
            r4.append(r2)     // Catch:{ all -> 0x0242 }
            java.lang.String r2 = "' installation emulated"
            r4.append(r2)     // Catch:{ all -> 0x0242 }
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0242 }
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x0242 }
            java.lang.String r1 = r1.mo22155b()     // Catch:{ all -> 0x0242 }
            r9.add(r1)     // Catch:{ all -> 0x0242 }
            goto L_0x01b9
        L_0x01fc:
            java.lang.String r1 = r1.mo22155b()     // Catch:{ all -> 0x0242 }
            int r2 = r1.length()     // Catch:{ all -> 0x0242 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0242 }
            int r2 = r2 + 35
            r3.<init>(r2)     // Catch:{ all -> 0x0242 }
            java.lang.String r2 = "Split '"
            r3.append(r2)     // Catch:{ all -> 0x0242 }
            r3.append(r1)     // Catch:{ all -> 0x0242 }
            java.lang.String r1 = "' installation not emulated."
            r3.append(r1)     // Catch:{ all -> 0x0242 }
            java.lang.String r1 = "SplitCompat"
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0242 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0242 }
            goto L_0x01b9
        L_0x0222:
            java.util.Set<java.lang.String> r10 = r8.f5247c     // Catch:{ all -> 0x0242 }
            monitor-enter(r10)     // Catch:{ all -> 0x0242 }
            java.util.Set<java.lang.String> r0 = r8.f5247c     // Catch:{ all -> 0x022d }
            r0.addAll(r9)     // Catch:{ all -> 0x022d }
            monitor-exit(r10)     // Catch:{ all -> 0x022d }
            monitor-exit(r8)
            return
        L_0x022d:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x022d }
            throw r9     // Catch:{ all -> 0x0242 }
        L_0x0230:
            r9 = move-exception
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0242 }
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0242 }
            r2[r1] = r0     // Catch:{ all -> 0x0242 }
            java.lang.String r0 = "Cannot load data for application '%s'"
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x0242 }
            r10.<init>(r0, r9)     // Catch:{ all -> 0x0242 }
            throw r10     // Catch:{ all -> 0x0242 }
        L_0x0242:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x0246
        L_0x0245:
            throw r9
        L_0x0246:
            goto L_0x0245
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.m5362h(android.content.Context, boolean):void");
    }

    public static boolean install(Context context) {
        return m5361g(context, false);
    }
}

package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.PowerManager;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.p018a.C0536a;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p038d.C0986g;
import com.applovin.impl.sdk.utils.C1115d;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.sdk.AppLovinSdk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.applovin.impl.sdk.n */
public class C1078n {

    /* renamed from: a */
    private final Map<Integer, Thread> f2258a = new HashMap();

    /* renamed from: b */
    private final Object f2259b = new Object();

    /* renamed from: c */
    private final C1062k f2260c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Lock f2261d;

    /* renamed from: e */
    private final Runnable f2262e;

    /* renamed from: f */
    private final Runnable f2263f;

    /* renamed from: g */
    private Thread f2264g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1115d f2265h;

    public C1078n(C1062k kVar) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f2261d = reentrantLock;
        this.f2264g = null;
        this.f2265h = null;
        this.f2260c = kVar;
        reentrantLock.lock();
        this.f2262e = new Runnable() {
            public void run() {
                try {
                    C1078n.this.f2261d.lockInterruptibly();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        this.f2263f = new Runnable() {
            public void run() {
                C1115d unused = C1078n.this.f2265h = null;
                C1078n.this.mo9439a();
            }
        };
    }

    /* renamed from: a */
    private Thread m2271a(String str) {
        Thread thread = new Thread(this.f2262e, str);
        thread.setDaemon(true);
        return thread;
    }

    /* renamed from: b */
    private void m2273b() {
        Context J = this.f2260c.mo9334J();
        StringBuilder sb = new StringBuilder("ALDEBUG");
        sb.append("-");
        sb.append(AppLovinSdk.VERSION);
        sb.append("-");
        try {
            PackageInfo packageInfo = J.getPackageManager().getPackageInfo("com.google.android.webview", 0);
            sb.append("-");
            sb.append(packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        ActivityManager activityManager = (ActivityManager) J.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            sb.append("-");
            sb.append(memoryInfo.availMem / 1000000);
            sb.append("MB");
            sb.append("/");
            sb.append(memoryInfo.totalMem / 1000000);
            sb.append("MB");
            sb.append("(");
            sb.append(memoryInfo.lowMemory);
            sb.append(")");
        }
        if (C1119g.m2531d()) {
            BatteryManager batteryManager = (BatteryManager) J.getSystemService("batterymanager");
            if (batteryManager != null) {
                sb.append("-");
                sb.append(batteryManager.getIntProperty(4));
                sb.append("%");
            }
            PowerManager powerManager = (PowerManager) J.getSystemService("power");
            if (powerManager != null) {
                sb.append("(");
                sb.append(powerManager.isPowerSaveMode());
                sb.append(")");
            }
        }
        sb.append("-");
        sb.append(this.f2260c.mo9341R().mo9202b(C0986g.f1957d));
        String sb2 = sb.toString();
        if (this.f2264g == null) {
            C1107r z = this.f2260c.mo9411z();
            z.mo9584b("AppLovinSdk", "Creating ANR debug thread with name: " + sb2);
            Thread a = m2271a(sb2);
            this.f2264g = a;
            a.start();
            return;
        }
        C1107r z2 = this.f2260c.mo9411z();
        z2.mo9584b("AppLovinSdk", "Updating ANR debug thread with name: " + sb2);
        this.f2264g.setName(sb2);
    }

    /* renamed from: c */
    private String m2274c(Object obj) {
        if (obj instanceof C0733a) {
            C0733a aVar = (C0733a) obj;
            StringBuilder sb = new StringBuilder("MAX-");
            sb.append("-");
            sb.append(AppLovinSdk.VERSION);
            sb.append("-");
            sb.append(aVar.getFormat().getLabel());
            sb.append("-");
            sb.append(aVar.mo8444K());
            if (C1155o.m2673b(aVar.getCreativeId())) {
                sb.append("-");
                sb.append(aVar.getCreativeId());
            }
            return sb.toString();
        } else if (!(obj instanceof C0934g)) {
            return null;
        } else {
            C0934g gVar = (C0934g) obj;
            String label = gVar.getAdZone().mo8973b() != null ? gVar.getAdZone().mo8973b().getLabel() : "NULL";
            StringBuilder sb2 = new StringBuilder("AL-");
            sb2.append("-");
            sb2.append(AppLovinSdk.VERSION);
            sb2.append("-");
            sb2.append(label);
            sb2.append("-");
            sb2.append(gVar.getAdIdNumber());
            if (gVar instanceof C0536a) {
                sb2.append("-VAST-");
                sb2.append(((C0536a) gVar).mo7836k().mo7878a());
            }
            if (C1155o.m2673b(gVar.mo9065q())) {
                sb2.append("-DSP-");
                sb2.append(gVar.mo9065q());
            }
            return sb2.toString();
        }
    }

    /* renamed from: a */
    public void mo9439a() {
        if (((Boolean) this.f2260c.mo9350a(C0965b.f1747dO)).booleanValue() && !this.f2260c.mo9389e()) {
            long longValue = ((Long) this.f2260c.mo9350a(C0965b.f1749dQ)).longValue();
            if (longValue >= 0) {
                if (longValue > 0 && this.f2265h == null) {
                    m2273b();
                    this.f2265h = C1115d.m2514a(longValue, this.f2260c, this.f2263f);
                } else if (longValue == 0) {
                    m2273b();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9440a(java.lang.Object r7) {
        /*
            r6 = this;
            com.applovin.impl.sdk.k r0 = r6.f2260c
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r1 = com.applovin.impl.sdk.p037c.C0965b.f1747dO
            java.lang.Object r0 = r0.mo9350a(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x005b
            if (r7 != 0) goto L_0x0013
            goto L_0x005b
        L_0x0013:
            int r0 = java.lang.System.identityHashCode(r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r6.f2259b
            monitor-enter(r1)
            java.util.Map<java.lang.Integer, java.lang.Thread> r2 = r6.f2258a     // Catch:{ all -> 0x0058 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0056
            java.lang.String r7 = r6.m2274c(r7)     // Catch:{ all -> 0x0058 }
            if (r7 != 0) goto L_0x002e
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            return
        L_0x002e:
            com.applovin.impl.sdk.k r2 = r6.f2260c     // Catch:{ all -> 0x0058 }
            com.applovin.impl.sdk.r r2 = r2.mo9411z()     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = "AppLovinSdk"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r4.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r5 = "Creating ad debug thread with name: "
            r4.append(r5)     // Catch:{ all -> 0x0058 }
            r4.append(r7)     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0058 }
            r2.mo9584b(r3, r4)     // Catch:{ all -> 0x0058 }
            java.lang.Thread r7 = r6.m2271a((java.lang.String) r7)     // Catch:{ all -> 0x0058 }
            r7.start()     // Catch:{ all -> 0x0058 }
            java.util.Map<java.lang.Integer, java.lang.Thread> r2 = r6.f2258a     // Catch:{ all -> 0x0058 }
            r2.put(r0, r7)     // Catch:{ all -> 0x0058 }
        L_0x0056:
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            return
        L_0x0058:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            throw r7
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1078n.mo9440a(java.lang.Object):void");
    }

    /* renamed from: b */
    public void mo9441b(Object obj) {
        if (((Boolean) this.f2260c.mo9350a(C0965b.f1747dO)).booleanValue() && obj != null) {
            Integer valueOf = Integer.valueOf(System.identityHashCode(obj));
            synchronized (this.f2259b) {
                Thread thread = this.f2258a.get(valueOf);
                if (thread != null) {
                    C1107r z = this.f2260c.mo9411z();
                    z.mo9584b("AppLovinSdk", "Destroying ad debug thread with name: " + thread.getName());
                    thread.interrupt();
                    this.f2258a.remove(valueOf);
                }
            }
        }
    }
}
